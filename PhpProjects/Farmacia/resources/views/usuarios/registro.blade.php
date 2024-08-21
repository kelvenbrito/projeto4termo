{{-- formularios de cadastro --}}
@extends('layouts.app')

@section('content')
{{--Formulario--}}
    <div class="container">
        <h1>Registrar-se</h1>
        <form method="POST" action="{{route('usuarios.registro')}}">
            @csrf
        </form>
    </div>
@endsection