package model;

import java.util.HashMap;
import model.algorithm.AStar;
import model.algorithm.BFS;
import model.algorithm.Searcher;


public class SearchAlgorithmsFactory {
	
	private HashMap<String, AlgorithmCreator> algoCreator;
		
	public SearchAlgorithmsFactory(){
	
		algoCreator=new HashMap<String, AlgorithmCreator>();
		algoCreator.put("astar", new AstarCreator());
		algoCreator.put("bfs", new BFSCreator());
	}
	
	public Searcher createAlgorithm(String algoName, String domainName)
	{		
		AlgorithmCreator creator = algoCreator.get(algoName);
		Searcher algorithm = null;
		if (creator != null) {
			algorithm = creator.create(domainName);			
		}
		return algorithm;
	}
	
	private interface AlgorithmCreator{
		Searcher create(String domainName);
	}
	
	private class BFSCreator implements AlgorithmCreator{

		@Override
		public Searcher create(String domainName) {
			return new BFS();
		}
		
	}
	
	private class AstarCreator implements AlgorithmCreator{

		@Override
		public Searcher create(String domainName) {
			return new AStar(new HeuristicFactory().createHeuristic(domainName));
		}
	}

}

