@extends('layouts.app')


@section('content')

<div class="container">
    <h1 class="my-4">Medicamentos</h1>
    @if ($message = Session::get('success'))
    <div class="alert alert-success">
        <p>{{ $message }}</p>
    </div>   
    @endif

    <a class="btn btn-success mb-2" href="{{ route('medicamentos.create') }}">
        Cadastrar Novo Medicamento
    </a>
    <table class="table table-bordered">
        <tr>
            <th>N°</th>
            <th>Nome</th>
            <th>Categoria</th>
            <th>fabricante</th>
            <th>data_validade</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th width="280px">Ação</th>
        </tr>
        @foreach ($medicamentos as $medicamento)
        <tr>
            <td>{{ $loop->iteration }}</td>
            <td>{{ $produto->nome }}</td>
            <td>{{ $produto->categoria}}</td>
            <td>{{ $produto->fabricante}}</td>
            <td>{{ $produto->data_validade }}</td>
            <td>{{ $produto->quantidade}}</td>
            <td>{{ $produto->preco }}</td>
      
            <form action="{{ route('medicamentos.destroy', $medicamento->id) }}" method="POST">
                    <a class="btn btn-info" href="{{ route('medicamentos.show', $produto->id) }}">Mostrar</a>
                    <a class="btn btn-primary" href="{{ route('medicamentos.edit', $produto->id) }}">Editar</a>


                    @csrf
                    @method('DELETE')
                    <button type="submit" class="btn btn-danger">Deletar</button>
                </form>
            </td>
        </tr>

        @endforeach
    </table>
</div>
@endsection







