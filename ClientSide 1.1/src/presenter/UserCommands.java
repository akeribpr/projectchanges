package presenter;

import java.util.HashMap;


import model.Model;
import model.MyModel;


public class UserCommands {

	private HashMap<String, Command> commands = 
			new HashMap<String,Command>();
	
	public UserCommands()
	{
		commands.put("SelectDomain", new SelectDomainCommand());
		commands.put("SelectAlgorithm", new SelectAlgorithmCommand());
		commands.put("SolveDomain", new SolveDomainCommand());
		commands.put("SelectMovesMaze", new SelectMovesMaze());
		commands.put("SelectMovesSki", new SelectMovesSki());
	}

	public Command selectCommand(String commandName)
	{
		Command command = commands.get(commandName);
		return command;
	}
	
	public interface Command
	{
		Model doCommand(Model model, String args);
	}
	
	private class SelectDomainCommand implements Command
	{
		public Model doCommand(Model model, String args) {
			Model m = new MyModel();
			m.selectDomain(args);	
			return m;
		}		
	}
	
	private class SelectAlgorithmCommand implements Command
	{
		public Model doCommand(Model model, String args) {
			model.selectAlgorithm(args);
			return model;
		}		
	}
	
	private class SolveDomainCommand implements Command
	{
		public Model doCommand(Model model, String args) {
			model.solveDomain();	
			return model;
		}		
	}
	

	private class SelectMovesMaze implements Command
	{
		public Model doCommand(Model model, String args)
		{
			model.selectMove(args);
			return model;
		}
	}
	
	private class SelectMovesSki implements Command
	{
		public Model doCommand(Model model, String args)
		{
			model.selectMove(args);
			return model;
		}
	}
	
}

		
	
	




