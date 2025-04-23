package com.dduongdev.services.concretes;

import java.util.List;

import com.dduongdev.entities.Truong;
import com.dduongdev.repositories.TruongRepository;
import com.dduongdev.repositories.mssql.MsSqlTruongRepository;
import com.dduongdev.services.TruongService;

public class TruongServiceImpl implements TruongService {
	private TruongRepository truongRepository = new MsSqlTruongRepository();

	@Override
	public List<Truong> getAll() {
		return truongRepository.findAll();
	}

}
