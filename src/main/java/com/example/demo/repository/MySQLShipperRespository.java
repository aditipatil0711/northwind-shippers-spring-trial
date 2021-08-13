package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Shipper;

@Repository
public class MySQLShipperRespository implements ShipperRepository {

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
		String sql = "SELECT ShipperID, CompanyName, Phone FROM Shippers WHERE ShipperID=?";
		return template.queryForObject(sql, new ShipperRowMapper(), id);
	}

	@Override
	public Shipper editShipper(Shipper shipper) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Shippers SET CompanyName = ?, Phone = ? " + "WHERE ShipperID = ?";
		template.update(sql, shipper.getName(), shipper.getPhone(), shipper.getId());
		return shipper;
	}

	@Override
	public int deleteShipper(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Shippers WHERE ShipperID = ?";
		template.update(sql, id);
		return id;
	}

	@Override
	public Shipper addShipper(Shipper shipper) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Shippers(CompanyName, Phone) " + "VALUES(?,?)";
		template.update(sql, shipper.getName(), shipper.getPhone());
		return shipper;
	}

}

class ShipperRowMapper implements RowMapper<Shipper> {

	@Override
	public Shipper mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Shipper(rs.getInt("ShipperID"), rs.getString("CompanyName"), rs.getString("Phone"));
	}

}
