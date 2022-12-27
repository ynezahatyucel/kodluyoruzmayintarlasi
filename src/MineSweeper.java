import java.util.Scanner;
import  java.util.Random;

public class MineSweeper {
    int rowNumber,colNumber,size;
    int[][] map;
    int[][] board;
    boolean game=true;

    Random rand= new Random();
    Scanner scan=new Scanner(System.in);

    MineSweeper(int rowNumber ,int colNumber){
        this.rowNumber=rowNumber;
        this.colNumber=colNumber;
        this.map=new int[rowNumber][colNumber];
        this.board=new int[rowNumber][colNumber];
        this.size=colNumber*rowNumber;


    }
    public void run(){
        int col,row,success=0;
        preperaGame();
        print(map);

        while (game){
            print(board);
            System.out.print("Satır : ");
            row=scan.nextInt();
            System.out.print("Sütun : ");
            col=scan.nextInt();
            if (row<0||row>=rowNumber){
                System.out.println("Geçersiz Kordinat.");
                continue;
            }
            if (col<0||col>=colNumber){
                System.out.println("Geçersiz Kordinat.");
                continue;
            }
            if (map[row][col]!=-1){
                check(row,col);
                success++;
                if (success==size-size/4){
                    System.out.println("Başardınız. Hiç bir mayına basmadınız..");
                    break;
                }
            }else {
                game=false;
                System.out.println("Mayına bastınız !! Oyunu kaybettiniz.");
                break;
            }
        }
    }
    public void check(int r ,int c) {
        if (map[r][c] == 0) {
            if (c<colNumber-1 && map[r][c + 1] == -1) {
                board[r][c]++;
            }
            if (map[r+1][c +1]==-1) {
                board[r][c]++;
            }
            if (r< rowNumber-1&& map[r + 1][c] == -1) {
                board[r][c]++;
            }
            if (map[r+1][c-1]==-1) {
                board[r][c]++;
            }
            if (r>0 &&map[r - 1][c] == -1) {
                board[r][c]++;
            }
            if (map[r-1][c+1]==-1) {
                board[r][c]++;
            }
            if (c>0&&map[r][c - 1] == -1) {
                board[r][c]++;
            }
            if (map[r-1][c-1]==-1) {
                board[r][c]++;
            }
            if (board[r][c]==0){
                board[r][c]=-2;
            }
        }
    }
    public void preperaGame(){
        int randrow,randcol,count=0;
        while (count != size/4){
            randrow=rand.nextInt(rowNumber);
            randcol=rand.nextInt(colNumber);
            if (map[randcol][randrow]!=-1){
                map[randcol][randrow]=-1;
                count++;
            }
        }
    }
    public void print(int [][] arr){
        for (int i=0; i<arr.length;i++) {
            for (int k = 0; k < arr[0].length; k++) {
                if (arr[i][k]>= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }


    }


}
