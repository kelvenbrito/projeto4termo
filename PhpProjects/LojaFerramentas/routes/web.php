<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;


// Rota para exibir a homepage
Route::get('/', function () {
    return view('home');
});

// Rota para exibir o formulário de registro
Route::get('/registro', [UserController::class, 'showRegistroForm'])
    ->name('usuarios.registro');

// Rota para processar o registro
Route::post('/registro', [UserController::class, 'registro'])
    ->name('usuarios.registro');


    // Rota para exibir o formulário de registro
Route::get('/login', [UserController::class, 'showLoginForm'])
->name('usuarios.login');

// Rota para processar o login
Route::post('/login', [UserController::class, 'login'])
->name('usuarios.login');

// Rota para pagina interna

Route::get('/dashboard', function(){
return view('usuarios.dashboard');
})->middleware('auth')->name('usuarios.dashboard');

// Rota do logot
Route::post('/logout',[UserController::class, 'logout']);
