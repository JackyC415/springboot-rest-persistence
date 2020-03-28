package com.cmpe275.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.lab2.dao.PlayerRepository;
import com.cmpe275.lab2.model.Player;

/*
 * Actual implementation of Player CRUD operations
 * */
@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerDao;
	
	@Override
	public Player createPlayer(Player player, String sponsorName) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Player updatePlayer(Player player, String sponsorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player deletePlayer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
