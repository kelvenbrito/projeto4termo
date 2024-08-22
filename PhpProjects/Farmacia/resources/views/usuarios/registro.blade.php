{{-- formularios de cadastro --}}
@extends('layouts.app')

@section('content')
{{--Formulario--}}
    <div class="container">
        <h1>Registrar-se</h1>
        <form method="POST" action="{{route('usuarios.registro')}}">
            @csrf
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" name="email" class="form-control" required autofocus>
            </div>
            <div class="form-group">
                <label for="password">Senha</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
@endsection