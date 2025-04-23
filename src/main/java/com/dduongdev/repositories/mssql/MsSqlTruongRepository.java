package com.dduongdev.repositories.mssql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dduongdev.entities.Truong;
import com.dduongdev.repositories.TruongRepository;
import com.dduongdev.repositories.mappers.TruongMapper;
import com.dduongdev.utils.DbConnector;

public class MsSqlTruongRepository implements TruongRepository {

	@Override
    public List<Truong> findAll() {
        List<Truong> truongList = new ArrayList<>();
        String sql = "SELECT * FROM TRUONG";

        try (Connection conn = DbConnector.getInstance().getConnection();
        		PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Truong truong = TruongMapper.mapRow(rs);
                truongList.add(truong);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return truongList;
    }

}
