package eu.xenit.de.example;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * The component name must match the delegate expression in the workflow definition.
 *
 * @author Laurent Van der Linden
 */
@Component("example.dynamicextensions.testTask")
public class ExampleWorkflowTask implements JavaDelegate {

    public void execute(DelegateExecution execution) {
        execution.setVariable("wf_review_comment", "Processed by ServiceTask");
    }
}
