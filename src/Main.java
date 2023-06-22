import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner ler = new Scanner(System.in);
        System.out.println("------ BATALHA NAVAL ------ ");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("Single player [S]  ||  Multiplayer [M]");
        System.out.print("Selecione: ");
        char modo = ler.next().charAt(0);
        switch (modo){
            case 's','S' -> {
                int navioGG = 1; //numero de barcos para atribuir
                int navioG = 2;
                int navioM = 3;
                int navioP = 4;
                int linha, coluna, posicao;
                int flagEnd; // flag para parar de repetir o laço
                System.out.println("------ MODO SINGLE PLAYER ------ ");
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
                System.out.println("Selecione: ");
                int opcao = ler.next().charAt(0);
                switch (opcao){
                    case 'm', 'M' ->{
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
                                    flagEnd = 0;
                                    do {
                                        if (navioGG!=0) { // verifica se ainda tem barcos disponiveis
                                            System.out.println();
                                            System.out.println("Escolha a localização do navio");
                                            player1.getMap();
                                            System.out.print("Linha: ");
                                            linha = ler.nextInt();
                                            System.out.print("Coluna: ");
                                            coluna = ler.nextInt();
                                            System.out.println("Escolha a posição do návio");
                                            System.out.println("Horizontal [1]  ||  Vertical [2]");
                                            System.out.print("Selecione: ");
                                            posicao = ler.nextInt();
                                            if (player1.setNavioGG(linha, coluna, posicao)) { // se atribuir corretamente retorna true
                                                navioGG--; // diminui os barcos disponiveis
                                                flagEnd = 1; // encerra o loop
                                            } else { // se houver algum erro retorna false e retoma o loop
                                                System.out.println("Localização Inválida!!");
                                                Thread.sleep(1000); // pausa o prompt
                                            }
                                        }
                                        else{
                                            System.out.println("Você não tem mais navios disponíveis!"); // se n houver barcos disponiveis retoma o loop
                                            flagEnd = 1;
                                            Thread.sleep(1000); // pausa o prompt
                                        }
                                    }while (flagEnd == 0);
                                }
                                case 3 ->{
                                    flagEnd = 0;
                                    do {
                                        if (navioG!=0) {
                                            System.out.println();
                                            System.out.println("Escolha a localização do navio");
                                            player1.getMap();
                                            System.out.print("Linha: ");
                                            linha = ler.nextInt();
                                            System.out.print("Coluna: ");
                                            coluna = ler.nextInt();
                                            System.out.println("Escolha a posição do návio");
                                            System.out.println("Horizontal [1]  ||  Vertical [2]");
                                            System.out.print("Selecione: ");
                                            posicao = ler.nextInt();
                                            if (player1.setNavioG(linha, coluna, posicao)) {
                                                navioG--;
                                                flagEnd = 1;
                                            } else {
                                                System.out.println("Localização Inválida!!");
                                                Thread.sleep(1000);
                                            }
                                        }
                                        else{
                                            System.out.println("Você não tem mais navios disponíveis!");
                                            flagEnd = 1;
                                            Thread.sleep(1000);
                                        }
                                    }while (flagEnd == 0);
                                }
                                case 2 ->{
                                    flagEnd = 0;
                                    do {
                                        if (navioM!=0) {
                                            System.out.println();
                                            System.out.println("Escolha a localização do navio");
                                            player1.getMap();
                                            System.out.print("Linha: ");
                                            linha = ler.nextInt();
                                            System.out.print("Coluna: ");
                                            coluna = ler.nextInt();
                                            System.out.println("Escolha a posição do návio");
                                            System.out.println("Horizontal [1]  ||  Vertical [2]");
                                            System.out.print("Selecione: ");
                                            posicao = ler.nextInt();
                                            if (player1.setNavioM(linha, coluna, posicao)) {
                                                navioM--;
                                                flagEnd = 1;
                                            } else {
                                                System.out.println("Localização Inválida!!");
                                                Thread.sleep(1000);
                                            }
                                        }
                                        else{
                                            System.out.println("Você não tem mais navios disponíveis!");
                                            flagEnd = 1;
                                            Thread.sleep(1000);
                                        }
                                    }while (flagEnd == 0);
                                }
                                case 1 ->{
                                    flagEnd = 0;
                                    do {
                                        if (navioP!=0) {
                                            System.out.println();
                                            System.out.println("Escolha a localização do navio");
                                            player1.getMap();
                                            System.out.print("Linha: ");
                                            linha = ler.nextInt();
                                            System.out.print("Coluna: ");
                                            coluna = ler.nextInt();
                                            System.out.println("Escolha a posição do návio");
                                            System.out.println("Horizontal [1]  ||  Vertical [2]");
                                            System.out.print("Selecione: ");
                                            posicao = ler.nextInt();
                                            if (player1.setNavioP(linha, coluna, posicao)) {
                                                navioP--;
                                                flagEnd = 1;
                                            } else {
                                                System.out.println("Localização Inválida!!");
                                                Thread.sleep(1000);
                                            }
                                        }
                                        else{
                                            System.out.println("Você não tem mais navios disponíveis!");
                                            flagEnd = 1;
                                            Thread.sleep(1000);
                                        }
                                    }while (flagEnd == 0);
                                }
                                default -> System.out.println("opção Inválida!");
                            }
                        }while (navioGG != 0 || navioG != 0 || navioM != 0 || navioP != 0); // se nao houver mais barcos disponiveis encerra a atribuicao
                        bot.getMap(); // provisorio
                    }
                    case 'a','A' -> {
                        player1.setMapRandom(); //define aleatoriamente o mapa do jogador
                        player1.getMap(); // provisorio
                        bot.getMap(); // provisorio
                    }
                }

            }
            case 'm','M' -> {

            }
            default -> System.out.println("opção Inválida!");
        }
    }
}