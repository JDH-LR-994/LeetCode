package jdh.lr.YandexContests.BackendSchool2025.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurdIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }

        FenwickTree ft = new FenwickTree(200);
        long result = 0;

        for (int i = 0; i < n; i++) {
            int price = p[i];
            if (price > 1) {
                result += ft.query(price - 1);
            }
            ft.update(price, 1);
        }

        System.out.println(result);
    }

    static class FenwickTree {
        int[] tree;
        int size;

        public FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 2]; // Индексация с 1
        }

        public void update(int index, int delta) {
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public long query(int index) {
            long sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}

