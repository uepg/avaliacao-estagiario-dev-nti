package desafiopoo.model.ave;

public class Pato extends Ave implements Voo{
    // atributos
    private boolean voando = false;
    
    // construtor
    public Pato(float peso, int qntPatas) {
        super(peso, qntPatas);
    }
    
    /**
     * implementação do metodo de voo da interface de voo.
     * @return 
     *  1 - se estiver no chão, começa o voo 
     *  2 - se estiver voando, avisa que já está voando
     */
    @Override
    public String voar() {
        if(!voando) {
            this.voando = true;
            return "Sou um pato e estou iniciando o meu voo.";
        } else {
            return "Já estou voando.";
        }
    }

    /**
     * implementação do metodo de pouso da interface de voo.
     * @return 
     *  1 - se estiver voando, pousa
     *  2 - se estiver no chão, avisa que não pode pousar pois já está no chão
     */
    @Override
    public String pousar() {
        if(voando) {
            this.voando = false;
            return "Sou um pato e acabei de pousar.";
        } else {
            return "Já estou no solo.";
        }
    }
    
}
