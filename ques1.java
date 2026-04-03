import java.util.*;

public class ques1 {

    static class Pair {
        int v, w;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int shortestPath(int n, List<List<Pair>> graph, List<List<Integer>> bridges, int k) {
        int[][] dist = new int[n + 1][k + 1];
        int INF = (int) 1e9;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[1][0] = 0;
        pq.offer(new int[] { 0, 1, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];
            int used = cur[2];

            if (d > dist[u][used])
                continue;

            for (Pair p : graph.get(u)) {
                int v = p.v;
                int w = p.w;

                if (dist[v][used] > d + w) {
                    dist[v][used] = d + w;
                    pq.offer(new int[] { dist[v][used], v, used });
                }
            }

            if (used < k) {
                for (int v : bridges.get(u)) {
                    if (dist[v][used + 1] > d) {
                        dist[v][used + 1] = d;
                        pq.offer(new int[] { d, v, used + 1 });
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 0; i <= k; i++) {
            ans = Math.min(ans, dist[n][i]);
        }

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            bridges.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        for (int i = 0; i < k; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            bridges.get(u).add(v);
            bridges.get(v).add(u);
        }

        System.out.println(shortestPath(n, graph, bridges, k));
    }
}