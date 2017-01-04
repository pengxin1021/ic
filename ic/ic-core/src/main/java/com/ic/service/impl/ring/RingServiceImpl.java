package com.ic.service.impl.ring;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.ic.base.utils.HttpRestUtils;
import com.ic.constant.Constant;
import com.ic.constant.ring.RingConstant;
import com.ic.core.util.RingUtil;
import com.ic.service.ring.RingService;

import java.util.HashMap;
import java.util.Map;


@Service
public class RingServiceImpl implements RingService {

	@Override
	public String chat(String info, String userId, String ioc) {
		Map<String, String> json = new HashMap<>();
		json.put(RingConstant.RING_KEY, RingUtil.key);
		json.put(RingConstant.RING_INFO, info);
		json.put(RingConstant.RING_USER_ID, userId);
		json.put(RingConstant.RING_LOC, ioc);
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(json);
		String request = jsonObject.toString();
		try {
			HttpRestUtils.HttpResult result = HttpRestUtils.fetchPostURLContent(RingUtil.url, null, Constant.encoded, false, null, request);
			return result.getResultString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		RingServiceImpl r = new RingServiceImpl();
		System.out.println(r.chat("hello", "1", null));
	}

}
