package mum.edu.carrentalsystem.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@Aspect
public class LogTraceAdvice {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Before("execution(public * mum.edu.carrentalsystem.controller..*(..))")
	public void beforeTrace(JoinPoint point){
		System.out.println(" I am Here in Before");
		logger.log(Level.INFO, "requesting " + point.getSignature().getName());
	}
	
	@After("execution(public * mum.edu.carrentalsystem.controller..*(..))")
	public void afterTrace(JoinPoint point){
		System.out.println(" I am Here in After");
		logger.log(Level.INFO, "exiting " + point.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "execution(public * mum.edu.carrentalsystem.controller..*(..))", throwing = "exception")
	public void beforeTrace(JoinPoint point, Exception exception){
		
		logger.log(Level.INFO, "An exception occured while executing " + point.getSignature().getName());
		logger.log(Level.ERROR, "Exception Message: " + exception.getMessage() + " \nStackTrace: " +exception.getStackTrace() );
	}

}
