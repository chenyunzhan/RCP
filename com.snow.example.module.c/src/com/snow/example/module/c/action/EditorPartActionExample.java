package com.snow.example.module.c.action;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.part.EditorActionBarContributor;

import com.snow.example.module.c.status.StatusLineContributionItemExample;




public class EditorPartActionExample extends
		EditorActionBarContributor {

	public EditorPartActionExample() {
	}
	
	@Override
	public void contributeToCoolBar(ICoolBarManager coolBarManager) {
		Action action = new ActionExample();
		action.setText("EditorPartAction CoolItem");
		ToolBarManager tbm = new ToolBarManager();
		tbm.add(action);
		
		coolBarManager.add(tbm);
	}
	
	@Override
	public void contributeToMenu(IMenuManager menuManager) {
		IMenuManager menu = new MenuManager("EditorPartAction Menu");
		menuManager.add(menu);
		
		Action action = new ActionExample();
		action.setText("EditorPartAction MenuItem");
		menu.add(action);		
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		Action action = new ActionExample();
		action.setText("EditorPartAction ToolItem");
		toolBarManager.add(action);
	}
	
	@Override
	public void contributeToStatusLine(IStatusLineManager statusLineManager) {
		super.contributeToStatusLine(statusLineManager);
		statusLineManager.add(new StatusLineContributionItemExample("Example"));
	}
	
}
