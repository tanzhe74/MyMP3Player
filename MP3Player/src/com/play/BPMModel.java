package com.play;
import java.awt.Component;

import java.util.ArrayList;
import java.util.Random;

public class BPMModel implements Runnable {

	public BPMModel() {


		componentObserver = new ArrayList<ComObserver>();
		this.notifyComponentObservers(null);

		//time = 1000;

//		random = new Random(System.currentTimeMillis());

	}

	public void notifyComponentObservers(Component comp) {
		for (int i = 0; i < this.componentObserver.size(); i++) {
			ComObserver observer = componentObserver.get(i);
			observer.updateComponent(comp);
		}
	}

	public void notifyJPBarObservers() {
		for (int i = 0; i < this.componentObserver.size(); i++) {
			ComObserver observer = this.componentObserver.get(i);
			observer.updateJPBar(BPMModel.MAXVALUE);
		}
	}

	public void notifyStopObservers() {
		for (int i = 0; i <this.componentObserver.size(); i++) {
			ComObserver stopoberserver = this.componentObserver.get(i);
			stopoberserver.updateStopStartState();
		}
	}


	public void registerObserver(ComObserver o) {
		// TODO Auto-generated method stub
		this.componentObserver.add(o);
		
	}


	public void removeObserver(ComObserver o) {
		int i = this.componentObserver.indexOf(o);
		if (i >= 0) {
			componentObserver.remove(i);
		}
	}

	


	
	public void run() {
		/*int lastrate = -1;

		for (;;) {
			int change = random.nextInt(10);
			if (random.nextInt(2)==0) {
				
				change = 0-change;
			}
			
			int rate = 60000 / (time + change);
			if (rate < 120 && rate > 50) {
				time += change;

				if (rate != lastrate) {
					lastrate = rate;
					this.notifyJPBarObservers();
				}
			}
			//System.out.println("in the run of the heartbeat");
			 * */
			time=75;
			for(;;){
				Random a=new Random();
				time = 60+a.nextInt(30);
				notifyJPBarObservers();
				
				try {
					Thread.sleep(300);
				} catch (Exception e) {
				}
			}
			
		
	}

	public int getRate() {
		//return 60000 / time;
		return time;
	}
	
	
	 
	private ArrayList<ComObserver> componentObserver;
	/**
	 * the max value of the bpm
	 */

	public static final float MAXVALUE = 120f;

	private int time;

//	private Random random;
	


}
