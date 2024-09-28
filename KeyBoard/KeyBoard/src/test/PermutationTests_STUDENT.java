package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import combinatorics.Permutation;
import combinatorics.PermutationImpl_Flores;

public class PermutationTests_STUDENT
{
	private enum Vowel
	{
		A, E, I, O, U;
	}
	
	protected static <E> Permutation<E> getPermutation(Set<List<E>> cycles, Set<E> domain)
	{
		return new PermutationImpl_Flores<E>(cycles, domain);
	}
	
	@Test
	public void vowelTest()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.A, Vowel.E);
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		assertEquals(Vowel.E, p.getImage(Vowel.A));
		assertEquals(Vowel.U, p.getImage(Vowel.E));
		assertEquals(Vowel.A, p.getImage(Vowel.I));
		assertEquals(Vowel.O, p.getImage(Vowel.O));
		assertEquals(Vowel.I, p.getImage(Vowel.U));
		
		assertEquals(domain, p.getDomain());
	}
	
	@Test
	public void vowelTest2()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.A, Vowel.E);
		List<Vowel> cycle_O = List.of(Vowel.O);
		
		Set<List<Vowel>> cycles = Set.of(cycle_UIAE, cycle_O);
		
		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		
		Permutation<Vowel> p = getPermutation(cycles, domain);
		
		assertEquals(Vowel.E, p.getImage(Vowel.A));
		assertEquals(Vowel.U, p.getImage(Vowel.E));
		assertEquals(Vowel.A, p.getImage(Vowel.I));
		assertEquals(Vowel.O, p.getImage(Vowel.O));
		assertEquals(Vowel.I, p.getImage(Vowel.U));
		
		assertEquals(domain, p.getDomain());

		List<Vowel> cycle_UIAE2 = List.of(Vowel.A, Vowel.E, Vowel.U, Vowel.I);
		
		Set<List<Vowel>> cycles2 = Set.of(cycle_UIAE2);
		
		Permutation<Vowel> p2 = getPermutation(cycles2, domain);
		
		assertEquals(Vowel.E, p2.getImage(Vowel.A));
		assertEquals(Vowel.U, p2.getImage(Vowel.E));
		assertEquals(Vowel.A, p2.getImage(Vowel.I));
		assertEquals(Vowel.O, p2.getImage(Vowel.O));
		assertEquals(Vowel.I, p2.getImage(Vowel.U));
		
		assertEquals(domain, p2.getDomain());
		
		assertEquals(p, p2);
	}
	
	@Test(expected=AssertionError.class)
	public void vowelTest_DomainDoesntContainEachElementInEachCycle()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.A, Vowel.E);

		Set<List<Vowel>> cycles = Set.of(cycle_UIAE);
		
		Set<Vowel> domain = Set.of(Vowel.A);
		
		getPermutation(cycles, domain);
	}
	
	@Test(expected=AssertionError.class)
	public void vowelTest_CyclesOverlap()
	{
		List<Vowel> cycle_UIAE = List.of(Vowel.U, Vowel.I, Vowel.A, Vowel.E);
		List<Vowel> cycle_EU = List.of(Vowel.E, Vowel.U);

		Set<List<Vowel>> cycles = Set.of(cycle_UIAE, cycle_EU);

		Set<Vowel> domain = Set.of(Vowel.A, Vowel.E, Vowel.I, Vowel.O, Vowel.U);
		
		getPermutation(cycles, domain);
	}
}
