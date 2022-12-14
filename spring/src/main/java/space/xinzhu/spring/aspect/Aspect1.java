package space.xinzhu.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Order(1)
@Component // 写切面. 切面类也需要配合组件扫描被 Spring 管理起来
@Aspect // 写切面. 标注此类是一个切面类
public class Aspect1 {

    private static final Logger log = LoggerFactory.getLogger(Aspect1.class);
    // 写通知. 标注 @Around 注解的方法称为通知方法，内含增强逻辑
    // 定切点. 最后在 @Around 内书写切点表达式，确定哪些目标方法需要增强
    //execution(@注解? 访问修饰符? 返回值 包名.类名?.方法名(方法参数) throws 异常?)
    @Around("execution(* space.xinzhu.spring.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();

        // 调目标. pjp.proceed() 即表示调用目标方法
        Object result = pjp.proceed();

        long end = System.nanoTime();
        log.info("cost time: {} ns", (end - start));
        return result;
    }

    // 例5 匹配【注解信息】
    @Pointcut("@annotation(space.xinzhu.spring.aspect.Log)")
    public void pt5() {
    }

    @Before("pt5()")
    public void before() {
        log.info("Aspect1.before...");
    }
}