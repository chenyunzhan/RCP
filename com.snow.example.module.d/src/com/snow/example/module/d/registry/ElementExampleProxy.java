package com.snow.example.module.d.registry;

import java.io.InputStream;


public class ElementExampleProxy {

	private String stringAttriburte;
	private boolean booleanAttriburte;
	private IElementExample javaAttriburte;
	private InputStream resourceAttriburte;

	public String getStringAttriburte() {
		return stringAttriburte;
	}

	public void setStringAttriburte(String stringAttriburte) {
		this.stringAttriburte = stringAttriburte;
	}

	public boolean isBooleanAttriburte() {
		return booleanAttriburte;
	}

	public void setBooleanAttriburte(boolean booleanAttriburte) {
		this.booleanAttriburte = booleanAttriburte;
	}

	public IElementExample getJavaAttriburte() {
		return javaAttriburte;
	}
	
	public void setJavaAttriburte(IElementExample javaAttriburte) {
		this.javaAttriburte = javaAttriburte;
	}

	public InputStream getResourceAttriburte() {
		return resourceAttriburte;
	}

	public void setResourceAttriburte(InputStream resourceAttriburte) {
		this.resourceAttriburte = resourceAttriburte;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("ElementExampleProxy[").append("\n");
		sb.append("stringAttriburte:"+stringAttriburte).append("\n");
		sb.append("booleanAttriburte:"+booleanAttriburte).append("\n");
		sb.append("javaAttriburte:"+javaAttriburte.hello()).append("\n");
		sb.append("resourceAttriburte:"+resourceAttriburte).append("\n");
		sb.append("]").append("\n");
		return sb.toString();
	}
}
