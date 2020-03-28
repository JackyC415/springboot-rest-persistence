package com.cmpe275.lab2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.lab2.dao.PlayerRepository;
import com.cmpe275.lab2.dao.SponsorRepository;
import com.cmpe275.lab2.errors.AlreadyExistsException;
import com.cmpe275.lab2.model.Player;
import com.cmpe275.lab2.model.Sponsor;

/*
 * Actual implementation of Player CRUD operations
 * */
@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerDao;
	
	@Autowired
	private SponsorRepository sponsorDao;
	
	@Override
	public Player createPlayer(Player player, String sponsorName) {
		try {
			Player existingPlayer = playerDao.findByEmail(player.getEmail());
			if (existingPlayer != null) {
				throw new AlreadyExistsException("Player with given Id already present");
			} else {
				Player newPlayer = new Player(player.getFirstname(), player.getLastname(), player.getEmail());
				newPlayer.setDescription(player.getDescription());
				newPlayer.setAddress(player.getAddress());
				if(sponsorName.length()!=0) {
					Optional<Sponsor> sponsorResult = sponsorDao.findById(sponsorName);
					Sponsor existingSponsor = sponsorResult.get();
					if(existingSponsor != null) {
						newPlayer.setSponsor(existingSponsor);
					}else {
						throw new RuntimeException("Incorrect sponsor Id...Sponsor with given name is not valid");
					}
				}
				return playerDao.save(newPlayer);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.fillInStackTrace());
		}
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
