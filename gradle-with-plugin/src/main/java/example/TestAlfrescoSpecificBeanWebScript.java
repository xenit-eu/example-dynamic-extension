package example;

import com.github.dynamicextensionsalfresco.webscripts.annotations.Uri;
import com.github.dynamicextensionsalfresco.webscripts.annotations.WebScript;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.springframework.stereotype.Component;

/**
 * Demonstrates how to inject optional dependencies using {@link Autowired}
 *
 * @author Laurens Fridael
 */
@Component
@WebScript(families = Constants.EXAMPLE_WEBSCRIPTS_FAMILY, baseUri = Constants.EXAMPLE_WEBSCRIPTS_BASE_URI)
@SuppressWarnings("unused")
public class TestAlfrescoSpecificBeanWebScript {

    @Autowired(required = false)
    private Alfresco6SpecificBean alfresco6SpecificBean;

    @Autowired(required = false)
    private Alfresco5SpecificBean alfresco5SpecificBean;

    @Uri("/test-alfresco-specific-beans")
    public void show(final WebScriptResponse response) throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Alfresco 6-specific bean available? ");

        if (alfresco6SpecificBean != null) {
            sb.append("yes");
        } else {
            sb.append("no");
        }

        sb.append("\n");

        sb.append("Alfresco 5-specific bean available? ");

        if (alfresco5SpecificBean != null) {
            sb.append("yes");
        } else {
            sb.append("no");
        }

        response.getWriter().write(sb.toString());
    }
}
