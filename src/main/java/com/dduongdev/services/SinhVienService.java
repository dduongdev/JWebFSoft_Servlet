package com.dduongdev.services;

import java.util.List;

import com.dduongdev.dtos.AdvancedSinhVienSearchResultDTO;
import com.dduongdev.entities.SinhVien;
import com.dduongdev.entities.TotNghiep;

public interface SinhVienService {
	void persist(SinhVien sinhVien, TotNghiep totNghiep);
	List<SinhVien> searchBase(SinhVien sinhVien);
	List<AdvancedSinhVienSearchResultDTO> searchAdvanced(String soCMND);
}
