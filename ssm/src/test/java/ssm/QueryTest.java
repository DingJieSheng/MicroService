package ssm;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

import org.apache.ibatis.mapping.ParameterMapping;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.sdj.bean.EmotionText;

/**
 * ʹ��spring����ģ���ṩ�Ĳ��������ܣ��������ݿ�����
 * @author A
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","file:WebContent/WEB-INF/dispatcherServlet-servlet.xml"})
public class QueryTest {
//	����springMvc��IOC
	@Autowired
	WebApplicationContext context;
//	����mvc���󣬻�ȡ������
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testQuery() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/searchtext").param("page", "1")).andReturn();
		
//		����ɹ����������л���pageinfo��ȡ�����е�pageinfo������֤
		PageInfo pageInfo = (PageInfo)result.getRequest().getAttribute("pageinfo");
		System.out.println("��ǰҳ�룺"+pageInfo.getPageNum());
		System.out.println("��ҳ�룺"+pageInfo.getPages());
		System.out.println("�ܼ�¼����"+pageInfo.getTotal());
		System.out.println("������ʾ��ҳ����");
		Arrays.stream(pageInfo.getNavigatepageNums())
				.forEach(i -> System.out.println(i));
		
//		��ȡ�ı�����
		List<EmotionText> list = pageInfo.getList();
		list.stream()
			.forEach(obj -> System.out.println("EmotionLabel:"+obj.getEmotionlabel()+"   Textcontent:"+obj.getTextcontent()));
	}
	
}
