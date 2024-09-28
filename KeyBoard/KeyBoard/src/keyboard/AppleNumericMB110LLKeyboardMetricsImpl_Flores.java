package keyboard;

import static keyboard.Key.*;
import static keyboard.KeyLayout.COLEMAK;
import static keyboard.KeyLayout.DVORAK;
import static keyboard.KeyLayout.QWERTY;
import static keyboard.KeyLayout.ROTATION_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import combinatorics.Permutation;
import combinatorics.PermutationImpl_Flores;

/**
 * @author skeleton
 *
 */
public class AppleNumericMB110LLKeyboardMetricsImpl_Flores implements KeyboardMetrics {
	Key homeKey;
	ArrayList<Key> vertexLabels;
	int[][] adjacencyMatrix;
	int[][] distanceMatrix;
	Map<Key, Set<Key>> keyToNeighborsMap;
	
	public AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout keyLayout)
	{
		
		Map<KeyLayout, Key> keyLayoutToHomeKeyMap = getKeyLayoutToHomeKeyMap(); 
		Map<KeyLayout, Map<Key, Set<Key>>> keyLayoutToKeyToNeighborMapMap = getKeyLayoutToKeyToNeighborMapMap();
		
		this.homeKey = keyLayoutToHomeKeyMap.get(keyLayout);
		
		if (keyLayout == KeyLayout.QWERTY) {keyToNeighborsMap = keyLayoutToKeyToNeighborMapMap.get(keyLayout);}
		else if (keyLayout == KeyLayout.DVORAK){keyToNeighborsMap = applyPermutationToMap(getKeyToNeighborMap_QWERTY(), getQWERTYToDvorakPermutation());}
		else if (keyLayout == KeyLayout.COLEMAK){keyToNeighborsMap = applyPermutationToMap(getKeyToNeighborMap_QWERTY(), getQWERTYToColemakPermutation());}
		else if (keyLayout == KeyLayout.ROTATION_13){keyToNeighborsMap = applyPermutationToMap(getKeyToNeighborMap_QWERTY(), getQWERTYToRotation13Permutation());}

		vertexLabels = new ArrayList<Key>(keyToNeighborsMap.keySet());
		adjacencyMatrix = getAdjacencyMatrix(keyToNeighborsMap, vertexLabels);

		distanceMatrix = getDistanceMatrix(adjacencyMatrix, vertexLabels);

		
		
		
		
	}
	
	private static int[][] getAdjacencyMatrix(Map<Key, Set<Key>> physicalKeyToNeighborsMap, List<Key> vertexLabels)
	{
		assert physicalKeyToNeighborsMap.keySet().equals(new HashSet<Key>(vertexLabels)) : "vertexLabels inconsistent with physicalKeyToNeighborsMap! : vertexLabels = " + vertexLabels + " physicalKeyToNeighborsMap.keySet() = " + physicalKeyToNeighborsMap.keySet();
		final int SIZE = physicalKeyToNeighborsMap.keySet().size();
		int[][] adjacencyMatrix = new int[SIZE][SIZE]; // [rows][columns]
		
		//build adjacencyMatrix here...
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				
				if (physicalKeyToNeighborsMap.get(vertexLabels.get(row)).contains(vertexLabels.get(col))) {
					
					adjacencyMatrix[row][col] = 1;
					
				}
				
				else {adjacencyMatrix[row][col] = 0;}
				
			}
		}
		
		
		
		
		return adjacencyMatrix;
	}
	
	//Matrix multiplication
	private static int[][] multiply(int[][] A, int[][] B)
	{
		int rowCount_A = A.length;
		assert rowCount_A > 0 : "rowCount_A = 0!";
		int columnCount_A = A[0].length;
		int rowCount_B = B.length;
		assert rowCount_B > 0 : "rowCount_B = 0!";
		int columnCount_B = B[0].length;
		assert columnCount_A == rowCount_B : "columnCount_A = " + columnCount_A + " <> " + rowCount_B + " = rowCount_B!";
		
		int[][] C = new int[rowCount_A][columnCount_B];
        for (int i = 0; i < rowCount_A; i++)
            for (int j = 0; j < columnCount_B; j++)
                for (int k = 0; k < columnCount_A; k++)
                    C[i][j] += A[i][k] * B[k][j];
        
        return C;
	}
	
	private static int[][] getDistanceMatrix(int[][] adjacencyMatrix, List<Key> vertexLabels){
		
		int vertexCount = adjacencyMatrix.length;
		assert vertexCount > 0 : "rowCount = 0!";
		int DISTANCENOTFOUND = -1;
		
		int[][] distanceMatrix = new int[vertexCount][vertexCount];
		
		//Figure out distanceMatrix here...
		
		
		for (int row = 0; row < vertexLabels.size(); row++) {// This nested loop sets all elements to -1 or 0
			for (int col = 0; col < vertexLabels.size(); col++) {
				if (row == col) {distanceMatrix[row][col] = 0;}
				else {distanceMatrix[row][col] = DISTANCENOTFOUND;}
			}
		}
		
		
		for (int row = 0; row < vertexLabels.size(); row++) {// This nested loop sets the elements of distance 1
			for (int col = 0; col < vertexLabels.size(); col++) {
				if (adjacencyMatrix[row][col] == 1) {distanceMatrix[row][col] = 1;}
			}
		}
		
		
		
		int distanceToSearchFor = 2;
		int [][] modifiedAdjacencyMatrix = adjacencyMatrix;
		while(distanceMatrixContainsNegativeOne(distanceMatrix, vertexLabels)) {
			
			
			
			
			int[][] distanceToSearchForMatrix = multiply(modifiedAdjacencyMatrix, adjacencyMatrix); // squared matrix will allow us to find if there is a path of 2 or not for each index in the matrix
			for (int row = 0; row < vertexLabels.size(); row++) {
				for (int col = 0; col < vertexLabels.size(); col++) {
					
					
					if (distanceMatrix[row][col] == DISTANCENOTFOUND && distanceToSearchForMatrix[row][col] > 0) {
						
						distanceMatrix[row][col] = distanceToSearchFor;
					
					}
					
					
				}
			}
			
			distanceToSearchFor += 1;
			modifiedAdjacencyMatrix = distanceToSearchForMatrix;
		}
		
		
		

		
	return distanceMatrix;
}
	
	/* (non-Javadoc)
	 * @see keyboard.KeyboardMeasurements#getDistance(keyboard.PhysicalKey, keyboard.PhysicalKey)
	 */
	@Override
	public double getDistance(Key key1, Key key2) {
		assert key1 != null;
		assert key2 != null;
		int index1 = getIndex(vertexLabels, key1);
		int index2 = getIndex(vertexLabels, key2);
		return distanceMatrix[index1][index2];
	}

	private static <E> int getIndex(List<E> list, E element)
	{
		boolean foundIndex = false;
		int i = 0;
		while(!foundIndex && i < list.size())
		{
			foundIndex = (list.get(i) == element);
			if(!foundIndex) i++;
		}
		int rv = -1;
		if(foundIndex) rv = i;
		return rv;
	}

	@Override
	public double getDistance(String str) {
		
		assert str != null;
		
		double distance = 0;
		Key currentKey = homeKey;
		Set<Key> setOfSpacebars = Set.of(Key.SPACEBAR_1, Key.SPACEBAR_2, Key.SPACEBAR_3, Key.SPACEBAR_4, Key.SPACEBAR_5);
		Key currentKeyPlusOne;
		
		for (int i = 0; i < str.length(); i++) {
			
			
			
			if (str.charAt(i) == ' ' && i < str.length() - 1) {
				
				Key keyAfterSpace = findNextKeyAfterSpace(str, i, getClosestKey(setOfSpacebars, currentKey));
				
				currentKeyPlusOne = getClosestKey(setOfSpacebars, currentKey, keyAfterSpace);
				
				distance += distanceMatrix[getIndexFromKey(currentKey)][getIndexFromKey(currentKeyPlusOne)]	;
				
				currentKey = currentKeyPlusOne;
				
			}
			else if (str.charAt(i) == ' ' && i == str.length() - 1) {
				
				currentKeyPlusOne = getClosestKey(setOfSpacebars, currentKey);
				
				distance += distanceMatrix[getIndexFromKey(currentKey)][getIndexFromKey(currentKeyPlusOne)]	;
				currentKey = currentKeyPlusOne;
				
			}
			else {
				currentKeyPlusOne = findCorrectKeyWithChar(str.charAt(i));
				
				distance += distanceMatrix[getIndexFromKey(currentKey)][getIndexFromKey(currentKeyPlusOne)]	;
				
				currentKey = currentKeyPlusOne;
			}
			
			
		}
		
		
		
		
		
		return distance;
	}
	
	private Key getClosestKey(Set<Key> keySet, Key key)
	{
		double minDistance = 0.0;
		List<Key> keyList = new ArrayList<Key>(keySet);
		minDistance += getDistance(key, keyList.get(0));
		Key minDistanceKey = keyList.get(0);
		
		
		for (int i = 0; i < keyList.size(); i++) {
			double currDistance = 0.0;
			currDistance += getDistance(key, keyList.get(i));
			
			if (currDistance < minDistance) {
				minDistance = currDistance;
				minDistanceKey = keyList.get(i);
			}
			
		}
		
		
		return minDistanceKey;
	}
	
	private Key getClosestKey(Set<Key> keySet, Key key, Key keyAfterSpace)
	{
		double minDistance = 0.0;
		List<Key> keyList = new ArrayList<Key>(keySet);
		minDistance += getDistance(key, keyList.get(0));
		minDistance += getDistance(keyList.get(0), keyAfterSpace);
		Key minDistanceKey = keyList.get(0);
		
		
		for (int i = 0; i < keyList.size(); i++) {
			double currDistance = 0.0;
			currDistance += getDistance(key, keyList.get(i));
			currDistance += getDistance(keyList.get(i), keyAfterSpace);
			
			if (currDistance < minDistance) {
				minDistance = currDistance;
				minDistanceKey = keyList.get(i);
			}
			
		}
		
		
		return minDistanceKey;
	}

	private static Set<Key> getKeySet(char character)
	{
		List<Key> keyList = Arrays.asList(Key.values());
		Set<Key> characterProducingKeysSet = new HashSet<Key>();
		for(int i = 0; i < keyList.size(); i++)
		{
			Key key = keyList.get(i);
			assert key != null : "key is null!";
			boolean keyProducesCharacter = (key.getNormalCharacter() != null && key.getNormalCharacter() == character) || (key.getShiftModifiedCharacter() != null && key.getShiftModifiedCharacter() == character);
			if(keyProducesCharacter) characterProducingKeysSet.add(key);
		}
		return characterProducingKeysSet;
	}
	
	private static Map<Key, Set<Key>> getKeyToNeighborMap_QWERTY()
	{
		Map<Key, Set<Key>> keyToNeighborSetMap = new HashMap<Key, Set<Key>>();
		
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
		
		//Produce keyToNeighborSetMap here
		//You might want to take a look at getSet()
		
		return keyToNeighborSetMap;
	}
	
	private static Set<Key> getSet(Key... keys)
	{
		return new HashSet<Key>(Arrays.asList(keys));
	}
	
	public static Permutation<Key> getQWERTYToDvorakPermutation(){
		
		
		Set<Key> domain = getKeyToNeighborMap_QWERTY().keySet();
		Set<List<Key>> cycles = new HashSet<List<Key>>();

		
		cycles.add(List.of(Key.MINUS, Key.LEFT_BRACKET, Key.FORESLASH, Key.Z, Key.SEMICOLON, Key.S, Key.O, Key.R, Key.P, Key.L, Key.N, Key.B, Key.X, Key.Q, Key.TICK));
		cycles.add(List.of(Key.RIGHT_BRACKET, Key.EQUALS));
		cycles.add(List.of(Key.V, Key.K, Key.T, Key.Y, Key.F, Key.U, Key.G, Key.I, Key.C, Key.J, Key.H, Key.D, Key.E, Key.PERIOD));
		cycles.add(List.of(Key.W, Key.COMMA));
		
		Permutation<Key> b = new PermutationImpl_Flores<Key>(cycles, domain);
		return b;
	}
	
	private static Permutation<Key> getQWERTYToColemakPermutation()
	{
		Set<Key> domain = getKeyToNeighborMap_QWERTY().keySet();
		Set<List<Key>> cycles = new HashSet<List<Key>>();

		
		cycles.add(List.of(Key.T, Key.G, Key.D, Key.S, Key.R, Key.P, Key.SEMICOLON, Key.O, Key.Y, Key.J, Key.N, Key.K, Key.E, Key.F));
		cycles.add(List.of(Key.I, Key.U, Key.L));
		
		
		Permutation<Key> b = new PermutationImpl_Flores<Key>(cycles, domain);
		return b;
	}
	
	private static Permutation<Key> getQWERTYToRotation13Permutation()
	{
		Set<Key> domain = getKeyToNeighborMap_QWERTY().keySet();
		Set<List<Key>> cycles = new HashSet<List<Key>>();

		
		cycles.add(List.of(Key.A, Key.N));
		cycles.add(List.of(Key.B, Key.O));
		cycles.add(List.of(Key.C, Key.P));
		cycles.add(List.of(Key.D, Key.Q));
		cycles.add(List.of(Key.E, Key.R));
		cycles.add(List.of(Key.F, Key.S));
		cycles.add(List.of(Key.G, Key.T));
		cycles.add(List.of(Key.H, Key.U));
		cycles.add(List.of(Key.I, Key.V));
		cycles.add(List.of(Key.J, Key.W));
		cycles.add(List.of(Key.K, Key.X));
		cycles.add(List.of(Key.L, Key.Y));
		cycles.add(List.of(Key.M, Key.Z));
		
		
		Permutation<Key> b = new PermutationImpl_Flores<Key>(cycles, domain);
		return b;
	}
	
	private static <E> Map<E, Set<E>> applyPermutationToMap(Map<E, Set<E>> map, Permutation<E> permutation)
	{
		
		Map<E, Set<E>> newMap = new HashMap<E, Set<E>>();

		Set<E> keySet = map.keySet();
		
		Iterator<E> it = keySet.iterator();
		
		while (it.hasNext()) {
			E currKey = it.next();
			Set<E> currKeySet = map.get(currKey);
			
			Iterator<E> keySetIt = currKeySet.iterator();
			Set<E> setToAddToNewMap = new HashSet<E>();
			while (keySetIt.hasNext()) {
				E currKeyInKeySet = keySetIt.next();
				setToAddToNewMap.add(permutation.getImage(currKeyInKeySet));
				
			}
			newMap.put(permutation.getImage(currKey), setToAddToNewMap);
			
		}
		
		return newMap;
	}
	
	public static Map<KeyLayout, Key>getKeyLayoutToHomeKeyMap() {
		
		Map<KeyLayout, Key> keyLayoutToHomeKeyMap = new HashMap<>();
		
		keyLayoutToHomeKeyMap.put(KeyLayout.QWERTY, Key.J);
		keyLayoutToHomeKeyMap.put(KeyLayout.DVORAK, Key.H);
		keyLayoutToHomeKeyMap.put(KeyLayout.COLEMAK, Key.N);
		keyLayoutToHomeKeyMap.put(KeyLayout.ROTATION_13, Key.W);
		
		return keyLayoutToHomeKeyMap;
		
	}
	
	private static Map<KeyLayout, Map<Key, Set<Key>>>getKeyLayoutToKeyToNeighborMapMap() {
		
		Map<KeyLayout, Map<Key, Set<Key>>> KeyLayoutToKeyToNeighborMapMap = new HashMap<>();
		
		KeyLayoutToKeyToNeighborMapMap.put(KeyLayout.QWERTY, getKeyToNeighborMap_QWERTY());
		
		return KeyLayoutToKeyToNeighborMapMap;
		
		
	}
	
	private static String matrixToString(int[][] matrix, List<Key> vertexLabels) {
		
		String adMatrix = "";
		
		for (int row = 0; row < vertexLabels.size(); row++) {
			for (int col = 0; col < vertexLabels.size(); col++) {
				
				adMatrix += matrix[row][col] + " ";
				
			}
			
			adMatrix += "\n";
			
		}
		
		return adMatrix;
		
	}
	
	private static String adMatrixToString(List<Key> vertexLabels) {
		
		String vl = "";
		
		for (int i = 0; i < vertexLabels.size(); i++) {
			
			vl += vertexLabels.get(i) + " ";
			
		}
		
		return vl;
		
	}
	
	private int getIndexFromKey(Key k) {
		
		for (int i = 0; i < vertexLabels.size(); i++) {
			if (k == vertexLabels.get(i)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	private Key getKeyFromIndex(int targetIdx) {
			
			for (int i = 0; i < vertexLabels.size(); i++) {
				if (targetIdx == i) {
					return vertexLabels.get(i);
				}
			}
			
			return Key.BACKSLASH;
			
		}
	
	private static boolean distanceMatrixContainsNegativeOne(int[][] distanceMatrix, List<Key> vertexLabels) {
		int DISTANCENOTFOUND = -1;
		for (int row = 0; row < vertexLabels.size(); row++) {// This nested loop sets all elements to -1 or 0
			for (int col = 0; col < vertexLabels.size(); col++) {
				if (distanceMatrix[row][col] == DISTANCENOTFOUND) {return true;}
			}
		}
		return false;
	}
	
	private static Key findCorrectKeyWithChar(char c) {
		
		List<Key> arrayOfKeys = Arrays.asList(Key.values());
//		arrayOfKeys.add(Key.values());
		
		for (int i = 0; i < arrayOfKeys.size(); i++) {
			
			
			if (arrayOfKeys.get(i).getNormalCharacter() != null && arrayOfKeys.get(i).getShiftModifiedCharacter() != null) {
				if (arrayOfKeys.get(i).getNormalCharacter() == c || arrayOfKeys.get(i).getShiftModifiedCharacter() == c) {
					return arrayOfKeys.get(i);
				}
			}
			
		}
		return Key.A;
	}
	
	private static Key findNextKeyAfterSpace(String str, int idx, Key key) {
		
		char charFound = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			if (i > idx && str.charAt(i) != ' ') {
				charFound = str.charAt(i);
				i = str.length() - 1;
			}
			
			if (i == str.length()-1 && charFound == 0) {
				return key;
			}
			
		}
		return findCorrectKeyWithChar(charFound);
	}
	

}