package org.esupportail.data.sirene.client.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.esupportail.data.sirene.client.dto.CodeNaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ChargeurCodeNafJson {

	final private transient Logger logger = LoggerFactory.getLogger(this.getClass());

	private List<CodeNaf> listCodeNaf;

	/**
	 * 
	 */
	public ChargeurCodeNafJson() {
		byte[] jsonData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonData = Files.readAllBytes(Paths.get("code_int_courts_naf_rev_2.json"));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		try {
			listCodeNaf = objectMapper.readValue(jsonData, new TypeReference<List<CodeNaf>>() {
			});

		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}
	/**
	 * 
	 * @param code
	 * @return
	 */
	public CodeNaf findCodeNafByCode(String code) {

		CodeNaf cn = null;
		for (CodeNaf codeNaf : listCodeNaf) {
			if (codeNaf.getCode().equalsIgnoreCase(code)) {
				return codeNaf;
			}
		}
		return cn;

	}

	public List<CodeNaf> getListCodeNaf() {
		return listCodeNaf;
	}

	public void setListCodeNaf(List<CodeNaf> listCodeNaf) {
		this.listCodeNaf = listCodeNaf;
	}

}
