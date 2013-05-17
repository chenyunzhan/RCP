package com.snow.example.module.d.registry;


import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;

public class ElementExampleRegistry implements IRegistryChangeListener {  

	public static String PLUGIN_ID = "com.snow.example.module.d";
	
	/**
	 * EXTENSION_NAME : ExtensionPointExample
	 */
	public static String EXTENSION_NAME = "ExtensionPointExample";
	
	/**
	 * PLUGIN_ID + "." + EXTENSION_NAME
	 */
	public static String EXTENSIONPOINT_ID = PLUGIN_ID + "." + EXTENSION_NAME;

	/**
	 * 
	 */
	public ElementExampleRegistry() {
		super();
		Platform.getExtensionRegistry().addRegistryChangeListener(this, PLUGIN_ID);
	}
	
	/**
	 * 执行所有扩展,作为演示仅仅显示扩展中的内容
	 */
/*	public static void exeExtensionRegistry() {
		
		Set<ElementExampleProxy> eeps = ElementExampleRegistryReader.getInstance().getElementExampleProxys();
		for (ElementExampleProxy eep : eeps) {
			System.out.println(eep);
		}
	}*/
	
	@Override
	public void registryChanged(IRegistryChangeEvent event) {
		IExtensionDelta[] deltas=event.getExtensionDeltas(PLUGIN_ID, EXTENSION_NAME);
	}
}
