import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        try{


            //Name!!!
            Scanner scanName = new Scanner(System.in);
            System.out.println("ENTER NAME:");
            String name = scanName.nextLine();
            for (char c : name.toCharArray()) {
                // Check if the character is a number
                if (Character.isDigit(c)) {
                    System.out.println("ERROR!There is a number in the name.");
                    showMenu();
                    scanNumber();
                    Scanner scan = new Scanner(System.in);
                    System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
                    int num = scan.nextInt();
                    checkOption(num);
                }else{
                    break;
                }
            }


            //Email!!!
            Scanner scanEmail = new Scanner(System.in);
            System.out.println("ENTER EMAIL:");
            String email = scanEmail.nextLine();


            //ID!!
            Scanner scanIdNum = new Scanner(System.in);
            System.out.println("ENTER IDENTIFICATION NUMBER: ");
            int idNumber = scanIdNum.nextInt();


            //Date Of Beginning!!!
            Scanner scannerForDateOfBeginning = new Scanner(System.in);
            System.out.println("Enter a date (yyyy-MM-dd): ");
            String userInputForBeginningDate = scannerForDateOfBeginning.nextLine();
            // To parse the users input
            DateTimeFormatter formatterForBeginningDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");


            //Date Of End!!!
            Scanner scannerForDateOfEnd = new Scanner(System.in);
            System.out.println("Enter a date (yyyy-MM-dd): ");
            String userInputForEndDate = scannerForDateOfBeginning.nextLine();
            // To parse the users input
            DateTimeFormatter formatterForEndDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");


            //Knd of leave!!!
            Scanner scanPaidOrUnpaid = new Scanner(System.in);
            System.out.println("ENTER PAID OR UNPAID IS THE LEAVE: ");
            String paidOrUnpaid = scanPaidOrUnpaid.nextLine();

            //Saving into a file!!!

            try {
                PrintStream ps = new PrintStream("OptionOnSaveInput.txt");
                   ps.println(name);
                   ps.print(email);
                   ps.print(userInputForBeginningDate);
                   ps.print(userInputForEndDate);
                   ps.print(paidOrUnpaid);

                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            //FIGURE OUT HOW TO MAKE IT A TABLE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }catch(Exception e){
            System.out.println("ERROR!Try again");
            showMenu();
            scanNumber();

        }
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

        if (num == 1) {
            showFirstOption();
        } else if (num == 2) {
            showSecondOption();
        } else if (num == 3) {
            showThirdOption();
        } else if (num == 4) {
            showFourthOption();
        } else if (num == 5) {
            showMenu();
        } else {
            System.out.println("!INVALID OPTION! PICK ANOTHER ONE");
            showMenu();
        }


    }
    //Scanner for what number the user picked
    public static void scanNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
        int num = scan.nextInt();
        checkOption(num);
    }
    //check what option is chosen
    public static void checkOption(int num) {
        if (num == 1) {
            showFirstOption();
        } else if (num == 2) {
            showSecondOption();
        } else if (num == 3) {
            showThirdOption();
        } else if (num == 4) {
            showFourthOption();
        } else if (num == 5) {
            showMenu();
        } else {
            System.out.println("!INVALID OPTION! PICK ANOTHER ONE");
            showMenu();
        }
    }

}