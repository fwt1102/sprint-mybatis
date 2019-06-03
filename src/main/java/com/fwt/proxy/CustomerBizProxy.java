package com.fwt.proxy;


import com.fwt.pojo.UserInfo;


import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.Log;

import java.util.List;
@Component
@Aspect
public class CustomerBizProxy {

    @Pointcut( value = "execution(* com.fwt.service.impl.UserInfoServiceImpl.selectAllUser(..))")
    public void point(){
     }
     @Before(value = "point()")
     public void Begin(){
         System.out.println("开始连接");
     }
     @After(value= "point()")
     public void end(){
         System.out.println("结束连接");
     }
     @AfterReturning(value = "point()")
     public void afterReturning(){
         System.out.println("数据返回之后调用");
     }
     @Around(value="point()")
     public void around(ProceedingJoinPoint joinPoint) throws Throwable {
         System.out.println("开始环绕");
         //可以对proceed事务结果进行处理

                 joinPoint.proceed();

         System.out.println("结束环绕");
     }
     @AfterThrowing(value = "point()")
     public  void throwException(){
         System.out.println("模拟异常");
     }




}
