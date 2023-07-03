class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        # Check if the lengths of A and B are equal
        if len(A) != len(B):
            return False

        # Check if A and B are identical and have duplicate characters
        if A == B and len(set(A)) < len(A):
            return True

        # Find the differing characters in A and B
        diff = [(a, b) for a, b in zip(A, B) if a != b]

        # Check if there are exactly two differences and they can be swapped to make A and B equal
        return len(diff) == 2 and diff[0] == diff[1][::-1]


# Testing the function
solution = Solution()
A = "abc"
B = "abd"
print(solution.buddyStrings(A, B))
