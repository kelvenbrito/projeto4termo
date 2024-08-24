@extends('layouts.app')


@section('content')

<div class="container">
    <h1 class="my-4">Medicamentos</h1>
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


    <a class="btn btn-success mb-2" href="{{ route('medicamentos.create') }}">
        Cadastrar Novo Medicamento
    </a>
    <table class="table table-bordered">
        <tr>
            <th>N°</th>
            <th>Nome</th>
            <th>Categoria</th>
            <th>fabricante</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th width="280px">Ação</th>
        </tr>
        @foreach ($medicamentos as $medicamento)
        <tr>
            <td>{{ $loop->iteration }}</td>
            <td>{{ $medicamento->nome }}</td>
            <td>{{ $medicamento->categoria}}</td>
            <td>{{ $medicamento->fabricante}}</td>
            <td>{{ $medicamento->quantidade}}</td>
            <td>{{ $medicamento->preco }}</td>
      <td>
            <form action="{{ route('medicamentos.destroy', $medicamento->id) }}" method="POST">
                    <a class="btn btn-primary" href="{{ route('medicamentos.edit', $medicamento->id) }}">Editar</a>


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







