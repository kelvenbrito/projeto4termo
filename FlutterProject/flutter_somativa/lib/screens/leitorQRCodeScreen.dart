// import 'dart:io';

// import 'package:flutter/material.dart';
// import 'package:permission_handler/permission_handler.dart';
// import 'package:qr_code_scanner/qr_code_scanner.dart';

// class LeitorQRCodeScreen extends StatefulWidget {
//   const LeitorQRCodeScreen({super.key});

//   @override
//   _LeitorQRCodeScreenState createState() => _LeitorQRCodeScreenState();
// }

// Future<void> _requestPermissions() async {
//   // Solicitar permissão para a câmera
//   await Permission.camera.request();
// }

// class _LeitorQRCodeScreenState extends State<LeitorQRCodeScreen> {
//   final GlobalKey qrKey = GlobalKey(debugLabel: 'QR');
//   QRViewController? controller;
//   Barcode? qrCodeResult;

//   @override
//   void initState() {
//     super.initState();
//     _requestPermissions(); // Solicitar permissões na inicialização
//   }

//   @override
//   void reassemble() {
//     super.reassemble();
//     if (Platform.isAndroid) {
//       controller!.pauseCamera();
//     }
//     controller!.resumeCamera();
//   }

//   @override
//   void dispose() {
//     controller?.dispose();
//     super.dispose();
//   }

//   void _onQRViewCreated(QRViewController controller) {
//     this.controller = controller;
//     controller.scannedDataStream.listen((scanData) {
//       setState(() {
//         qrCodeResult = scanData; // Armazena o valor do QR Code escaneado
//       });
//       controller.pauseCamera(); // Pausa a câmera após a leitura do QR Code
//     });
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: const Text('Leitor de QR Code'),
//       ),
//       body: Column(
//         children: [
//           Expanded(
//             flex: 4,
//             child: QRView(
//               key: qrKey,
//               onQRViewCreated: _onQRViewCreated,
//               overlay: QrScannerOverlayShape(
//                 borderColor: Colors.blue,
//                 borderRadius: 10,
//                 borderLength: 30,
//                 borderWidth: 10,
//                 cutOutSize: 250,
//               ),
//             ),
//           ),
//           Expanded(
//             flex: 1,
//             child: Center(
//               child: qrCodeResult != null
//                   ? Text('Resultado: ${qrCodeResult!.code}') // Exibe o código QR
//                   : const Text('Escaneie um QR Code'),
//             ),
//           ),
//           ElevatedButton(
//             onPressed: () {
//               controller?.resumeCamera(); // Reinicia a câmera para escanear novamente
//             },
//             child: const Text('Escanear Novamente'),
//           ),
//         ],
//       ),
//     );
//   }
// }
