package com.cmpe275.Lab2.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cmpe275.Lab2.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

	
}
