package com.example.springbootDemo.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class PermissionAspect {
    /**
     * 选取切入点为自定义注解
     */
    @Pointcut("@annotation(com.example.springbootDemo.service.aspect.PermissionCheck)")
    public void permissionCheck(){}

    /**
     * 在切入点业务逻辑执行前进行操作
     * @param joinPoint
     */
    @Before(value = "permissionCheck();")
    public void before(JoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature(); //获取连接点的方法签名对象
        if (!(signature instanceof MethodSignature)){
            throw new PermissionCheckException("user permission check fail,stop this request!");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Object target = joinPoint.getTarget();
        Method method = target.getClass().getDeclaredMethod(methodSignature.getName(),methodSignature.getParameterTypes());//获取到当前执行的方法
        PermissionCheck annotation = method.getAnnotation(PermissionCheck.class);//获取方法的注解
        System.out.println(annotation);
        System.out.println(annotation.value());
        System.out.println("我是在执行业务逻辑之前");
    }

    /**
     * 在业务逻辑执行后进行的操作
     * @param joinPoint
     */
    @After(value = "permissionCheck();")
    public void after(JoinPoint joinPoint) throws NoSuchMethodException {
        System.out.println("我是在执行业务逻辑后");
    }

    @Around(value = "permissionCheck();")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around方法执行前1");
        Object proceed = joinPoint.proceed();
        System.out.println("around方法执行前2");
        System.out.println("proceed:"+proceed.toString());
        return proceed;
    }
}
