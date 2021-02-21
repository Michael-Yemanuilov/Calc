package calc;


public class Roman extends Arabic{
	
	public static String computeRoman(int arg1, int arg2, String operation) {
		
		int arabicResult = computeArabic(arg1, arg2, operation);
		
		return RomanNumbers.map.get(arabicResult);
	}
}
