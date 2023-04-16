# Questionário conceitual

Responda as questões neste mesmo arquivo.

1. Conhece GIT? Já o utilizou em algum projeto?
R = Sim, utilizei em meu projeto pessoal (website).

2. Qual a diferença entre GIT e GITHUB?
R = Git se refere ao versionamento de código de maneira local, ou seja, em sua própria máquina através de um console/prompt de comando, possibilitando a criação de repositórios.
Já o Github se refere ao local onde é armazenado o versionamento de código, criando repositórios com projetos de diversar magnitudes e com diversos propósitos diferentes disponíveis para todos os programadores.
No github é onde os programadores conseguem ter acesso ao projeto, incrementa-lo e aplicarem suas modificações de forma clara e transparente.

3. Conhece ou tem experiência com desenvolvimento Web? Descreva como se dá a requisição HTTP entre um cliente e o servidor, e como se dá a resposta.
R = Sim, a requisição HTTP consiste primeiramente no envio de uma requisição para o servidor, em seguida o servidor analisará e retornará com os dados solicitados. 
O envio de informações geralmente ocorrem via URL com o método GET, porém há casos que é necessário utilizar o método POST para realizar uma determianda tarefa, tal como envio e salvamento de formulários por exemplo. Também existem vários outros tipos de métodos disponíveis para diversas situações, tais como PUT, DELETE entre outros.
O recebimento de informações (HTTP Response) é recebido pelo usuário e interpretado pelo navegador. Na resposta, também haverá um status code, podendo ser os números 200, 201, 401 403, 404, 500, etc. Cada um com seu significado.

4. Conhece API REST? Para que são utilizadas? Cite dois exemplos.
R = Sim, São utilizadas para criar aplicações web cujo o requerimento de informações ocorre em um servidor específico e retorna as mesmas para a API. O termo Rest se refere as regras e boa práticas utilizadas na criação de API's.
API do Google Maps e API do Clima.

5. Conhece o conceito de AJAX? Descreva a tecnologia utilizada.
R = AJAX é um tipo diferente de interação entre cliente/servidor. Basicamente, o AJAX fará uma ligação com o script do servidor e o script do servidor fará uma requisição para o banco de dados. Na hora de retornar as informações, o script do servidor envia os dados para o usuário, ou seja, não é necessário que o usuário atualize a página para ver a nova informação, a página será atualizada em tempo real. O problema é que a aplicação fica um pouco mais lenta para carregar, pois muitas coisas precisam ser pré carregadas. Porém, a partir do momento que a aplicação for carregada, muitas funções ficarão mais rápidas e acessíveis ao usuário, resultando por fim, em uma melhor experiência do usuário (UX).
