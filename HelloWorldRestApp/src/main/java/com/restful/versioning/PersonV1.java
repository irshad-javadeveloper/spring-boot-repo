package com.restful.versioning;

public class PersonV1 {

	private String name;
	public PersonV1() {}

	public PersonV1(String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	
}
