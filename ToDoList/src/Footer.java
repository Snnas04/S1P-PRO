import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;

class Footer extends JPanel {
    JButton addTask;
    JButton clear;
    JButton clearAll;

    Color button = new Color(0, 0, 102);
    Color addTaskButton = new Color(204, 255, 255);
    Color clearButton = new Color(51, 255, 51);
    Color clearAllButton = new Color(255, 71, 26);
    Color bgColor = new Color(128, 212, 255);
    Border emptyBorder = BorderFactory.createEmptyBorder();

    Footer() {

        this.setPreferredSize(new Dimension(400, 80));
        this.setBackground(bgColor);

        addTask = new JButton("Add Task"); // add task button
        addTask.setBorder(emptyBorder); // remove border
        addTask.setFont(new Font("Arial", Font.BOLD, 20)); // set font
        addTask.setPreferredSize(new Dimension(100, 40));
        addTask.setBackground(addTaskButton); // set background color
        addTask.setForeground(button);
        this.add(addTask); // add to footer

        this.add(Box.createHorizontalStrut(20)); // Space between buttons

        clear = new JButton("Clear finished tasks"); // clear button
        clear.setFont(new Font("Arial", Font.BOLD, 20)); // set font
        clear.setPreferredSize(new Dimension(220, 40));
        clear.setBorder(emptyBorder); // remove border
        clear.setBackground(clearButton); // set background color
        clear.setForeground(button);
        this.add(clear); // add to footer

        this.add(Box.createHorizontalStrut(20)); // Space between buttons

        clearAll = new JButton("Clear all tasks");
        clearAll.setFont(new Font("Arial", Font.BOLD, 20)); // set font
        clearAll.setPreferredSize(new Dimension(160, 40));
        clearAll.setBorder(emptyBorder); // remove border
        clearAll.setBackground(clearAllButton); // set background color
        clearAll.setForeground(button);
        this.add(clearAll); // add to footer
    }

    public JButton getNewTask() {
        return addTask;
    }

    public JButton getClear() {
        return clear;
    }

    public JButton getClearAll() {
        return clearAll;
    }
}
