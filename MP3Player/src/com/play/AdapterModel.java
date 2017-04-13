package com.play;
import java.awt.Component;
import java.net.URL;


public class AdapterModel implements Model {

	public AdapterModel(){
		this.heartbeatmodle=new BPMModel();
	}
	@Override
	public float getBPM() {
		// TODO Auto-generated method stub
		if(this.startthread!=null)
	  {
			
			return	this.heartbeatmodle.getRate();
										
	  }else{
		  return 0f;
	  }
	}

	@Override
	public void setBPM(float setbpm) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
		
	}

	@Override
	public void calculateBPM(String filepath) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	
	@Override
	public void startPlay(URL url) {
		// TODO Auto-generated method stub
		this.startthread=new Thread(this.heartbeatmodle);
		this.startthread.start();

	}

	@SuppressWarnings("deprecation")
	@Override
	public void stopPlay() {
		if(this.startthread!=null){
		
			this.startthread.stop();
			
			this.startthread=null;
		this.notifyStopObservers();
		this.notifyJPBarObservers();
		
	    		
		}
		
		
		

	}

	@Override
	public void registerObserver(ComObserver o) {
		// TODO Auto-generated method stub

		this.heartbeatmodle.registerObserver(o);
	}

	@Override
	public void removeObserver(ComObserver o) {
		// TODO Auto-generated method stub

		this.heartbeatmodle.registerObserver(o);
	}


	private BPMModel heartbeatmodle;
	private Thread startthread;
	@Override
	public void notifyComponentObservers(Component comp) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}
	@Override
	public void notifyJPBarObservers() {
		// TODO Auto-generated method stub
		this.heartbeatmodle.notifyJPBarObservers();
	}
	@Override
	public void notifySetStateObservers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}
	@Override
	public void notifyStopObservers() {
		this.heartbeatmodle.notifyStopObservers();
		
	}
	@Override
	public void notifyDisableObservers() {
		// TODO Auto-generated method stub
		

		throw new UnsupportedOperationException();
		
		}
	}
	

