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
//// ------------------------------��Ϊ��ͳ��Ԫ����ģʽ------------------------------------
////		1.����springIOC����
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
////		2.�������л�ȡBean
//		EmotionTextMapper emotionTextMapper = ioc.getBean(EmotionTextMapper.class);

		
//		------------------------����Ϊspring��Ԫ����-------------------------------
//		System.out.println(emotionTextMapper);
		
//		EmotionTextExample emotionTextExample = new EmotionTextExample();
//		emotionTextExample.createCriteria().andIdEqualTo(50);
//		List<EmotionText> result = emotionTextMapper.selectByExample(emotionTextExample);
//		System.out.println(result.get(0).toString());
		
		EmotionText emotionText = new EmotionText();
		emotionText.setEmotionlabel(1);
		emotionText.setIsnew(1);
		emotionText.setTextcontent("�����������ҵĲ��Ǹ������ж�˧����������ĺ�����ò�������׺����������ܶ����ڻ�������Ƶ���Դ���˿һ�����Ӷ�û�У��������������һ����");
		int res = emotionTextMapper.insertSelective(emotionText);
		System.out.println(emotionText.getId());
	}

}
