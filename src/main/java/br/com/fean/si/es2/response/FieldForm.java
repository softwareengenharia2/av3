package br.com.fean.si.es2.response;

import lombok.Getter;

@Getter
public class FieldForm {

	private String name;
	
	private FieldForm(String name) {
		this.name = name;
	}
	
	public static FieldForm create(String name) {
		return new FieldForm(name);
	}
	
}
