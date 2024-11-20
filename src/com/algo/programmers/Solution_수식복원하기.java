package com.ssafy.algo;

import java.util.*;

public class Solution_수식복원하기 {

	//2~9진수로 이루어진 수식 주어짐
	//몇진법인지 찾고 X의 값이 하나면 X 구하기
	//X의 값이 여러개면 ?로 대체해서 X가 포함된 수식만 출력하기
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"})));
	}

	public static String[] solution(String[] expressions) {
		List<String> completeExpression = new ArrayList<>();//정상적인 수식
		List<String> problemExpression = new ArrayList<>();//X 들어있는 수식
		
		for(String expression : expressions) {//수식 분류
			if(!expression.contains("X")) {
				completeExpression.add(expression);
			} else {
				problemExpression.add(expression);
			}
		}
		String[] result = new String[problemExpression.size()];//X가 포함된 수식만 출력
		Map<Integer, Integer> expressionMap = new HashMap<>();//사용가능한 진법을 확인하기 위한 맵 선언
		expressionMap.put(2, 0);
		expressionMap.put(3, 0);
		expressionMap.put(4, 0);
		expressionMap.put(5, 0);
		expressionMap.put(6, 0);
		expressionMap.put(7, 0);
		expressionMap.put(8, 0);
		expressionMap.put(9, 0);
		
		int maxDigitInComplate = 0; //정상 수식에서 제일 큰 수
		int minBaseInComplete = 0;//진법
		
		for(String ex : completeExpression) {//정상 수식에서 최소 진법 찾아내기
			String[] parts = ex.split(" ");
			int maxDigit = Math.max(getMaxDigit(parts[0]), getMaxDigit(parts[2]));
			maxDigit = Math.max(maxDigit, getMaxDigit(parts[4]));
			maxDigitInComplate = Math.max(maxDigit, maxDigitInComplate);
		}
		minBaseInComplete = maxDigitInComplate + 1; //정상수식에서 제일 큰 수 + 1 = 최소 진법
		
		for(String ex : completeExpression) { //최소 진법부터 정상수식에 맞는지 체크하면서 맞는 진법 찾기
			String[] parts = ex.split(" ");
			String op = parts[1];
			
			for (int base = minBaseInComplete; base <= 9; base++) {
				check(parts, base, op, expressionMap);
			}
		}
		
		int maxDigitInProblem = 0;//X수식에서 제일 큰 수
		int minBaseInProblem = 0;//진법
		
		for(String ex : problemExpression) {//X수식에서 최소 진법 찾아내기
			String[] parts = ex.split(" ");
			int maxDigit = Math.max(getMaxDigit(parts[0]), getMaxDigit(parts[2]));
			maxDigitInProblem = Math.max(maxDigit, maxDigitInProblem);
		}
		minBaseInProblem = maxDigitInProblem + 1; //X수식에서 제일 큰 수 + 1 = 최소 진법
		
		for(int i = 0; i <problemExpression.size(); i++) {//X수식 하나씩 확인
			String[] parts = problemExpression.get(i).split(" ");
			String op = parts[1];
			
			Set<String> resultSet = new HashSet<>();//X의 값 넣는 set
			for(int base = minBaseInProblem; base <= 9; base++) {
				int value = expressionMap.get(base);//정상수식에서 해당 진법이 사용된 수 가져오기 
				if(value == completeExpression.size()) {//value와 정상수식의 사이즈가 같으면 해당 진법으로 계산이 맞는 정상수식이라는 뜻
					checkSet(parts, base, op, resultSet);
				}
			}
			
			if(resultSet.size() != 1) {//X에 들어갈 수 있는 값이 1개가 아니면 ?로 변환
				result[i] = parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]+" "+"?";
			} else {
				Iterator<String> it = resultSet.iterator();
				if(it.hasNext()) {
					String value = it.next();
					result[i] = parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]+" "+value;
				}
			}
		}
		
		return result;
	}

	//수식쪼갠 배열, 진법, 연산, X의 값 넣는 set
	private static void checkSet(String[] parts, int base, String op, Set<String> resultSet) {
		if(!isValidNumber(parts[0], base) || !isValidNumber(parts[2], base)) {
			return;
		}
		int num1 = Integer.parseInt(parts[0], base);//10진법으로 변환
		int num2 = Integer.parseInt(parts[2], base);
		
		int res = op.equals("+") ? num1+num2 : num1-num2;
		String ans = Integer.toString(res, base);//base진법으로 변환
		
		resultSet.add(ans);//X에 들어가는 값
	}

	//수식쪼갠 배열, 진법, 연산, 사용가능한 진법을 확인하기 위한 맵
	private static void check(String[] parts, int base, String op, Map<Integer, Integer> expressionMap) {
		if(!isValidNumber(parts[0], base) || !isValidNumber(parts[2], base) || !isValidNumber(parts[4], base)) {
			return;
		}
		int num1 = Integer.parseInt(parts[0], base);//10진법으로 변환
		int num2 = Integer.parseInt(parts[2], base);//10진법으로 변환
		int res = op.equals("+") ? num1 + num2 : num1- num2;
		
		String ans = Integer.toString(res, base);//base진법으로 변환
		
		if(ans.equals(parts[4])) {
			expressionMap.merge(base, 1, Integer::sum);//Map에 해당하는 진법에 1 더해주기 
		}
	}

	//진법 변환이 가능한지 체크
	private static boolean isValidNumber(String number, int base) {
		for(char c : number.toCharArray()) {//한자리씩 다 체크
			int digit = Character.getNumericValue(c);
			if(digit < 0 || digit >= base) {//음수이거나 base이상이면 진법에 포함 안됨
				return false;
			}
		}
		return true;
	}

	//숫자에서 제일 큰 수 뽑아내기
	private static int getMaxDigit(String number) {
		int maxDigit = 0;
		for(char c : number.toCharArray()) {
			if(Character.isDigit(c)) {//숫자면
				maxDigit = Math.max(maxDigit, Character.getNumericValue(c));//숫자로 변환 후 비교
			}
		}
		return maxDigit;
	}

}
