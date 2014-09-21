package Object;

public class MyClock {
	public int time =0;
	public int timePhone = 0;
	public int timeCal = 0;
	
	
	public int getTime(){
		return this.time/1000;
	}
	public int getTimePhone(){
	    return this.timePhone;	
	}
	public void render(){
		
	}
	public void update(int delta){
		this.time += delta;
	}
}
