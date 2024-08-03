INSERT INTO produtos  (id, nome, descricao, preco, quantidade) 
VALUES (1, 'produto1', 'decricao', 99.00, 5);


-- Use App\Models\Produto

-- class ProdutoController extends Controller
-- {
--     // Exibe a lista de produtos
--     public function index()
--     {
--         $produtos = Produto::all();
--         return view('produtos', compact('produtos'));
--     }

--     // Exibe o formulário para criar um novo produto
--     public function create()
--     {
--         return view('produtos.create');
--     }

--     // Armazena um novo produto no banco de dados
--     public function store(Request $request)
--     {
--         $request->validate([
--             'nome' => 'required',
--             'descricao' => 'required',
--             'preco' => 'required|decimal',
--             'quantidade' => 'required|integer',
--         ]);

--         Produto::create($request->all());

--         return redirect()->route('produtos.index')->
--         with('success', 'Produto criado com sucesso.');
--     }

--     // Exibe um produto específico
--     public function show(Produto $produto)
--     {
--         return view('produtos.show', compact('produto'));
--     }

--     // Exibe o formulário para editar um produto existente
--     public function edit(Produto $produto)
--     {
--         return view('produtos.edit', compact('produto'));
--     }

--     // Atualiza um produto existente no banco de dados
--     public function update(Request $request, Produto $produto)
--     {
--         $request->validate([
--             'nome' => 'required',
--             'descricao' => 'required',
--             'preco' => 'required|numeric',
--             'quantidade' => 'required|integer',
--         ]);

--         $produto->update($request->all());

--         return redirect()->route('produtos.index')->with('success', 'Produto atualizado com sucesso.');
--     }

--     // Remove um produto do banco de dados
--     public function destroy(Produto $produto)
--     {
--         $produto->delete();

--         return redirect()->route('produtos.index')->with('success', 'Produto excluído com sucesso.')
--     }
-- }

-- <div class="container">
--         <h1>Produtos</h1>
--         <a href="" class="btn btn-primary">Adicionar Produto</a>
--         <table class="table table-bordered mt-4">
--             <thead>
--                 <tr>
--                     <th>ID</th>
--                     <th>Nome</th>
--                     <th>Descrição</th>
--                     <th>Preço</th>
--                     <th>Quantidade</th>
--                     <th>Ações</th>
--                 </tr>
--             </thead>
--             <tbody>
--                 @foreach ($produtos as $produto)
--                     <tr>
--                         <td>{{ $produto->id }}</td>
--                         <td>{{ $produto->nome }}</td>
--                         <td>{{ $produto->descricao }}</td>
--                         <td>{{ $produto->preco }}</td>
--                         <td>{{ $produto->quantidade }}</td>
--                         <td>
--                             <a href="{{ route('produtos.show', $produto->id) }}" class="btn btn-info">Ver</a>
--                             <a href="{{ route('produtos.edit', $produto->id) }}" class="btn btn-warning">Editar</a>
--                             <form action="{{ route('produtos.destroy', $produto->id) }}" method="POST" style="display:inline;">
--                                 @csrf
--                                 @method('DELETE')
--                                 <button type="submit" class="btn btn-danger">Excluir</button>
--                             </form>
--                         </td>
--                     </tr>
--                 @endforeach
--             </tbody>
--         </table>
--     </div>

-- Route::get('/produtos',ProdutoController::class,'index');