package com.play;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class test {


	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				 try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					
					 MP3Model playermodel=new MP3Model();
					 View view=new View(null,playermodel);
					 MP3Control playercontrol=new MP3Control(playermodel,view);
					 
					 Controlcs controlcs=new Controlcs(playercontrol);
					 View views=controlcs.getView();
					 views.setVisible(true);
				 
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						e.printStackTrace();
					}
					
				
			}
		});
	}
}
