package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Register;

@Repository
public interface IRegisterRepo extends JpaRepository<Register,String>{

}
