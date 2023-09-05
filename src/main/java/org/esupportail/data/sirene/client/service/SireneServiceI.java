package org.esupportail.data.sirene.client.service;

import java.util.List;

import org.esupportail.data.sirene.client.dto.StructureFormDto;

public interface SireneServiceI {
	
	
	public StructureFormDto findBySiret(String siret) ;
	
	public List<StructureFormDto> findByMotcleCp(String cp, String motcle);
}
