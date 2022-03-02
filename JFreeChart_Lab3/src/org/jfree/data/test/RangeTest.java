package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRangeNegZero;
    private Range exampleRangeZeroPos;
    private Range exampleRangeNegPos;
    private Range exampleRangeEqual;
    private Range exampleRangePosPos;
    private Range exampleRangeNegNeg;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	exampleRangeNegZero = new Range(-3, 0);
        exampleRangeZeroPos = new Range(0, 3);
        exampleRangeNegPos = new Range(-2.5, 2.5);
        exampleRangeEqual = new Range(3, 3);
        exampleRangePosPos = new Range(0.111111111,0.111111112);
        exampleRangeNegNeg = new Range(-6, -3);
    }

    /* * * * *
     * TESITNG getLowerBound
     * * * * */

    /* Testing get lower bound method on a range spanning negative to zero,
     * where a negative number is the lowest bound
     */
    @Test
    public void getLowerBoundNegZero() {
    	assertEquals("The lower bound of -3 and 0 should be -3",
    			-3, exampleRangeNegZero.getLowerBound(), .000000001d);
    }

    /* Testing get lower bound method on a range spanning zero to positive,
     * where zero is the lowest bound
     */
    @Test
    public void getLowerBoundZeroPos() {
    	assertEquals("The lower bound of 0 and 3 should be 0",
    			0, exampleRangeZeroPos.getLowerBound(), .000000001d);
    }

    /* Testing get lower bound method on a range spanning negative to positive,
     * where a negative number is the lowest bound
     */
    @Test
    public void getLowerBoundNegPos() {
    	assertEquals("The lower bound of -2.5 and 2.5 should be -2.5",
    			-2.5, exampleRangeNegPos.getLowerBound(), .000000001d);
    }

    /* Testing get lower bound method on a range spanning one positive number,
     * where the positive number is the lowest bound
     */
    @Test
    public void getLowerBoundEqual() {
    	assertEquals("The lower bound of 3 and 3 should be 3",
    			3, exampleRangeEqual.getLowerBound(), .000000001d);
    }

    /* Testing get lower bound method on a range spanning two decimal numbers
     * where the smallest decimal is the lowest bound
     */
    @Test
    public void getLowerBoundPosPos() {
    	assertEquals("The lower bound of 0.111111111 and 0.111111112 should be 0.111111111",
    			0.111111111, exampleRangePosPos.getLowerBound(), .000000001d);
    }

    /* Testing get lower bound method on a range spanning two negative numbers
     * where the smallest negative is the lowest bound
     */
    @Test
    public void getLowerBoundNegNeg() {
    	assertEquals("The lower bound of -6 and -3 should be -6",
    			-6, exampleRangeNegNeg.getLowerBound(), .000000001d);
    }

    /* * * * *
     * TESITNG getUpperBound
     * * * * */

    /* Testing get upper bound method on a range spanning negative to zero,
     * where zero is the highest bound
     */
    @Test
    public void getUpperBoundNegZero() {
        assertEquals("The upperbound of -3 and 0 should be 0",
        		0, exampleRangeNegZero.getUpperBound(), .000000001d);
    }

    /* Testing get upper bound method on a range spanning zero to positive,
     * where a positive number is the highest bound
     */
    @Test
    public void getUpperBoundZeroPos() {
    	assertEquals("The upper bound of 0 and 3 should be 3",
    			3, exampleRangeZeroPos.getUpperBound(), .000000001d);
    }

    /* Testing get upper bound method on a range spanning negative to positive,
     * where the positive number should be returned
     */
    @Test
    public void getUpperBoundNegPos() {
    	assertEquals("The upper bound of -2.5 and 2.5 should be 2.5",
    			2.5, exampleRangeNegPos.getUpperBound(), .000000001d);
    }

    /* Testing get upper bound method on a range spanning zero to positive,
     * where a positive number is the highest bound
     */
    @Test
    public void getUpperBoundEqual() {
    	assertEquals("The upper bound of 3 and 3 should be 3",
    			3, exampleRangeEqual.getUpperBound(), .000000001d);
    }

    /* Testing get upper bound method on a range spanning two decimal numbers,
     * where the largest decimal number is the highest bound
     */
    @Test
    public void getUpperBoundPosPos() {
    	assertEquals("The upper bound of 0.111111111 and 0.111111112 should be 0.111111112",
    			0.111111112, exampleRangePosPos.getUpperBound(), .000000001d);
    }

    /* Testing get upper bound method on a range spanning two negative numbers,
     * where the largest negative number is the highest bound
     */
    @Test
    public void getUpperBoundNegNeg() {
    	assertEquals("The upper bound of -6 and -3 should be -3",
    			-3, exampleRangeNegNeg.getUpperBound(), .000000001d);
    }


    /* * * * *
     * TESITNG getLength
     * * * * */

    /* Testing get length method on a range spanning negative to zero,
     */
    @Test
    public void getLengthNegZero() {
        assertEquals("The length of -3 and 0 should be 3",
        		3, exampleRangeNegZero.getLength(), .000000001d);
    }

    /* Testing get length method on a range spanning zero to positive,
     */
    @Test
    public void getLengthZeroPos() {
    	assertEquals("The length of 0 and 3 should be 3",
    			3, exampleRangeZeroPos.getLength(), .000000001d);
    }

    /* Testing get length method on a range spanning negative to positive,
     */
    @Test
    public void getLengthNegPos() {
    	assertEquals("The length of -2.5 and 2.5 should be 5",
    			5, exampleRangeNegPos.getLength(), .000000001d);
    }

    /* Testing get length method on a range spanning zero to positive,
     */
    @Test
    public void getLengthEqual() {
    	assertEquals("The length of 3 and 3 should be 0",
    			0, exampleRangeEqual.getLength(), .000000001d);
    }

    /* Testing get length method on a range spanning two decimal numbers,
     */
    @Test
    public void getLengthPosPos() {
    	assertEquals("The length of 0.111111111 and 0.111111112 should be 0.000000001",
    			0.000000001, exampleRangePosPos.getLength(), .000000001d);
    }


    /* Testing get length method on a range spanning two negative numbers,
     */
    @Test
    public void getLengthNegNeg() {
    	assertEquals("The length of -6 and -3 should be 3",
    			3, exampleRangeNegNeg.getLength(), .000000001d);
    }


    /* * * * *
     * TESITNG shift
     * * * * */

    /* Testing shift method on a range spanning negative to zero using a negative shift
     */
    @Test
    public void shiftNegZeroNeg() {
    	Range testRange = new Range(-4, -1);
        assertEquals("The new range should be -4 to -1", testRange,
        Range.shift(exampleRangeNegZero, -1));
    }

    /* Testing shift method on a range spanning negative to zero using a zero shift
     */
    @Test
    public void shiftNegZeroZero() {
    	Range testRange = new Range(-3, 0);
        assertEquals("The new range should be -3 to 0", testRange,
        Range.shift(exampleRangeNegZero, 0));
    }

    /* Testing shift method on a range spanning negative to zero using a positive shift
     */
    @Test
    public void shiftNegZeroPos() {
    	Range testRange = new Range(-2, 1);
        assertEquals("The new range should be -2 to 1", testRange,
        Range.shift(exampleRangeNegZero, 1));
    }

    /* Testing shift method on a range spanning zero to positive to positive using a negative shift
     */
    @Test
    public void shiftZeroPosNeg() {
    	Range testRange = new Range(-1, 2);
        assertEquals("The new range should be -1 to 2", testRange,
        Range.shift(exampleRangeZeroPos, -1));
    }

    /* Testing shift method on a range spanning zero to positive using a zero shift
     */
    @Test
    public void shiftZeroPosZero() {
    	Range testRange = new Range(0, 3);
        assertEquals("The new range should be 0 to 3", testRange,
        Range.shift(exampleRangeZeroPos, 0));
    }

    /* Testing shift method on a range spanning zero to positive using a positive shift
     */
    @Test
    public void shiftZeroPosPos() {
    	Range testRange = new Range(1, 4);
        assertEquals("The new range should be 1 to 4", testRange,
        Range.shift(exampleRangeZeroPos, 1));
    }

    /* Testing shift method on a range spanning negative to positive using a negative shift
     */
    @Test
    public void shiftNegPosNeg() {
    	Range testRange = new Range(-3.5, 1.5);
        assertEquals("The new range should be -3.5 to 1.5", testRange,
        Range.shift(exampleRangeNegPos, -1));
    }

    /* Testing shift method on a range spanning negative to positive using a zero shift
     */
    @Test
    public void shiftNegPosZero() {
    	Range testRange = new Range(-2.5, 2.5);
        assertEquals("The new range should be -2.5 to 2.5", testRange,
        Range.shift(exampleRangeNegPos, 0));
    }

    /* Testing shift method on a range spanning negative to positive using a positive shift
     */
    @Test
    public void shiftNegPosPos() {
    	Range testRange = new Range(-1.5, 3.5);
        assertEquals("The new range should be -1.5 to 3.5", testRange,
        Range.shift(exampleRangeNegPos, 1));
    }

    /* Testing shift method on a range spanning one positive number using a negative shift
     */
    @Test
    public void shiftEqualNeg() {
    	Range testRange = new Range(2, 2);
        assertEquals("The new range should be 2 to 2", testRange,
        Range.shift(exampleRangeEqual, -1));
    }

    /* Testing shift method on a range spanning one positive number using a zero shift
     */
    @Test
    public void shiftEqualZero() {
    	Range testRange = new Range(3, 3);
        assertEquals("The new range should be 3 to 3", testRange,
        Range.shift(exampleRangeEqual, 0));
    }

    /* Testing shift method on a range spanning one positive number using a positive shift
     */
    @Test
    public void shiftEqualPos() {
    	Range testRange = new Range(4, 4);
        assertEquals("The new range should be 4 to 4", testRange,
        Range.shift(exampleRangeEqual, 1));
    }

    /* Testing shift method on a range spanning decimal numbers using a negative shift
     */
    @Test
    public void shiftPosPosNeg() {
    	Range testRange = new Range(-0.888888889,-0.888888888);
        assertEquals("The new range should be -0.888888889 to -0.888888889", testRange,
        Range.shift(exampleRangePosPos, -1, true));
    }

    /* Testing shift method on a range spanning decimal numbers using a zero shift
     */
    @Test
    public void shiftPosPosZero() {
    	Range testRange = new Range(0.111111111, 0.111111112);
        assertEquals("The new range should be 0.111111111 to 0.111111112", testRange,
        Range.shift(exampleRangePosPos, 0));
    }

    /* Testing shift method on a range spanning decimal numbers using a positive shift
     */
    @Test
    public void shiftPosPosPos() {
    	Range testRange = new Range(1.111111111, 1.111111112);
        assertEquals("The new range should be 1.111111111 to 1.111111112", testRange,
        Range.shift(exampleRangePosPos, 1));
    }

    /* Testing shift method on a range spanning negative numbers using a negative shift
     */
    @Test
    public void shiftNegNegNeg() {
    	Range testRange = new Range(-7, -4);
        assertEquals("The new range should be -7 to -4", testRange,
        Range.shift(exampleRangeNegNeg, -1));
    }

    /* Testing shift method on a range spanning negative numbers using a zero shift
     */
    @Test
    public void shiftNegNegZero() {
    	Range testRange = new Range(-6, -3);
        assertEquals("The new range should be -6 to -3", testRange,
        Range.shift(exampleRangeNegNeg, 0));
    }

    /* Testing shift method on a range spanning negative numbers using a positive shift
     */
    @Test
    public void shiftNegNegPos() {
    	Range testRange = new Range(-5, -2);
        assertEquals("The new range should be -5 to -2", testRange,
        Range.shift(exampleRangeNegNeg, 1));
    }

    /* * * * *
     * TESITNG scale
     * * * * */

    /* Testing scale method on a range spanning negative to zero using scale of 0
     */
    @Test
    public void scaleNegZeroZero() {
    	Range testRange = new Range(0, 0);
        assertEquals("The new range should be 0 to 0", testRange,
        Range.scale(exampleRangeNegZero, 0));
    }
    
    /* Testing scale method on a range spanning zero to positive using scale of 0
     */
    @Test
    public void scaleZeroPosZero() {
    	Range testRange = new Range(0, 0);
        assertEquals("The new range should be 0 to 0", testRange,
        Range.scale(exampleRangeZeroPos, 0));
    }

    /* Testing scale method on a range spanning negative to negative using scale of 0
     */
    @Test
    public void scaleNegNegZero() {
    	Range testRange = new Range(0,0);
        assertEquals("The new range should be 0 to 0", testRange,
        Range.scale(exampleRangeNegNeg, 0));
    }

    /* Testing scale method on a range spanning positive to positive using scale of 0
     */
    @Test
    public void scalePosPosZero() {
    	Range testRange = new Range(0, 0);
        assertEquals("The new range should be 0 to 0", testRange,
        Range.scale(exampleRangePosPos, 0));
    }

    /* Testing scale method on a range spanning negative to positive using scale of 0
     */
    @Test
    public void scaleNegPosZero() {
    	Range testRange = new Range(0, 0);
        assertEquals("The new range should be 0 to 0", testRange,
        Range.scale(exampleRangeNegPos, 0));
    }

    /* Testing scale method on a range spanning negative to zero using scale of 1/2
     */
    @Test
    public void scaleNegZeroFrac() {
    	Range testRange = new Range(-1.5, 0);
        assertEquals("The new range should be -1.5 to 0", testRange,
        Range.scale(exampleRangeNegZero, 0.5));
    }
    
    /* Testing scale method on a range spanning zero to positive using scale of 1/2
     */
    @Test
    public void scaleZeroPosFrac() {
    	Range testRange = new Range(0, 1.5);
        assertEquals("The new range should be 0 to 1.5", testRange,
        Range.scale(exampleRangeZeroPos, 0.5));
    }
    
    /* Testing scale method on a range spanning negative to negative using scale of 1/2
     */
    @Test
    public void scaleNegNegFrac() {
    	Range testRange = new Range(-3, -1.5);
        assertEquals("The new range should be -3 to -1.5", testRange,
        Range.scale(exampleRangeNegNeg, 0.5));
    }

    /* Testing scale method on a range spanning one number using scale of 1/2
     */
    @Test
    public void scalePosPosFrac() {
    	Range testRange = new Range(1.5, 1.5);
        assertEquals("The new range should be 1.5 to 1.5", testRange,
        Range.scale(exampleRangeEqual, 0.5));
    }

    /* Testing scale method on a range spanning negative to positive using scale of 1/2
     */
    @Test
    public void scaleNegPosFrac() {
    	Range testRange = new Range(-1.25, 1.25);
        assertEquals("The new range should be -1.25 to 1.25", testRange,
        Range.scale(exampleRangeNegPos, 0.5));
    }
    
    /* Testing scale method on a range spanning negative to zero using scale of 1
     */
    @Test
    public void scaleNegZeroOne() {
    	Range testRange = new Range(-3, 0);
        assertEquals("The new range should be -3 to 0", testRange,
        Range.scale(exampleRangeNegZero, 1));
    }
    
    /* Testing scale method on a range spanning zero to positive using scale of 1
     */
    @Test
    public void scaleZeroPosOne() {
    	Range testRange = new Range(0, 3);
        assertEquals("The new range should be 0 to 3", testRange,
        Range.scale(exampleRangeZeroPos, 1));
    }

    /* Testing scale method on a range spanning negative to negative using scale of 1
     */
    @Test
    public void scaleNegNegOne() {
    	Range testRange = new Range(-6, -3);
        assertEquals("The new range should be -6 to -3", testRange,
        Range.scale(exampleRangeNegNeg, 1));
    }

    /* Testing scale method on a range spanning one number using scale of 1
     */
    @Test
    public void scalePosPosOne() {
    	Range testRange = new Range(3, 3);
        assertEquals("The new range should be 3 to 3", testRange,
        Range.scale(exampleRangeEqual, 1));
    }

    /* Testing scale method on a range spanning negative to positive using scale of 1
     */
    @Test
    public void scaleNegPosOne() {
    	Range testRange = new Range(-2.5, 2.5);
        assertEquals("The new range should be -2.5 to 2.5", testRange,
        Range.scale(exampleRangeNegPos, 1));
    }
    
    /* Testing scale method on a range spanning negative to zero using scale of 2
     */
    @Test
    public void scaleNegZeroPos() {
    	Range testRange = new Range(-6, 0);
        assertEquals("The new range should be -6 to 0", testRange,
        Range.scale(exampleRangeNegZero, 2));
    }
    
    /* Testing scale method on a range spanning zero to positive using scale of 2
     */
    @Test
    public void scaleZeroPosPos() {
    	Range testRange = new Range(0, 6);
        assertEquals("The new range should be 0 to 6", testRange,
        Range.scale(exampleRangeZeroPos, 2));
    }

    /* Testing scale method on a range spanning negative to negative using scale of 2
     */
    @Test
    public void scaleNegNegPos() {
    	Range testRange = new Range(-12, -6);
        assertEquals("The new range should be -12 to -6", testRange,
        Range.scale(exampleRangeNegNeg, 2));
    }

    /* Testing scale method on a range spanning one number using scale of 2
     */
    @Test
    public void scalePosPosPos() {
    	Range testRange = new Range(6, 6);
        assertEquals("The new range should be 6 to 6", testRange,
        Range.scale(exampleRangeEqual, 2));
    }

    /* Testing scale method on a range spanning negative to positive using scale of 2
     */
    @Test
    public void scaleNegPosPos() {
    	Range testRange = new Range(-5, 5);
        assertEquals("The new range should be -5 to 5", testRange,
        Range.scale(exampleRangeNegPos, 2));
    }
    
    /* New test for lab 3 */
    /* Testing scale method with negative range factor */
    @Test
    public void scaleNegPosNeg() {
    	try {
	        Range.scale(exampleRangeNegPos, -2);
    	}
    	catch (Exception err){
			assertEquals("IllegalArugmentException error should be thrown",IllegalArgumentException.class, err.getClass());
		}
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
