
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame implements ActionListener {
    int grade;
    float gradePoint;
    private String name;
    private int indexNo;

    private JTextField textField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField indexField = new JTextField();

    private List<JTextField> gradeFields = new ArrayList<>();
    private JButton calculateButton = new JButton("Calculate CGPA");
    private JTextArea resultArea = new JTextArea(5, 10);

    private JButton submiButton = new JButton("Submit");

    // constructor
    public void CGPAGUI() {

        setTitle("CGPA CALCULATOR");
        setSize(300, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Name: "));
        panel.add(nameField);

        panel.add(new JLabel("Index Number: "));
        panel.add(indexField);

        panel.add(submiButton);
        submiButton.addActionListener(this);

        panel.add(new JLabel("ENTER GRADES: "));
        calculateButton.addActionListener(this);
        panel.add(calculateButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        add(panel);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submiButton) {
            gradeFields();
        } else if (e.getSource() == calculateButton) {
            calculateCGPA();
        }
    }

    private void gradeFields() {
        gradeFields.clear();
        int numOfGrades = 8;

        JPanel gradePanel = new JPanel(new GridLayout(numOfGrades, 2));

        for (int i = 0; i <= numOfGrades; i++) {
            JTextField gradeField = new JTextField(3);

            gradeFields.add(gradeField);
            gradePanel.add(new JLabel("Grade " + i + ":"));
            gradePanel.add(gradeField);
        }
        JFrame frame = new JFrame("Enter Grades: ");
        frame.getContentPane().add(gradePanel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.CGPAGUI();
    }

    private void calculateCGPA() {
        double totalGradePoints = 0;
        // make adjustments later
        int totalCredits = gradeFields.size();
        for (JTextField gradeField : gradeFields) {
            try {
                int grade = Integer.parseInt(gradeField.getText());

                totalGradePoints += grade;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Grade: " + gradeField.getText());
            }
        }
        double cgpa = totalGradePoints / totalCredits;
        resultArea.setText("CGPA: " + cgpa);
    }
}
