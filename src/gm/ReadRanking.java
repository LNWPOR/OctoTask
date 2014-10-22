package gm;

import java.io.File;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class ReadRanking {
	
	public Scanner rankingScanner;
	public static int[] list =new int [6];
	public Array sorterArray;
	
	public ReadRanking(){
		
		try{
			rankingScanner = new Scanner(new File("res/ranking.txt"));
			readFile();
			closeFile();
		}catch(Exception e){
			System.out.println("can not read ranking");
		}
		
	}
	
	public void readFile(){
		
		for(int i = 0 ; rankingScanner.hasNext();i++)
		{
			list[i] = Integer.parseInt(rankingScanner.next());
		}
		
		Arrays.sort(list);
		
		
	}
	
	public void showRanking(Graphics g){
		
		g.setColor(Color.red);
		for(int i =5;i>0;i--)
		{
			
			g.drawString("Rank "+(6-i)+":"+list[i], GameController.gameWidth/2 -40, GameController.gameHeight/2-50+(6-i)*30);
		}
	}
	
	public void closeFile(){
		rankingScanner.close();
	}
	
	

}
