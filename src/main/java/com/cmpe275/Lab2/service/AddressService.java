package com.cmpe275.Lab2.service;

import com.cmpe275.Lab2.dao.AddressRepository;
import com.cmpe275.Lab2.model.Address;

public class AddressService {
	private final AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository) {
	this.addressRepository = addressRepository;
	}

	public void saveAddress(Address address){
		addressRepository.save(address);
	}
	
	public Address getAddress(int id){
		return addressRepository.findOne(id);
	}
}
