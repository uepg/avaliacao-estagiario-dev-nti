
# Algoritmos

Organize a resolução de cada uma das questões em uma pasta separada dentro da pasta `algoritmos`, cada pasta deve ter o nome com o número da questão que resolve. Dentro da pasta é obrigatória a existência de um arquivo `README.md` que descreva a linguagem utilizada e o grau de dificuldade que teve para resolver a questão, se precisou de pesquisa, etc.

Se possível resolva orientado a objetos.

Siga as orientações da página principal deste repositório em relação à tecnologia/linguagens que deve/pode utilizar para resolver estas questões.

*** Desafio de sistema simples comercial ***

1. Escreva um sistema que implemente a tela de venda e registre os dados de acordo com as regras de desconto para o cenário a seguir:

Um determinado comércio possui uma base de produtos com a seguinte estrutura:
  - Código
  - Nome
  - Valor unitário
  - Desconto por quantidade
    - acima de 10 - 5%
    - acima de 20 - 10%
    - acima de 30 - 20%
    
  É necessário gravar o registro de cada venda realizada para seus clientes, com os seguintes dados:
  - Número da venda
  - Data e hora
  - Itens vendidos com 
    - produto
    - qtde
    - vlr total de venda
  
    
  
*** Desafio de programação orientada a objetos ***

2. Escreva um programa orientado à objetos onde uma classe `Animal` é super classe de `Mamifero` e `Ave`. `Cao`, `Gato`, `Elefante` e `Cavalo` são subclasses de `Mamifero`, sendo `Andorinha`, `Pato` e `Galinha` de `Ave`. Todos os animais têm peso e quantidade de patas. Todos os animais possuem as ações de andar e comer. Elefante possui uma maneira de comer diferente dos demais. Os cães possuem a ação de atacar. Andorinhas e patos implementam uma interface para o vôo. Animais, mamíferos e aves não podem existir, somente seus objetos concretos.

Escreva uma classe que simule a execução de cada uma das ações, as ações podem apenas imprimir uma sáida em tela, por exemplo "Sou um cão e estou comendo".
