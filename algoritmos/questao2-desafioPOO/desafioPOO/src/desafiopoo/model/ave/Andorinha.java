package desafiopoo.model.ave;

public class Andorinha extends Ave implements Voo{
    // atributo
    private boolean voando = false;
    
    // construtor
    public Andorinha(float peso, int qntPatas) {
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
            return "Sou uma andorinha e estou iniciando o meu voo.";
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
            return "Sou uma andorinha e acabei de pousar.";
        } else {
            return "Já estou no solo.";
        }
    }
    
}
