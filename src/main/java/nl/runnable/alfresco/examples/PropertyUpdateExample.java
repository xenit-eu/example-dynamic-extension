package nl.runnable.alfresco.examples;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.alfresco.repo.node.NodeServicePolicies;
import org.alfresco.repo.node.NodeServicePolicies.OnUpdatePropertiesPolicy;
import org.alfresco.repo.policy.Behaviour;
import org.alfresco.repo.policy.Behaviour.NotificationFrequency;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;

/**
 * Example of an {@link OnUpdatePropertiesPolicy} that outputs a simple message every time the properties of a node have
 * updated.
 * 
 * @author Laurens Fridael
 * 
 */
public class PropertyUpdateExample implements NodeServicePolicies.OnUpdatePropertiesPolicy {

	/**
	 * The {@link PolicyComponent} that gets injected here is actually an intercepting proxy that, in turn, generates
	 * proxy {@link Behaviour}s.
	 */
	@Inject
	private PolicyComponent policyComponent;

	/**
	 * Use the {@link PostConstruct} annotation to trigger this method on initialization.
	 * <p>
	 * There is nothing particularly special about this code; this is how you would normally register a
	 * {@link Behaviour}. However, the underlying {@link PolicyComponent} wraps a proxy around the {@link JavaBehaviour}
	 * that you're passing in here. This proxy {@link Behaviour} maintains a reference to the original {@link Behaviour}
	 * . This reference is automatically cleared by clean-up code when the extension is undeployed. As Dynamic
	 * Extensions can be redeployed or undeployed throughout the lifetime of the host application, it is essential that
	 * object references are properly cleared. The drawback to this approach is that empty, no-op proxies remain in
	 * memory when you undeploy an extension.
	 * <p>
	 * And in case you're wondering why we would need such a complex solution: the {@link PolicyComponent} interface
	 * does not offer any "unbind" methods.
	 * <p>
	 * Future revisions will offer an annotation-based approach to creating {@link Behaviour}s that prevents memory
	 * leaks by handling the routing to the behaviour handling code itself.
	 */
	@PostConstruct
	protected void bindBehaviours() {
		policyComponent.bindClassBehaviour(OnUpdatePropertiesPolicy.QNAME, this, new JavaBehaviour(this,
				"onUpdateProperties", NotificationFrequency.TRANSACTION_COMMIT));
	}

	public void onUpdateProperties(final NodeRef nodeRef, final Map<QName, Serializable> before,
			final Map<QName, Serializable> after) {
		System.out.println(String.format("Updating node properties for \"%s\" from %s to %s", nodeRef, before, after));
	}

}
