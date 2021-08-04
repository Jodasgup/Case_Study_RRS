package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;


@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactRepository contactrepository;
	
	@PostMapping("/addContact")
	public String saveBook(@RequestBody Contact contact) {
    contactrepository.save(contact);
	return "Added contact with id :  " + contact.getId();
}
	
	@GetMapping("/findAllContacts")
	public List<Contact> getContacts(){
		return contactrepository.findAll();
		
	}
	@GetMapping("/findAllContacts/{id}")
	public Optional<Contact> getContact(@PathVariable String id){
		return contactrepository.findById(id);
	}
	
	 @DeleteMapping("/delcontact/{id}")
		public String deleteContact (@PathVariable String id) {
			contactrepository.deleteById(id);
			return "Contact deleted with id : "+id;
		}
	}

