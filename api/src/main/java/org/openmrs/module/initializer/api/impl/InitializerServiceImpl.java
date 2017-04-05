/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.initializer.api.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.addresshierarchy.util.AddressHierarchyImportUtil;
import org.openmrs.module.initializer.InitializerConstants;
import org.openmrs.module.initializer.api.InitializerService;
import org.openmrs.util.OpenmrsUtil;

public class InitializerServiceImpl extends BaseOpenmrsService implements InitializerService {
	
	@Override
	public void loadAddressHierachyConfig() throws APIException {
		String path = OpenmrsUtil.getApplicationDataDirectory() + InitializerConstants.CONFIG_PATH + "/addresshierarchy/"
		        + "addresshierarchy.csv";
		InputStream stream = null;
		try {
			stream = OpenmrsUtil.getResourceInputStream(new URL("file://" + path));
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddressHierarchyImportUtil.importAddressHierarchyFile(stream, ",");
	}
}
