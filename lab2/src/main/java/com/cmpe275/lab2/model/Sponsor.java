package com.cmpe275.lab2.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sponsor")
public class Sponsor {
	@Id
	@Column(name = "name", nullable = false)
	private String name; // primary key, >= two characters after trimming white spaces

	@Column(name = "description")
	private String description;

	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	List<Player>beneficiaries;

	public Sponsor() {
		// TODO Auto-generated constructor stub
	}
	
	public Sponsor(String name, String description, Address address) {
		this.name = name;
		this.description = description;
		this.address = address;
	}

	public List<Player> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Player> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Sponsor [name=" + name + ", description=" + description + ", address=" + address + "]";
	}
	
	public void addBeneficiary(Player player) {
		if(this.beneficiaries==null) {
			this.beneficiaries=new ArrayList<Player>();
		}
		this.beneficiaries.add(player);
	}
}
