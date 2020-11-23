package com.home.msite.utilities;

/**
 * @author rajesh.kulkarni
 *
 */
public enum Method {
	
		GET("GET"), 
		POST("POST"),
		PATCH("PATCH"),
		PUT("PUT"),
		DELETE("DELETE");

		private String method;

		Method(String method) {
			this.method = method;
		}

		public String getUrl() {
			return method;
		}
}
