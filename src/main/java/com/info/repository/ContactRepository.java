package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer >{

}
