package com.play;
import java.awt.Component;
import java.net.URL;
import java.util.ArrayList;

import javax.media.*;

import com.device.*;

/**
 * 
 * @author No.Eccentric
 * BPM = Beat Per Minute，
 * 每分钟节拍数的单位。最浅显的概念就是在一分钟的时间段落之间，
 * 鼓总共发出了几次声音，这个数量的单位便是BPM。　 
 *
 */
public class MP3Model implements ControllerListener,Model{
	
	
	public MP3Model(){
	
			this.initialized=false;
			this.toSetBPM=this.bpm=0f;
			this.url=null;
			
			this.player=null;
			this.thread=null;
			
			
					
	}
	
	/* (non-Javadoc)
	 * @see Modele#getBPM()
	 */
	@Override
	public float getBPM(){
		/*if(this.initialized==false){
			return 1f;
		}else{
			return this.player.getRate();
		}*/
		return this.toSetBPM;
	}
	/* (non-Javadoc)
	 * @see Modele#setBPM(float)
	 */
	@Override
	public void setBPM(float setbpm){
		
		this.toSetBPM=setbpm;
		if(this.initialized==true){
			
			this.player.setRate(this.toSetBPM/this.bpm);
			
		
		}
			 this.notifyJPBarObservers();
		
		
		
	}

//	关闭先前的媒体播放器
	private void closePreviosPlayer()
	{
		if(this.player == null)
			return;
		this.player.stop();      
		this.player.deallocate(); //停止播放并且重新装载DataSource
  
		
	}


	@Override
	public void controllerUpdate(ControllerEvent event) {
		// TODO Auto-generated method stub
		
		// 当实例化后
		  if (event instanceof RealizeCompleteEvent) {
			  
			  this.initialized=true;
			  if(this.toSetBPM==0f){
				  this.player.setRate(1f);
				
			  }else{
				  this.player.setRate(this.player.setRate(this.toSetBPM/this.bpm));
			  }
			  
			  this.notifyComponentObservers( player.getControlPanelComponent());
		
				return;
			}
		  // 当预提取媒体的内容结束
		  if (event instanceof PrefetchCompleteEvent) {
		  this.player.start();
		  
		   return;
		  }
		// 当媒体播放结束时,循环播放
		  if (event instanceof EndOfMediaEvent) {
			  this.stopPlay();
			  this.player.setRate(1f);
			  this.setBPM(0f);
			  
		  return;
		  }
		  if(event instanceof RateChangeEvent){
			  if(player!=null){
				 // this.notifyJPBarObservers();
			  }
			  return;
		  }

		  // 当预提取媒体的内容结束
		  if (event instanceof PrefetchCompleteEvent) {
		  this.player.start();
		  return;
		  }
		  
}
	
	

	/* (non-Javadoc)
	 * @see Modele#startPlay(java.net.URL)
	 */
	
	@Override
     public void startPlay(URL url) {
				// TODO Auto-generated method stub
		if(this.url!=null){
			if(this.url.equals(url)){
				this.setBPM(this.bpm);
				this.notifySetStateObservers();
			}
		}else{
			this.url=url;
			
		}
		this.closePreviosPlayer();
		try
		{
			//为文件创建播放器
			this.player = Manager.createPlayer(url);
			
   
			player.addControllerListener(this);
			player.prefetch();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see Modele#stopPlay()
	 */

	@Override
	public void stopPlay() {
		// TODO Auto-generated method stub
		 if (player != null) {
			 this.initialized=false;
				this.player.stop();
				this.player.setMediaTime(new Time(0));
				this.setBPM(0f);
			
				notifyStopObservers();
				this.notifyComponentObservers(null);
				this.notifyDisableObservers();
				
			}
		
		
	}
	

	/* (non-Javadoc)
	 * @see Modele#registerObserver(StringObserver)
	 */

	@Override
	public void registerObserver(ComObserver o) {
		// TODO Auto-generated method stub
		this.componentObserver.add(o);
		
	}

	/* (non-Javadoc)
	 * @see Modele#removeObserver(StringObserver)
	 */

	@Override
	public void removeObserver(ComObserver o) {
		int i = this.componentObserver.indexOf(o);
		if (i >= 0) {
			componentObserver.remove(i);
		}
	}

	/* (non-Javadoc)
	 * @see Modele#registerObserver(JPBarObserver)
	 */

	
	/* (non-Javadoc)
	 * @see display.Subject#notifyComponentObservers(java.awt.Component)
	 */
	public void notifyComponentObservers(Component comp) {
		for(int i = 0; i < this.componentObserver.size(); i++) {
			ComObserver observer = componentObserver.get(i);
			observer.updateComponent(comp);
		}
	}
  
	
	/* (non-Javadoc)
	 * @see display.Subject#notifyJPBarObservers()
	 */
	public void notifyJPBarObservers() {
		for(int i = 0; i < this.componentObserver.size(); i++) {
			ComObserver observer = this.componentObserver.get(i);
			observer.updateJPBar(MP3Model.MAXVALUE);
		}
	}
	/* (non-Javadoc)
	 * @see display.Subject#notifyStopObservers()
	 */
	public void notifyStopObservers(){
		for(int i=0;i<this.componentObserver.size();i++){
			ComObserver stopoberserver=this.componentObserver.get(i);
			stopoberserver.updateStopStartState();

		}
	}
	/* (non-Javadoc)
	 * @see display.Subject#notifySetStateObservers()
	 */
	public void notifySetStateObservers() {
		// TODO Auto-generated method stub
		for(int i=0;i<this.componentObserver.size();i++){
			ComObserver stopoberserver=this.componentObserver.get(i);
			stopoberserver.updateCanSetState();

		}
	}
	@Override
	public void notifyDisableObservers() {
		// TODO Auto-generated method stub
		for(int i=0;i<this.componentObserver.size();i++){
			ComObserver stopoberserver=this.componentObserver.get(i);
			stopoberserver.updateDisableSetState();

		}
	}
	/**
	 * to play the mp3 format file
	 */
	private Player player;
	/**
	 * to identify if the player has initialized
	 */
	private boolean initialized;
	/*
	 * to store the bpm to be set, 
	 * when the player is not initialized
	 */
	private volatile float toSetBPM;
	
	/**
	 * the observer list of the component is"
	 */
	private ArrayList<ComObserver> componentObserver = new ArrayList<ComObserver>();
	
	/**
	 * the max value of the bpm
	 */

	public static final float MAXVALUE = 300f;
	
	/**
	 * to change the bpm ,i.e. ,rate
	 */
	
	@SuppressWarnings("unused")
	private Thread thread;
	
	private volatile float bpm;
	
	private URL url;
	
	
	
	

	@Override
	public void calculateBPM(final String filepath) {
		// TODO Auto-generated method stub
		
		
	    Thread thread=new Thread(new Runnable(){
	    	public void run(){
	    		CalculateBPM calculatebpm=new CalculateBPM(filepath);
	    		bpm=(float)calculatebpm.getBpm();
	    		System.out.println(bpm);
	    		toSetBPM=bpm;
	    		notifyJPBarObservers();
	    		notifySetStateObservers();
	    		
	    	}

			
	    });
	    thread.start();
		
	}

	

	
}
