/**
 * 
 */
package com.project.vo;

import java.util.List;

import com.project.pojo.TRole;
import com.project.pojo.TUser;

/**
 * @author cyr
 * @Date 2018年5月16日
 * @version 1.0
 */
public class UserVO {
	private String userId;
	private String userRname;
	private String roleName;
	private String userTel;
	private String userEmail;
	private String userGender;
	private String userAddress;

	public UserVO(TUser user0,List<TRole> list) {
		this.userId = user0.getUserId();
		this.userRname = user0.getUserRname();
		this.roleName = "";
		this.userTel = user0.getUserTel();
		this.userEmail = user0.getUserEmail();
		this.userGender = user0.getUserGender();
		this.userAddress = user0.getUserAddress();
		for (TRole tRole : list) {
			roleName += tRole.getRoleName()+"  ";
		}
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserRname() {
		return userRname;
	}


	public void setUserRname(String userRname) {
		this.userRname = userRname;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getUserTel() {
		return userTel;
	}


	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserGender() {
		return userGender;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


}
