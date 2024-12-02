package org.esupportail.referentiel.sirene.client.service;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.esupportail.referentiel.sirene.client.dto.CategorieJuridique;
import org.esupportail.referentiel.sirene.client.dto.SimpleCodeNaf;
import org.springframework.stereotype.Service;

@Service
public class SqliteService {

	URL url = SqliteService.class.getResource("/");
	String path = url.getPath();
	
	String urlConnection="jdbc:sqlite:" + path + "/metadata.db";

	public List<CategorieJuridique> findStatutJuridique(String code) {

		List<CategorieJuridique> categorieJuridiques = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(urlConnection);
				PreparedStatement pstmt = connection
						.prepareStatement("SELECT Code, Libelle FROM categories_juridiques_3 where Code = ?")) {
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				categorieJuridiques.add(new CategorieJuridique(rs.getString("Code"), rs.getString("Libelle")));
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);
		}

		return categorieJuridiques;

	}

	public List<SimpleCodeNaf> findSimpleCodeNaf(String code) {

		List<SimpleCodeNaf> simpleCodeNafs = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(urlConnection);
				PreparedStatement pstmt = connection.prepareStatement(
						"SELECT ID, CODE,INTITULE, INTITULE_COURT, INTITULE_COURT_C FROM code_naf where Code = ?")) {
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				simpleCodeNafs.add(new SimpleCodeNaf(rs.getInt("ID"), rs.getString("CODE"), rs.getString("INTITULE"),
						rs.getString("INTITULE_COURT"), rs.getString("INTITULE_COURT_C")));
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);
		}

		return simpleCodeNafs;

	}

}
