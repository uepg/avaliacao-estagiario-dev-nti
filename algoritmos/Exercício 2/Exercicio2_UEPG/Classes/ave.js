/*Escreva um programa orientado à objetos onde uma classe Animal é super classe de Mamifero e Ave. Cao, Gato, Elefante e Cavalo são subclasses de Mamifero, sendo Andorinha, Pato e Galinha de Ave. Todos os animais têm peso e quantidade de patas. Todos os animais possuem as ações de andar e comer. Elefante possui uma maneira de comer diferente dos demais. Os cães possuem a ação de atacar. Andorinhas e patos implementam uma interface para o vôo. Animais, mamíferos e aves não podem existir, somente seus objetos concretos. */
class Ave extends Animal{
    constructor(peso, patas){
        super(peso, patas);
    }

    andar () {
        return super.andar();
    }

    comer () {
        return super.comer();
    }

}