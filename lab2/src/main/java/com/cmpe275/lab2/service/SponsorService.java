package com.cmpe275.lab2.service;

import com.cmpe275.lab2.model.Sponsor;

/*
 * Interface to define necessary Sponsor CRUD operations
 * */
public interface SponsorService {

	Sponsor createSponsor();
	Sponsor updateSponsor();
	Sponsor getSponsor();
	Sponsor deleteSponsor();
	
}
