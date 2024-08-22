<?php

namespace App\Http\Controllers;

use App\Models\Medicamentos;
use Illuminate\Http\Request;

class HomeController extends Controller
{
    public function index()
    {
        // Pegue os 5 medicamentos mais recentes, por exemplo
        $medicamentos = Medicamentos::take(5)->get();
        return view('home', compact('medicamentos'));
    }

}
