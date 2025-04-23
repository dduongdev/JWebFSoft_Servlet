package com.dduongdev.entities;

public enum HeTN {
	DAI_HOC("Đại học"), CAO_DANG("Cao đẳng");

	HeTN(String hienthi) {
		this.hienthi = hienthi;
	}

	private final String hienthi;

	public String getHienthi() {
		return hienthi;
	}

}
