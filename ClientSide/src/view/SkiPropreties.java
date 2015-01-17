package view;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;


import presenter.Presenter;

public class SkiPropreties extends PropretiesWindow{
	
	private Presenter presenter;

	public SkiPropreties(Presenter presenter,Display display, int width, int height,
			String title) {
		super(presenter,display, width, height, title);	
		this.presenter=presenter;
	}

	@Override
	void initWidgets() {
		//userAction=null;
		shell.setLayout(new GridLayout(2, false));
		
		Label lblAlgorithm = new Label(shell, SWT.NONE);
		lblAlgorithm.setText("Choose algorithm: ");
		
		final Combo combo = new Combo(shell, SWT.READ_ONLY);	
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
	    String items[] = { "bfs", "astar" };
	    combo.setItems(items);
		
		Button btnSearch = new Button(shell, SWT.PUSH);
		//Maze maze = new Maze(shell, SWT.BORDER);
		btnSearch.setText("Start");
		btnSearch.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		
		
		
		
		//lstActions = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		//lstActions.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
				
		btnSearch.addSelectionListener(new SelectionListener() {
			
			
			public void widgetSelected(SelectionEvent arg0) {	
				/*userAction = "SelectDomain maze"; 
				MazePropreties.this.setChanged();
				MazePropreties.this.notifyObservers();	
				
				userAction = "SelectAlgorithm " + combo.getText();
				MazePropreties.this.setChanged();
				MazePropreties.this.notifyObservers();	*/
				
					
				/*userAction = "SolveDomain";
				SkiGameWindow.this.setChanged();
				SkiGameWindow.this.notifyObservers();*/
				
				/*String selectedGame = combo.getText();
				 if (selectedGame.equals("BFS"||"A-Star")) {*/
				/*BasicWindow s1 = new SkiGameWindow(presenter, display, 10, 10,"Ski Game");
				s1.run;*/
				//UIView window = new SkiGameWindow(presenter, display, 400, 300, "Ski Game");	
				//Display display = new Display();
				String algoritemName=combo.getText();
				
				UIView  m = new SkiGameWindow(presenter,null,400,400,"Ski Game", algoritemName);
				m.run();
				
				
			}
			
		
			public void widgetDefaultSelected(SelectionEvent arg0) {
								
			}
		});
	}

}

