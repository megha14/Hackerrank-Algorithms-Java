/**  
* MaxGcdSum --- Given two Arrays A and B, Find a pair (x, y) such that it has the highest gcd and highest sum among all such pairs (x, y)
* @author Megha Rastogi
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxGcdSum {
    
    //Maximum size an array can hold
    static int limit = 1000000+6;

    //Array to store count of occurences of an element in A
	static int[] countA = new int[limit];

	//Array to store count of occurences of an element in B
	static int[] countB = new int[limit];

	//Array to store count of multiples of elements in A
	static int[] multiplesA = new int[limit];

	//Array to store count of multiples of elements in B
	static int[] multiplesB = new int[limit];

	/**
    * Update count of elements of A and B in countA and countB arrays respectively
    * @param arrayA 
    * @param arrayB
    * @return No return Value
    */
	static void updateCount(int[] arrayA, int[] arrayB){

		//For each element in A, increase value of that element as position in countA
		for(int i = 0; i < arrayA.length; ++i)
			++countA[arrayA[i]];

		//For each element in A, increase value of that element as position in countA
		for(int i = 0; i < arrayB.length; ++i){
			++countB[arrayB[i]];
	}

	/**
    * Update multiples of A and B in multiplesA and multiplesB arrays respectively
    * @return No return Value
    */
	static void updateMultiples(){

		for(int i = 1; i < limit; i++){
			for(int j = i; j < limit; j+=i){
				if(countA[j] != 0)
					multiplesA[i] = j;
			}
		}

		for(int i = 1; i < limit; i++){
			for(int j = i; j < limit; j+=i){
				if(countB[j] != 0)
					multiplesB[i] = j;
			}
		}
	}

	/**
    * Find the pair (x, y) with highest gcd and highest sum.
    * @param arrayA 
    * @param arrayB
    * @return integer representing sum of pair (x, y) with highest gcd and sum
    */
    static int maximumGcdAndSum(int[] arrayA, int[] arrayB) {
        
        int max = 0;
		updateCount(arrayA, arrayB);
		updateMultiples();

		//Iterate over multiplesA and multiplesB and update max when ith element
		//of both multiplesA and multiplesB is greater than 0
		for(int i = 1; i < limit ; i++){
			if(multiplesA[i]>0 && multiplesB[i]>0)
				max = i;
		}
		return multiplesA[max] + multiplesB[max];
    }
    

    /**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for(int B_i = 0; B_i < n; B_i++){
            B[B_i] = in.nextInt();
        }
        int res = maximumGcdAndSum(A, B);
        System.out.println(res);
    }
}
