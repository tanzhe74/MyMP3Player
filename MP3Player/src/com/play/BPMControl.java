package com.play;

import com.play.Control;
import com.play.Model;
import com.play.View;

public class BPMControl implements Control{

	public BPMControl(Model heartadaptermodel,View view) {
		// TODO Auto-generated constructor stub
		this.model=heartadaptermodel;
		this.view=view;
		
		this.view.disableDecreaseButton();
		this.view.disableIncreaseButton();
		this.view.disableSetButton();
		this.view.disableStopMenuItem();
		this.view.disableTextField();
		this.view.disableFileChooserItem();
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
		this.view.disableStartMenuItem();
		this.view.enableStopMenuItem();
		this.model.startPlay(null);
		
		
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		this.view.enableStartMenuItem();
		this.view.disableStopMenuItem();
		this.model.stopPlay();
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBPM(float bpm) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	

	@Override
	public void setFilePath(String filePath) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
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
	@Override
	public void setController(Control which){
 		throw new UnsupportedOperationException();
 	}

	
	private View view;
	private Model model;
	
}

