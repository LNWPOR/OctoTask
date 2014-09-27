package oj;

public class MyClock {
	public int time =0;
	
	public int getTime(){
		return this.time/1000;
	}
	public void update(int delta){
		this.time += delta;
	}
}
