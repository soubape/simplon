package net.stc.management;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.stc.management.model.Administrateur;
import net.stc.management.repository.AdministrateurRepository;
import net.stc.management.services.impl.AdministrateurServicesImpl;

@SpringBootTest
class StcManagementV2ApplicationTests {
	
	@Autowired
	private AdministrateurRepository admrepo;
	
	@Autowired
	private AdministrateurServicesImpl administrateurServicesImpl;

	@Test
	void contextLoads() {
//		Administrateur admin = new Administrateur();
//		admin.setName("Soubape");
//		admin.setUsername("Soubape123");
//		admin.setEmail("soubape@gmail.com");
//		admin.setPassword("soubape123");
//		admin.setTelephone("06383634939");
//		admrepo.save(admin);
	}
	
	
	@Test
	void Listerall() {
		List<Administrateur> admin = admrepo.findAll();
		System.out.println("administrateur :" + admin);

	}

//	@Test
//	void Delete() {
//		administrateurServicesImpl.delete(1L);
//		System.out.println("suppressiin reussie");
//	}
	
	@Test
	void Upadte() {
		Administrateur admin = new Administrateur();
		admin.setEmail("anas@gmail.com");
		admin.setName("Anas");
		admin.setPassword("anas2000");
		admin.setTelephone("0635282923");
		admin.setUsername("anas123");
		
		administrateurServicesImpl.update(admin, 5L);
		System.out.println("Modification reussie");
	}
	
	@Test
	void findByID() {
		admrepo.findById(2L);
	}
	

}
