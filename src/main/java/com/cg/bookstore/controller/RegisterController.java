package com.cg.bookstore.controller;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Register;
import com.cg.bookstore.repository.IRegisterRepo;
import com.cg.bookstore.serviceImplementation.RegisterService;

@RestController
@RequestMapping("/BookManagement")
@CrossOrigin
public class RegisterController {

	 @Autowired
	 IRegisterRepo iRegisterRepo;
	 @Autowired
	 RegisterService registerService;
	
	 @PostMapping(path="/addRegisterer")
	  public String createRegisterer(@Valid @RequestBody Register register)
	  {
		  iRegisterRepo.save(register);
		  return "Register Added"; 
	  }
	 
	 @GetMapping(path="/login")
	  public ResponseEntity<List<Register>> login()
	  {
		   return new ResponseEntity<List<Register>>(iRegisterRepo.findAll(),HttpStatus.OK);
	  }
	 

}
