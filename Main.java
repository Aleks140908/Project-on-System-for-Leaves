import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void showMenu(){
        System.out.println("1. STATE LEAVE ");
        System.out.println("2. LOOK AT LEAVES ");
        System.out.println("3. LOOK AT LEAVES FOR AN EMPLOYEE ");
        System.out.println("4. CHANGE STATUS FOR LEAVE ");
        System.out.println("5. EXIT ");
    }
    //2 state leave
    public static void showFirstOption(){
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER NAME:");
        String name = scan.nextLine();

        Scanner scan1 = new Scanner(System.in);
        System.out.println("ENTER EMAIL:");
        String email = scan1.nextLine();

        Scanner scan2 = new Scanner(System.in);
        System.out.println("ENTER IDENTIFICATION NUMBER: ");
        int idNumber = scan2.nextInt();

        Scanner scan3 = new Scanner(System.in);
        System.out.println("ENTER BEGINNING OF LEAVE: ");
        double beginDate = scan3.nextInt();

        Scanner scan4 = new Scanner(System.in);
        System.out.println("ENTER END DATE OF LEAVE: ");
        double endDate= scan4.nextInt();

        Scanner scan5 = new Scanner(System.in);
        System.out.println("ENTER PAID OR UNPAID IS THE LEAVE: ");
        String paidOrUnpaid = scan.nextLine();

    }
    //3 look at leaves
    public static void showSecondOption(){

    }
    //4 look at employee leaves
    public static void showThirdOption(){

    }
    //5 change status for leave
    public static void showFourthOption(){

    }
    public static void main(String[] args) {
        showMenu();
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
        int num = scan.nextInt();

        if(num==1){
            showFirstOption();
        }else if(num==2){
            showSecondOption();
        } else if(num==3) {
            showThirdOption();
        }else if(num==4){
            showFourthOption();
        }else if(num==5){
            showMenu();
        }else{
            System.out.println("!INVALID OPTION! PICK ANOTHER ONE");
            showMenu();
        }
    }
}