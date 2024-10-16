<!-- Documentação Técnica do Projeto -->
##Definição do Tema
O Sistema de Manutenção Preventiva e Corretiva é um software destinado ao gerenciamento do ciclo de vida de máquinas e equipamentos industriais, com foco em minimizar o tempo de inatividade e otimizar a performance operacional. Ele permite o controle das manutenções preventivas (realizadas regularmente para evitar falhas) e corretivas (realizadas após uma falha). O sistema também inclui funcionalidades para registrar falhas, gerenciar técnicos, gerar relatórios e acompanhar indicadores de desempenho, como o MTTR (Mean Time to Repair - Tempo Médio de Reparo) e o MTBF (Mean Time Between Failures - Tempo Médio Entre Falhas).

##Análise de Requisitos e Escopo

###Funcionalidades Principais:
Gerenciamento de Máquinas e Equipamentos:
Cadastro de máquinas, incluindo especificações técnicas, data de aquisição e localização.
Visualização e edição de informações de máquinas.
###Registro e Controle de Manutenções:
Registro de manutenções preventivas e corretivas.
Histórico completo de manutenções para cada máquina.
Registro de peças substituídas e tempo de inatividade.

###Gerenciamento de Falhas:
Registro de falhas ocorridas, classificando a severidade e identificando o operador.
Controle de falhas por máquina.
##Gerenciamento de Técnicos:
Cadastro de técnicos, incluindo suas especialidades e disponibilidade.
Relatórios e Indicadores:
Geração de relatórios de manutenção, tempo de inatividade, falhas e peças trocadas.
Cálculo de indicadores como MTTR e MTBF.
Integração com API:
Utilização de uma API REST (JSON-Server) para armazenar e recuperar dados.


###Requisitos Funcionais:
O sistema deve permitir o cadastro de máquinas com suas especificações.
O sistema deve registrar manutenções preventivas e corretivas, associando técnicos e peças trocadas.
O sistema deve gerar relatórios de manutenção e indicadores de performance.
O sistema deve oferecer uma interface gráfica intuitiva para o usuário final.

###Requisitos Não Funcionais:
O sistema deve ser responsivo, com tempo de resposta rápido ao realizar operações com a API.
A interface deve ser amigável e permitir fácil navegação entre as funcionalidades.
O sistema deve armazenar e recuperar dados de maneira segura e eficiente.

##ESCOPO

###objetivos
Específico: Desenvolver e implementar um módulo que permita a criação de uma interface gráfica utilizando Java Swing para o gerenciamento de máquinas, técnicos e manutenções, além do registro de manutenções corretivas após falhas.
Mensurável: O sucesso será medido pela conclusão das funcionalidades de CRUD (Criar, Ler, Atualizar e Deletar) para máquinas, manutenções, falhas e técnicos.
Atingível: As funcionalidades serão desenvolvidas com base em um cronograma detalhado, priorizando os módulos críticos e utilizando as tecnologias já definidas (Java Swing para o frontend e integração com o backend em Java)
Relevante: Este objetivo é crucial para garantir a manutenção adequada de máquinas e equipamentos, aumentando a eficiência operacional e reduzindo o tempo de inatividade. A integração com uma API será implementada para armazenar e manipular dados em tempo real, garantindo a sincronização do sistema com o backend.
Temporal: O módulo de manutenções preventivas, incluindo validação e testes para garantir a robustez do sistema, deverá ser concluído em 5 dias.

###Levantamento de recursos
Ferramentas:
 java Swing
 Visual Studio Code
 GIT
 Json
  Bibliotecas Java
  JUnit


###Análise de riscos
•Problemas de conectividade ou lentidão na API podem afetar o desempenho da integração.

Mitigações: Monitorar a performance da API, implementar mecanismos adequados para garantir que a aplicação lide corretamente com falhas e otimizar a aplicação.


•A equipe pode enfrentar desafios ao criar uma interface gráfica intuitiva e de fácil uso.
Mitigações: Adotar bibliotecas ou frameworks que facilitam a criação de interfaces amigáveis

•	Atrasos no cronograma: Atrasos podem ocorrer devido a mudanças nos requisitos, problemas técnicos inesperados ou falta de recursos humanos, comprometendo o prazo de entrega.
 Mitigação: Utilizar uma metodologia ágil com sprints curtos, revisões regulares do progresso e comunicação clara entre a equipe para detectar e resolver problemas rapidamente.

•Problemas de segurança na aplicação:
Mitigação: Implementar boas práticas de segurança, como a criptografia de dados sensíveis, uso de autenticação forte

•Erros no armazenamento ou na recuperação de dados podem prejudicar a precisão dos relatórios e indicadores.
Mitigações: Implementar testes para garantir a consistência dos dados e utilizar mecanismos de validação de dados antes de inseri-los ou atualizá-los no sistema..

Teste API


Maquinas

GET:
![alt text](img/get_img.png)

POST:
![alt text](img/post_img.png)

PUT:
![alt text](img/image.png)

![alt text](img/put_img.png)

DELETE
![alt text](img/delete_img.png)

Manutenções

GET:
![alt text](img/Manutencao_get_img.png)

POST:
![alt text](img/Manutencao_post_img.png)

Falhas

GET:
![alt text](img/Falha_get_img.png)

POST:
![alt text](img/Falha_post_img.png)

tecnicos

POST:
![alt text](img/tecnicos_get.png)