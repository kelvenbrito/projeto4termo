<?php

namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
class UserController extends Controller
{
    //Exibir o formulario de login
    public function showLoginForm()
    {
        return view('usuarios.login');
    }

    //Processar o login do usuario
    public function login(Request $request)
    {
        $credentials = $request->validate([
            'email' => ['required', 'email'],
            'password'=> ['required'],
        ]);

        if(Auth::guard('web')->attempt($credentials)){
            $request->session()->regenerate();
            return redirect()->intended('/dashboard');
        }

        return back()->withErrors([
            'email' => 'Esse email não existe em nossos registros!',

        ])->onlyInput('email');
    }

    //Exibir o formulario de registro
    public function showRegistroForm()
    {
        return view('usuarios.registro');
    }

    //Processar o registro de um novo usuario
    public function registro(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'email'=> 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:8|confirmed',
        ]);
    
        $usuario = User::create([
            'name'=> $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);
    
        Auth::login($usuario);
        
        return redirect('/dashboard');
    }
    

    //Realizar o logout do usuario
    public function logout(Request $request)
    {
        Auth::logout();

        $request->session()->regenerateToken();
        $request->session()->invalidate();
        return redirect('/');
     
    }
}
