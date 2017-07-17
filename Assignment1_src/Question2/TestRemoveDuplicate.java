package Question2;

import org.junit.Assert;
import org.junit.Test;

public class TestRemoveDuplicate {

	// test when array contain duplicate element
	@Test
	public void testRemoveDuplicate() {
		int input[] = { 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 9, 10, 11, 11, 11, 12, 13 };
		RemoveDuplicate testRemoval = new RemoveDuplicate();
		int actual[] = testRemoval.removeDuplicate(input);
		int expected[] = { 1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13 };
		Assert.assertArrayEquals(expected, actual);
	}

	// test when array is empty
	@Test
	public void testWhenArrayIsEmpty() {
		int input[] = {};
		RemoveDuplicate testRemoval = new RemoveDuplicate();
		int actual[] = testRemoval.removeDuplicate(input);
		int expected[] = {};
		Assert.assertArrayEquals(expected, actual);
	}

	// test when all elements are different
	@Test
	public void testWhenAllElementsAreDifferent() {
		int input[] = { 1, 2, 3, 4, 5, 6 };
		RemoveDuplicate testRemoval = new RemoveDuplicate();
		int actual[] = testRemoval.removeDuplicate(input);
		int expected[] = { 1, 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expected, actual);
	}
}
