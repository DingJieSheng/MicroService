package com.sdj.bean;
/**
 * 通用的返回类
 * @author A
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Msg {
	
//	状态码 100-成功，200-失败
	private int code;
//	提示信息
	private String msg;
//	返回给浏览器的数据
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public static Msg success() {
		Msg resMsg = new Msg();
		resMsg.setCode(100);
		resMsg.setMsg("请求成功！");
		return resMsg;
	}
	
	public static Msg fail() {
		Msg resMsg = new Msg();
		resMsg.setCode(200);
		resMsg.setMsg("请求失败！");
		return resMsg;
	}
	
	public Msg add(String key, Object value) {
		this.resultMap.put(key, value);
		return this;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
}
