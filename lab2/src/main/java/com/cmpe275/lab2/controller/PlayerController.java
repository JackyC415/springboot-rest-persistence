package com.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmpe275.lab2.dao.PlayerRepository;
import com.cmpe275.lab2.model.Player;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping(path="/test")
	  public @ResponseBody Iterable<Player> getAllUsers() {
	    return playerRepository.findAll();
	  }
	
}
