package org.esupportail.data.sirene.client.rest;

import java.util.List;

import org.esupportail.data.sirene.client.dto.StructureFormDto;
import org.esupportail.data.sirene.client.service.SireneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sirene")
public class SireneController implements SireneControllerI {

	@Autowired
	private SireneService sireneService;

	public SireneService getSireneService() {
		return sireneService;
	}

	public void setSireneService(SireneService dossierAgentService) {
		this.sireneService = dossierAgentService;
	}

	@Override
	@GetMapping("/findBySiret")
	public ResponseEntity<StructureFormDto> findBySiret(
			@RequestParam(value = "siret", required = true, defaultValue = "19921204400010") String siret) {
		StructureFormDto result = sireneService.findBySiret(siret);
		if (result != null)
			return new ResponseEntity<StructureFormDto>(result, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	@Override
	@GetMapping("/findByMotCleCodePostal")
	public ResponseEntity<List<StructureFormDto>> findByMotCleCodePostal(String cp, String motcle) {
		System.out.println("++++++++++++++++++++++------------------------------");
		List<StructureFormDto> result = sireneService.findByMotcleCp(cp,motcle);
		if (result != null)
			return new ResponseEntity<List<StructureFormDto>>(result, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

}
