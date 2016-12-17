package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class JoinPointTest {

	@Pointcut(value = "execution(* com.spring.contoller.UserController.*(..))")
	public void customerJoinPoint() {

	}
	
	@Before(value="customerJoinPoint()")
	public void beforeJoinPoint(){
		System.out.println("before joinpoint test ... ");
	}
}
