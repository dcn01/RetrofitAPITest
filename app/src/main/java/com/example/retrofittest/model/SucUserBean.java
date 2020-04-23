package com.example.retrofittest.model;

/**
 * 当前登录用户的信息
 */
public class SucUserBean extends BaseResponseBean<SucUserBean.GetUserBean>{

	public class GetUserBean {
		public UserBean user;
	}
}
