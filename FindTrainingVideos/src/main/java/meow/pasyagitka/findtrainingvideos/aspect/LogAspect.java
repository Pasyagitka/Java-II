package meow.pasyagitka.findtrainingvideos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

@Aspect
@Component
public class LogAspect {
    Logger logger=Logger.getLogger(LogAspect.class);

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.DisciplineController.*(..))")
    public void callAtDisciplineController() {}

    @Before("callAtDisciplineController()")
    public void beforeCallMethod(JoinPoint jp) {logger.info("before " + jp.toString());}

    @After("callAtDisciplineController()")
    public void afterCallAt(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }
}
