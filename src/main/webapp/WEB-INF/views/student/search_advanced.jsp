<%@page import="com.dduongdev.dtos.AdvancedSinhVienSearchResultDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Advanced</title>
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
			<input type="text" name="searchParam" placeholder="Nhập số CMND..." />
			<button>Tìm kiếm</button>
		</form>
		
		<%
			List<AdvancedSinhVienSearchResultDTO> searchResult = (List<AdvancedSinhVienSearchResultDTO>) request.getAttribute("search_result");
		
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
							<th>Mã ngành tốt nghiệp</th>
							<th>Mã trường</th>
							<th>Mã ngành công việc</th>
							<th>Tên công ty</th>
							<th>Thời gian làm việc</th>
						</tr>
					</thead>
					
					<tbody>
						<%
						for (AdvancedSinhVienSearchResultDTO tuple : searchResult) {
							%>
							<tr>
								<td><%= tuple.getSoCMND() %></td>
								<td><%= tuple.getHoTen() %></td>
								<td><%= tuple.getMaNganhTotNghiep() %></td>
								<td><%= tuple.getMaTruong() %></td>
								<td><%= tuple.getMaNganhCongViec() %></td>
								<td><%= tuple.getTenCongTy() %></td>
								<td><%= tuple.getThoiGianLamViec() %></td>
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