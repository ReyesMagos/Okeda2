package co.gov.fna.okeda.persistence.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.gov.fna.okeda.persistence.sqlite.contract.ViviendaContract;

import android.content.ContentValues;
import android.test.AndroidTestCase;

public class ViviendaDAOImplTest extends AndroidTestCase{
	
	private ViviendaDAOImpl viviendaDAOImpl;

	public ViviendaDAOImplTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		this.viviendaDAOImpl = ViviendaDAOImpl.getInstance(getContext());
		try {
			ContentValues contentValues = new ContentValues();
			contentValues.put(ViviendaContract.Column.PARTITION_KEY, "1234dfskldj");
			assertNotNull(this.viviendaDAOImpl.save(contentValues));
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
