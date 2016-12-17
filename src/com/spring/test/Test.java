package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.contoller.UserController;
import com.spring.vo.User;

public class Test {
	
	/**
	 * Spring AOP 使用方法
	 * 1、spring的xml文件中引入 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	 * 2、使用AspectJ
	 * 	  2.1由于sping3.0之后不集成aspjectj的包了，所以需要另外下载aspjectj的包
	 *    地址：http://www.eclipse.org/aspectj/（其实就是eclipse个网 -_-||| ）
	 * 3、在需要aop通知的类中加入@Aspect注解(扩展：如果有多个通知可以用@Order来指定顺序)
	 *  3.1通知一共有5种
	 *     前置通知：@before
	 * 	   后置通知：@After 后置通知 (即使有无异常都回执行，大致上等于java里的finally块)
	 *     返回通知：@AfterReturning 相当于调用方法成功获取到返回值
	 *     异常通知：@AfterThrowing 运行异常触发一下事件，大致相当于catch块
	 *     环绕通知：@Around 是上面4种通知的完整版本，能够实现上面所有通知功能，参数使用proceedingJoinPoint
	 *  3.2注解中用 (value="execution(返回类型 包名.类名.方法名(参数类型))")
	 *     例如：@After(value="execution(* com.text.UserCtrl(..))")
	 *     其中afterreturning需要指定returning（可以填写参数中的参数名）
	 *        afterthrowing需要指定throwing
	 *  3.3前四个通知可以用Joinpoint 获取调用方法的相关参数
	 *     而Around则可以使用ProceedingJoinPoint
	 *     
	 * 4、扩展(切点概念)参考JoinPointTest  
	 * 		指定切点 @Pointcut(value = "execution(* com.spring.contoller.UserController.*(..))") public void customerJoinPoint() { }
	 *  	重用切点 @Before(value="customerJoinPoint()")
	 * @param args
	 */
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//通过springioc获取bean
		UserController ctrl = (UserController) ctx.getBean("userController");
		//调用bean方法
		ctrl.saveUser(new User("Super Man", 20));
		//测试异常通知：ctrl.saveUser(new User("Super Man", 20));
	}
}
