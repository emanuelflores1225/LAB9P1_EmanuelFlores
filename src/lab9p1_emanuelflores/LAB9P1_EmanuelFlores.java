package lab9p1_emanuelflores;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LAB9P1_EmanuelFlores {
    public static Scanner leer = new Scanner(System.in);
    public static Random random = new Random();
    static Game M = new Game();
    public static void main(String[] args) {        
        int opcion;
        do{
            opcion = tabla();                                   
            switch (opcion){
                case 1->{
                    System.out.println("Bienvenid@ a Game of Life: " 
                            + "\nIngrese el numero de rondas: ");  
                    M.Settablero(random());
                    int rounds = leer.nextInt();   
                    M.print(M.Gettablero());//imprime las coordenadas
                    System.out.print(M.imprimir(M.Gettablero()));//imprime el tablero                    
                    System.out.println();
                    for(int i = 0; i < rounds;i++){
                        M.print(M.Getnext());//imprime las coordenadas
                        System.out.println(M.imprimir(M.Getnext()));//imprime el tablero
                                               
                    }                  
                    break;
                }
                
                case 2->{
                    System.out.println("Saliendo......");
                    break;
                }
            }
        }while(opcion != 2);
    }
    //tabla para elegir la opcion
    public static int tabla(){
        int opcion;
        System.out.println("Titulo \n1. Game of Life \n2. Saliendo");
        opcion = leer.nextInt();
        return opcion;
    } 
    //se crea la tabla con 0 y 1 con el borde lleno de 0
    public static int[][] random (){
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = random.nextInt(2);
            }
        }
        grid = Contorno(grid);
        return grid;
    }
    public static int[][] Contorno(int[][] datos) {
        int[][] temporal = new int[datos.length][datos[0].length];
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                if (i == 0 || j == 0 || i == datos.length - 1 || j == datos[1].length - 1) {
                    temporal[i][j] = 0;
                } else {
                    temporal[i][j] = datos[i][j];
                }
            }

        }
        return temporal;
    }
}
