<?php

use App\Http\Controllers\ProdutoController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('home'); // Página inicial
});

Route::get('/produtos', [ProdutoController::class,'index']
 );

Route::get('/contato', function () {
    return view('contato'); // Página de contato
});

Route::get('/cadProduto', function () {
    return view('cadProduto'); // Página de contato
});

Route::post('/adicionar-produto', [ProdutoController::class, 'store'])->name('produtos.store');