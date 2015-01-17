package view;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Ski extends Canvas{
	
	int[][] SkiBoard;
	double totalScore;
	
	GameCharacter c;
	Timer timer;
	TimerTask task;
	
	public Ski( Composite parent, int style, final int[][] SkiBoard){
		super(parent, style);
		this.SkiBoard=SkiBoard;
		//this.totalScore=(double) 0;
		setBackground(new Color(null, 255, 255, 255));
		
		c = new GameCharacter(10, 10);
		
		
		
		addPaintListener(new PaintListener(){

			public void paintControl(PaintEvent e) {
				e.gc.setForeground(new Color(null,255,0,0));
				   e.gc.setBackground(new Color(null,255,255,255));
				   int width=getSize().x;
				   int height=getSize().y;

				   int w=width/SkiBoard[0].length;
				   int h=height/SkiBoard.length;

				   for(int i=0;i<SkiBoard.length;i++)
				      for(int j=0;j<SkiBoard[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          if(SkiBoard[i][j]!=0&&SkiBoard[i][j]!=10)
				              e.gc.fillRectangle(x,y,w,h);
				          if(SkiBoard[i][j]==10){
				        	  e.gc.drawRectangle(x, y, w, h);
				        	  System.out.println("ssssssssss");
				          }
				          System.out.println(totalScore);
				        	  
				          
				      }
				   //this.validate();
				   
				   c.paint(e, w, h);
				  // e.gc.drawImage(new Image image ("resources/images"), x, y);
				   
				}
		});
		

		
		addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				stop();
			}
		});
	
		addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				stop();
			}
		});
	} 	  
			          
		        	  

	
	
	public void start() {
		timer = new Timer();
		task = new TimerTask()
		{

			@Override
			public void run() {
				getDisplay().syncExec(new Runnable() {
					
					@Override
					public void run() {
						Random r = new Random();
						c.x +=- 5+r.nextInt(11);
						c.y +=- 5+r.nextInt(11);
						redraw();
						
					
					}
				});
				
				
			}
		};
		timer.scheduleAtFixedRate(task, 0, 250);
	
	}
	
	public void stop() {
		if(task!=null)
			task.cancel();
		if(timer!=null)
			timer.cancel();
	}


	public int[][] getSkiBoard() {
		return SkiBoard;
	}


	public void setSkiBoard(int[][] SkiBoard) {
		this.SkiBoard = SkiBoard;
		System.out.println("ssdggg");
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
}