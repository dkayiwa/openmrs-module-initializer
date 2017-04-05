/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.initializer;

import java.net.URISyntaxException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.initializer.api.InitializerService;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.openmrs.util.OpenmrsConstants;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is a unit test, which verifies logic in InitializerService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
public class InitializerServiceTest extends BaseModuleContextSensitiveTest {
	
	private static String APP_DATA_TEST_DIRECTORY = "appDataDir";
	
	@Autowired
	private InitializerService service;
	
	@Before
	public void setup() throws URISyntaxException {
		
		String path = getClass().getClassLoader().getResource(APP_DATA_TEST_DIRECTORY).getPath();
		
		Properties prop = new Properties();
		prop.setProperty(OpenmrsConstants.APPLICATION_DATA_DIRECTORY_RUNTIME_PROPERTY, path);
		Context.setRuntimeProperties(prop);
	}
	
	@Test
	public void loadAddressHierachyConfig_should() {
		service.loadAddressHierachyConfig();
	}
}
