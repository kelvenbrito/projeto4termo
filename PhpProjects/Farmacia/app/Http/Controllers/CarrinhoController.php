<?php

namespace App\Http\Controllers;

use App\Models\Carrinho;
use App\Models\Medicamentos;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

class CarrinhoController extends Controller
{
 // Metodo para adicionar na tabela carrinho
 public function add(Request $request, Medicamentos $medicamento)
 {
     $dados = $request->validate([
         'quantidade' => 'required|numeric|min:1',
     ]);

     // Verifica se há quantidade suficiente em estoque
     if ($medicamento->quantidade < $request->quantidade) {
         return redirect()->route('medicamentos.show', $medicamento)
             ->with('error', 'Quantidade insuficiente em estoque.');
     }

     // Adiciona o medicamento ao carrinho
     Carrinho::create([
         'id_medicamento' => $medicamento->id,
         'id_user' => Auth::id(),
         'quantidade' => $request->quantidade,
     ]);

     // Atualiza a quantidade do medicamento em estoque
     $medicamento->quantidade -= $request->quantidade;
     $medicamento->save();

     return redirect()->route('home')->with('success', 'Compra efetuada com sucesso.');
 }

 public function index()
 {
     $userId = Auth::id();
     $carrinho = Carrinho::where('id_user', $userId)->get();
     return view('carrinho.index', compact('carrinho'));
 }






}
