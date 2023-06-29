class Solution:
    def shortestPathAllKeys(self, grid):
        m = len(grid)
        n = len(grid[0])
        allKeys = 0
        startRow = -1
        startCol = -1
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(m):
            for j in range(n):
                c = grid[i][j]
                if c == '@':
                    startRow = i
                    startCol = j
                elif c >= 'a' and c <= 'f':
                    allKeys |= (1 << (ord(c) - ord('a')))
        queue = deque()
        visited = [[[False] * 64 for _ in range(n)] for _ in range(m)]
        queue.append([startRow, startCol, 0])
        visited[startRow][startCol][0] = True
        steps = 0
        while queue:
            size = len(queue)
            while size > 0:
                curr = queue.popleft()
                row = curr[0]
                col = curr[1]
                keys = curr[2]
                if keys == allKeys:
                    return steps
                for dir in directions:
                    newRow = row + dir[0]
                    newCol = col + dir[1]
                    if newRow >= 0 and newRow < m and newCol >= 0 and newCol < n:
                        cell = grid[newRow][newCol]
                        if cell == '#':
                            continue
                        newKeys = keys
                        if cell >= 'a' and cell <= 'f':
                            newKeys |= (1 << (ord(cell) - ord('a')))
                        if cell >= 'A' and cell <= 'F' and (keys & (1 << (ord(cell) - ord('A')))) == 0:
                            continue
                        if not visited[newRow][newCol][newKeys]:
                            queue.append([newRow, newCol, newKeys])
                            visited[newRow][newCol][newKeys] = True
                size -= 1
            steps += 1
        return -1