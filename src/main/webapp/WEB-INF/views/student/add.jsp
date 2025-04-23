<%@page import="com.dduongdev.entities.TotNghiep"%>
<%@page import="com.dduongdev.entities.SinhVien"%>
<%@page import="com.dduongdev.entities.Nganh"%>
<%@page import="com.dduongdev.entities.Truong"%>
<%@page import="java.util.List"%>
<%@page import="com.dduongdev.entities.HeTN"%>
<%@page import="com.dduongdev.entities.LoaiTN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sinh viên</title>
</head>
<body>
	<%
		LoaiTN[] dsLoaiTN = (LoaiTN[]) request.getAttribute("dsLoaiTN");
		HeTN[] dsHeTN = (HeTN[]) request.getAttribute("dsHeTN");
		List<Truong> dsTruong = (List<Truong>) request.getAttribute("dsTruong");
		List<Nganh> dsNganh = (List<Nganh>) request.getAttribute("dsNganh");
		
		SinhVien entriedSinhVien = (SinhVien) request.getAttribute("entriedSinhVien");
		TotNghiep entriedTotNghiep = (TotNghiep) request.getAttribute("entriedTotNghiep");
		
		String soCMNDErrorMessage = (String) request.getAttribute("soCMNDErrorMessage");
		String maNganhErrorMessage = (String) request.getAttribute("maNganhErrorMessage");
		String maTruongErrorMessage = (String) request.getAttribute("maTruongErrorMessage");
	%>
	
	<div style="
	    display: flex;
	    height: 100vh;
	">
		<form method="post" action="${pageContext.request.contextPath}/student/add" style="
		    display: flex;
		    flex-direction: column;
		    width: 50%;
		    gap: 4px;
		    margin: auto;
		">
			<input type="text" name="soCMND" value="<%= entriedSinhVien != null ? entriedSinhVien.getSoCMND() : "" %>" placeholder="Nhập CMND.." required />
			<%
				if (soCMNDErrorMessage != null && !soCMNDErrorMessage.isBlank()) {
					%>
						<span style="color: red;"><%= soCMNDErrorMessage %></span>
					<%
				}
			%>
			
			<input type="text" name="hoTen" value="<%= entriedSinhVien != null ? entriedSinhVien.getHoTen() : "" %>" placeholder="Nhập họ tên..." required />
			<input type="text" name="email" value="<%= entriedSinhVien != null ? entriedSinhVien.getEmail() : "" %>" placeholder="Nhập email..." required />
			<input type="text" name="soDT" value="<%= entriedSinhVien != null ? entriedSinhVien.getSoDT() : "" %>" placeholder="Nhập số điện thoại..." required />
			<input type="text" name="diaChi" value="<%= entriedSinhVien != null ? entriedSinhVien.getDiaChi() : "" %>" placeholder="Nhập địa chỉ..." required />
			
			<select name="maTruong" required>
				<option value="">Chọn trường</option>
				<%
					for (Truong truong : dsTruong) {
						boolean isSelected = entriedTotNghiep != null && entriedTotNghiep.getMaTruong() == truong.getMaTruong();
						%>
							<option value="<%= truong.getMaTruong() %>" <%= isSelected ? "selected" : "" %>><%= truong.getTenTruong() %></option>
						<%
					}
				%>
			</select>
			<%
				if (maTruongErrorMessage != null && !maTruongErrorMessage.isBlank()) {
					%>
						<span><%= maTruongErrorMessage %></span>
					<%
				}
			%>
			
			<select name="maNganh" required>
				<option value="">Chọn ngành</option>
				<%
					for (Nganh nganh : dsNganh) {
						boolean isSelected = entriedTotNghiep != null && entriedTotNghiep.getMaNganh() == nganh.getMaNganh();
						%>
							<option value="<%= nganh.getMaNganh() %>" <%= isSelected ? "selected" : "" %>><%= nganh.getTenNganh() %></option>
						<%
					}
				%>
			</select>
			<%
				if (maNganhErrorMessage != null && !maNganhErrorMessage.isBlank()) {
					%>
						<span><%= maNganhErrorMessage %></span>
					<%
				}
			%>
			
			<select name="heTN" required>
				<option value="">Chọn hệ tốt nghiệp</option>
				<%
					for (HeTN heTN : dsHeTN) {
						boolean isSelected = entriedTotNghiep != null && entriedTotNghiep.getHeTN() == heTN;
						%>
							<option value="<%= heTN.name() %>" <%= isSelected ? "selected" : "" %>><%= heTN.getHienthi() %></option>
						<%
					}
				%>
			</select>
			
			<input type="date" name="ngayTN" value="<%= entriedTotNghiep != null ? entriedTotNghiep.getNgayTN() : "" %>" required />
			
			<select name="loaiTN" required>
				<option value="">Chọn loại tốt nghiệp</option>
				<%
					for (LoaiTN loaiTN : dsLoaiTN) {
						boolean isSelected = entriedTotNghiep != null && entriedTotNghiep.getLoaiTN() == loaiTN;
						%>
							<option value="<%= loaiTN.name() %>" <%= isSelected ? "selected" : "" %>><%= loaiTN.getHienThi() %></option>
						<%
					}
				%>
			</select>
			
			<button>Gửi</button>
		</form>
	</div>
</body>
</html>