package fr.upn.dri.espacnum.sirene;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Map;

import org.esupportail.referentiel.sirene.client.utils.Pays;

public class Sample {
	public  void main(String[] args) {
		// NOTE: Connection and Statement are AutoCloseable.
		// Don't forget to close them both in order to avoid leaks.

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL path = classLoader.getResource("");

		try {
			Enumeration<URL> urls = classLoader.getResources("");
			while (urls.hasMoreElements()) {
				System.out.println(urls.nextElement());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Sample.class.getResource("/"));
		try (
				// create a database connection
				Connection connection = DriverManager.getConnection(
						"jdbc:sqlite:/home/abdelhamid/Documents/workspace/esup-siscol-ws/sirene/src/main/resources/metadata.db");
				Statement statement = connection.createStatement();) {
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			ResultSet rs = statement.executeQuery("SELECT Code, Libelle FROM categories_juridiques_1");
			while (rs.next()) {
				// read the result set
				System.out.println(rs.getString("Code") + " : " + rs.getString("Libelle"));

			}
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			e.printStackTrace(System.err);
		}
		
	}

	public  void tablePays() {
		Pays pays = new Pays();
		Map<Integer, String> paysmaps = pays.getPaysMap();
		paysmaps.forEach((k, v) -> {

			String request = "INSERT INTO pays_stage (CODE, INTITULE) VALUES(?, ?)";
			// create a database connection
			Connection connection;
			try {
				connection = DriverManager.getConnection(
						"jdbc:sqlite:/home/abdelhamid/Documents/workspace/esup-siscol-ws/sirene/src/main/resources/metadata.db");
				PreparedStatement pstmt = connection.prepareStatement(request);
				pstmt.setInt(1, k);
				pstmt.setString(2, v);
				int rowsInserted = pstmt.executeUpdate();
				System.out.println(rowsInserted + " rows inserted.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(String.format(request, k, v));
		});

	}
}