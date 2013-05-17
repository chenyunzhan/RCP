package com.snow.example.app.language;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * Switches the language in RCP based products. Works only if the product is
 * deployed to the local file system since the <product>.ini file is altered.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class LanguageSwitchHandler extends AbstractHandler {

	/**
	 * configini
	 */
	private String configini = "config.ini";
	
	/**
	 * 
	 */
	private IProduct product = Platform.getProduct();
	
	/**
	 * The constructor.
	 */
	public LanguageSwitchHandler() {

	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String locale = event.getParameter("com.snow.example.app.language.locale");	
		try {			
			changeLocale(locale);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		PlatformUI.getWorkbench().restart();
		return null;
	}

	private void changeLocale(String locale) throws IOException {

		Bundle configiniBundle = product.getDefiningBundle();
		URL url = null;
		if (configini != null) {
			try {
				url = new URL(configini);
			} catch (MalformedURLException e) {
				url = FileLocator.find(configiniBundle, new Path(configini), null);
			}
		}
		
		Properties prop = new Properties();
        InputStream fis  = url.openStream();
        prop.load(fis);
        
        System.out.println(prop);
        prop.setProperty("osgi.nl", locale); //$NON-NLS-1$
        FileOutputStream fos = new FileOutputStream(FileLocator.toFileURL(url).getFile());
        prop.store(fos, "Product Runtime Configuration File"); //$NON-NLS-1$
        
        fis.close();
        fos.close();
	}
}
