package org.esupportail.data.sirene.client.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.esupportail.data.sirene.client.dto.CodeNaf;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class ChargeurCodeNafJson {

	private List<CodeNaf> listCodeNaf;

	public ChargeurCodeNafJson() {
		byte[] jsonData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonData = Files.readAllBytes(Paths.get("code_int_courts_naf_rev_2.json"));

			// System.out.println(jsonData[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			listCodeNaf = objectMapper.readValue(jsonData, new TypeReference<List<CodeNaf>>() {
			});
			// System.out.println(listCodeNaf.get(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<CodeNaf> getListCodeNaf() {
		return listCodeNaf;
	}

	public void setListCodeNaf(List<CodeNaf> listCodeNaf) {
		this.listCodeNaf = listCodeNaf;
	}
	
	public CodeNaf findCodeNafByCode(String code) {
		//System.out.println(listCodeNaf+"+++++++++++++++++++++++++++++");
		CodeNaf cn=null;
		for (CodeNaf codeNaf : listCodeNaf) {
			if (codeNaf.getCode().equalsIgnoreCase(code)){
				//System.out.println(codeNaf.getCode()+"+++++++++++++++++++++++++++++");
				return codeNaf;
			}
		}
		return cn;
		
	}

}
