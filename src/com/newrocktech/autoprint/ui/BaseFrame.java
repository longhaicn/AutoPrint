package com.newrocktech.autoprint.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * Base Window Frame Settings and Configuration
 * @author Lenhart
 *
 */
public class BaseFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public BaseFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.jpg"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		int w = 1000;
		int h = 600;
		if(width>w){
			width=(width - w)/2;
		}else{
			width = 0;
		}
		if(height > h){
			height=(height - h)/2;
		}else{
			height = 0;
		}
		setBounds(width, height, w, h);
	}

}
