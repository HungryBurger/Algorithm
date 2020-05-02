package BaekJoon;

import java.util.*;

public class 물통 {
    static int visit[][] = new int[201][201];
    static int ans[] = new int[201];
    static int wat_A, wat_B, wat_C;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        wat_A = sc.nextInt();
        wat_B = sc.nextInt();
        wat_C = sc.nextInt();

        dfs(0, 0, wat_C);

        for (int i = 0; i < 201; i++) {
            if (ans[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(int A, int B, int C) {
        if (visit[A][B] == 1)
            return;
        if (A == 0)
            ans[C] = 1;
        visit[A][B] = 1;
        // A에서 B로 줄때
        if (A + B > wat_B)
            dfs((A + B) - wat_B, wat_B, C);
        else
            dfs(0, A + B, C);
        // B에서 A로 줄때
        if (B + A > wat_A)
            dfs(wat_A, (B + A) - wat_A, C);
        else
            dfs(B + A, 0, C);
        // C에서 A로 줄때
        if (C + A > wat_A)
            dfs(wat_A, B, (C + A) - wat_A);
        else
            dfs(C + A, B, 0);
        // C에서 B로 줄때
        if (C + B > wat_B)
            dfs(A, wat_B, (C + B) - wat_B);
        else
            dfs(A, C + B, 0);
        // B에서 C로 A에서 C로
        // A+B = C
        dfs(A, 0, B + C);
        dfs(0, B, A + C);

    }
}
