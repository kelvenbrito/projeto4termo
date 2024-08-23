<?php

namespace App\Http\Controllers;

use App\Models\Carrinho;
use App\Models\Medicamentos;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

class CarrinhoController extends Controller
{
    public function add(Request $request, Medicamentos $medicamento){
        $dados = $request->validate([
            "quantidade"=> 'required|numeric|min:1'
        ]);
            Carrinho::create(['id_medicamento'=> $medicamento->id, 'id_user'=>Auth::id(), 'quantidade'=>$request->quantidade]);

            return redirect()->route('medicamentos.show', $medicamento)
            ->with('success', 'Medicamento adicionado ao Carrinho.');
            
        

    }
}