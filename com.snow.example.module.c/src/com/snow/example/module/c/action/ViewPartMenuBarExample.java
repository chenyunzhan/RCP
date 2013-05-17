package com.snow.example.module.c.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.part.ViewPart;

public class ViewPartMenuBarExample {
	
	public ViewPartMenuBarExample(ViewPart viewPart) {
		IMenuManager mm = viewPart.getViewSite().getActionBars().getMenuManager();			
		fillActions(mm);
		mm.update(true);
	}
	
	protected void fillActions(IMenuManager tbm) {
		Action action = new ActionExample();
		action.setText("ViewPart MenuItem");
		tbm.add(action);
	}
}
