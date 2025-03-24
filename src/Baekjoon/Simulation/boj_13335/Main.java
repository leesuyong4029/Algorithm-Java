package Baekjoon.Simulation.boj_13335;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        int time = 0;
        int weightOnBridge = 0;
        while (!bridge.isEmpty()) {
            time++;
            weightOnBridge -= bridge.poll();

            // 트럭이 비어있으면 건너뜀
            if (trucks.isEmpty()) {
                continue;
            }

            if (trucks.peek() + weightOnBridge <= L) {
                int cur = trucks.poll();
                weightOnBridge += cur;
                bridge.add(cur);
            } else {
                bridge.add(0);
            }
        }
        System.out.println(time);
    }
}
