package com.manikandanmuthuv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parking Lot
 *
 */
public class App implements Runnable {
    static Scanner scanner;
    static Boolean exit = false;
    ParkingLot parkingLot = new ParkingLot();

    public void executeCommands(String[] fileCommands) {
        if (fileCommands[0].equals("create_parking_lot")) {
            CreateParkingLot(fileCommands);
        }
        if (fileCommands[0].equals("park")) {
            AllocateSlot(fileCommands);
        }
        if (fileCommands[0].equals("leave")) {
            LeaveSlot(fileCommands);
        }
        if (fileCommands[0].equals("status")) {
            Status();
        }
        if (fileCommands[0].equals("registration_numbers_for_cars_with_colour")) {
            FindRegNumbersByCarColor(fileCommands);
        }
        if (fileCommands[0].equals("slot_numbers_for_cars_with_colour")) {
            FindSlotNumbersByCarColor(fileCommands);
        }
        if (fileCommands[0].equals("slot_number_for_registration_number")) {
            FindSlotNumbersByCarRegNumber(fileCommands);
        }
    }

    private void AllocateSlot(String[] fileCommands) {
        String regNumber = fileCommands[1];
        String color = fileCommands[2];
        Car car = new Car(regNumber, color);
        String output = parkingLot.AllocateSlot(car);
        System.out.println(output);
    }

    public void run() {
        while (true) {
            String[] commands = scanner.nextLine().trim().split("\\s+");
            if (commands.length == 0 && commands.length > 3) {
                System.out.println("please enter the valid commands");
            }
            if (commands[0].equals("exit")) {
                exit = true;
                break;
            }
            if (commands[0].equals("file_input.txt")) {
                File file = new File(commands[0]);
                List<String> commandLines = new ArrayList<String>(32);
                String[] fileCommands;
                Scanner scanner;
                try {
                    scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        fileCommands = scanner.nextLine().trim().split("\\s+");
                        executeCommands(fileCommands);
                        // commandLines.add(scanner.nextLine());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (commands[0].equals("create_parking_lot")) {
                CreateParkingLot(commands);
            }
            if (commands[0].equals("park")) {
                AllocateSlot(commands);
            }
            if (commands[0].equals("leave")) {
                LeaveSlot(commands);
            }
            if (commands[0].equals("status")) {
                Status();
            }
            if (commands[0].equals("registration_numbers_for_cars_with_colour")) {
                FindRegNumbersByCarColor(commands);
            }
            if (commands[0].equals("slot_numbers_for_cars_with_colour")) {
                FindSlotNumbersByCarColor(commands);
            }
            if (commands[0].equals("slot_number_for_registration_number")) {
                FindSlotNumbersByCarRegNumber(commands);
            }

        }
    }

    private void CreateParkingLot(String[] commands) {
        String methodParams = commands[1];
        String output = parkingLot.Create(Integer.parseInt(methodParams));
        System.out.println(output);
    }

    private void FindSlotNumbersByCarRegNumber(String[] commands) {
        String regNumber = commands[1];
        String output = parkingLot.FindAllSlotNumbersByCarRegNo(regNumber);
        System.out.println(output);
    }

    private void FindSlotNumbersByCarColor(String[] commands) {
        String color = commands[1];
        String output = parkingLot.FindAllSlotNumbersByCarColor(color);
        System.out.println(output);
    }

    private void FindRegNumbersByCarColor(String[] commands) {
        String color = commands[1];
        String output = parkingLot.FindRegNumbersOfAllCarsByItsColor(color);
        System.out.println(output);
    }

    private void Status() {
        String output = parkingLot.Status();
        System.out.println(output);
    }

    private void LeaveSlot(String[] commands) {
        Integer slotNumber = Integer.parseInt(commands[1]);
        String output = parkingLot.LeaveSlot(slotNumber);
        System.out.println(output);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Thread thread = new Thread(new App());
        thread.start();
        while (true) {
            try {
                thread.sleep(10);
            } catch (Exception e) {
            }
            if (exit == true)
                break;

        }
    }
}
