package notificador;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchedulerJob implements Job {

    private static Logger log = LoggerFactory.getLogger(SchedulerJob.class.getName());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        
        log.info("Iniciando Metodo execute info: ");
        AppMail appMail = new AppMail();
        appMail.sendMail();
        System.out.println("Probando envio de Correo");
    }

}
