package siham;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.esupportail.data.sirene.client.dto.CodeNaf;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLoaderTest {

	@Test
	public void testLoderV2() {
		byte[] jsonData=null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonData = Files.readAllBytes(Paths.get("code_int_courts_naf_rev_2.json"));
			
			System.out.println(jsonData[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			List<CodeNaf> emp = objectMapper.readValue(jsonData, new TypeReference<List<CodeNaf>>(){});
			emp.forEach(e->{
				System.out.println(e.getIntitulSDeLaNAFRV2VersionFinale());
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//@Test
	public void testLoader() {
		List<CodeNaf> listPropre = new ArrayList<>();
		Pattern p = Pattern.compile("^[0-9]{2}");

		try {
			byte[] jsonData = Files.readAllBytes(Paths.get("csvjson.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			System.out.println(jsonData[0]);

			CodeNaf[] emp = objectMapper.readValue(jsonData, CodeNaf[].class);

			List<CodeNaf> codes = Arrays.asList(emp);
			codes.forEach(e -> {
				if (e.getCode() != null) {

					Matcher m = p.matcher(e.getCode());
					if (m.find()) {
						listPropre.add(e);
					}
				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listPropre.forEach(e -> {
			System.out.println(e);
	
		});
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(listPropre);
			System.out.println(json);
			Files.write(Paths.get("code_int_courts_naf_rev_2.json"),
					json.getBytes(StandardCharsets.UTF_8));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
