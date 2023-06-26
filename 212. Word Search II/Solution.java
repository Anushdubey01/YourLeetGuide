import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word;
}

class Solution {
    private TrieNode root;
    private Set<String> foundWords;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        foundWords = new HashSet<>();

        for (String word : words)
            insert(word);

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                dfs(board, i, j, root, visited);
            }
        }

        return new ArrayList<>(foundWords);
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.word = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j])
            return;

        char c = board[i][j];
        TrieNode child = node.children[c - 'a'];
        if (child == null)
            return;

        if (child.word != null) {
            foundWords.add(child.word);
            child.word = null; // Mark word as found once
        }

        visited[i][j] = true;

        dfs(board, i + 1, j, child, visited);
        dfs(board, i - 1, j, child, visited);
        dfs(board, i, j + 1, child, visited);
        dfs(board, i, j - 1, child, visited);

        visited[i][j] = false; // Reset visited flag for backtracking
    }
}
