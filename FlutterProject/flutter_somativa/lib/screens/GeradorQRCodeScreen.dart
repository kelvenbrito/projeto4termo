import 'package:flutter/material.dart';
import 'package:qr_flutter/qr_flutter.dart';

class GeradorQRCodeScreen extends StatefulWidget {
  @override
  _GeradorQRCodeScreenState createState() => _GeradorQRCodeScreenState();
}

class _GeradorQRCodeScreenState extends State<GeradorQRCodeScreen> {
  final _nomeController = TextEditingController();
  final _cpfController = TextEditingController();
  String _qrCodeData = '';

  // Função para gerar QR Code baseado no CPF
  void _gerarQRCode() {
    setState(() {
      _qrCodeData = _cpfController.text; // Usa o CPF como o dado para gerar o QR code
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Gerador de QR Code'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _nomeController,
              decoration: const InputDecoration(labelText: 'Nome'),
            ),
            TextField(
              controller: _cpfController,
              decoration: const InputDecoration(labelText: 'CPF'),
              keyboardType: TextInputType.number,
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _gerarQRCode,
              child: const Text('Gerar QR Code'),
            ),
            const SizedBox(height: 20),
            if (_qrCodeData.isNotEmpty) 
              QrImage(
                data: _qrCodeData,
                version: QrVersions.auto,
                size: 200.0,
              ),
          ],
        ),
      ),
    );
  }
}
