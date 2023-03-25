// Question -> https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

import java.util.*;

class Solution {
    public static int count;

    public static class Pair {
        int to;
        boolean fake;

        Pair(int to, boolean fake) {
            this.to = to;
            this.fake = fake;
        }
    }

    public static void dfs(ArrayList<ArrayList<Pair>> adj, int node, int[] visited) {
        visited[node] = 1;
        for (Pair nbr : adj.get(node)) {
            if (visited[nbr.to] == -1) {
                visited[nbr.to] = 1;
                if (nbr.fake == false) {
                    count++;
                }
                dfs(adj, nbr.to, visited);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            adj.get(u).add(new Pair(v, false));
            adj.get(v).add(new Pair(u, true));
        }

        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        count = 0;
        dfs(adj, 0, visited);

        return count;
    }
}