import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file name and extension: ");
        String dir = scan.next();
        System.out.println("Enter number of columns to read: ");
        int len = scan.nextInt();
        System.out.println("Enter number of rows (horizontal): ");
        int rows = scan.nextInt();
        scan.close();

        File data = new File(dir);
        Scanner scan2 = new Scanner(data);
        scan2.useDelimiter(",");
        String[][] csvdata = new String[rows][len];

        int count = 0;
        while (scan2.hasNext() && count < len) {
            for (int i = 0; i < rows; i++) {
                csvdata[i][count] = scan2.next();
            }
            count += 1;
        }
        scan2.close();

        boolean headers = true;
        for (int i = 0; i < csvdata[rows-1].length; i++) {
            if (headers) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            System.out.print(csvdata[0][i] + " | ");
            System.out.print(csvdata[1][i] + " | ");
            System.out.print(csvdata[2][i] + " | ");
            System.out.print(csvdata[3][i]);
            if (headers) {
                System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                headers = false;
            }
        }
        
    }
}
