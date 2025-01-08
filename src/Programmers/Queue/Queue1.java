package Programmers.Queue;

import java.util.ArrayDeque;

public class Queue1 {
    private int Solution(int N, int K) {
        // 1. 1부터 N까지의 번호를 deque에 추가
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        // 2. deque에 하나의 요소가 남을 때까지 반복
        while (deque.size() > 1) {
            // 3. K번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst(); // 4. K번째 요소 제거
        }
        return deque.pollFirst();
    }
}
