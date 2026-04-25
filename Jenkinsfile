pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                echo '📦 Clonando repositorio...'
                checkout scm
            }
        }
        
        stage('Compile') {
            steps {
                echo '🔨 Compilando proyecto...'
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo '🧪 Ejecutando tests...'
                sh 'mvn test'
            }
            post {
                always {
                    // Publicar reporte de tests
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        
        stage('Coverage Report') {
            steps {
                echo '📊 Generando reporte de cobertura...'
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    // Publicar reporte JaCoCo
                    publishHTML([
                        reportDir: 'target/site/jacoco',
                        reportFiles: 'index.html',
                        reportName: 'JaCoCo Coverage Report'
                    ])
                }
            }
        }
        
        stage('Static Analysis') {
            steps {
                echo '🔍 Ejecutando análisis estático...'
                sh 'mvn checkstyle:checkstyle pmd:pmd spotbugs:check || true'
            }
            post {
                always {
                    // Publicar reportes de análisis estático
                    publishHTML([
                        reportDir: 'target/site',
                        reportFiles: 'checkstyle.html, pmd.html, spotbugs.html',
                        reportName: 'Static Analysis Reports'
                    ])
                }
            }
        }
        
        stage('Generate Site') {
            steps {
                echo '🌐 Generando sitio Maven...'
                sh 'mvn site -Ddependency-check.skip=true || true'
            }
            post {
                always {
                    publishHTML([
                        reportDir: 'target/site',
                        reportFiles: 'index.html',
                        reportName: 'Maven Site'
                    ])
                }
            }
        }
        
        stage('Generate Javadoc') {
            steps {
                echo '📚 Generando JavaDoc...'
                sh 'mvn javadoc:javadoc || true'
            }
            post {
                always {
                    publishHTML([
                        reportDir: 'target/site/apidocs',
                        reportFiles: 'index.html',
                        reportName: 'Javadoc API'
                    ])
                }
            }
        }
        
        stage('Package') {
            steps {
                echo '📦 Empaquetando JAR...'
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }
    
    post {
        success {
            echo '✅ BUILD EXITOSO'
            echo '📊 Reportes generados:'
            echo '  - Cobertura: target/site/jacoco/index.html'
            echo '  - Checkstyle: target/site/checkstyle.html'
            echo '  - PMD: target/site/pmd.html'
            echo '  - Spotbugs: target/site/spotbugs.html'
            echo '  - JavaDoc: target/site/apidocs/index.html'
        }
        failure {
            echo '❌ BUILD FALLIDO'
            echo 'Revisa los logs para más detalles'
        }
        always {
            echo '🏁 Pipeline finalizado'
        }
    }
}
