package com.snow.example.module.c.editorpart;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import com.snow.example.module.ui.chapters.model.Element;

public class ElementEditorInput implements IEditorInput{
	
	private Element element;
	
	public ElementEditorInput(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			return true;
		}
		if(!(obj instanceof ElementEditorInput)) {
			return false;
		}
		ElementEditorInput other = (ElementEditorInput) obj;
		return this.element.getName().equalsIgnoreCase(other.getName());
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return element.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return element.getName();
	}
	
}
