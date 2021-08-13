package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entities.Shipper;

public class DemoMySQLShippers implements ShipperRepository {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Shipper> getAllShippers() {
		// TODO Auto-generated method stub
		String sql = "SELECT ShipperID, CompanyName, Phone FROM Shippers";
		return template.query(sql, new ShipperRowMapper());
	}

	@Override
	public Shipper getShipperById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipper editShipper(Shipper shipper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteShipper(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Shipper addShipper(Shipper shipper) {
		// TODO Auto-generated method stub
		return null;
	}

}
