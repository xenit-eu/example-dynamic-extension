package com.github.dynamicextensionsalfresco.examples;

import com.github.dynamicextensionsalfresco.jobs.ScheduledQuartzJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Run a Quartz job every 15 seconds.
 * (compatible with JMX and enterprise dashboard)
 * @author Laurent Van der Linden.
 */
@Component
@ScheduledQuartzJob(name = "sample", cron = "0/15 * * * * ?")
public class ScheduledJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("cron execution");
    }
}
