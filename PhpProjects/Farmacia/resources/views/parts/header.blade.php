{{-- header --}}
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Home</a>
       

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
            @if (Auth::check())
            <h3 class="navbar-text">Olá, {{ Auth::user()->name }}, Bem vindo a nossa Farmacia</h3>
            <div class="navbar-nav ms-auto">
  
               
                    @if(Auth::user()->isfunc())
                        <li class="nav-item">
                            <a class="nav-link" href="/medicamentos">Cadastro de Produtos</a>
                        </div>
                    @else
                        <div class="nav-item">
                            <a class="nav-link" href="/dashboard">Produtos</a>
                        </div>
                    @endif
                    <div class="nav-item">
                        <form action="/logout" method="post" class="d-inline">
                            @csrf
                            <button type="submit" class="btn btn-link nav-link">Logout</button>
                        </form>
                    </div>
                @else
                    <div class="nav-item">
                        <button><a class="nav-link" href="/login">Login</a></button>
                    </div>
                    <div class="nav-item">
                    </button> <a class="nav-link" href="/registro">Cadastrar</a></button>
                    </div>
                @endif
            </ul>
        </div>
    </div>
</nav>
