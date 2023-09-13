/*
문제 설명
두 정수 left와 right가 매개변수로 주어집니다. 
left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ left ≤ right ≤ 1,000

입출력 예
left	right	result
13		17		43
24		27		52
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int testcaseA = 13;
		int testcaseB = 17;
		Solution solution = new Solution();
		System.out.println(solution(testcaseA, testcaseB));
	}
	
	public static int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int count = 0;
            for(int j = 1; j * j <= i; j++) {
                if(j * j == i)
                    count++;
                else if (i % j == 0)
                    count += 2;
            }
            
            // System.out.println(i + "의 약수는 " + count + "개 입니다.");
            
            if(count % 2 == 0) {
                answer = answer + i;
            }
            else {
                answer = answer - i;
            }
        }
        
        return answer;
    }
}
