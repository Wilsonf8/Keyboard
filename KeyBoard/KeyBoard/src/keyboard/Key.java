package keyboard;

public enum Key {
	A('a', 'A'), B('b', 'B'), C('c', 'C'), D('d', 'D'), 
	E('e', 'E'), F('f', 'F'), G('g', 'G'), H('h', 'H'), 
	I('i', 'I'), J('j', 'J'), K('k', 'K'), L('l', 'L'), 
	M('m', 'M'), N('n', 'N'), O('o', 'O'), P('p', 'P'), 
	Q('q', 'Q'), R('r', 'R'), S('s', 'S'), T('t', 'T'), 
	U('u', 'U'), V('v', 'V'), W('w', 'W'), X('x', 'X'), 
	Y('y', 'Y'), Z('z', 'Z'), 
	ONE('1', '!'), TWO('2', '@'), THREE('3', '#'),
	FOUR('4', '$'), FIVE('5', '%'), SIX('6', '^'), 
	SEVEN('7', '&'), EIGHT('8', '*'), NINE('9', '('), 
	ZERO('0', ')'),
	BACKTICK('`', '~'), MINUS('-', '_'), EQUALS('=', '+'), 
	TAB('\t', '\t'), LEFT_BRACKET('[', '{'), 
	RIGHT_BRACKET(']', '}'), BACKSLASH('\\', '|'),
	SEMICOLON(';', ':'), TICK('\'', '\"'), RETURN('\n', '\n'), 
	COMMA(',', '<'), PERIOD('.', '>'), FORESLASH('/', '?'), 
	SPACEBAR_1(' ', ' '), SPACEBAR_2(' ', ' '), 
	SPACEBAR_3(' ', ' '), SPACEBAR_4(' ', ' '), 
	SPACEBAR_5(' ', ' '),
	SHIFT_1(null, null), SHIFT_2(null, null);
	
	private Character normalCharacter;
	private Character shiftModifiedCharacter;
	Key(Character normalCharacter, 
				Character shiftModifiedCharacter) {
        this.normalCharacter = normalCharacter;
        this.shiftModifiedCharacter = shiftModifiedCharacter;
    }
	
	public Character getNormalCharacter()
	{
		return normalCharacter;
	}
	
	public Character getShiftModifiedCharacter()
	{
		return shiftModifiedCharacter;
	}
}
