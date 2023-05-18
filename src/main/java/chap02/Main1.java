package chap02;
///lec0518/src/main/java/chap02/Main1.java
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
// 1. ApplicationContext 객체 생성 (컨테이너)
		GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:applicationContext.xml");
// 2. chap02.SystemMonitor객체를 컨테이너에서 조회하여 monitor 변수 저장하기
//		SystemMonitor monitor = new SystemMonitor(); 
		SystemMonitor monitor = ctx.getBean("monitor",SystemMonitor.class);
// 3. monitor 콘솔 출력하기		
		System.out.println(monitor);
		// 스프링 없이 객체 생성하기
		SystemMonitor m = new SystemMonitor();
		m.setPeriodTime(10);
		SmsSender s = new SmsSender();
		m.setSender(s);
		System.out.println(m);
	}

}
