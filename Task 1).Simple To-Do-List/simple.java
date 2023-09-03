import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simple extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> todoListView;
    private JTextField newItemField;

    public simple() {
        // Initialize the JFrame
        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a DefaultListModel to store the To-Do items
        listModel = new DefaultListModel<>();

        // Create a JList to display the To-Do items
        todoListView = new JList<>(listModel);
        todoListView.setBackground(Color.LIGHT_GRAY);

        // Create a JScrollPane for the JList
        JScrollPane scrollPane = new JScrollPane(todoListView);

        // Create a JTextField for entering new items
        newItemField = new JTextField(20);

        // Create "Add" and "Remove" buttons
        JButton addButton = new JButton("Add");
        addButton.setBackground(Color.GREEN);
        JButton removeButton = new JButton("Remove");
        removeButton.setBackground(Color.RED);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = newItemField.getText();
                if (!newItem.isEmpty()) {
                    listModel.addElement(newItem);
                    newItemField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoListView.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Create a JPanel to hold the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.add(newItemField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Set the layout for the main content pane
        setLayout(new BorderLayout());

        // Add the components to the main content pane
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new simple();
            }
        });
    }
}
