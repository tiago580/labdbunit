package com.tiago.agenda;

import java.io.FileInputStream;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import junit.framework.TestCase;

import com.tiago.agenda.dao.UsuarioDAO;

public class AgendaTest extends TestCase {
	private IDatabaseTester databaseTester;

	@Override
	protected void setUp() throws Exception {
		databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
				"jdbc:mysql://192.168.1.24/agenda", "root", "root");
		IDataSet dataSet = getDataSet("user.xml");
		databaseTester.setDataSet(dataSet);
		databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
		databaseTester.onSetup();
		super.setUp();

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		databaseTester.onTearDown();
		super.tearDown();
	}

	public void testLoginUser() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean isUserLogin = usuarioDAO.isUserLogin("tiago580");
		assertTrue("Login existe", isUserLogin);
	}

	protected IDataSet getDataSet(String fileName) throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream(fileName));
	}

}
