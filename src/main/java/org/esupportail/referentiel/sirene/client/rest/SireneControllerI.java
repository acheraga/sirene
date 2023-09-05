package org.esupportail.referentiel.sirene.client.rest;

import java.util.List;

import org.esupportail.referentiel.sirene.client.dto.StructureFormDto;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;

public interface SireneControllerI {
	
	@Operation(summary = "Exemple  dis Bonjour")
	public ResponseEntity<StructureFormDto> findBySiret(String siret);

	ResponseEntity<List<StructureFormDto>> findByMotCleCodePostal(String cp, String motcle);

	
}
