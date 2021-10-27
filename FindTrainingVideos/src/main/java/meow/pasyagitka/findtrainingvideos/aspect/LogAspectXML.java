package meow.pasyagitka.findtrainingvideos.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LogAspectXML {
    Logger logger=Logger.getLogger(LogAspect.class);

    public void callAtDisciplineController2() {}
    public void aroundGetAllDisciplines(JoinPoint jp) {
        logger.info("aroundGetAllDisciplines " + jp.toString());
    }
    public void afterThrowingGetAllDisciplines(JoinPoint jp) {
        logger.info("afterThrowingGetAllDisciplines" + jp.toString());
    }

}
