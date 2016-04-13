
    /**  
    * @Title: RestTemplate.java
    * @Package com.harvey.learn
    * @Description: TODO(用一句话描述该文件做什么)
    * @author rose
    * @Email  rose@maizuo.com
    * @date 2016年3月30日
    * @version V1.0  
    */
    
package com.harvey.learn;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;


    /**
 * @ClassName: RestTemplate
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author rose
 * @Email  rose@maizuo.com
 * @date 2016年3月30日
 *
 */

public class RestTemplateTest {
	
	
	@Test
	public void testA(){
		RestTemplate rest = new RestTemplate();
		String url = "http://test.maizuo.com/test/testPost";
		URI uri = null;
		try {
			uri = new URI("http://test.maizuo.com/test/testPost");
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MultiValueMap<String,String> map = new LinkedMultiValueMap<String,String>();
		map.add("name","harvey");
		map.add("salary","10000");
		map.add("Content-Type", "application/json");
		Gson gson = new Gson();
		String req = gson.toJson(map);
		String res = rest.postForObject(url, req, String.class);
		System.out.println(gson.toJson(res));
	}
}
