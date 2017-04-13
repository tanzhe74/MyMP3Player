package com.play;

import java.awt.Component;
import java.net.URL;
public interface Model {

	public abstract float getBPM();

	public abstract void setBPM(float setbpm);

	public abstract void startPlay(URL url);

	public abstract void stopPlay();

	public abstract void registerObserver(ComObserver o);

	public abstract void removeObserver(ComObserver o);

	public abstract void notifyComponentObservers(Component comp);

	public abstract void notifyJPBarObservers();

	public abstract void notifyStopObservers();

	public abstract void notifySetStateObservers();
	
	public abstract void notifyDisableObservers();

	public abstract void calculateBPM(String filePaht);

}