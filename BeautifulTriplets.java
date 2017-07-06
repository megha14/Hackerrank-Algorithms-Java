//https://www.hackerrank.com/challenges/beautiful-triplets

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BeautifulTriplets {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] ar = new int[n];
        for(int i = 0;i<n;i++)
            ar[i] = in.nextInt();
        in.close();
        System.out.println(findCounts(ar,d));
    }
    
    static int findCounts(int[] ar, int d){
        int counts = 0;
        int a[] = new int[2*100000];

        for(int i = 0; i<ar.length; i++)
            a[ar[i]] = 1;

        for(int i = 0; i<ar.length; i++){
            if(a[ar[i]+d] == 1 && a[ar[i]+d+d] == 1)
                counts += 1;
        }
        return counts;
    }
}
