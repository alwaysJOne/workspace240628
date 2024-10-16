package com.kh.aop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * - Aspect : 해당 클래스가 Aspect(aop객체)라는 것을 선언
 * - Component : Spring이 해당 빈을 서칭할 수 있도록 선언 (Bean등록)
 */

@Slf4j
@Aspect
@Component
public class LoggingAOP {
	
	/*
	 * <시점>
	 * @Before : 대상메서드 실행 전에 Advice(추가기능)가 실행된다.
	 * 
	 * @After : 대상메서드 실행 후에 Advice(추가기능)가 실행된다.
	 * 
	 * @AfterReturning : 대상 메서드가 정상적으로 반환된 후에 Advice(추가기능)가 실행된다.
	 * 
	 * @AfterThrowing : 대상 메서드가 예외를 던진 후에 Advice(추가기능)가 실행된다.
	 * 
	 * @Around : 대상메서드를 감싸서 메서드 호출 전후에 Advice를 실행할 수 있다.
	 */
	
	/*
	 * <대상>
	 * target : 특정 인터페이스와 그 자식클래스
	 * within : 특정 패키지 또는 클래스
	 * execution : 표현식으로 형태지정
	 */
	
	//특정 메서드나 패키지등의 join point
	//com.kh아래 모든 controller패키지 하위 클래스의 모든 메서드에 전부 적용하겠다고 지점 설정.
	@Pointcut("execution(* com.kh.etc.aoptest.*.*(..) )")
	private void cut() {};
	
	//cut메서드가 실행되는 지점 이전에 before()메서드를 실행
	//JoinPoint : pointcut지점에 대한 정보가 들어있다.
	//메서드의 실행이 가장 일반적인 joinpoint다
	@Before("cut()")
	public void before(JoinPoint joinPoint) {
		
		//실행되는 메서드의 이름을 가져오기
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		Object[] args = joinPoint.getArgs();
		log.info("========================= START ============================");
		log.info("----------------------API Controller----------------");
		log.info("Information		:	" + methodSignature);
		log.info("Method Name		:	" + method);
		log.info("Parameter			:	" + Arrays.toString(args));
	}
	
	@AfterReturning(value="cut()", returning= "obj")
	public void afterReturn(JoinPoint joinPoint, Object obj) {
		log.info("=========================  END  ============================");
		log.info("Object     : " + obj);
	}
	
	//api시간측정
	@Around("cut()")
	public Object displayLogInfo(ProceedingJoinPoint joinPoint) throws Throwable {
		//실행전 서버 시간
		long start = System.currentTimeMillis(); // 0
		
		//실행하려던 joinpoint메서드 실행
		Object result = joinPoint.proceed(); //원래 진행중이던 작업 진행
		
		//실행후 서버 시간
		long end = System.currentTimeMillis(); // 1000
		
		long runTime = end - start; //실행시간
		
		log.info("---------------------------------------------------------------");
		log.info("Information		: " + joinPoint.getSignature());
		log.info("Processing Time   : " + runTime + "ms");
		
		return result;
	}

}
