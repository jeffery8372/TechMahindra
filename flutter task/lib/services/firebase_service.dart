import 'package:cloud_firestore/cloud_firestore.dart';

class FirebaseService {
  final FirebaseFirestore _db = FirebaseFirestore.instance;

  Future<void> saveMatchResult(
    int matchNumber,
    String player1,
    int score1,
    String player2,
    int score2,
    String winner,
  ) async {
    await _db.collection('matches').add({
      'matchNumber': matchNumber,
      'player1': player1,
      'score1': score1,
      'player2': player2,
      'score2': score2,
      'winner': winner,
      'timestamp': FieldValue.serverTimestamp(),
    });
  }

  Stream<QuerySnapshot> getMatchResults() {
    return _db
        .collection('matches')
        .orderBy('matchNumber', descending: true)
        .snapshots();
  }
}
