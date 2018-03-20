/*Says package for Junit does not exist. Fix for to use outside Eclipse*/

import static org.junit.Assert.*;

import org.junit.Test;

public class FullTimeEmployeeTest {

	FullTimeEmployee test1 = new FullTimeEmployee();
	FullTimeEmployee test2 = new FullTimeEmployee("John Doe", 0.00);
	FullTimeEmployee test3 = new FullTimeEmployee("Sarah Fisher", 15.00);
	FullTimeEmployee test4 = new FullTimeEmployee("John Doe", 25.00);
	FullTimeEmployeeComparator FTE_Comparator = new FullTimeEmployeeComparator();

	@Test
	public void testReflexivity() { //Test for reflexivity, x.equals(x)
		String expected = "Sarah Fisher, 15.00";
		assertEquals(expected, test3.toString());
		assertTrue(test1.equals(test1));
		assertTrue(test1.compareTo(test2) == 0);
		assertTrue(test2.compareTo(test1)== 0);
		assertTrue(FTE_Comparator.compare(test1, test2) == 0);
		assertTrue(FTE_Comparator.compare(test3, test3) == 0);
	}

	@Test
	public void testSymmetry() { //Test for symmetry, y.equals(x) and x.equals(y)
		assertFalse(test1.equals(test4));
		assertFalse(test4.equals(test1));
		assertTrue(test1.compareTo(test3) == 1);
		assertTrue(test3.compareTo(test1)== -1);
		assertTrue(FTE_Comparator.compare(test1, test3) == 1);
		assertTrue(FTE_Comparator.compare(test3, test1) == -1);
		}

	@Test
	public void testTransitivity() { //x = y, y = z, z = x
		test4.setGross_pay(0);
		assertTrue(test1.equals(test2));
		assertTrue(test4.equals(test1));
		assertTrue(test2.equals(test4));
		assertTrue(test1.compareTo(test2) == 0);
		assertTrue(test4.compareTo(test1)== 0);
		assertTrue(test2.compareTo(test4) == 0);
		assertTrue(FTE_Comparator.compare(test1, test2) == 0);
		assertTrue(FTE_Comparator.compare(test4, test1) == 0);
		assertTrue(FTE_Comparator.compare(test4, test2) == 0);
	}

	@Test
	public void testConsistency() { //no matter how many times you inovacte x.equals(y) it stays the same
		assertFalse(test3.equals(test4));
		assertFalse(test3.equals(test4));
		assertFalse(test3.equals(test4));
		assertFalse(test3.equals(test4));
		assertFalse(test3.equals(test4));
		assertTrue(test2.compareTo(test1)== 0);
		assertTrue(test2.compareTo(test1)== 0);
		assertTrue(test2.compareTo(test1)== 0);
		assertTrue(test2.compareTo(test1)== 0);
		assertTrue(FTE_Comparator.compare(test1, test2) == 0);
		assertTrue(FTE_Comparator.compare(test1, test2) == 0);
		assertTrue(FTE_Comparator.compare(test1, test2) == 0);
		assertTrue(FTE_Comparator.compare(test1, test2) == 0);
	}

	@Test
	public void testActuality() { //x.equals(null) is false
		assertFalse(test1.equals(null));
		assertFalse(test4.equals(null));
		assertTrue(test1.compareTo(null) == 2);
		assertTrue(FTE_Comparator.compare(test1, null) == 2);
	}


}
