package com.snow.example.module.c.editorpart;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.snow.example.module.c.composite.ElementPOJOComposite;
import com.snow.example.module.ui.chapters.model.Element;

public class ElementEditorPart extends EditorPart {

	public static final String ID = "com.snow.example.module.c.editorpart.ElementEditorPart"; //$NON-NLS-1$
	private Composite composite;
	private ElementEditorInput elementEditorInput;
	private Text text;
	private boolean dirty;

	public ElementEditorPart() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		composite = new ElementPOJOComposite(parent, SWT.NONE);
		POJOCompositeUtils.setPOJO(composite, elementEditorInput.getElement());
		
		getSite().getPage().addSelectionListener(new ISelectionListener() {
		     public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		    	 if(part.equals(this)) return;// 不响应当前编辑器的选择事件
		    	 StructuredSelection ss = (StructuredSelection) selection;
		    	 Element element = (Element) ss.getFirstElement();
		    	 if(element!=null && element instanceof Element)
		    	 POJOCompositeUtils.setPOJO(composite, element);
		     }
		});
		
		
		
		
		text =new Text(parent,SWT.BORDER|SWT.WRAP|SWT.H_SCROLL|SWT.CANCEL|SWT.MULTI);
		loadText();
		text.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				dirty=true;
				firePropertyChange(ISaveablePart2.PROP_DIRTY);
			}
			
		});
		
		/**
		 * 
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
		 */

	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		String path = elementEditorInput.getName();
		String[] temp = path.split(":");
		SaveToLocal("F:\\work\\code\\rcp\\com.snow.example.module.c\\file\\" + temp[0] + temp[1]);
		dirty=false;
		firePropertyChange(ISaveablePart2.PROP_DIRTY);
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		this.setSite(site);
		this.setInput(input);
		elementEditorInput = (ElementEditorInput)input;
		setPartName(elementEditorInput.getName());
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
	
	
	private void loadText(){
		String path = elementEditorInput.getName();
		String[] temp = path.split(":");
		try{
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("F:\\work\\code\\rcp\\com.snow.example.module.c\\file\\" + temp[0] + temp[1]),"utf-8"));
			StringBuffer sb=new StringBuffer();
			String line=reader.readLine();
			while(line!=null){
				sb.append(line);
				sb.append("\n");
				line=reader.readLine();
			}
			reader.close();
			text.setText(sb.toString());
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void SaveToLocal(String path){
		try{
			OutputStream out=new FileOutputStream(path);
			OutputStreamWriter writer =new OutputStreamWriter(out,"utf-8");
			writer.write(text.getText());
			writer.close();
			out.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
