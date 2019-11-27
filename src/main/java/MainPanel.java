

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {

    Action query_1_Action = new Query_1_Action();
    Action dropTablesAction = new DropTablesAction();
    Action rebuildTablesAction = new RebuildTablesAction();

    public MainPanel() {
        super();
        setBounds(20, 20, 600, 400);
//        setBackground(new Color(255,255,0, 64));
        setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(0, 0, 400, 400);
//        label.setBackground(new Color(255,0,255,64));
        label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(label);

        JPanel panelRight = new JPanel(new GridLayout(8, 1));
        panelRight.setBounds(420, 0, 160, 400);
//        panelRight.setBackground(new Color(0,255,255,128));

        add(panelRight);
        JButton button_1 = new JButton(query_1_Action);
        button_1.setText("Filmy z 2018 r.");
        panelRight.add(button_1);

        JButton button_2 = new JButton(dropTablesAction);
        button_2.setText("Usuń tabele");
        panelRight.add(button_2);

        JButton button_3 = new JButton(rebuildTablesAction);
        button_3.setText("Odbuduj tabele");
        panelRight.add(button_3);

        JButton button_4 = new JButton(rebuildTablesAction);
        button_4.setText("Odtwórz zawartość tabeli");
        panelRight.add(button_4);
    }

    class Query_1_Action extends AbstractAction {

        Query_1_Action() {}


        @Override
        public void actionPerformed(ActionEvent e) {

            Queries query = new Queries();
            query.establishConnection();
            query.makeStatement();
            System.out.println(Ask.question_01(query));
            query.closeStatement();
            query.terminateConnection();


        }
    }

    class DropTablesAction extends AbstractAction {

        DropTablesAction() {}


        @Override
        public void actionPerformed(ActionEvent e) {

            Queries query = new Queries();
            query.establishConnection();
            query.makeStatement();
            Ask.dropTables(query);
            query.closeStatement();
            query.terminateConnection();


        }
    }

    class RebuildTablesAction extends AbstractAction {

        RebuildTablesAction() {}


        @Override
        public void actionPerformed(ActionEvent e) {

            Queries query = new Queries();
            query.establishConnection();
            query.makeStatement();
            Ask.rebuildTables(query);
            query.closeStatement();
            query.terminateConnection();


        }
    }

    class RepopulateTablesAction extends AbstractAction {

        RepopulateTablesAction() {}


        @Override
        public void actionPerformed(ActionEvent e) {

            Queries query = new Queries();
            query.establishConnection();
            query.makeStatement();
            Ask.repopulateTables(query);
            query.closeStatement();
            query.terminateConnection();


        }
    }
}
