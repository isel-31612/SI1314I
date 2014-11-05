package com.isel.adeetc.leic.si.serie2.ex6.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class OpenSubMenuAction implements ActionListener{
	private final JFrame frame;
	private final JFrame father;
	
	public OpenSubMenuAction(JFrame father, JFrame openframe){
		this.father = father;
		this.frame = openframe;
		this.frame.setVisible(false);
		this.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.setVisible(true);
		father.setEnabled(false);
	}

}
