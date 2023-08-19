package best.project.lore.algorithms.identification;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PolindromFinderTest {
	
	@ParameterizedTest
	@CsvSource(value = {"1234321:true", "12345:false", "123321:true", "22234222:false", "1:true"}, delimiter = ':')
	void isPalindromeTestWithInt(int number, boolean isPalindrome) {
		assertEquals(isPalindrome, PalindromeFinder.isPalindrome(number));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1234321:true", "12345:false", "123321:true", "22234222:false" ,"1:true"}, delimiter = ':')
	void isPalindromeTestWithString(String number, boolean isPalindrome) {
		assertEquals(isPalindrome, PalindromeFinder.isPalindrome(number));
	}

}
