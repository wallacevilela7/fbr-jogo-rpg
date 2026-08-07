import java.util.Scanner;

//TIP
// To
// <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1. Mostrar o menu principal
        Heroi guerreiro = new Heroi(
                "Guerreiro", 100, 20, 10,
                "1", 1, 1, "Escalibur Tunada"
        );

        Heroi mago = new Heroi(
                "Mago", 80, 25, 10,
                "2", 1, 2, "Vingardio Leverola"
        );

        Heroi arqueiro = new Heroi(
                "Arqueiro", 90, 18, 8,
                "1", 3, 1, "Flexada do Nightao"
        );

        apresentacaoHerois(guerreiro, mago, arqueiro);
        //2. Usuario seleciona o heroi
        int menuOpcaoEscolhida = sc.nextInt();
        Heroi heroiSelecionado = selecionarHeroi(menuOpcaoEscolhida, guerreiro, mago, arqueiro);


        //3. Mostrar o monstro
        Monstro dragao = new Monstro(
                "Dragao", 100, 15, 5,
                2, "Fireball", 0.2);
        dragao.mostrarApresentacao();
        boolean jogoAcabou = false;

        //4. Começar os turnos de combate
        do
        {
            //4.1 Solicitar acao do turno do heroi
            realizarTurnoHeroi(sc, heroiSelecionado, dragao);
            if(dragao.estaMorto()) {
                System.out.println("Você eliminou o Dragão! Parabéns!");
                jogoAcabou = true;
            }

            //4.2 Mostrar as vidas
            heroiSelecionado.mostrarVida();
            dragao.mostrarVida();

            //4.3 Executar o turno do monstro
            System.out.println("## TURNO DO DRAGÃO ##");
            dragao.regenerarVida();
            dragao.atacar(heroiSelecionado);

            //4.4 Mostrar as vidas
            heroiSelecionado.mostrarVida();
            dragao.mostrarVida();

            //4.5 Verificar as vidas e finalizar o jogo se necessario, senao voltar ao 4.1
            if(heroiSelecionado.estaMorto()) {
                System.out.println("Você morreu!");
                jogoAcabou = true;
            }

            if(dragao.estaMorto()) {
                System.out.println("Você eliminou o Dragão! Parabéns!");
                jogoAcabou = true;
            }
        } while (!jogoAcabou);
    }

    private static void realizarTurnoHeroi(Scanner sc, Heroi heroiSelecionado, Monstro dragao) {
        System.out.println("## SEU TURNO ##");
        System.out.println("1. Atacar / 2. Usar habilidade especial / 3. Usar poção de vida");

        int opcaoJogada = sc.nextInt();
        switch (opcaoJogada) {
            case 1:
                heroiSelecionado.atacar(dragao);
                break;
            case 2:
                heroiSelecionado.usarAtaqueEspecial(dragao);
                break;
            case 3:
                heroiSelecionado.usarPocaoVida();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static Heroi selecionarHeroi(int menuOpcaoEscolhida,
                                         Heroi guerreiro,
                                         Heroi mago,
                                         Heroi arqueiro) {
        return switch (menuOpcaoEscolhida) {
            case 1 ->
                    guerreiro;
            case 2 ->
                    mago;
            case 3 ->
                    arqueiro;
            default ->
                    null;
        };
    }

    private static void apresentacaoHerois(Heroi guerreiro, Heroi mago, Heroi arqueiro) {
        System.out.println("Heróis Disponíveis: ");
        System.out.print("1 - ");
        guerreiro.mostrarApresentacao();

        System.out.print("2 - ");
        mago.mostrarApresentacao();

        System.out.print("3 - ");
        arqueiro.mostrarApresentacao();
        System.out.println("Escolha o seu herói: ");
    }
}