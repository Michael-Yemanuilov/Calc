package calc;

public class Arabic {

	public static int computeArabic(int arg1, int arg2, String operation) {
		
		int result = 0;
		
		switch (operation.charAt(0)) {
		case '+':
			result = arg1 + arg2;
			break;
		case '-':
			result = arg1 - arg2;
			break;
		case '*':
			result = arg1 * arg2;
			break;
		case '/':
			result = arg1 / arg2;
			break;
		}
		
		return result;
	}


}
