<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Medicamentos;


class DashboardController extends Controller
{
    public function index(Request $request)
    {
        $search = $request->input('search');
        $medicamentos = Medicamentos::when($search, function ($query, $search) {
            return $query->where('nome', 'like', "%{$search}%")
                         ->orWhere('descricao', 'like', "%{$search}%")
                         ->orWhere('categoria', 'like' ,"%{$search}%");
        })->get();
        return view('usuarios.dashboard', compact('medicamentos'));
    
    }
}