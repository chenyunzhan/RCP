package com.snow.example.app.intro;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.jface.action.IAction;

import com.snow.example.module.c.status.StatusLineContributionItemExample;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    private IWorkbenchAction introAction;
    private IAction helpContentsAction;
    private IAction saveAction;
    private IAction preferencesAction;
    
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		introAction = ActionFactory.INTRO.create(window);
		register(introAction);
		{
			helpContentsAction = ActionFactory.HELP_CONTENTS.create(window);
			register(helpContentsAction);
		}
		{
			saveAction = ActionFactory.SAVE.create(window);
			register(saveAction);
		}
		{
			preferencesAction = ActionFactory.PREFERENCES.create(window);
			register(preferencesAction);
		}
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		
		MenuManager helpMenu = new MenuManager(Messages.ApplicationActionBarAdvisor_help, IWorkbenchActionConstants.M_HELP);
		menuBar.add(helpMenu);
		helpMenu.add(helpContentsAction);
		helpMenu.add(preferencesAction);
		helpMenu.add(new Separator());
		helpMenu.add(introAction);
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		ToolBarManager toolBarManager = new ToolBarManager();
		coolBar.add(toolBarManager);
		toolBarManager.add(saveAction);
	}

	@Override
	protected void fillStatusLine(IStatusLineManager statusLine) {
		statusLine.add(new StatusLineContributionItemExample("Example"));
	}
	
	

}
