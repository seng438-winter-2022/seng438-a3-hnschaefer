package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	private Mockery mockTotalZero;
    private Values2D valuesZero;
	private Mockery mockTotalPos;
    private Values2D valuesPos;
	private Mockery mockTotalNeg;
    private Values2D valuesNeg;
	private Mockery mockEmpty;
    private Values2D valuesEmpty;
    private Mockery mockNull;
    private Values2D valuesNull;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	// first column and row add to zero
    	/* -5.5  5.5 -5.5  5.5 -5.5  5.5 : 0
    	 *  5.5
    	 * -5.5
    	 *  5.5
    	 * -5.5
    	 *  5.5
    	 *  : 0
    	 * */
        mockTotalZero = new Mockery();
        valuesZero = mockTotalZero.mock(Values2D.class);
        mockTotalZero.checking(new Expectations() {
            {
                one(valuesZero).getRowCount();
                will(returnValue(6));
                one(valuesZero).getValue(0, 0);
                will(returnValue(-5.5));
                one(valuesZero).getValue(1, 0);
                will(returnValue(5.5));
                one(valuesZero).getValue(2, 0);
                will(returnValue(-5.5));
                one(valuesZero).getValue(3, 0);
                will(returnValue(5.5));
                one(valuesZero).getValue(4, 0);
                will(returnValue(-5.5));
                one(valuesZero).getValue(5, 0);
                will(returnValue(5.5));
                // columns
                one(valuesZero).getColumnCount();
                will(returnValue(6));
                one(valuesZero).getValue(0, 1);
                will(returnValue(5.5));
                one(valuesZero).getValue(0, 2);
                will(returnValue(-5.5));
                one(valuesZero).getValue(0, 3);
                will(returnValue(5.5));
                one(valuesZero).getValue(0, 4);
                will(returnValue(-5.5));
                one(valuesZero).getValue(0, 5);
                will(returnValue(5.5));
            }
        });

        // first column and row add to positive
    	/* 100 100 100 : 300
    	 * 100
    	 * 100
    	 * : 300
    	 * */
        mockTotalPos = new Mockery();
        valuesPos = mockTotalPos.mock(Values2D.class);
        mockTotalPos.checking(new Expectations() {
        	 {
                 one(valuesPos).getRowCount();
                 will(returnValue(3));
                 one(valuesPos).getValue(0, 0);
                 will(returnValue(100));
                 one(valuesPos).getValue(1, 0);
                 will(returnValue(100));
                 one(valuesPos).getValue(2, 0);
                 will(returnValue(100));
                 // columns
                 one(valuesPos).getColumnCount();
                 will(returnValue(3));
                 one(valuesPos).getValue(0, 1);
                 will(returnValue(100));
                 one(valuesPos).getValue(0, 2);
                 will(returnValue(100));
             }
        });

        // first column and row add to negative
    	/* -100 -100 -100
    	 * -100
    	 * -100
    	 * */
        mockTotalNeg = new Mockery();
        valuesNeg = mockTotalNeg.mock(Values2D.class);
        mockTotalNeg.checking(new Expectations() {
       	 {
             one(valuesNeg).getRowCount();
             will(returnValue(3));
             one(valuesNeg).getValue(0, 0);
             will(returnValue(-100));
             one(valuesNeg).getValue(1, 0);
             will(returnValue(-100));
             one(valuesNeg).getValue(2, 0);
             will(returnValue(-100));
             // columns
             one(valuesNeg).getColumnCount();
             will(returnValue(3));
             one(valuesNeg).getValue(0, 1);
             will(returnValue(-100));
             one(valuesNeg).getValue(0, 2);
             will(returnValue(-100));
         }
        });
        // no rows or columns
        mockEmpty = new Mockery();
        valuesEmpty = mockEmpty.mock(Values2D.class);
        mockEmpty.checking(new Expectations() {
          	 {
                 one(valuesEmpty).getRowCount();
                 will(returnValue(0));
                 one(valuesEmpty).getColumnCount();
                 will(returnValue(0));
                 one(valuesNeg).getValue(0, 0);
                 will(returnValue(1));
                 one(valuesNeg).getValue(1, 0);
                 will(returnValue(null));
                 one(valuesNeg).getValue(0, 1);
                 will(returnValue(1));
             }
        });

        // elements are null
        mockNull = new Mockery();
        valuesNull = mockNull.mock(Values2D.class);
        mockNull.checking(new Expectations() {
          	 {
                 one(valuesNull).getRowCount();
                 will(returnValue(1));
                 one(valuesNull).getColumnCount();
                 will(returnValue(1));
                 one(valuesNull).getValue(0, 0);
                 will(returnValue(null));
//                 one(valuesNeg).getValue(1, 0);
//                 will(returnValue(null));
//                 one(valuesNeg).getValue(0, 1);
//                 will(returnValue(null));
             }
        });
    }

    /* * * * *
     * TESITNG calculateColumnTotal
     * * * * */

    /* Testing calculate column total method where all columns add to zero
     */
    @Test
    public void calculateColumnTotalForZero() {
        // setup - DONE WITH PRIVATE CLASS FIELDS
    	// todo: ask if we should make a setup for each test individually

        // exercise
        double result = DataUtilities.calculateColumnTotal(valuesZero, 0);
        // verify
        assertEquals(result, 0.0, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate column total method where column adds to positive 300
     */
    @Test
    public void calculateColumnTotalForPos() {
        double result = DataUtilities.calculateColumnTotal(valuesPos, 0);
        // verify
        assertEquals(result, 300, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate column total method where column adds to negative 300
     */
    @Test
    public void calculateColumnTotalForNeg() {
        double result = DataUtilities.calculateColumnTotal(valuesNeg, 0);
        // verify
        assertEquals(result, -300, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate column total method where no columns or rows exist
     */
    @Test
    public void calculateColumnTotalForEmpty() {
        double result = DataUtilities.calculateColumnTotal(valuesEmpty, 0);
        // verify
        assertEquals(result, 0, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate column total method where null Values2D object is passed
     */
    @Test
    public void calculateColumnTotalForNullObject() {
    	try{
            double result = DataUtilities.calculateColumnTotal(null, 0);
    	}
    	catch (Exception err){
            assertEquals("IllegalArugmentException error should be thrown",IllegalArgumentException.class, err.getClass());
    	}
        // tear-down: NONE in this test method
    }

    /* Testing calculate column total method where a Values2D object with a null entry is passed
     */
    @Test
    public void calculateColumnTotalForNullElement() {
    	double result = DataUtilities.calculateColumnTotal(valuesNull, 0);
        assertEquals(result, 0, .000000001d);
    }


    /* * * * *
     * TESITNG calculateRowTotal
     * * * * */

    /* Testing calculate row total method where row adds to zero
     */
    @Test
    public void calculateRowTotalForZero() {
    	// todo: ask if we should make a setup for each test individually

        // exercise
        double result = DataUtilities.calculateRowTotal(valuesZero, 0);
        // verify
        assertEquals(result, 0.0, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate row total method where row adds to positive 300
     */
    @Test
    public void calculateRowTotalForPos() {
        double result = DataUtilities.calculateRowTotal(valuesPos, 0);
        // verify
        assertEquals(result, 300, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate row total method where row adds to negative 300
     */
    @Test
    public void calculateRowTotalForNeg() {
        double result = DataUtilities.calculateRowTotal(valuesNeg, 0);
        // verify
        assertEquals(result, -300, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate row total method where no rows or columns exist
     */
    @Test
    public void calculateRowTotalForEmpty() {
        double result = DataUtilities.calculateRowTotal(valuesEmpty, 0);
        // verify
        assertEquals(result, 0, .000000001d);
        // tear-down: NONE in this test method
    }

    /* Testing calculate row total method where Values2D object is null
     */
    @Test
    public void calculateRowTotalForNull() {
    	try{
            double result = DataUtilities.calculateRowTotal(valuesNull, 0);
    	}
    	catch (Exception err){
            assertEquals("IllegalArugmentException error should be thrown",IllegalArgumentException.class, err.getClass());
    	}
        // tear-down: NONE in this test method
    }

    /* Testing calculate row total method where a Values2D object with a null entry is passed
     */
    @Test
    public void calculateRowTotalForNullElement() {
    	double result = DataUtilities.calculateRowTotal(valuesNull, 0);
        assertEquals(result, 0, .000000001d);
    }

    /* * * * *
     * TESITNG clone
     * * * * */

    /* Testing clone method using a 2D array of all zero elements
     */
    @Test
    public void cloneZero() {
        // exercise
    	double[][] testArrZero = {{0,0,0},{0,0,0},{0,0,0}};
        double[][] result = DataUtilities.clone(testArrZero);
        // verify
        assertArrayEquals(result, testArrZero);
        // tear-down: NONE in this test method
    }

    /* Testing clone method using a 2D array of all positive elements
     */
    @Test
    public void clonePos() {
    	double[][] testArrPos = {{1,1,1},{1,1,1},{1,1,1}};
        double[][] result = DataUtilities.clone(testArrPos);
        // verify
        assertArrayEquals(result, testArrPos);
        // tear-down: NONE in this test method
    }

    /* Testing clone method using a 2D array of all negative elements
     */
    @Test
    public void cloneNeg() {
    	double[][] testArrNeg = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        double[][] result = DataUtilities.clone(testArrNeg);
        // verify
        assertArrayEquals(result, testArrNeg);
        // tear-down: NONE in this test method
    }

    /* Testing clone method using null 2D array
     */
    @Test
    public void cloneEmpty() {
    	double[][] testArrEmpty = null;
    	try{
            double[][] result = DataUtilities.clone(testArrEmpty);
    	}
    	catch (Exception err){
            assertEquals("IllegalArugmentException error should be thrown",IllegalArgumentException.class, err.getClass());
    	}
        // tear-down: NONE in this test method
    }

    /* Testing clone method using a 2D array with a null element
     */
    @Test
    public void cloneNullElement() {
    	double[][] testNullElement = {null};
        double[][] result = DataUtilities.clone(testNullElement);
        assertArrayEquals(result, testNullElement);
    }


    /* * * * *
    * TESITNG createNumberArray
    * * * * */

    //    Empty array
    @Test
    public void createNumberArrayEmpty() {
        double [] empty= {};
        Number [] testEmpty= {};
        Number [] result= DataUtilities.createNumberArray(empty);
        assertArrayEquals(result, testEmpty);
    }


    //	Array with one value
    @Test
    public void createNumberArrayOneValue() {
        double [] oneValue= {10.1};
        Number[] testOneArr= {10.1}; //Has same value as on
        Number [] result= DataUtilities.createNumberArray(oneValue);
        // verify
        assertArrayEquals(result,testOneArr);
        // tear-down: NONE in this test method
    }


    //  Array with 3 values
    @Test
    public void createNumberArrayThreeValues() {
        double [] threeValues= {1.1,5.9, 100.01};
        Number [] testThreeValues={1.1,5.9, 100.01};
        Number [] result= DataUtilities.createNumberArray(threeValues);
        // verify
        assertArrayEquals(result, testThreeValues);
        // tear-down: NONE in this test method
    }

    //  Array with 3 negative values
    @Test
    public void createNumberArrayThreeValuesNeg() {
        double [] threeValues= {-1.1,-5.9, -100.01};
        Number [] testThreeValues={-1.1,-5.9, -100.01};
        Number [] result= DataUtilities.createNumberArray(threeValues);
        assertArrayEquals(result, testThreeValues);
        // tear-down: NONE in this test method
    }

    //    Array with 3 values and one of them has 3 decimal places
    @Test
    public void createNumberArrayThreeValues3Decs() {
        double [] threeValues= {1.1, -100.001, 3.3};
        Number [] testThreeValues={1.1, -100.001, 3.3};
        Number [] result= DataUtilities.createNumberArray(threeValues);
        assertArrayEquals(result, testThreeValues);
    }


	//  Array of 3 values, with some large positive and negative numbers
	@Test
	public void createNumberArrayThreeValuesBigNum() {
	  	double [] threeValues= {1234569.9000000, 999999999.99999, -999999999.99999};
	  	Number [] testThreeValues={1234569.9000000, 999999999.99999, -999999999.99999};
	  	Number [] result= DataUtilities.createNumberArray(threeValues);
	  	assertEquals(result, testThreeValues);
	}

	//Creates a null array- expects to throw exception
	@Test
	public void createNumberArrayNull() {
		double [] threeValues= null;
		Number [] testThreeValues= null;
		try {
			Number [] result= DataUtilities.createNumberArray(threeValues);
		}
		catch (Exception err){
			assertEquals("IllegalArugmentException error should be thrown",IllegalArgumentException.class, err.getClass());
		}
	}


    /* * * * *
    * TESITNG createNumberArray2D
    * * * * */

    @Test
    public void createNumberArray2DEmpty() {
        double[][] byThree = {{},{},{}};
        Number[][] result = DataUtilities.createNumberArray2D(byThree);
        // verify
        assertArrayEquals(result, byThree);
        // tear-down: NONE in this test method
    }

    /*
     * One by one array
     */

    @Test
    public void createNumberArray2DByOnePos() {
        double [][] oneValue= {{1.1}};
    //    	Number [][] testOneValue= {{1.1}};
        Number [][] result= DataUtilities.createNumberArray2D(oneValue);
        // verify
        assertArrayEquals(result, oneValue);
    }

    /*
     * Three by three array
     */
    @Test
    public void createNumberArray2DByThreePos() {
        double[][] byThree = {{1,1,1},{1,1,1},{1,1,1}};
        Number[][] result = DataUtilities.createNumberArray2D(byThree);
        // verify
        assertArrayEquals(result, byThree);
        // tear-down: NONE in this test method
    }

    /*
     * three by three array of negative numbers
     */
    @Test
    public void createNumberArray2DByThreeNeg() {
        double[][] byThree = {{-1,-1,-1},{1,1,1},{-1,-1,-1}};
        Number[][] result = DataUtilities.createNumberArray2D(byThree);
        // verify
        assertArrayEquals(result, byThree);
        // tear-down: NONE in this test method
    }


    //   has row with small decimal numbers and negative numbers
    @Test
    public void createNumberArray2DByThreeSmallNum() {
        double[][] byThree = {{0.0000000000001,0.192912919394945999, 0.01120305067080},{1,1,1},{-1,-1,-1}};
        Number[][] result = DataUtilities.createNumberArray2D(byThree);
        // verify
        assertArrayEquals(result, byThree);
        // tear-down: NONE in this test method
    }

    /*
     * tests a 3 by 5 array containing negative and positive numbers
     */
    @Test
    public void createNumberArray2DThreeByFive() {
    	double[][] threeByFive= {{12.34569,9.99999, -99.99999},
    			{12.34569,9.99999, -99.99999},
    			{12.34569,9.99999, -99.99999},
    			{12.34569,9.99999, -99.99999},
    			{12.34569,9.99999, -99.99999}};
        Number[][] result = DataUtilities.createNumberArray2D(threeByFive);
        // verify
        assertArrayEquals(result, threeByFive);
        // tear-down: NONE in this test method
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
