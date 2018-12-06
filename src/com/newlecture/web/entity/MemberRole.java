package com.newlecture.web.entity;

public class MemberRole {
	private String memberId;
	private String roleId;
	private Boolean default_role;
	
	public MemberRole() {
		// TODO Auto-generated constructor stub
	}

	public MemberRole(String memberId, String roleId, Boolean default_role) {
		this.memberId = memberId;
		this.roleId = roleId;
		this.default_role=default_role;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
	public Boolean getDefault_role() {
		return default_role;
	}

	public void setDefault_role(Boolean default_role) {
		this.default_role = default_role;
	}

	@Override
	public String toString() {
		return "MemberRole [memberId=" + memberId + ", roleId=" + roleId + ", default_role=" + default_role + "]";
	}

	
}
