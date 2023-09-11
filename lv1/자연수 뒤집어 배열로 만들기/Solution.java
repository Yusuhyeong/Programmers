/*
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.

입출력 예
n	return
12345	[5,4,3,2,1]
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		long testcase = 12345;
		Solution solution = new Solution();
		System.out.println(Arrays.toString(Solution.solution(testcase)));
	}
	
	public static int[] solution(long n) {
        int[] answer = {};
        String str = String.valueOf(n);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < str.length(); i++) {
            list.add(0, Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
