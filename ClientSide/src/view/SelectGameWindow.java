package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;

import presenter.Presenter;

public class SelectGameWindow extends BasicWindow {

	public SelectGameWindow(Presenter presenter, int width,
			int height, String title) {
		super(presenter, width, height, title);
		// TODO Auto-generated constructor stub
	}

	/*public SelectGameWindow(Presenter presenter,, int width, int height, String title) {
		super(presenter,display, width, height, title);		
	}*/

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(1, false));
		
		final Combo combo = new Combo(shell, SWT.READ_ONLY);	
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		//combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	    String items[] = { "Ski", "Maze" };
	    combo.setItems(items);
	    
	    Button btnSelectModel = new Button(shell, SWT.PUSH);
	    btnSelectModel.setText("Start");
	    btnSelectModel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

	    btnSelectModel.addSelectionListener(new SelectionListener() {
			
		
			public void widgetSelected(SelectionEvent arg0) {
				// Choose window according to the game (using a factory)
				String selectedGame = combo.getText();
				if (selectedGame.equals("Maze")) {
					/*UIView window = new MazeGameWindow(presenter, display, 400, 300, "Maze Game");
					window.run();	*/			
					/*PropretiesWindow mazepro=new PropretiesWindow (presenter, display, 400,300,
							"Maze Propreties");*/
					MazePropreties mazepro =new MazePropreties(presenter, display, 400,300,
							"Maze Propreties");
					mazepro.run();
				}
				else { 
					SkiPropreties skipro = new SkiPropreties(presenter, display, 400, 300, "Ski Propreties");
					skipro.run();
				}
				shell.setVisible(false);
				
			}
			
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
