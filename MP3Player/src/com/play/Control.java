package com.play;
public interface Control {

	public abstract void start();

	public abstract void stop();

	public abstract void increaseBPM();

	public abstract void decreaseBPM();

	public abstract void setBPM(float bpm);


	public abstract void setFilePath(String filePath);

	public abstract View getView();
	
	public abstract Model getModel();

	public abstract void setController(Control which);

}