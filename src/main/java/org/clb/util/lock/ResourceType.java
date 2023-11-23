package org.clb.util.lock;



public enum ResourceType {

	/** 鐠у嫭绨猾璇茬��*/
	COURSE(1,"鐠囧墽鈻�"),
	COMBINATION_COURSE(2, "缂佸嫬鎮庣拠锟�"),
	CTF(3, "鐠ф盯顣�"),
	TRAIN_SCENE(4, "閸︾儤娅�"),
	TARGET(5, "闂堣埖鐖�"),
	VULN(6, "濠曞繑绀�"),
	FLOW(7, "濞翠線鍣�");

	private final Integer type;

	private String name;


	public Integer getCode() {
		return type;
	}

	public String getDesc() {
		return name;
	}

	ResourceType(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public static void main(String[] args) {
		for (ResourceType value : ResourceType.values()) {
			System.out.println(value.getCode()+"."+value.getDesc());
		}
	}
}
