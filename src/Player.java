import java.util.Random;

public class Player {

    String nome;
    char[][] map = new char[10][10];

    public void setName(String nome){
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

    public boolean setNavioGG(int linha, int coluna, int posicao){ //define navio de 4 espacos
        for (int l=0, tamanho = 1; l<map.length; l++){
            for (int c=0; c<map[0].length;c++){
                if (l==linha && c==coluna){ //se a linha e coluna definidas pelo usuario coincidem
                    if (posicao == 1){ //se o usuario escolheu horizontal
                        if(coluna+3 <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
                                if (tamanho < 4) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
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
                        if(linha+3 <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
                                if (tamanho < 4) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
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

    public boolean setNavioG(int linha, int coluna, int posicao){
        for (int l=0, tamanho = 1; l<map.length; l++){
            for (int c=0; c<map[0].length;c++){
                if (l==linha && c==coluna){ //se a linha e coluna definidas pelo usuario coincidem
                    if (posicao == 1){ //se o usuario escolheu horizontal
                        if(coluna+2 <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
                                if (tamanho < 3) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
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
                        if(linha+2 <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') {
                                map[l][c] = 'B'; //define o navio na matriz
                                if (tamanho < 3) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
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

    public boolean setNavioM(int linha, int coluna, int posicao){
        for (int l=0, tamanho = 1; l<map.length; l++){
            for (int c=0; c<map[0].length;c++){
                if (l==linha && c==coluna){ //se a linha e coluna definidas pelo usuario coincidem
                    if (posicao == 1){ //se o usuario escolheu horizontal
                        if(coluna+1 <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
                                if (tamanho < 2) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
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
                        if(linha+1 <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
                                if (tamanho < 2) { //verifica se ainda deve definir o navio no mapa dependendo do tamanho dele
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

    public boolean setNavioP(int linha, int coluna, int posicao){
        for (int l=0; l<map.length; l++){
            for (int c=0; c<map[0].length;c++){
                if (l==linha && c==coluna){ //se a linha e coluna definidas pelo usuario coincidem
                    if (posicao == 1){ //se o usuario escolheu horizontal
                        if(coluna <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
                            }
                            else{
                                return false;
                            }
                        }
                        else{
                            return false; //se n tiver espaco encerra
                        }
                    }
                    else if (posicao == 2) { //se o usuario  escolheu vertical
                        if(linha <= map.length){ //verifica se tem espaco para alocar o navio na matriz
                            if (map[l][c] != 'B') { //verifica se tem um navio ocupando o espaco
                                map[l][c] = 'B'; //define o navio na matriz
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

    public void setMapRandom(){
        Random aleatorio = new Random();
        int navioGG = 1;
        int navioG = 2;
        int navioM = 3;
        int navioP = 4;
        do {
            if (navioGG!=0){
                if (setNavioGG(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2))){
                    navioGG--;
                }
            }
            if (navioG!=0){
                if (setNavioG(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2))){
                    navioG--;
                }
            }
            if (navioM!=0){
                if (setNavioM(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2))){
                    navioM--;
                }
            }
            if (navioP!=0){
                if (setNavioP(aleatorio.nextInt(1,9), aleatorio.nextInt(1,9), aleatorio.nextInt(1,2))){
                    navioP--;
                }
            }
        }while (navioGG != 0 || navioG != 0 || navioM != 0 || navioP != 0);

    }

    public void getMap(){
        System.out.println("    0   1   2   3   4   5   6   7   8   9  ");
        int count= 0;
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
