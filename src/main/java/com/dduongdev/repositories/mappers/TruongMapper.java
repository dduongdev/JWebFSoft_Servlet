package com.dduongdev.repositories.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dduongdev.entities.Truong;

public class TruongMapper {
	
    public static Truong mapRow(ResultSet rs) throws SQLException {
        Truong truong = new Truong();
        truong.setMaTruong(rs.getInt("MaTruong"));
        truong.setTenTruong(rs.getString("TenTruong"));
        truong.setDiaChi(rs.getString("DiaChi"));
        return truong;
    }
}
