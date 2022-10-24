/*
 * @author Grant Pennington
 * CS330 - Algorithms
 * Project Assignment 2 
 * 
 * My pseudocode works as intended, however, I would have coded this a different way. But since I was supposed to follow my pseudocode, this is very ineffecient.
 * Efficiency: O(n) + O(n) + O(n^3)
*/


import java.security.SecureRandom;

public class GenerateUniqueRandom {
	static int[] Generate(int from, int to) {
		int n = to - from + 1;
		int a[] = new int[n];
		SecureRandom rand = new SecureRandom();
		
		// fill array with random integers
		for(int i = 0; i < n; i++) {
			int x = rand.nextInt(n)+from;
			a[i] = x;
		}
		// check for random duplicate random numbers
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j != i) { // don't check the same the index for duplicate
					if(a[i] == a[j]) {
						// if a duplicate is found set x to be a random number
						int x = rand.nextInt(n)+from;
					
						int k = 0;
						while(k < n) {
							// continue checking if the new random number is already in the array
							if(a[k] == x) {
								// if new random is in the list, generate another random number and continue
								x = rand.nextInt(n)+from;
								k = 0;
							}
							else {
								// else increment k by 1
								k++;
							}
						}
						// once we make it out of the while loop, we know we have a unique random integer
						a[j] = x;
					} 
				}
			}
		}
		return a;
	}
	public static void main(String[] args) {
		int result[] = Generate(0, 10);
	    for( int i = 0; i < result.length; i++) {
	    	System.out.print(result[i]);
	        System.out.print(" ");
	    }
	}
}
