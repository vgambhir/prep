package cox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ClosingBraceMatch {

	public static Set<Character> validOpeningBrace = new HashSet<Character>(Arrays.asList('(', '{', '['));
	public Map<Character, Character> bracketMap = new HashMap<Character, Character>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		{
			put(')', '(');
			put('}', '{');
			put(']', '[');
		}
	};

	public boolean isValid(String str) {
		char[] cArr = str.toCharArray();
		Stack<Character> cStack = new Stack<Character>();
		Character c;		
		for (int i = 0; i < cArr.length; i++) {
			c = cArr[i];
			if (validOpeningBrace.contains(c)) {
				cStack.push(c);

			} else {
				// closing brackets started
				Character sBrace = bracketMap.get(c);
				if (sBrace == null) {
					continue;
				}

				if (!cStack.isEmpty()) {
					Character temp = cStack.pop();
					if (!sBrace.equals(temp))
						return false;
				}
				else {
					return false;
				}

			}
		}
		
		return true;

	}

	public static void main(String[] args) {

		String input = "([a]b)c{jkjkl}";
		ClosingBraceMatch cb = new ClosingBraceMatch();
		System.out.println(cb.isValid(input));
	}

}
