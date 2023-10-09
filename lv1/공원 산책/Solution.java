/*
문제 설명
지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.

["방향 거리", "방향 거리" … ]
예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.

주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.

공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때, 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
3 ≤ park의 길이 ≤ 50
3 ≤ park[i]의 길이 ≤ 50
park[i]는 다음 문자들로 이루어져 있으며 시작지점은 하나만 주어집니다.
S : 시작 지점
O : 이동 가능한 통로
X : 장애물
park는 직사각형 모양입니다.

1 ≤ routes의 길이 ≤ 50
routes의 각 원소는 로봇 강아지가 수행할 명령어를 나타냅니다.
로봇 강아지는 routes의 첫 번째 원소부터 순서대로 명령을 수행합니다.
routes의 원소는 "op n"과 같은 구조로 이루어져 있으며, op는 이동할 방향, n은 이동할 칸의 수를 의미합니다.
op는 다음 네 가지중 하나로 이루어져 있습니다.
N : 북쪽으로 주어진 칸만큼 이동합니다.
S : 남쪽으로 주어진 칸만큼 이동합니다.
W : 서쪽으로 주어진 칸만큼 이동합니다.
E : 동쪽으로 주어진 칸만큼 이동합니다.
1 ≤ n ≤ 9

입출력 예
park						routes					result
["SOO","OOO","OOO"]			["E 2","S 2","W 1"]		[2,1]
["SOO","OXX","OOO"]			["E 2","S 2","W 1"]		[0,1]
["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]		[0,0]
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String[] testcaseA = {"SOO","OOO","OOO"};
		String[] testcaseB = {"E 2","S 2","W 1"};
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.solution(testcaseA, testcaseB)));
	}
	
	public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2]; // 마지막 S의 위치 좌표
        int[][] parkMap = new int[park.length][park[0].length()]; // parkMap[높이][넓이]
        String[] move = new String[2];
        int h = 0;
        int w = 0;
        int intMove = 0;
        boolean check = true;
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                if(String.valueOf(park[i].charAt(j)).equals("S")){
                    parkMap[i][j] = 2;
                    h = i;
                    w = j;
                }
                else if(String.valueOf(park[i].charAt(j)).equals("O")){
                    parkMap[i][j] = 1;
                }
                else{
                    parkMap[i][j] = 0;
                }
            }
        }
        
        int parkMapSizeH = parkMap.length;
        int parkMapSizeW = parkMap[0].length;
        
        // System.out.println(parkMapSizeH + " " + parkMapSizeW);
        
        // park를 parkMap의 2차열 배열로 바꿨을 때, 배열을 출력하는 부분. 잘 나옴
        /*
        for(int i = 0; i < parkMap.length; i++){
            System.out.println(Arrays.toString(parkMap[i]));   
        }
        */
        
        for(int i = 0; i < routes.length; i++){
            move[0] = String.valueOf(routes[i].charAt(0));
            move[1] = String.valueOf(routes[i].charAt(2));
            
            intMove = Integer.parseInt(move[1]);
            
            if(move[0].equals("E")){ // 동쪽으로 이동, x축을 양의 방향으로 이동
                if(w + intMove < parkMapSizeW){
                    for(int j = w + 1; j < w + intMove + 1; j++){
                        if(parkMap[h][j] == 0){
                            // System.out.println("동쪽 이동 실행 실패");
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        w = w + intMove;
                        // System.out.println(move[0] + " " + move[1] + " 실행");
                    }
                }
            }
            else if(move[0].equals("W")){ // 서쪽으로 이동, x축을 음의 방향으로 이동
                if(w - intMove >= 0){
                    for(int j = w - 1; j > w - intMove - 1; j--){
                        if(parkMap[h][j] == 0){
                            // System.out.println("서쪽 이동 실행 실패");
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        w = w - intMove;
                        // System.out.println(move[0] + " " + move[1] + " 실행");
                    }
                }
            }
            else if(move[0].equals("S")){ // 남쪽으로 이동, y축을 양의 방향으로 이동
                if(h + intMove < parkMapSizeH){
                    for(int j = h + 1; j < h + intMove + 1; j++){
                        if(parkMap[j][w] == 0){
                            // System.out.println("남쪽 이동 실행 실패");
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        h = h + intMove;
                        // System.out.println(move[0] + " " + move[1] + " 실행");
                    }
                }
            }
            else if(move[0].equals("N")){ // 북쪽으로 이동, y축을 음의 방향으로 이동
                if(h - intMove >= 0){
                    for(int j = h - 1; j > h - intMove - 1; j--){
                        if(parkMap[j][w] == 0){
                            // System.out.println("북쪽 이동 실행 실패");
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        h = h - intMove;
                        // System.out.println(move[0] + " " + move[1] + " 실행");
                    }
                }
            }
            
            check = true;
        }
        
        // 마지막 h,w를 answer배열에 집어 넣는다
        answer[0] = h;
        answer[1] = w;
        
        return answer;
    }
}
