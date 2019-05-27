package eu.xenit.de.example;

import com.github.dynamicextensionsalfresco.annotations.AlfrescoPlatform;
import org.springframework.stereotype.Component;

/**
 * This bean will only be instantiated on Alfresco 6.0.
 *
 * @author Laurens Fridael
 */
@Component
@AlfrescoPlatform(minVersion = "6.0")
public class Alfresco6SpecificBean {

    /*
     * Here you would autowire e.g. services that are only available on Alfresco > 6
     */

}
