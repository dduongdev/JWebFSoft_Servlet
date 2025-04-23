package com.dduongdev.repositories;

import java.sql.Connection;
import java.util.List;

import com.dduongdev.dtos.AdvancedSinhVienSearchResultDTO;
import com.dduongdev.entities.SinhVien;

public interface SinhVienRepository {
	void persist(Connection conn, SinhVien sinhVien);
	List<SinhVien> searchBase(SinhVien sinhVien);
	List<AdvancedSinhVienSearchResultDTO> searchAdvanced(String soCMND);
}
