package Question5;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayOrder {

	// this test will check if array is sorted in ascending order
	@Test
	public void testWhenAscending() {
		int input[] = { 1, 2, 3, 4, 5, 6 };
		int expected = 1;
		CheckArrayOrder testOrder = new CheckArrayOrder();
		int actual = testOrder.isSorted(input);
		Assert.assertEquals(expected, actual);
	}

	// this test will check if array is sorted in descending order
	@Test
	public void testWhenDescending() {
		int input[] = { 6, 5, 4, 3, 2, 1 };
		int expected = 2;
		CheckArrayOrder testOrder = new CheckArrayOrder();
		int actual = testOrder.isSorted(input);
		Assert.assertEquals(expected, actual);
	}

	// this test will check if array is not sorted
	@Test
	public void testWhenNotSorted() {
		int input[] = { 1, 2, 9, 4, 5, 6 };
		int expected = 0;
		CheckArrayOrder testOrder = new CheckArrayOrder();
		int actual = testOrder.isSorted(input);
		Assert.assertEquals(expected, actual);
	}

}
