import javax.swing.*;

public class AssignmentUI extends JFrame {

    AssignmentManager manager = new AssignmentManager();

    JTextField titleField, subjectField, deadlineField;
    JComboBox<String> priorityBox;
    JTextArea displayArea;

    public AssignmentUI() {

        setTitle("Assignment Deadline Tracker");
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Title:");
        l1.setBounds(20, 20, 100, 25);
        add(l1);

        titleField = new JTextField();
        titleField.setBounds(120, 20, 150, 25);
        add(titleField);

        JLabel l2 = new JLabel("Subject:");
        l2.setBounds(20, 60, 100, 25);
        add(l2);

        subjectField = new JTextField();
        subjectField.setBounds(120, 60, 150, 25);
        add(subjectField);

        JLabel l3 = new JLabel("Deadline:");
        l3.setBounds(20, 100, 100, 25);
        add(l3);

        deadlineField = new JTextField();
        deadlineField.setBounds(120, 100, 150, 25);
        add(deadlineField);

        JLabel l4 = new JLabel("Priority:");
        l4.setBounds(20, 140, 100, 25);
        add(l4);

        priorityBox = new JComboBox<>(new String[]{"High", "Medium", "Low"});
        priorityBox.setBounds(120, 140, 150, 25);
        add(priorityBox);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(20, 180, 80, 30);
        add(addBtn);

        JButton showBtn = new JButton("Show");
        showBtn.setBounds(110, 180, 80, 30);
        add(showBtn);

        JButton doneBtn = new JButton("Done");
        doneBtn.setBounds(200, 180, 80, 30);
        add(doneBtn);

        JButton delBtn = new JButton("Delete");
        delBtn.setBounds(290, 180, 100, 30);
        add(delBtn);

        displayArea = new JTextArea();
        displayArea.setBounds(20, 230, 540, 200);
        add(displayArea);
        // ADD
        addBtn.addActionListener(e -> {
            manager.add(new Assignment(
                    titleField.getText(),
                    subjectField.getText(),
                    deadlineField.getText(),
                    (String) priorityBox.getSelectedItem()
            ));
            displayArea.setText("Assignment Added ✅");
        });
        // SHOW
        showBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            for (Assignment a : manager.getAll()) {
                sb.append(a.title).append(" | ")
                        .append(a.subject).append(" | ")
                        .append(a.deadline).append(" | ")
                        .append(a.priority).append(" | ")
                        .append(a.completed ? "Done ✅" : "Pending ⏳")
                        .append("\n");
            }

            displayArea.setText(sb.toString());
        });
        // DONE
        doneBtn.addActionListener(e -> {
            manager.markDone(titleField.getText());
            displayArea.setText("Marked as Done");
        });
        // DELETE
        delBtn.addActionListener(e -> {
            manager.delete(titleField.getText());
            displayArea.setText("Deleted (if found)");
        });

        setVisible(true);
    }
}
