package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..) )")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..) )")
	private void getter() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..) )")
	private void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>>> Executing @Before advice on addAccount()");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>>> Perfoming Api analytics");
	}

}
