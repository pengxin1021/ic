package com.ic.service.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class DubboStartService {

	private static DubboStartService ourInstance = new DubboStartService();
	
	private static ClassPathXmlApplicationContext context = null;
	
	private DubboStartService() {
		
	}
	
	public static DubboStartService getInstance() {
		return ourInstance;
	}
	
	public static void main(String[] args) throws InterruptedException {
		String configLocation = null;
		if(args != null && args.length > 0) {
			configLocation = args[0];
		}
		if(StringUtils.isEmpty(configLocation)) {
			configLocation = "classpath:application-dubbo-provider.xml";
		}
		DubboStartService.getInstance().start(configLocation);
		
		System.out.println("[ service started ]");
		while (true) {
			Thread.sleep(1000);
		}
	}
	
	private synchronized void start(String configLocation) {
		if(context == null) {
			context = new ClassPathXmlApplicationContext(configLocation);
			context.start();
		}
	}
}
