{{-- Pagina inicial --}}
@extends('layouts.app')


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

    <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            @foreach ($medicamentos as $index => $medicamento)
            <div class="carousel-item {{ $index == 0 ? 'active' : '' }}">
                <img src="{{ asset('storage/medicamentos/' . $medicamento->img) }}" class="d-block w-100" alt="{{ $medicamento->nome }}">
                <div class="carousel-caption d-none d-md-block">

                    <h5>{{ $medicamento->nome }}</h5>
                    <p>{{ $medicamento->descricao }}</p>
                    <p>Preço: R$ {{ $medicamento->preco }}</p>
                </div>
            </div>
            @endforeach
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <br><br>

    <h1>Medicamentos</h1>


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
                    <a href="{{ route('medicamentos.show', $medicamento->id) }}" class="btn btn-primary">Comprar</a>

                </div>
            </div>
        </div>
        @endforeach
    </div>
</div>
@endsection
