
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
            checkNumForMenu(num);
        } catch (Exception e) {
            System.out.println("ERROR!");
            showMenu();
        }
    }

    public static void stateLeave() {
        try {
            Scanner scanData = new Scanner(System.in);
            System.out.println("ENTER NAME:");
            String name = scanData.nextLine();
            checkIfNameHasDig(name);

            System.out.println("ENTER EMAIL:");
            String email = scanData.nextLine();

            System.out.println("ENTER IDENTIFICATION NUMBER: ");
            int idNumber = Integer.parseInt(scanData.nextLine()); // Read the entire line and parse it as an integer
            String iD = String.valueOf(idNumber);

            System.out.print("Enter the beginning date of your leave (dd/MM/yyyy): ");
            String dateInputForBeg = scanData.nextLine();
            SimpleDateFormat dateFormatBeg = new SimpleDateFormat("dd/MM/yyyy");
            Date dateBeg = dateFormatBeg.parse(dateInputForBeg);
            String dateBegToString = dateFormatBeg.format(dateBeg);
            scanData.nextLine();

            System.out.print("Enter the end date of your leave (dd/MM/yyyy): ");
            String dateInputForEnd = scanData.nextLine();
            SimpleDateFormat dateFormatEnd = new SimpleDateFormat("dd/MM/yyyy");
            Date dateEnd = dateFormatEnd.parse(dateInputForEnd);
            String dateEndToString = dateFormatEnd.format(dateEnd);
            scanData.nextLine();

            System.out.println("ENTER PAID OR UNPAID IS THE LEAVE: ");
            String paidOrUnpaid = scanData.nextLine();

            makeNSaveTable(name, email, iD, dateBegToString, dateEndToString, paidOrUnpaid);
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
/////////////////////////////////////////////////////////////////////
    //4 look at employee leaves
    public static void lookAtLeavesForSpecificEmployee() {

        try (BufferedReader reader = new BufferedReader(new FileReader("OptionOnSaveInput.txt"))) {
           Scanner scanEmployeeName = new Scanner(System.in);
            System.out.println("Enter name of employee :");
            String name = scanEmployeeName.nextLine();

            Map<String, String[]> map = new HashMap<>();
            String line;
            line = reader.readLine();
            String[] arr = line.split(",");
            putValueNKeyForEmployees(map,arr,name);
            mapKeyNValueForEmployee(map);
            formatData(arr);

            PrintStream ps = new PrintStream(new FileOutputStream("OptionOnSaveInput.txt", true));
            ps.print(arr[0] + ",");
            ps.print(arr[1]+ ",");
            ps.print(arr[2]+ ",");
            ps.print(arr[3]+ ",");
            ps.print(arr[4]+ ",");
            ps.println();
            ps.close();
            showMenu();
        } catch (Exception e) {
            System.out.println("ERROR!");
            showMenu();
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

           printRandomNumber(rand);
           mapPut(lN,rand,arr,map);
           mapKeyNValue(map);
           formatData(arr);

            Scanner scanIndividualNumber = new Scanner(System.in);
            System.out.println("Enter individual number for the request: ");
            int iN = scanIndividualNumber.nextInt();

            Scanner scanStatusOfLeave = new Scanner(System.in);
            System.out.println("Enter the status of your leave (approved/pending/declined):");
            String status = scanStatusOfLeave.nextLine();

            String[] arrayToUpdate = map.get(iN);
            checkArrWithUpdates(arrayToUpdate,status,arr);
        } catch (Exception e) {
            System.out.println("ERROR!");
            showMenu();
        }
    }

    public static void main(String[] args) {
        showMenu();
    }

    //Making the table
    public static void makeNSaveTable(String name, String email, String ID, String BeginningDate, String EndDate, String paidOrUnpaid) {
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
    public static void mapKeyNValueForEmployee(Map<String, String[]> map){
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            System.out.println("For "+ key+" requests are :");
            System.out.println(Arrays.toString(value));
            System.out.println();
        }
    }

    public static void putValueNKeyForEmployees(Map<String, String[]> map,String[]arr,String name) {
            try {
               map.put(name,arr);
            } catch (Exception e) {
                System.out.println("ERROR!");
                showMenu();
            }

        }
        public static void checkIfNameHasDig(String name){
            for (char c : name.toCharArray()) {
                if (Character.isDigit(c)) {
                    System.out.println("ERROR!There is a number in the name.");
                    showMenu();
                } else {
                    break;
                }
            }
        }
        public static void checkNumForMenu(int num){
        try{
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
        }catch(Exception e){
            System.out.println("ERROR!");
            showMenu();
        }
        }
        public static void printRandomNumber(int rand){
        try{
            PrintStream ps = new PrintStream(new FileOutputStream("OptionOnSaveInput",true));
            ps.print(rand);
            ps.close();
        }catch(Exception e){
            System.out.println("ERROR!");
            showMenu();
        }
        }
        public static void mapPut(int lN,int rand,String[] arr, Map<Integer, String[]> map){
        try{
            map.put(lN, arr);
            map.put(rand, arr);
        }catch(Exception e){
            System.out.println("ERROR!");
            showMenu();
        }
        }
        public static void formatData(String[] arr){
        try{
            System.out.print(String.format("%1$20s", arr[0]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[1]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[2]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[3]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[4]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[5]));
            System.out.println();
        }catch(Exception e){
            System.out.println("ERROR!");
            showMenu();
        }

        }
        //have to save
        public static void formatDataWithUpdateNSave(String[] arr,String[] arrayToUpdate){
        try{
            System.out.print(String.format("%1$20s", arr[0]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[1]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[2]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[3]));
            System.out.print("|");
            System.out.print(String.format("%1$20s", arr[4]));
            System.out.print("|");
            System.out.print(String.format("%1$20s",arr[5]));
            System.out.println();

            PrintStream ps = new PrintStream(new FileOutputStream("OptionOnSaveInput.txt", true));
            ps.print(arr[0] + ",");
            ps.print(arr[1]+ ",");
            ps.print(arr[2]+ ",");
            ps.print(arr[3]+ ",");
            ps.print(arr[4]+ ",");
            ps.print(arr[5]+",");
            ps.print(arrayToUpdate[5]);
            ps.println();
            ps.close();
        }catch(Exception e){
            System.out.println("ERROR!");
            showMenu();
        }
        }
        public static void mapKeyNValue(Map<Integer, String[]> map){
            for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
                Integer key = entry.getKey();
                String[] value = entry.getValue();
                System.out.println("Key: " + key);
                System.out.println("Value: " + Arrays.toString(value));
                System.out.println();
            }
        }
        public static void checkArrWithUpdates(String[] arrayToUpdate,String status,String[]arr){
        try{
            if (arrayToUpdate != null && arrayToUpdate.length >= 6) {
                arrayToUpdate[5] = status;
                System.out.println("Status updated.");
                formatDataWithUpdateNSave(arr,arrayToUpdate);
                showMenu();
            } else {
                System.out.println("ERROR!");
                showMenu();
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("ERROR!");
            showMenu();
        }
        }
    }
