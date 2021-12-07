package ma.octo.assignement.dto;

import java.math.BigDecimal;
import java.util.Date;

import ma.octo.assignement.domain.Utilisateur;

public class CompteDto {
  private String nrCompte;
  private String rib;
  private Utilisateur utilisateur;
  private BigDecimal solde;
public String getNrCompte() {
	return nrCompte;
}
public void setNrCompte(String nrCompte) {
	this.nrCompte = nrCompte;
}
public String getRib() {
	return rib;
}
public void setRib(String rib) {
	this.rib = rib;
}
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public BigDecimal getSolde() {
	return solde;
}
public void setSolde(BigDecimal solde) {
	this.solde = solde;
}


}
