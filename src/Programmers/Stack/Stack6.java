// https://school.programmers.co.kr/learn/courses/30/lessons/64061
package Programmers.Stack;

import java.util.Stack;

public class Stack6 {
    public int solution(int[][] board, int[] moves) {
        // 각 열에 대한 스택을 생성
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // board를 역순으로 탐색하며, 각 열의 인형을 lanes에 추가
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // 인형을 담을 bucket을 생성
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        // moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가
        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) {
                int doll = lanes[move - 1].pop();
                // 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                }
                else {
                    // 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                    bucket.push(doll);
                }
            }
        }
        return answer;
    }
}

