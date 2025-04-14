package jdh.lr.YandexContests.BackendSchool2025.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SatelliteImagery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int W = Integer.parseInt(firstLine[0]);
        int H = Integer.parseInt(firstLine[1]);
        int N = Integer.parseInt(br.readLine());

        int minX = 0, maxX = 0, minY = 0, maxY = 0;
        boolean first = true;
        boolean possible = true;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            if (first) {
                minX = x1;
                maxX = x2;
                minY = y1;
                maxY = y2;
                first = false;
                continue;
            }

            int newMinX = Math.max(x1, minX - 1);
            int newMaxX = Math.min(x2, maxX + 1);
            int newMinY = Math.max(y1, minY);
            int newMaxY = Math.min(y2, maxY);

            boolean verticalPossible = (newMinX <= newMaxX) && (newMinY <= newMaxY);

            newMinX = Math.max(x1, minX);
            newMaxX = Math.min(x2, maxX);
            newMinY = Math.max(y1, minY - 1);
            newMaxY = Math.min(y2, maxY + 1);

            boolean horizontalPossible = (newMinX <= newMaxX) && (newMinY <= newMaxY);

            if (!verticalPossible && !horizontalPossible) {
                possible = false;
                break;
            }

            minX = Math.max(x1, minX - 1);
            maxX = Math.min(x2, maxX + 1);
            minY = Math.max(y1, minY - 1);
            maxY = Math.min(y2, maxY + 1);
        }

        System.out.println(possible ? "YES" : "NO");
    }
}