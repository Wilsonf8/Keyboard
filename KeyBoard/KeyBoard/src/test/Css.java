package test;

import keyboard.*;
import static keyboard.Key.*;
import static org.junit.Assert.assertEquals;
//mport static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.junit.Test;


public class Css {
	
	private static KeyboardMetrics getKeyboardMetrics(KeyLayout keyLayout) {
		return new AppleNumericMB110LLKeyboardMetricsImpl_Flores(keyLayout);
	}
	
	
	//QWERTY Tests
	@Test
	public void QWERTY_SIMPLE_KEYS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(6.0, keyboardMetrics.getDistance(J, A), 0.0);
		assertEquals(5.0, keyboardMetrics.getDistance(A, B), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(B, C), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(C, D), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(D, E), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(E, F), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(F, G), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(G, H), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(H, I), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(I, J), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(J, K), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(K, L), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(L, M), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(M, N), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(N, O), 0.0);
	}
	@Test
	public void QWERTY_SIMPLE_STRINGS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(71.0, keyboardMetrics.getDistance("abcdefghijklmnopqrstuvwxyz!"), 0.0);
		assertEquals(71.0, keyboardMetrics.getDistance("AbCdEfGhIjKlMnOpQrStUvWxYz!"), 0.0);
		assertEquals(66.0, keyboardMetrics.getDistance("mnopqrstuvwxyz!abcdefghijkl"), 0.0);
	}
	@Test
	public void QWERTY_SAME_KEYS() {		
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(0.0, keyboardMetrics.getDistance(J, J), 0.0);
		assertEquals(0.0, keyboardMetrics.getDistance("jjjjjjjjjjjjjjjjjj"), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance("hhhhhhhhhhhhhhhhhh"), 0.0);
	}
	@Test
	public void QWERTY_SPACES() {	
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		String spaces = "jhgfdsasdfghjkl;\']\\][poiuyhgtrfvgt567uyhnjm mnbhn nbhgv vfc cvfdxzsaqw23ewqwerty";
		assertEquals(spaces.length() - 1, keyboardMetrics.getDistance(spaces), 0.0);
		assertEquals(11, keyboardMetrics.getDistance("k                  a"), 0.0);
		assertEquals(21, keyboardMetrics.getDistance("k a K"), 0.0);
		assertEquals(23, keyboardMetrics.getDistance("k a K "), 0.0);
		assertEquals(26, keyboardMetrics.getDistance(" k a K "), 0.0);
		assertEquals(9, keyboardMetrics.getDistance(" a"), 0.0);
		assertEquals(14, keyboardMetrics.getDistance("6 `"), 0.0);
	}
//	@Test
//	public void QWERTY_warAndPeaceTest() {
//		KeyboardMetrics Keyboard = getKeyboardMetrics(KeyLayout.QWERTY);
//		Scanner warAndPeaceScanner = null;
//		try {warAndPeaceScanner = getWarAndPeaceScanner();} 
//		catch (IOException e) {fail("War and Peace not read!");}
//		String wordString = getWordString(warAndPeaceScanner);
//		System.out.println(Keyboard.getDistance(wordString));
//	}
	
	
	//DVORAK Tests
	@Test
	public void DVORAK_SIMPLE_KEYS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.DVORAK);
		assertEquals(6.0, keyboardMetrics.getDistance(H, A), 0.0);
		assertEquals(5.0, keyboardMetrics.getDistance(A, X), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(X, J), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(J, E), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(U, I), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(I, D), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(D, C), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(C, H), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(H, T), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(T, N), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(N, M), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(M, B), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(B, R), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(R, L), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(P, O), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(O, Y), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(Y, G), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(G, K), 0.0);
	}
	@Test
	public void DVORAK_SIMPLE_STRINGS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.DVORAK);
		assertEquals(71.0, keyboardMetrics.getDistance("axje.uidchtnmbrl'poygk,qf;!"), 0.0);
		assertEquals(71.0, keyboardMetrics.getDistance("AxJe.UiDcHtNmBrL'PoYgK,Qf:!"), 0.0);
		assertEquals(66.0, keyboardMetrics.getDistance("mbrl'poygk,qf;!axje.uidchtn"), 0.0);
	}
	@Test
	public void DVORAK_SAME_KEYS() {		
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.DVORAK);
		assertEquals(0.0, keyboardMetrics.getDistance(J, J), 0.0);
		assertEquals(0.0, keyboardMetrics.getDistance("hhhhhhhhhhhhhhhhhh"), 0.0);
		assertEquals(4.0, keyboardMetrics.getDistance("jjjjjjjjjjjjjjjjjj"), 0.0);
	}
	@Test
	public void DVORAK_SPACES() {	
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.DVORAK);
		assertEquals(22, keyboardMetrics.getDistance("hAxjeuI dc"), 0.0);
		assertEquals(9, keyboardMetrics.getDistance("k a"), 0.0);
		assertEquals(12, keyboardMetrics.getDistance("5 8"), 0.0);
		assertEquals(16, keyboardMetrics.getDistance("5 8 "), 0.0);
	}
//	@Test
//	public void DVORAK_warAndPeaceTest() {
//		KeyboardMetrics Keyboard = getKeyboardMetrics(KeyLayout.DVORAK);
//		Scanner warAndPeaceScanner = null;
//		try {warAndPeaceScanner = getWarAndPeaceScanner();} 
//		catch (IOException e) {fail("War and Peace not read!");}
//		String wordString = getWordString(warAndPeaceScanner);
//		System.out.println(Keyboard.getDistance(wordString));
//	}
	
	
	//COLEMAK Tests
	@Test
	public void COLEMAK_SIMPLE_KEYS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.COLEMAK);
		assertEquals(5.0, keyboardMetrics.getDistance(N, R), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(R, X), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(X, Z), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(Z, V), 0.0);
		assertEquals(4.0, keyboardMetrics.getDistance(V, COMMA), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(COMMA, NINE), 0.0);
	}
	@Test
	public void COLEMAK_SIMPLE_STRINGS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.COLEMAK);
		assertEquals(17, keyboardMetrics.getDistance("nrRxXzZvV,<9"), 0.0);
	}
	@Test
	public void COLEMAK_SAME_KEYS() {		
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.COLEMAK);
		assertEquals(0.0, keyboardMetrics.getDistance(J, J), 0.0);
		assertEquals(0.0, keyboardMetrics.getDistance("nnnnnnnnnnnnnnnnnn"), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance("hhhhhhhhhhhhhhhhhh"), 0.0);
	}
	@Test
	public void COLEMAK_SPACES() {	
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.COLEMAK);
		assertEquals(19, keyboardMetrics.getDistance("nrRxXzZvV ,<9"), 0.0);
		assertEquals(10, keyboardMetrics.getDistance("P j"), 0.0);
		assertEquals(10, keyboardMetrics.getDistance("P  j"), 0.0);
	}
	
	
	//ROTATION_13 Tests
	@Test
	public void ROTATION_13_SIMPLE_KEYS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.ROTATION_13);
		assertEquals(5.0, keyboardMetrics.getDistance(W, R), 0.0);
		assertEquals(6.0, keyboardMetrics.getDistance(R, X), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(X, Z), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(Z, V), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(V, COMMA), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(COMMA, NINE), 0.0);
	}
	@Test
	public void ROTATION_13_SIMPLE_STRINGS() {
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.ROTATION_13);
		assertEquals(19, keyboardMetrics.getDistance("wrRxXzZvV,<9"), 0.0);
	}
	@Test
	public void ROTATION_13_SAME_KEYS() {		
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.ROTATION_13);
		assertEquals(0.0, keyboardMetrics.getDistance(J, J), 0.0);
		assertEquals(0.0, keyboardMetrics.getDistance("wwwwwwwwwwwwwwwwww"), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance("uuuuuuuuuuuuuuuuuu"), 0.0);
	}
	@Test
	public void ROTATION_13_SPACES() {	
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.ROTATION_13);
		assertEquals(25, keyboardMetrics.getDistance("nrRxXzZvV ,<9"), 0.0);
	}
	
	
	protected static String getWordString(Scanner wordScanner)
	{
		StringBuilder wordString = new StringBuilder();
		while(wordScanner.hasNext())
		{
			wordString.append(wordScanner.next());
		}
		return wordString.toString();
	}
	
	
	protected Scanner getWarAndPeaceScanner() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("resources/WarAndPeace.txt");
		assert input != null : "input is null";
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
		Scanner warAndPeaceScanner = new Scanner(bufferedReader);
		return warAndPeaceScanner;
	}
}

