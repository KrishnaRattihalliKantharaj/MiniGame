package com.cmpe275.Lab2.dao;

import org.springframework.data.repository.CrudRepository;

import com.cmpe275.Lab2.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
