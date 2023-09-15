/*
문제 설명
자연수 n이 매개변수로 주어집니다. 
n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.

입출력 예
n	result
45	7
125	229
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int testcase = 45;
		Solution solution = new Solution();
		System.out.println(Solution.solution(testcase));
	}
	
	public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int value = n;
        int k = 1;
        
        while(value != 0) {
            list.add(value % 3);
            value = value / 3;
        }
        
        for(int i = list.size()-1; i >= 0; i--) {
            answer = answer + list.get(i) * k;
            k = k * 3;
        }
        
        // System.out.println(list);
        
        return answer;
    }
}
