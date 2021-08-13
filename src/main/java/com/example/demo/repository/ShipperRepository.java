package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Shipper;

public interface ShipperRepository {
	public List<Shipper> getAllShippers();

	public Shipper getShipperById(int id);

	public Shipper editShipper(Shipper shipper);

	public int deleteShipper(int id);

	public Shipper addShipper(Shipper shipper);

}
