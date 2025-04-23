package com.dduongdev.repositories.mssql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dduongdev.entities.Nganh;
import com.dduongdev.repositories.NganhRepository;
import com.dduongdev.repositories.mappers.NganhMapper;
import com.dduongdev.utils.DbConnector;

public class MsSqlNganhRepository implements NganhRepository {

	@Override
    public List<Nganh> findAll() {
        List<Nganh> result = new ArrayList<>();
        String sql = "SELECT * FROM NGANH";

        try (Connection conn = DbConnector.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                result.add(NganhMapper.map(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn danh sách ngành", e);
        }

        return result;
    }
}
