import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../services/firebase_service.dart';

class ScorecardScreen extends StatelessWidget {
  const ScorecardScreen({super.key});

  @override
  Widget build(BuildContext context) {
    FirebaseService firebaseService = FirebaseService();

    return Scaffold(
      appBar: AppBar(title: const Text('Scoreboard')),
      body: StreamBuilder<QuerySnapshot>(
        stream: firebaseService.getMatchResults(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }

          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return const Center(child: Text('No matches recorded yet.'));
          }

          var matches = snapshot.data!.docs;

          return ListView.builder(
            itemCount: matches.length,
            itemBuilder: (context, index) {
              var match = matches[index];
              return Card(
                margin: const EdgeInsets.symmetric(horizontal: 10, vertical: 5),
                child: ListTile(
                  title: Text('Match #${match['matchNumber']}'),
                  subtitle: Text(
                    '${match['player1']} (${match['score1']}) vs ${match['player2']} (${match['score2']})',
                    style: const TextStyle(fontSize: 16),
                  ),
                  trailing: Text(
                    'Winner: ${match['winner']}',
                    style: const TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.green,
                    ),
                  ),
                ),
              );
            },
          );
        },
      ),
    );
  }
}
