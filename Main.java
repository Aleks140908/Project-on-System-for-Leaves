
import java.io.*;
import java.lang.reflect.Array;
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
                stateLeave();
            } else if (num == 2) {
                lookAtLeaves();
            } else if (num == 3) {
                lookAtLeavesForSpecificEmployee();
            } else if (num == 4) {
                changeStatusForLeave();
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

    //2 state leave
    public static void stateLeave() {
        try {
            //Name
            Scanner scanName = new Scanner(System.in);
            System.out.println("ENTER NAME:");
            String name = scanName.nextLine();
            for (char c : name.toCharArray()) {
                // Check if the char is a number
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

    //3 look at leaves
    public static void lookAtLeaves() {
        try (BufferedReader reader = new BufferedReader(new FileReader("OptionOnSaveInput.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
            e.printStackTrace();
            showMenu();
        }
        showMenu();
    }

    //4 look at employee leaves
    public static void lookAtLeavesForSpecificEmployee() {

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
            showMenu();
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    //5 change status for leave
    public static void changeStatusForLeave() {
        try (BufferedReader reader = new BufferedReader(new FileReader("OptionOnSaveInput.txt"))) {


            Map<Integer, String[]> map = new HashMap<>();
            Random random = new Random();

            String line;
            int lN = 1;

            line = reader.readLine();
            String[] arr = line.split(",");
            int rand = random.nextInt();

            PrintStream ps = new PrintStream(new FileOutputStream("OptionOnSaveInput.txt", true));
            ps.print(rand);
            ps.close();

            map.put(lN, arr);
            map.put(rand, arr);

            for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
                Integer key = entry.getKey();
                String[] value = entry.getValue();
                System.out.println("Key: " + key);
                System.out.println("Value: " + Arrays.toString(value));
                System.out.println();
            }

            System.out.print(String.format("%1$20s", arr[0]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[1]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[2]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[3]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[4]));
            System.out.println();

            Scanner scanIndividualNumber = new Scanner(System.in);
            System.out.println("Enter individual number for the request: ");
            int IN = scanIndividualNumber.nextInt();

            Scanner scanStatusOfLeave = new Scanner(System.in);
            System.out.println("Enter the status of your leave (approved/pending/declined):");
            String status = scanStatusOfLeave.nextLine();

            String[] arrayToUpdate = map.get(IN);
            if (arrayToUpdate != null && arrayToUpdate.length >= 6) {
                arrayToUpdate[5] = status;
                System.out.println("Status updated.");
                showMenu();
            } else {
                System.out.println("ERROR!");
            }
            System.out.println();
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
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("OptionOnSaveInput.txt", true));
            ps.print(name + ",");
            ps.print(email+ ",");
            ps.print(ID+ ",");
            ps.print(BeginningDate+ ",");
            ps.print(EndDate+ ",");
            ps.print(paidOrUnpaid);
            ps.println();
            ps.close();
        } catch (Exception exception) {
            System.out.println("ERROR!");
            showMenu();

        }
    }
    //Reading the file which contains the table
    public static void ReadTable(Map<String, String> map, String filename,String person) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                boolean foundPerson = false;

                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(person)) {
                        foundPerson = true;
                        String[] parts = line.split(",");

                    }
                }

                if (!foundPerson) {
                    System.out.println("No leaves found for employee");
                    showMenu();
                }

            } catch (Exception e) {
                System.out.println("ERROR!");
                showMenu();
            }

        }
    }