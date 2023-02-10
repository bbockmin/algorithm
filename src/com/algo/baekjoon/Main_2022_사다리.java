package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2022_사다리 {

	static double x,y,c;
	static double w;
	static double low,high;
	static double result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x=Double.parseDouble(st.nextToken());
		y=Double.parseDouble(st.nextToken());
		c=Double.parseDouble(st.nextToken());
		
		//x,y가 대각선이라 w가 아무리 길어도 x,y를 넘을 수 없음 -> 0~x,y중 더 작은거로 이분탐색!
		low = 0;
		high = Math.min(x, y);
		while(high-low>0.000001) {//예제에서 소수점 6자리까지 제공
			w = (low+high)/2;//중간부터 시작
			if(findC(w) >= c) {
				result = w;
				low = w;//low를 큰수로 만든 다음 w를 큰 수로 만든 다음 findC에서 크게 빼줘야 c에 더 가까워 짐
			} else {
				high = w;
			}
		}
		System.out.println(String.format("%.3f", w));
		
	}
	private static double findC(double w) {
		double h1 = Math.sqrt(Math.pow(x,2)-Math.pow(w,2));
		double h2 = Math.sqrt(Math.pow(y,2)-Math.pow(w,2));
		
		return (h1*h2)/(h1+h2);
	}
}
