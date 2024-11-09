// File generated by FlutterFire CLI.
// ignore_for_file: type=lint
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        return windows;
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyAqq40dsCuYnct4FldTKurFO0ys8Fr9ow0',
    appId: '1:612233225640:web:b620b24631f3a91210699d',
    messagingSenderId: '612233225640',
    projectId: 'projeto-flutter-3a7d0',
    authDomain: 'projeto-flutter-3a7d0.firebaseapp.com',
    storageBucket: 'projeto-flutter-3a7d0.firebasestorage.app',
    measurementId: 'G-CYZBTR3QSZ',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyA9tlGWYAru7WBEEKesCtc7ymvkLw0VN_A',
    appId: '1:612233225640:android:4fa736b6137bb9c810699d',
    messagingSenderId: '612233225640',
    projectId: 'projeto-flutter-3a7d0',
    storageBucket: 'projeto-flutter-3a7d0.firebasestorage.app',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyBZceMe0OWiJUqTzrtkAnPyDUHdLzkuwyg',
    appId: '1:612233225640:ios:f2004cf43d26bc9c10699d',
    messagingSenderId: '612233225640',
    projectId: 'projeto-flutter-3a7d0',
    storageBucket: 'projeto-flutter-3a7d0.firebasestorage.app',
    iosBundleId: 'com.example.flutterSomativa',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyBZceMe0OWiJUqTzrtkAnPyDUHdLzkuwyg',
    appId: '1:612233225640:ios:f2004cf43d26bc9c10699d',
    messagingSenderId: '612233225640',
    projectId: 'projeto-flutter-3a7d0',
    storageBucket: 'projeto-flutter-3a7d0.firebasestorage.app',
    iosBundleId: 'com.example.flutterSomativa',
  );

  static const FirebaseOptions windows = FirebaseOptions(
    apiKey: 'AIzaSyAqq40dsCuYnct4FldTKurFO0ys8Fr9ow0',
    appId: '1:612233225640:web:85edebf3147ba8de10699d',
    messagingSenderId: '612233225640',
    projectId: 'projeto-flutter-3a7d0',
    authDomain: 'projeto-flutter-3a7d0.firebaseapp.com',
    storageBucket: 'projeto-flutter-3a7d0.firebasestorage.app',
    measurementId: 'G-C9K1XEP861',
  );
}
