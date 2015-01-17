package model;

import java.util.HashMap;


import model.algorithm.BFS;
import model.algorithm.Game;
import model.algorithm.Game2;
import model.algorithm.SearchDomain;
import model.domains.MazeGameDomain;
import model.domains.SkiGameDomain;



public class DomainFactory {
	
	private HashMap<String,SearchDomain> domains;
	
	public DomainFactory(){
		
		BFS s= new BFS();
		Game game=new Game();
		Game2 game2=new Game2();
		while (s.search(new MazeGameDomain(game2))==null){ //finds a solvable MazeBoard
			game2=new Game2();
		}
		
		domains =new HashMap<String,SearchDomain>();
		domains.put("ski",new SkiGameDomain(game));
		domains.put("maze",new MazeGameDomain(game2));
	}
	
	public SearchDomain createDomain(String domainName)
	{
		SearchDomain domain = null;
		SearchDomain creator = domains.get(domainName);
		if (creator != null) {
			domain = creator;			
		}
		return domain;
	}
	
}
	