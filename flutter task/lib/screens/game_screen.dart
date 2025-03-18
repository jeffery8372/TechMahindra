import 'dart:math';
import 'package:flutter/material.dart';
import 'game_logic.dart';
import '../services/firebase_service.dart';

enum GamePhase {
  chooseOddEven,
  chooseNumber,
  tossResult,
  chooseBatBowl,
  playing,
  result,
}

class GameScreen extends StatefulWidget {
  const GameScreen({super.key});

  @override
  _GameScreenState createState() => _GameScreenState();
}

class _GameScreenState extends State<GameScreen> {
  FirebaseService firebaseService = FirebaseService();
  int matchNumber = 1; // Track match number
  GamePhase _phase = GamePhase.chooseOddEven;
  bool? playerChoseOdd;
  int? playerTossNumber;
  int cpuTossNumber = 0;
  bool tossWonByPlayer = false;
  bool playerBatting = true;
  final GameLogic _gameLogic = GameLogic();
  String gameMessage = "Make your move!";

  void _selectOddEven(bool choseOdd) {
    setState(() {
      playerChoseOdd = choseOdd;
      _phase = GamePhase.chooseNumber;
    });
  }

  void _chooseTossNumber(int number) {
    setState(() {
      cpuTossNumber = Random().nextInt(5) + 1;
      playerTossNumber = number;
      tossWonByPlayer = ((number + cpuTossNumber) % 2 == 1) == playerChoseOdd;
      _phase = GamePhase.tossResult;
    });

    Future.delayed(
      const Duration(seconds: 2),
      () => setState(
        () =>
            _phase =
                tossWonByPlayer ? GamePhase.chooseBatBowl : GamePhase.playing,
      ),
    );
  }

  void _chooseBatBowl(bool batFirst) {
    setState(() {
      playerBatting = batFirst;
      _gameLogic.playerBatting = batFirst;
      _phase = GamePhase.playing;
    });
  }

  void _playTurn(int playerChoice) {
    setState(() {
      gameMessage = _gameLogic.playTurn(playerChoice);
      if (_gameLogic.isGameOver) {
        if (_gameLogic.playerBatting && _gameLogic.playerScore > 0) {
          _gameLogic.switchInnings();
          gameMessage =
              "You scored ${_gameLogic.playerScore} runs. CPU needs to chase ${_gameLogic.target} runs.";
          _gameLogic.isGameOver = false;
        } else if (!_gameLogic.playerBatting && _gameLogic.cpuScore > 0) {
          _phase = GamePhase.result;

          // Save match result to Firebase
          String winner =
              (_gameLogic.playerScore > _gameLogic.cpuScore) ? "Player" : "CPU";
          firebaseService.saveMatchResult(
            matchNumber,
            "Player",
            _gameLogic.playerScore,
            "CPU",
            _gameLogic.cpuScore,
            winner,
          );

          // Increment match number for the next game
          matchNumber++;
        }
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.brown[800],
        title: const Text(
          'Hand Cricket',
          style: TextStyle(
            fontSize: 24,
            fontWeight: FontWeight.bold,
            color: Colors.white, // Changed text color to white
          ),
        ),
        centerTitle: true,
      ),
      body: Stack(
        children: [_buildBackground(), Center(child: _buildGameUI())],
      ),
    );
  }

  Widget _buildGameUI() {
    switch (_phase) {
      case GamePhase.chooseOddEven:
        return Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.asset(
              'assets/robot.jpg', // Ensure this image exists in assets
              width: 200,
              height: 200,
            ),
            const SizedBox(height: 20), // Adds spacing between image and text
            _buildChoiceUI(
              "Choose Odd or Even:",
              ["Odd", "Even"],
              [() => _selectOddEven(true), () => _selectOddEven(false)],
            ),
          ],
        );
      case GamePhase.chooseNumber:
        return Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.asset(
              'assets/robot2.jpg', // Ensure this image exists in assets
              width: 200,
              height: 200,
            ),
            const SizedBox(height: 20), // Adds spacing between image and text
            _buildChoiceUI(
              "Pick a number (1-5):",
              List.generate(5, (i) => "${i + 1}"),
              List.generate(5, (i) => () => _chooseTossNumber(i + 1)),
            ),
          ],
        );
      case GamePhase.tossResult:
        return _buildTossResultUI();
      case GamePhase.chooseBatBowl:
        return Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            _buildChoiceUI(
              "You won the toss! Choose:",
              ["Bat First", "Bowl First"],
              [() => _chooseBatBowl(true), () => _chooseBatBowl(false)],
            ),
            const SizedBox(
              height: 20,
            ), // Adds spacing between buttons and images
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Column(
                  children: [
                    Image.asset(
                      'assets/bat.jpg', // Ensure this image exists in assets
                      width: 150,
                      height: 150,
                    ),
                  ],
                ),
                const SizedBox(width: 40), // Space between images
                Column(
                  children: [
                    Image.asset(
                      'assets/bowl.jpg', // Ensure this image exists in assets
                      width: 150,
                      height: 150,
                    ),
                  ],
                ),
              ],
            ),
          ],
        );
      case GamePhase.playing:
        return _buildPlayingUI();
      case GamePhase.result:
        return Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              _gameLogic.getGameResult(),
              style: const TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
                color: Colors.redAccent,
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(
                  context,
                  '/scorecard_screen',
                ); // Navigate to Scoreboard
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.brown[700],
                padding: const EdgeInsets.symmetric(
                  horizontal: 20,
                  vertical: 10,
                ),
              ),
              child: const Text(
                "View Scoreboard",
                style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                ),
              ),
            ),
          ],
        );
    }
  }

  Widget _buildPlayingUI() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        // Batting Status Card
        Container(
          width: double.infinity,
          padding: const EdgeInsets.all(12),
          decoration: const BoxDecoration(
            gradient: LinearGradient(
              colors: [Colors.brown, Colors.orangeAccent], // Gradient Effect
              begin: Alignment.centerLeft,
              end: Alignment.centerRight,
            ),
            borderRadius: BorderRadius.only(
              bottomLeft: Radius.circular(20),
              bottomRight: Radius.circular(20),
            ),
          ),
          child: Center(
            child: Text(
              _gameLogic.playerBatting
                  ? "You are Batting 🏏"
                  : "CPU is Batting 🏏",
              style: const TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
                color: Colors.white, // Better Contrast
              ),
            ),
          ),
        ),

        const SizedBox(height: 10),

        // Bowling Status
        Text(
          _gameLogic.playerBatting ? "CPU is Bowling ⚾" : "You are Bowling ⚾",
          style: const TextStyle(
            fontSize: 20,
            fontWeight: FontWeight.bold,
            color: Colors.brown,
          ),
        ),

        const SizedBox(height: 20),

        // Score Display
        Card(
          elevation: 4,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(12),
          ),
          child: Padding(
            padding: const EdgeInsets.all(12.0),
            child: Text(
              _gameLogic.playerBatting
                  ? "Runs(😎): ${_gameLogic.playerScore}"
                  : "Runs(🤖): ${_gameLogic.cpuScore} (Target: ${_gameLogic.target})",
              style: const TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
                color: Colors.deepOrange,
              ),
            ),
          ),
        ),

        const SizedBox(height: 20),

        // Game Message
        Text(
          gameMessage,
          style: const TextStyle(fontSize: 18, color: Colors.deepOrange),
        ),

        const SizedBox(height: 20),

        // Number Selection Buttons
        Wrap(
          spacing: 10,
          children: List.generate(
            5,
            (i) => ElevatedButton(
              onPressed: () => _playTurn(i + 1),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.brown[700],
                padding: const EdgeInsets.symmetric(
                  horizontal: 20,
                  vertical: 10,
                ),
              ),
              child: Text(
                "${i + 1}",
                style: const TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                ),
              ),
            ),
          ),
        ),
      ],
    );
  }

  Widget _buildChoiceUI(
    String title,
    List<String> options,
    List<VoidCallback> actions,
  ) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          title,
          style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
        ),
        const SizedBox(height: 20),
        Wrap(
          spacing: 10,
          children: List.generate(
            options.length,
            (i) => ElevatedButton(
              onPressed: actions[i],
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.brown[600],
              ),
              child: Text(
                options[i],
                style: const TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                  color: Colors.white, // Changed text color to white
                ),
              ),
            ),
          ),
        ),
      ],
    );
  }

  Widget _buildTossResultUI() {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          "You picked: $playerTossNumber",
          style: const TextStyle(fontSize: 20),
        ),
        Text(
          "CPU picked: $cpuTossNumber",
          style: const TextStyle(fontSize: 20),
        ),
        Text(
          "Sum: ${playerTossNumber! + cpuTossNumber}",
          style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
        ),
        Text(
          tossWonByPlayer ? "You won the toss!" : "CPU won the toss!",
          style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
        ),
      ],
    );
  }

  Widget _buildBackground() {
    return SizedBox.expand(
      child: Image.asset('assets/background2.jpg', fit: BoxFit.cover),
    );
  }
}
