package com.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.lab2.dao.PlayerRepository;

@RestController
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping(path = "/test")
	public String test() {
		return "testing";
	}

}
