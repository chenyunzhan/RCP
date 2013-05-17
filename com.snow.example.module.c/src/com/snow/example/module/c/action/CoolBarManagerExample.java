package com.snow.example.module.c.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.CoolBar;

public class CoolBarManagerExample {

	public CoolBarManagerExample(CoolBar coolBar) {
		ICoolBarManager cbm = new CoolBarManager(coolBar);
		fillActions(cbm);
		cbm.update(true);
	}

	protected void fillActions(ICoolBarManager cbm) {
		Action action = new ActionExample();
		action.setText("CoolBar CoolItem");
		ToolBarManager tbm = new ToolBarManager();
		tbm.add(action);
		
		cbm.add(tbm);
	}

}
