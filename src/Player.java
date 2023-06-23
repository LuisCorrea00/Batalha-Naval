import java.util.Random;
import java.util.Scanner;

public class Player {

    String nome;
    char[][] map = new char[10][10];
    char[] coluna = {'A','B','C','D','E','F','G','H','I','J'};

    public void setName(String nome){ //define o nome do jogador
        this.nome = nome;
    }

    public void setAgua(){ //define os espacos para a agua
        for (int l = 0; l< map.length;l++){
            for (int c = 0; c< map[0].length;c++){
                if (map[l][c] != 'B'){
                    map[l][c] = '~';
                }
            }
        }
    }

    public boolean setNavio(int linha, int coluna, int posicao, int navio){ //define navio no mapa
        int colInicio = coluna;
        int linInicio = linha;
        for (int l=0, tamanho = 1; l<map.length; l++){
            for (int c=0; c<map[0].length;c++){
                if (l==linha && c==coluna){ //se a linha e coluna definidas pelo usuario coincidem
                    if (posicao == 1){ //se o usuario escolheu horizontal
                        if(colInicio+navio <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz 
//                                System.out.println(navio);
                                if (tamanho < navio) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
                                    coluna++;
                                    tamanho++;
                                }
                            }
                            else{
                                return false;
                            }
                        }
                        else{
                            return false; //se n tiver espaco encerra
                        }
                    }
                    else if (posicao == 2) { //se o usuario escolheu vertical
                        if(linInicio+navio <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
                                if (tamanho < navio) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
                                    linha++;
                                    tamanho++;
                                }
                            }
                            else{
                                return false;
                            }
                        }
                        else{
                            return false; //se n tiver espaco encerra
                        }
                    }
                }
            }
        }
        return true;
    }

    public void setMapRandom(){ // preenche aleatoriamente o mapa
        Random aleatorio = new Random();
        int navioGG = 1; //numero de barcos para atribuir
        int navioG = 2;
        int navioM = 3;
        int navioP = 4;
        do {
            if (navioGG!=0){ // se ainda tiver barcos disponiveis
                if (setNavio(aleatorio.nextInt(10), aleatorio.nextInt(10), aleatorio.nextInt(2)+1,4)){ // se a atribuicao do barco funcionar, retorna true
                    navioGG--; // diminui 1 barco dos disponiveis
                }
            }
            if (navioG!=0){
                if (setNavio(aleatorio.nextInt(10), aleatorio.nextInt(10), aleatorio.nextInt(2)+1,3)){
                    navioG--;
                }
            }
            if (navioM!=0){
                if (setNavio(aleatorio.nextInt(10), aleatorio.nextInt(10), aleatorio.nextInt(2)+1,2)){
                    navioM--;
                }
            }
            if (navioP!=0){
                if (setNavio(aleatorio.nextInt(10), aleatorio.nextInt(10), aleatorio.nextInt(2)+1,1)){
                    navioP--;
                }
            }
        }while (navioGG != 0 || navioG != 0 || navioM != 0 || navioP != 0); // enquanto ainda tiver barcos para atribuir

    }

    public void getMap(){ // imprime o mapa atualizado do jogador
        int count= 0; //contador para ver se tem todos os 20 barcos no mapa 
        for (int i = 0; i<coluna.length;i++){
            if (i==0) System.out.print("    "+coluna[i]+"   ");
            else System.out.print(coluna[i]+"   ");
        }
        System.out.println();
        for (int l = 0; l<map.length; l++){
            for (int c = 0; c<map[0].length;c++){
                if (c==0){
                    System.out.print(l + " | ");
                    System.out.print(map[l][c]+" | ");
                }
                else{
                    System.out.print(map[l][c]+" | ");
                }
                if (map[l][c] == 'B'){
                    count++;
                }
            }
            System.out.println();

        }
        System.out.println(count);
    }
    
    public void hideMap(){
        for (int i = 0; i<coluna.length;i++){
            if (i==0) System.out.print("    "+coluna[i]+"   ");
            else System.out.print(coluna[i]+"   ");
        }
        System.out.println();
        for (int l = 0; l<map.length; l++){
            for (int c = 0; c<map[0].length;c++){
                if (c==0){
                    System.out.print(l + " | ");
                }
                switch (map[l][c]) {
                    case 'X' -> System.out.print(map[l][c]+" | ");
                    case '*' -> System.out.print(map[l][c]+" | ");
                    default -> System.out.print("  | ");
                }
            }
            System.out.println();
        }
    }
    
    public void atacar(Player enemy) throws InterruptedException{
        boolean flagWin = false;
        int colunaSelec = 0;
        int countBarco = 0;
        Scanner ler = new Scanner(System.in);
                do{
                    System.out.println();
                    System.out.println("\t------ MAPA "+nome+ "------");
                    System.out.println("");
                    getMap();
                    System.out.println("\t------ MAPA "+enemy.nome+" ------");
                    enemy.hideMap();
                    System.out.println("");
                    System.out.println("ATACAR");
                    System.out.print("Linha: ");
                    int linha = ler.nextInt();
                    System.out.print("Coluna: ");
                    char colunaChar = ler.next().charAt(0);
                    colunaChar = Character.toUpperCase(colunaChar);
                    for (int i = 0; i<enemy.coluna.length;i++){
                        if (colunaChar == enemy.coluna[i]) colunaSelec = i;
                    }
                    for(int l = 0; l<enemy.map.length;l++){
                        for(int c = 0; c<enemy.map[0].length;c++){
                            if(l == linha && c == colunaSelec){
                                if(map[l][c] == '~'){
                                    map[l][c] = 'X';
                                    System.out.println("XXX "+nome+" acertou a água XXX");
                                    Thread.sleep(1000);
                                }
                                else if(map[l][c] == 'B'){
                                    map[l][c] = '*';
                                    System.out.println("*** "+nome+" acertou um barco ***");
                                    Thread.sleep(500);
                                    countBarco++;
                                    if(countBarco == 20){
                                       System.out.println("\t------ "+nome+" GANHOU O JOGO\t------"); 
                                       Thread.sleep(1000);
                                       flagWin = true;
                                    }
                                }
                            }
                            else System.out.println("Localização Inválida");
                            Thread.sleep(1000);
                        }
                    }
                    
                }while(!flagWin);
    }

    public void atacarRandom (Player enemy) throws InterruptedException{
        boolean flagWin = false;
        int countBarco = 0;
        Random aleatorio = new Random();
        int linha = aleatorio.nextInt(10);
        int colunaSelec = aleatorio.nextInt(10);
        for(int l = 0; l<enemy.map.length;l++){
            for(int c = 0; c<enemy.map[0].length;c++){           
                if(l == linha && c == colunaSelec){
                    if(map[l][c] == '~'){
                        map[l][c] = 'X';
                        System.out.println("XXX "+nome+" acertou a água XXX");
                        Thread.sleep(1000);
                    }
                    else if(map[l][c] == 'B'){
                        map[l][c] = '*';
                        System.out.println("*** "+nome+" acertou um barco ***");
                        Thread.sleep(500);
                        countBarco++;
                        if(countBarco == 20){
                            System.out.println("\t------ "+nome+" GANHOU O JOGO\t------"); 
                            Thread.sleep(1000);
                        }
                    }
                }
            }            
        }
    }
}