package com.home.msite.utilities;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Executor {
		
	public static String tagName = "Executor";
	
	@SuppressWarnings({ "unlikely-arg-type" })
	public static Response run(API api) {
		Response res = null ;
		RequestSpecification rs =RestAssured.given();
		if(api.getConfig()!=null) {
			rs = rs.config(api.getConfig());
		}
		if(api.getMethod().equals(Method.GET)) {
			res = rs.headers(api.getHeaders()).formParams(api.getFormParam()).queryParams(api.getQueryParam()).relaxedHTTPSValidation().when().get(api.getUrl());
		}
		if(api.getMethod().equals(Method.POST)) {
			if(api.getBody()==null|| api.getBody().equals(""))
			{
				res = rs.headers(api.getHeaders()).formParams(api.getFormParam()).relaxedHTTPSValidation().post(api.getUrl()).then().extract().response();
			}
			else  
				res = rs.headers(api.getHeaders()).urlEncodingEnabled(false).config(RestAssured.config()
		                .encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)
		                        .encodeContentTypeAs("application/octet-stream", ContentType.TEXT))).
body(api.getBody()).request().relaxedHTTPSValidation().post(api.getUrl()).then().extract().response();
		}
		return res;
	}
	
	
	
}


