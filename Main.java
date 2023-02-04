import java.util.Scanner;

public class Main {

    private static Process process;
    private static Infos infos;
    private static Scanner scanner;

    private static int totalIncome = 0, currentIncome = 0 ,soldTicketsCount = 0, ticketPrice = 10 ;

    private static int selectedRow, selectedColumn;
    private static String[][] seats;
    private static int rows, columns, totalSeats;

    public static void main(String[] args) {
        process = new Process();
        infos = new Infos();
        scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows:\n> ");
        rows = scanner.nextInt();

        System.out.print("Enter the number of seats in each row:\n> ");
        columns = scanner.nextInt();

        seats = process.makeSeats(rows,columns);
        totalSeats = rows * columns;
        totalIncome = process.calculatePrice(rows,columns);

        CINEMAPROGRAM:
        while (true) {
            System.out.println("\n" + infos.MENU);

            System.out.print("> ");
            int userInput = scanner.nextInt();
            System.out.println();

            switch (userInput) {
                case 1:
                    process.printSeats(seats);
                    break;

                case 2:
                    seatChoice();
                    process.selectSeat(seats,selectedRow,selectedColumn);

                    ticketPrice = rows * columns > 60 ? selectedRow > rows / 2 ? 8 : 10 : 10;
                    System.out.printf("Ticket price: $%d\n", ticketPrice);
                    currentIncome+= ticketPrice;
                    soldTicketsCount++;

                    break;

                case 3:
                    System.out.println(
                            infos.STATISTICS_TEXT.formatted(
                                    soldTicketsCount,
                                    100.0 / totalSeats * soldTicketsCount,
                                    currentIncome,totalIncome
                            )
                    );
                    break;

                case 0:
                    break CINEMAPROGRAM;
            }
        }


    }

    static void seatChoice() {
        boolean reset = false;

        System.out.print("Enter a row number:\n> ");
        selectedRow = scanner.nextInt();

        System.out.print("Enter a seat number in that row:\n> ");
        selectedColumn = scanner.nextInt();

        if (selectedRow < 1 || selectedRow > rows || selectedColumn < 1 || selectedColumn > rows ) {
            System.out.println("Wrong input!");
            reset = true;
        } else if (process.checkSelectedSeat(seats,selectedRow,selectedColumn)){
            System.out.println("That ticket has already been purchased!");
            reset = true;
        }

        if (reset) {
            seatChoice();
        }

    }

}



