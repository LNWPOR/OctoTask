package gm;

import java.util.Arrays;
import java.util.Formatter;

public class WritingRanking {

	public static int scoreToWrite=0;
	public Formatter writter;
	
	public WritingRanking(){
		try{
			writter = new Formatter("res/ranking.txt");
			addRecords();
			writter.close();
		}catch(Exception e){
			System.out.println("Ranking error");
		}
	}
	
	public void addRecords(){
		
		ReadRanking.list[0] = scoreToWrite;
		scoreToWrite=0;
		Arrays.sort(ReadRanking.list);
		
		
		for(int i = 0;i<6;i++){
			writter.format("%d ",ReadRanking.list[i]);
		}
		
	}
	
	public void closeFile(){
		
		writter.close();
	}
}
