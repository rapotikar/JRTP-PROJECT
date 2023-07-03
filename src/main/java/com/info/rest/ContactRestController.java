package com.info.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.binding.Contact;
import com.info.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	private ContactService service;
	
	//-----------------------------------------------------------
	
	// POST => http://localhost:9090/contact
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact)
	{
	   String status = service.saveContact(contact);
		
	   return status;
	
	}
	//------------------------------------------
	
	// GET => http://localhost:9090/contacts
	@GetMapping("/contacts")
	public List<Contact>  getAllContacts()
	{
		return service.getAllContact();
	}
	
	//------------------------------------------
	
	// GET => http://localhost:9090:contact/12
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId)
	{
		return service.getContactById(contactId);
	}
	
	//--------------------------------------------
	
	// PUT => http://localhost:9090/contact
	@PutMapping("/contact")
     public String updateContact(@RequestBody Contact contact)
     {
    	 return service.updateContact(contact);
     }
	
	//-------------------------------------------
	
	// DELETE => http://localhost:9090/contact/101
	@DeleteMapping("/contact/{contactId}")
	 public String deleteContact(@PathVariable Integer contactId)
	 {
		 return service.deleteContactById(contactId);
	 }
	
	//--------------------------------------------
	
	
	
}
