package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Board;
import Model.PlayerRoster;

public class GameBoard extends JPanel implements ActionListener{ 
    
    public static final int NUM_OF_BUTTONS = 9;

    public JButton[] buttons;
    public JPanel TurnDisplayer;
    private JPanel GameGrid;

    public JLabel turnLabel;

    Board board;
    PlayerRoster pr;

    public GameBoard(Board board, PlayerRoster pr) {
        this.board = board;
        this.pr=pr;
        setupGameBoard();
        
    }

    public void setupGameBoard(){
        this.setBackground(Color.WHITE);
        this.setBounds(300, 100, 600, 700);
        this.setLayout(new BorderLayout()); 
        setupTurnDisplayerPanel();
        setupGameGridPanel();
        this.add(this.TurnDisplayer, BorderLayout.NORTH);
        this.add(this.GameGrid, BorderLayout.CENTER);
        initializeButtons(this.GameGrid);
        this.setVisible(true);
    }

    public void setupTurnDisplayerPanel(){
        this.TurnDisplayer = new JPanel();
        this.TurnDisplayer.setBackground(Color.LIGHT_GRAY);
        this.TurnDisplayer.setPreferredSize(new Dimension(600, 100));

        // Create and add turnLabel to display whose turn it is
        turnLabel = new JLabel("X's turn");
        this.TurnDisplayer.add(turnLabel);
    }

    private void setupGameGridPanel(){
        this.GameGrid = new JPanel(new GridLayout(3, 3, 5, 5)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                int width = getWidth();
                int height = getHeight();
                int cellWidth = width / 3;
                int cellHeight = height / 3;
                for (int i = 1; i < 3; i++) {
                    // Draw horizontal lines
                    g2d.drawLine(0, i * cellHeight, width, i * cellHeight);
                    // Draw vertical lines
                    g2d.drawLine(i * cellWidth, 0, i * cellWidth, height);
                }
            }
        };;
        this.GameGrid.setBounds(400, 500, 200, 500);
        this.GameGrid.setBackground(Color.WHITE);
    }

    private void initializeButtons(JPanel panel) {
        buttons = new JButton[NUM_OF_BUTTONS];
        Font buttonFont = new Font("Arial", Font.PLAIN, 130);

        for (int i = 0; i < NUM_OF_BUTTONS; i++) {
            buttons[i] = new JButton();
            buttons[i].setOpaque(false);
            buttons[i].setFocusable(false);
            buttons[i].setForeground(Color.BLACK); // Set the foreground color to black
            buttons[i].setFont(buttonFont); // Set the font for the button text
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setEnabled(false);
            buttons[i].setBorder(BorderFactory.createEmptyBorder());
            panel.add(buttons[i]);
            //buttons[i].addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < NUM_OF_BUTTONS; i++) {
            if (e.getSource() == buttons[i]) {
                
                int row = i/3;
                int col = i%3;

                System.out.println("Button pressed: " +  buttons[i].getText() + " that is :"+ row + ", "+ col);

                board.makeMove(row, col);

                // Update the button text based on the state of the corresponding position on the board
                if (board.getBoard()[row][col] == 'X') {
                    turnLabel.setText("O's turn.");
                    buttons[i].setText("X");
                    buttons[i].setForeground(Color.RED);
                } else if (board.getBoard()[row][col] == 'O') {
                    turnLabel.setText("X's turn.");
                    buttons[i].setText("O");
                    buttons[i].setForeground(Color.BLUE);
                }
 
                // Disable the button after setting the text
                buttons[i].setEnabled(false);
                
                 // Check if the game has finished
                if (board.isGameFinished()) {
                    // If the game has finished, disable all buttons
                    for (JButton button : buttons) {
                        button.setEnabled(false);
                    }
                }
            }
        }
    }

    public void resetBoard(){
        board.initializeBoard();

        for(int i=0; i<NUM_OF_BUTTONS; i++){
            buttons[i].setText(" ");
        }

        board.gameHasFinished=false;

        board.setMoves(Board.MAXIMUM_MOVES);

        board.setFlag(true);
        
        turnLabel.setText("X's turn.");
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public PlayerRoster getPr() {
        return pr;
    }

    public void setPr(PlayerRoster pr) {
        this.pr = pr;
    }
}    