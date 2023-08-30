
package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;//for calendar
import java.text.*;//for simple date formate
import java.net.*;// for making of server class
import java.io.*;


 public class Server //extends JFrame/*this JFrame class is used for making frame, here we are not extending but making static frame */
              implements ActionListener{//implement interface for mouse action
         
         JTextField text;//globally declaring the value of text field written by user
         JPanel a1;// globally decalring so the value get append over the JPanel a1
         static Box vertical = Box.createVerticalBox();//to arrange message vertically
        static JFrame f =new JFrame();//making static object of JFrame so that we can use it from static context as well
       static DataOutputStream dout;//globally declaring data outputstream, statically
       Server(){
          
     
        
        // PANEL MAKING
        f.setLayout(null);
        
        JPanel p1=new JPanel();//making class and object of panel named p1 over frame
        p1.setBackground(new Color(255,0,0 ));//giving color to the panel made over frame
        p1.setBounds(0,0,450,70);//top left with 00and length and height
        p1.setLayout(null); //to pick setBound
        f.add(p1);//the panel made by add function is to be added over frame
        
        //NOW WE WILL ADD ICON OVER PANEL
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/arrow.png"));
        //to pick image from file directory we have to make the class 'ImageIcon'
        //there is a class so there should be its object 'new ImageIcon'
        //'ClassLoader' is used to pick image from file directory
        //'getSystemResource' is a static method class loader 
        // and inside static meathod class loader we have to pass the address of image
        
        //IMAGE SCALING INCLUDED IN AWT LIB

      Image i2=i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel back = new JLabel(i3);
      /*now we have to set icon over frame but we cannot do it directly 
          so we will make a JLabel back class and its obect
          and also pass image icon(i1) inside object of JLabel*/
      back.setBounds(5,20,25,25);// setting dimension of icon
      p1.add(back);
        //by using add function we have added it over frame,but still not visible 
        //because we have added it over frame not over panel ...so added p1 to make it visible over panel
        
        //ACTION ON BACK BUTTON
        back.addMouseListener(new MouseAdapter(){
            //addMouseListener is a function given to back button
            //new Mouse Adapter is the object
         public void mouseClicked(MouseEvent ae){//method
        System.exit(0);}//it is used to close the project
        //we can mention the function of mouse click
         //here we want to close the frame
});
        
        //ADD PROFILE PICTURE 
        // CODE is same as adding arrow over frame, just chnaging parameters & declerations i1 ,i2...
        ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));
        Image i5=i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);//image size change
      ImageIcon i6= new ImageIcon(i5);
      JLabel profile = new JLabel(i6);
      profile.setBounds(40,10,50,50);//position chnage
       p1.add(profile);
       
       // ADDING VIDEO CALLING ICON
        ImageIcon i7 =new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8=i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);//image size change
      ImageIcon i9= new ImageIcon(i8);
      JLabel video = new JLabel(i9);
      video.setBounds(300,20,30,30);//position chnage
       p1.add(video);
       
       // ADDING PHONE CALLING ICON
        ImageIcon i10 =new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11=i10.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);//image size change
      ImageIcon i12= new ImageIcon(i11);
      JLabel phone = new JLabel(i12);
      phone.setBounds(345,20,30,30);//position chnage
       p1.add(phone);
       
         // ADDING PHONE CALLING ICON
        ImageIcon i13 =new ImageIcon(ClassLoader.getSystemResource("icons/morevert.png"));
        Image i14=i13.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);//image size change
      ImageIcon i15= new ImageIcon(i14);
      JLabel morevert = new JLabel(i15);
      morevert.setBounds(400,20,30,30);//position chnage
       p1.add(morevert);
       
       // ADDING USERNAME ICON
       // using JLabel we can write anything over frame
       JLabel name = new JLabel("Gaitonde");
       name.setBounds(110,15,100,18);//adding position and dimensions
       name.setForeground(Color.WHITE);// changing color of text color
       name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
       p1.add(name);//adding name over pannel ,otherwise will not be visible
       
       
       
       //ADDING STATUS-ACTIVE NOW
       JLabel status = new JLabel("Active Now");
       status.setBounds(110,35,100,18);//adding position and dimensions
       status.setForeground(Color.WHITE);// changing color of text color
        name.setFont(new Font("SAN_SERIF",Font.BOLD,14));
       p1.add(status);//adding name over pannel ,otherwise will not be visible
       
       
       
       //making one more panel over frame for text region
      /*Remove JPanel local declaration*/
       a1 = new JPanel();
       a1.setBounds(5,75,425,570);
       f.add(a1);//panel added over frame
       
    //user can write their message
       text= new JTextField();
       //JTextField is class using which can write his message
       //so we made class, thus its object
       text.setBounds(5,655,310,40);//messgae writing region
       text.setFont(new Font("SAN_SERIF",Font.PLAIN, 16));//font of text by user
       f.add(text);
       
       //ADDING SEND BUTTON
       JButton send =new JButton("Send");//specified class is there,so we make class & object
       send.setBounds(320,655,123,40);
       send.setBackground(new Color(7,94,84));//Without this default 'send' button will be shown 
       send.setForeground(Color.WHITE);
       send.addActionListener(this);//for adding action on clicking
       send.setFont(new Font("SAN_SERIF",Font.PLAIN, 16));//font of 'send' written to send
       
       f.add(send);
       
       //SHOWING OF MESSAGE ON CLICKING SEND BUTTON
       // in other words ClickEvent is needed on send button
       
       /*text field is declared inside the constructor but we have to declare it globally 
       so we can use it inside constructor as well outside */
       /*now at send button click we want value from text field and 
       we will write it under action performed function, outside the constructor*/
       
       /*Now, the message written,should get append over JPanel a1(2nd panel)
       and for this declare JPanel a1 globally*/
       
       
       
       
       
       
       //frame
         f.setSize(450,700);//set size of frame
        f.setLocation(200,50);//set location of frame otherwise willbe shown in right corner
        f.getContentPane().setBackground(Color.WHITE);//getContentPane()is static class used for selecting whole backgrond and giving it white color
        //setUndecorated(true);//to remove header of frame
        f.setVisible(true);//frame is build succrsfully but will not be seen withoutsetVisible
        
        
        
        
        
        
   
    }
public void actionPerformed(ActionEvent ae){
    //put it in try and catch and perform exceptional handiling
   try{
    
    String out=text.getText();
    //text is object of JText
    //using it with get.Text function whose role is to extract value from inside text field
    // and we can store this value in string
    
    a1.setLayout(new BorderLayout());
    // at panel a1 we want a BorderLayout in which the send text will be written
    //so made an object of BorderLayout
    //BorderLayout place elements at top,buttom,left, right and center
    // we want text at right side of frame
    JPanel right = new JPanel (new BorderLayout());
    // we made a new JPanel class with its object and passed BorderLayout in object
    //we want text send by user in right corner only
    
    JLabel output = new JLabel(out);
    //JPanel p2 =new JPanel();//but we have taken return type of formatlabel below while formating the the send message, so
    JPanel p2 = formatLabel(out);
   // p2.add(output);
    
    right.add(p2, BorderLayout.LINE_END);
     //right.add(out, BorderLayout.LINE_END);...we canot add (out)because its a string
     // so we made a Label named output and passed it in JPanel p2 , above and then added p2 panel 
    // we have to add out(text by sender) in right
    // and also want to set that (out) in BorderLayout and also at line end  
    
    vertical.add(right);// for multiple messages to get allign vertically
    vertical.add(Box.createVerticalStrut(15));// for creating distance of height 15, vertically
    
    a1.add(vertical, BorderLayout.PAGE_START);//adding that verticals messages and border at page start of panel a1
    
    dout.writeUTF(out);//method for sending message in outbox
    
    
    // FOR EMPETING THE TEXTBOX AFTER SENDING MSG
    text.setText("");// set text empty
    
    f.repaint();
    f.invalidate(); 
    f.validate();
    //all these function s are used to reload the frame
   }catch (Exception e){
       e.printStackTrace();//exception handling
   }
}

//formating of the message send by the user
// making a static function for this formating
public static JPanel formatLabel(String out){
//passing out that string by sender

JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
JLabel output = new JLabel(out);
output.setFont(new Font("Tahoma",Font.PLAIN,16));// font for text written by user
output.setBackground(new Color(37,211,102));//background color of text written by user
output.setOpaque(true);
output.setBorder(new EmptyBorder(15,15,15,50));

panel.add(output);// adding it to the panel

// ADDING TIME BELOW THE MESSAGE

Calendar cal= Calendar.getInstance();//by using java calender class we can add time below the message send by the user
SimpleDateFormat sdf =new SimpleDateFormat("HH:mm");

JLabel time = new JLabel();// it is used to put sth on panel

time.setText(sdf.format(cal.getTime()));// this function is used for dynamically setting value in JLabel
panel.add(time);
return panel;
}
    
    public static void main(String[] args){
        new Server();
        //SOCKET PROGRAMMING
        // we made a try and catch classes for socket prog.
        try {
            ServerSocket skt = new  ServerSocket(6001);// running server socket at port 6001
            while(true) {// its infinite while loop , so that unlimited of messages can be accepted
                Socket s = skt.accept();// accepted messages are stored in Socket s
                DataInputStream din= new DataInputStream(s.getInputStream());//for receiving messages
                 dout= new DataOutputStream(s.getOutputStream());// for sending,declare it globally
                
                while(true){
                    String msg = din.readUTF();
                    //readUTF method is used for reading received messages 
                    JPanel panel = formatLabel(msg);//formate is already given to the message
                    JPanel left = new JPanel(new BorderLayout());// adding received message to the left of frame
                    left.add(panel, BorderLayout.LINE_START);
                    /*make the validate and vertical functions static because
                    we cannot call nonstatic function from main function(main fun is static function)*/
                    vertical.add(left);
                    f.validate();
                }
                
            }
        }catch(Exception e){//for catching exceptions
            e.printStackTrace();
        }
    }
}
