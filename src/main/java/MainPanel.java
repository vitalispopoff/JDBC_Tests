

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class MainPanel extends JPanel {

Action query_1_Action = new QueryAction();

    public MainPanel() {
        super();
        setBounds(20, 20,  600, 400);
//        setBackground(new Color(255,255,0, 64));
        setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(0,0, 400, 400);
//        label.setBackground(new Color(255,0,255,64));
        label.setBorder(new LineBorder(new Color(0,0,0),1,true));
        add(label);

        JPanel panelRight = new JPanel(new GridLayout(8,1));
        panelRight.setBounds(420,0, 160,400);
//        panelRight.setBackground(new Color(0,255,255,128));

        add(panelRight);
        JButton button_1 = new JButton(query_1_Action);
        panelRight.add(button_1);
    }

    class QueryAction extends AbstractAction {

        QueryAction(){}


        @Override
        public void actionPerformed(ActionEvent e) {

            /*try {
                new DatabaseAppNSFW().request_1();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }*/


        }
    }
}
