/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 2009 http://www.streamhead.com
 */
package com.device;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * @author Peter Backx
 */
public class CalculateBPM implements Runnable {


    public CalculateBPM(String filepath){
    	this.filepath=filepath;
    	this.bpm=50;
    	this.calBPM();
    	
    }
    public void calBPM() {
       //
		// Thread thread=new Thread(this);
		// thread.start();
		 //try {
		//	thread.join();
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
      //  
    	BPM2SampleProcessor processor = new BPM2SampleProcessor();
        processor.setSampleSize(1024);
        EnergyOutputAudioDevice output = new EnergyOutputAudioDevice(processor);
        output.setAverageLength(1024);
        //Player player;
		try {
			File file=new File(this.filepath);
			long filelength=file.length();
			FileInputStream fileinputstream=new FileInputStream(this.filepath);
			//fileinputstream.skip(1024*1024*3);
			fileinputstream.skip(399*filelength/400);
			player = new Player(new FileInputStream(this.filepath), output);
			 player.getPosition();
	         player.play();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
       this.bpm=processor.getBPM();
    }
    
  
    public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getBpm() {
		return bpm;
	}
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}


	private String filepath;
    private Player player;
    private volatile int bpm;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BPM2SampleProcessor processor = new BPM2SampleProcessor();
        processor.setSampleSize(1024);
        EnergyOutputAudioDevice output = new EnergyOutputAudioDevice(processor);
        output.setAverageLength(1024);
        //Player player;
		try {
			File file=new File(this.filepath);
			long filelength=file.length();
			FileInputStream fileinputstream=new FileInputStream(this.filepath);
			//fileinputstream.skip(1024*1024*3);
			fileinputstream.skip(399*filelength/400);
			player = new Player(new FileInputStream(this.filepath), output);
			 player.getPosition();
	         player.play();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
       this.bpm=processor.getBPM();
       
    
       
   	
		
	}
    
}
