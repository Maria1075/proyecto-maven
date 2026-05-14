# Proyecto Maven - SotoZapataMariaCamilaMP2025

[![Maven Build](https://github.com/Maria1075/proyecto-maven/actions/workflows/maven-build.yml/badge.svg)](https://github.com/Maria1075/proyecto-maven/actions/workflows/maven-build.yml)
[![Java Version](https://img.shields.io/badge/Java-21-blue.svg)](https://adoptium.net/)
[![Maven](https://img.shields.io/badge/Maven-3.9.0-red.svg)](https://maven.apache.org/)
[![Jenkins](https://img.shields.io/badge/Jenkins-CI-blue?logo=jenkins)](http://20.127.236.41:8080)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## 📋 Descripción

Proyecto Maven para prácticas de **Integración Continua** con Jenkins, GitHub Actions y pruebas de aceptación con Selenium.

**Autor:** María Camila Soto Zapata

## 🛠️ Tecnologías y Herramientas

| Herramienta | Versión | Uso |
|-------------|---------|-----|
| Java | 21 | Lenguaje de programación |
| Maven | 3.9.0 | Gestión de dependencias y build |
| JUnit | 5.11.3 | Pruebas unitarias |
| JaCoCo | 0.8.12 | Cobertura de código |
| Checkstyle | 3.6.0 | Estilo de código |
| PMD | 3.21.0 | Análisis estático |
| Spotbugs | 4.8.6.0 | Búsqueda de bugs |
| Selenium WebDriver | 4.21.0 | Pruebas de aceptación / Cross-browser |
| Jenkins | - | CI/CD (VM Azure) |
| GitHub Actions | - | CI/CD automático |

## 📊 Estado del Build

El badge de arriba muestra el estado del último build en **GitHub Actions**.

| Pipeline | Estado |
|----------|--------|
| GitHub Actions | [![Maven Build](https://github.com/Maria1075/proyecto-maven/actions/workflows/maven-build.yml/badge.svg)](https://github.com/Maria1075/proyecto-maven/actions/workflows/maven-build.yml) |
| Jenkins (Maven) | [![Jenkins](https://img.shields.io/badge/Jenkins-Maven-blue?logo=jenkins)](http://20.127.236.41:8080/job/ej07-maven-msz016/) |
| Jenkins (Pipeline) | [![Jenkins](https://img.shields.io/badge/Jenkins-Pipeline-blue?logo=jenkins)](http://20.127.236.41:8080/job/ej07-pipeline-msz016/) |
| Jenkins (Selenium) | [![Jenkins](https://img.shields.io/badge/Jenkins-Selenium-blue?logo=jenkins)](http://20.127.236.41:8080/job/selenium-tests-msz016/) |

## 🚀 Comandos útiles

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar tests unitarios
mvn test

# Generar reporte de cobertura
mvn jacoco:report

# Generar sitio con todos los reportes (sin OWASP)
mvn site -Ddependency-check.skip=true

# Empaquetar JAR
mvn package

# Limpiar todo
mvn clean
