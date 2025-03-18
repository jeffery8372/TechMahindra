import 'package:flutter/material.dart';

void showHowToPlayDialog(BuildContext context) {
  showDialog(
    context: context,
    builder: (BuildContext context) {
      return AlertDialog(
        title: Text(
          "How to Play",
          style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20),
        ),
        content: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              _buildRule(
                "1. Toss:",
                "Choose odd or even. The sum of your and CPU's numbers decides the toss winner.",
              ),
              _buildRule(
                "2. Batting:",
                "Pick a number (1-5). If the CPU picks the same number, you're out!",
              ),
              _buildRule(
                "3. Scoring:",
                "If the numbers don’t match, your chosen number is added to your score.",
              ),
              _buildRule(
                "4. Bowling:",
                "Guess the CPU’s number (1-5). If your guess matches, the CPU is out.",
              ),
              _buildRule(
                "5. Winning:",
                "The second player must chase the first player’s target to win.",
              ),
            ],
          ),
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: Text(
              "OK",
              style: TextStyle(
                fontSize: 16,
                fontWeight: FontWeight.bold,
                color: Theme.of(context).primaryColor,
              ),
            ),
          ),
        ],
      );
    },
  );
}

Widget _buildRule(String title, String description) {
  return Padding(
    padding: const EdgeInsets.only(bottom: 12.0),
    child: RichText(
      textAlign: TextAlign.justify,
      text: TextSpan(
        style: TextStyle(fontSize: 16, color: Colors.black),
        children: [
          TextSpan(text: title, style: TextStyle(fontWeight: FontWeight.bold)),
          TextSpan(text: " $description"),
        ],
      ),
    ),
  );
}
