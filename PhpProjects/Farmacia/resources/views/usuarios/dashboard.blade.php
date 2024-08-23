@extends('layouts.app')

@section('content')
    <h1>Dashboard de Medicamentos</h1>
    <form method="GET" action="{{ route('dashboard') }}">
        <input type="text" name="search" placeholder="Pesquisar medicamentos..." value="{{ request('search') }}">
        <button type="submit">Pesquisar</button>
    </form>

    <div class="row">
        @foreach ($medicamentos as $medicamento)
        <div class="col-md-4">
            <div class="card">
                <img src="{{ asset('storage/medicamentos/' . $medicamento->img) }}" class="card-img-top" alt="{{ $medicamento->nome }}">
                <div class="card-body">
                    <h5 class="card-title">{{ $medicamento->nome }}</h5>
                    <p class="card-text">{{ $medicamento->descricao }}</p>
                    <p class="card-text">{{ $medicamento->categoria }}</p>
                    <p class="card-text">{{ $medicamento->fabricante }}</p>
                    <p class="card-text">Preço: R$ {{ $medicamento->preco }}</p>
                    <a href="{{ route('medicamentos.show', $medicamento->id) }}" class="btn btn-primary">Ver Medicamentos</a>

                </div>
            </div>
        </div>
        @endforeach
    </div>
</div>
@endsection



