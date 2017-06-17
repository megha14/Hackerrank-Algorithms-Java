// Question : https://www.hackerrank.com/challenges/30-nested-logic/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LibraryFines {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int actual_day = in.nextInt();
        int actual_month = in.nextInt();
        int actual_year = in.nextInt();
        int expected_day = in.nextInt();
        int expected_month = in.nextInt();
        int expected_year = in.nextInt();
        
        System.out.println(calculateFine( actual_day,  actual_month,  actual_year,  expected_day,  expected_month, expected_year));
    }
    
    public static int calculateFine(int actual_day, int actual_month, int actual_year, int expected_day, int expected_month, int expected_year){
        int fine = 0;
        if(Math.abs(actual_day - expected_day) > 0){
            if(actual_year == expected_year){
                if(actual_month == expected_month && actual_day>expected_day)
                    fine = 15 * Math.abs(actual_day - expected_day);
                else if(actual_month > expected_month)
                    fine = 500 * Math.abs(actual_month - expected_month);
            }else if(actual_year > expected_year)
                fine = 10000;
        }
       return fine;
    }
}
