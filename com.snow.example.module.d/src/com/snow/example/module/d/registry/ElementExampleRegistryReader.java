package com.snow.example.module.d.registry;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.internal.util.BundleUtility;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;


/**
 * @author luyang
 *
 */
public class ElementExampleRegistryReader {

	/**
	 * single
	 */
	private static ElementExampleRegistryReader registryReader = new ElementExampleRegistryReader();

	private ElementExampleRegistryReader() {

	}

	public static ElementExampleRegistryReader getInstance() {
		return registryReader;
	}

	/**
	 * ��ȡ�����ָ��ID����չ��
	 * @param extensionPointId ��չ��ID
	 * @return
	 */
	private IExtensionPoint getBundleExtensionPoint(String extensionPointId){
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(extensionPointId);
		return extensionPoint;
	}

	/**
	 * ��ȡָ����չ���е���չԪ��
	 * @param extensionPointId
	 * @return
	 */
	private Set<IExtension> getBundleExtensions(String extensionPointId){
		Set<IExtension> registryExtensions = new HashSet<IExtension>();
		
		IExtensionPoint extensionPoint = getBundleExtensionPoint(extensionPointId);
		if(extensionPoint!=null){
			IExtension[] extensions=extensionPoint.getExtensions();
			if(extensions!=null){
				for (int i = 0; i < extensions.length; i++) {
					registryExtensions.add(extensions[i]);
				}
			}
		}
		return registryExtensions;
	}

	/**
	 * ��ȡ����ʹ����ElementExample��չ������ô������
	 * @return
	 */
	public Set<ElementExampleProxy> getElementExampleProxys() {
		Set<ElementExampleProxy> proxys = new HashSet<ElementExampleProxy>();
		
		Set<IExtension> es = getBundleExtensions(ElementExampleRegistry.EXTENSIONPOINT_ID);
		for (Iterator<IExtension> iterator = es.iterator(); iterator.hasNext();) {
			IExtension e = (IExtension) iterator.next();
			
			proxys.addAll( getElementExampleProxy(e)  );
		}		
		return proxys;
	}
	
	/**
	 * ��ȡ��չԪ���е����ô������
	 * @param e
	 * @return
	 */
	private Set<ElementExampleProxy> getElementExampleProxy(IExtension e) {
		
		Set<ElementExampleProxy> proxys = new HashSet<ElementExampleProxy>();	
		IConfigurationElement[] elements = e.getConfigurationElements();
		proxys.addAll( parseConfigurationElements(elements) );
		return proxys;
	}

	/**
	 * ������չԪ����ָ�����Ƶ�����Ԫ��
	 * @param ces ��Ҫ����������Ԫ�ؼ���
	 * @return
	 */
	private Set<ElementExampleProxy> parseConfigurationElements(IConfigurationElement[] ces) {
		Set<ElementExampleProxy> proxys = new HashSet<ElementExampleProxy>();	
		for (int i = 0; i < ces.length; i++) {
			IConfigurationElement ce = ces[i];
			if(ce.getName().equals("ElementExample"))
			proxys.add( parseConfigurationElement(ce) );
		}
		return  proxys;
	}

	/**
	 * ������չԪ���е�����Ԫ��
	 * @param ce ��Ҫ����������Ԫ��
	 * @return
	 */
	private ElementExampleProxy parseConfigurationElement(IConfigurationElement ce) {
		ElementExampleProxy eep = new ElementExampleProxy();
		eep.setStringAttriburte(ce.getAttribute("javaAttribute"));
		boolean b = Boolean.parseBoolean(ce.getAttribute("booleanAttribute"));
		eep.setBooleanAttriburte(b);
		eep.setJavaAttriburte( (IElementExample)getJava(ce, "javaAttribute") );
		eep.setResourceAttriburte( getInputStreamResource(ce, "resourceAttribute") );
		return eep;
	}
	
	/**
	 * ��ȡJava��������
	 * @param ce
	 * @param attributeName
	 * @return
	 */
	private Object getJava(IConfigurationElement ce, String attributeName) {
		Object javaAttriburte=null;
		try {
			javaAttriburte = ce.createExecutableExtension(attributeName);
		} catch (CoreException e) {}
		return javaAttriburte;
	}
		
	/**
	 * ��InputStream�����ƻ�ȡResource��������
	 * @param ce
	 * @param resourceAttribute
	 * @return
	 */
	private InputStream getInputStreamResource(IConfigurationElement ce, String resourceAttribute) {
		InputStream is = null;	
		try {
				Bundle bundle = Platform.getBundle(ElementExampleRegistry.PLUGIN_ID);
				String resourceAttributeValue = ce.getAttribute(resourceAttribute);
				if(!BundleUtility.isReady(bundle)) return null;
				Path path = new Path("/" + resourceAttributeValue);
				is = FileLocator.openStream(bundle, path, false);				
			} catch (IOException e) {}
		return is;
	}
	
	/**
	 * �����ͼƬ��Դ����ImageDescriptor����
	 * @param ce
	 * @param resourceAttribute
	 * @return
	 */
	private  ImageDescriptor getImageResource(IConfigurationElement ce, String resourceAttribute) {
		String resourceAttributeValue = ce.getAttribute(resourceAttribute);
		return AbstractUIPlugin.imageDescriptorFromPlugin(ElementExampleRegistry.PLUGIN_ID, resourceAttributeValue);
	}

}