package nl.runnable.alfresco.examples;

import java.io.IOException;

import nl.runnable.alfresco.webscripts.annotations.Uri;
import nl.runnable.alfresco.webscripts.annotations.WebScript;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.springframework.stereotype.Component;

/**
 * Demonstrates how to inject optional dependencies using {@link Autowired}
 * 
 * @author Laurens Fridael
 * 
 */
@Component
@WebScript
public class TestAlfresco4SpecificBeanWebScript {

  @Autowired(required = false)
  private Alfresco4SpecificBean alfresco4SpecificBean;

  @Uri("/dynamic-extensions/examples/test-alfresco-4-bean")
  public void show(final WebScriptResponse response) throws IOException {
    final String message = String.format("Alfresco 4-specific bean available? %s",
        alfresco4SpecificBean != null ? "yes" : "no");
    response.getWriter().write(message);
  }
}
