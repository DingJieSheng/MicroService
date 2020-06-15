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
////    请求前预先过滤
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE;
//    }
////    过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
// 
////   设置为true则会执行过滤器，即下面的run方法。
//    public boolean shouldFilter() {
//    	// TODO Auto-generated method stub
//    	return false;
//    }
//    
//    
//    /**
//     * 过滤器的具体逻辑。这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
//     * 然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，当然也可以进 一步优化我们的返回，
//     * 比如，通过ctx.setResponseBody(body)对返回的body内容进行编辑等。
//     */
//  
//    public Object run() {
//        //获取上下文
//        RequestContext ctx = RequestContext.getCurrentContext();
//        //获取Request
//        HttpServletRequest request = ctx.getRequest();
//        //获取请求参数accessToken
//        String accessToken = request.getParameter("accessToken");
//        //使用String工具类
//        if (StringUtils.isBlank(accessToken)) {
//            log.warn("accessToken is empty");
//            ctx.setSendZuulResponse(false);  //进行拦截
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