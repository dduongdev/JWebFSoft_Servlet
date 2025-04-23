package com.dduongdev.servlet;

import java.io.IOException;
import java.time.LocalDate;

import com.dduongdev.entities.HeTN;
import com.dduongdev.entities.LoaiTN;
import com.dduongdev.entities.SinhVien;
import com.dduongdev.entities.TotNghiep;
import com.dduongdev.services.NganhService;
import com.dduongdev.services.SinhVienService;
import com.dduongdev.services.TruongService;
import com.dduongdev.services.concretes.NganhServiceImpl;
import com.dduongdev.services.concretes.SinhVienServiceImpl;
import com.dduongdev.services.concretes.TruongServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/add")
public class AddSinhVienServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private NganhService nganhService = new NganhServiceImpl();
    private TruongService truongService = new TruongServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dsLoaiTN", LoaiTN.values());
        req.setAttribute("dsHeTN", HeTN.values());
        req.setAttribute("dsTruong", truongService.getAll());
        req.setAttribute("dsNganh", nganhService.getAll());

        req.getRequestDispatcher("/WEB-INF/views/student/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setSoCMND(req.getParameter("soCMND"));
        sinhVien.setHoTen(req.getParameter("hoTen"));
        sinhVien.setEmail(req.getParameter("email"));
        sinhVien.setSoDT(req.getParameter("soDT"));
        sinhVien.setDiaChi(req.getParameter("diaChi"));

        TotNghiep totNghiep = new TotNghiep();
        totNghiep.setSoCMND(sinhVien.getSoCMND()); 

        try {
            totNghiep.setMaNganh(Integer.parseInt(req.getParameter("maNganh")));
        } catch (Exception e) {
            totNghiep.setMaNganh(0); 
        }

        try {
            totNghiep.setMaTruong(Integer.parseInt(req.getParameter("maTruong")));
        } catch (Exception e) {
            totNghiep.setMaTruong(0);
        }

        String heTNParam = req.getParameter("heTN");
        String loaiTNParam = req.getParameter("loaiTN");
        String ngayTNParam = req.getParameter("ngayTN");

        if (heTNParam != null) {
            totNghiep.setHeTN(HeTN.valueOf(heTNParam));
        }

        if (loaiTNParam != null) {
            totNghiep.setLoaiTN(LoaiTN.valueOf(loaiTNParam));
        }

        if (ngayTNParam != null && !ngayTNParam.isBlank()) {
            try {
                totNghiep.setNgayTN(LocalDate.parse(ngayTNParam)); 
            } catch (Exception e) {
                totNghiep.setNgayTN(null);
            }
        }

        HttpSession session = req.getSession();
        boolean isInvalid = false;

        if (sinhVien.getSoCMND() == null || sinhVien.getSoCMND().isBlank()) {
            session.setAttribute("soCMNDErrorMessage", "SoCMND không được trống.");
            isInvalid = true;
        }

        if (totNghiep.getMaNganh() == 0) {
            session.setAttribute("maNganhErrorMessage", "Mã ngành không được trống.");
            isInvalid = true;
        }

        if (totNghiep.getMaTruong() == 0) {
            session.setAttribute("maTruongErrorMessage", "Mã trường không được trống.");
            isInvalid = true;
        }

        session.setAttribute("entriedSinhVien", sinhVien);
        session.setAttribute("entriedTotNghiep", totNghiep);

        if (isInvalid) {
            resp.sendRedirect(req.getContextPath() + "/student/add");
            return;
        }

        sinhVienService.persist(sinhVien, totNghiep);

        resp.sendRedirect(req.getContextPath() + "/WEB-INF/views/home.jsp");
    }

}
