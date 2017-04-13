package com.play;

public class Controlcs implements Control {

	public Controlcs(Control control){
		this.controller=control;
		this.model=control.getModel();
		this.view=controller.getView();
		
		this.view.setControl(this);
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		this.controller.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		this.controller.stop();
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub
		this.controller.increaseBPM();
	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		this.controller.decreaseBPM();
	}

	@Override
	public void setBPM(float bpm) {
		// TODO Auto-generated method stub
		this.controller.setBPM(bpm);
		
	}
	
	@Override
	public void setFilePath(String filePath) {
		// TODO Auto-generated method stub
		this.controller.setFilePath(filePath);
	}

	@Override
	public void setController(Control which) {
		// TODO Auto-generated method stub
		//this.stop();
		this.controller=which;
		
		this.model=which.getModel();
		this.view=which.getView();

		
		this.view.setControl(this);
		//if(!this.view.isFileChoosed()){
		//	this.view.disableStartMenuItem();
		//}
		this.view.pack();

	}
	
	@Override
	public View getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
	
	
	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	private Control controller;
	private View view;
	private Model model;
	

}
