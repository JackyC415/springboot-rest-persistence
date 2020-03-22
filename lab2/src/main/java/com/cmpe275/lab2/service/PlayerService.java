package com.cmpe275.lab2.service;

import com.cmpe275.lab2.model.Player;

/*
 * Interface to define necessary Player CRUD operations
 * */
public interface PlayerService {
	
	Player createPlayer();
	Player updatePlayer();
	Player getPlayer();
	Player deletePlayer();

}
