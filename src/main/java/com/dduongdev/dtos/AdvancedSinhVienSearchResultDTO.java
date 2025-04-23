package com.dduongdev.dtos;

public class AdvancedSinhVienSearchResultDTO {
	private String soCMND;
	private String hoTen;
	private int maNganhTotNghiep;
	private int maTruong;
	private int maNganhCongViec;
	private String tenCongTy;
	private String thoiGianLamViec;

	public AdvancedSinhVienSearchResultDTO(String soCMND, String hoTen, int maNganhTotNghiep, int maTruong,
			int maNganhCongViec, String tenCongTy, String thoiGianLamViec) {
		super();
		this.soCMND = soCMND;
		this.hoTen = hoTen;
		this.maNganhTotNghiep = maNganhTotNghiep;
		this.maTruong = maTruong;
		this.maNganhCongViec = maNganhCongViec;
		this.tenCongTy = tenCongTy;
		this.thoiGianLamViec = thoiGianLamViec;
	}

	public AdvancedSinhVienSearchResultDTO() {
		super();
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getMaNganhTotNghiep() {
		return maNganhTotNghiep;
	}

	public void setMaNganhTotNghiep(int maNganhTotNghiep) {
		this.maNganhTotNghiep = maNganhTotNghiep;
	}

	public int getMaTruong() {
		return maTruong;
	}

	public void setMaTruong(int maTruong) {
		this.maTruong = maTruong;
	}

	public int getMaNganhCongViec() {
		return maNganhCongViec;
	}

	public void setMaNganhCongViec(int maNganhCongViec) {
		this.maNganhCongViec = maNganhCongViec;
	}

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getThoiGianLamViec() {
		return thoiGianLamViec;
	}

	public void setThoiGianLamViec(String thoiGianLamViec) {
		this.thoiGianLamViec = thoiGianLamViec;
	}

}
