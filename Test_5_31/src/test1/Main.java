package test1;


import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        List<Integer>[] graph = new List[n + 1];
        int[] father = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            father[i] = scanner.nextInt();
        }
        for (int i = 2; i <= n; i++) {
            if (graph[father[i]] == null) {
                graph[father[i]] = new ArrayList<>();
            }
            graph[father[i]].add(i);
        }
        dfs(graph, 1);
        out.println();
        bfs(graph, 1);
        out.println();
        out.close();
    }

    public static void dfs(List<Integer>[] graph, int root) {
        out.print(root + " ");
        //out.flush();
        if (graph[root] == null) {
            return;
        }
        for (Integer child : graph[root]) {
            dfs(graph, child);
        }
    }

    public static void bfs(List<Integer>[] graph, int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        //单源
        while (!queue.isEmpty()) {
            root = queue.poll();
            out.print(root + " ");
            if (graph[root] != null) {
                for (Integer child : graph[root]) {
                    queue.offer(child);
                }
            }
        }
    }
}

class Read {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String next() throws IOException {
        while (!st.hasMoreTokens()) {//没有分割就继续分割
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException {
        return bf.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}