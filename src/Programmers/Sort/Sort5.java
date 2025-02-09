package Programmers.Sort;

import java.util.Arrays;

public class Sort5 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            // 1. i번째 부터 J번째까지 자르기
            int[] slicedArr = Arrays.copyOfRange(array, i - 1, j);
            // 2. 자른 배열을 정렬하기
            Arrays.sort(slicedArr);
            // 3. k번쨰 원소 구하기
            answer[c] = slicedArr[k - 1];
        }
        return answer;
    }
}
