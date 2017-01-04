package com.ic.base.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpUtils {

	public static Response getHttp(String url) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response;
			}else {
				throw new IOException("Get response unsuccess! response: " + response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
