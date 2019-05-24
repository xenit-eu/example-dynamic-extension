package eu.xenit.de.example;

import com.github.dynamicextensionsalfresco.webscripts.annotations.Attribute;
import com.github.dynamicextensionsalfresco.webscripts.annotations.HttpMethod;
import com.github.dynamicextensionsalfresco.webscripts.annotations.RequestParam;
import com.github.dynamicextensionsalfresco.webscripts.annotations.Uri;
import com.github.dynamicextensionsalfresco.webscripts.annotations.UriVariable;
import com.github.dynamicextensionsalfresco.webscripts.annotations.WebScript;
import java.io.IOException;
import java.util.Arrays;
import org.alfresco.service.namespace.QName;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Simplest annotated Web Script.
 * <p>
 * See the documentation in {@link CategoriesWebScript} for more information on annotated Web Scripts.
 *
 * @author Laurens Fridael
 */
@Component
@WebScript(families = Constants.EXAMPLE_WEBSCRIPTS_FAMILY, baseUri = Constants.EXAMPLE_WEBSCRIPTS_BASE_URI)
public class HelloWebScript {

    /**
     * Handles the "hello" request. Note the use of Spring MVC-style annotations to map the Web Script URI configuration
     * and request handling objects.
     */
    @Uri("/hello")
    @ResponseBody
    public String handleHello(@RequestParam final String name) {
        return String.format("Hello, %s", name);
    }

    /**
     * Illustrates that {@link QName} can now be resolved as {@link RequestParam} arguments.
     * <p>
     * Note also the use of the delimiter to split a single parameter into an array of values.
     */
    @Uri("/hello-qname")
    public void handleHelloQNameParameter(@RequestParam(delimiter = ",") final QName[] names,
            final WebScriptResponse response) throws IOException {
        final String message = String.format("Hello, %s", Arrays.asList(names));
        response.getWriter().write(message);
    }

    /**
     * Illustrates that {@link QName} can now be resolved as {@link UriVariable} arguments.
     */
    @Uri("/hello/{name}")
    public ResponseEntity<String> handleHelloQNameVariable(@UriVariable final QName name) {
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.I_AM_A_TEAPOT);
    }

    /**
     * Methods annotated with {@link Attribute} provide reference data for arguments in {@link Uri} handling methods.
     * These metho arguments must be annotated with {@link Attribute} as well.
     * <p>
     * In this case, the method provides a String attribute named 'name'.
     *
     * @see #handleHelloAttribute(String)
     */
    @Attribute
    protected String getName(final WebScriptRequest request) {
        return request.getParameter("name");
    }

    /**
     * Illustrates request handling using {@link Attribute}.
     *
     * @see {@link #getName(WebScriptRequest)}
     */
    @Uri("/hello-attribute")
    @ResponseBody
    public String handleHelloAttribute(@Attribute final String name) {
        return String.format("Hello, %s", name);
    }

    /**
     * Illustrates request body deserialization using {@link RequestBody}
     */
    @Uri(value = "/hello-body", method = HttpMethod.POST)
    @ResponseBody
    public String handleHelloPerson(@RequestBody final Person person) {
        return String.format("Hello, %s", person.getName());
    }

    /**
     * Example class used to illustrate data binding.
     *
     * @author Laurens Fridael
     */
    public static class Person {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

    }
}
