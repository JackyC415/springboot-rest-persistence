package com.cmpe275.lab2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.lab2.dao.PlayerRepository;
import com.cmpe275.lab2.dao.SponsorRepository;
import com.cmpe275.lab2.errors.AlreadyExistsException;
import com.cmpe275.lab2.errors.BadRequestException;
import com.cmpe275.lab2.errors.NotFoundException;
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
				if(sponsorName!=null && sponsorName.length()!=0) {
					Optional<Sponsor> sponsorResult = sponsorDao.findById(sponsorName);
					if(sponsorResult.isPresent()) {
						newPlayer.setSponsor(sponsorResult.get());
					}else {
						throw new RuntimeException("Incorrect sponsor Id...Sponsor with given name is not valid");
					}
				}
				return playerDao.save(newPlayer);
			}
		} catch (Exception e) {
			throw new BadRequestException(e.fillInStackTrace());
		}
	}

	@Override
	public Player updatePlayer(Player player, String sponsorName) {
		try {
			Optional<Player> existingPlayer = playerDao.findById(player.getId());
			if (!existingPlayer.isPresent()) {
				System.out.println("inside not present");
				throw new NotFoundException("Player with given Id already present");
			} else {
				List<Player> opponents = existingPlayer.get().getOpponents();
				for(Player opponent:opponents) {
					player.addOpponent(opponent);
				}
				
				if(sponsorName!=null && sponsorName.length()!=0) {
					Optional<Sponsor> sponsorResult = sponsorDao.findById(sponsorName);
					if(sponsorResult.isPresent()) {
						player.setSponsor(sponsorResult.get());
					}else {
						throw new RuntimeException("Incorrect sponsor Id...Sponsor with given name is not valid");
					}
				}
				System.out.println(player);
				System.out.println(player.getOpponents());
				return playerDao.saveAndFlush(player);
			}
		} catch (Exception e) {
			throw new BadRequestException(e.fillInStackTrace());
		}
	}

	@Override
	public Player getPlayer(long id) {
		Optional<Player> result = playerDao.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			throw new NotFoundException("player with given Id does not found");
		}
	}

	@Override
	public Player deletePlayer(long id) {
		Optional<Player> result = playerDao.findById(id);
		if(result.isPresent()) {
			Player res=result.get();
			playerDao.deleteById(id);
			
			return res;
		}else {
			throw new NotFoundException("player with given Id does not found");
		}
	}
}
