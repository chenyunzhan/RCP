package com.snow.example.module.c.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.part.ViewPart;

public class ViewPartToolBarExample {
	
	public ViewPartToolBarExample(ViewPart viewPart) {
		IToolBarManager tbm = 
		viewPart.getViewSite().getActionBars().getToolBarManager();
		fillActions(tbm);
		tbm.update(true);
	}
	
	protected void fillActions(IToolBarManager tbm) {
		Action action = new ActionExample();
		action.setText("ViewPart ToolItem");
		tbm.add(action);
	}
}
