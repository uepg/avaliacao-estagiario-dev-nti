#include <iostream>

namespace std
{
    template <typename T>
    T max(T &x, T &y)
    {
        if (y < x)
            return x;
        return y;
    }
}

class Animal
{
public:
    Animal(float peso, int qtd_patas, std::string nome_animal)
    {
        this->nome_animal = nome_animal;
        this->peso = peso;
        this->qtd_patas = qtd_patas;
    }

    virtual void set_peso(float peso) = 0;
    virtual float get_peso() = 0;

    virtual void set_qtd_patas(int qtd_patas) = 0;
    virtual int get_qtd_patas() = 0;

    std::string get_nome_animal()
    {
        return this->nome_animal;
    }

    void andar()
    {
        std::cout << "Sou " + this->nome_animal + " e estou andando" << std::endl;
    }
    void comer()
    {
        std::cout << "Sou " + this->nome_animal + " e estou comendo" << std::endl;
    }

protected:
    float peso;
    int qtd_patas;
    std::string nome_animal;
};
class Voo
{
public:
    virtual void voar() = 0;
    virtual void pousar() = 0;
};

// Especialização de animal
class Mamifero : public Animal
{
public:
    Mamifero(float peso, int qtd_patas, std::string nome_animal) : Animal(peso, qtd_patas, nome_animal) {}

    void set_peso(float peso)
    {
        this->peso = peso;
    }
    float get_peso()
    {
        return this->peso;
    }

    void set_qtd_patas(int qtd_patas)
    {
        this->qtd_patas = qtd_patas;
    }
    int get_qtd_patas()
    {
        return this->qtd_patas;
    }
};
class Ave : public Animal
{
public:
    Ave(float peso, int qtd_patas, std::string nome_animal) : Animal(peso, qtd_patas, nome_animal) {}

    void set_peso(float peso)
    {
        this->peso = peso;
    }
    float get_peso()
    {
        return this->peso;
    }

    void set_qtd_patas(int qtd_patas)
    {
        this->qtd_patas = qtd_patas;
    }
    int get_qtd_patas()
    {
        return this->qtd_patas;
    }
};

// Especialização de mamifero
class Cao : public Mamifero
{
public:
    Cao(float peso) : Mamifero(peso, 4, "um cão") {}
    
    void atacar()
    {
        std::cout << "O cão está atacando" << std::endl;
    }
};

class Gato : public Mamifero
{
public:
    Gato(float peso) : Mamifero(peso, 4, "um gato") {}
};

class Elefante : public Mamifero
{
public:
    Elefante(float peso) : Mamifero(peso, 4, "um elefante") {}

    void comer()
    {
        std::cout << "Sou" << this->nome_animal << " e estou comendo levando o alimento com a tromba" << std::endl;
    }
};

class Cavalo : public Mamifero
{
public:
    Cavalo(float peso) : Mamifero(peso, 4, "um cavalo") {}
};

// Especialização de ave
class Andorinha : public Ave, public Voo
{
public:
    Andorinha(float peso) : Ave(peso, 2, "uma andorinha") {}

    void voar()
    {
        std::cout << "Sou " + this->nome_animal << " e estou voando" << std::endl;
    }
    void pousar()
    {
        std::cout << "Sou " + this->nome_animal << " e estou pousando" << std::endl;
    }
};

class Pato : public Ave, public Voo
{
public:
    Pato(float peso) : Ave(peso, 2, "um pato") {}

    void voar()
    {
        std::cout << "Sou " + this->nome_animal << " e estou voando" << std::endl;
    }
    void pousar()
    {
        std::cout << "Sou " + this->nome_animal << " e estou pousando" << std::endl;
    }
};

class Galinha : public Ave
{
public:
    Galinha(float peso) : Ave(peso, 2, "uma galinha") {}
};

template <class T>
void executar_comandos_basicos(T x)
{
    std::cout << "Foi criado " + x.get_nome_animal() << ", ele possui " << x.get_qtd_patas() << " patas e pesa " << x.get_peso() << "kg" << std::endl;
    x.andar();
    x.comer();
}

int main()
{
    std::cout << "\tApresentação dos mamiferos" << std::endl;
    Cao cao(4.5f);
    executar_comandos_basicos(cao);
    /* metodo atacar */
    cao.atacar();
    std::cout << std::endl;

    Gato gato(2.6f);
    executar_comandos_basicos(gato);
    std::cout << std::endl;

    Elefante elefante(4000.0f);
    executar_comandos_basicos(elefante);
    std::cout << std::endl;

    Cavalo cavalo(4000.0f);
    executar_comandos_basicos(cavalo);
    std::cout << std::endl;

    std::cout << "\tApresentação das aves" << std::endl;
    Andorinha andorinha(3.4f);
    executar_comandos_basicos(andorinha);
    andorinha.voar();
    andorinha.pousar();
    std::cout << std::endl;

    Pato pato(3.4f);
    executar_comandos_basicos(pato);
    pato.voar();
    pato.pousar();
    std::cout << std::endl;

    Galinha galinha(3.4f);
    executar_comandos_basicos(galinha);
    std::cout << std::endl;

    std::cout << "Todos os animais criados foram apresentados" << std::endl;
}