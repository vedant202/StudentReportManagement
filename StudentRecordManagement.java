package StudentRecordManagement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import StudentRecordManagement.sql.SqlConnection;

class labelActionListener implements ActionListener{
	Frame f;
	public labelActionListener(Frame f1) {
		// TODO Auto-generated constructor stub
		this.f = f1;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Event");
		this.f.dispose();
		addStudentFrame addStudFrame = new addStudentFrame();
		addStudFrame.setVisible(true);
	}
}

public class StudentRecordManagement extends Frame {
	
	
	
	public StudentRecordManagement() {
		
		Label l1,l2,l3,l4,l5,l6;
	    TextField t1, t2,t3,t4;    
	    
	    MenuBar mb=new MenuBar(); 
	    MenuItem ADD_Student = new MenuItem("ADD Student"),All_Student=new MenuItem("All Student");
	    Menu Student = new Menu("Student");
//        MenuItem menu=new Menu("ADD Student");
//        MenuItem menu2=new Menu("All Student");
       
        
		l1 = new Label();
		l1.setText("Student Record Management system");
//		l1.setSize(100,300);
	    l1.setBounds(70, 80, 600, 34);
	    l1.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		add(l1);
		
		
		l2 = new Label();
		l2.setText("Search Student Details");
		l2.setBounds(180, 150, 600, 30);
		l2.setFont(new Font(Font.DIALOG,Font.BOLD,24));
		
		add(l2);
		
		l3 = new Label();
		l3.setText("Roll No : ");
		l3.setBounds(110, 200, 100, 20);
		l3.setFont(new Font(Font.DIALOG,Font.PLAIN,19));
		add(l3);
		
		t1 = new TextField();
		t1.setBounds(230, 200, 250, 24);
		add(t1);
		
		l4 = new Label();
		l4.setText("Name : ");
		l4.setBounds(110, 240, 100, 20);
		l4.setFont(new Font(Font.DIALOG,Font.PLAIN,19));
		add(l4);
		
		t2 = new TextField();
		t2.setBounds(230, 240, 250, 24);
		add(t2);
		
		l5 = new Label();
		l5.setText("class : ");
		l5.setBounds(110, 280, 100, 20);
		l5.setFont(new Font(Font.DIALOG,Font.PLAIN,19));
		add(l5);
		
		t3 = new TextField();
		t3.setBounds(230, 280, 250, 24);
		add(t3);
		
//		 create instance of button with label  
	    Button b = new Button("Submit");   
	  
	    // set the position for the button in frame   
	    b.setBounds(330, 330, 100, 27); 
	    
	    add(b);
		
	    Student.add(ADD_Student);
	    Student.add(All_Student);
	    mb.add(Student);
	    
	    b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SqlConnection sqlCon = new SqlConnection();
				HashMap<String,String> m = sqlCon.getStudent(Integer.parseInt(t1.getText()), t2.getText(), t3.getText());
				GetStudentFrame sFrame = new GetStudentFrame(m);
				System.out.println("Fetched "+m.get("rNo")+" Name:- "+m.get("name"));
				m.forEach((key,value)->{
					System.out.println(key+" "+value);
				});
			}
		});
	    
//	    mb.add(menu2);
	    setMenuBar(mb);
	    
	    ADD_Student.addActionListener(new labelActionListener(this));
	    All_Student.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("All students");
				dispose();
				allStudentFrame allStudFrame = new allStudentFrame();
				allStudFrame.setVisible(true);
				
			}
		});
	    
	    setSize(800, 700);
		setTitle("Student Record Management System");
		setLayout(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		StudentRecordManagement recordM = new StudentRecordManagement();
		
	}

	
}
