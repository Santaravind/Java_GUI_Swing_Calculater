import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SwingCalcu implements ActionListener  {
     
     JFrame frame;
     JTextField textfield;
     JButton[] numbutt=new JButton[10];
     JButton[] funbutt=new JButton[10];
     JButton addB,subB,multB,divB;
     JButton decB,equB,detB,clrB,negB;
      JPanel panel;

      Font myfont=new Font("Ink Free",Font.BOLD,30);
      double num1=0,num2=0,result=0;
      char operater;
     
      SwingCalcu(){
          frame=new JFrame("Calculation");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(430,550);
          frame.setLayout(null);
          
          //Set the Text field of output
          textfield =new JTextField();
          textfield.setBounds(50,25,320,50);
          textfield.setFont(myfont);
          textfield.setEditable(false);
          textfield.setBackground(Color.GRAY);
          
           
          //Creating button
          /*
           * JButton addB,subB,multB,divB;
            JButton decB,equB,detB,clrB;
           */
          addB=new JButton("+");
          subB=new JButton("-");
          multB=new JButton("*");
          divB=new JButton("/");
          decB=new JButton(".");
          equB=new JButton("=");
          detB=new JButton("Delete");
          clrB=new JButton("Clear");
          negB=new JButton("(-)");

          //Add Button on Function array
          funbutt[0]=addB;
          funbutt[1]=subB;
          funbutt[2]=multB;
          funbutt[3]=divB;
          funbutt[4]=decB;
          funbutt[5]=equB;
          funbutt[6]=detB;
          funbutt[7]=clrB;
          funbutt[8]=negB;
           
          for(int i=0; i<9; i++){
               funbutt[i].addActionListener(this);
               funbutt[i].setFont(myfont);
               funbutt[i].setFocusable(false);
          }
           
          //     JButton[] numbutt=new JButton[10];

          for(int i=0; i<10; i++){
              numbutt[i]=new JButton(String.valueOf(i));
              numbutt[i].addActionListener(this);
              numbutt[i].setFont(myfont);
              numbutt[i].setFocusable(false); 
          }
          //negB.setBounds(50,430,100,50);
          //detB.setBounds(150,430,100,50);
          //clrB.setBounds(250,430,100,50);
          negB.setBounds(50,430,100,50);
          detB.setBounds(150,430,120,50);
          clrB.setBounds(250,430,120,50);


          //Create a panal
          //JPanel panel;
          panel =new JPanel();
          //panel.setBounds(50,100,300,300);
          panel.setBounds(60,100,300,300);
          panel.setLayout(new GridLayout(4,4,8,8));
          panel.setBackground(Color.RED);
           
          panel.add(numbutt[1]);
          panel.add(numbutt[2]);
          panel.add(numbutt[3]);
          panel.add(addB);
          panel.add(numbutt[4]);
          panel.add(numbutt[5]);
          panel.add(numbutt[6]);
          panel.add(subB);
          panel.add(numbutt[7]);
          panel.add(numbutt[8]);
          panel.add(numbutt[9]);
          panel.add(multB);
          panel.add(decB);
          panel.add(numbutt[0]);
          panel.add(equB);
          panel.add(divB);


 
          frame.add(negB);  
          frame.add(panel);
           //adding to the frame 
           frame.add(detB);
           frame.add(clrB);
              
          frame.add(textfield);
          frame.setVisible(true);//set frame visible
            
          //frame closing code
           frame.addWindowListener(new WindowAdapter(){
                public void windowClosing( WindowEvent e){
                    System.exit(0);
                }
           });
     
      }

      public void actionPerformed(ActionEvent e){
            for(int i=0; i<10; i++){
               if(e.getSource()==numbutt[i]){
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
               }
            }
            //For decimel button
            if(e.getSource()==decB){
               textfield.setText(textfield.getText().concat("."));
          }
          //For Addition button 
          if(e.getSource()==addB){
               num1=Double.parseDouble(textfield.getText());
               operater='+';
               textfield.setText("");
          }

          //For subtration button
           
          if(e.getSource()==subB){
               num1=Double.parseDouble(textfield.getText());
               operater='-';
               textfield.setText(" ");
          }

          //for multiplication button
          if(e.getSource()==multB){
               num1=Double.parseDouble(textfield.getText());
               operater='*';
               textfield.setText("");
          }
          
          //For divition button
          if(e.getSource()==divB){
               num1=Double.parseDouble(textfield.getText());
               operater='/';
               textfield.setText("");
          }

          if(e.getSource()==equB){
               num2=Double.parseDouble(textfield.getText());

               switch(operater){
                    case '+':
                    result=num1+num2;
                    break;

                    case '-':
                    result=num1-num2;
                    break;

                    case '*':
                    result=num1*num2;
                    break;
                    
                    case '/':
                    result=num1/num2;
                    break;
                                  
               }
               textfield.setText(String.valueOf(result));
               num1=result;
          }
          
          if(e.getSource()==clrB){
               textfield.setText(" ");

          }
          if(e.getSource()==detB){
               String string=textfield.getText();
               textfield.setText(" ");
               for(int i=0; i<string.length()-1; i++){
                    textfield.setText(textfield.getText()+string.charAt(i));
               }
          }
          
          if(e.getSource()==negB){
             Double temp= Double.parseDouble(textfield.getText());
             temp*=-1;
             //temp = -temp;
             textfield.setText(String.valueOf(temp))   ;

           
          }

      }
     public static void main(String[] args) {
          SwingCalcu sc=new SwingCalcu();
     }
}
