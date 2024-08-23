@extends('layouts.app')


@section('content')
    <div class="container">
        <h1 class="my-4">Editar Medicamento</h1>
        @if ($errors->any())
        <div class="alert alert-danger">
            <strong>Oops!</strong> Houve alguns problemas com sua entrada.<br><br>
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
        @endif
        <form action="{{ route('medicamentos.update', $medicamento->id) }}" enctype="multipart/form-data" method="POST">


            @csrf
            @method('PUT')
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" name="nome" class="form-control" value="{{ $medicamento->nome }}">
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea name="descricao" class="form-control">{{ $medicamento->descricao }}</textarea>
            </div>
            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <input type="text" name="categoria" class="form-control" value="{{ $medicamento->categoria }}">
            </div>
            <div class="form-group">
                <label for="quantidade">Quantidade:</label>
                <input type="number" name="quantidade" class="form-control" value="{{ $medicamento->quantidade }}">
            </div>
            <div class="form-group">
                <label for="fabricante">Fabricante:</label>
                <input type="text" name="fabricante" class="form-control" value="{{ $medicamento->fabricante }}">
            </div>
            <div class="form-group">
                <label for="preco">Preço:</label>
                <input type="text" name="preco" class="form-control" value="{{ $medicamento->preco }}">
            </div>
            <div class="form-group">
                <label for="img">Imagem:</label>
                <input type="file" name="img" class="form-control" placeholder="imagem">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
@endsection