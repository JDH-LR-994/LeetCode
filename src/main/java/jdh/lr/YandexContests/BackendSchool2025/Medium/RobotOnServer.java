package jdh.lr.YandexContests.BackendSchool2025.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RobotOnServer {

    public static void main(String[] args) {
        Map<String, Integer> outgoing = new HashMap<>();
        Map<String, Integer> incoming = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
                String[] Parts = br.readLine().split(" ");

                String fromAddr = Parts[0] + " " + Parts[1];
                String toAddr = Parts[2] + " " + Parts[3];

                outgoing.put(fromAddr, outgoing.getOrDefault(fromAddr, 0) + 1);
                incoming.put(toAddr, incoming.getOrDefault(toAddr, 0) + 1);
            }

            String start = null;
            String end = null;

            for (String addr : outgoing.keySet()) {
                if (outgoing.get(addr) > incoming.getOrDefault(addr, 0)) {
                    if (start != null) {
                        System.out.println(-1);
                        return;
                    }
                    start = addr;
                }
            }

            for (String addr : incoming.keySet()) {
                if (incoming.get(addr) > outgoing.getOrDefault(addr, 0)) {
                    if (end != null) {
                        System.out.println(-1);
                        return;
                    }
                    end = addr;
                }
            }

            if (start != null && end != null) {
                System.out.println(start + " " + end);
            } else {
                System.out.println(-1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}