# Questionário conceitual

Responda as questões neste mesmo arquivo.

1. Conhece GIT? Já o utilizou em algum projeto?
Sim, conheço a algum tempo. Já utilizei em alguns projetos passados.

2. Qual a diferença entre GIT e GITHUB?
GIT é uma ferramenta de versionamento do projeto/código, amplamente utilizado por desenvolvedores, na maioria dos casos para ter uma garantia de funcionamento antes de fazer alguma alteração no projeto que poderia resultar em erros ou simplesmente para registrar alterações no código. GitHub é uma aplicação WEB que serve como repostirório remoto para esses versionamentos de código, um site para hospedagem de códigos versionados que utiliza da ferramenta GIT.

3. Conhece ou tem experiência com desenvolvimento Web? Descreva como se dá a requisição HTTP entre um cliente e o servidor, e como se dá a resposta.
Tenho alguma experiência com desenvolvimento Web.
A requisição/request entre um cliente e servidor acontece da seguinte forma: vamos supor que um cliente (usuário) de um site deseja logar na sua nova conta, ao preencher todas as informações necessárias para o login e dar um "submit" dessas informações, esse request é enviado ao servidor hospedeiro do site através do protocolo de transferência HTTP, o servidor verifica a validade dessas informações e se caso não ocorra nenhuma discrepancia entre as informações cadastradas e as informadas, o servidor retorna uma "response" para o cliente.

Basicamente 
Página HTML do cliente --> HTTP --> Servidor
Código PHP, javascript, etc do servidor --> HTTP --> Página html do cliente.

4. Conhece API REST? Para que são utilizadas? Cite dois exemplos.
Conheço um pouco, API REST é uma interface que estabelece comunicação entre aplicações, por exemplo, um site de e-commerce em que é necessário realizar um pagamento online por uma outra aplicação que serve como intermediadora de pagamentos, ou seja, se torna necessário as duas aplicações comunicar-se entre si de uma forma rápida porém segura. Outro exemplo quando em um site precisa-se de informações de uma outra aplicação sem que seja preciso sair da URL original, como em redes sociais, em que alguns casos específicos precisam puxar informações de um outro site. 

5. Conhece o conceito de AJAX? Descreva a tecnologia utilizada.

AJAX é uma "junção" de Javascript com XML, serve para se comunicar com scripts de um servidor enviando e recebendo informações, por agir de forma assíncrona ele atualiza somente parte de uma página sem ter que recarrega-la inteiramente.
