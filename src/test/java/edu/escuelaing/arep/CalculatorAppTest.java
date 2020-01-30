package edu.escuelaing.arep;

import edu.escuelaing.arep.calculator.CalculatorApp;
import edu.escuelaing.arep.calculator.entities.LinkedListP;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculatorAppTest extends TestCase {

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorAppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CalculatorAppTest.class );
    }
    
    public void testItShouldCalculateMean() {

        LinkedListP<Double> linkedList1 = new LinkedListP<Double>();
        linkedList1.add(160.0);
        linkedList1.add(591.0);
        linkedList1.add(114.0);
        linkedList1.add(229.0);
        linkedList1.add(230.0);
        linkedList1.add(270.0);
        linkedList1.add(128.0);
        linkedList1.add(1657.0);
        linkedList1.add(624.0);
        linkedList1.add(1503.0);
        
        double resultMean1 = CalculatorApp.mean(linkedList1);
        //System.out.println(resultMean1);
        assertTrue(resultMean1 == 550.6);
        
        LinkedListP<Double> linkedList2 = new LinkedListP<Double>();
        linkedList2.add(15.0);
        linkedList2.add(69.9);
        linkedList2.add(6.5);
        linkedList2.add(22.4);
        linkedList2.add(28.4);
        linkedList2.add(65.9);
        linkedList2.add(19.4);
        linkedList2.add(198.7);
        linkedList2.add(38.8);
        linkedList2.add(138.2);

        double resultMean2 = CalculatorApp.mean(linkedList2);
        assertTrue(resultMean2 == 60.32 );
    }
    
    public void testItShouldCalculateStandardDeviation() {

        LinkedListP<Double> linkedList1 = new LinkedListP<Double>();
        linkedList1.add(160.0);
        linkedList1.add(591.0);
        linkedList1.add(114.0);
        linkedList1.add(229.0);
        linkedList1.add(230.0);
        linkedList1.add(270.0);
        linkedList1.add(128.0);
        linkedList1.add(1657.0);
        linkedList1.add(624.0);
        linkedList1.add(1503.0);
        
        double resultMean1 = CalculatorApp.standarDeviation(linkedList1);
        //System.out.println(resultMean1+"va");
        assertTrue(resultMean1 == 572.03);
        
        LinkedListP<Double> linkedList2 = new LinkedListP<Double>();
        linkedList2.add(15.0);
        linkedList2.add(69.9);
        linkedList2.add(6.5);
        linkedList2.add(22.4);
        linkedList2.add(28.4);
        linkedList2.add(65.9);
        linkedList2.add(19.4);
        linkedList2.add(198.7);
        linkedList2.add(38.8);
        linkedList2.add(138.2);

        double resultMean2 = CalculatorApp.standarDeviation(linkedList2);
        assertTrue(resultMean2 == 62.26 );
    }
}
