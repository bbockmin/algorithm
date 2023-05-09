package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1193_분수찾기 {

	static int x;
	static int line=1;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		
		while(x>line) {
			x-=line;
			line++;
		}
		if(line%2==0) {
			System.out.println(x + "/" + (line-x+1));
		} else {
			System.out.println((line-x+1) + "/" + x);
		}
	}
}
