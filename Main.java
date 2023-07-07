
import java.io.*;
import java.text.SimpleDateFormat;
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
        try{
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
        }catch(Exception e){
            System.out.println("ERROR!");
            showMenu();
        }


    }
    //2 state leave - have to save all of them only and fix the dates
    public static void showFirstOption(){
        try{

            Scanner scanName = new Scanner(System.in);
            System.out.println("ENTER NAME:");
            String name = scanName.nextLine();
            for (char c : name.toCharArray()) {
                // Check if the character is a number
                if (Character.isDigit(c)) {
                    System.out.println("ERROR!There is a number in the name.");
                    showMenu();
                }else{
                    break;
                }
            }

            Scanner scanEmail = new Scanner(System.in);
            System.out.println("ENTER EMAIL:");
            String email = scanEmail.nextLine();

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
                }

                Scanner scanAnswer = new Scanner(System.in);
            System.out.println("Would you like to continue using this programme(YES/NO): ");
            String AnswerContinueProgramme = scanAnswer.nextLine();

            if(AnswerContinueProgramme == "YES"){
                System.out.println("You said yes");
                showMenu();
            }else if(AnswerContinueProgramme == "NO") {
                System.out.println("Thank you for using this programme!");
            }else{
                System.out.println("The answer must be in caps!");
                showFirstOption();
            }


        }catch(Exception e){
            System.out.println("ERROR!Try again");
            showMenu();
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
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
   //below this is maybe worth it
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

        }
    }
}