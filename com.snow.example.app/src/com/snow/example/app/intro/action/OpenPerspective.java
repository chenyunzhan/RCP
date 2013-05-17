package com.snow.example.app.intro.action;

import java.util.Properties;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;

public class OpenPerspective implements IIntroAction{

	@Override
	public void run(IIntroSite site, Properties params) {
		final String perspectiveID = params.getProperty("perspectiveId");
		if (perspectiveID != null) {
			try {
				// Close the intro view ...
				final IIntroPart introPart = PlatformUI.getWorkbench()	.getIntroManager().getIntro();
				PlatformUI.getWorkbench().getIntroManager()	.closeIntro(introPart);
				// Open the perspective ....n
				final IWorkbench wb = PlatformUI.getWorkbench();
				wb.showPerspective(perspectiveID, wb.getActiveWorkbenchWindow());
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

}
