package com.swamy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class LoggingAspect {

	private ObjectMapper objectMapper;

	@Around(value = "execution(* com.swamy.controller.EmployeeRestController.*(..))")
	public Object aroundAdviceForController(ProceedingJoinPoint joinPoint) throws Throwable {

		String methodName = joinPoint.getSignature().getName();

		String className = joinPoint.getTarget().getClass().toString();

		Object[] args = joinPoint.getArgs();

		log.info("Invoked : " + className + " : " + methodName + "() " + "Arguments : "
				+ objectMapper.writeValueAsString(args));

		Object object = joinPoint.proceed();

		log.info("Returning Back From : " + className + " : " + methodName + "() " + "Response :"
				+ objectMapper.writeValueAsString(object));

		return object;
	}

	@Around(value = "execution(* com.swamy.service.EmployeeService.*(..))")
	public Object aroundAdviceForService(ProceedingJoinPoint joinPoint) throws Throwable {

		String methodName = joinPoint.getSignature().getName();

		String className = joinPoint.getTarget().getClass().toString();

		Object[] args = joinPoint.getArgs();

		log.info("Invoked : " + className + " : " + methodName + "() " + "Arguments : "
				+ objectMapper.writeValueAsString(args));

		Object object = joinPoint.proceed();

		log.info("Returning Back From : " + className + " : " + methodName + "() " + "Response :"
				+ objectMapper.writeValueAsString(object));

		return object;
	}
}
