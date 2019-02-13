package com.example;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("sample")
@SessionScope
public class Sample {
	private String option;

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}
