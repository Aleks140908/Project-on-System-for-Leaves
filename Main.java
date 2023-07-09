
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void showMenu() {
        System.out.println("1. STATE LEAVE ");
        System.out.println("2. LOOK AT LEAVES ");
        System.out.println("3. LOOK AT LEAVES FOR AN EMPLOYEE ");
        System.out.println("4. CHANGE STATUS FOR LEAVE ");
        System.out.println("5. EXIT ");
        try {
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
        } catch (Exception e) {
            System.out.println("ERROR!");
            showMenu();
        }


    }

    //2 state leave - ready but have to save the requests (all of them)
    public static void showFirstOption() {
        try {
            //Name
            Scanner scanName = new Scanner(System.in);
            System.out.println("ENTER NAME:");
            String name = scanName.nextLine();
            for (char c : name.toCharArray()) {
                // Check if the character is a number
                if (Character.isDigit(c)) {
                    System.out.println("ERROR!There is a number in the name.");
                    showMenu();
                } else {
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

            MakeNSaveTable(name, email, ID, dateBegToString, dateEndToString, paidOrUnpaid);
            System.out.println("Request Made!");
            showMenu();
        } catch (Exception e) {
            System.out.println("ERROR!Try again");
            showMenu();
        }
    }

    //3 look at leaves-ready
    public static void showSecondOption() {
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
        showMenu();
    }

    //4 look at employee leaves - not ready / has a problem
    public static void showThirdOption() {
        //read with hashset and the passcode will be the employees name;
        try {
            Scanner scanEmployee = new Scanner(System.in);
            System.out.print("Enter the name of the employee: ");
            String person = scanEmployee.nextLine();

            Map<String, String> map = new HashMap<>();


            ReadTable(map, "OptionOnSaveInput",person);

            for (Map.Entry<String, String> entry : map.entrySet()) {
                String value = entry.getValue();
                System.out.println(value);
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    //5 change status for leave
    public static void showFourthOption() {
        try {
//make or show table add one column more for the IN and status so that the status can change based on the IN
           //make the unique number
            Random random = new Random();
            int randomNumber = random.nextInt();

            //last step scan
            Scanner IndividualNumber = new Scanner(System.in);
            System.out.println("Enter individual number of leave: ");
            int IN = IndividualNumber.nextInt();

            Scanner scanStatusOfLeave = new Scanner(System.in);
            System.out.println("ENTER WHAT WILL BE THE STATUS OF YOUR LEAVE:");
            String status = scanStatusOfLeave.nextLine();
            //put approved pending and declined

        } catch (Exception e) {
            System.out.println("ERROR!");
            showMenu();
        }
    }

    public static void main(String[] args) {
        showMenu();
    }

    //Making the table
    public static void MakeNSaveTable(String name, String email, String ID, String BeginningDate, String EndDate, String paidOrUnpaid) {
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
        SaveTable(TheFirstRowOfTheTable, TheSecondRowOfTheTable);

    }

    //Method for saving the table
    public static void SaveTable(ArrayList<String> TheFirstRowOfTheTable, ArrayList<String> TheSecondRowOfTheTable) {
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
    public static void ReadTable(Map<String, String> map, String filename,String person) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                boolean foundPerson = false;

                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(person + ":")) {
                        foundPerson = true;
                        String[] parts = line.split(":");
                        if (parts.length == 2) {
                            String leave = parts[1].trim();
                            System.out.println(leave);
                        }
                    }
                }

                if (!foundPerson) {
                    System.out.println("No leaves found for " + person);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }

        }
    }




