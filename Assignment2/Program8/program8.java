import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvestmentCalculator {
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Investment Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel with GridLayout (4 rows, 2 columns)
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Labels and text fields
        JLabel l1 = new JLabel("Principal:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Rate (%):");
        JTextField t2 = new JTextField();

        JLabel l3 = new JLabel("Years:");
        JTextField t3 = new JTextField();

        JLabel l4 = new JLabel("Future Value:");
        JTextField t4 = new JTextField();
        t4.setEditable(false);

        JButton calc = new JButton("Calculate");

        // Add components to panel
        panel.add(l1); panel.add(t1);
        panel.add(l2); panel.add(t2);
        panel.add(l3); panel.add(t3);
        panel.add(l4); panel.add(t4);
        panel.add(new JLabel()); // empty cell for spacing
        panel.add(calc);

        // Add panel to frame
        frame.add(panel);
        frame.setSize(400, 250);
        frame.setVisible(true);

        // Action listener for calculation
        calc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double principal = Double.parseDouble(t1.getText());
                    double rate = Double.parseDouble(t2.getText()) / 100;
                    int years = Integer.parseInt(t3.getText());

                    double futureValue = principal * Math.pow(1 + rate, years);
                    t4.setText(String.format("%.2f", futureValue));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter numbers.");
                }
            }
        });
    }
}
