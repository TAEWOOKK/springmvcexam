package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {

	// 포인트컷 선언
//	@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))")
//	public void getPointcut() {
//
//	}

	@AfterReturning(pointcut = "PointcutCommon.getPointcut()",returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName(); // 메소드명

		System.out.printf("[사후처리] %s(), 리턴값: %s\n", method, returnObj.toString());
	}
}
