package jdh.lr.YandexContests.BackendSchool2025.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SatelliteImagery{
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int W = Integer.parseInt(firstLine[0]);
        int H = Integer.parseInt(firstLine[1]);
        int N = Integer.parseInt(br.readLine());

        Set<Point> prevPoints = new HashSet<>();
        boolean possible = true;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            Set<Point> currentPoints = new HashSet<>();
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    currentPoints.add(new Point(x, y));
                }
            }

            if (i == 0) {
                prevPoints = currentPoints;
                continue;
            }

            Set<Point> reachable = new HashSet<>();
            for (Point p : currentPoints) {
                for (Point prev : prevPoints) {
                    if ((Math.abs(p.x - prev.x) == 1 && p.y == prev.y) ||
                            (Math.abs(p.y - prev.y) == 1 && p.x == prev.x)) {
                        reachable.add(p);
                        break;
                    }
                }
            }
            for (Point p : reachable) {
                System.out.println(p.x + " " + p.y);
            }

            if (reachable.isEmpty()) {
                possible = false;
                break;
            }
            prevPoints = reachable;
        }

        System.out.println(possible ? "YES" : "NO");
    }
}