import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ArrayIntListMaster {

    public static void main(String[] args) {
        boolean completed = false;
        ArrayIntList valuesList = new ArrayIntList();
        Scanner userSelector = new Scanner(System.in);
        String userSelection;
        // As long as you haven't noted to quit
        while (!(completed)) {
            // List all options
            System.out.println("Would you like to \n" +
                    "\'A\' to add to the end.\n" +
                    "\'I\' to insert in the middle.\n" +
                    "\'D\' to delete a value.\n" +
                    "\'P\' to print all of the values.\n" +
                    "\'Q\' to quit.\n");
            // Take in an option from the user
            userSelection = userSelector.next();
            userSelector.nextLine();
            // If "A", call the add method
            if (userSelection.equals("A"))
                addToArrayList(valuesList, userSelector);

            // If "I", call the insert method
            if (userSelection.equals("I"))
                insertIntoArrayList(valuesList, userSelector);

            // If"D", call the delete method
            if (userSelection.equals("D"))
                deleteFromArrayList(valuesList, userSelector);

            // If "P", call the print method
            if (userSelection.equals("P"))
                printArrayList(valuesList);
            // If "Q"
            if (userSelection.equals("Q"))
                completed = true;
        }
        userSelector.close();
        System.exit(0);
    }

    public static void printArrayList(ArrayIntList valuesList) {
        System.out.println(valuesList);
    }

    public static void addToArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        int newValue = userSelector.nextInt();
        userSelector.nextLine();
        valuesList.add(newValue);
    }

    public static void deleteFromArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to delete from?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot < valuesList.size()))
            valuesList.remove(newSpot);
        else
            System.out.println("Invalid index received; no change");
    }

    public static void insertIntoArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("At which index would you like to insert a value?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot <= valuesList.size()))
        {
            System.out.println("What value would you like to add?");
            int newValue = userSelector.nextInt();
            userSelector.nextLine();
            valuesList.add(newSpot, newValue);
        }
        else
        System.out.println("Invalid index received; no change");
    }
}

class ArrayIntList {
    private int list[];
    private int numAdded = 0;
    private int size = 10;

    public ArrayIntList(int userSize) {
        list = new int[userSize];
    }

    public ArrayIntList() {
        list = new int[size];
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        list[size] = value;
        size++;
        numAdded++;
    }

    public String toString() {
        String retString = "[";
        for(int i = 0; i < size - 1; i++) {
            retString += list[i] + ", ";
        }
        if (size != 0) {
            retString += list[size-1];
        }
        retString += "]";
        return retString;
    }

    public void add(int index, int value) {
        numAdded++;
        for (int i = size; i > index; i--) {
            list[i] = list[i-1];
        }
        list[index] = value;
        size++;
        numAdded++;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i+1];
        }
        size--;
        list[size] = 0;
    }

    public void set(int index, int value) {
        list[index] = value;
    }

    public int get(int index) {
        return list[index];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int indexof(int value) {
        for (int i = 0; i < size; i++) {
            if (list[i] == value) {
                return i;
            }    
        }
        return -1;
    }

    public boolean contains(int value) {
        return !(indexof(value) == -1);
    }
}