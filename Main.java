
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
    //2 state leave - have to save all of them only
    public static void showFirstOption(){
        try{


            //Name - k
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


            //Email - k
            Scanner scanEmail = new Scanner(System.in);
            System.out.println("ENTER EMAIL:");
            String email = scanEmail.nextLine();


            //ID - k
            Scanner scanIdNum = new Scanner(System.in);
            System.out.println("ENTER IDENTIFICATION NUMBER: ");
            int IdNumber = scanIdNum.nextInt();
            String ID = String.valueOf(IdNumber);


            //Date Of Beginning - check if right
            Scanner scannerForDateOfBeginning = new Scanner(System.in);
            System.out.println("Enter a date (yyyy-MM-dd): ");
            String BeginningDate = scannerForDateOfBeginning .nextLine();
            SimpleDateFormat dateFormatForBeg= new SimpleDateFormat("yyyy-MM-dd");
                Date dateBeg = dateFormatForBeg.parse(BeginningDate);
                String dateStringBeg = dateFormatForBeg.format(dateBeg);





            //Date Of End - check if right
            Scanner scannerForDateOfEnd = new Scanner(System.in);
            System.out.println("Enter a date (yyyy-MM-dd): ");
            String EndDate = scannerForDateOfEnd.nextLine();
            SimpleDateFormat dateFormatForEnd = new SimpleDateFormat("yyyy-MM-dd");
            Date dateEnd = dateFormatForEnd.parse(BeginningDate);
            String dateStringEnd = dateFormatForEnd.format(dateEnd);


            //Kind of leave - k
            Scanner scanPaidOrUnpaid = new Scanner(System.in);
            System.out.println("ENTER PAID OR UNPAID IS THE LEAVE: ");
            String paidOrUnpaid = scanPaidOrUnpaid.nextLine();

            //from here down maybe worth it
            //Create Table
            ArrayList<ArrayList<String>> tableForSavingInTheFirstOption = new ArrayList<>();
            ArrayList<String> TheFirstRowOfTheTable = new ArrayList<>();
            TheFirstRowOfTheTable.add("Name");
            TheFirstRowOfTheTable.add("Email");
            TheFirstRowOfTheTable.add("Id");
            TheFirstRowOfTheTable.add("Date of beginning");
            TheFirstRowOfTheTable.add("Date of end");
            TheFirstRowOfTheTable.add("Kind of leave");
            tableForSavingInTheFirstOption.add(TheFirstRowOfTheTable);

            System.out.println();

            ArrayList<String> TheSecondRowOfTheTable = new ArrayList<>();
            TheSecondRowOfTheTable.add(name);
            TheSecondRowOfTheTable.add(email);
            TheSecondRowOfTheTable.add(ID);
            TheSecondRowOfTheTable.add(BeginningDate);
            TheSecondRowOfTheTable.add(EndDate);
            TheSecondRowOfTheTable.add(paidOrUnpaid);
            tableForSavingInTheFirstOption.add(TheFirstRowOfTheTable);
            //save table
                try {
                    PrintStream ps = new PrintStream("OptionOnSaveInput.txt");
                    ps.println(TheFirstRowOfTheTable);
                    ps.println(TheSecondRowOfTheTable);

                    ps.close();
                } catch (Exception exception) {
                    System.out.println("ERROR!");
                    exception.printStackTrace();
                    showMenu();
                    Scanner scan = new Scanner(System.in);
                    System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
                    int num = scan.nextInt();

                    switch (num){
                        case 1: showFirstOption();
                        case 2: showSecondOption();
                        case 3: showThirdOption();
                        case 4: showFourthOption();
                        case 5: showMenu();
                        default:
                            System.out.println("ERROR!");
                            showMenu();
                    }
                }


        }catch(Exception e){
            System.out.println("ERROR!Try again");
            showMenu();
            Scanner scan = new Scanner(System.in);
            System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
            int num = scan.nextInt();

            switch (num){
                case 1: showFirstOption();
                case 2: showSecondOption();
                case 3: showThirdOption();
                case 4: showFourthOption();
                case 5: showMenu();
                default:
                    System.out.println("ERROR!");
                    showMenu();
            }

        }
    }
               //3 look at leaves-ready
    public static void showSecondOption(){

        try (BufferedReader reader = new BufferedReader(new FileReader("OptionOnSaveInput.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR!");
            e.printStackTrace();
            showMenu();
            scanNumber();
            Scanner scan = new Scanner(System.in);
            System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
            int num = scan.nextInt();
            switch (num){
                case 1: showFirstOption();
                case 2: showSecondOption();
                case 3: showThirdOption();
                case 4: showFourthOption();
                case 5: showMenu();
                default:
                    System.out.println("ERROR!");
                    showMenu();
            }
        }
    }


    //4 look at employee leaves - not started
    public static void showThirdOption(){

    }
    //5 change status for leave
    public static void showFourthOption(){
        try{
            Scanner IndividualNumber = new Scanner(System.in);
            System.out.println("Enter individual number of leave: ");
            int IN = IndividualNumber.nextInt();

            Scanner scanStatusOfLeave = new Scanner(System.in);
            System.out.println("ENTER WHAT WILL BE THE STATUS OF YOUR LEAVE:");
            String status = scanStatusOfLeave.nextLine();

        }catch (Exception e){
            System.out.println("ERROR!");
            showMenu();
            Scanner scan = new Scanner(System.in);
            System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
            int num = scan.nextInt();
            switch (num){
                case 1: showFirstOption();
                case 2: showSecondOption();
                case 3: showThirdOption();
                case 4: showFourthOption();
                case 5: showMenu();
                default:
                    System.out.println("ERROR!");
                    showMenu();
            }
        }
    }

    public static void main(String[] args) {
        showMenu();

        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
        int num = scan.nextInt();

        switch (num){
            case 1: showFirstOption();
            case 2: showSecondOption();
            case 3: showThirdOption();
            case 4: showFourthOption();
            case 5: showMenu();
            default:
                System.out.println("ERROR!");
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
        switch (num){
            case 1: showFirstOption();
            case 2: showSecondOption();
            case 3: showThirdOption();
            case 4: showFourthOption();
            case 5: showMenu();
            default:
                System.out.println("ERROR!");
                showMenu();
        }
    }//below this is maybe worth it
    public static void MakeNReadTable(String name,String email ,String ID,String BeginningDate,String EndDate,String paidOrUnpaid,String status){
        ArrayList<ArrayList<String>> tableForSavingInTheFirstOption = new ArrayList<>();
        ArrayList<String> TheFirstRowOfTheTable = new ArrayList<>();
        TheFirstRowOfTheTable.add("Name");
        TheFirstRowOfTheTable.add("Email");
        TheFirstRowOfTheTable.add("Id");
        TheFirstRowOfTheTable.add("Date of beginning");
        TheFirstRowOfTheTable.add("Date of end");
        TheFirstRowOfTheTable.add("Kind of leave");
        TheFirstRowOfTheTable.add("Status");
        tableForSavingInTheFirstOption.add(TheFirstRowOfTheTable);

        System.out.println();

        ArrayList<String> TheSecondRowOfTheTable = new ArrayList<>();
        TheSecondRowOfTheTable.add(name);
        TheSecondRowOfTheTable.add(email);
        TheSecondRowOfTheTable.add(ID);
        TheSecondRowOfTheTable.add(BeginningDate);
        TheSecondRowOfTheTable.add(EndDate);
        TheSecondRowOfTheTable.add(paidOrUnpaid);
        TheSecondRowOfTheTable.add(status);
        tableForSavingInTheFirstOption.add(TheFirstRowOfTheTable);
        //save table
        try {
            PrintStream ps = new PrintStream("OptionOnSaveInput.txt");
            ps.println(TheFirstRowOfTheTable);
            ps.println(TheSecondRowOfTheTable);

            ps.close();
        } catch (Exception exception) {
            System.out.println("ERROR!");
            exception.printStackTrace();
            showMenu();
            Scanner scan = new Scanner(System.in);
            System.out.print("ENTER NUMBER OF OPTION YOU WOULD LIKE: ");
            int num = scan.nextInt();

            switch (num){
                case 1: showFirstOption();
                case 2: showSecondOption();
                case 3: showThirdOption();
                case 4: showFourthOption();
                case 5: showMenu();
                default:
                    System.out.println("ERROR!");
                    showMenu();
            }
        }
    }
}