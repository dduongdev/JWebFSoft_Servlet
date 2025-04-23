package com.dduongdev.repositories.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dduongdev.entities.SinhVien;

public class SinhVienMapper {
	 public static SinhVien mapRow(ResultSet rs) throws SQLException {
	        SinhVien sinhVien = new SinhVien();
	        
	        sinhVien.setSoCMND(rs.getString("SoCMND"));
	        sinhVien.setHoTen(rs.getString("HoTen"));
	        sinhVien.setDiaChi(rs.getString("DiaChi"));
	        sinhVien.setEmail(rs.getString("Email"));
	        sinhVien.setSoDT(rs.getString("SoDT"));
	        return sinhVien;
	    }
}
