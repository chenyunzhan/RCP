package com.snow.example.module.c.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.snow.example.module.c.Activator;


/**
 * Class used to initialize default preference values.
 */
public class StandardPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(
				StandardPreferenceConstants.P_Standard_BOOLEAN, true);
		store.setDefault(
				StandardPreferenceConstants.P_Standard_CHOICE, "Choice 2");
		store.setDefault(
				StandardPreferenceConstants.P_Standard_STRING, "Standard-Default value");
	}

	public static void setBooleanPreference(Boolean b) {
		Activator.getDefault().getPreferenceStore().setValue(
		StandardPreferenceConstants.P_Standard_BOOLEAN, b);
	}
	
	public static boolean getBooleanPreference() {
		return Activator.getDefault().getPreferenceStore().getBoolean(
		StandardPreferenceConstants.P_Standard_BOOLEAN);
	}
	
	public static boolean getDefaultBooleanPreference() {
		return Activator.getDefault().getPreferenceStore().getDefaultBoolean(
		StandardPreferenceConstants.P_Standard_BOOLEAN);
	}

	public static void setChoicePreference(String c) {
		Activator.getDefault().getPreferenceStore().setValue(
		StandardPreferenceConstants.P_Standard_CHOICE, c);
	}

	public static String getChoicePreference() {
		return Activator.getDefault().getPreferenceStore().getString(
		StandardPreferenceConstants.P_Standard_CHOICE);
	}
	
	public static String getDefaultChoicePreference() {
		return Activator.getDefault().getPreferenceStore().getDefaultString(
		StandardPreferenceConstants.P_Standard_CHOICE);
	}
	
	public static void setStringPreference(String s) {
		Activator.getDefault().getPreferenceStore().setValue(
		StandardPreferenceConstants.P_Standard_STRING, s);
	}
	
	public static String getStringPreference() {
		return Activator.getDefault().getPreferenceStore().getString(
		StandardPreferenceConstants.P_Standard_STRING);
	}
	
	public static String getDefaultStringPreference() {
		return Activator.getDefault().getPreferenceStore().getDefaultString(
		StandardPreferenceConstants.P_Standard_STRING);
	}	
}
