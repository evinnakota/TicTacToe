import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private TicTacToe game;

    public Image xImage;
    public Image oImage;

    public static final int SIZE = 120; // pixel size of one square
    public static final int TOP = 25; // pixel height of title bar

    public TicTacToeViewer(TicTacToe game) {
        this.game = game;


        setTitle("TicTacToe");
        setSize((2+TicTacToe.SIZE)*SIZE,
                (2+TicTacToe.SIZE)*SIZE + TOP);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();

        setVisible(true);
    }

    public void paint(Graphics g) {

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 14));

        // numbers on axes
        for (int i = 0; i < 3; i++) {
            g.drawString("" + i, SIZE*i + SIZE*3/2, SIZE - 10 + TOP);
            g.drawString("" + i, SIZE - 20, SIZE*i + SIZE*3/2 + TOP + 5);
        }

        Square[][] board = game.getBoard();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].draw(g);
            }
        }

        if (!game.getGameOver()) return;

        g.setColor(Color.BLACK);
        final int textSize = Math.min(24,SIZE);
        g.setFont(new Font("Arial", Font.BOLD, textSize));

        if (game.checkTie()) {
            g.drawString("It's a Tie!", 5*SIZE/2-textSize*2, (9*SIZE)/2 + TOP + textSize/3);
            xImage = new ImageIcon("Resources/csduck.png").getImage();
            oImage = new ImageIcon("Resources/menlo.png").getImage();
            for (Square[] row : board) {
                for (Square s : row) {
                    s.draw(g);
                }
            }
        } else {
            g.drawString(game.getWinner() + " Wins", 5*SIZE/2-textSize*3/2, (9*SIZE)/2 + TOP + textSize/3);
        }
    }
}













