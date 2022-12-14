package space.xinzhu.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
public class Aspect3 {

    private static final Logger log = LoggerFactory.getLogger(Aspect2.class);

    @Around("execution(* space.xinzhu.spring.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        log.info("開始執行");
        // 调目标. pjp.proceed() 即表示调用目标方法
        Object result = pjp.proceed();

        long end = System.nanoTime();
        log.info("cost time: {} ns", (end - start));
        log.info("結束任務");
        return result;
    }
}
