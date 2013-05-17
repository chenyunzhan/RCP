package com.snow.example.module.c.viewpart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.snow.example.module.c.action.ViewPartMenuBarExample;
import com.snow.example.module.c.action.ViewPartToolBarExample;
import com.snow.example.module.c.composite.TreeViewerComposite;

public class MasterViewPart extends ViewPart {

	public static final String ID = "com.snow.example.module.c.viewpart.MasterViewPart"; //$NON-NLS-1$

	public MasterViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		TreeViewerComposite container = new TreeViewerComposite(parent, SWT.NONE);
		

		createActions();
		initializeToolBar();
		initializeMenu();
		
		getSite().setSelectionProvider(container.getTreeViewer());
		
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		new ViewPartToolBarExample(this);
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		new ViewPartMenuBarExample(this);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
