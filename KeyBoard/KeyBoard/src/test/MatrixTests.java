package test;

import static org.junit.Assert.*;

import org.junit.Test;

import keyboard.AppleNumericMB110LLKeyboardMetricsImpl_Flores;
import keyboard.Key;
import keyboard.KeyLayout;

public class MatrixTests {

	@Test
	public void test() {
		
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.QWERTY);
		
		assertEquals(1.0, a.getDistance(Key.Y, Key.H), 0.0);
		assertEquals(1.0, a.getDistance(Key.BACKTICK, Key.TAB), 0.0);
		assertEquals(1.0, a.getDistance(Key.ONE, Key.TAB), 0.0);
		assertEquals(2.0, a.getDistance(Key.Q, Key.E), 0.0);
		assertEquals(6.0, a.getDistance(Key.P, Key.R), 0.0);
		assertEquals(14.0, a.getDistance(Key.BACKSLASH, Key.BACKTICK), 0.0);
		assertEquals(13.0, a.getDistance(Key.BACKSLASH, Key.TAB), 0.0);
		assertEquals(0.0, a.getDistance(Key.J, Key.J), 0.0);
		assertEquals(7.0, a.getDistance("f g"), 0.0);
		assertEquals(13.0, a.getDistance("a b"), 0.0);
		assertEquals(7.0, a.getDistance("f  g"), 0.0);
		assertEquals(7.0, a.getDistance("f  d"), 0.0);
		assertEquals(7.0, a.getDistance("f                  d"), 0.0);
		assertEquals(7.0, a.getDistance("f d"), 0.0);
		assertEquals(1.0, a.getDistance(Key.SHIFT_1, Key.A), 0.0);
		assertEquals(0.0, a.getDistance(""), 0.0);
		assertEquals(147.0, a.getDistance("Hi my name is wilson. What is yours?"), 0.0);
		assertEquals(94.0, a.getDistance("Hi my name is wilson. W"), 0.0);
		assertEquals(48.0, a.getDistance("Hi my name is"), 0.0);
		assertEquals(14.0, a.getDistance("Hi my n"), 0.0);
		assertEquals(23.0, a.getDistance("d v y  j ,  "), 0.0);
		assertEquals(7.0, a.getDistance("     d"), 0.0);
		
		
	}
	
	@Test
	public void startFromKeyO() {
		
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.QWERTY);
		
		assertEquals(4.0, a.getDistance("oJ"), 0.0);
		assertEquals(5.0, a.getDistance("O "), 0.0);
		assertEquals(8.0, a.getDistance("oH B"), 0.0);
		
	}
	
	@Test
	public void colemakTests() {
		
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.COLEMAK);
		
		assertEquals(0.0, a.getDistance("nnnnnnnnn"), 0.0);
		assertEquals(1.0, a.getDistance("eeeEEe"), 0.0);
		assertEquals(8.0, a.getDistance(Key.Q, Key.Y), 0.0);
		assertEquals(6.0, a.getDistance("neio;{}"), 0.0);
		assertEquals(18.0, a.getDistance("qwfpgjluy;{}"), 0.0);
		assertEquals(14.0, a.getDistance("'oienhdtsra"), 0.0);
		assertEquals(15.0, a.getDistance("Zxcvbkm<>/"), 0.0);
		
		
	}
	
	@Test
	public void ROT13Tests() {
		
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.ROTATION_13);
		
		assertEquals(8.0, a.getDistance("KD"), 0.0);
		assertEquals(16.0, a.getDistance("LnvC"), 0.0); //wl=2 ln=5 nv=7 vc=2
		assertEquals(3.0, a.getDistance(Key.C, Key.H), 0.0);
		
		assertEquals(6.0, a.getDistance(Key.R, Key.X), 0.0);
		assertEquals(2.0, a.getDistance(Key.F, Key.E), 0.0);
		assertEquals(3.0, a.getDistance(Key.Q, Key.O), 0.0);
		assertEquals(3.0, a.getDistance(Key.C, Key.H), 0.0);
//		assertEquals(3.0, a.getDistance(Key.C, Key.H), 0.0);
//		assertEquals(3.0, a.getDistance(Key.C, Key.H), 0.0);
//		assertEquals(3.0, a.getDistance(Key.C, Key.H), 0.0);
		
	}
	
	@Test 
	public void DVORAK_SPACES() { 
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.DVORAK);
		String spaces = "hAxjeuI dc"; 
		assertEquals(22.0, a.getDistance(spaces), 0.0);
	}
	
	@Test(expected=AssertionError.class)
	public void getDistanceHasNull() {
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.QWERTY);
		a.getDistance(null);	
	}
	@Test(expected=AssertionError.class)
	public void getDistanceHasNull2() {
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.QWERTY);
		a.getDistance(null, Key.SPACEBAR_1);	
	}
	@Test(expected=AssertionError.class)
	public void getDistanceHasNull3() {
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.QWERTY);
		a.getDistance(Key.A, null);	
	}
	
	@Test
	public void tests46() {
		
		AppleNumericMB110LLKeyboardMetricsImpl_Flores a = new AppleNumericMB110LLKeyboardMetricsImpl_Flores(KeyLayout.QWERTY);
		
		
//		assertEquals(5.0, a.getDistance(Key.A, Key.B), 0.0);
		assertEquals(79.0, a.getDistance("jhgfdsasdfghjkl;']\\][poiuyhgtrfvgt567uyhnjm mnbhn nbhgv vfc cvfdxzsaqw23ewqwerty"), 0.0);
		
		
		
	}

}
