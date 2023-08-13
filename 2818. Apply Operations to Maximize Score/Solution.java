import java.util.*;

class Solution {
    static int MOD = (int)1e9 + 7;

    int calculateScore(int number) {
        int count = 0;
        if (number % 2 == 0) {
            count++;
            while (number % 2 == 0) {
                number /= 2;
            }
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                count++;
                while (number % i == 0) {
                    number /= i;
                }
                if (number == 1) {
                    return count;
                }
            }
        }

        if (number > 2) {
            count++;
        }

        return count;
    }

    long calculatePower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        long result = 1;
        if ((exponent & 1) == 1) {
            result = base;
        }
        long temp = calculatePower(base, exponent >> 1);
        temp = (temp * temp) % MOD;
        result = (result * temp) % MOD;
        return result;
    }

    public int maximumScore(List<Integer> nums, int k) {
        Queue<List<Integer>> priorityQueue = new PriorityQueue<>(
            (a, b) -> (b.get(0) - a.get(0))
        );
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.size();
        for (int i = 0; i < length; i++) {
            int num = nums.get(i);
            priorityQueue.offer(List.of(num, i, calculateScore(num)));
            list.add(List.of(num, calculateScore(num)));
        }

        long result = 1;
        while (!priorityQueue.isEmpty() && k > 0) {
            List<Integer> currentList = priorityQueue.poll();
            int currentValue = currentList.get(0);
            int currentIndex = currentList.get(1);
            int currentScore = currentList.get(2);
            int right = 1;
            while (currentIndex + right < length && list.get(currentIndex + right).get(1) <= currentScore && right < k) {
                right++;
            }
            int left = 1;
            while (currentIndex - left >= 0 && list.get(currentIndex - left).get(1) < currentScore && left * right < k) {
                left++;
            }
            int operations = right * left;
            int realOperations = Math.min(k, operations);
            k -= realOperations;
            result = result * calculatePower(currentValue, realOperations) % MOD;
        }
        return (int) (result % MOD);
    }
}