<?php


use App\Http\Controllers\CarrinhoController;
use App\Http\Controllers\DashboardController;
use App\Http\Controllers\HomeController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\MedicamentosController;
use App\Http\Middleware\MedicamentosMiddleware;
use SebastianBergmann\CodeCoverage\Report\Html\Dashboard;

//pagina inicial com carrosel

Route::get('/',  [HomeController::class,'index'])->name('home');

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
Route::get('/dashboard', [DashboardController::class, 'index'])->middleware('auth')->name('dashboard');

// Rota do logot
Route::post('/logout',[UserController::class, 'logout']);

//rota para medicamentos
Route::resource('/medicamentos', MedicamentosController::class)->middleware(MedicamentosMiddleware::class)->except('show');

//Visualização de um ,edicamentos especifico
Route::get('medicamentos/{medicamento}', [MedicamentosController::class, 'show'])->middleware('auth')->name('medicamentos.show');

//rota para adicionar medicamentos no carrinho
Route::post('carrinho/add/{medicamento}', [CarrinhoController::class,'add'])->middleware('auth')->name('carrinho.add');
