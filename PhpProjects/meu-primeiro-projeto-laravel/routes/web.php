<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('home'); // Página inicial
});

Route::get('/produtos', function () {
    return view('produtos'); // Página de produtos
});

Route::get('/contato', function () {
    return view('contato'); // Página de contato
});
