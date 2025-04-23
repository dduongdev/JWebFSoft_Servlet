package com.dduongdev.repositories.mssql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dduongdev.dtos.AdvancedSinhVienSearchResultDTO;
import com.dduongdev.entities.SinhVien;
import com.dduongdev.repositories.SinhVienRepository;
import com.dduongdev.repositories.mappers.SinhVienMapper;
import com.dduongdev.utils.DbConnector;

public class MsSqlSinhVienRepository implements SinhVienRepository {

	@Override
	public List<SinhVien> searchBase(SinhVien sinhVien) {
	    StringBuilder sql = new StringBuilder("SELECT * FROM SINHVIEN WHERE 1=1 ");
	    List<Object> params = new ArrayList<>();

	    if (sinhVien.getDiaChi() != null && !sinhVien.getDiaChi().isBlank()) {
	        sql.append("AND DiaChi LIKE ? ");
	        params.add("%" + sinhVien.getDiaChi() + "%");
	    }
	    if (sinhVien.getEmail() != null && !sinhVien.getEmail().isBlank()) {
	        sql.append("AND Email LIKE ? ");
	        params.add("%" + sinhVien.getEmail() + "%");
	    }
	    if (sinhVien.getHoTen() != null && !sinhVien.getHoTen().isBlank()) {
	        sql.append("AND HoTen LIKE ? ");
	        params.add("%" + sinhVien.getHoTen() + "%");
	    }
	    if (sinhVien.getSoCMND() != null && !sinhVien.getSoCMND().isBlank()) {
	        sql.append("AND SoCMND LIKE ? ");
	        params.add("%" + sinhVien.getSoCMND() + "%");
	    }
	    if (sinhVien.getSoDT() != null && !sinhVien.getSoDT().isBlank()) {
	        sql.append("AND SoDT LIKE ? ");
	        params.add("%" + sinhVien.getSoDT() + "%");
	    }

	    Object[] paramsArray = params.toArray();
	    
	    List<SinhVien> result = new ArrayList<>();
	    
	    try (Connection conn = DbConnector.getInstance().getConnection();
	    		PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
	        for (int i = 0; i < paramsArray.length; i++) {
	            stmt.setObject(i + 1, paramsArray[i]);
	        }

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                SinhVien sinhVienResult = SinhVienMapper.mapRow(rs); 
	                result.add(sinhVienResult);
	            }
	        }
	    } catch (SQLException e) {
			e.printStackTrace();
		}

	    return result;
	}


	@Override
	public List<AdvancedSinhVienSearchResultDTO> searchAdvanced(String soCMND) {
	    String sql = "SELECT SINHVIEN.SoCMND, HoTen, TOTNGHIEP.MaNganh AS MaNganhTotNghiep, MaTruong, "
	               + "CONGVIEC.MaNganh AS MaNganhCongViec, TenCongTy, ThoiGianLamViec "
	               + "FROM SINHVIEN "
	               + "JOIN TOTNGHIEP ON SINHVIEN.SoCMND = TOTNGHIEP.SoCMND "
	               + "JOIN CONGVIEC ON SINHVIEN.SoCMND = CONGVIEC.SoCMND "
	               + "WHERE SINHVIEN.SoCMND = ?";

	    List<AdvancedSinhVienSearchResultDTO> result = new ArrayList<>();

	    try (Connection conn = DbConnector.getInstance().getConnection();
	    		PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, soCMND);

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                AdvancedSinhVienSearchResultDTO dto = new AdvancedSinhVienSearchResultDTO();
	                dto.setSoCMND(rs.getString("SoCMND"));
	                dto.setHoTen(rs.getString("HoTen"));
	                dto.setMaNganhTotNghiep(rs.getInt("MaNganhTotNghiep"));
	                dto.setMaTruong(rs.getInt("MaTruong"));
	                dto.setMaNganhCongViec(rs.getInt("MaNganhCongViec"));
	                dto.setTenCongTy(rs.getString("TenCongTy"));
	                dto.setThoiGianLamViec(rs.getString("ThoiGianLamViec"));
	                result.add(dto);
	            }
	        }
	    } catch (SQLException e) {
			e.printStackTrace();
		}

	    return result;
	}


	@Override
	public void persist(Connection conn, SinhVien sinhVien) {
		String sql = "INSERT INTO SINHVIEN (SoCMND, HoTen, Email, SoDT, DiaChi) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, sinhVien.getSoCMND());
			stmt.setString(2, sinhVien.getHoTen());
			stmt.setString(3, sinhVien.getEmail());
			stmt.setString(4, sinhVien.getSoDT());
			stmt.setString(5, sinhVien.getDiaChi());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
