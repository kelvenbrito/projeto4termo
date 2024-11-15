
Diagrama Entidade-Relacionamento (DER)

+---------------------+          +----------------------+
|      Usuarios       |          |        Tarefas      |
+---------------------+          +----------------------+
| PK   email          |          | PK   id             |
|      nome           |   1-N    |      descricao       |
|                     |<---+-----|      setor          |
|                     |          |      prioridade      |
+---------------------+          |      status         |
                                 | FK   id_usuario     |
                                 +----------------------+


Criação do Banco de Dados
CREATE DATABASE saep


Caso de uso do cenário de gerenciamento de tarefas

+---------------------+
|      Usuário        |
+---------------------+
          |
          |
          |---------------------------+
          |                           |
+---------------------+     +----------------------+
|  Cadastrar Tarefa   |     |  Gerenciar Tarefas   |
+---------------------+     +----------------------+
          |                           |
          |                           |
+---------------------+     +----------------------+
|   Editar Tarefa     |     |  Atualizar Status    |
+---------------------+     +----------------------+
          |                           |
          |                           |
+---------------------+     +----------------------+
|  Excluir Tarefa     |     |  Visualizar Tarefas  |
+---------------------+     +----------------------+

+---------------------+
|    Administrador    |
+---------------------+
          |
          |
+---------------------+
|  Cadastrar Usuário  |
+---------------------+

                          
