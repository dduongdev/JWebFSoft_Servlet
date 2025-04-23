package com.dduongdev.entities;

import java.time.LocalDate;

public class TotNghiep {
	private String soCMND;
	private int maTruong;
	private int maNganh;
	private HeTN heTN;
	private LoaiTN loaiTN;
	private LocalDate ngayTN;

	public TotNghiep() {
		super();
	}

	public TotNghiep(String soCMND, int maTruong, int maNganh, HeTN heTN, LoaiTN loaiTN, LocalDate ngayTN) {
		super();
		this.soCMND = soCMND;
		this.maTruong = maTruong;
		this.maNganh = maNganh;
		this.heTN = heTN;
		this.loaiTN = loaiTN;
		this.ngayTN = ngayTN;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public int getMaTruong() {
		return maTruong;
	}

	public void setMaTruong(int maTruong) {
		this.maTruong = maTruong;
	}

	public int getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(int maNganh) {
		this.maNganh = maNganh;
	}

	public HeTN getHeTN() {
		return heTN;
	}

	public void setHeTN(HeTN heTN) {
		this.heTN = heTN;
	}

	public LoaiTN getLoaiTN() {
		return loaiTN;
	}

	public void setLoaiTN(LoaiTN loaiTN) {
		this.loaiTN = loaiTN;
	}

	public LocalDate getNgayTN() {
		return ngayTN;
	}

	public void setNgayTN(LocalDate ngayTN) {
		this.ngayTN = ngayTN;
	}

	@Override
	public String toString() {
		return "TotNghiep [soCMND=" + soCMND + ", maTruong=" + maTruong + ", maNganh=" + maNganh + ", heTN=" + heTN
				+ ", loaiTN=" + loaiTN + ", ngayTN=" + ngayTN + "]";
	}

}
