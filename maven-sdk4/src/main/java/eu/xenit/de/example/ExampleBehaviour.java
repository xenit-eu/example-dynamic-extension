package eu.xenit.de.example;

import com.github.dynamicextensionsalfresco.behaviours.annotations.AssociationPolicy;
import com.github.dynamicextensionsalfresco.behaviours.annotations.Behaviour;
import com.github.dynamicextensionsalfresco.behaviours.annotations.ClassPolicy;
import com.github.dynamicextensionsalfresco.behaviours.annotations.Event;
import java.io.Serializable;
import java.util.Map;
import org.alfresco.repo.node.NodeServicePolicies.OnCreateChildAssociationPolicy;
import org.alfresco.repo.node.NodeServicePolicies.OnUpdatePropertiesPolicy;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Behaviour(value = {"cm:content", "cm:folder"}, event = Event.COMMIT)
@SuppressWarnings("unused")
public class ExampleBehaviour implements OnUpdatePropertiesPolicy, OnCreateChildAssociationPolicy {

    private static final Logger logger = LoggerFactory.getLogger(ExampleBehaviour.class);

    @ClassPolicy(event = Event.FIRST)
    public void onUpdateProperties(final NodeRef nodeRef, final Map<QName, Serializable> before,
            final Map<QName, Serializable> after) {
        logger.info("Updating node properties for '{}', from {} to {}", nodeRef, before, after);
    }

    @AssociationPolicy(value = "cm:folder", association = "cm:contains")
    public void onCreateChildAssociation(final ChildAssociationRef childAssocRef, final boolean isNewNode) {
        logger.info("Creating child association from '{}' to '{}'.", childAssocRef.getParentRef(),
                childAssocRef.getChildRef());
    }

}
