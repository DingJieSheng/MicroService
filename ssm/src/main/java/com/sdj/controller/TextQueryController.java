package com.sdj.controller;

import java.awt.event.TextListener;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdj.bean.EmotionText;
import com.sdj.bean.Msg;
import com.sdj.service.EmotionTextService;

@Controller
public class TextQueryController {
	
	@Autowired
	EmotionTextService emotionTextService;
	
	
	/**
	 * ����json����ʵ��ƽ̨�޹�
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/searchtext")
	@ResponseBody
	public Msg textListJson(@RequestParam(value = "page", defaultValue = "1")Integer pageNum) {
		PageHelper.startPage(pageNum, 20);
		List<EmotionText> list = emotionTextService.getAll();
//		ʹ��pageinfo��װ��ѯ�Ľ��������ҳ������������������ϸ��Ϣ��ֻ�轫pageinfo���ظ�ǰ��ҳ����Ⱦ
		PageInfo pageinfo = new PageInfo(list, 10);
		return Msg.success().add("pageInfo", pageinfo);
	}
	
//	@RequestMapping("/searchtext")
//	public String textList(@RequestParam(value = "page", defaultValue = "1")Integer pageNum, Model model) {
////		��ѯ�����ı���Ϣ
////		List<EmotionText> list = emotionTextService.getAll();
//		
////		�����ҳ���
////		��ѯ����ʱ����ҳ���Լ�ÿһҳ��չʾ����������
//		PageHelper.startPage(pageNum, 20);
//		List<EmotionText> list = emotionTextService.getAll();
////		ʹ��pageinfo��װ��ѯ�Ľ��������ҳ������������������ϸ��Ϣ��ֻ�轫pageinfo���ظ�ǰ��ҳ����Ⱦ
//		PageInfo pageinfo = new PageInfo(list, 10);
//		model.addAttribute("pageinfo", pageinfo);
//		return "textlist";
//	}
	
	@RequestMapping("/textinfo")
	public String textInfo(@RequestParam(value = "textID", defaultValue = "-1")Integer textID, Model model) {
//		��ѯ�����ı���Ϣ
//		List<EmotionText> list = emotionTextService.getAll();
		
//		�����ҳ���
//		��ѯ����ʱ����ҳ���Լ�ÿһҳ��չʾ����������
		if(textID == -1) {
			model.addAttribute("textinfo", null);
			return "textinfo";
		}
		List<EmotionText> list = emotionTextService.getTextInfo(textID);
//		ʹ��pageinfo��װ��ѯ�Ľ��������ҳ������������������ϸ��Ϣ��ֻ�轫pageinfo���ظ�ǰ��ҳ����Ⱦ
		model.addAttribute("textinfo", list.get(0));
		return "textinfo";
	}
	
	@RequestMapping("/insertText")
	@ResponseBody
	public Msg insertText(@RequestParam(value = "inputtext", defaultValue = " ")String text, @RequestParam(value = "emotionLabel", defaultValue = "0")Integer label, @RequestParam(value = "isNew", defaultValue = "0")Integer isnew) {
//		��ѯ�����ı���Ϣ
//		List<EmotionText> list = emotionTextService.getAll();
		
//		�����ҳ���
//		��ѯ����ʱ����ҳ���Լ�ÿһҳ��չʾ����������
		if(text == null) {
			return Msg.fail();
		}
		int result = emotionTextService.insertText(text, label, isnew);
//		ʹ��pageinfo��װ��ѯ�Ľ��������ҳ������������������ϸ��Ϣ��ֻ�轫pageinfo���ظ�ǰ��ҳ����Ⱦ
		if(result >= 0)
			return Msg.success();
		return Msg.fail();
	}
	
	
}
