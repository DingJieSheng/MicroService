package zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import io.micrometer.core.instrument.util.StringUtils;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApplication {
	
    public static void main(String[] args) {
    	
        SpringApplication.run(ZuulApplication.class, args);
        
    }
    
//    @Bean
//    public AccessFilter accessFilter() {
//        return new AccessFilter();
//    }
    
}


//class AccessFilter extends ZuulFilter {
// 
//    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
// 
////    ����ǰԤ�ȹ���
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE;
//    }
////    ��������ִ��˳�򡣵�������һ���׶��д��ڶ��������ʱ����Ҫ���ݸ÷������ص�ֵ������ִ�С�
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
// 
////   ����Ϊtrue���ִ�й��������������run������
//    public boolean shouldFilter() {
//    	// TODO Auto-generated method stub
//    	return false;
//    }
//    
//    
//    /**
//     * �������ľ����߼�����������ͨ��ctx.setSendZuulResponse(false)��zuul���˸����󣬲��������·�ɣ�
//     * Ȼ��ͨ��ctx.setResponseStatusCode(401)�������䷵�صĴ����룬��ȻҲ���Խ� һ���Ż����ǵķ��أ�
//     * ���磬ͨ��ctx.setResponseBody(body)�Է��ص�body���ݽ��б༭�ȡ�
//     */
//  
//    public Object run() {
//        //��ȡ������
//        RequestContext ctx = RequestContext.getCurrentContext();
//        //��ȡRequest
//        HttpServletRequest request = ctx.getRequest();
//        //��ȡ�������accessToken
//        String accessToken = request.getParameter("accessToken");
//        //ʹ��String������
//        if (StringUtils.isBlank(accessToken)) {
//            log.warn("accessToken is empty");
//            ctx.setSendZuulResponse(false);  //��������
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("accessToken is empty");
//            } catch (Exception e) {
//            }
//            return null;
//        }
//        log.info("access is ok");
//        return null;
//    }
//}