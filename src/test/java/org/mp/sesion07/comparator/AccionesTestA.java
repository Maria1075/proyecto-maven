package org.mp.sesion07.comparator;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class AccionesTestA {

	private Acciones acciones;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		acciones = new Acciones();
		acciones.add(new Accion("AMADEUS",1919654));
		acciones.add(new Accion("GAMESA",3692344));
		acciones.add(new Accion("FERROVIAL",3084953));
		acciones.add(new Accion("ENDESA",838209));
		acciones.add(new Accion("ABENGOA",12900));
	}

	@Test
	public void testOrdenarAccionesSort() {
		List<Accion> lista = acciones.getAcciones();
		Collections.sort(lista);
		
		for (int i = 0; i < lista.size()-1; i++) {
			Accion accion0 = (Accion) lista.get(i);
			Accion accion1 = (Accion) lista.get(i+1);
			assertTrue(accion0.compareTo(accion1) < 0);
		}
	}
	
	@Test
	public void testOrdenarAccionesSortAccionesVolumenComparator() {
		
		List<Accion> lista = acciones.getAcciones();
		Collections.sort(lista, new VolumenComparator());
		for (int i = 0; i < lista.size()-1; i++) {
			Accion accion0 = (Accion) lista.get(i);
			Accion accion1 = (Accion) lista.get(i+1);
			assertTrue(accion0.getVolumen()<=accion1.getVolumen());
		}
	}
	
	@Test
	public void testOrdenarAccionesSortReverseOrder() {
		List<Accion> lista = acciones.getAcciones();
		Collections.sort(lista, java.util.Collections.reverseOrder());
		
		for (int i = 0; i < lista.size()-1; i++) {
			Accion accion0 = (Accion) lista.get(i);
			Accion accion1 = (Accion) lista.get(i+1);
			assertTrue(accion0.compareTo(accion1) > 0);
		}
	}
	
	@Test
	public void testOrdenarAccionesSortAccionesVolumenComparatorReverseOrder() {
		
		List<Accion> lista = acciones.getAcciones();
		Collections.sort(lista, Collections.reverseOrder(new VolumenComparator()));
		for (int i = 0; i < lista.size()-1; i++) {
			Accion accion0 = (Accion) lista.get(i);
			Accion accion1 = (Accion) lista.get(i+1);
			assertTrue(accion0.getVolumen()>=accion1.getVolumen());
		}
	}
}
