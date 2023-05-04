package com.ezen.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	// 포인트컷 선언
	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
	public void allPointcut() {

	}

	// 포인트컷 선언
	@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))")
	public void getPointcut() {

	}
	
	
}
