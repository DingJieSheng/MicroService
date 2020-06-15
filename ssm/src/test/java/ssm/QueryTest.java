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
 * 使用spring测试模块提供的测试请求功能，测试数据库请求
 * @author A
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","file:WebContent/WEB-INF/dispatcherServlet-servlet.xml"})
public class QueryTest {
//	传入springMvc的IOC
	@Autowired
	WebApplicationContext context;
//	虚拟mvc请求，获取处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testQuery() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/searchtext").param("page", "1")).andReturn();
		
//		请求成功后，请求域中会有pageinfo，取出其中的pageinfo进行验证
		PageInfo pageInfo = (PageInfo)result.getRequest().getAttribute("pageinfo");
		System.out.println("当前页码："+pageInfo.getPageNum());
		System.out.println("总页码："+pageInfo.getPages());
		System.out.println("总记录数："+pageInfo.getTotal());
		System.out.println("连续显示的页数：");
		Arrays.stream(pageInfo.getNavigatepageNums())
				.forEach(i -> System.out.println(i));
		
//		获取文本数据
		List<EmotionText> list = pageInfo.getList();
		list.stream()
			.forEach(obj -> System.out.println("EmotionLabel:"+obj.getEmotionlabel()+"   Textcontent:"+obj.getTextcontent()));
	}
	
}
