/*
문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.

입출력 예
n	return
118372	873211
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		long testcase = 118372;
		Solution solution = new Solution();
		System.out.println(Solution.solution(testcase));
	}
	
	public static long solution(long n) {
        long answer = 0;
        String str = "";
        ArrayList<Integer> list = new ArrayList<>();
        
        str = String.valueOf(n);
        
        for(int i = 0; i < str.length(); i++) {
            String value = "";
            value = String.valueOf(str.charAt(i));
            
            list.add(Integer.parseInt(value));
        }
        
        str = "";
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i = 0; i < list.size(); i++){
            str = str + list.get(i);
        }
        answer = Long.parseLong(str);
        
        return answer;
    }
}
