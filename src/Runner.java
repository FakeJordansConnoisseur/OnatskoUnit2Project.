import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {

        int thing = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter to coordinate 1: ");
        String cord1 = scan.nextLine();
        System.out.print("Enter to coordinate 2: ");
        String cord2 = scan.nextLine();
        int par1 = cord1.indexOf("(");
        int par2 = cord1.indexOf(")");
        int space = cord1.indexOf(" ");
        int par3 = cord2.indexOf("(");
        int par4 = cord2.indexOf(")");
        int space2 = cord2.indexOf(" ");
        int x1 = Integer.parseInt(cord1.substring(par1+1,space-1));
        int y1 = Integer.parseInt(cord1.substring(space+1,par2));
        int x2 = Integer.parseInt(cord2.substring(par3+1,space2-1));
        int y2 = Integer.parseInt(cord2.substring(space2+1,par4));

        if (x1 == x2) {
            System.out.println("The line is vertical. "+ "x = " + x1);
            System.exit(0);
        }
        LinearEquation obj = new LinearEquation(x1,y1,x2,y2);
        System.out.println(obj.lineInfo());
        System.out.print("Please enter an x value to find the y value of: ");
        double storage = scan.nextDouble();
        System.out.println(obj.coordinateForX(storage));




    }
}

