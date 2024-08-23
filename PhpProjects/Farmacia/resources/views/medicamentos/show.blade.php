@extends('layouts.app')


@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="{{ asset('storage/medicamentos/' . $medicamento->img) }}" class="img-fluid" alt="{{ $medicamento->nome }}">
            </div>
            <div class="col-md-6">
                <h2>{{ $medicamento->nome }}</h2>
                <p>{{ $medicamento->categoria }}</p>
                <p>{{ $medicamento->descricao }}</p>
                <p>{{ $medicamento->fabricante }}</p>
                <p>Preço: R$ {{ $medicamento->preco }}</p>


                <form method="POST" action="{{ route('carrinho.add', $medicamento->id) }}">
                    @csrf
                    <label for="quantidade"> Selecione a Quantidade</label>
                    <input type="number" name="quantidade" id="">
                    <br>
                    <button type="submit" class="btn btn-primary">Finalizar Compra</button>
                </form>
            </div>
        </div>
    </div>
@endsection
