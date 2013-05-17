package com.snow.example.module.ui.chapters.model;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


/**
 * @author LuYang
 *
 */
public class ElementFactory {

	/**
	 * ����һ��ָ����ֵ��С������,Ĭ���ӳ�һ��
	 * @return
	 */
	public static Element[] getElements(int total) {
		return getElements(total, 0);
	}
	
	/**
	 * ����һ��ָ����ֵ��С������
	 * @param total �����������
	 * @param second �ӳ�ʱ��,ģ���ʱ����
	 * @return
	 */
	public static Element[] getElements(int total, int second) {
		Element[] datas = new Element[total];
		for (int i = 1; i <= datas.length; i++) {
			datas[i-1] = new Element("element:"+i,"col0-"+i, "col1-"+i);					
		}
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return datas;
	}

	/**
	 * ����һ��ָ����ֵ��Χ�������С������,Ĭ���ӳ�һ��
	 * @return
	 */
	public static Element[] getRandomElements(int total) {
		return getRandomElements(total, 0);
	}
	
	/**
	 * ����һ��ָ����ֵ��Χ�������С������
	 * @param total �����������
	 * @param second �ӳ�ʱ��,ģ���ʱ����
	 * @return
	 */
	public static Element[] getRandomElements(int total, int second) {
		Random random = new Random();
		Element[] datas = new Element[random.nextInt(total)];
		for (int i = 1; i <= datas.length; i++) {
			datas[i-1] = new Element("element-"+i, "col0-"+i, "col1-"+i);					
		}
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	/**
	 * ����һ��ϵͳICON_INFORMATIONͼƬ����,��Ϊ��ʾ
	 * @return
	 */
	public static Image getColumn0Image() {		
		 return Display.getDefault().getSystemImage(SWT.ICON_INFORMATION);
	}
	
	/**
	 * ����һ��ϵͳICON_QUESTIONͼƬ����,��Ϊ��ʾ
	 * @return
	 */
	public static Image getColumn1Image() {		
		 return Display.getDefault().getSystemImage(SWT.ICON_QUESTION);
	}
	
	/**
	 * ����һ��ϵͳWorkingͼƬ����,��Ϊ��ʾ
	 * @return
	 */
	public static Image getImage() {		
		 return Display.getDefault().getSystemImage(SWT.ICON_WORKING);
	}
}
