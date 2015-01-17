package view;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Maze extends Canvas{
	
	int[][] mazeBoard;
	
	GameCharacter c;
	Timer timer;
	TimerTask task;
	
	public Maze( Composite parent, int style, final int[][] mazeBoard){
		super(parent, style);
		this.mazeBoard=mazeBoard;
		setBackground(new Color(null, 179, 163, 148));
		
		c = new GameCharacter(10, 10);
		
		
		
		addPaintListener(new PaintListener(){

			public void paintControl(PaintEvent e) {
				e.gc.setForeground(new Color(null,255,0,0));
				   e.gc.setBackground(new Color(null,100,20,34));
				   int width=getSize().x;
				   int height=getSize().y;
				   Color c2 = new Color(null, 105, 90, 60);
				   Color c1 = new Color(null, 100,20,34);
			    //   Image image;
			       Image image = new Image(getDisplay(),"resources/images.jpg"); 
				//e.gc.setBackground(c2);
			      //  e.gc.fillRectangle(130, 15, 90, 60);
				//   GC s = new GC(image.getImageData().scaledTo(w, h)); 
			       
				   int w=width/mazeBoard[0].length;
				   int h=height/mazeBoard.length;
				   image.getImageData().scaledTo(w, h);
			        GC s = new GC(image); 
				   for(int i=0;i<mazeBoard.length;i++)
				      for(int j=0;j<mazeBoard[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          
				          if(mazeBoard[i][j]!=0&&mazeBoard[i][j]!=10){
				        	 /* e.gc.setBackground(c1);
				              e.gc.fillRectangle((int)(x*1.1), (int)(y*1.1),(int)(w/1.1),(int)(h/1.1));*/
				        	  s.fillRectangle((int)(x*1.1), (int)(y*1.1),(int)(w/1.1),(int)(h/1.1));
				          }
				          if(mazeBoard[i][j]==0){
				        	//  e.gc.s
				        	  
				        	  e.gc.setBackground(c2);
				        	  e.gc.fillRectangle((int)(x*1.1), (int)(y*1.1),(int)(w/1.1),(int)(h/1.1));
				          }
				          //e.gc.drawImage(image, srcX, srcY, srcWidth, srcHeight, destX, destY, destWidth, destHeight);
				          if(mazeBoard[i][j]==10){
				        	  e.gc.drawRectangle(x, y, w, h);
				        	  System.out.println("ssssssssss");
				          }
				        	  
				          
				      }
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


	public int[][] getMazeBoard() {
		return mazeBoard;
	}


	public void setMazeBoard(int[][] mazeBoard) {
		this.mazeBoard = mazeBoard;
		System.out.println("ssdggg");
	}
}
				
				
			


				
		
