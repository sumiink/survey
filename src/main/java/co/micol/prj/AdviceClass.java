package co.micol.prj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdviceClass {
	
	@Pointcut("execution(* co.micol.prj..*Impl.*(..))")
	public void targetMethod() {
		 
	}
	@Before("targetMethod()")
	public void jointBeforeMethod() {
		System.out.println("===핵심기능이 시작되었습니다.");
	}
	
	@After("targetMethod()")
	public void jointAfterMethod() {
		System.out.println("==핵심기능이 수행 완료되었습니다.");
	}
	
}
