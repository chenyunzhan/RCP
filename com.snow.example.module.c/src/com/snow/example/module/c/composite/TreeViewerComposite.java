package com.snow.example.module.c.composite;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.snow.example.module.c.editorpart.ElementEditorInput;
import com.snow.example.module.c.editorpart.ElementEditorPart;
import com.snow.example.module.ui.chapters.model.Element;
import com.snow.example.module.ui.chapters.model.ElementFactory;


public class TreeViewerComposite extends Composite {
	private TreeViewer treeViewer;
	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return ElementFactory.getImage();
		}
		public String getText(Object element) {
			return ((Element)element).getName();
		}
	}
	private static class TreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object inputElement) {		
			return (Object[]) inputElement;
		}
		public Object[] getChildren(Object parentElement) {
			return ((Element)parentElement).getChildren();
		}
		public Object getParent(Object element) {
			return null;
		}
		public boolean hasChildren(Object element) {
			//return getChildren(element).length > 0;
			return true;
		}
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TreeViewerComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		treeViewer = new TreeViewer(this, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
		// 设置Viewer的初始根节点
		treeViewer.setInput(ElementFactory.getElements(10));
		
		// Open EditorPart
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection ss = (IStructuredSelection)event.getSelection();
				Element element = (Element) ss.getFirstElement();
				IEditorInput input = new ElementEditorInput(element);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().
					getActivePage().openEditor(input, ElementEditorPart.ID);
				} catch (PartInitException e) {e.printStackTrace();}
			}
		});		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}
}
