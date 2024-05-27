import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class Calcnew extends JFrame implements ActionListener {

        JTextField jt1;
        JButton[] numberbuttons = new JButton[10];
        JButton[] functionbuttons = new JButton[8];
        JButton addButton, subButton, multbutton, divdbutton;
        JButton decButton, clrButton, delButton, equButton;
        JPanel panel;

        Font myfont = new Font("Ink Free",Font.BOLD,25);

        double num1 = 0, num2 = 0, result = 0;
        char operator;

        Calcnew(){
            setTitle("Calculator");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 400);
            setLayout(null);

            jt1 = new JTextField();
            jt1.setBounds(50,25,300,50);
            jt1.setFont(myfont);
            jt1.setEditable(false);
            add(jt1);

            addButton = new JButton("+");
            subButton = new JButton("-");
            multbutton = new JButton("*");
            divdbutton = new JButton("/");
            decButton = new JButton(".");
            equButton = new JButton("=");
            delButton = new JButton("del");
            clrButton = new JButton("clr");

            functionbuttons[0] = addButton;
            functionbuttons[1] = subButton;
            functionbuttons[2] = multbutton;
            functionbuttons[3] = divdbutton;
            functionbuttons[4] = decButton;
            functionbuttons[5] = equButton;
            functionbuttons[6] = delButton;
            functionbuttons[7] = clrButton;

            for (int i = 0; i<8;i++){
                functionbuttons[i].addActionListener(this);
                functionbuttons[i].setFont(myfont);
                functionbuttons[i].setFocusable(false);
            }
            for (int i = 0; i<10;i++){
                numberbuttons[i] = new JButton(String.valueOf(i));
                numberbuttons[i].addActionListener(this);
                numberbuttons[i].setFont(myfont);
                numberbuttons[i].setFocusable(false);
            }
            panel = new JPanel();
            panel.setBounds(50,100,300,300);
            panel.setLayout(new GridLayout(4,4,10,10));
            add(panel);

            panel.add(numberbuttons[1]);
            panel.add(numberbuttons[2]);
            panel.add(numberbuttons[3]);
            panel.add(addButton);
            panel.add(numberbuttons[4]);
            panel.add(numberbuttons[5]);
            panel.add(numberbuttons[6]);
            panel.add(subButton);
            panel.add(numberbuttons[7]);
            panel.add(numberbuttons[8]);
            panel.add(numberbuttons[9]);
            panel.add(multbutton);
            panel.add(decButton);
            panel.add(numberbuttons[0]);
            panel.add(equButton);
            panel.add(divdbutton);

            clrButton.setBounds(205,430,145,50);
            delButton.setBounds(50,430,145,50);
            add(clrButton);
            add(delButton);

            setVisible(true);
    }
public static void main(String[] args) {

    Calcnew c1 = new Calcnew();
}
    @Override
    public void actionPerformed(ActionEvent e) {
            for (int i = 0; i<10;i++){
                if(e.getSource()==numberbuttons[i]){
                    jt1.setText(jt1.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource()==decButton){
                jt1.setText(jt1.getText().concat("."));
            }
            if (e.getSource()==addButton){
                num1 = Double.parseDouble(jt1.getText());
                operator = '+';
                jt1.setText("");
            }
            if (e.getSource()==subButton) {
                num1 = Double.parseDouble(jt1.getText());
                operator = '-';
                jt1.setText("");
            }
            if (e.getSource()==multbutton) {
                num1 = Double.parseDouble(jt1.getText());
                operator = '*';
                jt1.setText("");
            }
            if (e.getSource()==divdbutton) {
                num1 = Double.parseDouble(jt1.getText());
                operator = '/';
                jt1.setText("");
            }
            if(e.getSource()==equButton){
                num2 = Double.parseDouble(jt1.getText());
                if (operator == '+'){
                    result = num1+num2;
                }
                if (operator == '-'){
                    result = num1-num2;
                }
                if (operator == '*'){
                    result = num1*num2;
                }
                if (operator == '/'){
                    result = num1/num2;
                }
                jt1.setText(String.valueOf(result));
                num1 = result;
            }
            if(e.getSource()==clrButton){
                jt1.setText("");
            }

    }
}
