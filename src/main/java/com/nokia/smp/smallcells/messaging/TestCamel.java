package com.nokia.smp.smallcells.messaging;

import org.apache.camel.spring.Main;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCamel {

	static Logger logger = LoggerFactory.getLogger(TestCamel.class);
	
	public static void main(String args[]) {
		logger.debug("Starting");
		TestCamel test = new TestCamel(); 
		try {
			test.boot();
		} catch(Exception e) {
			logger.warn("failing loading appcontext", e);
		}
		logger.debug("Finished");
	}
	
	
	public void boot() throws Exception {
		Main main = new Main();
		main.enableHangupSupport();
		main.setApplicationContext(new ClassPathXmlApplicationContext("applicationContext2.xml"));
		main.run();
	}
}
