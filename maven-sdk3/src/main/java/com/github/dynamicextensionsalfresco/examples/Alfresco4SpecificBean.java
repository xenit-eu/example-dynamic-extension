package com.github.dynamicextensionsalfresco.examples;

import com.github.dynamicextensionsalfresco.annotations.AlfrescoPlatform;

import org.alfresco.repo.bulkimport.BulkFilesystemImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This bean will only be instantiated on Alfresco 4.0.
 * 
 * @author Laurens Fridael
 * 
 */
@Component
@AlfrescoPlatform(minVersion = "4.0")
public class Alfresco4SpecificBean {

	/**
	 * {@link BulkFilesystemImporter} is specific to Alfresco 4.0 API.
	 */
	@Autowired
	private BulkFilesystemImporter bulkFilesystemImporter;

}
