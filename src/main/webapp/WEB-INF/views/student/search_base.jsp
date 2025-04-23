<%@page import="com.dduongdev.entities.SinhVien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Base</title>
</head>
<body>
	<div style="
	    display: flex;
	    flex-direction: column;
	    width: 75%;
	    gap: 8px;
	    margin: auto;
	">
		<form>
			<input type="text" name="soCMND" placeholder="Nhập CMND..." />
			<input type="text" name="hoTen" placeholder="Nhập họ tên..." />
			<input type="text" name="email" placeholder="Nhập email..." />
			<input type="text" name="soDT" placeholder="Nhập số điện thoại..." />
			<input type="text" name="diaChi" placeholder="Nhập địa chỉ..." />
			<button>Tìm kiếm</button>
		</form>
		
		<%
			List<SinhVien> searchResult = (List<SinhVien>) request.getAttribute("search_result");
			if (searchResult == null || searchResult.size() == 0) {
				%>
				<span>Không tìm thấy kết quả.</span>
				<%
			} else {
				%>
				<table>
					<thead>
						<tr>
							<th>Số CMND</th>
							<th>Họ tên</th>
							<th>Email</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (SinhVien sinhVien : searchResult) {
								%>
									<tr>
										<td><%= sinhVien.getSoCMND() %></td>
										<td><%= sinhVien.getHoTen() %></td>
										<td><%= sinhVien.getEmail() %></td>
										<td><%= sinhVien.getSoDT() %></td>
										<td><%= sinhVien.getDiaChi() %></td>
									</tr>
								<%
							}
						%>
					</tbody>
				</table>
				<%
			}
		%>
	</div>
</body>
</html>