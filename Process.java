import java.util.Arrays;

public class Process {

    StringBuilder stringSeat = new StringBuilder();

    public String[][] makeSeats(int rows, int columns) {
        String[][] seats = new String[rows][columns];
        
        seats[0][0] = " ";

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                seats[r][c] = "S";
            }
        }
        return seats;
    }

    public String[][] selectSeat(String[][] seats, int selectedRow, int selectedColumn) {
        seats[selectedRow - 1][selectedColumn - 1] = "B";
        return seats;
    }

    public boolean checkSelectedSeat(String[][] seats, int selectedRow, int selectedColumn) {

        if (seats[selectedRow - 1][selectedColumn - 1] == "B") {
            return true;
        }
        return false;
    }

    public void printSeats(String[][] seats) {
        stringSeat.setLength(0);

        stringSeat.append("Cinema:\n  ");


        boolean isTopNumbers = false;

        for (int i = 1; i <= seats[0].length; i++) {
            stringSeat.append(i);
            if (i != seats[0].length) {
                stringSeat.append(" ");
            }
        }

        for (int i = 0; i < seats.length; i++) {
            stringSeat.append("\n");
            stringSeat.append(i + 1 + " ");
            stringSeat.append(
                    Arrays.toString(seats[i]).replace("[","")
                    .replace("]","")
                    .replace(",","")
            );
        }
        System.out.println(stringSeat.toString());
    }

    public int calculatePrice(int rows, int columns) {
        int calculate;

        if (rows * columns > 60) {
            calculate = ( rows / 2 ) * columns * 10 + (rows - rows / 2) * columns * 8;
        } else {
            calculate = rows * columns * 10;
        }

        return calculate;

    }


}
