package com.snow.example.module.c.status;

import org.eclipse.jface.action.StatusLineContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class StatusLineContributionItemExample extends
		StatusLineContributionItem {

	public StatusLineContributionItemExample(String id) {
		super(id, StatusLineContributionItem.CALC_TRUE_WIDTH);
		this.setVisible(true);
	}

	@Override
	public void fill(Composite parent) {		
		super.fill(parent);
		StatusLineComposite sc = new StatusLineComposite(parent, SWT.NONE);
	}
}
