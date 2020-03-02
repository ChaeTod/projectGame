package sample;

import java.util.Random;

public class Field {
    private Tile[][] arr;

    public void setArr(Tile[][] arr) {
        this.arr = arr;
    }

    public Tile[][] getArr() {
        return arr;
    }

    public Field() {
        initGame();
    }

    private void initGame() {
        arr = new Tile[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = new Tile();
            }
        }
    }

    public boolean isWinner() {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].isValue())
                    counter++;
            }
        }
        return counter == 0 || counter == 16;
    }

    public void toggleTiled(int code) {
        int x = code % 4; // column
        int y = code / 4; // row


        //int x = 0;
        //int y = 0;

        /*
            if (x == i  &&  Math.abs(y - j) > 0)
                dir = (y - j) > 0 ? size : -size;
            else if (y == j && Math.abs(x - i) > 0)
                dir = (x - i) > 0 ? 1 : -1;
        */

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (!(x == i && y == j) && Math.abs(x - i) <= 1 && Math.abs(y - j) <= 1) {
                    arr[i][j].toggle();
                }

            }
        }
/*

        if (x > 0) {
            if (!arr[x - 1][y].isValue()) {
                arr[x - 1][y].setValue(true);
                arr[x][y].setValue(false);
            }
        }
        if (x < 3) {
            if (!arr[x + 1][y].isValue()) {
                arr[x + 1][y].setValue(true);
                arr[x][y].setValue(false);
            }
        }
        if (y > 0) {
            if (!arr[x][y - 1].isValue()) {
                arr[x][y - 1].setValue(true);
                arr[x][y].setValue(false);
            }
        }
        if (y < 3) {
            if (!arr[x][y - 1].isValue()) {
                arr[x][y + 1].setValue(true);
                arr[x][y].setValue(false);
            }
        }

         */

    }

    public void shuffle() {
        Random rnd = new Random();
        do {
            for (int i = 0; i < 47; i++)
                toggleTiled(rnd.nextInt(15));
        } while (isWinner());
    }

    public void print() {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i][j].isValue() ? " x " : " 0 ");
            System.out.println();
        }
        System.out.println();
    }
}
