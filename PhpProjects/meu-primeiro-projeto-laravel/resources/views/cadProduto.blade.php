@extends('layouts.master')
<body>
    <div class="container">
        <h1>Adicionar Produto</h1>
        <form action="{{ route('produtos.store') }}" method="POST">
            <div class="form-group">
                <label for="nome">Nome do Produto:</label>
                <input type="text" id="nome" name="nome" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea id="descricao" name="descricao" rows="4" required></textarea>
            </div>
            <div class="form-group">
                <label for="preco">Preço:</label>
                <input type="number" id="preco" name="preco" step="0.01" required>
            </div>
           
            <div class="form-group">
                <label for="qtd">Quantidade:</label>
                <input type="number" id="qtd" name="qtd" required>
            </div>
            <div class="form-group">
                <button type="submit">Adicionar Produto</button>
            </div>
        </form>
    </div>
</body>

