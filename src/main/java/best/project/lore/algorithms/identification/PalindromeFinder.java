package best.project.lore.algorithms.identification;

public class PalindromeFinder {
	
	private PalindromeFinder() {
		//
	}
	
	public static boolean isPalindrome(int number) {
		boolean isPalindrome = Boolean.TRUE;
		int[] digits = Integer.toString(number).chars().map(c -> c-'0').toArray();
		isPalindrome = checkIsPolindrome(isPalindrome, digits);
		return isPalindrome;
	}
	
	public static boolean isPalindrome(String number) {
		boolean isPalindrome = Boolean.TRUE;
		int[] digits = number.chars().map(c -> c-'0').toArray();
		isPalindrome = checkIsPolindrome(isPalindrome, digits);
		return isPalindrome;
	}

	private static boolean checkIsPolindrome(boolean isPalindrome, int[] digits) {
		for(int i = 0; i <= digits.length / 2; i++) {
			if(digits[i] != digits[digits.length-1-i]) {
				isPalindrome = Boolean.FALSE;
				break;
			}
		}
		return isPalindrome;
	}

}
