@extends('layouts.app')
{{-- Pagina de login --}}

@section('content')
<!-- Exibir mensagens de sucesso -->
@if(session('success'))
    <div class="alert alert-success">
        {{ session('success') }}
    </div>
@endif

<!-- Exibir mensagens de erro -->
@if($errors->any())
    <div class="alert alert-danger">
        @foreach($errors->all() as $error)
            <p>{{ $error }}</p>
        @endforeach
    </div>
@endif


<div class="container">
    <div class="login">
    <h1>Login</h1>
    <form method="POST" action="{{ route('usuarios.login') }}">
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
</div>


@endsection
