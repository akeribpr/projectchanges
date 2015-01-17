package model.algorithm;

public interface HeuristicAlgorithmParam {
	double heuristic_cost_estimate(SearchDomain  domain,  State state);
}
