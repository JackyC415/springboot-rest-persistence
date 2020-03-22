package com.cmpe275.lab2.dao;

import org.springframework.data.repository.CrudRepository;

import com.cmpe275.lab2.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	
}
