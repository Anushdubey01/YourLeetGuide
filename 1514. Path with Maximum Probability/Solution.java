class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
      List<Pair<Integer, Double>>[] graph = new List[n]; // {a: [(b, prob_ab)]}
      Queue<Pair<Double, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
      maxHeap.offer(new Pair<>(1.0, start));
      boolean[] visited = new boolean[n];
      for (int i = 0; i < n; ++i)
        graph[i] = new ArrayList<>();
      for (int i = 0; i < edges.length; ++i) {
        final int u = edges[i][0];
        final int v = edges[i][1];
        final double prob = succProb[i];
        graph[u].add(new Pair<>(v, prob));
        graph[v].add(new Pair<>(u, prob));
      }
      while (!maxHeap.isEmpty()) {
        final double currProb = maxHeap.peek().getKey();
        final int currNode = maxHeap.poll().getValue();
        if (currNode == end)
          return currProb;
        if (visited[currNode])
          continue;
        visited[currNode] = true;
        for (Pair<Integer, Double> neighbor : graph[currNode]) {
          final int nextNode = neighbor.getKey();
          final double edgeProb = neighbor.getValue();
          if (visited[nextNode])
            continue;
          maxHeap.add(new Pair<>(currProb * edgeProb, nextNode));
        }
      }
      return 0;
    }
  }