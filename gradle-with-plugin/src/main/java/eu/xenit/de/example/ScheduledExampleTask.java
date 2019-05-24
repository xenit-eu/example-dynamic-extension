package eu.xenit.de.example;

import com.github.dynamicextensionsalfresco.schedule.ScheduledTask;
import com.github.dynamicextensionsalfresco.schedule.Task;
import org.alfresco.service.cmr.repository.NodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Run a Quartz job every 15 seconds. (compatible with JMX and enterprise dashboard)
 *
 * @author Laurent Van der Linden.
 */
@Component
@ScheduledTask(name = "sample", cron = "0/15 * * * * ?")
public class ScheduledExampleTask implements Task {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledExampleTask.class);

    @Autowired
    private NodeService nodeService;

    @Override
    public void execute() {
        logger.info("Executing '{}'", ScheduledExampleTask.class.getCanonicalName());
    }
}
