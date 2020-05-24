package com.rule.common.enums;

public enum BaseRespStatusEnum {

	/**
	 * 1-成功
	 */
	SUCCESS("1", "成功"),
	/**
	 * 0-失败
	 */
	FAIL("0", "失败"),
	/**
	 * 9-处理中
	 */
	IN_PROCESS("9", "处理中");

	private String code;

	private String desc;

	public static String getDescByCode(String code) {
		BaseRespStatusEnum tmp = getByCode(code);
		return tmp == null ? "" : tmp.getDesc();
	}

	public static BaseRespStatusEnum getByCode(String code) {
		if (code == null || "".equals(code)) {
			return null;
		}
		for (BaseRespStatusEnum tmp : BaseRespStatusEnum.values()) {
			if (tmp.getCode().equals(code)) {
				return tmp;
			}
		}
		return null;
	}

	BaseRespStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
