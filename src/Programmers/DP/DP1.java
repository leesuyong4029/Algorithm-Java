package Programmers.DP;

public class DP1 {
    private static int solution(String str1, String str2) {
        // 1. 두 문자열의 길이를 저장
        int m = str1.length();
        int n = str2.length();

        // 2. LCS를 저장할 테이블 초기화
        int[][] dp = new int[m + 1][n + 1];

        // 3. 동적 프로그래밍을 통해 LCS 길이 계산
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 4. 현재 비교하는 문자가 같으면
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 5. 현재 비교하는 문자가 같지 않으면
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 6. LCS 길이 반환
        return dp[m][n];
    }
}
