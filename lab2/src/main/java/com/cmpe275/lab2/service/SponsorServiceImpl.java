package com.cmpe275.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.lab2.dao.SponsorRepository;
import com.cmpe275.lab2.errors.AlreadyExistsException;
import com.cmpe275.lab2.errors.NotFoundException;
import com.cmpe275.lab2.model.Sponsor;

/*
 * Actual implementation of Sponsor CRUD operations
 * */
@Service
public class SponsorServiceImpl implements SponsorService {

	@Autowired
	private SponsorRepository sponsorDao;

	@Override
	public Sponsor createSponsor(Sponsor sponsor) {
		try {
			Sponsor existingSponsor = sponsorDao.findByName(sponsor.getName());
			if (existingSponsor != null) {
				throw new AlreadyExistsException("Sponsor with given Id already present!");
			} else {
				Sponsor newSponsor = new Sponsor(sponsor.getName(), sponsor.getDescription(), sponsor.getAddress());
				return sponsorDao.save(newSponsor);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.fillInStackTrace());
		}
	}

	@Override
	public Sponsor updateSponsor(Sponsor sponsor) {
		return null;
	}

	@Override
	public Sponsor getSponsor(String name) {
		try {
			Sponsor sponsor = sponsorDao.findByName(name);
			if (sponsor == null) {
				throw new NotFoundException("Sponsor does not exist!");
			} else {
				return sponsor;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.fillInStackTrace());
		}
	}

	@Override
	public Sponsor deleteSponsor(String name) {
		try {
			Sponsor sponsorName = sponsorDao.findByName(name);
			if (sponsorName == null) {
				throw new NotFoundException("Sponsor does not exist!");
			} else {
				// return sponsorDao.deleteById(name);
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.fillInStackTrace());
		}
	}

}
