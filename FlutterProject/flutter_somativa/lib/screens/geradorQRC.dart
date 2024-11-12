import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class GeradorQRC extends StatefulWidget {
  const GeradorQRC({super.key});

  @override
  _GeradorQRCState createState() => _GeradorQRCState();
}

class _GeradorQRCState extends State<GeradorQRC> {
  final TextEditingController _emailController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Enviar E-mail'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: _emailController,
              decoration: const InputDecoration(
                labelText: 'Digite o e-mail',
                hintText: 'exemplo@dominio.com',
              ),
              keyboardType: TextInputType.emailAddress,
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _sendEmail,
              child: const Text('Enviar E-mail'),
            ),
          ],
        ),
      ),
    );
  }

  void _sendEmail() async {
    final String email = _emailController.text;
    
    if (email.isNotEmpty) {
      final Uri emailUri = Uri(
        scheme: 'mailto',
        path: email, // O e-mail digitado pelo usuário
        queryParameters: {
          'subject': 'Assunto do E-mail',
          'body': 'Olá,\n\nEsta é uma mensagem de teste.',
        },
      );

      if (await canLaunchUrl(emailUri)) {
        await launchUrl(emailUri);
      } else {
        print('Não foi possível abrir o cliente de e-mail');
      }
    } else {
      print('Por favor, insira um endereço de e-mail válido.');
    }
  }
}
