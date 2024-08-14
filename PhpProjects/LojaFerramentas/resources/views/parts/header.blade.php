@if (Auth::check())
    <div>
        <h3>Olá, {{Auth::user()->name}}</h3>
    </div>
    <form action="/logout" method="POST">
    @csrf
    <button type="submit">Logout</button>
</form>
@else
<div>
    <ul>
        <li><a href="/login">Login</a></li>
        <li><a href="/registro">Registro</a></li>
    </ul>
</div

@endif