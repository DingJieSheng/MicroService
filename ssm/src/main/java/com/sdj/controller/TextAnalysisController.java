package com.sdj.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.sdj.bean.Msg;

@Controller	
public class TextAnalysisController {
	
	/**
	 * Զ�̵���΢��������ı���з���
	 */
	@RequestMapping("/analysis")
	@ResponseBody
	public Msg textAnalysis(@RequestParam(value = "text")String text) {
		System.out.println(text);
		String url = "http://172.16.62.164:8050/sidecar-textanalysis/analysis/";
		RestTemplate resttemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
//        headers.add(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, accessToken.getValue()));
//		��json��ʽ�����ݣ�django����post.get()������ȡ�������ݡ�
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", text);
        String jsonObj = jsonObject.toJSONString();
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonObj, headers);
        //3.����base�ӿڻ�ȡ����baseUrl + BASE_URI
//        ResponseEntity<String> response = resttemplate.postForEntity(url, requestEntity, String.class);
        
//        try {
//            // ������
//        	resttemplate.setErrorHandler(new CustomResponseErrorHandler());
        ResponseEntity<String> response = resttemplate.postForEntity(url, requestEntity, String.class);
//	    }catch (CustomException e) {
//	         e.printStackTrace();
//	         System.out.println(e.getBody());
//	          System.out.println(e.getMessage());
//	    }
//        System.out.println("analysis");
        if (response.getStatusCode().is2xxSuccessful()) {
        	Map<String, Integer> resultMap = new HashMap<>();
        	JSONObject object = JSONObject.parseObject(response.getBody());
//        	String resultString = response.getBody();
        	return Msg.success().add("resultMap", object);
        }
        return Msg.fail();
	}
}


class CustomResponseErrorHandler implements ResponseErrorHandler {

  private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();
   @Override
  public void handleError(ClientHttpResponse response) throws IOException {

// ������ͷ�Ĵ���
    List<String> customHeader = response.getHeaders().get("x-app-err-id");

    String svcErrorMessageID = "";
    if (customHeader != null) {
      svcErrorMessageID = customHeader.get(0);
    }
//��body �Ĵ��� (inputStream)
    String body = convertStreamToString(response.getBody());

    try {

      errorHandler.handleError(response);

    } catch (RestClientException scx) {

      throw new CustomException(scx.getMessage(), scx, body);
    }
  }
   @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return errorHandler.hasError(response);
  }

// inputStream װ��Ϊ string 
  private String convertStreamToString(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return sb.toString();
  }
}

class CustomException extends RestClientException {

  private RestClientException restClientException;
  private String body;

  public RestClientException getRestClientException() {
    return restClientException;
  }

  public void setRestClientException(RestClientException restClientException) {
    this.restClientException = restClientException;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


  public CustomException(String msg, RestClientException restClientException, String body) {
    super(msg);
    this.restClientException = restClientException;
    this.body = body;
  }

}
