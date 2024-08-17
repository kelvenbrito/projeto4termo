<?php

namespace App\Http\Controllers;

use App\Models\Carrinho;
use App\Models\Produto;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

class CarrinhoController extends Controller
{
    public function add(Request $request, Produto $produto){
        $dados = $request->validate([
            "quantidade"=> 'required|numeric|min:1'
        ]);
            Carrinho::create(['id_produto'=> $produto->id, 'id_user'=>Auth::id(), 'quantidade'=>$request->quantidade]);
            return redirect()->route('produtos.show', $produto)
            ->with('success', 'Produto adicionado ao Carrinho.');
            
        

    }
    
}
