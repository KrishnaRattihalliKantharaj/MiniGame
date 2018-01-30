package com.cmpe275.Lab2.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cmpe275.Lab2.dao.*;
import com.cmpe275.Lab2.model.Address;
import com.cmpe275.Lab2.model.Player;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class PlayersService {
	@Autowired
	private OpponentsService opponenetsService;
	
	@Autowired
	private SponsorService sponsorService;
	
	@Autowired 
	private static AddressService addressService;
	
	private static PlayerRepository playerRepository;
	
	//private final PlayerRepository playerRepository;
	public static List<Player> addPlayers(String firstname, String lastname, String email,String description,String street,String city,String state,Long zip,int sponsorerId){
		Address address = new Address(street,city,state,zip);
		addressService.saveAddress(address);
		Player player = new Player(firstname, lastname, email, description,address);
		playerRepository.save(player);
		
		List<Player> PlayerList = new ArrayList<>();
		/*Task task = taskRepository.findOne(1);
		tasks.add(task);*/
		for(Player plr : playerRepository.findAll()){
			if(plr.getEmail().equals(email))
				PlayerList.add(plr);
		}

		return PlayerList;
		
	}
	
	/*public static List<Player> getDetails(Player plr){
		List<Player> players = new ArrayList<>();
		Task task = taskRepository.findOne(1);
		tasks.add(task);
		Player player : playerRepository.findPlayer(plr.getEmail());
			if(player.getName().equals("Vimal"))
				players.add(player);
		return players;
	}*/
	
}
