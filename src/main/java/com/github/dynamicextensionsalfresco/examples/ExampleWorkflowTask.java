package com.github.dynamicextensionsalfresco.examples;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * The component name must match the taskId variable in the workflow definition.
 * @author Laurent Van der Linden
 */
@Component("example.dynamicextensions.testTask")
public class ExampleWorkflowTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("wf_review_comment", "Processed by ServiceTask");
    }
}
