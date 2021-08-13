package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Shipper;
import com.example.demo.repository.ShipperRepository;

@Service
public class ShipperService {

	@Autowired
	private ShipperRepository repository;

	public List<Shipper> getAllShippers() {
		return repository.getAllShippers();
	}

	public Shipper getShipper(int id) {
		return repository.getShipperById(id);
	}

	public Shipper saveShipper(Shipper shipper) {
		return repository.editShipper(shipper);
	}

	public Shipper newShipper(Shipper shipper) {
		return repository.addShipper(shipper);
	}

	public int deleteShipper(int id) {
		return repository.deleteShipper(id);
	}
}
