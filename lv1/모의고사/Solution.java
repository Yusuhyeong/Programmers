/*
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

입출력 예
answers			return
[1,2,3,4,5]		[1]
[1,3,2,4,2]		[1,2,3]
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int[] testcase = {1,2,3,4,5};
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.solution(testcase)));
	}
	
	public static int[] solution(int[] answers) {
        HashSet<Integer> answerSet = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        
        int studentOne = student1(answers);
        
        if(max <= studentOne) {
            max = studentOne;
            list.add(1);
        }
        
        int studentTwo = student2(answers);
        
        if(max < studentTwo) {
            max = studentTwo;
            list.clear();
            list.add(2);
        }
        else if(max == studentTwo) {
            list.add(2);
        }
        
        int studentThree = student3(answers);
        
        if(max < studentThree) {
            list.clear();
            list.add(3);
        }
        else if(max == studentThree) {
            list.add(3);
        }
        
        // System.out.println(list);
        // System.out.println("학생1 : " + studentOne + " 학생2 : " + studentTwo + " 학생3 : " + studentThree);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private static int student1(int[] answer) {
        int[] std = {1, 2, 3, 4, 5};
        int j = 0;
        int count = 0;
        
        for(int i = 0; i < answer.length; i++) {
            if(j == std.length) {
                j = 0;
            }
            if(std[j] == answer[i]) {
                count++;
            }
            j++;
        }
        
        return count;
    }
    
    private static int student2(int[] answer) {
        int[] std = {2, 1, 2, 3, 2, 4, 2, 5};
        int j = 0;
        int count = 0;
        
        for(int i = 0; i < answer.length; i++) {
            if(j == std.length) {
                j = 0;
            }
            if(std[j] == answer[i]) {
                count++;
            }
            j++;
        }
        
        return count;
    }
    
    private static int student3(int[] answer) {
        int[] std = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int j = 0;
        int count = 0;
        
        for(int i = 0; i < answer.length; i++) {
            if(j == std.length) {
                j = 0;
            }
            if(std[j] == answer[i]) {
                count++;
            }
            j++;
        }
        
        return count;
    }
}
