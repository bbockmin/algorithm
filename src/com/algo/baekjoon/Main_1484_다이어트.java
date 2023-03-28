package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1484_다이어트 {

	static int G;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		
		int start=1;
		int end=1;
		boolean flag=false;
		while(end<=100000) {
			long diff = (long) (Math.pow(start, 2) - Math.pow(end, 2));
			
			if(diff>=G) {
				end++;
			} else {//diff<G
				start++;
			}
			
			if(diff==G) {
				System.out.println(start);
				flag=true;
			}
		}
		
		if(!flag) {
			System.out.println(-1);
		}
	}
}
