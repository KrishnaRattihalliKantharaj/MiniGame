package com.cmpe275.Lab2.model;

import java.util.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="player")
public class Player implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    private String firstname;
    private String lastname;
    @Column(name="email",unique=true)
    private String email;
    private String description;
    
    @OneToOne
    private Address address;
    
    @ManyToMany(targetEntity=Sponsor.class)
    private Sponsor sponsor;
    private List<Player> opponents;
    
    
    public int getId(int id){
    	return id;
    }
    public void setId(int id){
    	this.id=id;
    }
    public Player(){}
    
    public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Sponsor getSponsor() {
		return sponsor;
	}
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	public List<Player> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Player> opponents) {
		this.opponents = opponents;
	}
	public Player(String firstname, String lastname, String email, String description, Address address){
    	super();
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.email = email;
    	this.description = description;
    	this.address = address;
    }	
	
    
}
