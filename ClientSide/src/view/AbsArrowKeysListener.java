package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

import common.Keys;


/**
 * Abstract Arrow class implements KeysListener
 * @author Tzelon Machluf and Jasmine Nouriel
 *
 */
public abstract class AbsArrowKeysListener implements KeyListener {

	/**
	 * Support keys UP, DOWN, LEFT, RIGHT
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		setInstructions(false);
		System.out.println("toto");
		switch (e.keyCode) {
		case SWT.ARROW_DOWN:
			setUserCommand("down");
			break;
		case SWT.ARROW_UP:
			setUserCommand("up");
			break;
		case SWT.ARROW_LEFT:
			setUserCommand("left");
			break;
		case SWT.ARROW_RIGHT:
			setUserCommand("right");
			break;
		default:
			setInstructions(true);
			break;	
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	
	public abstract void setUserCommand(String userCommand);
	public abstract void setInstructions(Boolean flag);
}
