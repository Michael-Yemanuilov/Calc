package calc;


public class Execution {
	private static String[] userInput;
	private static final String[] operations = {"+", "-", "*", "/"};
	private static final String[] romanDigitsArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
	private static String operation;
	private static int arg1, arg2;
	private static boolean isArabic;
	
	
	public static boolean validateInput(String[] arrToCheck){
		
		userInput = arrToCheck;
		
		if (userInput.length != 3) {
			return false;
		}
		
		if (!checkOperation()) {
			return false;
		}
		
		if (!checkArguments()) {
			return false;
		}		
		return true;
	}
	
	private static boolean checkOperation() {
		for (int i = 0; i < operations.length; i++) {
			if (userInput[1].equals(operations[i])) {
				operation = operations[i];
				break;
			}
		}
		return operation != null && !operation.isEmpty();
	}
	
	private static boolean checkArguments() {
		try {
			arg1 = Integer.parseInt(userInput[0]);
			arg2 = Integer.parseInt(userInput[2]);
	    } catch (NumberFormatException e) {
	    	
	    }
		if (arg1 < 11 && arg1 > 0 && arg2 < 11 && arg2 > 0) {
			isArabic = true;
			return true;
		} else if (arg1 != 0 && arg2 != 0) {
			return false;
		} else if (arg1 == 0 && arg2 == 0) {
			int i = 0;
			while (i < 10) {
				if (userInput[0].equals(romanDigitsArray[i])) {
					arg1 = i + 1;
				}
				if (userInput[2].equals(romanDigitsArray[i])) {
					arg2 = i + 1;
				}
				i++;
				if (arg1 != 0 && arg2 != 0) {
					break;
				}
			}
		}
		if (arg1 == 0 || arg2 == 0) {
			return false;
		}
		return true;
	}

	public static String compute() {
		String result = "";
		
		if (isArabic) {
			result += Arabic.computeArabic(arg1, arg2, operation);
		} else {
			result = Roman.computeRoman(arg1, arg2, operation);
		}
		
		operation = "";
		arg1 = 0;
		arg2 = 0;
		isArabic = false;
		
		return result;
	}
}
