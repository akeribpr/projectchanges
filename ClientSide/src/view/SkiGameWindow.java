package view;

//import model.Solution;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.Solution;
import model.algorithm.SearchDomain;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import presenter.Presenter;


public class SkiGameWindow extends UIView{
	
/*	private static final int diagonalleft = 0;
	private static final int left = 1;
	private static final int stright = 2;
	private static final int right = 3;
	private static final int diagonalright = 4;*/
	String[] moves;
	private String userAction;
	int currentMove;
	String algorithem;
	int[][] skiBoard;
	double totalScore;
	Ski ski;
	Timer timer;
	moveCharachter movement;
	
		public SkiGameWindow(Presenter presenter, Display display, int width,
				int height, String title,String algorithem) {
			super(presenter, display, width, height, title);
			this.algorithem=algorithem;
			moves=new String[]{"diagonalleft","left", "stright", "right", "diagonalright"};
			currentMove=2;
			
			      
	
		}
		
		@Override
		void initWidgets() {
			
			timer = new Timer();
			movement = new moveCharachter();
			
			userAction = "SelectDomain ski"; 
			SkiGameWindow.this.setChanged();
			SkiGameWindow.this.notifyObservers();	
			
			
			userAction = "SelectAlgorithm " + algorithem;
			SkiGameWindow.this.setChanged();
			SkiGameWindow.this.notifyObservers();	
			

			//shell.setLayout(new GridLayout(1, false));
			
			 Composite composite = new Composite(shell, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setLayout(new GridLayout(2, false));
			
			shell.setLayout(new GridLayout(1, false));
			      							
			
			Button start = new Button(composite, SWT.PUSH);
			start.setText("Start");
			start.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
			
			ski = new Ski (composite, SWT.BALLOON, skiBoard);
			ski.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,1,2));
	

			Button stop = new Button(composite, SWT.PUSH);
			stop.setText("Stop");
			stop.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
			
			start.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ski.start();	
				
				timer.scheduleAtFixedRate(movement, 0, 250);
				  /* if (currentMove==4){
				    	timer.scheduleAtFixedRate(new moveCharachter(), 0, 85);
				    }
				    if (currentMove==3){
				    	timer.scheduleAtFixedRate(new moveCharachter(), 0, 85*2);
				    }
				    if(currentMove!=4&&currentMove!=3)
				    	timer.scheduleAtFixedRate(new moveCharachter(), 0, (85*currentMove+1));*/
					
			}
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		
		});
			
			
			
		stop.addSelectionListener((new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ski.stop();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		
		}));
		Text text =new Text(composite, 0);
		text.addKeyListener(new org.eclipse.swt.events.KeyListener() {
			
			@Override
			public void keyReleased(org.eclipse.swt.events.KeyEvent arg0) {
				// TODO Auto-generated method stub4					
			}
			
			@Override
			public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
				
				System.out.println(e.keyCode);
				switch (e.keyCode){
				case 16777219:
				{
					if (currentMove>0){
						currentMove--;
						userAction="SelectMovesSki "+moves[currentMove];
						
					    }
					
					   }
					break;
				
				case 16777220:
				{
					if (currentMove<4){
						currentMove++;
						userAction="SelectMovesSki "+moves[currentMove];
					 
					}
					
					break;
				}
				
				}
				
			}
			
		});
		
	
	        
	    }
		
		
		private class moveCharachter extends TimerTask {
			
	        public void run() {
	        	synchronized (this) {
	        	try {
	        		switch (currentMove){
	        			case 0:{
	        					movement.wait(400);
	        					break;}
	        			case 1:{
	        					movement.wait(200);
	        					break;}
	        			case 2:{
        						movement.wait(100);
        						break;}
	        			
	        			case 3:{
	        					movement.wait(200);
	        					break;}
	        				
	        			case 4:{
	        					movement.wait(400);
	        					break;}
	        		}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	SkiGameWindow.this.setChanged();
				SkiGameWindow.this.notifyObservers();	
				updateSki();
	           }
	        }
	        }
		
		
		


		@Override
		public void start() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayCurrentState(SearchDomain searchDomain) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displaySolution(Solution solution) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getUserAction() {
			
			return userAction;
		}

		

		@Override
		public void updateGame(int[][] gameBoard,double totalScore) {
			this.skiBoard= gameBoard;
			this.totalScore=totalScore;
			System.out.println("dd");
			
			
		}
		public void updateSki() {
			this.ski.setSkiBoard(skiBoard);
			this.ski.setTotalScore(totalScore);
			System.out.println("dds");
		}

		@Override
		public void createMazeGame(SearchDomain searchDomain) {
			// TODO Auto-generated method stub
			
		}
		
		


	

}
