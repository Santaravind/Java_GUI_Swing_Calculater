import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.TextField;
public class  InterestCalculator extends Frame implements ActionListener {
     Label plabel,rlabel,slabel,alabel,tlabel;
     TextField p,r,s,a,t;
     Button clear,Calculate;
     InterestCalculator(){  
          //Frame property
          this.setTitle("Simple Interest Calcutator");
          this.setLayout(null);
          this.setSize(500,500);
          this.setVisible(true);
           
           // Light gray background
          this.setBackground(new Color(200, 220, 240));
          
          //Window closing 
          this.addWindowListener(new WindowAdapter(){ 
               public void windowClosing(WindowEvent e){
                    System.exit(0);
               }
          });

            //Creating Font 
            Font f=new Font("consolase",Font.BOLD,20);

            //create Lable
            plabel=new Label("Principle:  ");
            plabel.setFont(f);
            plabel.setBounds(50,50,100,30);

            rlabel=new Label("Rate:  ");
            rlabel.setFont(f);
            rlabel.setBounds(50,100,100,40);

            tlabel =new Label("Time:  ");
            tlabel.setFont(f);
            tlabel.setBounds(50,150,100,40);

            slabel=new Label("Simple interest ");
            slabel.setFont(f);
            slabel.setBounds(50,200,150,40);

            alabel=new Label("Amount ");
            alabel.setFont(f);
            alabel.setBounds(50,250,100,40);

          //Creating TextField
          //TextField p,r,s,a,t;
          p=new TextField("Enter Principle");
          p.setFont(f);
          p.setBounds(200,50,200,40);     
            
          r=new TextField("Enter Rate");
          r.setFont(f);
          r.setBounds(200,100,200,40);     
          
          t=new TextField("Time in year");
          t.setFont(f);
          t.setBounds(200,150,200,40);     
          
          s=new TextField();
          s.setFont(f);
          s.setBounds(200,200,200,40); 
          //meking simple interest textfield uneditable
          s.setEditable(false);

         a =new TextField();
         a.setFont(f);
          a.setBounds(200,250,200,40);     
          a.setEditable(false);

          //Creating Button
          //     Button clear,cal;
         clear =new Button("Clear");
         clear.setFont(f);
         clear.setBounds(50,350,100,40);     
             
         Calculate =new Button("Calculate");
         Calculate.setFont(f);
         Calculate.setBounds(350,350,100,40);     
         
         //adding this GUI componant in Frame
         this.add(plabel);
         this.add(rlabel);
         this.add(tlabel);
         this.add(slabel);
         this.add(alabel);
         
         this.add(p);
         this.add(r);
         this.add(t);
         this.add(s);
         this.add(a);

         this.add(clear);
         this.add(Calculate);
         
         //Register to the button on the actionlistener 
         clear.addActionListener(this);
         Calculate.addActionListener(this); 

     }
     public void actionPerformed(ActionEvent e){
          Button clickButton=(Button)e.getSource();

          String clickButtonLabel=clickButton.getLabel();

          if(clickButtonLabel.equals("Calculate")){
               
               //declaration 
               float pe,sip,amount;
               int rate,time;

               pe=Float.parseFloat(p.getText());
               rate=Integer.parseInt(r.getText());
               time=Integer.parseInt(t.getText());
               
              //calcutating simple interest using farmulas

              sip=(pe*rate*time)/100;
              //set the textfield of simple interest      
              s.setText(Float.toString(sip));

              //calculating amount
              amount=pe+sip;
              //set the textfield of amount 
              a.setText(Float.toString(amount));
              

          }
          else{
               p.setText(" ");
               a.setText(" ");
               s.setText(" ");
               r.setText(" ");
               t.setText(" ");
          }
     }
     public static void main(String[] args) {
          InterestCalculator cl=new InterestCalculator();
     }
}
  