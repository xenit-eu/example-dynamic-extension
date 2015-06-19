package com.github.dynamicextensionsalfresco.examples;

import org.alfresco.service.cmr.repository.NodeService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.dynamicextensionsalfresco.jobs.ScheduledQuartzJob;

/**
 * New Quartz support coming to Dynamic extensions 1.3
 * @author Laurent Van der Linden
 */
@Component
@ScheduledQuartzJob(name = "test", cron = "0 * * * * ?", group = "demo")
public class ScheduledDummyJob implements Job {
	private final Logger logger = LoggerFactory.getLogger(ScheduledDummyJob.class);

	@Autowired
	NodeService nodeService;

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		logger.warn("executed ScheduledDummyJob with a reference to the " + nodeService);
	}
}
