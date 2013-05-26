package nl.runnable.alfresco.examples;

import java.io.IOException;

import javax.annotation.Resource;

import nl.runnable.alfresco.webscripts.annotations.Uri;
import nl.runnable.alfresco.webscripts.annotations.WebScript;

import org.alfresco.repo.transaction.RetryingTransactionHelper;
import org.alfresco.repo.transaction.RetryingTransactionHelper.RetryingTransactionCallback;
import org.springframework.context.ApplicationContext;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.springframework.stereotype.Component;

/**
 * Example that illustrates injecting dependencies from the Alfresco ApplicationContext by name.
 * <p>
 * Normally dependencies are injected by interface type. However, some specialized use cases call for injecting
 * dependencies on specific beans from the Alfresco application context. In this case you can refer to them explicitly
 * by bean name.
 * <p>
 * Dynamic Extensions 1.0 milestone 4 expands on the support for injecting named dependencies, by looking up the beans
 * directly in the Alfresco {@link ApplicationContext}. This removes the need for them to be declared as an OSGi
 * service.
 * 
 * @author Laurens Fridael
 * 
 */
@Component
@WebScript
public class NamedDependencyInjectionExample {

  /**
   * Inject a named bean from the Alfresco main ApplicationContext using the {@link Resource} annotation.
   * <p>
   * In this case we are looking for the {@link RetryingTransactionHelper} named
   * <code>web.retryingTransactionHelper</code> defined in <code>alfresco/core-services-context.xml</code>.
   */
  @Resource(name = "web.retryingTransactionHelper")
  private RetryingTransactionHelper retryingTransactionHelper;

  @Uri("/dynamic-extensions/examples/transaction")
  public void transaction(final WebScriptResponse response) throws IOException {
    performReadonlyTransaction();
    response.getWriter().write("Performed a read-only transaction operation.");
  }

  private void performReadonlyTransaction() {
    retryingTransactionHelper.doInTransaction(new RetryingTransactionCallback<Void>() {

      public Void execute() throws Throwable {
        return null;
      }
    }, true, true);
  }
}
