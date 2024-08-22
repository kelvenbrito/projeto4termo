<?php

namespace App\Http\Controllers;

use App\Models\Medicamentos;
use Illuminate\Http\Request;

class MedicamentosController extends Controller
{
    /**
     * Display a listing of the resource.
     */
  //lista todos os medicamentos
     public function index()
    {
        $medicamentos = Medicamentos::all();
        return view('medicamentos.index', compact('medicamentos'));
    }

    /**
     * Show the form for creating a new resource.
     */

      //abre o formulario de cadastro
    public function create()
    {
        return view('medicamentos.create');
    }

    /**
     * Store a newly created resource in storage.
     */
 // envia o formulario de cadastro
     public function store(Request $request)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'quantidade'=> 'required|numeric',
            'categoria'=> 'require',
            'preco'=> 'required|numeric',
            'data_validade'=> 'required',
            'fabricante'=> 'required',

        ]);

        Medicamentos::create($request->all());

        return redirect()->route('medicamentos.index')->
        with('success','Medicamentos cadastrado com sucesso!');
    }

    /**
     * Display the specified resource.
     */
      //Mostrar o produto
     public function show(Medicamentos $medicamento)
    {
        return view('medicamentos', compact('medicamento'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Medicamentos $medicamentos)
    {
        return view('mediamentos.edit', compact('medicamentos'));
    }

    /**
     * Update the specified resource in storage.
     */
    // Atualização do medicamento
    public function update(Request $request, Medicamentos $medicamentos)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'quantidade'=> 'required|numeric',
            'categoria'=> 'require',
            'preco'=> 'required|numeric',
            'data_validade'=> 'required',
            'fabricante'=> 'required',

        ]);

        $medicamentos->update($request->all());

        return redirect()->route('medicamentos.index')->
        with('success','Medicamento Atualizado com Sucesso!');

    }

    /**
     * Remove the specified resource from storage.
     */
    // Deletar Medicamentos
    public function destroy(Medicamentos $medicamentos)
    {
        $medicamentos->delete();

        return redirect()->route('medicamentos')->
        with('success','Medicamento deletado com sucesso');
    }
}
