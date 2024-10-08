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
 Json


###Análise de riscos
Risco: Falhas na Integração com API

    Descrição: A falha na integração entre o frontend (Java Swing) e o backend (Spring Boot, API REST) pode impedir a comunicação adequada entre as partes do sistema.
    Probabilidade: Média
    Impacto: Alto – As funcionalidades do sistema ficariam comprometidas, como o armazenamento de dados e a comunicação em tempo real.
    Mitigação: Testes rigorosos da API antes da integração, uso de ferramentas como Postman para validar as rotas e garantir que as respostas sejam adequadas. Implementar tratamento de erros eficaz no frontend para capturar e lidar com falhas de comunicação.

2. Risco: Problemas de Desempenho no Frontend (Java Swing)

    Descrição: O Java Swing pode enfrentar problemas de desempenho ao lidar com um grande volume de dados ou interfaces complexas, tornando a aplicação lenta.
    Probabilidade: Média
    Impacto: Médio – A experiência do usuário pode ser afetada pela lentidão da interface.
    Mitigação: Otimizar o uso de componentes Swing, carregando dados de forma assíncrona e implementando paginação para grandes volumes de dados. Revisar o código para evitar operações bloqueantes na interface gráfica.

3. Risco: Falhas de Segurança (Acesso Indevido)

    Descrição: Vulnerabilidades no sistema de autenticação ou no acesso à API podem permitir que usuários não autorizados acessem dados sensíveis.
    Probabilidade: Baixa
    Impacto: Alto – A exposição de dados críticos pode comprometer a confiabilidade do sistema e causar perda de informações.
    Mitigação: Implementar Spring Security no backend para controle de acesso baseado em papéis, garantir que a comunicação seja feita por meio de HTTPS, e realizar auditorias regulares de segurança.

4. Risco: Problemas de Confiabilidade nos Dados (Falhas de Banco de Dados)

    Descrição: Possíveis falhas no banco de dados podem resultar em perda de dados ou inconsistências no registro de manutenções, falhas e técnicos.
    Probabilidade: Baixa
    Impacto: Alto – Perda de dados pode comprometer a eficiência operacional e gerar retrabalho.
    Mitigação: Implementar backups regulares no banco de dados (PostgreSQL ou MySQL), usar transações para garantir a integridade dos dados e configurar replicação do banco para maior confiabilidade.

5. Risco: Sobrecarga na Equipe de Desenvolvimento

    Descrição: A equipe pode enfrentar dificuldades em cumprir os prazos devido a sobrecarga de trabalho ou falta de recursos adequados.
    Probabilidade: Média
    Impacto: Médio – Atrasos podem comprometer o cronograma do projeto e causar insatisfação com o cliente.
    Mitigação: Garantir que o cronograma seja realista e adequado ao tamanho da equipe. Acompanhamento constante das entregas e ajustes no planejamento, se necessário. Uso de ferramentas de gestão de projetos como Jira ou Trello.

6. Risco: Dificuldades com Validação e Testes

    Descrição: A falta de testes robustos pode resultar em bugs ou falhas não detectadas, afetando a qualidade do sistema após o lançamento.
    Probabilidade: Alta
    Impacto: Alto – Erros não detectados podem impactar negativamente a funcionalidade e usabilidade do sistema.
    Mitigação: Desenvolver um plano de testes abrangente, incluindo testes unitários com JUnit e testes de integração. Implementar uma equipe de QA para revisar e validar as funcionalidades antes do lançamento.

7. Risco: Atrasos na Entrega de Funcionalidades

    Descrição: O cronograma pode ser afetado por imprevistos, como dificuldade técnica ou necessidade de ajustes não previstos.
    Probabilidade: Média
    Impacto: Médio – O atraso na entrega de módulos críticos pode afetar o lançamento e a implementação do sistema.
    Mitigação: Realizar revisões constantes do progresso, identificar problemas cedo, e ajustar o cronograma conforme necessário. Atribuir prioridades claras para funcionalidades essenciais.

8. Risco: Mudanças nos Requisitos do Cliente

    Descrição: Requisitos podem mudar durante o desenvolvimento, levando a retrabalho ou necessidade de refazer funcionalidades.
    Probabilidade: Média
    Impacto: Médio – Mudanças inesperadas podem causar atrasos e aumentar os custos do projeto.
    Mitigação: Manter uma comunicação constante e clara com o cliente, definir claramente os requisitos antes do início do desenvolvimento e implementar gerenciamento de mudanças eficaz.

9. Risco: Dificuldade de Usabilidade para os Técnicos

    Descrição: O sistema pode ser complicado ou confuso para os técnicos de manutenção utilizarem, especialmente se a interface gráfica não for intuitiva.
    Probabilidade: Média
    Impacto: Alto – Se o sistema for difícil de usar, os técnicos podem cometer erros ou evitar seu uso, comprometendo a eficiência.
    Mitigação: Realizar testes de usabilidade com usuários finais durante o desenvolvimento. Incorporar feedback do cliente e dos técnicos para ajustar a interface.

10. Risco: Limitações de Performance em Operações Complexas

    Descrição: Operações complexas como a geração de relatórios detalhados ou o cálculo de MTTR e MTBF podem causar lentidão ou falhas no sistema.
    Probabilidade: Média
    Impacto: Médio – A geração lenta de relatórios ou cálculos incorretos podem reduzir a confiabilidade do sistema.
    Mitigação: Usar algoritmos otimizados para cálculos e técnicas como cacheamento. Implementar relatórios assíncronos para que os usuários não precisem esperar a conclusão das operações mais pesadas.

