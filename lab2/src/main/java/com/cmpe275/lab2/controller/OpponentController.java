package com.cmpe275.lab2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.lab2.model.Player;

@RestController
public class OpponentController {

	/*
	 * (9) Add an opponent relationship 
	 * Path:opponents/{id1}/{id2} 
	 * Method: POST This
	 * 
	 * makes the two players with the given IDs opponents with each other. If the
	 * two players are already opponents, do nothing, just return 200. Otherwise,
	 * record this opponent relationship.
	 */
	@PostMapping("/opponents/{id1}/{id2}")
	public Player addOpponent(@PathVariable(value = "id") Long playerId) {

		/*
		 * Error Handling: If either player does not exist, return 404. Return 400 for
		 * other bad requests, e.g., the given two players are the same. If all is
		 * successful, return HTTP code 200 and any informative text message in the HTTP
		 * payload.
		 */
		return null;
	}

	/*
	 * (10) Remove an opponent relationship 
	 * Path:opponents/{id1}/{id2} Method:
	 * DELETE
	 * 
	 * This request removes the opponent relation between the two players.
	 */
	@DeleteMapping("/opponents/{id1}/{id2}")
	public Player deleteOpponent(@PathVariable(value = "id") Long playerId) {

		/*
		 * Error Handling: If either player does not exist, return 404. Return 400 for
		 * other bad requests; e.g, if the two players are not opponents, return 400
		 * too. Otherwise, Remove this opponent relation. Return HTTP code 200 and a
		 * meaningful text message if all is successful.
		 */
		return null;
	}

}
