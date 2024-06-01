package test2;

import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read scanner = new Read();

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i < m; i++) {
            int vi = scanner.nextInt();
            int vj = scanner.nextInt();
            if (graph[vi] == null) {
                graph[vi] = new ArrayList<>();
            }
            graph[vi].add(vj);
        }
        boolean[] visited = new boolean[n + 1];
        bfs(graph, 1, visited);
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                out.print(i + " ");
            }
        }
        out.println();
        out.close();

        
    }

    public static void bfs(List<Integer>[] graph, int vi, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vi);
        visited[vi] = true;
        while (!queue.isEmpty()) {
            vi = queue.poll();
            if (graph[vi] == null) {
                continue;
            }
            for (Integer vj : graph[vi]) {
                if (!visited[vj]) {
                    queue.offer(vj);
                    visited[vj] = true;
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