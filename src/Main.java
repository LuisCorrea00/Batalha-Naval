import java.util.Scanner;

public class Main {

    public static void alocarNavio(int disp, int tipoNavio, Player player) throws InterruptedException {
        boolean flagEnd = false;
        int coluna = 0;
        Scanner ler = new Scanner(System.in);
        do {
            if (disp!=0) { // verifica se ainda tem barcos disponiveis
                System.out.println();
                player.getMap();
                System.out.println("Escolha a localização do navio");
                System.out.print("Linha: ");
                int linha = ler.nextInt();
                System.out.print("Coluna: ");
                char colunaChar = ler.next().charAt(0);
                colunaChar = Character.toUpperCase(colunaChar);
                for (int i = 0; i<player.coluna.length;i++){
                    if (colunaChar == player.coluna[i]) coluna = i;
                }
                System.out.println("Escolha a posição do návio");
                System.out.println("Horizontal [1]  ||  Vertical [2]");
                System.out.print("Selecione: ");
                int posicao = ler.nextInt();
                if (player.setNavio(linha, coluna, posicao, tipoNavio)) { // se atribuir corretamente retorna true
                    flagEnd = true; // encerra o loop
                } else { // se houver algum erro retorna false e retoma o loop
                    System.out.println("Localização Inválida!!");
                    Thread.sleep(1000); // pausa o prompt
                }
            }
            else{
                System.out.println("Você não tem mais navios disponíveis!"); // se n houver barcos disponiveis retoma o loop
                flagEnd = true;
                Thread.sleep(1000); // pausa o prompt
            }
        }while (!flagEnd);
    }

    public static void posicionar(Player player) throws InterruptedException {
        Scanner ler = new Scanner(System.in);
        int navioGG = 1; //numero de barcos para atribuir
        int navioG = 2;
        int navioM = 3;
        int navioP = 4;
        System.out.println("\t------ "+player.nome+" ------\t");
        do {
            System.out.println();
            System.out.println("Escolha o tipo de navio para posicionar");
            System.out.println("Navio 4 espaços [4] || " + navioGG + " disponível[eis]");
            System.out.println("Navio 3 espaços [3] || " + navioG + " disponível[eis]");
            System.out.println("Navio 2 espaços [2] || " + navioM + " disponível[eis]");
            System.out.println("Navio 1 espaços [1] || " + navioP + " disponível[eis]");
            System.out.print("Selecione: ");
            int tipoNavio = ler.nextInt();
            switch (tipoNavio){
                case 4 ->{
                    alocarNavio(navioGG,tipoNavio,player);
                    if (navioGG != 0 ) navioGG--;
                }
                case 3 ->{
                    alocarNavio(navioG,tipoNavio,player);
                    if (navioG != 0 ) navioG--;
                }
                case 2 ->{
                    alocarNavio(navioM,tipoNavio,player);
                    if (navioM != 0 ) navioM--;
                }
                case 1 ->{
                    alocarNavio(navioP,tipoNavio,player);
                    if (navioP != 0 ) navioP--;
                }
                default -> System.out.println("opção Inválida!");
            }
        }while (navioGG != 0 || navioG != 0 || navioM != 0 || navioP != 0); // se nao houver mais barcos disponiveis encerra a atribuicao
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner ler = new Scanner(System.in);
        System.out.println("\t------ BATALHA NAVAL ------ ");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("Single-player [S]  ||  Multiplayer [M]");
        System.out.print("Selecione: ");
        char modo = ler.next().charAt(0);
        switch (modo){
            case 's','S' -> {
                System.out.println("\t------ MODO SINGLE-PLAYER ------ ");
                Player player1 = new Player(); //cria o jogador
                Player bot = new Player(); // cria o bot
                bot.setName("Bot");
                bot.setAgua(); // preenche os espaco de agua do bot
                bot.setMapRandom(); // preenche aleatorimante o mapa
                System.out.print("Informe seu nome: ");
                String nome = ler.next();
                player1.setName(nome);
                player1.setAgua(); // preenche os espaco de agua do jogador
                System.out.println("Escolha a forma de posicionar os navios");
                System.out.println("Manual [M]  ||  Automático [A]");
                System.out.print("Selecione: ");
                char opcao = ler.next().charAt(0);
                switch (opcao){
                    case 'm', 'M' -> posicionar(player1); // manualmente
                    case 'a','A' ->  player1.setMapRandom(); //define aleatoriamente o mapa do jogador
                }
                System.out.println("\t------ HORA DE ATACAR ------");
                do {
                    player1.atacar(bot);
                    bot.atacarRandom (player1);
                }while( !player1.atacar(bot) || !bot.atacarRandom (player1) );
            }
            case 'm','M' -> {
                System.out.println("\t------ MODO MULTIPLAYER ------ ");
                Player player1 = new Player(); //cria o jogador 1
                Player player2 = new Player(); // criar o jogador 2
                System.out.print("Informe o nome do jogador 1: ");
                String nome1 = ler.next();
                player1.setName(nome1);
                player1.setAgua();
                System.out.print("Informe o nome do jogador 2: ");
                String nome2 = ler.next();
                player2.setName(nome2);
                player2.setAgua();
                System.out.println("Escolha a forma de posicionar os navios");
                System.out.println("Manual [M]  ||  Automático [A]");
                System.out.print("Selecione: ");
                char opcao = ler.next().charAt(0);
                switch (opcao){
                    case 'm','M' ->{
                        posicionar(player1);
                        posicionar(player2);
                    }
                    case 'a','A' ->{
                        player1.setMapRandom();
                        player2.setMapRandom();
                    }
                }
                System.out.println("\t------ HORA DE ATACAR ------");
                do {
                    player1.atacar(player2);
                    player2.atacar(player1);
                }while( !player1.atacar(player2) || !player2.atacarRandom (player1) );
            }
            default -> System.out.println("opção Inválida!");
        }
    }

}