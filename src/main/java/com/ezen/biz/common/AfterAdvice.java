package com.ezen.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	//포인트컷 선언
//		@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//			public void allPointcut() {
//			
//		}
	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 무조건 수행...");
	}
}
