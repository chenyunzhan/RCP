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
	 * 返回一个指定数值大小的数组,默认延迟一秒
	 * @return
	 */
	public static Element[] getElements(int total) {
		return getElements(total, 0);
	}
	
	/**
	 * 返回一个指定数值大小的数组
	 * @param total 数组最大容量
	 * @param second 延迟时间,模拟耗时操作
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
	 * 返回一个指定数值范围内随机大小的数组,默认延迟一秒
	 * @return
	 */
	public static Element[] getRandomElements(int total) {
		return getRandomElements(total, 0);
	}
	
	/**
	 * 返回一个指定数值范围内随机大小的数组
	 * @param total 数组最大容量
	 * @param second 延迟时间,模拟耗时操作
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
	 * 返回一个系统ICON_INFORMATION图片对象,作为演示
	 * @return
	 */
	public static Image getColumn0Image() {		
		 return Display.getDefault().getSystemImage(SWT.ICON_INFORMATION);
	}
	
	/**
	 * 返回一个系统ICON_QUESTION图片对象,作为演示
	 * @return
	 */
	public static Image getColumn1Image() {		
		 return Display.getDefault().getSystemImage(SWT.ICON_QUESTION);
	}
	
	/**
	 * 返回一个系统Working图片对象,作为演示
	 * @return
	 */
	public static Image getImage() {		
		 return Display.getDefault().getSystemImage(SWT.ICON_WORKING);
	}
}
