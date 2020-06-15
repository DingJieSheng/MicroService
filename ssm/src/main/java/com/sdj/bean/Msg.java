package com.sdj.bean;
/**
 * ͨ�õķ�����
 * @author A
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Msg {
	
//	״̬�� 100-�ɹ���200-ʧ��
	private int code;
//	��ʾ��Ϣ
	private String msg;
//	���ظ������������
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public static Msg success() {
		Msg resMsg = new Msg();
		resMsg.setCode(100);
		resMsg.setMsg("����ɹ���");
		return resMsg;
	}
	
	public static Msg fail() {
		Msg resMsg = new Msg();
		resMsg.setCode(200);
		resMsg.setMsg("����ʧ�ܣ�");
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
