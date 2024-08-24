<?php

namespace App\Http\Controllers;

use App\Models\Medicamentos;
use Illuminate\Http\Request;
use App\Models\Carrinho;

class HomeController extends Controller
{
    public function index()
    {
        // Pegaos 5 medicamentos mais recentes
        $medicamentos = Medicamentos::take(5)->get();
        return view('home', compact('medicamentos'));
    }

   

}
