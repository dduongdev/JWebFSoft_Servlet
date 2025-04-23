package com.dduongdev.repositories.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dduongdev.entities.Nganh;

public class NganhMapper {
	public static Nganh map(ResultSet rs) throws SQLException {
		Nganh nganh = new Nganh();
		nganh.setMaNganh(rs.getInt("MaNganh"));
		nganh.setTenNganh(rs.getString("TenNganh"));
		nganh.setLoaiNganh(rs.getString("LoaiNganh"));
		return nganh;
	}
}