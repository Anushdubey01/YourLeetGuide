import java.util.ArrayList;
import java.util.List;
enum VertexState {
    NOT_VISITED,
    VISITING,
    VISITED
}
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        VertexState[] states = new VertexState[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (!hasCycle(graph, i, states)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    private boolean hasCycle(int[][] graph, int vertex, VertexState[] states) {
        if (states[vertex] == VertexState.VISITING) {
            return true;
        }
        if (states[vertex] == VertexState.VISITED) {
            return false;
        }
        states[vertex] = VertexState.VISITING;
        for (final int neighbor : graph[vertex]) {
            if (hasCycle(graph, neighbor, states)) {
                return true;
            }
        }
        states[vertex] = VertexState.VISITED;
        return false;
    }
}