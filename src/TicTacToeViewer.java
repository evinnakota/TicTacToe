import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private TicTacToe game;

    private Image xImage;
    private Image oImage;

    private static final int SIZE = 100;
    private static final int START_X = 120;
    private static final int START_Y = 60;

    public TicTacToeViewer(TicTacToe game) {
        this.game = game;


        setTitle("TicTacToe");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();

        setVisible(true);
    }

    public void paint(Graphics g) {

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 14));

        for (int i = 0; i < 3; i++) {
            g.drawString("" + i, 160 + i * SIZE, 50);
            g.drawString("" + i, 90, 135 + i * SIZE);
        }

        Square[][] board = game.getBoard();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int x = START_X + col * SIZE;
                int y = START_Y + row * SIZE;

                Square s = board[row][col];

                // Winning highlight
                if (s.isWinningSquare()) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, SIZE, SIZE);
                }

                // Square border
                g.setColor(Color.BLACK);
                g.drawRect(x, y, SIZE, SIZE);

                // Marker image
                if (s.getMarker().equals(TicTacToe.X_MARKER)) {
                    g.drawImage(xImage, x + 10, y + 10, 80, 80, null);
                } else if (s.getMarker().equals(TicTacToe.O_MARKER)) {
                    g.drawImage(oImage, x + 10, y + 10, 80, 80, null);
                }
            }
        }



        if (!game.getGameOver()) return;

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));

        if (game.checkTie()) {
            g.drawString("It's a Tie!", 160, 500);
        } else {
            g.drawString(game.getWinner() + " Wins", 170, 500);
        }
    }

    }













