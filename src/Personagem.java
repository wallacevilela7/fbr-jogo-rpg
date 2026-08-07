public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public void atacar(Personagem alvo) {
        alvo.receberDano(ataque);
    }

    public void receberDano(int dano) {
        //todo: realizar lógica de defesa com 50% de chance de ativar
        vida -= dano;
    }

    public boolean estaMorto() {
        return vida <= 0;
    }

    public String getNome() {
        return this.nome;
    }

    public void mostrarVida() {
        System.out.println(this.nome + "(Vida " + ": " + this.vida + ")");
    }

    public abstract void mostrarApresentacao();

    public abstract void usarAtaqueEspecial(Personagem alvo);

    protected boolean executarJogadaEspecial() {
        var umOuDois = Math.round(1 + Math.random());
        return umOuDois == 1 ? true : false;
    }
}
