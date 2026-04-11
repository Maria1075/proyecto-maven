package org.mp.sesion09.residencias.dao;

import java.io.File;
import org.mp.sesion09.residencias.dao.DataAccessObject;
import org.mp.sesion09.residencias.dao.ResidenciaDAOFactory;

public class ResidenciaJSONTest extends AbstractResidenciaDAOTest{
	@Override
	public DataAccessObject makeDataAccessObject() {
		String directorioEntrada = System.getProperty("user.dir");
			String archivoDatos = directorioEntrada + File.separator 
				+ "src" + File.separator 
				+ "test" + File.separator 
				+ "java" + File.separator 
				+ "org" + File.separator 
				+ "mp" + File.separator 
				+ "sesion09" + File.separator
				+ "residencias" + File.separator
				+ "dao" + File.separator
				+ "residencia.json";
		return ResidenciaDAOFactory.createResidenciaDAOFactory(archivoDatos, "json");
	}
}
