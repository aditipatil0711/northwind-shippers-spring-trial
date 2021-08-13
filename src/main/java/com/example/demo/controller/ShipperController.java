package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Shipper;
import com.example.demo.service.ShipperService;

@RestController
@RequestMapping("api/shippers")
public class ShipperController {

	@Autowired
	ShipperService service;

	@GetMapping(value = "/")
	public List<Shipper> getAllShippers() {
		return service.getAllShippers();
	}

	@GetMapping(value = "/{id}")
	public Shipper getShipperById(@PathVariable("id") int id) {
		return service.getShipper(id);
	}

	@PostMapping(value = "/")
	public Shipper addShipper(@RequestBody Shipper shipper) {
		return service.newShipper(shipper);
	}

	@PutMapping(value = "/")
	public Shipper editShipper(@RequestBody Shipper shipper) {
		return service.saveShipper(shipper);
	}

	@DeleteMapping(value = "/{id}")
	public int deleteShipper(@PathVariable int id) {
		return service.deleteShipper(id);
	}

}
