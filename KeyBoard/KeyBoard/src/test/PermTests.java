package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import combinatorics.Permutation;
import combinatorics.PermutationImpl_Flores;





public class PermTests {

	private enum Vowel
	{
		A, E, I, O, U;
	}
	
	protected static <E> Permutation<E> getPermutation(Set<List<E>> cycles, Set<E> domain)
	{
		return new PermutationImpl_Flores<E>(cycles, domain);
	}
	
	@Test
	public void diffSizeDomainTest(){
		
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.A, Vowel.E);
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.U);
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		List<Vowel> cycle_UIAE2 = List.of(Vowel.U, Vowel.I, Vowel.A, Vowel.E);
		Set<List<Vowel>> cycles2 = Set.of(cycle_UIAE2);
		Set<Vowel> domain2 = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		Permutation<Vowel> p2 = getPermutation(cycles2, domain2);	
		
		assertEquals(false, p.equals(p2));
		
	}
	
	@Test
	public void diffDomainSameSizeTest(){
		
		List<Vowel> cycle_UIAE = List.of(Vowel.I);
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I);
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		List<Vowel> cycle_UIAE2 = List.of(Vowel.I);
		Set<List<Vowel>> cycles2 = Set.of(cycle_UIAE2);
		Set<Vowel> domain2 = Set.of(Vowel.I, Vowel.O, Vowel.U);
		Permutation<Vowel> p2 = getPermutation(cycles2, domain2);	
		
		assertEquals(false, p.equals(p2));
		
	}
	
	@Test(expected=AssertionError.class)
	public void nullInDomainTest(){
		
		List<Integer> cycle_UIAE = List.of(2, 0, 3);
		Set<List<Integer>> cycles = Set.of(cycle_UIAE);
		Set<Integer> domain = new HashSet<Integer>();
		domain.add(0);
		domain.add(1);
		domain.add(2);
		domain.add(3);
		domain.add(4);
		domain.add(null);
		domain.add(null);
		
		getPermutation(cycles, domain);
		
	}
	
	@Test(expected=AssertionError.class)
	public void nullInCyclesTest(){
		
		List<Vowel> cycle_UIAE = new ArrayList<Vowel>();
		cycle_UIAE.add(Vowel.A);
		cycle_UIAE.add(null);
		cycle_UIAE.add(Vowel.E);
		cycle_UIAE.add(Vowel.I);
		
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I);
		
		getPermutation(cycles, domain);
		
	}
	
	@Test(expected=AssertionError.class)
	public void nullCyclesTest(){
		
		Set<List<Vowel>> cycles = null;
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I);
		
		getPermutation(cycles, domain);
		
	}
	
	@Test(expected=AssertionError.class)
	public void nullDomainTest(){
		
		List<Vowel> cycle_UIAE = new ArrayList<Vowel>();
		cycle_UIAE.add(Vowel.A);
		cycle_UIAE.add(null);
		cycle_UIAE.add(Vowel.E);
		cycle_UIAE.add(Vowel.I);
		
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		Set<Vowel> domain = null;
		
		getPermutation(cycles, domain);
		
	}
	
	
	@Test(expected=AssertionError.class)
	public void cycleElementNotInDomain(){
		
		List<Vowel> cycle_UIAE = new ArrayList<Vowel>();
		cycle_UIAE.add(Vowel.E);
		cycle_UIAE.add(Vowel.I);
		List<Vowel> cycle_2 = List.of(Vowel.A);
		
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE, cycle_2);
		Set<Vowel> domain = Set.of(Vowel.E, Vowel.I);
		
		getPermutation(cycles, domain);
		
	}
	
	@Test
	public void cyclesAndDomainAreEmpty()
	{
		
		Set<List<Vowel>> cycles = new HashSet<List<Vowel>>();
		cycles.add(List.of());
		
		Set<Vowel> domain = new HashSet<Vowel>();
		
		getPermutation(cycles, domain);
		
	}
	
	@Test
	public void cyclesAreEmptyDomainIsNot() {
		
		List<Vowel> cycle_UIAE = List.of();
		
		Set<List<Vowel>> cycles = Set.of();
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		
		getPermutation(cycles, domain);
		
	}
	
	
	
	// Public Method Precondition checks
	
	@Test(expected=AssertionError.class)
	public void eNotInDomainOrCyclesGetImage()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.A, Vowel.E);
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		assertEquals(Vowel.E, p.getImage(Vowel.A));
		assertEquals(Vowel.U, p.getImage(Vowel.E));
		assertEquals(Vowel.A, p.getImage(Vowel.I));
		assertEquals(Vowel.O, p.getImage(Vowel.O));
		assertEquals(Vowel.I, p.getImage(Vowel.U));
		
		assertEquals(domain, p.getDomain());
	}
	
	
	@Test(expected=AssertionError.class)
	public void eNotInDomainGetImage()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.A, Vowel.E, Vowel.I);
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		assertEquals(Vowel.E, p.getImage(Vowel.A));
		assertEquals(Vowel.U, p.getImage(Vowel.E));
		assertEquals(Vowel.A, p.getImage(Vowel.I));
		assertEquals(Vowel.O, p.getImage(Vowel.O));
		assertEquals(Vowel.I, p.getImage(Vowel.U));
		
		assertEquals(domain, p.getDomain());
	}
	
	
	@Test(expected=AssertionError.class)
	public void eNotInDomainOrCyclesGetPreImage()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.A, Vowel.E);
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		assertEquals(Vowel.A, p.getPreImage(Vowel.E));
		assertEquals(Vowel.E, p.getPreImage(Vowel.I));
		assertEquals(Vowel.I, p.getPreImage(Vowel.U));
		assertEquals(Vowel.U, p.getPreImage(Vowel.A));
		assertEquals(Vowel.I, p.getPreImage(Vowel.U));
		
		assertEquals(domain, p.getDomain());
	}
	
	
	@Test(expected=AssertionError.class)
	public void eNotInDomainGetPreImage()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.A, Vowel.E, Vowel.I);
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		assertEquals(Vowel.A, p.getPreImage(Vowel.E));
		assertEquals(Vowel.E, p.getPreImage(Vowel.I));
		assertEquals(Vowel.I, p.getPreImage(Vowel.U));
		assertEquals(Vowel.U, p.getPreImage(Vowel.A));
		assertEquals(Vowel.I, p.getPreImage(Vowel.U));
		
		assertEquals(domain, p.getDomain());
	}
	
	
	
	
	
	
	
	
	//Equals Method Tests
	
	
	
	
	
	
	@Test
	public void EqualsMethodSameDomainsSameCycle()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.E);
		List<Vowel> cycle_O = List.of(Vowel.O);
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE, cycle_O);
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		assertEquals(Vowel.A, p.getImage(Vowel.A));
		assertEquals(Vowel.U, p.getImage(Vowel.E));
		assertEquals(Vowel.E, p.getImage(Vowel.I));
		assertEquals(Vowel.O, p.getImage(Vowel.O));
		assertEquals(Vowel.I, p.getImage(Vowel.U));
		
		assertEquals(domain, p.getDomain());

		List<Vowel> cycle_UIAE2 = List.of(Vowel.E, Vowel.U, Vowel.I);
		List<Vowel> cycle_O2 = List.of(Vowel.O);
		Set<List<Vowel>> cycles2 = Set.of(cycle_UIAE2, cycle_O2);
		Set<Vowel> domain1 = Set.of(Vowel.A, Vowel.O, Vowel.U, Vowel.E, Vowel.I);
		Permutation<Vowel> p2 = getPermutation(cycles2, domain1);
		
		assertEquals(Vowel.I, p2.getImage(Vowel.U));
		assertEquals(Vowel.U, p2.getImage(Vowel.E));
		assertEquals(Vowel.E, p2.getImage(Vowel.I));
		assertEquals(Vowel.O, p2.getImage(Vowel.O));
		
		assertEquals(Vowel.O, p2.getPreImage(Vowel.O));
		assertEquals(Vowel.E, p2.getPreImage(Vowel.U));
		assertEquals(Vowel.I, p2.getPreImage(Vowel.E));
		assertEquals(Vowel.A, p2.getPreImage(Vowel.A));
		assertEquals(Vowel.U, p2.getPreImage(Vowel.I));
		
		assertEquals(domain, p2.getDomain());
		
		assertEquals(p, p2);
	}
	
	@Test(expected=AssertionError.class)
	public void EqualsMethodDiffSizeDomainsSameCycle()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.E);
		List<Vowel> cycle_O = List.of(Vowel.O);
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE, cycle_O);
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		
		
		

		List<Vowel> cycle_UIAE2 = List.of(Vowel.E, Vowel.U, Vowel.I);
		List<Vowel> cycle_O2 = List.of(Vowel.O);
		Set<List<Vowel>> cycles2 = Set.of(cycle_UIAE2, cycle_O2);
		Set<Vowel> domain1 = Set.of(Vowel.O, Vowel.U, Vowel.E, Vowel.I);
		Permutation<Vowel> p2 = getPermutation(cycles2, domain1);
		
		
		
		
		
		assertEquals(p, p2);
	}
	
	
	@Test(expected=AssertionError.class)
	public void EqualsMethodSameSizeDomainsSameCycle()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.E);
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.U);
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		
		
		

		List<Vowel> cycle_UIAE2 = List.of(Vowel.I, Vowel.E, Vowel.U);
		
		Set<List<Vowel>> cycles2 = Set.of(cycle_UIAE2);
		Set<Vowel> domain1 = Set.of(Vowel.O, Vowel.U, Vowel.E, Vowel.I);
		Permutation<Vowel> p2 = getPermutation(cycles2, domain1);
		
		
		
		
		
		assertEquals(p, p2);
	}
	
	@Test(expected=AssertionError.class)
	public void EqualsMethodSameDomainsDiffCycle()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.E);
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.U);
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		
		
		

		List<Vowel> cycle_UIAE2 = List.of(Vowel.I, Vowel.U, Vowel.E);
		
		Set<List<Vowel>> cycles2 = Set.of(cycle_UIAE2);
		Set<Vowel> domain1 = Set.of(Vowel.A, Vowel.U, Vowel.E, Vowel.I);
		Permutation<Vowel> p2 = getPermutation(cycles2, domain1);
		
		
		
		
		
		assertEquals(p, p2);
	}
	
	
	
	
	
	
	//Duplicate cycles Tests
	
	
	
	
	@Test(expected=AssertionError.class)
	public void duplicateElementsInCyclesTest()
	{
		List<Vowel> cycle_IAE = List.of(Vowel.I, Vowel.A, Vowel.E);
		List<Vowel> cycle_UI = List.of(Vowel.U, Vowel.I);
		
		Set<List<Vowel>> cycles = Set.of(cycle_IAE, cycle_UI);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		

	}
	
	
	@Test
	public void permutationDoesNotEqualString()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.A, Vowel.E);
		List<Vowel> cycle_O = List.of(Vowel.O);
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE, cycle_O);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		
		assertNotEquals(p, "Ryan");
	}
	
	
	
	
	
	

}
