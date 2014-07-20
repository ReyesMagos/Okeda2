package co.gov.fna.okeda.process.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.gov.fna.okeda.modelo.entidades.Vivienda;

import android.test.AndroidTestCase;

public class ViviendaProcessImplTest extends AndroidTestCase {
	
	private ViviendaProcessImpl viviendaProcessImpl;

	public ViviendaProcessImplTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveVivienda() {
		Vivienda vivienda = new Vivienda("ADSD345");
		this.viviendaProcessImpl = new ViviendaProcessImpl(getContext());
		
		try {
			assertNotNull(this.viviendaProcessImpl.saveVivienda(vivienda));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testUpdateVivienda() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllViviendas() {
		fail("Not yet implemented");
	}

}
