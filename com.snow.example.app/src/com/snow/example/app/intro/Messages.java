package com.snow.example.app.intro;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.snow.example.app.intro.messages"; //$NON-NLS-1$
	public static String ApplicationActionBarAdvisor_help;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
