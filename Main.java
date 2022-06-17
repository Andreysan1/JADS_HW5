package jads.lesson5;

public class Main {
    private static int powerRec(int a, int b) {
        return (b == 0) ? 1 : powerRec(a, b - 1) * a;
    }

    private static int[][] moves = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };

    private static boolean isPossible(int[][] desk, int x, int y) {
        return x >= 0 && x < desk[0].length &&
                y >= 0 && y < desk.length &&
                desk[y][x] == 0;
    }

    private static boolean knight(int[][] desk, int x, int y, int move) {
        desk[y][x] = move;
        if (move > desk.length * desk[0].length - 1) return true;

        int nextX;
        int nextY;
        for (int i = 0; i < moves.length - 1; i++) {
            nextX = x + moves[i][0];
            nextY = y + moves[i][1];
            if (isPossible(desk, nextX, nextY)
                    && knight(desk, nextX, nextY, move + 1))
                return true;
        }
        desk[y][x] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int y = 0; y < desk.length; y++) {
            for (int x = 0; x < desk[y].length; x++) {
                System.out.printf("%3d", desk[y][x]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] desk = new int[6][6];
        knight(desk, 0, 0, 1);
        printDesk(desk);
    }
}
