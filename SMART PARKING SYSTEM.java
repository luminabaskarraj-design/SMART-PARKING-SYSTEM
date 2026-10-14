
import java.util.Scanner;

public class SmartParkingSystem {

    static boolean[] slots = new boolean[6];
    // Slots 1 to 5; true means occupied

    static Scanner sc = new Scanner(System.in);

    static void displaySlots() {
        System.out.println("\n--- Parking Slot Status ---");

        for (int i = 1; i <= 5; i++) {
            if (slots[i]) {
                System.out.println("Slot " + i + " : Occupied");
            } else {
                System.out.println("Slot " + i + " : Available");
            }
        }
    }

    static int findSlot() {
        for (int i = 1; i <= 5; i++) {
            if (!slots[i]) {
                return i;
            }
        }
        return -1;
    }

    static void parkVehicle() {
        System.out.print("Enter vehicle number: ");
        String vehicle = sc.nextLine();

        int slot = findSlot();

        if (slot == -1) {
            System.out.println("Sorry! No parking slots available.");
        } else {
            slots[slot] = true;
            System.out.println("Vehicle " + vehicle
                    + " parked successfully.");
            System.out.println("Your parking slot is: " + slot);
        }
    }

    static void releaseSlot() {
        System.out.print("Enter slot number to release: ");
        int slot = sc.nextInt();
        sc.nextLine();

        if (slot >= 1 && slot <= 5 && slots[slot]) {
            slots[slot] = false;
            System.out.println("Slot " + slot
                    + " released successfully.");
        } else {
            System.out.println("Invalid slot or slot is already empty.");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== SMART PARKING SYSTEM ===");
            System.out.println("1. View Parking Slots");
            System.out.println("2. Find Available Slot");
            System.out.println("3. Park Vehicle");
            System.out.println("4. Release Parking Slot");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displaySlots();
                    break;

                case 2:
                    int available = findSlot();
                    if (available == -1) {
                        System.out.println("No slots available.");
                    } else {
                        System.out.println(
                            "Available slot found: " + available);
                    }
                    break;

                case 3:
                    parkVehicle();
                    break;

                case 4:
                    releaseSlot();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
