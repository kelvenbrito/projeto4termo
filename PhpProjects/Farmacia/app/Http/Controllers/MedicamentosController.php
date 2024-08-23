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
     // Validação dos dados do formulário
     $request->validate([
         'nome' => 'required|string|max:255',
         'descricao' => 'nullable|string',
         'categoria' => 'nullable|string',
         'quantidade' => 'required|integer',
         'preco' => 'required|numeric',
         'fabricante' => 'nullable|string',
         'img' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
     ]);
 
     // Processamento do arquivo de imagem, se presente
     if ($request->hasFile('img')) {
         $file = $request->file('img');
         $path = $file->store('public/medicamentos'); // Armazena a imagem em storage/app/public/medicamentos
         $imgPath = basename($path); // Obtém o nome do arquivo
     } else {
         $imgPath = null;
     }
 
     // Criação do registro no banco de dados
     Medicamentos::create([
         'nome' => $request->input('nome'),
         'descricao' => $request->input('descricao'),
         'categoria' => $request->input('categoria'),
         'quantidade' => $request->input('quantidade'),
         'preco' => $request->input('preco'),
         'fabricante' => $request->input('fabricante'),
         'img' => $imgPath,
     ]);
 
     return redirect()->route('medicamentos.index')
         ->with('success', 'Medicamento cadastrado com sucesso!');
 }
 

    /**
     * Display the specified resource.
     */
      //Mostrar o produto
     public function show(Medicamentos $medicamento)
    {
        return view('medicamentos.show', compact('medicamento'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Medicamentos $medicamento)
    {
        return view('medicamentos.edit', compact('medicamento'));
    }

    /**
     * Update the specified resource in storage.
     */
    // Atualização do medicamento
    public function update(Request $request, Medicamentos $medicamento)
    {
        $request->validate([
            'nome' => 'required|string|max:255',
            'descricao' => 'nullable|string',
            'categoria' => 'nullable|string',
            'quantidade' => 'required|integer',
            'preco' => 'required|numeric',
            'fabricante' => 'nullable|string',
            'img' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
        ]);
    
        // Processamento do arquivo de imagem, se presente
        if ($request->hasFile('img')) {
            $file = $request->file('img');
            $path = $file->store('public/medicamentos'); // Armazena a imagem em storage/app/public/medicamentos
            $imgPath = basename($path); // Obtém o nome do arquivo
        } else {
            $imgPath = $medicamento->img; // Mantém o valor antigo se não houver nova imagem
        }
    
        // Atualização do registro no banco de dados
        $medicamento->update([
            'nome' => $request->input('nome'),
            'descricao' => $request->input('descricao'),
            'categoria' => $request->input('categoria'),
            'quantidade' => $request->input('quantidade'),
            'preco' => $request->input('preco'),
            'fabricante' => $request->input('fabricante'),
            'img' => $imgPath,
        ]);
    
        return redirect()->route('medicamentos.index')
            ->with('success', 'Medicamento atualizado com sucesso!');
    }
    

    /**
     * Remove the specified resource from storage.
     */
    // Deletar Medicamentos
    public function destroy(Medicamentos $medicamento)
    {
        $medicamento->delete();

        return redirect()->route('medicamentos.index')->
        with('success','Medicamento deletado com sucesso');
    }
}
