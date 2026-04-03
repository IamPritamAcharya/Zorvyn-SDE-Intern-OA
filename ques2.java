import java.util.*;

public class ques2 {

    static int n;
    static int[] value;
    static List<List<Integer>> adj;
    static long[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            value[i] = sc.nextInt();
        }

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int manager = sc.nextInt();
            int employee = sc.nextInt();

            adj.get(manager).add(employee);
            adj.get(employee).add(manager);
        }

        dp = new long[n + 1][2];

        dfs(1, 0);

        long ans = Math.max(dp[1][0], dp[1][1]);
        System.out.println(Math.max(0, ans));
    }

    static void dfs(int node, int parent) {

        dp[node][1] = value[node]; 
        dp[node][0] = 0; 

        for (int child : adj.get(node)) {
            if (child == parent)
                continue;

            dfs(child, node);

            dp[node][1] += dp[child][0];
            dp[node][0] += Math.max(dp[child][0], dp[child][1]);
        }
    }

}
