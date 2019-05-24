package eu.xenit.de.example;

import com.github.dynamicextensionsalfresco.annotations.AlfrescoPlatform;
import org.springframework.stereotype.Component;

/**
 * This bean will only be instantiated on Alfresco 5.0.
 *
 * @author Laurens Fridael
 */
@Component
@AlfrescoPlatform(minVersion = "5.0", maxVersion = "5.99")
public class Alfresco5SpecificBean {

    /*
     * Here you would autowire e.g. services that are only available on Alfresco 5
     */

}
