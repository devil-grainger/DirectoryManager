package oracle.java.erpsol.com.kube.directory.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.java.erpsol.com.kube.directory.model.Addressbook;
import oracle.java.erpsol.com.kube.directory.repository.AddressbookRepository;

@Controller
public class AddressController {

	@Autowired
	AddressbookRepository addBookRepo;
	
	@GetMapping("/")
	public String showList(Model model, @RequestParam (defaultValue="0") int page) {
		model.addAttribute("data", addBookRepo.findAll( PageRequest.of(page, 5, Sort.by(
			    Order.asc("id")))));
		model.addAttribute("currentPage", page);
		return "index";
	}
	
	@GetMapping("/list")
	public String showTheList(Model model, @RequestParam (defaultValue="0") int page) {
		model.addAttribute("data", addBookRepo.findAll( PageRequest.of(page, 5, Sort.by(
			    Order.asc("id")))));
		model.addAttribute("currentPage", page);
		return "index2";
	}
	
	@GetMapping("/list3")
	public String showTheList3(Model model) {
		model.addAttribute("contacts", addBookRepo.findAll());
		return "index3";
	}
	
	@RequestMapping("/contact/{id}") 
	public String getContact (@PathVariable ("id") String id, Model model ) {
		
		Optional<Addressbook> contact = addBookRepo.findById(id);
		model.addAttribute("contact" , contact);
		return "index3 :: modalContents";
	}
	
	@PostMapping("/save") 
	public String saveAddBook (Addressbook ab) {
		addBookRepo.save(ab);
		return "redirect:/";
	}
	
	@PostMapping("/save2") 
	public String saveAddBook2 (Addressbook ab) {
		addBookRepo.save(ab);
		return "redirect:/list";
	}
	
	
	@GetMapping("/delete") 
	public String deleteAddBook (String id) {
		addBookRepo.deleteById(id);
	
		return "redirect:/";
	}
	
	@GetMapping("/findOne") 
	@ResponseBody
	public Optional<Addressbook> findOne (String id) {
		return addBookRepo.findById(id);
	}
	
}