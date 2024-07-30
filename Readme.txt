1. Definição do Projeto

Projeto: Jogo da Memória

Descrição: Desenvolver um jogo da memória onde o jogador deve encontrar pares de cartas iguais. O sistema deve embaralhar as cartas no início, controlar o tempo e registrar a pontuação do jogador.

2. Elaboração do Escopo e Objetivos

Definir o Escopo do Projeto:

 Desenvolver uma aplicação web simples que permita jogar o jogo da memória.

Ferramentas:

    HTML para estruturar o jogo.
    CSS para estilizar as cartas e o tabuleiro.
    JavaScript para a lógica do jogo.

Objetivos SMART

Específicos:
O sistema deve permitir que o jogador encontre pares de cartas iguais. Cada par encontrado deve ser mantido virado até o final do jogo. O jogador deve ser capaz de iniciar uma nova partida a qualquer momento. Além disso, o sistema deve mostrar visualmente quando um par é encontrado e permitir que o jogador saiba quando ele venceu o jogo.

Mensuráveis:
O sistema deve ser capaz de registrar e exibir a pontuação do jogador, baseada no número de tentativas ou tempo gasto para encontrar todos os pares. O sistema também deve registrar o tempo de jogo e exibir um cronômetro que começa ao iniciar a partida e para quando todos os pares são encontrados.

Atingíveis:
O desenvolvimento do jogo utilizará tecnologias familiares como HTML, CSS e JavaScript, garantindo que a equipe de desenvolvimento consiga implementar as funcionalidades necessárias. As funcionalidades básicas devem ser implementadas de maneira incremental e testadas frequentemente para garantir a qualidade do código.

Relevantes:
O objetivo principal é proporcionar uma experiência de jogo desafiadora e divertida para os usuários. O jogo da memória é um ótimo exercício para a memória e concentração dos jogadores, tornando-se uma atividade relevante tanto para entretenimento quanto para benefícios cognitivos. Além disso, a interface do jogo deve ser amigável e intuitiva para garantir uma boa experiência do usuário.

Temporais:
Completar o protótipo funcional em 4 horas. O objetivo é ter uma versão jogável que permita ao usuário iniciar o jogo, virar cartas, encontrar pares, ver sua pontuação e tempo, e reiniciar o jogo.

3. Planejamento do Projeto

Cronograma:

    Primeira Hora: Configuração do ambiente e criação do layout das cartas em HTML e CSS.
    Segunda Hora: Desenvolvimento da lógica do jogo em JavaScript (embaralhar cartas, verificar pares).
    Terceira Hora: Implementação de funcionalidades adicionais (controle de tempo, pontuação).
    Quarta Hora: Testes e refinamento do design e funcionalidade.

Recursos:

    Computadores
    Ambiente de desenvolvimento integrado (IDE)
    Navegador web para testes

4. Análise de Riscos

Risco: Garantir que as cartas sejam corretamente embaralhadas no início do jogo. As cartas podem não ser embaralhadas corretamente, resultando em uma distribuição previsível.

Resposta: Testar o algoritmo de embaralhamento e garantir que ele realmente randomize a posição das cartas.

Risco: Manter o controle do estado do jogo (cartas viradas, pares encontrados, etc.). O estado do jogo pode ser corrompido se as variáveis não forem redefinidas corretamente após cada jogada.

Resposta: Utilize uma função para resetar as variáveis do jogo após cada tentativa.

Risco: Determinar corretamente quando o jogador encontrou todos os pares. O jogo pode não reconhecer a vitória corretamente.

Resposta: Manter um contador de pares encontrados e compare com o número total de pares.

Risco:  Verificar se duas cartas viradas são iguais. Cartas podem ser registradas como pares quando não são, ou não serem registradas quando são.

Resposta:  Verifique cuidadosamente as condições de comparação. Certifique-se de que a comparação de cartas considera o atributo correto

Risco: Tempo insuficiente para finalizar todas as funcionalidades

Resposta: Priorizar funcionalidades essenciais e, se necessário, ajustar o escopo.
5. Desenvolvimento Inicial

Iteração Ágil: Desenvolver um protótipo funcional que permita ao jogador iniciar e completar uma partida de jogo da memória, encontrando todos os pares de cartas.