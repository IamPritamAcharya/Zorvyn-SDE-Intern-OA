import java.util.*;

public class ques3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        solve(text, pattern);

        sc.close();
    }

    public static void solve(String text, String pattern) {

        int n = text.length();
        char[] t = text.toCharArray();

        boolean leadStar = pattern.charAt(0) == '*';

        List<String> segs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : pattern.toCharArray()) {
            if (ch == '*') {
                if (sb.length() > 0) {
                    segs.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(ch);
            }
        }
        if (sb.length() > 0)
            segs.add(sb.toString());

        if (segs.isEmpty()) {
            System.out.println(n);
            for (int i = 0; i < n; i++)
                System.out.print(i + " ");
            System.out.println();
            return;
        }

        boolean[] nextOk = new boolean[n + 1];
        Arrays.fill(nextOk, true);

        for (int si = segs.size() - 1; si >= 0; si--) {

            char[] seg = segs.get(si).toCharArray();
            int len = seg.length;

            int[] nextPos = new int[n + 1];
            Arrays.fill(nextPos, -1);

            for (int i = 0; i + len <= n; i++) {
                boolean ok = true;

                for (int j = 0; j < len; j++) {
                    if (seg[j] != '?' && seg[j] != t[i + j]) {
                        ok = false;
                        break;
                    }
                }

                if (ok)
                    nextPos[i] = i;
            }

            int last = -1;
            for (int i = n; i >= 0; i--) {
                if (i < n && nextPos[i] != -1)
                    last = i;
                nextPos[i] = last;
            }

            boolean[] curOk = new boolean[n + 1];

            boolean exact = (si == 0 && !leadStar);

            for (int i = 0; i <= n; i++) {

                if (exact) {
                    if (i + len <= n &&
                            nextPos[i] == i &&
                            nextOk[i + len]) {
                        curOk[i] = true;
                    }
                } else {
                    int pos = nextPos[i];

                    if (pos != -1 &&
                            pos + len <= n &&
                            nextOk[pos + len]) {
                        curOk[i] = true;
                    }
                }
            }

            nextOk = curOk;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nextOk[i])
                res.add(i);
        }

        System.out.println(res.size());

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1)
                System.out.print(" ");
        }
        System.out.println();
    }

}
