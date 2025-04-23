package com.dduongdev.servlet;

import java.io.IOException;
import java.util.List;

import com.dduongdev.dtos.AdvancedSinhVienSearchResultDTO;
import com.dduongdev.services.SinhVienService;
import com.dduongdev.services.concretes.SinhVienServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/search-advanced")
public class SearchAdvancedSinhVienServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SinhVienService sinhVienService = new SinhVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String soCMND = req.getParameter("searchParam");
        if (soCMND == null) soCMND = "";

        List<AdvancedSinhVienSearchResultDTO> result = sinhVienService.searchAdvanced(soCMND);
        req.setAttribute("search_result", result);
        req.getRequestDispatcher("/WEB-INF/views/student/search_advanced.jsp").forward(req, resp);
    }
}