import java.util.Random;

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
                    map[l][c] = 'A';
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
                                System.out.println(navio);
                                System.out.println("x");
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
                if (setNavio(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2),4)){ // se a atribuicao do barco funcionar, retorna true
                    navioGG--; // diminui 1 barco dos disponiveis
                }
            }
            if (navioG!=0){
                if (setNavio(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2),3)){
                    navioG--;
                }
            }
            if (navioM!=0){
                if (setNavio(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2),2)){
                    navioM--;
                }
            }
            if (navioP!=0){
                if (setNavio(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2),1)){
                    navioP--;
                }
            }
        }while (navioGG != 0 || navioG != 0 || navioM != 0 || navioP != 0); // enquanto ainda tiver barcos para atribuir

    }

    public void getMap(){ // imprime o mapa atualizado do jogador
        int count= 0; //contador para ver se tem todos os 20 barcos no mapa || 🚨🚨 está atribuindo mais que 20 🚨🚨
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

}