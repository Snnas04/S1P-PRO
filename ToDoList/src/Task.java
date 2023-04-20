import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.BorderLayout;

class Task extends JPanel {
    JLabel index;
    JTextField taskName;
    JButton done;
    JButton eliminate;

    Color uncomplete = new Color(255, 161, 161);
    Color doneButtonUncomplete = new Color(255, 71, 26);
    Color complete = new Color(188, 226, 158);
    Color doneButtonComplete = new Color(51, 255, 51);
    Color doneButton = new Color(0, 51, 204);

    private boolean checked;

    Task() {
        this.setPreferredSize(new Dimension(400, 20)); // set size of task
        this.setBackground(uncomplete); // set background color of task

        this.setLayout(new BorderLayout()); // set layout of task

        checked = false;

        index = new JLabel(""); // create index label
        index.setPreferredSize(new Dimension(20, 20)); // set size of index label
        index.setHorizontalAlignment(JLabel.CENTER); // set alignment of index label
        index.setFont(new Font("Arial", Font.BOLD, 20));

        this.add(index, BorderLayout.WEST); // add index label to task

        taskName = new JTextField("Task"); // create task name text field
        taskName.setFont(new Font("Arial", Font.PLAIN, 18));
        taskName.setBorder(BorderFactory.createEmptyBorder()); // remove border of text field
        taskName.setBackground(uncomplete); // set background color of text field

        this.add(taskName, BorderLayout.CENTER);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(80, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setFont(new Font("Arial", Font.BOLD, 20));
        done.setBackground(doneButton);
        done.setForeground(doneButtonUncomplete);
        done.setFocusPainted(false);

        this.add(done, BorderLayout.EAST);
    }

    public void changeIndex(int num) {
        this.index.setText(num + ""); // num to String
        this.revalidate(); // refresh
    }

    public JButton getDone() {
        return done;
    }

    public JButton getEliminate() {
        return eliminate;
    }

    public boolean getState() {
        return checked;
    }

    public void changeState() {
        this.setBackground(complete);
        taskName.setBackground(complete);
        taskName.setText("Task done!");
        done.setForeground(doneButtonComplete);
        checked = true;
        revalidate();
    }
}
