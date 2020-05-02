package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class my_pair {
    int x;
    int y;
}

public class 탈출_3055 {
    static int R, C;
    static char[][] map;
    static int[][] answer;
    static int[][] water_day;
    static my_pair Start = new my_pair();
    static my_pair Destination = new my_pair();
    static Queue<my_pair> water = new LinkedList<my_pair>();
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] temp = str.split(" ");

        R = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);

        map = new char[R][C];
        answer = new int[R][C];
        water_day = new int[R][C];

        for (int i = 0; i < R; i++) {
            String data = bf.readLine();
            for (int k = 0; k < C; k++) {
                map[i][k] = data.charAt(k);
                if (data.charAt(k) == 'S') {
                    Start.x = k;
                    Start.y = i;
                }
                if (data.charAt(k) == 'D') {
                    Destination.x = k;
                    Destination.y = i;
                }
                if (data.charAt(k) == '*') {
                    my_pair water_coordinate = new my_pair();
                    water_coordinate.x = k;
                    water_coordinate.y = i;
                    water.add(water_coordinate);
                }
            }
        }
        //먼저 물의 값을 BFS를 이용해서 구함
        Flood();
        BFS();
        if (answer[Destination.y][Destination.x] != 0) {
            System.out.println(answer[Destination.y][Destination.x]);
        } else
            System.out.println("KAKTUS");

    }

    // 물 먼저 확인
    static void Flood() {
        while (!water.isEmpty()) {
            my_pair temp = water.poll();
            int x = temp.x;
            int y = temp.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                    if (water_day[ny][nx] == 0 && map[ny][nx] == '.') {
                        water_day[ny][nx] = water_day[y][x] + 1;
                        my_pair tp = new my_pair();
                        tp.x = nx;
                        tp.y = ny;
                        water.add(tp);
                    }
                }
            }

        }
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{Start.x, Start.y});
        while (!q.isEmpty()) {
            int[] location = q.poll();
            int x = location[0];
            int y = location[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                    if (answer[ny][nx] == 0 && (map[ny][nx] == '.' || map[ny][nx] == 'D')) {
                        if (water_day[ny][nx] == 0) {
                            answer[ny][nx] = answer[y][x] + 1;
                            q.add(new int[]{nx, ny});
                        } else {
                            //총 움직인 크기 = 몇분이 지났나 = 물이 지나간 경로 확인
                            if (water_day[ny][nx] > answer[y][x] + 1) {
                                answer[ny][nx] = answer[y][x] + 1;
                                q.add(new int[]{nx, ny});

                            }
                        }
                    }
                }
            }
        }
    }
}
