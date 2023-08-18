package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;


@RestController
public class MyController {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService service;

	@RequestMapping("/save")
	String AddUser (@Valid @RequestBody User user)
	{
		String result=service.save(user);
		return result;
	}

}
