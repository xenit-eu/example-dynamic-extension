package eu.xenit.de.example;

import com.github.dynamicextensionsalfresco.annotations.AlfrescoService;
import com.github.dynamicextensionsalfresco.annotations.ServiceType;
import com.github.dynamicextensionsalfresco.webscripts.annotations.Uri;
import com.github.dynamicextensionsalfresco.webscripts.annotations.WebScript;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import javax.annotation.Resource;
import org.alfresco.model.ContentModel;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.InvalidNodeRefException;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.cmr.repository.StoreRef;
import org.alfresco.service.cmr.search.CategoryService;
import org.alfresco.service.cmr.search.CategoryService.Depth;
import org.alfresco.service.cmr.search.CategoryService.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.springframework.stereotype.Component;

/**
 * Annotated Web Script that recursively lists the categories in the "generalclassifiable" classification.
 * <p>
 * This class illustrates Web Script request handling and how to obtain Alfresco service dependencies, such as {@link
 * CategoryService} and {@link NodeService}.
 * <p>
 * The {@link Component} annotation causes this class to be instantiated by Spring's component scanning. The {@link
 * WebScript} annotation marks it as an annotated Web Script for Dynamic Extensions to further decorate with request
 * handling logic.
 *
 * @author Laurens Fridael
 */
@Component
@WebScript(families = Constants.EXAMPLE_WEBSCRIPTS_FAMILY, baseUri = Constants.EXAMPLE_WEBSCRIPTS_BASE_URI, description = "Shows the entire category tree.")
public class CategoriesWebScript {

    /**
     * Annotate dependencies with {@link Autowired} to obtain references to Alfresco services. This is how you'd
     * normally inject dependencies in a Spring application. There is nothing specific to Dynamic Extensions about this
     * style of dependency injection.
     * <p>
     * The {@link AlfrescoService} annotation lets you control whether you want the default (high-level) implementation
     * of a service or, as in this case, the low-level version. Low-level versions are typically faster, as they are not
     * equipped with security, auditing or transaction advice. (As you might expect, not specifying {@link
     * AlfrescoService} is equivalent to using {@link ServiceType#DEFAULT}.)
     */
    @Autowired
    @AlfrescoService(ServiceType.LOW_LEVEL)
    private CategoryService categoryService;

    /**
     * You can also inject Alfresco dependencies by name using {@link Resource}. This is NOT recommended practice, as it
     * couples your code to the specifics of Alfresco's Spring bean configuration.
     */
    @Resource(name = "nodeService")
    private NodeService nodeService;

    /**
     * Note how the Web Script URI is mapped using an annotation. Annotated Web Scripts do not use XML configuration,
     * eliminating the code sprawl associated with regular Web Scripts.
     */
    @Uri("/categories")
    public void showCategories(final WebScriptResponse response) throws IOException {
        final Writer out = response.getWriter();
        final Collection<ChildAssociationRef> rootCategories = categoryService.getRootCategories(
                StoreRef.STORE_REF_WORKSPACE_SPACESSTORE, ContentModel.ASPECT_GEN_CLASSIFIABLE);
        for (final ChildAssociationRef childAssociationRef : rootCategories) {
            showCategory(childAssociationRef.getChildRef(), 0, out);
        }
    }

    /**
     * Recursively output the category names.
     */
    private void showCategory(final NodeRef categoryNodeRef, final int level, final Writer out)
            throws InvalidNodeRefException, IOException {
        for (int i = 0; i < level; i++) {
            out.write("\t");
        }
        out.write(String.format("%s\n", nodeService.getProperty(categoryNodeRef, ContentModel.PROP_NAME)));
        final Collection<ChildAssociationRef> childCategories = categoryService.getChildren(categoryNodeRef,
                Mode.SUB_CATEGORIES, Depth.IMMEDIATE);
        for (final ChildAssociationRef childAssociationRef : childCategories) {
            showCategory(childAssociationRef.getChildRef(), level + 1, out);
        }
    }
}
