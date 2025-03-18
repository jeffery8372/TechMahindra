import 'package:flutter/material.dart';
import 'game_screen.dart';
import 'scorecard_screen.dart';
import 'how_to_play_dialog.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBodyBehindAppBar: true, // Extends background to app bar
      appBar: AppBar(
        title: const Text(''),
        centerTitle: true,
        backgroundColor: Colors.transparent,
        elevation: 0,
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {}, // Implement sharing logic
        child: const Icon(Icons.share),
      ),
      body: Stack(
        children: [
          Positioned.fill(
            child: Image.asset(
              'assets/background.jpg',
              fit: BoxFit.cover, // Ensures full-screen background
            ),
          ),
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const SizedBox(height: 10), // Moves text up by 4 cm
              const Text(
                'HAND CRICKET',
                style: TextStyle(
                  fontSize: 28,
                  fontWeight: FontWeight.bold,
                  fontFamily: 'BrushScript',
                  color: Colors.black, // Restores original color
                ),
              ),
              const Text(
                'ONLINE MULTIPLAYER',
                style: TextStyle(
                  fontSize: 16,
                  fontStyle: FontStyle.italic,
                  color: Colors.black, // Restores original color
                ),
              ),
              const SizedBox(height: 30),
              _buildMenuItem(
                context,
                Icons.sports_esports,
                'Single Player',
                const GameScreen(),
              ),
              _buildMenuItem(
                context,
                Icons.group,
                'Multi Player',
                null, // Multiplayer screen placeholder
              ),
              _buildMenuItem(
                context,
                Icons.leaderboard,
                'Score Board',
                const ScorecardScreen(),
              ),
              _buildMenuItem(
                context,
                Icons.menu_book,
                'How to Play',
                null,
                onTap: () => showHowToPlayDialog(context),
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildMenuItem(
    BuildContext context,
    IconData icon,
    String title,
    Widget? screen, {
    VoidCallback? onTap,
  }) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
      child: InkWell(
        onTap:
            onTap ??
            (screen != null
                ? () => Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => screen),
                )
                : null),
        child: Container(
          padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 20),
          decoration: BoxDecoration(
            color: Colors.white.withOpacity(0.9),
            borderRadius: BorderRadius.circular(10),
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Row(
                children: [
                  Icon(icon, size: 30),
                  const SizedBox(width: 10),
                  Text(title, style: const TextStyle(fontSize: 18)),
                ],
              ),
              const Icon(Icons.arrow_forward_ios),
            ],
          ),
        ),
      ),
    );
  }
}
