package com.home.msite.utilities;

import java.util.HashMap;
import java.util.Map;

import io.restassured.config.RestAssuredConfig;



public class API {
	Method method;
	RestAssuredConfig config = null;
    Map<String, String> headers = new HashMap<String, String>();
    Map<String, String> queryParam = new HashMap<String, String>();
    Map<String, String> formParam = new HashMap<String, String>();
    String url;
    String body = "";
    
	public API(Method method, Map<String, String> headers, Map<String, String> queryParam, String url,String body) {
		super();
		this.method = method;
		if(headers!=null)
			this.headers = headers;
		if(queryParam!=null)
			this.queryParam = queryParam;
		this.url = url;
		if(body!=null)
			this.body = body;

	}
	
	public API(Method method, Map<String, String> headers,Map<String, String> formParam, Map<String, String> queryParam, String url,
			String body) {
		super();
		this.method = method;
		if(headers!=null)
			this.headers = headers;
		if(queryParam!=null)
			this.queryParam = queryParam;
		if(formParam!=null)
			this.formParam = formParam;
		this.url = url;
		if(body!=null)
			this.body = body;
	}
	
	public API() {
		// TODO Auto-generated constructor stub
	}
	
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public RestAssuredConfig getConfig() {
		return config;
	}
	public void setConfig(RestAssuredConfig config) {
		this.config = config;
	}	
	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(Map<String, String> queryParam) {
		this.queryParam = queryParam;
	}

	public Map<String, String> getFormParam() {
		return formParam;
	}

	public void setFormParam(Map<String, String> formParam) {
		this.formParam = formParam;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		try {
	        return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
	    } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
