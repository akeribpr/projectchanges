package view;

//import model.Solution;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Solution;
import model.algorithm.Action;
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


public class MazeGameWindow extends UIView{
	
	private String userAction;
	String algorithem;
	int[][] mazeBoard;
	Maze maze;
	
	
		public MazeGameWindow(Presenter presenter, Display display, int width,
				int height, String title,String algorithem) {
			super(presenter, display, width, height, title);
			this.algorithem=algorithem;
			
			      
			
		}
		
		@Override
		void initWidgets() {
			
			userAction = "SelectDomain maze"; 
			MazeGameWindow.this.setChanged();
			MazeGameWindow.this.notifyObservers();	
			
			
			userAction = "SelectAlgorithm " + algorithem;
			MazeGameWindow.this.setChanged();
			MazeGameWindow.this.notifyObservers();	
			

			//shell.setLayout(new GridLayout(1, false));
			
			 Composite composite = new Composite(shell, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setLayout(new GridLayout(2, false));
			
			shell.setLayout(new GridLayout(1, false));
			      							
			
			Button start = new Button(composite, SWT.PUSH);
			start.setText("Start");
			start.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
			
			Button solve = new Button(composite, SWT.PUSH);
			start.setText("Solve");
			start.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
			
			maze = new Maze (composite, SWT.BALLOON, mazeBoard);
			maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,1,2));
	

			Button stop = new Button(composite, SWT.PUSH);
			stop.setText("Stop");
			stop.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
			
			solve.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					userAction = "SolveDomain .";
					MazeGameWindow.this.setChanged();
					MazeGameWindow.this.notifyObservers();	
					
				}
				
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					
				}
			
			});
			
			start.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				maze.start();	
				
			}
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		
		});
			
			
			
		stop.addSelectionListener((new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				maze.stop();
				
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
				case 16777220:
				{
					userAction = "SelectMovesMaze right";
					MazeGameWindow.this.setChanged();
					MazeGameWindow.this.notifyObservers();	
					updateMaze();
					System.out.println("right");
					break;
					
				}
				
				case 16777219:
				{
					userAction = "SelectMovesMaze left";
					MazeGameWindow.this.setChanged();
					MazeGameWindow.this.notifyObservers();	
					updateMaze();
					break;
				}
				case 16777217:
				{
					userAction = "SelectMovesMaze up";
					MazeGameWindow.this.setChanged();
					MazeGameWindow.this.notifyObservers();	
					updateMaze();
					break;
				}
				case 16777218:
				{
					userAction = "SelectMovesMaze down";
					MazeGameWindow.this.setChanged();
					MazeGameWindow.this.notifyObservers();	
					updateMaze();
					break;
				}
				
				}
				
			}
		});
		
		
		
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
			for(Action a : solution.getActions()){
				System.out.println(a);
				/*userAction = "SelectMovesMaze" +a ;
				MazeGameWindow.this.setChanged();
				MazeGameWindow.this.notifyObservers();	
				updateMaze();*/
			}
			
		}

		@Override
		public String getUserAction() {
			
			return userAction;
		}

		

		@Override
		public void createMazeGame(SearchDomain searchDomain) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateGame(int[][] gameBoard,double totalScore) {
			this.mazeBoard= gameBoard;
			System.out.println("dd");
			
			
		}
		public void updateMaze() {
			this.maze.setMazeBoard(mazeBoard);
			System.out.println("dds");
		}
		
		


	

}
