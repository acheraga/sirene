package org.esupportail.data.sirene.client.utils;

import java.util.HashMap;
import java.util.Map;

public final class TrancheEffectif {

	private final static Map<String, String> effectifMap = new HashMap<>();

	public static Map<String, String> getEfftifMap() {
		effectifMap.put("NN",
				"Etablissement non employeur (pas de salarié au cours de l'année de référence et pas d'effectif au 31/12)");
		effectifMap.put("00",
				"0 salarié (n'ayant pas d'effectif au 31/12 mais ayant employé des salariés au cours de l'année de référence)");
		effectifMap.put("01", "1 ou 2 salariés");
		effectifMap.put("02", "3 à 5 salariés");
		effectifMap.put("03", "6 à 9 salariés");
		effectifMap.put("11", "10 à 19 salariés");
		effectifMap.put("12", "20 à 49 salariés");
		effectifMap.put("21", "50 à 99 salariés");
		effectifMap.put("22", "100 à 199 salariés");
		effectifMap.put("31", "200 à 249 salariés");
		effectifMap.put("32", "250 à 499 salariés");
		effectifMap.put("41", "500 à 999 salariés");
		effectifMap.put("42", "1 000 à 1 999 salariés");
		effectifMap.put("51", "2 000 à 4 999 salariés");
		effectifMap.put("52", "5 000 à 9 999 salariés");
		effectifMap.put("53", "10 000 salariés et plus");

		return effectifMap;

	}

	private TrancheEffectif() {
	}

}
