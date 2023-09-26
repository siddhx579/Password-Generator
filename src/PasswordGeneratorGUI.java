import javax.swing.*;
import java.awt.*;

//this class will work as the frontend
//this class will be inherited from the JFrame class
public class PasswordGeneratorGUI extends JFrame {
    private final PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI(){
        //render frame and add title
        super("Password Generator");

        //set the size of the GUI
        setSize(540, 540);

        //set the color of the application window
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.decode("#DDF2FD"));

        //prevent the GUI from being resized
        setResizable(false);

        //we will set the layout to be null to have control over the position and size of our components in our app
        setLayout(null);

        //terminate the program when the GUI is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //center the GUI to the screen
        setLocationRelativeTo(null);

        //init password generator
        passwordGenerator = new PasswordGenerator();

        //render GUI components
        addGUIComponents();
    }

    private void addGUIComponents(){
        //create title text
        JLabel titleLabel = new JLabel("Password Generator");

        //increase the font size and make it bold
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        //center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y coordinates and width/height values
        titleLabel.setBounds(0, 10, 540, 42);

        //add to GUI
        add(titleLabel);

        //create result text area
        JTextArea passwordOutput = new JTextArea();

        //prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        //add scroll-ability in case the output becomes too big
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 85, 479, 45);

        //create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        //create password length label
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 28));
        passwordLengthLabel.setBounds(25, 180, 272, 39);
        add(passwordLengthLabel);

        //create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(260, 180, 230, 40);
        add(passwordLengthInputArea);

        //create toggle buttons
        //uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("UpperCase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        uppercaseToggle.setBounds(25, 260, 225, 56);
        uppercaseToggle.setForeground(Color.BLACK);
        uppercaseToggle.setBackground(Color.decode("#CCEECC"));
        add(uppercaseToggle);

        //lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("LowerCase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        lowercaseToggle.setBounds(275, 260, 225, 56);
        lowercaseToggle.setForeground(Color.BLACK);
        lowercaseToggle.setBackground(Color.decode("#CCEECC"));
        add(lowercaseToggle);

        //number toggle
        JToggleButton numberToggle = new JToggleButton("Numbers");
        numberToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        numberToggle.setBounds(25, 341, 225, 56);
        numberToggle.setForeground(Color.BLACK);
        numberToggle.setBackground(Color.decode("#CCEECC"));
        add(numberToggle);

        //symbols toggle
        JToggleButton symbolToggle = new JToggleButton("Symbols");
        symbolToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        symbolToggle.setBounds(275, 341, 225, 56);
        symbolToggle.setForeground(Color.BLACK);
        symbolToggle.setBackground(Color.decode("#CCEECC"));
        add(symbolToggle);

        //create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155,425,222,51);
        generateButton.setForeground(Color.BLACK);
        generateButton.setBackground(Color.decode("#A5AAAB"));
        generateButton.addActionListener(e -> {
            //validation: generate a password only when length > 0 and one of the toggled button is pressed
            if(passwordLengthInputArea.getText().length() <= 0) return;
            boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || numberToggle.isSelected() || symbolToggle.isSelected();

            //generate password
            int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
            if(anyToggleSelected){
                String generatedPassword = passwordGenerator.generatePassword(passwordLength, uppercaseToggle.isSelected(), lowercaseToggle.isSelected(), numberToggle.isSelected(), symbolToggle.isSelected());

                //display password back to the user
                passwordOutput.setText(generatedPassword);
            }
        });
        add(generateButton);
    }
}
