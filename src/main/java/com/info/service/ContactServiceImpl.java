package com.info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.binding.Contact;
import com.info.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository repo;
	
	//-------------------------------------------------
	
	public String saveContact(Contact contact) {
		
	    contact=repo.save(contact);
	    
	    if(contact.getContactId() != null)
	    {
	    	return "Contact saved ..!!";
	    }else {
	    	 return "Contact Failed To Save..!";
	    }
	 }
    //---------------------------------------------------
	
	public List<Contact> getAllContact() {
		
		return repo.findAll();
	}
	
	//----------------------------------------------

	
	public Contact getContactById(Integer contactId) {
		
		Optional<Contact> findById=repo.findById(contactId);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	//-----------------------------------------------------

	
	public String updateContact(Contact contact) {
		
		if(repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "Update Successfully";
		}else {
			return "No record found";
		}
	}
	//------------------------------------------------------

	
	public String deleteContactById(Integer contactId) {
		
		if(repo.existsById(contactId))
		{
			repo.deleteById(contactId);
			return "delete Record..!!";
		}else {
			return "No Record Found..!";
		}
	}

}
