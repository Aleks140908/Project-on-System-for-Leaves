
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
    //2 state leave - have to save the requests (all of them)
    public static void showFirstOption(){
        try{
            //Name
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
            //Email
            Scanner scanEmail = new Scanner(System.in);
            System.out.println("ENTER EMAIL:");
            String email = scanEmail.nextLine();
            //ID
            Scanner scanIdNum = new Scanner(System.in);
            System.out.println("ENTER IDENTIFICATION NUMBER: ");
            int IdNumber = scanIdNum.nextInt();
            String ID = String.valueOf(IdNumber);

            //Date Of Beginning
            Scanner scanTheBegDate = new Scanner(System.in);
            System.out.print("Enter the beginning date of your leave (dd/MM/yyyy): ");
            String dateInputForBeg = scanTheBegDate.nextLine();

            SimpleDateFormat dateFormatBeg = new SimpleDateFormat("dd/MM/yyyy");
            Date dateBeg = dateFormatBeg.parse(dateInputForBeg);
            String dateBegToString = dateFormatBeg.format(dateBeg);

            //Date Of End
            Scanner scanTheEndDate = new Scanner(System.in);
            System.out.print("Enter the end date of your leave (dd/MM/yyyy): ");
            String dateInputForEnd = scanTheEndDate.nextLine();

            SimpleDateFormat dateFormatEnd = new SimpleDateFormat("dd/MM/yyyy");
                Date dateEnd = dateFormatEnd.parse(dateInputForEnd);
                String dateEndToString = dateFormatEnd.format(dateEnd);
                //paid or unpaid
                Scanner scanPaidOrUnpaid = new Scanner(System.in);
            System.out.println("ENTER PAID OR UNPAID IS THE LEAVE: ");
            String paidOrUnpaid = scanPaidOrUnpaid.nextLine();

            MakeNReadTable(name,email,ID,dateBegToString,dateEndToString,paidOrUnpaid);
            showMenu();
        }catch(Exception e){
            System.out.println("ERROR!Try again");
            showMenu();
        }
    }
    //3 look at leaves-ready
    public static void showSecondOption(){
        ReadTable();
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
            //put approved pending and declined

        }catch (Exception e){
            System.out.println("ERROR!");
            showMenu();
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
   //Making the table
    public static void MakeNReadTable(String name,String email,String ID,String BeginningDate,String EndDate, String paidOrUnpaid){
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
        tableForSavingInTheFirstOption.add(TheSecondRowOfTheTable);
        //save table
       SaveTable(TheFirstRowOfTheTable,TheSecondRowOfTheTable);

    }
    //Method for saving the table
    public static void SaveTable(ArrayList<String> TheFirstRowOfTheTable,ArrayList<String> TheSecondRowOfTheTable){
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
    //This is option two and its Reading the file which contains the table
    public static void ReadTable(){
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
}