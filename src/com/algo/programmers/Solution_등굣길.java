package com.ssafy.algo;

//오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return
public class Solution_등굣길 {

	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] {{2,2}}));
	}
	
	public static int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        
        int[][] street = new int[n][m];
        
        //웅덩이 표시 -1
        for (int i = 0; i < puddles.length; i++) {
        	street[puddles[i][1]-1][puddles[i][0]-1] = -1;//행, 열 거꾸로 세팅되어 있음
		}
        
        street[0][0] = 1;//집
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(street[i][j] == -1) {
					continue;
				}
				if(i!=0 && street[i-1][j] > 0) {
					street[i][j] += street[i-1][j] % mod;
				}
				if(j!=0 && street[i][j-1] > 0) {
					street[i][j] += street[i][j-1] % mod;
				}
			}
		}
        
        return street[n-1][m-1] % mod;
    }
}
