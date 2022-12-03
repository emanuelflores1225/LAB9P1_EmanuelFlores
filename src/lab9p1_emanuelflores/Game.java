package lab9p1_emanuelflores;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static lab9p1_emanuelflores.LAB9P1_EmanuelFlores.random;

public class Game {
    //llama al original y la mejora
    public int[][] tablero = random();    
    public int[][] gen = tablero;
    //principales
    public int[][] jugar(int x){        
        gen = tablero;
        for(int i = 0; i <  x-1; i++){
            gen = nextGen();
            
            //print();
        }
        return gen;
    }    
    public int[][] nextGen(){
        int [][] futuro = new int [10][10];
        for(int i = 1; i < 9;i++){
            for(int j = 1; j < 9; j++){
                int vivo = 0;
                for (int l = -1; l <= 1; l++){
                    for (int m = -1; m <= 1; m++){
                        if (tablero[i+l][j+m]==1){
                            vivo++;
                        }
                    }
                }
                vivo -= tablero[i][j];
                if (tablero[i][j] == 1 && vivo < 2){
                    futuro[i][j] = 0;
                }
                else if (tablero[i][j] == 1 && (vivo > 3)){
                    futuro[i][j] = 1;
                }
                else if (tablero[i][j] == 1 && (vivo == 2)){
                    futuro[i][j] = 1;
                }
                else if (futuro[i][j] == 0 && (vivo == 3)){
                    futuro[i][j] = 1;
                }
                else {
                    //System.out.print("[1]");
                    futuro[i][j] = tablero[i][j];
                }
            }              
        }
        int[][] temp = tablero;
        tablero = futuro;
        futuro = temp;
        return tablero;
    }   
    public void print (int [][] life){
        this.gen = life;
        ArrayList<String> CO = new ArrayList<>();        
        String x = "";
        String y = "";
        for(int i = 0; i < life.length;i++){
            for(int j = 0; j < life[0].length; j++){
                if ( gen[i][j] == 1 ){
                    x = String.valueOf(i);
                    y = String.valueOf(j);
                    CO.add(x + ":" + y);  
                }       
            }
        }
        for(int i = 0; i < CO.size();i++){
            String[] array = CO.get(i).split(":", 1);
            System.out.print(Arrays.toString(array));
            //System.out.println("");
        } 
        System.out.println("");
    }
    //sets y gets
    public void Settablero(int[][] matriz){
         this.tablero = matriz;
    }
    public int[][] Gettablero() {
        return tablero;
    }
    public int[][] Getnext(){        
        return nextGen();
    }
    //imprimir el original y su contorno
    public String imprimir(int[][] matrix) {
        String cadena = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cadena += "[" + matrix[i][j] + "]" + " ";
            }
            cadena += "\n";
        }

        return cadena;
    }    
    
}
