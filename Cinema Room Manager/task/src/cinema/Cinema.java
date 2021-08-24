package cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    public static ArrayList<int[]> busySeat = new ArrayList<int[]>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatInRow = scanner.nextInt();
        int chooise = -1;
        while (chooise != 0) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            chooise = scanner.nextInt();
            switch (chooise) {
                case 1:
                    printCinema(rows, seatInRow, -1, busySeat);
                    break;
                case 2:
                    buyTicket(rows, seatInRow);
                    break;
                case 3:
                    statistics(rows, seatInRow, busySeat);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Enter number 0/1/2");
                    break;

            }
        }


    }

    public static void buyTicket(int rows, int seatInRow) {
        Scanner scanner = new Scanner(System.in);
        int seatAtRow = 0;
        int seatNumber = 0;

        while (true) {
            System.out.println("Enter a row number:");
            seatAtRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt() - 1;
            boolean flag = false;
            for (int[] ints : busySeat) {
                if (seatAtRow == ints[0] && seatNumber == ints[1]) {
                    System.out.println("That ticket has already been purchased!");
                    flag = true;
                    break;
                }
            }

            if ( seatAtRow > rows || seatAtRow < 0 || seatNumber > seatInRow || seatNumber < 0) {
                System.out.println("Wrong input!");
                flag = true;
            }
            if (!flag) break;
        }
        int[] temp = new int[2];
        temp[0] = seatAtRow;
        temp[1] = seatNumber;
        busySeat.add(temp);


        //System.out.println("Total income:");
        if (rows * seatInRow <= 60) {
            //маленький зал
            System.out.println("Ticket price: $10");
        } else {
            //Большой зал
            int firstS = rows / 2;

            if (seatAtRow <= firstS) System.out.println("Ticket price: $10");
            else System.out.println("Ticket price: $8");

        }
        System.out.println();
        printCinema(rows, seatInRow, seatAtRow, busySeat);
    }

    public static void printCinema(int rows, int seatInRow, int searchRow, ArrayList<int[]> searchInRow) {

        System.out.println("Cinema:");

        // Распечатка кинотеатра
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seatInRow + 1; j++) {
                if (i == 0 && j == 0) System.out.print("  ");
                else if (i == 0) System.out.print(j + " ");
                if (i >= 1 && j == 0) {
                    System.out.print(i + " ");
                }
                boolean flag = true;
                for (int k = 0; k < busySeat.size(); k++) {
                    if (i != 0 && i == searchInRow.get(k)[0] && j == searchInRow.get(k)[1]) {
                        System.out.print("B ");
                        flag = false;
                    }
                }
                if (i != 0 && j != seatInRow && flag) System.out.print("S ");

            }
            System.out.println();
        }
    }

    public static void statistics(int rows, int seatInRows, ArrayList<int[]> busySeat) {
        System.out.println("Number of purchased tickets: " + busySeat.size());

        System.out.format("Percentage: "+ String.format("%.2f", (double) busySeat.size() * 100 / (rows * seatInRows)));
        System.out.print("%");
        System.out.println();
        int sum = 0;
        int firstS = rows / 2;

        for (int[] ints : busySeat) {

            if (rows * seatInRows <= 60) {
                //маленький зал
                sum += 10;

            } else {
                //Большой зал

                if (ints[0] <= firstS) sum += 10;
                else sum += 8;

            }
        }
        int total = 0;
        if(rows * seatInRows <= 60) total = rows * seatInRows * 10;
        else total = firstS * 10 * seatInRows + 8 * (rows - firstS) * seatInRows;
        System.out.println("Current income: $" + sum);
        System.out.println("Total income: $" + total);
    }
}
/*package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seat = scan.nextInt();
        int price;

        String[][] cinema = new String[row][seat];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                cinema[i][j] = "S";
            }
        }

        while (true) {
            System.out.print("\n1. Show the seats\n2. Buy a ticket\n0. Exit\n");
            int choice = scan.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                display(cinema, row, seat);
            } else {
                System.out.println("\nEnter a row number:");
                int row1 = scan.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seat1 = scan.nextInt();

                cinema[row1 - 1][seat1 - 1] = "B";
                if (row * row <= 60 || row1 <= row / 2) {
                    price = 10;
                } else {
                    price = 8;
                }
                System.out.println("Ticket price: $" + price);
            }
        }
    }

    private static void display(String[][] cinema, int row, int seat) {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i < seat + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j = 0; j < row; j++) {
            System.out.print((j + 1) + " ");
            for (int i = 0; i < seat; i++) {
                System.out.print((cinema[j][i] + " "));
            }
            System.out.println();
        }
    }
}*/
/*package cinema;

public class Cinema {

    private int rowsCount;
    private int seatsCount;
    String[][] cinema;
    private double totalIncome = 0;
    private double incomeNow = 0;
    private double countTickets = 0;

    Cinema (int rowsCount, int seatsCount) {
        this.rowsCount = rowsCount;
        this.seatsCount = seatsCount;
        cinemaStart();
    }

    private void cinemaStart() {
        this.cinema = new String[this.rowsCount + 1][this.seatsCount + 1];
        for (int i = 0; i < this.cinema.length; i++) {
            for (int j = 0; j < this.cinema[i].length; j++) {
                if (i != 0) {
                    this.cinema[i][j] = j == 0 ? i + " " : "S ";
                } else {
                    this.cinema[i][j] = j == 0 ? "  " : j + " ";
                }
            }
        }
        System.out.println();
        totalIncome = rowsCount * seatsCount < 60 ? rowsCount * seatsCount * 10
                : rowsCount / 2 * seatsCount * 10
                + (rowsCount - rowsCount / 2) * seatsCount * 8;
    }

    public void printCinema() {
        System.out.println("Cinema:");
        for (int i = 0; i < this.cinema.length; i++) {
            for (int j = 0; j < this.cinema[i].length; j++) {
                System.out.print(this.cinema[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean buyTicket(int row, int place) {
        if (row < 1 || place < 1 || row > rowsCount || place > seatsCount) {
            System.out.println("Wrong input!\n");
            return false;
        } else {
            if (this.cinema[row][place].equals("S ")) {
                this.cinema[row][place] = "B ";
                System.out.print("Ticket price: ");
                int ticketPrice = rowsCount * seatsCount < 60 ? 10 : row <= rowsCount / 2 ? 10 : 8;
                System.out.println("$" + ticketPrice + "\n");
                incomeNow += ticketPrice;
                countTickets++;
                return true;
            } else {
                System.out.println("That ticket has already been purchased!\n");
                return false;
            }
        }
    }

    public void printStatistics() {
        double ticketsCount = rowsCount * seatsCount;
        double incomeTicketsPerc = countTickets / (ticketsCount / 100);
        System.out.printf("\nNumber of purchased tickets: %.0f\n", countTickets);
        System.out.printf("Percentage: %.2f%%\n", incomeTicketsPerc);
        System.out.printf("Current income: $%.0f\n", incomeNow);
        System.out.printf("Total income: $%.0f\n\n", totalIncome);
    }
}*/