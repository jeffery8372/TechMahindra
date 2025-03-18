import 'dart:math';

class GameLogic {
  int playerScore = 0;
  int cpuScore = 0;
  bool playerBatting = true; // Player bats first by default
  bool isGameOver = false;
  int target = 0; // Target for second innings

  final Random _random = Random();

  int getCPUChoice() {
    return _random.nextInt(5) + 1; // CPU chooses a number between 1-5
  }

  String playTurn(int playerChoice) {
    int cpuChoice = getCPUChoice();

    if (playerBatting) {
      // First Innings: Player is batting
      if (playerChoice == cpuChoice) {
        isGameOver = true;
        return "Out! You scored $playerScore runs. Now CPU needs to chase $playerScore runs.";
      } else {
        playerScore += playerChoice;
        return "You played $playerChoice, CPU played $cpuChoice. Your score: $playerScore";
      }
    } else {
      // Second Innings: CPU is batting, player is guessing
      if (playerChoice == cpuChoice) {
        isGameOver = true;
        return "Out! CPU scored $cpuScore runs. You Win!";
      } else {
        cpuScore += cpuChoice;
        if (cpuScore > target) {
          isGameOver = true;
          return "CPU played $cpuChoice. CPU scored $cpuScore runs. CPU Wins!";
        }
        return "You guessed $playerChoice, CPU played $cpuChoice. CPU score: $cpuScore";
      }
    }
  }

  void switchInnings() {
    if (playerBatting) {
      // End of first innings, switch to second innings
      playerBatting = false;
      target = playerScore; // Set target for CPU
    } else {
      // End of second innings, game over
      isGameOver = true;
    }
  }

  String getGameResult() {
    if (cpuScore > playerScore) return "CPU Wins!";
    if (cpuScore < playerScore) return "You Win!";
    return "It's a Tie!";
  }
}
