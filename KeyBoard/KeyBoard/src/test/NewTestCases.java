package test;

import static org.junit.Assert.*;

import org.junit.Test;

import combinatorics.Permutation;
import keyboard.AppleNumericMB110LLKeyboardMetricsImpl_Flores;
import keyboard.Key;
import keyboard.KeyLayout;
import keyboard.KeyboardMetrics;

public class NewTestCases {

	private KeyboardMetrics getKeyboardMetrics(KeyLayout keyLayout)
	{
		KeyboardMetrics km = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(keyLayout);
		KeyboardMetrics km2 = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.ROTATION_13);
		KeyboardMetrics km3 = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.DVORAK);
//		KeyboardMetrics km4 = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.COLEMAK);
		return km;
	}
	
	@Test
	public void neighborToNeighborTestQwerty() {
		KeyboardMetrics a = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(79.0, a.getDistance("jhgfdsasdfghjkl;']\\][poiuyhgtrfvgt567uyhnjm mnbhn nbhgv vfc cvfdxzsaqw23ewqwerty"), 0.0);
	}
	
	@Test
	public void newlineTestQwerty() {
		KeyboardMetrics a = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(7.0, a.getDistance("jkl;'\n]\n"), 0.0);
	}
	
	@Test
	public void simpleDistancesColemak() {
		KeyboardMetrics a = getKeyboardMetrics(KeyLayout.COLEMAK);
		assertEquals(5.0, a.getDistance(Key.A, Key.B), 0.0);
	}
	
	@Test
	public void simpleDistancesDvorak() {
		KeyboardMetrics a = getKeyboardMetrics(KeyLayout.DVORAK);
		assertEquals(6.0, a.getDistance(Key.H, Key.A), 0.0);
	}
	
	@Test
	public void simpleDistancesQwerty2() {
		KeyboardMetrics a = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(71.0, a.getDistance("abcdefghijklmnopqrstuvwxyz!"), 0.0);
	}
	
	@Test
	public void simpleDistancesQwerty() {
		KeyboardMetrics a = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(6.0, a.getDistance(Key.J, Key.A), 0.0);
	}
	
	@Test
	public void skipNeighborTestQwerty() {
		KeyboardMetrics a = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(52.0, a.getDistance("jl9&tdzq3r6hi0=;]piyrw	adgj"), 0.0);
	}
	

}
