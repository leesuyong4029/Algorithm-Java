package Baekjoon.Simulation.boj_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visit;

    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(Min);
    }

    // idx는 인덱스, count는 조합 개수(=재귀 깊이)
    static void combination(int idx, int count) {
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    start += map[i][j];
                    start += map[j][i];
                }
                else if (visit[i] == false && visit[j] == false) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 (절댓값)
        int val = Math.abs(start - link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        Min = Math.min(val, Min);
    }
}
