package ex0926.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
	Log log = LogFactory.getLog(super.getClass());
				
	public static void main(String[] args) {
		System.out.println("-----------Log Test 시작합니다--------");
		
		new LogTest().test();
		
		
		System.out.println("-----------Log Test 끝입니다--------");
	}
	public void test() {
		log.trace("trace관련 log입니다");
		log.debug("debug관련 log입니다");
		log.info("info관련 log입니다");
		log.error("error관련 log입니다");
		log.warn("warn관련 log입니다");
		log.fatal("fatal관련 log입니다");
	}

}
