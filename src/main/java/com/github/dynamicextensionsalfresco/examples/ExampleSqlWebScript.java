package com.github.dynamicextensionsalfresco.examples;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.github.dynamicextensionsalfresco.webscripts.annotations.Uri;
import com.github.dynamicextensionsalfresco.webscripts.annotations.WebScript;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.springframework.stereotype.Component;

/**
 * Web Script that illustrates access to the repository database using SQL.
 * 
 * @author Laurens Fridael
 * 
 */
@Component
@WebScript
public class ExampleSqlWebScript {

	@Autowired
	private DataSource dataSource;

	@Uri("/dynamic-extensions/examples/sql")
	public void selectCountNodes(final WebScriptResponse response) throws IOException, SQLException {
		final Writer out = response.getWriter();
		final Connection connection = dataSource.getConnection();
		try {
			final Statement stmt = connection.createStatement();
			final ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM alf_node");
			if (rs.next()) {
				final int count = rs.getInt(1);
				out.write(String.format("Number of alf_node records: %d", count));
			}
			rs.close();
		} finally {
			out.close();
			connection.close();
		}
	}

}
