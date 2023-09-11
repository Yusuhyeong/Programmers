/*
문제 설명
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수

입출력 예
N	answer
123	6
987	24
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int testcase = 123;
		Solution solution = new Solution();
		System.out.println(solution.solution(testcase));
	}
	
	public int solution(int n) {
        int answer = 0;
        int value = 0;
        value = n;
        while(true){
            int listValue = 0;
            listValue = value % 10;
            
            answer = answer + listValue;
            if(value / 10 == 0) {
                break;
            }
            else{
                value = value / 10;
            }
        }

        return answer;
    }
}
