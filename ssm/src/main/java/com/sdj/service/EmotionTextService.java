package com.sdj.service;

import com.sdj.bean.EmotionText;
import com.sdj.bean.EmotionTextExample;
import com.sdj.dao.EmotionTextMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionTextService {
	
	@Autowired
	EmotionTextMapper emotionTextMapper;
	/**
	 * 查询所有文本
	 * @return
	 */
	public List<EmotionText> getAll() {
		// TODO Auto-generated method stub
		return emotionTextMapper.selectByExample(null);
	}
	
	/**
	 * 查询单个文本具体信息
	 * @return
	 */
	public List<EmotionText> getTextInfo(Integer textID) {
		// TODO Auto-generated method stub
		EmotionTextExample emotionTextExample = new EmotionTextExample();
		emotionTextExample.createCriteria().andIdEqualTo(textID);
		List<EmotionText> result = emotionTextMapper.selectByExample(emotionTextExample);
		return result;
	}
	
	/**
	 * 插入单个文本
	 * @return
	 */
	public int insertText(String text, Integer label, Integer isnew) {
		// TODO Auto-generated method stub
		EmotionText emotionText = new EmotionText();
		emotionText.setEmotionlabel(label);
		emotionText.setIsnew(isnew);
		emotionText.setTextcontent(text);
		int result = emotionTextMapper.insertSelective(emotionText);	
		return 1;
	}

}
