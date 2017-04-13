package com.play;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
@SuppressWarnings("serial")
public class View extends javax.swing.JFrame implements ActionListener,ItemListener,ComObserver,Runnable{

	public View(Control control,Model model) {
		this.controller=control;
		this.model=model;
		this.filepath="";
		model.registerObserver((ComObserver)this);
		this.thread=null;
		initComponents();
	}
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		
		jButton1.setFocusPainted(true);
		
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jProgressBar1 = new javax.swing.JProgressBar();
		jProgressBar1.setBackground(Color.yellow);//显示节拍的条
		
		this.jProgressBar1.setMaximum(500);
		jProgressBar1.setValue(0);
		
		jPanel1 = new JPanel();
		jPanel1.setBackground(Color.lightGray);

		
		
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("mp3播放器~~脉动监测");
		
		jLabel1.setText("节拍/脉动");
		jLabel1.setFont(new java.awt.Font("楷体_GB2312", 0, 13));
		jLabel1.setForeground(Color.blue);
		
		jLabel2.setText("BPM: ");
		jLabel2.setFont(new java.awt.Font("楷体_GB2312", 0, 13));
		jLabel2.setForeground(Color.blue);
		jTextField1.setToolTipText("输入一个值, 最大为 "+MP3Model.MAXVALUE);

		jButton1.setText("设置");
		jButton1.setFont(new java.awt.Font("楷体_GB2312", 0, 13));

		jButton2.setText("<<");
		jButton2.setToolTipText("减 1");

		jButton3.setText(">>");
		jButton3.setToolTipText("加 1");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 401,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53,
				Short.MAX_VALUE));

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setSelected(true);
		jRadioButton1.setText("MP3播放器");
		jRadioButton1.setFont(new java.awt.Font("楷体_GB2312", 0, 13));

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("监测脉动");
		jRadioButton2.setFont(new java.awt.Font("楷体_GB2312", 0, 13));

		jMenu1.setText("文件");
		jMenu1.setFont(new java.awt.Font("楷体_GB2312", 0, 13));
		jMenu1.setToolTipText("选择要播放的文件");

		jMenuItem1.setText("选择");
		jMenuItem1.setFont(new java.awt.Font("楷体_GB2312", 0, 13));
		jMenu1.add(jMenuItem1);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("操作选项");
		jMenu2.setFont(new java.awt.Font("楷体_GB2312", 0, 13));

		jMenuItem2.setText("开始");
		jMenuItem2.setFont(new java.awt.Font("楷体_GB2312", 0, 13));
		jMenu2.add(jMenuItem2);

		jMenuItem3.setText("暂停");
		jMenuItem3.setFont(new java.awt.Font("楷体_GB2312", 0, 13));
		jMenu2.add(jMenuItem3);

		jMenuItem4.setText("退出");
		jMenuItem4.setFont(new java.awt.Font("楷体_GB2312", 0, 13));
		jMenu2.add(jMenuItem4);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(69, 69, 69)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(
																				jLabel1)
																		.addGroup(
																				layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel2)
																						.addGap(
																								13,
																								13,
																								13)))
														.addComponent(
																jRadioButton1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jButton2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												70,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												10,
																												Short.MAX_VALUE)
																										.addComponent(
																												jButton3,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												71,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												26,
																												26,
																												26))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								layout
																										.createSequentialGroup()
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jTextField1,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																170,
																																Short.MAX_VALUE)
																														.addComponent(
																																jProgressBar1,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																170,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																		.addComponent(
																				jButton1))
														.addComponent(
																jRadioButton2))
										.addGap(28, 28, 28))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jRadioButton1)
														.addComponent(
																jRadioButton2))
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addGap(
																				31,
																				31,
																				31)
																		.addComponent(
																				jLabel2))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jProgressBar1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jButton1)
																						.addComponent(
																								jTextField1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(30, 30, 30)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton3)
														.addComponent(jButton2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap()));
		
		this.registerListener();                //给各个组件注册监听器，下面实现
		Toolkit kit=Toolkit.getDefaultToolkit();//为了让窗口位于屏幕中间
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		setLocation(screenWidth/3, screenHeight/4);

//		setSize(500,320);
		pack();//自动匹配合适的大小
	}// </editor-fold>
	//GEN-END:initComponents
	
	
	@Override
	public void updateJPBar(Object o) {
		
		this.value=(int)(500*this.model.getBPM()/(Float)o);
		
		this.thread=new Thread(this);
		this.thread.start();
	}

		

	@Override
	public void updateComponent(Object o) {
		if (model != null) {
			jPanel1.removeAll();
			if(o!=null){
			
			jPanel1.add((Component) o);
			jPanel1.repaint();
			}
		}
	}

	@Override
	public void updateCanSetState() {
		this.enableDecreaseButton();
		this.enableIncreaseButton();
		this.enableSetButton();
		this.enableTextField();
		
	}
	@Override
	public void updateDisableSetState() {
		this.disableDecreaseButton();
		this.disableIncreaseButton();
		this.disableTextField();
		this.disableSetButton();
		
	}


	@Override
	public void updateStopStartState() {
		this.disableStopMenuItem();
		this.enableStartMenuItem();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jButton1){
			float bpm=0.0f;
			try{
		bpm=Float.parseFloat(jTextField1.getText());
			if(bpm>MP3Model.MAXVALUE){
				JOptionPane.showMessageDialog(this, "！！！输入非法, 0-"+MP3Model.MAXVALUE+",float");
			}
			this.controller.setBPM(bpm);
			}catch(Exception e1){
				JOptionPane.showMessageDialog(this, "非法输入");
			}
		}else if(e.getSource()==jButton2){
			this.controller.decreaseBPM();
		}else if(e.getSource()==jButton3){
			this.controller.increaseBPM();
		}else if(e.getSource()==jMenuItem2){
			this.controller.start();
		}else if(e.getSource()==jMenuItem3){
			this.controller.stop();
		}else if(e.getSource()==jMenuItem4){
			System.exit(0);
		}else if(e.getSource()==jMenuItem1){
			
			class Mp3Filter extends FileFilter{
				
				public boolean accept(File f){
					return f.getName().toLowerCase().endsWith(".mp3")||f.isDirectory();
				}
				public String getDescription(){
					return ".mp3";
				}
			}
		
			JFileChooser jfilechooser=new JFileChooser();
			
			jfilechooser.setFileFilter(new Mp3Filter());
			jfilechooser.setAcceptAllFileFilterUsed(false);
			
			 
			int value=jfilechooser.showOpenDialog(this);

			if(value==JFileChooser.APPROVE_OPTION){
				filepath=jfilechooser.getSelectedFile().toString();
			this.controller.setFilePath(filepath);
			this.filechoosed=true;
		
			}

		}
		
		
	}
	private void buildController(int i){
		this.controller.stop();
		Model newmodel=null;
		Control newcontrol=null;
		switch(i){
		case 1:
			 newmodel=new MP3Model();
			 newcontrol=new MP3Control(newmodel,this);
			 if(filechoosed){
				 newcontrol.setFilePath(this.filepath);
			 }
			
			 
			break;
		case 2:
			newmodel=new AdapterModel();
		
			newcontrol=new BPMControl(newmodel,this);
			
			break;
			default:
				return;
			
			
		}
		
		newmodel.registerObserver((ComObserver)this);
		 this.model=newmodel;
		 this.controller.setController(newcontrol);
		
		 
	}
	@SuppressWarnings("static-access")
	@Override
	public void itemStateChanged(ItemEvent e) {
		 if(e.getStateChange()==e.SELECTED){
			 
			 if(e.getSource()==jRadioButton1){
				this.buildController(1);//MP3
				
				 
			 }else if(e.getSource()==jRadioButton2){
				 this.buildController(2);//监测脉动
			     
			 }
			 
			 
		 }
		
		
	}

	private void registerListener(){
		this.jButton1.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
		this.jMenuItem1.addActionListener(this);
	
		this.jMenuItem2.addActionListener(this);
		this.jMenuItem3.addActionListener(this);
		this.jMenuItem4.addActionListener(this);
		
		this.jRadioButton1.addItemListener(this);
		this.jRadioButton2.addItemListener(this);
	}
	
	
	
	
	public void enableStopMenuItem() {
    	jMenuItem3.setEnabled(true);
    	jMenuItem3.repaint();
	}

	public void disableStopMenuItem() {
    	jMenuItem3.setEnabled(false);
    	jMenuItem3.repaint();
	}

	public void enableStartMenuItem() {
    	jMenuItem2.setEnabled(true);
    	jMenuItem2.repaint();
	}

	public void disableStartMenuItem() {
    	jMenuItem2.setEnabled(false);
    	jMenuItem2.repaint();
	}
	
	public void enableSetButton() {
		jButton1.setEnabled(true);
		jButton1.repaint();
	}
	public void disableSetButton() {
		jButton1.setEnabled(false);
		jButton1.repaint();
	}
	public void enableDecreaseButton() {
		jButton2.setEnabled(true);
		jButton2.repaint();
	}
	public void disableDecreaseButton() {
		jButton2.setEnabled(false);
		jButton2.repaint();
	}
	public void enableIncreaseButton() {
		jButton3.setEnabled(true);
		jButton3.repaint();
		
	}
	public void disableIncreaseButton() {
		jButton3.setEnabled(false);
		jButton3.repaint();
	}
	public void enableTextField() {
		jTextField1.setEnabled(true);
		jTextField1.repaint();
	}
	public void disableTextField() {
		jTextField1.setEnabled(false);
		jTextField1.repaint();
	}
	public void disableFileChooserItem() {
		jMenuItem1.setEnabled(false);
		jMenuItem1.repaint();
		
	}
	public void enableFileChooserItem(){
		jMenuItem1.setEnabled(true);
		jMenuItem1.repaint();
	}
	
	
 
 



	private javax.swing.ButtonGroup buttonGroup1;

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JTextField jTextField1;
	
	private boolean filechoosed=false;
	@SuppressWarnings("unused")
	private ArrayList<String> filepaths;
	private String filepath;
	private Model model;
	private Control controller;
	private int value;//for the JPRogressBar
	private Thread thread;
	@Override
	public void run() {
		try {
			Thread.sleep(10);
			if (model != null) {

				
				
				DecimalFormat df=new DecimalFormat("0.00");
				String sbpm=df.format(this.model.getBPM());
				this.jTextField1.setText(sbpm);

			jProgressBar1.setValue(value);
			
			if(this.model.getBPM()>0){
				
				this.jLabel1.setText("当前BPM: ");
				this.jLabel1.repaint();
				
			}else{
				this.jLabel1.setText("节拍");
				this.jLabel1.repaint();
			}
			jProgressBar1.repaint();
			this.jTextField1.repaint();
			
			
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	public void setControl(Control control) {
		this.controller=control;
		
	}

	
	
	
	

}