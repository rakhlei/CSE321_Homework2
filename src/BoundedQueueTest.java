import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;

public class BoundedQueueTest {
	// Test Fixtures
	private BoundedQueue Q1, Q2;
	private Object o, o1, o2;

	@Before
	public void setUp() {
		Q1 = new BoundedQueue(2);
		o = 0;
		o1 = 1;
	}

	/**
	 * This test evaluates the constructor.
	 * Test if the Queue is not Null;
	 */
	@Test
	public void testBoundedQueue() {
		assertNotNull(Q1);
	}

	/**
	 * This test evaluates the constructor to see if the exception thrown was
	 * caught to ensure a negative value isn't entered into constructor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegavtiveCapacity() {
		Q2 = new BoundedQueue(-1);
		fail("Expected Illegal Argument exception: Capacity < 0");
	}

	/**
	 * This test is to observe if the EnQueue method is working. adds an object
	 * to a Queue than asserts false that the Queue is not empty.
	 */
	@Test
	public void testEnQueue() {

		Q1.enQueue(o);
		assertFalse(Q1.isEmpty());

	}

	/**
	 * This test is to observe that the NullPointer exception in the EnQueue
	 * method is working correctly, method adds a null value to the queue.
	 */
	@Test(expected = NullPointerException.class)
	public void testNullEnQueue() {
		o2 = null;
		Q1.enQueue(o2);
		fail("Expected null pointer exception");
	}

	/**
	 * This test is to observe that the IllegalState exception in the EnQueue
	 * method is working correctly, method adds a third item to push queue over
	 * the capacity.
	 */
	@Test(expected = IllegalStateException.class)
	public void testFullEnQueue() {
		o2 = 2;
		Q1.enQueue(o);
		Q1.enQueue(o1);
		Q1.enQueue(o2);
		fail("Expected Illegal State exception");
	}

	/**
	 * This test is to observe if the DeQueue method is working Method adds two
	 * objects to the Queue than removes them Asserts True if the Queue is Empty
	 * after removing two objects.
	 */
	@Test
	public void testDeQueue() {
		Q1.enQueue(o);
		Q1.enQueue(o1);
		// remove objects
		Q1.deQueue();
		Q1.deQueue();
		assertTrue(Q1.isEmpty());

	}

	/**
	 * This test is to observe that the IllegalState exception in the DeQueue
	 * method is working correctly, method Removes a third item to push queue to
	 * a capacity of -1.
	 */
	@Test(expected = IllegalStateException.class)
	public void testIllegalStateException() {
		Q1.enQueue(o);
		Q1.enQueue(o1);
		// remove objects
		Q1.deQueue();
		Q1.deQueue();
		Q1.deQueue();
		fail("Expected Illegal State Exception");

	}

	/**
	 * This test evaluates the IsEmpty Method A Queue is instantiated with no
	 * objects added, Test Asserts Equals If isEmpty Returns True.
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(true, Q1.isEmpty());
	}

	/**
	 * This test evaluates the IsFull Method A Queue is instantiated with to
	 * capacity 2 with 2 objects added, Test Asserts Equals If isFull Returns
	 * True.
	 */
	@Test
	public void testIsFull() {
		Q1.enQueue(o);
		Q1.enQueue(o1);
		assertEquals(true, Q1.isFull());
	}

	/**
	 * Test to evaluate the toString Method Queue instantiated and enQueded with
	 * a string object Test Asserts Equals if the method equals the expected
	 * output.
	 */
	@Test
	public void testToString() {
		Q1.enQueue((o));
		String s = Q1.toString();
		assertEquals("[0]", s);
	}

}
