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
    public void callAtGeneralController() {}
    @Before("callAtGeneralController()")
    public void beforeCallGeneral(JoinPoint jp) {logger.info("Trying to access: " + jp.getSignature());}
    @AfterReturning("callAtGeneralController()")
    public void afterReturningCallGeneral(JoinPoint jp) {
        logger.info("Success: " + jp.getSignature());
    }
    @AfterThrowing("callAtGeneralController()")
    public void afterThrowingCallGeneral(JoinPoint jp) {
        logger.info("Error " + jp.getSignature());
    }



    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.UserController.*(..))")
    public void callAtUserController() {}
    @Before("callAtUserController()")
    public void beforeCallUser(JoinPoint jp) { logger.info("Trying to access: " + jp.getSignature());}
    @AfterReturning("callAtUserController()")
    public void afterReturningCallUser(JoinPoint jp) { logger.info("Success: " + jp.getSignature());}
    @AfterThrowing("callAtUserController()")
    public void afterThrowingCallUser(JoinPoint jp) { logger.info("Error: " + jp.getSignature());}



    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.*(..))")
    public void callAtAdminController() {}
    @Before("callAtAdminController()")
    public void beforeCallAdmin(JoinPoint jp) { logger.info("Trying to access: " + jp.getSignature());}
    @AfterReturning("callAtAdminController()")
    public void afterReturningCallAdmin(JoinPoint jp) { logger.info("Success: " + jp.getSignature());}
    @AfterThrowing("callAtAdminController()")
    public void afterThrowingCallAdmin(JoinPoint jp) { logger.info("Error: " + jp.getSignature());}



    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.saveVideo(..))")
    public void callAtAdminControllerSaveVideo() {}
    @Before("callAtAdminControllerSaveVideo()")
    public void beforeCallSaveVideo(JoinPoint jp)  {logger.info("Trying to add a video...");}
    @After("callAtAdminControllerSaveVideo()")
    public void afterCallSaveVideo(JoinPoint jp)  {logger.info("Video is added.");}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.updateVideo(..))")
    public void callAtAdminControllerUpdateVideo() {}
    @Before("callAtAdminControllerUpdateVideo()")
    public void beforeCallUpdateVideo(JoinPoint jp)  {logger.info("Trying to edit a video...");}
    @After("callAtAdminControllerUpdateVideo()")
    public void afterCallUpdateVideo(JoinPoint jp)  {logger.info("Video is edited.");}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AdminController.deleteVideo(..))")
    public void callAtAdminControllerDeleteVideo() {}
    @Before("callAtAdminControllerDeleteVideo()")
    public void beforeCallDeleteVideo(JoinPoint jp)  {logger.info("Trying to delete a video...");}
    @After("callAtAdminControllerDeleteVideo()")
    public void afterCallDeleteVideo(JoinPoint jp)  {logger.info("Video is deleted.");}

    @Pointcut("execution(public * meow.pasyagitka.findtrainingvideos.controller.AuthController.*(..))")
    public void callAtAuthController() {}
    @Before("callAtAuthController()")
    public void beforeCallAuth(JoinPoint jp) {logger.info("Trying to access: " + jp.getSignature());}
    @AfterReturning("callAtAuthController()")
    public void afterReturningCallAuth(JoinPoint jp) {
        logger.info("Success: " + jp.getSignature());
    }
    @AfterThrowing("callAtAuthController()")
    public void afterThrowingCallAuth(JoinPoint jp) {
        logger.info("Error " + jp.getSignature());
    }

}
