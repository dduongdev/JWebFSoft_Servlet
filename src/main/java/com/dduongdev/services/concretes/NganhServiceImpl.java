package com.dduongdev.services.concretes;

import java.util.List;

import com.dduongdev.entities.Nganh;
import com.dduongdev.repositories.NganhRepository;
import com.dduongdev.repositories.mssql.MsSqlNganhRepository;
import com.dduongdev.services.NganhService;

public class NganhServiceImpl implements NganhService {
	private NganhRepository nganhRepository = new MsSqlNganhRepository();
	
	@Override
	public List<Nganh> getAll() {
		return nganhRepository.findAll();
	}

}
