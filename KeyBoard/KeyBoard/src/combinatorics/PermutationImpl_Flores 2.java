package combinatorics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import keyboard.Key;

public class PermutationImpl_Flores<E> implements Permutation<E>{

	Set<List<E>> cycles;
	Set<E> domain;
	
	public PermutationImpl_Flores(Set<List<E>> cycles, Set<E> domain) {
		assert domain != null: "Domain is null";
		assert cycles != null: "cycles is null";
		
		
		this.cycles = cycles;
		this.domain = domain;
		
		assert isNotANullInDomain(): "Null in domain";
		assert isNotANullInCycles(): "Null in cycles";
		assert isEveryCycleElementInDomain(): "Every element in cycles is not in domain";
		assert isNoDuplicateElementsInTheCyclesLists(): "Duplicate elements in cycles lists";
		
	}
	
	@Override
	public E getImage(E e) {
		assert getDomain().contains(e): "e not in domain";
		
		Iterator<List<E>> cyclesIterator = cycles.iterator();
		
		while (cyclesIterator.hasNext()) { // Iterate over every cycles list
			List<E> cycleList = cyclesIterator.next();
			
			for (int i = 0; i < cycleList.size(); i++) { // Iterate over the current list in cycles
				
				if ((cycleList.get(i) == e) && (i < cycleList.size() - 1)) { // if the index is equal to e and i is less then the last elements index, return the next index
					return cycleList.get(i + 1);
				}
				
				else if ((cycleList.get(i) == e) && (i == cycleList.size() - 1)) { // if the index is equal to e and i is equals the last elements index, return the index zero element
					return cycleList.get(0);
				}
				
			}
			
		}
		return e;
	}
	
	

	@Override
	public E getPreImage(E e) {
		assert getDomain().contains(e): "e not in domain";
		Iterator<List<E>> cyclesIterator = cycles.iterator();
		
		while (cyclesIterator.hasNext()) { // Iterate over every cycles list
			List<E> cycleList = cyclesIterator.next();
			
			for (int i = 0; i < cycleList.size(); i++) { // Iterate over the current list in cycles
				
				if ((cycleList.get(i) == e) && (i > 0)) { // if the index is equal to e and i is greater then the zero index, return the previous index
					return cycleList.get(i - 1);
				}
				
				else if ((cycleList.get(i) == e) && (i == 0)) { // if the index is equal to e and i is equal the zero index, return the largest elements index
					return cycleList.get(cycleList.size() - 1);
				}
				
			}
			
		}
		return e;
	}

	@Override
	public Set<E> getDomain()	{
		return domain;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		
		 if (!(obj instanceof PermutationImpl_Flores)) {
	          return false;
	      }
		
		Permutation<E> other = (PermutationImpl_Flores<E>) obj;
		
		if (this.getDomain().size() != other.getDomain().size()) {
			return false;
		}
		
		Iterator<E> domainIterator1 = domain.iterator();
		while (domainIterator1.hasNext()) {
			E domainElement1 = domainIterator1.next();
			
			if (!(this.getDomain().contains(domainElement1) && other.getDomain().contains(domainElement1))) {
				return false;
			}
			
			
		}
		
        
		
		Iterator<E> domainIterator2 = domain.iterator();
		
		while (domainIterator2.hasNext()) { // Iterates over the domain, then tests getImage and getPreImage with each iteration
			E domainElement2 = domainIterator2.next();
			if (this.getImage(domainElement2) != other.getImage(domainElement2)) {
				return false;
			}
			if (this.getPreImage(domainElement2) != other.getPreImage(domainElement2)) {
				return false;
			}
		}
		return true;	
	}
	
	
	private boolean isEveryCycleElementInDomain() {
		
		Iterator<List<E>> cyclesIterator = cycles.iterator();
		
		while (cyclesIterator.hasNext()) { // Iterate over every cycles list
			List<E> cycleList = cyclesIterator.next();
			
			for (int i = 0; i < cycleList.size(); i++) { // Iterate over the current list in cycles
		
				if (!domain.contains(cycleList.get(i))) {
					return false;
				}
				
			}
		}
		return true;
	}
		
	private boolean isNoDuplicateElementsInTheCyclesLists() {
		Set<E> ElementsFound = new HashSet<E>();
		
		Iterator<List<E>> cyclesIterator = cycles.iterator();
		
		while (cyclesIterator.hasNext()) { // Iterate over every cycles list
			List<E> cycleList = cyclesIterator.next();
			
			for (int i = 0; i < cycleList.size(); i++) { // Iterate over the current list in cycles
				
				if (ElementsFound.contains(cycleList.get(i))) {return false;}
				else {ElementsFound.add(cycleList.get(i));}
			}
		}
		return true;
	}
	

	
	private boolean isNotANullInDomain() {
		Iterator<E> domainIterator = domain.iterator();
		while(domainIterator.hasNext()) {
			E currElementInDomain = domainIterator.next();
			
			if (currElementInDomain == null) {
				return false;
			}
			
		}
		return true;
	}
	
	private boolean isNotANullInCycles() {
		Iterator<List<E>> cyclesIterator = cycles.iterator();
		while(cyclesIterator.hasNext()) {
			List<E> currListInCycles = cyclesIterator.next();
			
			for (int i = 0; i < currListInCycles.size(); i++) {
				if (currListInCycles.get(i) == null) {
					return false;
				}
			}
			
		}
		return true;
	}


	
}