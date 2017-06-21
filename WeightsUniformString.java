//https://www.hackerrank.com/challenges/weighted-uniform-string

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WeightsUniformString {

    public static void main(String[] args) {
        HashSet<Integer> weights; 
        Scanner in = new Scanner(System.in);
        String s = in.next();
        weights = getWeights(s);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            // your code goes here
            if(weights.contains(x))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    
    public static HashSet<Integer> getWeights(String s){
        HashSet<Integer> weights = new HashSet<Integer>();
        int numRepeats = 1;
        for(int i = 0;i<s.length();i++){
            int w = s.charAt(i) - 'a' + 1;
            if(i+1<s.length() && s.charAt(i) == s.charAt(i+1))
                numRepeats += 1;
            else
                numRepeats = 1;                            
            int newWeight = w*numRepeats;
            weights.add(newWeight);
        }
        return weights;
    }
}
