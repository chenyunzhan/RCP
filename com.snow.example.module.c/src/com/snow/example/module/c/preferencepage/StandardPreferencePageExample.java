package com.snow.example.module.c.preferencepage;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.snow.example.module.c.Activator;
import com.snow.example.module.c.preferences.StandardPreferenceInitializer;


public class StandardPreferencePageExample extends PreferencePage 
implements IWorkbenchPreferencePage {
	private Text text;
	private Button btnCheckButton;
	private Button btnRadioButton_1;
	private Button btnRadioButton_2;

	/**
	 * Create the preference page.
	 */
	public StandardPreferencePageExample() {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * Create contents of the preference page.
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {

		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblNewLabel_2.setText("&An example of a boolean preference");
		
		btnCheckButton = new Button(container, SWT.CHECK);
		btnCheckButton.setText("Check Button");
		new Label(container, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblNewLabel_1.setText("An example of a multiple-choice preference");
		
		btnRadioButton_1 = new Button(container, SWT.RADIO);
		btnRadioButton_1.setText("&Choice 1");
		btnRadioButton_1.setData("Choice 1");
		new Label(container, SWT.NONE);
		
		btnRadioButton_2 = new Button(container, SWT.RADIO);
		btnRadioButton_2.setText("&Choice 2");
		btnRadioButton_2.setData("Choice 2");
		new Label(container, SWT.NONE);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("A &text preference");
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnCheckButton.setSelection(
				StandardPreferenceInitializer.getBooleanPreference());
		text.setText(
				StandardPreferenceInitializer.getStringPreference());
		btnRadioButton_1.setSelection(
		StandardPreferenceInitializer.getChoicePreference().equals(
				btnRadioButton_1.getData()));
		btnRadioButton_2.setSelection(
		StandardPreferenceInitializer.getChoicePreference().equals(
				btnRadioButton_2.getData()));
		
		return container;
	}

	
	@Override
	public boolean performOk() {
		StandardPreferenceInitializer.setBooleanPreference(
				btnCheckButton.getSelection());
		StandardPreferenceInitializer.setStringPreference(
				text.getText());
		if(btnRadioButton_1.getSelection())
		btnRadioButton_1.setSelection(
		StandardPreferenceInitializer.getChoicePreference().equals(
				btnRadioButton_1.getData()));
		if(btnRadioButton_2.getSelection())
		btnRadioButton_2.setSelection(
		StandardPreferenceInitializer.getChoicePreference().equals(
				btnRadioButton_2.getData()));
		
		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		btnCheckButton.setSelection(StandardPreferenceInitializer.
				getDefaultBooleanPreference());
		text.setText(StandardPreferenceInitializer.
				getDefaultStringPreference());
		btnRadioButton_1.setSelection(StandardPreferenceInitializer.
				getDefaultChoicePreference().equals(btnRadioButton_1.getData()));
		btnRadioButton_2.setSelection(StandardPreferenceInitializer.
				getDefaultChoicePreference().equals(btnRadioButton_2.getData()));
	}
	
	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {

	}
}
