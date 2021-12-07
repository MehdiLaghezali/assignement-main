package ma.octo.assignement.mapper;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.dto.CompteDto;

public class CompteMapper {

    private static CompteDto compteDto;

    public static CompteDto map(Compte compte) {
    	compteDto = new CompteDto();
    	compteDto.setUtilisateur(compte.getUtilisateur());
    	compteDto.setRib(compte.getRib());
    	compteDto.setSolde(compte.getSolde());

        return compteDto;

    }
}
