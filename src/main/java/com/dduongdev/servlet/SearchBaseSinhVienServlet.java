package com.dduongdev.servlet;

import java.io.IOException;
import java.util.List;

import com.dduongdev.entities.SinhVien;
import com.dduongdev.services.SinhVienService;
import com.dduongdev.services.concretes.SinhVienServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/search-base")
public class SearchBaseSinhVienServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SinhVienService sinhVienService = new SinhVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setSoCMND(req.getParameter("soCMND"));
        sinhVien.setHoTen(req.getParameter("hoTen"));
        sinhVien.setEmail(req.getParameter("email"));
        sinhVien.setSoDT(req.getParameter("soDT"));
        sinhVien.setDiaChi(req.getParameter("diaChi"));

        List<SinhVien> result = sinhVienService.searchBase(sinhVien);
        req.setAttribute("search_result", result);
        req.getRequestDispatcher("/WEB-INF/views/student/search_base.jsp").forward(req, resp);
    }
}
