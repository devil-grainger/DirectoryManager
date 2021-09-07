package oracle.java.erpsol.com.kube.directory.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import oracle.java.erpsol.com.kube.directory.model.Addressbook;
import oracle.java.erpsol.com.kube.directory.repository.AddressbookRepository;

@RestController
@RequestMapping("/api/")
public class AddressRESTController {

	@Autowired
	AddressbookRepository addBookRepo;

	@GetMapping("/getallcontacts")
	public List<Addressbook> getAllContacts() {
		return addBookRepo.findAll();
	}

	@GetMapping("/contact/{id}")
	public Addressbook retrieveAddressbook(@PathVariable String id) {
		Optional<Addressbook> student = addBookRepo.findById(id);
		if (!student.isPresent())
			throw new AddressBookNotFoundException("id-" + id);
		return student.get();
	}

	@DeleteMapping("/contact/{id}")
	public void deleteAddressbook(@PathVariable String id) {
		addBookRepo.deleteById(id);
	}

	@PostMapping("/contact")
	public ResponseEntity<Object> createAddressbook(@RequestBody Addressbook student) {
		Addressbook savedAddressbook = addBookRepo.save(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAddressbook.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/contact/{id}")
	public ResponseEntity<Object> updateAddressbook(@RequestBody Addressbook student, @PathVariable String id) {
		Optional<Addressbook> studentOptional = addBookRepo.findById(id);
		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();
		student.setId(id);
		addBookRepo.save(student);
		return ResponseEntity.noContent().build();
	}

}