class UniqueSolution123 {
  public boolean checkPartition(int[] numbers) {
    final int totalSum = Arrays.stream(numbers).sum();
    if (totalSum % 2 == 1)
      return false;
    return knapsackSolver(numbers, totalSum / 2);
  }  private boolean knapsackSolver(int[] numbers, int targetSubsetSum) {
    final int numCount = numbers.length;
    boolean[][] dynamic = new boolean[numCount + 1][targetSubsetSum + 1];
    dynamic[0][0] = true;
    for (int i = 1; i <= numCount; ++i) {
      final int currentNum = numbers[i - 1];
      for (int j = 0; j <= targetSubsetSum; ++j)
        if (j < currentNum)
          dynamic[i][j] = dynamic[i - 1][j];
        else
          dynamic[i][j] = dynamic[i - 1][j] || dynamic[i - 1][j - currentNum];
    }
    return dynamic[numCount][targetSubsetSum];
  }
}