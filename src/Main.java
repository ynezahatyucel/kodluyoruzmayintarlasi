import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int row,column;
        System.out.println("Mayın Tarlasına Hoşgeldiniz ");
        System.out.println("Lütfen Oynamak İstediğiniz Ölçüleri Giriniz :");
        System.out.println("Satır Sayısı : ");
        row=scan.nextInt();
        System.out.println("Sütün Sayısı : ");
        column=scan.nextInt();

        MineSweeper mSweep=new MineSweeper(row,column);
        mSweep.run();








    }
}