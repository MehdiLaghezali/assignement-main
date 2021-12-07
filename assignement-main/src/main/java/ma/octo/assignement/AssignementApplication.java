package ma.octo.assignement;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.mapper.CompteMapper;
import ma.octo.assignement.repository.CompteRepository;
import ma.octo.assignement.repository.UtilisateurRepository;
import ma.octo.assignement.repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AssignementApplication<T> implements CommandLineRunner {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private VirementRepository virementRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AssignementApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setUsername("user1");
		utilisateur1.setLastname("last1");
		utilisateur1.setFirstname("first1");
		utilisateur1.setGender("Male");

		utilisateurRepository.save(utilisateur1);


		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setUsername("user2");
		utilisateur2.setLastname("last2");
		utilisateur2.setFirstname("first2");
		utilisateur2.setGender("Female");

		utilisateurRepository.save(utilisateur2);

		Compte compte1 = new Compte();
		compte1.setNrCompte("010000A000001000");
		compte1.setRib("RIB1");
		compte1.setSolde(BigDecimal.valueOf(200000L));
		compte1.setUtilisateur(utilisateur1);

		compteRepository.save(compte1);

		Compte compte2 = new Compte();
		compte2.setNrCompte("010000B025001000");
		compte2.setRib("RIB2");
		compte2.setSolde(BigDecimal.valueOf(140000L));
		compte2.setUtilisateur(utilisateur2);

		compteRepository.save(compte2);

		Virement v = new Virement();
		v.setMontantVirement(BigDecimal.TEN);
		v.setCompteBeneficiaire(compte2);
		v.setCompteEmetteur(compte1);
		v.setDateExecution(new Date());
		v.setMotifVirement("Assignment 2021");

		virementRepository.save(v);
		
		
		BigDecimal b =new BigDecimal(1000);
		Versement vers =new Versement();
        System.out.println("Versement : ");

        vers.setMontantVirement(b);
        System.out.println(vers.getMontantVirement()+"\n");

        vers.setDateExecution(new Date(6-12-2021));
        System.out.println(vers.getDateExecution()+"\n");

        vers.setCompteBeneficiaire(compte2);
        System.out.println(vers.getCompteBeneficiaire().getNrCompte()+"\n");

        vers.setMotifVersement("test");
        System.out.println(vers.getMotifVersement()+"\n");

        vers.setNom_prenom_emetteur(utilisateur1.getFirstname()+" "+utilisateur1.getLastname());
        System.out.println(vers.getNom_prenom_emetteur()+"\n");
        
        
        //Mise a jour du solde du client
		 String sql = "UPDATE Compte SET Solde=Solde+? WHERE Rib=?";
		 int result = jdbcTemplate.update(sql,b,compte2.getRib());
		 
		 if(result>0) {
			 System.out.println("Versement effectué");
		 }
		
		
       
	}
}
