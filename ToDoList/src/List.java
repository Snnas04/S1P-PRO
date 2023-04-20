import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

class List extends JPanel {
    Color bgColor = new Color(128, 212, 255);

    List() {
        GridLayout layout = new GridLayout(10, 1);
        layout.setVgap(5); // Vertical gap

        this.setLayout(layout); // 10 tasks
        this.setPreferredSize(new Dimension(400, 560));
        this.setBackground(bgColor);
    }

    public void updateNumbers() {
        Component[] listItems = this.getComponents();

        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i] instanceof Task) {
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }
    }

    public void removeCompletedTasks() {

        for (Component complete : getComponents()) {
            if (complete instanceof Task) {
                if (((Task) complete).getState()) {
                    remove(complete); // remove the component
                    updateNumbers(); // update the indexing of all items
                }
            }
        }
    }

    public void removeAllTasks() {
        for (Component all : getComponents()) {
            if (all instanceof Task) {
                remove(all); // remove the component
            }
        }
    }
}
