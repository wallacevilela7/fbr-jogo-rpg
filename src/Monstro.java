public class Monstro extends Personagem {

    private int qtdRegeneracaoVida;
    private String nomePoderEspecial;
    private double multiplicadorDanoEspecial;

    public Monstro(String nome,
                   int vida,
                   int ataque,
                   int defesa,
                   int qtdRegeneracaoVida,
                   String nomePoderEspecial,
                   double multiplicadorDanoEspecial) {
        super(nome, vida, ataque, defesa);
        this.qtdRegeneracaoVida = qtdRegeneracaoVida;
        this.nomePoderEspecial = nomePoderEspecial;
        this.multiplicadorDanoEspecial = multiplicadorDanoEspecial;
    }

    public void regenerarVida() {
        this.vida += qtdRegeneracaoVida;
    }

    @Override
    public void mostrarApresentacao() {
        System.out.println(this.nome + " (Vida: " + this.vida + ", " +
                "Ataque: " + this.ataque + ", " +
                "Defesa: " + this.defesa + ", " +
                "Regeneração de Vida: " + this.qtdRegeneracaoVida + ", " +
                "Poder Especial: " + this.nomePoderEspecial + ", "
        );
    }

    @Override
    public void usarAtaqueEspecial(Personagem alvo) {

    }
}
