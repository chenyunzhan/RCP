package com.snow.example.module.c.viewpart;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import com.snow.example.module.c.composite.ElementPOJOComposite;
import com.snow.example.module.c.editorpart.POJOCompositeUtils;
import com.snow.example.module.ui.chapters.model.Element;

public class SlaveViewPart extends ViewPart {

	public static final String ID = "com.snow.example.module.c.viewpart.Slave"; //$NON-NLS-1$

	public SlaveViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		final Composite composite = new ElementPOJOComposite(parent, SWT.NONE);

		createActions();
		initializeToolBar();
		initializeMenu();
		
		getSite().getPage().addPostSelectionListener(new ISelectionListener() {
			
			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				if(part.equals(this)) {
					return;
				}
				
				StructuredSelection ss = (StructuredSelection) selection;
				Element element = (Element) ss.getFirstElement();
				if(element != null && element instanceof Element) {
					POJOCompositeUtils.setPOJO(composite, element);
				}
			}
		});
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
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
