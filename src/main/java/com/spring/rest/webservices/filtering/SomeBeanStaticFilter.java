package com.spring.rest.webservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"field4","field7"})	
public class SomeBeanStaticFilter extends SomeBeanDynamicFilter {
	
	private String field4;
	@JsonIgnore
	private String field5;
	private String field6;
	private String field7;

	public SomeBeanStaticFilter(String field1, String field2, String field3, String field4, String field5,
			String field6, String field7) {
		super(field1, field2, field3);
		this.field4 = field4;
		this.field5 = field5;
		this.field6 = field6;
		this.field7 = field7;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public String getField7() {
		return field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}
	
}
