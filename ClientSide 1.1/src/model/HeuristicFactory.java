package model;

import java.util.HashMap;

import model.algorithm.HeuristicAlgorithmParam;
import model.domains.HeuristicDomainParam;

public class HeuristicFactory {
private HashMap<String, HeuristicCreator> heuristics;
	
	public HeuristicFactory(){
		heuristics = new HashMap<String, HeuristicCreator>();
		heuristics.put("maze", new MazeHeuristicCreator());
		heuristics.put("ski", new SkiHeuristicCreator());
	}
	
	public HeuristicAlgorithmParam createHeuristic(String domainName)
	{
		HeuristicCreator creator = heuristics.get(domainName);
		HeuristicAlgorithmParam heuristic = null;
		if (creator != null)  {
			heuristic = creator.create(domainName);			
		}
		return heuristic;
	}
	
	private interface HeuristicCreator{
		HeuristicAlgorithmParam create(String domainName);
	}
	
	private class MazeHeuristicCreator implements HeuristicCreator{

		@Override
		public HeuristicAlgorithmParam create(String domainName) {
			return new HeuristicDomainParam();
		}
		
	}
	
	private class SkiHeuristicCreator implements HeuristicCreator{

		@Override
		public HeuristicAlgorithmParam create(String domainName) {
			return new HeuristicDomainParam();
		}
	}

}
