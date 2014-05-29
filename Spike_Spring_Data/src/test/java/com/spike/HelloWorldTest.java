package com.spike;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.sql.MetaDataExporter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/config.xml" })
public class HelloWorldTest {

	@Autowired
	HelloWorld helloWorld;

	@Autowired
	DataSource dataSource;

	@Before
	public void setUp() throws SQLException {
		/*Connection conn = dataSource.getConnection();
		MetaDataExporter exporter = new MetaDataExporter();
		exporter.setPackageName("com.spike.model");
		exporter.setTargetFolder(new File("src/main/java"));
		exporter.export(conn.getMetaData());*/
	}

	@Test
	public void testMessage() {
		System.out.println(helloWorld.getMessage());
	}

}
