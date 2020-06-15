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
	 * 返回json对象，实现平台无关
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/searchtext")
	@ResponseBody
	public Msg textListJson(@RequestParam(value = "page", defaultValue = "1")Integer pageNum) {
		PageHelper.startPage(pageNum, 20);
		List<EmotionText> list = emotionTextService.getAll();
//		使用pageinfo包装查询的结果，包括页面总数，数据量等详细信息，只需将pageinfo返回给前端页面渲染
		PageInfo pageinfo = new PageInfo(list, 10);
		return Msg.success().add("pageInfo", pageinfo);
	}
	
//	@RequestMapping("/searchtext")
//	public String textList(@RequestParam(value = "page", defaultValue = "1")Integer pageNum, Model model) {
////		查询所有文本信息
////		List<EmotionText> list = emotionTextService.getAll();
//		
////		引入分页插件
////		查询数据时传入页码以及每一页所展示的数据条数
//		PageHelper.startPage(pageNum, 20);
//		List<EmotionText> list = emotionTextService.getAll();
////		使用pageinfo包装查询的结果，包括页面总数，数据量等详细信息，只需将pageinfo返回给前端页面渲染
//		PageInfo pageinfo = new PageInfo(list, 10);
//		model.addAttribute("pageinfo", pageinfo);
//		return "textlist";
//	}
	
	@RequestMapping("/textinfo")
	public String textInfo(@RequestParam(value = "textID", defaultValue = "-1")Integer textID, Model model) {
//		查询所有文本信息
//		List<EmotionText> list = emotionTextService.getAll();
		
//		引入分页插件
//		查询数据时传入页码以及每一页所展示的数据条数
		if(textID == -1) {
			model.addAttribute("textinfo", null);
			return "textinfo";
		}
		List<EmotionText> list = emotionTextService.getTextInfo(textID);
//		使用pageinfo包装查询的结果，包括页面总数，数据量等详细信息，只需将pageinfo返回给前端页面渲染
		model.addAttribute("textinfo", list.get(0));
		return "textinfo";
	}
	
	@RequestMapping("/insertText")
	@ResponseBody
	public Msg insertText(@RequestParam(value = "inputtext", defaultValue = " ")String text, @RequestParam(value = "emotionLabel", defaultValue = "0")Integer label, @RequestParam(value = "isNew", defaultValue = "0")Integer isnew) {
//		查询所有文本信息
//		List<EmotionText> list = emotionTextService.getAll();
		
//		引入分页插件
//		查询数据时传入页码以及每一页所展示的数据条数
		if(text == null) {
			return Msg.fail();
		}
		int result = emotionTextService.insertText(text, label, isnew);
//		使用pageinfo包装查询的结果，包括页面总数，数据量等详细信息，只需将pageinfo返回给前端页面渲染
		if(result >= 0)
			return Msg.success();
		return Msg.fail();
	}
	
	
}
