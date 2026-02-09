import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private TicTacToeViewer window;


    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param r the row the square is in
     * @param c the column the square is in
     */
    public Square(TicTacToeViewer Window, int r, int c) {
        row = r;
        col = c;
        marker = TicTacToe.BLANK;
        isWinningSquare = false;
        window = Window;
    }

    public void draw(Graphics g) {
        final int SIZE = TicTacToeViewer.SIZE;
        final int TOP = TicTacToeViewer.TOP;
        final Image xImage = window.xImage;
        final Image oImage = window.oImage;

        int x = SIZE*(col + 1);
        int y = SIZE*(row + 1) + TOP;

        // Winning highlight
        if (isWinningSquare()) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, SIZE, SIZE);
        }

        // Square border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, SIZE, SIZE);

        // Marker image
        if (getMarker().equals(TicTacToe.X_MARKER)) {
            g.drawImage(xImage, x + SIZE/10, y + SIZE/10, SIZE*4/5, SIZE*4/5, window);
        } else if (getMarker().equals(TicTacToe.O_MARKER)) {
            g.drawImage(oImage, x + SIZE/10, y + SIZE/10, SIZE*4/5, SIZE*4/5, window);
        }

        //g.draw();
        return;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    public boolean isWinningSquare() {
        return isWinningSquare;
    }


    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
