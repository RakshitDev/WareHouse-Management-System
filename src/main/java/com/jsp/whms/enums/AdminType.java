package com.jsp.whms.enums;

import java.util.List;

public enum AdminType {
	SUPER_ADMIN(List.of(Privilage.CREATE_ADMIN, Privilage.CREATE_ADDRESS, Privilage.CREATE_WAREHOUSE,
			Privilage.CREATE_STORAGE, Privilage.READ, Privilage.UPDATE_ADMIN, Privilage.UPDATE_WAREHOUSE,
			Privilage.UPDATE_ADDRESS, Privilage.UPDATE_STORAGE, Privilage.DELETE_ADMIN, Privilage.DELETE_WAREHOUSE,
			Privilage.DELETE_ADDRESS, Privilage.DELETE_STORAGE)),

	ADMIN(List.of(Privilage.CREATE_STORAGE, Privilage.UPDATE_ADMIN, Privilage.UPDATE_STORAGE, Privilage.READ,
			Privilage.DELETE_STORAGE));

	private List<Privilage> privilages;

	AdminType(List<Privilage> privalages) {
		this.privilages = privalages;
	}

	public List<Privilage> getPrivilages() {
		return this.privilages;
	}
}
