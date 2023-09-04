import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


//creating a class that contains all components and a constructor--->
public class RockPaperScissorsGame extends JFrame {
    private JLabel userLabel;
    private JLabel computerLabel;
    private JLabel resultLabel;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JButton playAgainButton; 
    
    //initializing the Constructor--->

    public RockPaperScissorsGame() {
        setTitle("Rock, Paper, Scissors Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(230, 230, 250));

        JLabel titleLabel = new JLabel("Rock, Paper, Scissors");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        userLabel = new JLabel("User's Choice: ");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        computerLabel = new JLabel("Computer's Choice: ");
        computerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        rockButton = createStyledButton("Rock");
        paperButton = createStyledButton("Paper");
        scissorsButton = createStyledButton("Scissors");
        buttonsPanel.add(rockButton);
        buttonsPanel.add(paperButton);
        buttonsPanel.add(scissorsButton);

        panel.add(userLabel);
        panel.add(computerLabel);
        panel.add(resultLabel);
        panel.add(buttonsPanel);

        // "Play Again" button setup->
        
        playAgainButton = createStyledButton("Play Again");
        playAgainButton.setEnabled(false); // Initially disabled
        panel.add(playAgainButton);

        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Rock");
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Paper");
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Scissors");
            }
        });

        // ActionListener for "Play Again" button
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgain();
            }
        });

        add(panel);
        setVisible(true);
    }

    private JButton createStyledButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    //Defining the logic to choose computer choice unique at each time--->
    private void playGame(String userChoice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int computerIndex = random.nextInt(3);
        String computerChoice = choices[computerIndex];

        userLabel.setText("User's Choice: " + userChoice);
        computerLabel.setText("Computer's Choice: " + computerChoice);

        if (userChoice.equals(computerChoice)) {
            resultLabel.setText("Result: It's a tie!");
        } else if (
            (userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            resultLabel.setText("Result: You win!");
        } else {
            resultLabel.setText("Result: Computer wins!");
        }

        // Enable the "Play Again" button after the game ends
        playAgainButton.setEnabled(true);
    }

    private void playAgain() {
        userLabel.setText("User's Choice: ");
        computerLabel.setText("Computer's Choice: ");
        resultLabel.setText("Result: ");
        playAgainButton.setEnabled(false); // Disable the button for the next game
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RockPaperScissorsGame();
            }
        });
    }
}
