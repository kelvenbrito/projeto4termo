<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <span class="navbar-text">Olá, {{ Auth::user()->name }}</span>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <div class="mx-auto">
                <form method="GET" action="{{ route('dashboard') }}" class="d-flex">
                    <input type="text" name="search" placeholder="Pesquisar medicamentos..." value="{{ request('search') }}" class="form-control me-2">
                    <button type="submit" class="btn btn-primary">Pesquisar</button>
                </form>
            </div>
            <ul class="navbar-nav ms-auto">
                @if (Auth::check())
                    <li class="nav-item">
                        <a class="navbar-brand" href="/">Farmácia</a>
                    </li>
                    @if(Auth::user()->isfunc())
                        <li class="nav-item">
                            <a class="nav-link" href="/medicamentos">Produtos</a>
                        </li>
                    @else
                        <li class="nav-item">
                            <a class="nav-link" href="/dashboard">Pedidos</a>
                        </li>
                    @endif
                    <li class="nav-item">
                        <form action="/logout" method="post" class="d-inline">
                            @csrf
                            <button type="submit" class="btn btn-link nav-link">Logout</button>
                        </form>
                    </li>
                @else
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/registro">Registro</a>
                    </li>
                @endif
            </ul>
        </div>
    </div>
</nav>
