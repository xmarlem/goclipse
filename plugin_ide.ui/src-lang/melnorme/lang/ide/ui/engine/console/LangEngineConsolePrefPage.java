/*******************************************************************************
 * Copyright (c) 2014, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package melnorme.lang.ide.ui.engine.console;

import melnorme.lang.ide.ui.LangUIPlugin;
import melnorme.util.swt.SWTFactoryUtil;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public abstract class LangEngineConsolePrefPage extends FieldEditorPreferencePage 
		implements EngineConsolePrefs, IWorkbenchPreferencePage {
	
	public LangEngineConsolePrefPage() {
		super(GRID);
		setPreferenceStore(LangUIPlugin.getCorePrefStore());
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}
	
	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		
		addField(new BooleanFieldEditor(ACTIVATE_ON_ERROR_MESSAGES.key, 
			"Activate console on error messages", parent));
		
		SWTFactoryUtil.createLabel(parent, SWT.LEFT, "Console color settings:", 
			GridDataFactory.fillDefaults().span(2, 1).create());
		
		addField(new ColorFieldEditor(INFO_COLOR.key,
			"Information text color:", parent));
		addField(new ColorFieldEditor(STDOUT_COLOR.key,
			"Program standard output text color:", parent));
		addField(new ColorFieldEditor(STDERR_COLOR.key,
			"Program error output text color:", parent));
		addField(new ColorFieldEditor(BACKGROUND_COLOR.key,
			"Console background color:", parent));
	}
	
}