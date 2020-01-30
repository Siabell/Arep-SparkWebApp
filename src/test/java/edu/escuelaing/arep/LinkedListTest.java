package edu.escuelaing.arep;

import java.util.Collection;

import edu.escuelaing.arep.entities.LinkedListP;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LinkedListTest extends TestCase {
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LinkedListTest.class );
    }
    

	//System.out.println(getResult + "lenght");
	//System.out.print(getResult);
    
    public void testShouldCreateAnEmptyLinkedList()
    {
    	LinkedListP<Integer> linkedList = new LinkedListP<Integer>();
    	int size = linkedList.size();
    	assertTrue(size==0);
    	
    }
    
    public void testShouldCreateALinkedListFromArray() {
    	Double[] newLinkedList = {23.34, 3453.2,45.3,34.4};
    	LinkedListP<Double> linkedList = new LinkedListP<Double>(newLinkedList);
    	assertTrue(linkedList.get(0)==23.34);
    	assertTrue(linkedList.get(3)==34.4);
    }
    
    public void testShouldAddAElementToLinkedList()
    {
    	LinkedListP<Integer> linkedList = new LinkedListP<Integer>();
    	assertTrue(linkedList.add(2));
    	assertTrue(linkedList.add(3));
    	assertTrue(linkedList.add(4));
    }
    
    public void testShouldAddAElementWithIndexToLinkedList()
    {
    	LinkedListP<Integer> linkedList = new LinkedListP<Integer>();
    	assertTrue(linkedList.add(2));
    	assertTrue(linkedList.add(4));
    	assertTrue(linkedList.add(6));
    	linkedList.add(0,1);
    	linkedList.add(2,3);
    	linkedList.add(4,5);
    	assertTrue(linkedList.get(0)==1);
    	assertTrue(linkedList.get(3)==4);
    	assertTrue(linkedList.get(5)==6);
    	assertTrue(linkedList.get(4)==5);
    }
    
    
    public void testShouldGetElementByIndex(){}
    {
    	LinkedListP<Integer> linkedList = new LinkedListP<Integer>();
    	assertTrue(linkedList.add(2));
    	assertTrue(linkedList.add(3));
    	assertTrue(linkedList.add(4));
    	Integer getResult = linkedList.get(2);
    	assertTrue(getResult == 4);
    }
    
    
    public void testShouldRemoveElementByIndex(){}
    {
    	LinkedListP<Integer> linkedList = new LinkedListP<Integer>();
    	assertTrue(linkedList.add(1));
    	assertTrue(linkedList.add(2));
    	assertTrue(linkedList.add(3));
    	assertTrue(linkedList.add(4));
    	assertTrue(linkedList.remove(0)==1);
    	assertTrue(linkedList.get(0) == 2);
    }
    
   public void testShouldEmptyALinkedList(){
	   LinkedListP<Integer> linkedList = new LinkedListP<Integer>();
	   assertTrue(linkedList.add(1));
	   assertTrue(linkedList.add(2));
	   assertTrue(linkedList.add(3));
	   assertTrue(linkedList.add(4));
	   linkedList.clear();
	   //System.out.print(linkedList.size());
	   assertTrue(linkedList.size()==0);
	   	
   }
    
}   


