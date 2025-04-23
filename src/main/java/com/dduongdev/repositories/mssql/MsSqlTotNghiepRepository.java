package com.dduongdev.repositories.mssql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dduongdev.entities.TotNghiep;
import com.dduongdev.repositories.TotNghiepRepository;


public class MsSqlTotNghiepRepository implements TotNghiepRepository {

	@Override
	public void persist(Connection conn, TotNghiep totNghiep) {
		String sql = "INSERT INTO TOTNGHIEP(SoCMND, MaTruong, MaNganh, HeTN, NgayTN, LoaiTN) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, totNghiep.getSoCMND());
			stmt.setInt(2, totNghiep.getMaTruong());
			stmt.setInt(3, totNghiep.getMaNganh());
			stmt.setInt(4, totNghiep.getHeTN().ordinal());
			stmt.setDate(5, Date.valueOf(totNghiep.getNgayTN()));
			stmt.setInt(6, totNghiep.getLoaiTN().ordinal());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
