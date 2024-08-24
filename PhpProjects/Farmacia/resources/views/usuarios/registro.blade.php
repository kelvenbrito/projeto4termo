{{-- formularios de cadastro --}}
@extends('layouts.app')




@section('content')
{{-- formulario --}}
<div class="container">
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

    <h1>Registrar-se</h1>
    <form method="POST" action="{{ route('usuarios.registro') }}">
        @csrf


        <div class="form-group">
            <label for="name">Nome</label>
            <input type="text" name="name" class="form-control" required>
        </div>




        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control @error('email')is-invalid @enderror" value="{{old('email')}}" required>
            @error('email')
            <div class="invalid-feedback">{{$message}}</div>
            @enderror
        </div>
       




        <div class="form-group">
            <label for="password">Senha</label>
            <input type="password" name="password" class="form-control @error('password')is-invalid @enderror" required>
            @error('password')
            <div class="invalid-feedback">{{$message}}</div>
            @enderror
        </div>
       




        <div class="form-group">
            <label for="password_confirmation">Confirme a Senha</label>
            <input type="password" name="password_confirmation" class="form-control" required>
        </div>
       






        <button type="submit" class="btn btn-primary">Registrar-se</button>
    </form>
</div>




@endsection

