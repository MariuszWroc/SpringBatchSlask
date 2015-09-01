/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.springbatchforslask.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mczarny
 */
public class AppJobStadiumImport {
private final static Logger fLogger = Logger.getLogger("AppJobCityImport");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fLogger.log(Level.INFO, "Import city csv from mysql");
        String[] springConfig
                = {"spring/batch/config/database.xml",
                    "spring/batch/config/context.xml",
                    "spring/batch/jobs/job-stadium-import.xml"
                };

        ApplicationContext context
                = new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobCityLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job cityJob = (Job) context.getBean("stadiumImportJob");

        try {
            JobExecution execution = jobCityLauncher.run(cityJob, new JobParameters());
            fLogger.log(Level.INFO, "Exit Status : {0}", execution.getStatus());
        } catch (JobParametersInvalidException e) {
            e.getMessage();
        } catch (JobExecutionAlreadyRunningException e) {
            e.getMessage();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.getMessage();
        } catch (JobRestartException e) {
            e.getMessage();
        }
        fLogger.log(Level.INFO, "Done");
    }
    
}
