package model;

import java.io.Serializable;

import model.algorithm.SearchDomain;
import model.algorithm.Searcher;

public class Problem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private SearchDomain  domainName;
	private Searcher algorithmName;

	
	public SearchDomain getDomainName() {
		return domainName;
	}
	public void setDomainName(SearchDomain domainName) {
		this.domainName = domainName;
	}

	public Searcher getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(Searcher algorithmName) {
		this.algorithmName = algorithmName;
		
	}
}

