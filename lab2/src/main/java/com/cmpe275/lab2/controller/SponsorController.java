package com.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.lab2.model.Sponsor;
import com.cmpe275.lab2.service.SponsorService;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

	@Autowired
	private SponsorService sponsorService;

	/*
	 * (5) Create an sponsor 
	 * Path: sponsor?name=XX&description=YY&street=ZZ&...
	 * Method: POST 
	 * 
	 * This API creates a sponsor object. For simplicity, all the fields 
	 * (name, description, street, city, etc) are passed in as query parameters. 
	 * Only name is required. The beneficiaries cannot be passed in as a parameter. 
	 * The request returns the newly created sponsor object in its deep form in the 
	 * requested format in the HTTP payload.
	 */
	@PostMapping("/sponsor")
	public ResponseEntity<Sponsor> createSponsor(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip) {

		Sponsor sponsor = null;
//		sponsorService.createSponsor();

		// Error Handling: If the sponsor object already exists, return 409. For other
		// bad requests, return 400.
		return ResponseEntity.ok(sponsor);
	}

	/*
	 * (6) Get a sponsor 
	 * Path:sponsor/{name} 
	 * Method: GET
	 * 
	 * This returns a deep sponsor object in the requested format in its HTTP payload.
	 */
	@GetMapping("/sponsor/{name}")
	public ResponseEntity<Sponsor> getSponsor(@PathVariable(value = "name") String sponsorName) {

		Sponsor sponsor = null;
//		sponsorService.getSponsor();

		// Error Handling: If the sponsor of the given name does not exist, the HTTP
		// return code should be 404; otherwise, 200.
		return ResponseEntity.ok(sponsor);
	}

	/*
	 * (7) Update a sponsor 
	 * Path: sponsor/{name}?description=YY&street=ZZ&...
	 * Method: POST
	 * 
	 * This API updates a sponsor object. For simplicity, all the fields
	 * (description, street, city, etc), except name, are passed in as query parameters. 
	 * Only name is required. The beneficiaries cannot be passed in as a parameter. 
	 * Similar to the get method, the request returns the updated sponsor 
	 * object in its deep form, including the shallow beneficiaries.
	 */

	@PutMapping("/sponsor/{name}")
	public ResponseEntity<Sponsor> updateSponsor(@PathVariable(value = "name") String sponsorName,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip) {

		Sponsor sponsor = null;
//		sponsorService.updateSponsor();

		// Error Handling: If the sponsor name does not exist, 404 should be returned.
		// If required parameters are missing, return 400 instead. Otherwise, return 200.
		return ResponseEntity.ok(sponsor);
	}

	/*
	 * (8) Delete a sponsor 
	 * URL: http://sponsor/{name} 
	 * Method: DELETE 
	 * 
	 * This method deletes the sponsor object with the given name, 
	 * and returns the deep form of the deleted sponsor object.
	 */

	@DeleteMapping("/sponsor/{name}")
	public ResponseEntity<Sponsor> deletePlayer(@PathVariable(value = "name") String sponsorName) {

		Sponsor sponsor = null;
//		sponsorService.deleteSponsor();

		// Error Handling: If there is still any player benefiting from this sponsor,
		// return 400. If the sponsor with the given name does not exist, return 404.
		return ResponseEntity.ok(sponsor);
	}

}
