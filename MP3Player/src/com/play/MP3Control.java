package com.play;
import java.net.MalformedURLException;
import java.net.URL;

import com.play.Control;
import com.play.Model;
import com.play.View;


public class MP3Control implements Control{
	
	public MP3Control(Model model,View view) {
		this.model = model;
		
		this.view=view;
						
		this.filepath="";
		
		this.view.disableStopMenuItem();
		this.view.disableStartMenuItem();
		this.view.enableFileChooserItem();
		this.view.disableDecreaseButton();
		this.view.disableIncreaseButton();
		this.view.disableTextField();
		this.view.disableSetButton();
		
	}
  
	@Override
	public void setFilePath(String filePath){
		
		
		this.filepath=filePath;
		view.enableStartMenuItem();
		this.model.calculateBPM(this.filepath);
		
	}
	/* (non-Javadoc)
	 * @see Control#start()
	 */
	@Override
	public void start() {
		
		
		URL mediaURL=null;
		try {
			mediaURL = new URL("file:"+this.filepath);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.startPlay(mediaURL);
		view.disableStartMenuItem();
		view.disableFileChooserItem();
		view.enableStopMenuItem();
	}
  
	/* (non-Javadoc)
	 * @see Control#stop()
	 */
	@Override
	public void stop() {
		
		model.stopPlay();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		view.enableFileChooserItem();
		
	}
    
	/* (non-Javadoc)
	 * @see Control#increaseBPM()
	 */
	@Override
	public void increaseBPM() {
        float bpm = model.getBPM();
        model.setBPM(bpm + 1f);
	}
    
	/* (non-Javadoc)
	 * @see Control#decreaseBPM()
	 */
	@Override
	public void decreaseBPM() {
        float bpm = model.getBPM();
        model.setBPM(bpm - 1f);
  	}
  
 	/* (non-Javadoc)
	 * @see Control#setBPM(float)
	 */
 	@Override
	public void setBPM(float bpm) {
 		
		model.setBPM(bpm);
	}
 	
 	@Override
	public void setController(Control which){
 		throw new UnsupportedOperationException();
 	}
 	@Override
 	public View getView(){
 		return this.view;
 	}
 	
	
	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
 	
 	private Model model;
	private View view;
	private String filepath;

   
}
