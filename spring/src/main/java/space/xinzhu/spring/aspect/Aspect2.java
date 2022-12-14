package space.xinzhu.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
@Order(3)
@Component // 写切面. 切面类也需要配合组件扫描被 Spring 管理起来
@Aspect // 写切面. 标注此类是一个切面类
public class Aspect2 {

    private static final Logger log = LoggerFactory.getLogger(Aspect2.class);

    // 例5 匹配【注解信息】
    @Pointcut("@annotation(space.xinzhu.spring.aspect.Log)")
    public void pt5() {
    }

    //@Pointcut("@annotation(space.xinzhu.spring.aspect.Log)")
    //public void pt4() {
    //}

    @Before("pt5()")
    public void before() {
        log.info("Aspect2.before...");
    }

    @After("@annotation(logObj)")
    public void after(Log logObj){
        log.info("after...{}",logObj.value());
    }

    //@AfterThrowing()
    //public void afterThrowing(){}

    //@AfterReturning
}