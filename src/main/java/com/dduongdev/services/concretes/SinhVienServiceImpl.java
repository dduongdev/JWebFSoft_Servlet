package com.dduongdev.services.concretes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dduongdev.dtos.AdvancedSinhVienSearchResultDTO;
import com.dduongdev.entities.SinhVien;
import com.dduongdev.entities.TotNghiep;
import com.dduongdev.repositories.SinhVienRepository;
import com.dduongdev.repositories.TotNghiepRepository;
import com.dduongdev.repositories.mssql.MsSqlSinhVienRepository;
import com.dduongdev.repositories.mssql.MsSqlTotNghiepRepository;
import com.dduongdev.services.SinhVienService;
import com.dduongdev.utils.DbConnector;

public class SinhVienServiceImpl implements SinhVienService {
	private SinhVienRepository sinhVienRepository = new MsSqlSinhVienRepository();
	private TotNghiepRepository totNghiepRepository = new MsSqlTotNghiepRepository();

	@Override
	public void persist(SinhVien sinhVien, TotNghiep totNghiep) {
		Connection conn = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			conn.setAutoCommit(false);
			sinhVienRepository.persist(conn, sinhVien);
			totNghiepRepository.persist(conn, totNghiep);
			
			conn.commit();
		} catch (SQLException e) {
			if (conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<SinhVien> searchBase(SinhVien sinhVien) {
		return sinhVienRepository.searchBase(sinhVien);
	}

	@Override
	public List<AdvancedSinhVienSearchResultDTO> searchAdvanced(String soCMND) {
		return sinhVienRepository.searchAdvanced(soCMND);
	}

}
