package Programmers.DP;

public class DP3 {
    private static int solution(int[][] arr) {
        // 1. 입력 배열의 열의 개수를 저장
        int n = arr[0].length;
        // 2. dp 배열을 초기화. 4행 n열의 2차원 배열
        int[][] dp = new int[4][n];
        // 각 열에서 선택 가능한 4가지 조약돌 배치 패턴에 대해 첫 번째 열의 가중치를 초기화
        // 0: 상단, 1: 중앙, 2: 하단, 3: 상단과 하단
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];
        dp[3][0] = arr[0][0] + arr[2][0];

        // 4. 두 번째 열부터 마지막 열까지 각 열에서 선택 가능한 4가지 조약돌 배치 패턴에 대해 최대 가중치를 계산
        for (int i = 1; i < n; i++) {
            // 패턴 0이 선택된 경우, 이전은 패턴 {1, 2} 가능
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);
            // 패턴 1이 선택된 경우, 이전은 패턴 {0, 2, 3} 가능
            dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], Math.max(dp[2][i - 1], dp[3][i -1 ]));
            // 패턴 2이 선택된 경우, 이전은 패턴 {0, 1} 가능
            dp[2][i] = arr[2][i] + Math.max(dp[0][i - 1], dp[1][i - 1]);
            // 패턴 3이 선택된 경우, 이전은 패턴 {1} 가능
            dp[3][i] = arr[0][i] + arr[2][i] + dp[1][i - 1];
        }
        // 5. 마지막 열에서 선택 가능한 4가지 조약돌 배치 패턴 중 최대 가중치를 반환
        return Math.max(Math.max(dp[0][n - 1], dp[1][n - 1]), Math.max(dp[2][n - 1], dp[3][n - 1]));
    }
}
