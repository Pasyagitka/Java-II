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
    public void beforeCallDiscipline(JoinPoint jp) {logger.info("before " + jp.getSignature());}
    @After("callAtDisciplineController()")
    public void afterCallDiscipline(JoinPoint jp) {
        logger.info("after " + jp.getSignature());
    }


    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.UserController.*(..))")
    public void callAtUserController() {}
    @Before("callAtUserController()")
    public void beforeCallUser(JoinPoint jp) {logger.info("before " + jp.getSignature());}
    @After("callAtUserController()")
    public void afterCallUser(JoinPoint jp) { logger.info("after " + jp.getSignature());}




    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.getVideos(..))")
    public void callAtAdminControllerGetVideos() {}
    @After("callAtAdminControllerGetVideos()")
    public void afterCallGetVideos(JoinPoint jp)  {logger.info("Getting list of all videos: " + jp.getSignature());}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.saveVideo(..))")
    public void callAtAdminControllerSaveVideo() {}
    @After("callAtAdminControllerSaveVideo()")
    public void afterCallSaveVideo(JoinPoint jp)  {logger.info("Video is added: " +  jp.getSignature());}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.updateVideo(..))")
    public void callAtAdminControllerUpdateVideo() {}
    @After("callAtAdminControllerUpdateVideo()")
    public void afterCallUpdateVideo(JoinPoint jp)  {logger.info("Video is edited: " +  jp.getSignature());}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.deleteVideo(..))")
    public void callAtAdminControllerDeleteVideo() {}
    @After("callAtAdminControllerDeleteVideo()")
    public void afterCallDeleteVideo(JoinPoint jp)  {logger.info("Video is deleted: " +  jp.getSignature());}
}
