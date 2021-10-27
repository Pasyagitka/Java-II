package meow.pasyagitka.findtrainingvideos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LogAspect {
    Logger logger=Logger.getLogger(LogAspect.class);

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.DisciplineController.*(..))")
    public void callAtDisciplineController() {
    }

    @Before("callAtDisciplineController()")
    public void beforeCallMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs()).map(a -> a.toString()).collect(Collectors.joining(","));
        logger.info("before " + jp.toString() + ", args=[" + args + "]");
    }
    @After("callAtDisciplineController()")
    public void afterCallAt(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }

}
