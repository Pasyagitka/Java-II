package meow.pasyagitka.findtrainingvideos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    Logger logger=Logger.getLogger(LogAspect.class);

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.GeneralController.*(..))")
    public void callAtDisciplineController() {}
    @Before("callAtDisciplineController()")
    public void beforeCallDiscipline(JoinPoint jp) {logger.info("before " + jp.getSignature());}
    @After("callAtDisciplineController()")
    public void afterCallDiscipline(JoinPoint jp) {
        logger.info("after " + jp.getSignature());
    }


    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.UserController.*(..))")
    public void callAtUserController() {}
    @After("callAtUserController()")
    public void afterCallUser(JoinPoint jp) { logger.info("after " + jp.getSignature());}



    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.*(..))")
    public void callAtAdminController() {}
    @After("callAtAdminController()")
    public void afterCallAdmin(JoinPoint jp) { logger.info("after " + jp.getSignature());}



    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.saveVideo(..))")
    public void callAtAdminControllerSaveVideo() {}
    @Before("callAtAdminControllerSaveVideo()")
    public void beforeCallSaveVideo(JoinPoint jp)  {logger.info("Trying to add a video..." +  jp.getSignature());}
    @After("callAtAdminControllerSaveVideo()")
    public void afterCallSaveVideo(JoinPoint jp)  {logger.info("Video is added: " +  jp.getSignature());}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.updateVideo(..))")
    public void callAtAdminControllerUpdateVideo() {}
    @Before("callAtAdminControllerUpdateVideo()")
    public void beforeCallUpdateVideo(JoinPoint jp)  {logger.info("Trying to edit a video...");}//todo id
    @After("callAtAdminControllerUpdateVideo()")
    public void afterCallUpdateVideo(JoinPoint jp)  {logger.info("Video is edited");}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.deleteVideo(..))")
    public void callAtAdminControllerDeleteVideo() {}
    @Before("callAtAdminControllerDeleteVideo()")
    public void beforeCallDeleteVideo(JoinPoint jp)  {logger.info("Trying to delete a video..." +  jp.getSignature());}
    @After("callAtAdminControllerDeleteVideo()")
    public void afterCallDeleteVideo(JoinPoint jp)  {logger.info("Video is deleted: " +  jp.getSignature());}
}
