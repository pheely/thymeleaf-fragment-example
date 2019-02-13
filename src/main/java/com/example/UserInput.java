package com.example;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("sessionAttr")
@SessionScope
public class UserInput {
	private String page;
	private String category;
	private String subCategory;
	private String selection;
	private String userId;
	private String password;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSelection() {
		return (category != null && category.length()>0? category + " " : "") 
			+  (subCategory != null && subCategory.length()>0? subCategory + " " : "")
			+  (userId != null && userId.length()>0? userId + " " : "") 
			+  (password != null && password.length()>0? password : "");
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
