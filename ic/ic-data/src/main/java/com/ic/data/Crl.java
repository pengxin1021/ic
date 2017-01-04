package com.ic.data;

import java.util.HashMap;
import java.util.Map;

public class Crl {

	protected Map<String, String> getHeaders(String host, String cookie) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		headers.put("Accept-Encoding", "gzip, deflate, br");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		headers.put("Connection", "keep-alive");
		headers.put("Host", host);
		headers.put("Cookie", cookie);
		headers.put("Referer", "https://shopsearch.taobao.com/search?app=shopsearch&q=%E5%A5%B3%E8%A3%85&tracelog=shopsearchnoqcat");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
		return headers;
	}
}
