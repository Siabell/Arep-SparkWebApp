package edu.escuelaing.arep.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import edu.escuelaing.arep.entities.LinkedListP;

/**
 * Calculator class 
 * Contains the operations to calculate the mean and standard deviation of a list of numbers
 * @author Valentina Siabatto Rojas
 *
 */
public class CalculatorApp {
	
	
	 public static void main(String[] args)throws Exception { 
		 LinkedListP<Double> linkedListcase1 = TextTestToLinkedListOfDoubles("resources\\test1.txt");
		 Double mean1 = mean(linkedListcase1);
		 Double standDev1 = standarDeviation(linkedListcase1);
		 System.out.println("Mean Case 1: " +mean1);
		 System.out.println("Standard Deviation Case 1: " + standDev1+"\n");
		 
		 LinkedListP<Double> linkedListcase2 = TextTestToLinkedListOfDoubles("resources\\test2.txt");
		 Double mean2 = mean(linkedListcase2);
		 Double standDev2 = standarDeviation(linkedListcase2);
	     System.out.println("Mean Case 2: " +mean2);
	     System.out.println("Standard Deviation Case 2: " + standDev2);
	  } 
	 
	 
	 /**
	  * Creates a linkedList of Doubles from a file of double numbers
	  * @param testPath the path of the file
	  * @return A linked List of the double numbers contained in the file
	  * @throws Exception
	  */
	 public static LinkedListP<Double> TextTestToLinkedListOfDoubles (String testPath) throws Exception {
		 File file = new File(testPath); 
		 LinkedListP<Double> linkedList = new LinkedListP<Double>();
		 BufferedReader br = new BufferedReader(new FileReader(file)); 
		 String st; 
		 st = br.readLine();
		 Double testDouble;
		 while (st != null) {
			 //System.out.println(st); 
			 testDouble = Double.parseDouble(st);
			 linkedList.add(testDouble);
	         st = br.readLine();
		 }   
		 return linkedList;
	 }
	
	/**
	 * Calculate the mean of a list of float numbers
	 * @param linkedList list of the float numbers
	 * @return mean of the data
	 */
	public static Double mean (LinkedListP<Double> linkedList) {
		Double result = 0.0;
		int o = 0;
		for (Double doubleData : linkedList) {
			result = result+doubleData;
        }
		result = result/linkedList.size();
		result = result * Math.pow(10, 2);
		result = (double) Math.round(result);
        result = result/Math.pow(10, 2);
		return result;
	}
	
	/**
	 * Calculate the standard Deviation of a list of float numbers
	 * @param linkedList list of the float numbers
	 * @return standard deviation of the list of data
	 */
	public static Double standarDeviation (LinkedListP<Double> linkedList) {
		Double result = 0.0;
		Double mean = mean(linkedList);
		Double sampleVariance = 0.0;
		for (Double doubleData : linkedList) {
			sampleVariance += Math.pow((doubleData-mean), 2);
			
        }
		result = Math.sqrt(sampleVariance / (linkedList.size() - 1));
		result = result * Math.pow(10, 2);
		result = (double) Math.round(result);
        result = result/Math.pow(10, 2);
		return result;
	}

}
