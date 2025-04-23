package com.dduongdev.repositories;

import java.sql.Connection;

import com.dduongdev.entities.TotNghiep;

public interface TotNghiepRepository {
	void persist(Connection conn, TotNghiep totNghiep);
}
