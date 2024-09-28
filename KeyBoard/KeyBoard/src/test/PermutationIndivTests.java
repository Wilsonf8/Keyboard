package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import combinatorics.Permutation;
import combinatorics.PermutationImpl_Flores;
//import keyboard.AppleNumericMB110LLKeyboardMetricsImpl_Flores;
import keyboard.Key;

public class PermutationIndivTests {

	public static void main(String[] args) {
		
		Set<List<Key>> cycles = new HashSet<List<Key>>();
		Set<Key> domain = new HashSet<Key>();
		
		domain.addAll(getQWERTYKeyToNeighborMap().keySet());
		
//		cycles.add(List.of(Key.A));
//		cycles.add(List.of(Key.B, Key.X, Key.B));
//		cycles.add(List.of(Key.C, Key.J, Key.C));
//		cycles.add(List.of(Key.D, Key.E, Key.S));
//		cycles.add(List.of(Key.E, Key.PERIOD, Key.F));
//		cycles.add(List.of(Key.F, Key.U, Key.T));
//		cycles.add(List.of(Key.G, Key.I, Key.D));
//		cycles.add(List.of(Key.H, Key.D, Key.H));
//		cycles.add(List.of(Key.I, Key.C, Key.U));
//		cycles.add(List.of(Key.J, Key.H, Key.N));
//		cycles.add(List.of(Key.K, Key.T, Key.E));
//		cycles.add(List.of(Key.L, Key.N, Key.I));
//		cycles.add(List.of(Key.M));
//		cycles.add(List.of(Key.N, Key.B, Key.K));
//		cycles.add(List.of(Key.O, Key.R, Key.Y));
//		cycles.add(List.of(Key.P, Key.L, Key.SEMICOLON));
//		cycles.add(List.of(Key.Q, Key.TICK, Key.Q));
//		cycles.add(List.of(Key.R, Key.P, Key.P));
//		cycles.add(List.of(Key.S, Key.O, Key.R));
//		cycles.add(List.of(Key.T, Key.Y, Key.G));
//		cycles.add(List.of(Key.U, Key.G, Key.L));
//		cycles.add(List.of(Key.V, Key.K, Key.V));
//		cycles.add(List.of(Key.W, Key.COMMA, Key.W));
//		cycles.add(List.of(Key.X, Key.Q, Key.X));
//		cycles.add(List.of(Key.Y, Key.F, Key.J));
//		cycles.add(List.of(Key.Z, Key.SEMICOLON, Key.Z));
//		
//		cycles.add(List.of(Key.ONE));
//		cycles.add(List.of(Key.TWO));
//		cycles.add(List.of(Key.THREE));
//		cycles.add(List.of(Key.FOUR));
//		cycles.add(List.of(Key.FIVE));
//		cycles.add(List.of(Key.SIX));
//		cycles.add(List.of(Key.SEVEN));
//		cycles.add(List.of(Key.EIGHT));
//		cycles.add(List.of(Key.NINE));
//		cycles.add(List.of(Key.ZERO));
//		
//		cycles.add(List.of(Key.BACKTICK));
//		cycles.add(List.of(Key.MINUS, Key.LEFT_BRACKET, Key.MINUS));
//		cycles.add(List.of(Key.EQUALS, Key.RIGHT_BRACKET, Key.EQUALS));
//		cycles.add(List.of(Key.TAB));
//		cycles.add(List.of(Key.LEFT_BRACKET, Key.FORESLASH, Key.LEFT_BRACKET));
//		cycles.add(List.of(Key.RIGHT_BRACKET, Key.EQUALS, Key.RIGHT_BRACKET));
//		cycles.add(List.of(Key.BACKSLASH));
//		cycles.add(List.of(Key.SEMICOLON, Key.S, Key.O));
//		cycles.add(List.of(Key.TICK, Key.MINUS, Key.TICK));
//		cycles.add(List.of(Key.SHIFT_1));
//		cycles.add(List.of(Key.COMMA, Key.W, Key.COMMA));
//		cycles.add(List.of(Key.PERIOD, Key.V, Key.PERIOD));
//		cycles.add(List.of(Key.FORESLASH, Key.Z, Key.FORESLASH));
//		cycles.add(List.of(Key.SHIFT_2));
		
		
		
		
		
		cycles.add(List.of(Key.A));
		cycles.add(List.of(Key.B, Key.X));
//		cycles.add(List.of(Key.C, Key.J, Key.C));
//		cycles.add(List.of(Key.D, Key.E, Key.S));
//		cycles.add(List.of(Key.E, Key.PERIOD, Key.F));
//		cycles.add(List.of(Key.F, Key.U, Key.T));
//		cycles.add(List.of(Key.G, Key.I, Key.D));
//		cycles.add(List.of(Key.H, Key.D, Key.H));
//		cycles.add(List.of(Key.I, Key.C, Key.U));
//		cycles.add(List.of(Key.J, Key.H, Key.N));
//		cycles.add(List.of(Key.K, Key.T, Key.E));
//		cycles.add(List.of(Key.L, Key.N, Key.I));
//		cycles.add(List.of(Key.M));
//		cycles.add(List.of(Key.N, Key.B, Key.K));
//		cycles.add(List.of(Key.O, Key.R, Key.Y));
//		cycles.add(List.of(Key.P, Key.L, Key.SEMICOLON));
		cycles.add(List.of(Key.Q, Key.TICK));
		cycles.add(List.of(Key.TICK));
		
		
		
//		cycles.add(List.of(Key.R, Key.P, Key.P));
//		cycles.add(List.of(Key.S, Key.O, Key.R));
//		cycles.add(List.of(Key.T, Key.Y, Key.G));
//		cycles.add(List.of(Key.U, Key.G, Key.L));
//		cycles.add(List.of(Key.V, Key.K, Key.V));
//		cycles.add(List.of(Key.W, Key.COMMA));
//		cycles.add(List.of(Key.X, Key.Q, Key.X));
//		cycles.add(List.of(Key.Y, Key.F, Key.J));
//		cycles.add(List.of(Key.Z, Key.SEMICOLON, Key.Z));
//		
//		cycles.add(List.of(Key.ONE));
//		cycles.add(List.of(Key.TWO));
//		cycles.add(List.of(Key.THREE));
//		cycles.add(List.of(Key.FOUR));
//		cycles.add(List.of(Key.FIVE));
//		cycles.add(List.of(Key.SIX));
//		cycles.add(List.of(Key.SEVEN));
//		cycles.add(List.of(Key.EIGHT));
//		cycles.add(List.of(Key.NINE));
//		cycles.add(List.of(Key.ZERO));
//		
//		cycles.add(List.of(Key.BACKTICK));
//		cycles.add(List.of(Key.MINUS, Key.LEFT_BRACKET, Key.MINUS));
//		cycles.add(List.of(Key.EQUALS, Key.RIGHT_BRACKET));
//		cycles.add(List.of(Key.TAB));
//		cycles.add(List.of(Key.LEFT_BRACKET, Key.FORESLASH, Key.LEFT_BRACKET));
////		cycles.add(List.of(Key.RIGHT_BRACKET, Key.EQUALS, Key.RIGHT_BRACKET));
//		cycles.add(List.of(Key.BACKSLASH));
//		cycles.add(List.of(Key.SEMICOLON, Key.S, Key.O));
//		cycles.add(List.of(Key.TICK, Key.MINUS, Key.TICK));
//		cycles.add(List.of(Key.SHIFT_1));
////		cycles.add(List.of(Key.COMMA, Key.W, Key.COMMA));
//		cycles.add(List.of(Key.PERIOD, Key.V, Key.PERIOD));
//		cycles.add(List.of(Key.FORESLASH, Key.Z, Key.FORESLASH));
//		cycles.add(List.of(Key.SHIFT_2));
		
		
		
		
		
		
		Permutation<Key> impl = new PermutationImpl_Flores<Key>(cycles, domain);
		
//		System.out.println(impl.getImage(Key.RIGHT_BRACKET));

	}
	
	private static Map<Key, Set<Key>> getQWERTYKeyToNeighborMap(){
		
		Map<Key, Set<Key>> keyToNeighborSetMap = new HashMap<>();
		
		//Letters
	
	    keyToNeighborSetMap.put(Key.A, Set.of(Key.Q, Key.W, Key.S, Key.Z, Key.SHIFT_1));
	    keyToNeighborSetMap.put(Key.B, Set.of(Key.V, Key.G, Key.H, Key.N, Key.SPACEBAR_3));
	    keyToNeighborSetMap.put(Key.C, Set.of(Key.X, Key.D, Key.F, Key.V, Key.SPACEBAR_1));
	    keyToNeighborSetMap.put(Key.D, Set.of(Key.S, Key.E, Key.R, Key.F, Key.C, Key.X));
	    keyToNeighborSetMap.put(Key.E, Set.of(Key.W, Key.THREE, Key.FOUR, Key.R, Key.D, Key.S));
	    keyToNeighborSetMap.put(Key.F, Set.of(Key.D, Key.R, Key.T, Key.C, Key.V, Key.G));
	    keyToNeighborSetMap.put(Key.G, Set.of(Key.F, Key.T, Key.Y, Key.H, Key.B, Key.V));
	    keyToNeighborSetMap.put(Key.H, Set.of(Key.G, Key.Y, Key.U, Key.J, Key.N, Key.B));
	    keyToNeighborSetMap.put(Key.I, Set.of(Key.U, Key.EIGHT, Key.NINE, Key.J, Key.K, Key.O));
	    keyToNeighborSetMap.put(Key.J, Set.of(Key.H, Key.U, Key.I, Key.K, Key.M, Key.N));
	    keyToNeighborSetMap.put(Key.K, Set.of(Key.J, Key.I, Key.O, Key.L, Key.COMMA, Key.M));
	    keyToNeighborSetMap.put(Key.L, Set.of(Key.K, Key.O, Key.P, Key.SEMICOLON, Key.PERIOD, Key.COMMA));
	    keyToNeighborSetMap.put(Key.M, Set.of(Key.N, Key.J, Key.K, Key.COMMA, Key.SPACEBAR_5));
	    keyToNeighborSetMap.put(Key.N, Set.of(Key.B, Key.H, Key.J, Key.M, Key.SPACEBAR_4));
	    keyToNeighborSetMap.put(Key.O, Set.of(Key.I, Key.NINE, Key.O, Key.P, Key.L, Key.K));
	    keyToNeighborSetMap.put(Key.P, Set.of(Key.O, Key.ZERO, Key.MINUS, Key.LEFT_BRACKET, Key.SEMICOLON, Key.L));
	    keyToNeighborSetMap.put(Key.Q, Set.of(Key.TAB, Key.ONE, Key.TWO, Key.W, Key.A));
	    keyToNeighborSetMap.put(Key.R, Set.of(Key.E, Key.FOUR, Key.FIVE, Key.T, Key.F, Key.D));
	    keyToNeighborSetMap.put(Key.S, Set.of(Key.A, Key.W, Key.E, Key.D, Key.X, Key.Z));
	    keyToNeighborSetMap.put(Key.T, Set.of(Key.R, Key.FIVE, Key.SIX, Key.Y, Key.G, Key.F));
	    keyToNeighborSetMap.put(Key.U, Set.of(Key.Y, Key.SEVEN, Key.EIGHT, Key.I, Key.J, Key.H));
	    keyToNeighborSetMap.put(Key.V, Set.of(Key.C, Key.F, Key.G, Key.B, Key.SPACEBAR_2));
	    keyToNeighborSetMap.put(Key.W, Set.of(Key.Q, Key.TWO, Key.THREE, Key.E, Key.S, Key.A));
	    keyToNeighborSetMap.put(Key.X, Set.of(Key.Z, Key.S, Key.D, Key.C));
	    keyToNeighborSetMap.put(Key.Y, Set.of(Key.T, Key.SIX, Key.SEVEN, Key.U, Key.H, Key.G));
	    keyToNeighborSetMap.put(Key.Z, Set.of(Key.SHIFT_1, Key.A, Key.S, Key.X));
	    
	    // Numbers
	    
	    keyToNeighborSetMap.put(Key.ONE, Set.of(Key.BACKTICK, Key.TAB, Key.Q, Key.TWO));
	    keyToNeighborSetMap.put(Key.TWO, Set.of(Key.ONE, Key.Q, Key.W, Key.THREE));
	    keyToNeighborSetMap.put(Key.THREE, Set.of(Key.TWO, Key.W, Key.E, Key.FOUR));
	    keyToNeighborSetMap.put(Key.FOUR, Set.of(Key.THREE, Key.E, Key.R, Key.FIVE));
	    keyToNeighborSetMap.put(Key.FIVE, Set.of(Key.FOUR, Key.R, Key.T, Key.SIX));
	    keyToNeighborSetMap.put(Key.SIX, Set.of(Key.FIVE, Key.T, Key.Y, Key.SEVEN));
	    keyToNeighborSetMap.put(Key.SEVEN, Set.of(Key.SIX, Key.Y, Key.U, Key.EIGHT));
	    keyToNeighborSetMap.put(Key.EIGHT, Set.of(Key.SEVEN, Key.U, Key.I, Key.NINE));
	    keyToNeighborSetMap.put(Key.NINE, Set.of(Key.EIGHT, Key.I, Key.O, Key.ZERO));
	    keyToNeighborSetMap.put(Key.ZERO, Set.of(Key.NINE, Key.O, Key.P, Key.MINUS));
	    
	    // Symbols
	    
	    keyToNeighborSetMap.put(Key.BACKTICK, Set.of(Key.TAB, Key.ONE));
	    keyToNeighborSetMap.put(Key.TAB, Set.of(Key.BACKTICK, Key.ONE, Key.Q));
	    keyToNeighborSetMap.put(Key.SHIFT_1, Set.of(Key.A, Key.Z));
	    keyToNeighborSetMap.put(Key.SPACEBAR_1, Set.of(Key.C));
	    keyToNeighborSetMap.put(Key.SPACEBAR_2, Set.of(Key.V));
	    keyToNeighborSetMap.put(Key.SPACEBAR_3, Set.of(Key.B));
	    keyToNeighborSetMap.put(Key.SPACEBAR_4, Set.of(Key.N));
	    keyToNeighborSetMap.put(Key.SPACEBAR_5, Set.of(Key.M));
	    keyToNeighborSetMap.put(Key.COMMA, Set.of(Key.M, Key.K, Key.L, Key.PERIOD));
	    keyToNeighborSetMap.put(Key.PERIOD, Set.of(Key.COMMA, Key.L, Key.SEMICOLON, Key.FORESLASH));
	    keyToNeighborSetMap.put(Key.SEMICOLON, Set.of(Key.L, Key.P, Key.LEFT_BRACKET, Key.TICK, Key.FORESLASH, Key.PERIOD));
	    keyToNeighborSetMap.put(Key.MINUS, Set.of(Key.ZERO, Key.P, Key.LEFT_BRACKET, Key.EQUALS));
	    keyToNeighborSetMap.put(Key.EQUALS, Set.of(Key.MINUS, Key.LEFT_BRACKET, Key.RIGHT_BRACKET));
	    keyToNeighborSetMap.put(Key.LEFT_BRACKET, Set.of(Key.P, Key.MINUS, Key.EQUALS, Key.TICK, Key.RIGHT_BRACKET, Key.SEMICOLON));
	    keyToNeighborSetMap.put(Key.RIGHT_BRACKET, Set.of(Key.LEFT_BRACKET, Key.EQUALS, Key.TICK, Key.RETURN, Key.BACKSLASH));
	    keyToNeighborSetMap.put(Key.TICK, Set.of(Key.LEFT_BRACKET, Key.RIGHT_BRACKET, Key.SEMICOLON, Key.FORESLASH, Key.SHIFT_2, Key.RETURN));
	    keyToNeighborSetMap.put(Key.BACKSLASH, Set.of(Key.RIGHT_BRACKET, Key.RETURN));
	    keyToNeighborSetMap.put(Key.RETURN, Set.of(Key.BACKSLASH, Key.RIGHT_BRACKET, Key.TICK, Key.SHIFT_2));
	    keyToNeighborSetMap.put(Key.SHIFT_2, Set.of(Key.RETURN, Key.TICK, Key.FORESLASH));
	    keyToNeighborSetMap.put(Key.FORESLASH, Set.of(Key.SEMICOLON, Key.PERIOD, Key.TICK, Key.SHIFT_2));
	    
	    return keyToNeighborSetMap;
    
	
	}

}
