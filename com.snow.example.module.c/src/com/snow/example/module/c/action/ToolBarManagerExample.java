package com.snow.example.module.c.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.ToolBar;

public class ToolBarManagerExample {

	public ToolBarManagerExample(ToolBar toolBar) {
		IToolBarManager tbm = new ToolBarManager(toolBar);
		fillAction(tbm);
		tbm.update(true);
	}

	protected void fillAction(IToolBarManager tbm) {
		Action action = new ActionExample();
		action.setText("ToolBar ToolItem");
		tbm.add(action);
	}
	
}
