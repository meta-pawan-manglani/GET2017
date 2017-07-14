package Question3;

import org.junit.Assert;
import org.junit.Test;

public class TestLongestIncreasingSequence {

	// this will check on if the input is correct
	@Test
	public void testOnCorrectInput() {
		int input[] = { 1, 2, 2, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		LongestIncreasingSequence testsequence = new LongestIncreasingSequence();
		int actual[] = testsequence.longestSequence(input);
		int expected[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertArrayEquals(expected, actual);

	}

	// this test will check if all the elements of array are same
	@Test
	public void testWhenAllInputAreSame() {
		int input[] = { 1, 1, 1, 1, 1, 1, 1 };
		LongestIncreasingSequence testsequence = new LongestIncreasingSequence();
		int actual[] = testsequence.longestSequence(input);
		int expected[] = { 1 };
		Assert.assertArrayEquals(expected, actual);
	}
}
