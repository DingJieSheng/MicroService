package ssm;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sdj.bean.EmotionText;
import com.sdj.bean.EmotionTextExample;
import com.sdj.dao.EmotionTextMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class DaoTest {
	
	@Autowired
	EmotionTextMapper emotionTextMapper;
	
//	@Autowired
//	EmotionTextExample emotionTextExample;
	
	@Test
	public void test() {
//// ------------------------------此为传统单元测试模式------------------------------------
////		1.创建springIOC容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
////		2.从容器中获取Bean
//		EmotionTextMapper emotionTextMapper = ioc.getBean(EmotionTextMapper.class);

		
//		------------------------以下为spring单元测试-------------------------------
//		System.out.println(emotionTextMapper);
		
//		EmotionTextExample emotionTextExample = new EmotionTextExample();
//		emotionTextExample.createCriteria().andIdEqualTo(50);
//		List<EmotionText> result = emotionTextMapper.selectByExample(emotionTextExample);
//		System.out.println(result.get(0).toString());
		
		EmotionText emotionText = new EmotionText();
		emotionText.setEmotionlabel(1);
		emotionText.setIsnew(1);
		emotionText.setTextcontent("最最最吸引我的不是高以翔有多帅，而是他真的很有礼貌，很有亲和力，看过很多他在机场的视频，对待粉丝一点点架子都没有，就像和朋友聊天一样。");
		int res = emotionTextMapper.insertSelective(emotionText);
		System.out.println(emotionText.getId());
	}

}
