package com.cg.bookstore.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Register;
import com.cg.bookstore.repository.IRegisterRepo;

@Service
public class RegisterService {

	@Autowired
	 IRegisterRepo iRegisterRepo;
	
//	public List<Register> login()
//	{
//	
//		List<Register> register=iRegisterRepo.findAll();
//		String emailID="";
//		for(Register r:register)
//		{
//			if(r.getEmail().equals(email)&&r.getPassword().equals(password))
//				{
//				return iRegisterRepo.findAll();
//				}
//			
//		}
//		return iRegisterRepo.findAll();
//	}
}
