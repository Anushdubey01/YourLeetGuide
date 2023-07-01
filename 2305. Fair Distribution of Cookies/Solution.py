class Solution:
    def distributeCookies(self, cookies, k):
        self.answer = float('inf')
        self.counter = [0] * k
        self.findMaximum(cookies, 0, k)
        return self.answer
    
    def findMaximum(self, cookies, index, k):
        if index == len(cookies):
            max_val = 0
            for i in range(k):
                max_val = max(max_val, self.counter[i])
            self.answer = min(self.answer, max_val)
            return
        
        for i in range(k):
            self.counter[i] += cookies[index]
            self.findMaximum(cookies, index + 1, k)
            self.counter[i] -= cookies[index]
            if self.counter[i] == 0:
                break
