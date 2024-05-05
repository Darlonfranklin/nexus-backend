package com.nexus.backend.domain.enums;

public enum Profile {

	ADMIN(0, "ROLE_ADMIN");

	private final Integer code;
	private final String description;

	private Profile(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Profile toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Profile x : Profile.values()) {
			if (cod.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Profile");
	}

}
