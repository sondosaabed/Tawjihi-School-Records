
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage; 

	/** in this project I have created GUI as list of buttons that user can chose from
	the progress of the operation will be updated on a progress label
	I also made it read the two files .csv and divide them into 4 linkedLists based on area and branch
	because there will be only 4 probabilities of what the user is going to chose on radio buttons
	the operations "button" chosen will operate based on the 2 radio button user choices  **/

public class Main extends Application{
	
	//four static linked lists
	public static LinkedList WestBankLitral= new LinkedList();
	public static LinkedList WestBankSci= new LinkedList();
	public static LinkedList GazaLitral= new LinkedList();
	public static LinkedList GazaSci= new LinkedList();
	
	//three files
	private static File WestBankF;// = new File("WestBank_2019.csv");
	private static File GazaF;// = new File("Gaza_2019.csv");
	private static File report = new File("report.txt");
	
	public static int choice=0;
	
	//choice of these radio buttons helps me decide the specified linked list that the user wants to operate on
	//if the choice is 0 or 1 or 2 or 3  
	//choice of the user to operate on a specific linked list 
	//Four static radio buttons
	public static RadioButton rbwb = new RadioButton("West Bank");
	
	public static RadioButton rbG = new RadioButton("Gaza");
	public static RadioButton rbs = new RadioButton("Sientific");
	public static RadioButton rbl = new RadioButton("Litral");
	
	//two toggele goups
	public static ToggleGroup group1 = new ToggleGroup();
	public static ToggleGroup group2 = new ToggleGroup(); 
	
	@Override
	public void start(Stage primaryStage) throws Exception { 
		
		//new gridPane
		GridPane pane = new GridPane();
		
		//make fill for my backgound
		BackgroundFill fill = new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(fill); 
		
		//set alignment, padding, gaps and background color
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(160,270,160,270));
		pane.setHgap(10.5);
		pane.setVgap(10.5); 
		pane.setBackground(background);
		
		//add title label
		Label title = new Label("Tawjihi Palestine");
		title.setTextFill(Color.DARKBLUE);
		title.setFont(Font.font(20));  
		pane.add(title, 1, 0);
		
		//add label to select
  	  	Label select1 =new Label("Select from the options below:");
  	  	select1.setFont(Font.font(14));
		pane.add(select1, 0, 1); 
		
		//add label for area
		Label area =new Label("       Area:");
		area.setFont(Font.font(14));
		area.setTextFill(Color.DARKBLUE);
		pane.add(area , 0, 2); 
		
		//add radio button to pane
		rbwb.setTextFill(Color.DARKBLUE);
		rbwb.setFont(Font.font(14)); 
		pane.add(rbwb,1,2);
		rbG.setTextFill(Color.DARKBLUE);
		rbG.setFont(Font.font(14));
		pane.add(rbG,2,2);
		
		//toggle group1 radio buttons 
		rbwb.setToggleGroup(group1);
		rbG.setToggleGroup(group1);
		
		//add label for Branch
		Label barnch =new Label("       Branch:");
		barnch.setFont(Font.font(14));
		barnch.setTextFill(Color.DARKBLUE);
		pane.add(barnch , 0, 3);
		
		//add radio button to pane
		rbs.setTextFill(Color.DARKBLUE);
		rbs.setFont(Font.font(14));
		pane.add(rbs,1,3); 
		rbl.setTextFill(Color.DARKBLUE);
		rbl.setFont(Font.font(14));
		pane.add(rbl,2,3);
		
		//toggle group2 radio buttons
		rbs.setToggleGroup(group2);
		rbl.setToggleGroup(group2);  
		
		//Creating process label so the user get the operation outputs and update 
		Label process= new Label(("\nThis is process Label\n will change by process"));
		process.setTextFill(Color.RED);
		process.setFont(Font.font(14));
  	  	pane.add(process,1,4);
  	  	
  	  	//creating chose label
  	  	Label chose=new Label("Choose from the operations below:");
  	  	chose.setFont(Font.font(14));
		pane.add(chose, 0, 5);
		
		//add 10 buttons for operations list
		Button bt1 = new Button("Insert a new record");
		bt1.setTextFill(Color.DARKBLUE);
		bt1.setFont(Font.font(14));  
		
		Button bt2 = new Button("Delete a record by number");
		bt2.setTextFill(Color.DARKBLUE); 
		bt2.setFont(Font.font(14));
		
		Button bt3 = new Button("Search by number");
		bt3.setTextFill(Color.DARKBLUE);
		bt3.setFont(Font.font(14));
		
		Button bt4 = new Button("Top 10 grade's students");
		bt4.setTextFill(Color.DARKBLUE);
		bt4.setFont(Font.font(14));
		
		Button bt5 = new Button("Calculate the mean");
		bt5.setTextFill(Color.DARKBLUE);
		bt5.setFont(Font.font(14));
		
		Button bt6 = new Button("Calculate the mode");
		bt6.setTextFill(Color.DARKBLUE);
		bt6.setFont(Font.font(14));
		
		Button bt7 = new Button("Calculate variance \n & standard dev.");
		bt7.setTextFill(Color.DARKBLUE);
		bt7.setFont(Font.font(14));
		
		Button bt8 = new Button("Calculate the median");
		bt8.setTextFill(Color.DARKBLUE);
		bt8.setFont(Font.font(14));
		
		Button bt9 = new Button("Calculate Percentage \n of a specific grade");
		bt9.setTextFill(Color.DARKBLUE);
		bt9.setFont(Font.font(14));
		
		Button bt10 = new Button("Export report as file"); 
		bt10.setTextFill(Color.DARKBLUE);
		bt10.setFont(Font.font(14));
		
		pane.add(bt1, 0, 6); 
		pane.add(bt2, 1, 6);
		pane.add(bt3, 2, 6);
		pane.add(bt4, 0, 7);
		pane.add(bt5, 1, 7);
		pane.add(bt6, 2, 7);
		pane.add(bt7, 0, 8);
		pane.add(bt8, 1, 8);
		pane.add(bt9, 2, 8);
		pane.add(bt10, 0, 9); 
		
		/** Create and register the Events handlers**/
		
		//button 1 handler
		bt1.setOnAction(new EventHandler<ActionEvent>()  {
		      @Override // Override the handle method
		      public void handle(ActionEvent e){  
		    	  
		    	  //Create seat label
		    	  Label seat= new Label(("       Student Seat Number:"));
		    	  pane.add(seat,0,10);
		    	  
		    	  //Create average label
		    	  Label average= new Label(("       Student Average:"));
		    	  pane.add(average, 0, 11);
		    
		    	  //Create seat TextField
		    	  TextField seat1 = new TextField();
		    	  pane.add(seat1, 1, 10); 
		    	  
		    	  //Create average TextField
		    	  TextField average1 = new TextField();
		    	  pane.add(average1, 1, 11);  

		    	  //create button to add student
		    	  Button btAdd = new Button("Add Student");
		    	  btAdd.setTextFill(Color.RED);
		    	  pane.add(btAdd, 1, 13);
		    	  
		    	  // Create and register the handler of add button
		    	  btAdd.setOnAction(new EventHandler<ActionEvent>() {
				      @Override // Override the handle method
				      public void handle(ActionEvent ev) {  
				    	  Student st= new Student();
				    	  //handling Number Format Exception
				    	  try {
				    		  //read user entries
				    		  st.setSeatNum(Long.parseLong(seat1.getText().trim())); 
					    	  st.setGrade(Float.parseFloat(average1.getText().trim()));
					    	  
					    	  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
					    		  st.setBranch("Scientific");
					    		  WestBankSci.insertionSorted(st); 
					    		  WestBankSci.traverse();
					    	  }
					    	  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
					    		  st.setBranch("Literary ");
					    		  WestBankLitral.insertionSorted(st);
					    		  WestBankLitral.traverse();
					    	  }
					    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
					    		  st.setBranch("Scientific");
					    		  GazaSci.insertionSorted(st);
					    		  GazaSci.traverse();
					    	  }
					    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)){
					    		  st.setBranch("Literary ");
					    		  GazaLitral.insertionSorted(st); 
					    		  GazaLitral.traverse();
					    	  } 
				    	  	}catch(NumberFormatException x) {
				    		  process.setText("You must enter a number!!");
				    		  System.out.println(x);
				    	  	 }	catch(NullPointerException x) {
					    		  process.setText("\nMust chose an area and branch to operate\n");
					    		  System.out.println(x+"\nMust chose an aea and branch\n");
					    	  }
				    	  //update progress label
				    	  process.setText("\nStudent "+ st.getSeatNum()+" is Added!\nclick again to add another one");
				    	  
				    	  //remove after use
				    	  pane.getChildren().remove(seat);
				    	  pane.getChildren().remove(seat1);
				    	  pane.getChildren().remove(average1);
				    	  pane.getChildren().remove(average); 
				    	  pane.getChildren().remove(btAdd);
				      }
				    });  
		      	}
		    });
		
		//button 2 handler
		bt2.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) { 
		    	  
		    	  //create seat label and text field and add them to pane
		    	  Label seat= new Label(("       Student Seat Number:"));
		    	  pane.add(seat,0,10); 
		    	  TextField seat1 = new TextField();
		    	  pane.add(seat1, 1, 10); 
		    	  
		    	  //create delete button and add them to pane
		    	  Button btDel = new Button("Delete Student");
		    	  btDel.setTextFill(Color.RED);
		    	  pane.add(btDel, 1, 11);
		    	  
		    	  // Create and register the handler for delete button
		    	  btDel.setOnAction(new EventHandler<ActionEvent>() {
				      @Override // Override the handle method
				      public void handle(ActionEvent ev) {   
				    	  try {
				    		  //read user entry
				    		  long seatN=Long.parseLong(seat1.getText().trim());
				    	 
				    		  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
				    			  if(WestBankSci.search(seatN)==null) {
				    				  process.setText("Student "+seatN+" was not found!");
				    			  }
				    			  else { 
				    				  WestBankSci.deleteStudent(seatN);  
				    				  WestBankSci.traverse();
				    			  process.setText("\nStudent "+seatN+" Deleted!\nclick again to delete another one"); 
				    			  }
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
				    			  if(WestBankLitral.search(seatN)==null) {
				    				  process.setText("Student "+seatN+" was not found!");
				    			  }
				    			  else {
				    				  WestBankLitral.deleteStudent(seatN);
				    				  WestBankLitral.traverse();
				    				  process.setText("\nStudent "+seatN+" Deleted!\nclick again to delete another one");
				    			  } 
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
				    			  if(GazaSci.search(seatN)==null) {
				    				  process.setText("Student "+seatN+" was not found!");
				    			  }
				    			  else {
				    				  GazaSci.deleteStudent(seatN);
				    				  GazaSci.traverse();
				    				  process.setText("\nStudent "+seatN+" Deleted!\nclick again to delete another one");
				    			  }  
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)){
				    			  if(GazaLitral.search(seatN)==null) {
				    				  process.setText("Student "+seatN+" was not found!");
				    			  }
				    			  else {
				    				  GazaLitral.deleteStudent(seatN);
				    				  GazaLitral.traverse();
				    				  process.setText("\nStudent "+seatN+" Deleted!\nclick again to delete another one");
				    			  }   
				    		  }  
				    	  }catch (NumberFormatException ex) {
					    	process.setText("You enterted nothing!!");
					    	System.out.println(ex);
				    	  }	catch(NullPointerException x) {
				    		  process.setText("\nMust chose an area and branch to operate\n");
				    		  System.out.println(x+"\nMust chose an aea and branch\n");
				    	  }
				    	  pane.getChildren().remove(seat);
				    	  pane.getChildren().remove(seat1);
				    	  pane.getChildren().remove(btDel);
				      }
		    	  }); 
		      	} 
		    });
		
		//button 3 handler
		bt3.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) { 
		    	  
		    	  //create seat label and add it to pane
		    	  Label seat= new Label(("       Student Seat Number:"));
		    	  pane.add(seat,0,10); 
		    	  
		    	  //create textFelid and add it to pane
		    	  TextField seat1 = new TextField();
		    	  pane.add(seat1, 1, 10); 
		    	  
		    	  //create button for search and add it to pane
		    	  Button btSer = new Button("Search");
		    	  btSer.setTextFill(Color.RED);
		    	  pane.add(btSer, 1, 11);
		    	  
		    	  // Create and register the handler for search button
		    	  btSer.setOnAction(new EventHandler<ActionEvent>() {
				      @Override // Override the handle method
				      public void handle(ActionEvent ev) { 
				    	  try{
				    		  //read user entry
				    		  long seatN=Long.parseLong(seat1.getText().trim());
				    		  
				    		  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
				    			  if(WestBankSci.search(seatN)==null) {
				    				  process.setText("There is no student with this seat number!");
				    			  }
				    			  else { 
				    			  process.setText("\nStudent Found!\n" +WestBankSci.search(seatN).getStudent());
				    			  }
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
				    			  if(WestBankLitral.search(seatN)==null) {
				    				  process.setText("There is no student with this seat number!");
				    			  }
				    			  else { 
				    				  process.setText("\nStudent Found!\n" +WestBankLitral.search(seatN).getStudent());
				    			  } 
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
				    			  if(GazaSci.search(seatN)==null) {
				    				  process.setText("There is no student with this seat number!");
				    			  }
				    			  else { 
				    				  process.setText("\nStudent Found!\n" +GazaSci.search(seatN).getStudent());
				    			  }  
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)){
				    			  if(GazaLitral.search(seatN)==null) {
				    				  process.setText("There is no student with this seat number!");
				    			  }
				    			  else {
				    				  process.setText("\nStudent Found!\n" +GazaLitral.search(seatN).getStudent());
				    			  }   
				    		  }     
				    	  }catch (NumberFormatException ex1) {
					    	process.setText("You enterted nothing!!");
					    	System.out.println(ex1);
				    	  }	catch(NullPointerException x) {
				    		  process.setText("\nMust chose an area and branch to operate\n");
				    		  System.out.println(x+"\nMust chose an aea and branch\n");
				    	  }
				    	  
				    	  pane.getChildren().remove(seat);
				    	  pane.getChildren().remove(seat1);
				    	  pane.getChildren().remove(btSer);
				      }
				    }); 
		      	} 
		    });
		
		//button 4 handler
		bt4.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) { 
		    	  Node current = null; 
		    	  int y=10;
		    	  
		    	  try {
		    	  process.setText("\nTop 10 grades Students are:\n ");
		    	 
		    	  //print top 10 students grades 
		    	  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {  
		    		  if(TopTen(WestBankSci).isEmpty()) {  
		    	            System.out.println("Your LinkedList is empty!");   
		    	        }   
			    		  current = TopTen(WestBankSci).firstNode; 
			    		  process.setText("\nTop 10 grades Students are:\n ");  
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {		    		  if(TopTen(WestBankSci).isEmpty()) {  
	    	            System.out.println("Your LinkedList is empty!");   
	    	        }   
		    		  current = TopTen(WestBankLitral).firstNode; 
		    		  process.setText("\nTop 10 grades Students are:\n ");  
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
		    		  if(TopTen(GazaSci).isEmpty()) {  
		    	            System.out.println("Your LinkedList is empty!");   
		    	        }   
			    		  current = TopTen(GazaSci).firstNode; 
			    		  process.setText("\nTop 10 grades Students are:\n ");   
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)) {
		     		  if(TopTen(GazaLitral).isEmpty()) {  
		    	            System.out.println("Your LinkedList is empty!");   
		    	        }   
			    		  current = TopTen(GazaLitral).firstNode; 
			    		  process.setText("\nTop 10 grades Students are:\n ");  
		    	  } 
		    	  
		    	  /**I didn't loop because I wanted when the bt done 
		    	  is selected to access the labels delete them**/ 
		    	  
		    	  Label label = new Label(current.student.toString());
    			  label.setTextFill(Color.BLUE);
    			  pane.add(label, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label2 = new Label(current.student.toString());
	    		  label2.setTextFill(Color.BLUE);
    			  pane.add(label2, 0, y);
    			  current = current.next;
    			  y++; 
	    		  Label label3 = new Label(current.student.toString());
	    		  label3.setTextFill(Color.BLUE);
    			  pane.add(label3, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label4 = new Label(current.student.toString());
	    		  label4.setTextFill(Color.BLUE);
    			  pane.add(label4, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label5 = new Label(current.student.toString());
	    		  label5.setTextFill(Color.BLUE);
    			  pane.add(label5, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label6 = new Label(current.student.toString());
	    		  label6.setTextFill(Color.BLUE);
    			  pane.add(label6, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label7 = new Label(current.student.toString());
	    		  label7.setTextFill(Color.BLUE);
    			  pane.add(label7, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label8 = new Label(current.student.toString());
	    		  label8.setTextFill(Color.BLUE);
    			  pane.add(label8, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label9 = new Label(current.student.toString());
	    		  label9.setTextFill(Color.BLUE);
    			  pane.add(label9, 0, y);
    			  current = current.next;
    			  y++;
	    		  Label label10 = new Label(current.student.toString()); 
	    		  label10.setTextFill(Color.BLUE);
    			  pane.add(label10, 0, y); 
		    	  
    			  Button done = new Button("done");
		    	  done.setFont(Font.font(14));
		    	  done.setTextFill(Color.RED);
		    	  pane.add(done,1,15);
    	        	 done.setOnAction(new EventHandler<ActionEvent>() {
				    		@Override
								public void handle(ActionEvent arg0) { 
				    			pane.getChildren().remove(label);
				    			pane.getChildren().remove(label2);
				    			pane.getChildren().remove(label3);
				    			pane.getChildren().remove(label4);
				    			pane.getChildren().remove(label5);
				    			pane.getChildren().remove(label6);
				    			pane.getChildren().remove(label7);
				    			pane.getChildren().remove(label8);
				    			pane.getChildren().remove(label9);
				    			pane.getChildren().remove(label10);
				    			pane.getChildren().remove(done);
				    			process.setText("Done");
								} 
				    	});  

		    	  
		    	  }	catch(NullPointerException x) {
		    		  process.setText("\nMust chose an area and branch to operate\n");
		    		  System.out.println(x+"\nMust chose an aea and branch\n");
		    	  }
		      } 
		    });
		
		//button 5 handler
		bt5.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) {  
		    	try {  
		    	  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText("\nthe mean of Students grade is:\n"+Float.toString(getMean(WestBankSci)));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText("\nthe mean of Students grade is:\n"+Float.toString(getMean(WestBankLitral)));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText("\nthe mean of Students grade is:\n"+Float.toString(getMean(GazaSci))); 
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText("\nthe mean of Students grade is:\n"+Float.toString(getMean(GazaLitral))); 
		    	  }   
		      }	catch(NullPointerException x) {
	    		  process.setText("\nMust chose an area and branch to operate\n");
	    		  System.out.println(x+"\nMust chose an aea and branch\n");
	    	  }
		      } 
		    });
		
		//button 6 handler
		bt6.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) {
		    	  try {
		    	  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText("\nThe Mode of Students grade is:\n"+Float.toString(getMode(WestBankSci)));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText("\nThe Mode of Students grade is:\n"+Float.toString(getMode(WestBankLitral)));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText("\nThe Mode of Students grade is:\n"+Float.toString(getMode(GazaSci))); 
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText("\nThe Mode of Students grade is:\n"+Float.toString(getMode(GazaLitral))); 
		    	  } 
		      }	catch(NullPointerException x) {
	    		  process.setText("\nMust chose an area and branch to operate\n");
	    		  System.out.println(x+"\nMust chose an aea and branch\n");
	    	  }
		      } 
		    });
		
		//button 7 handler
		bt7.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) {
		    	try {  
		    	  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText(getVarianceandstdr(WestBankSci));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText(getVarianceandstdr(WestBankLitral));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText(getVarianceandstdr(GazaSci)); 
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText(getVarianceandstdr(GazaLitral)); 
		    	  }  
		      }	catch(NullPointerException x) {
	    		  process.setText("\nMust chose an area and branch to operate\n");
	    		  System.out.println(x+"\nMust chose an aea and branch\n");
	    	  }
		      } 
		    });
		
		//button 8 handler
		bt8.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) {  
		      try {
		    	  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText("\nThe Median of Students grades is:\n"+Float.toString(getMedian(WestBankSci)));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText("\nThe Median of Students grades is:\n"+Float.toString(getMedian(WestBankLitral)));    
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
		    		  process.setText("\nThe Median of Students grades is:\n"+Float.toString(getMedian(GazaSci))); 
		    	  }
		    	  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)) {
		    		  process.setText("\nThe Median of Students grades is:\n"+Float.toString(getMedian(GazaLitral))); 
		    	  }   
		      }catch(NullPointerException x) {
	    		  process.setText("\nMust chose an area and branch to operate\n");
	    		  System.out.println(x+"\nMust chose an aea and branch\n");
		      }
		      } 
		    });
		
		//button 9 handler
		bt9.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) { 
		    	  
		    	  //create grade label and textfeild and add them to tha pane 
		    	  Label grade= new Label(("       Grade:"));
		    	  pane.add(grade,0,10); 
		    	  TextField grade1 = new TextField();
		    	  pane.add(grade1, 1, 10); 
		    	  
		    	  //create calculate button and add it to the pane
		    	  Button btcal = new Button("Calculate");
		    	  btcal.setTextFill(Color.RED);
		    	  pane.add(btcal, 1, 11);
		    	  
		    	  //Calculate button handler 
		    	  btcal.setOnAction(new EventHandler<ActionEvent>() {
				      @Override // Override the handle method
				      public void handle(ActionEvent ev) {
				    	  try {
				    		  //handle Number Format Exception
				    		  
				    		  //read user entry
				    		  Float grad = Float.parseFloat(grade1.getText().trim());
				    		  
				    		  if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
				    			  process.setText(getPercentageofGrade(grad,WestBankSci));    
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
				    			  process.setText(getPercentageofGrade(grad,WestBankLitral));   
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
				    			  process.setText(getPercentageofGrade(grad,GazaSci));
				    		  }
				    		  else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)) {
				    			  process.setText(getPercentageofGrade(grad,GazaLitral));
				    		  }
				    	  }catch(NumberFormatException e) {
				    		  process.setText("You enterted Nothing!!");
				    		  System.out.println(e);
				    	  }	catch(NullPointerException x) {
				    		  process.setText("\nMust chose an area and branch to operate\n");
				    		  System.out.println(x+"\nMust chose an aea and branch\n");
				    	  }
				    	  
				    	  //remove grade labe textfeild nad button after use
				    	  pane.getChildren().remove(grade);
				    	  pane.getChildren().remove(grade1);
				    	  pane.getChildren().remove(btcal);
				      }
		    	  });
		      	} 
		    });
		
		//button 10 handler
		bt10.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent e) { 
		    	  try {
		    		  //handle File Not Found Exception
		    		  	if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbs)) {
		    			  exportReport(WestBankSci);
		    		  	}
		    		  	else if(group1.getSelectedToggle().equals(rbwb) && group2.getSelectedToggle().equals(rbl)) {
		    			  exportReport(WestBankLitral);   
		    		  	}
		    		  	else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbs)) {
		    			  exportReport(GazaSci);
		    		  	}
		    		  	else if(group1.getSelectedToggle().equals(rbG) && group2.getSelectedToggle().equals(rbl)) {
		    			  exportReport(GazaLitral);
		    		  	}   
		    		  	
		    		  	//update process label
		    		  	process.setText("\nThe report is exported to report.txt\n");
		    		  	
		    	  }catch (FileNotFoundException e1) { 
						e1.printStackTrace();
		    	  }	catch(NullPointerException x) {
		    		  process.setText("\nMust chose an area and branch to operate\n");
		    		  System.out.println(x+"\nMust chose an aea and branch\n");
		    	  }
		    	 
		      	} 
		    });
		
		//create scene
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene); 
		
		//set title
		primaryStage.setTitle("Tawjihi Palestine");
		
		//show scene 
		primaryStage.show();
	}
	
	public static void main(String[] args) throws FileNotFoundException { 
		
		try {//handle File Not Found Exception
			
			WestBankF = new File("WestBank_2019.csv");
			GazaF = new File("Gaza_2019.csv");
			//create scans
			 Scanner scan = new Scanner( WestBankF );
			 Scanner scan1 = new Scanner( GazaF);
			 
			 //read files
			 while (scan.hasNextLine()){ 
				 Student student = new Student(scan.nextLine());
				 if (student.isLiterary()) 
					WestBankLitral.insertionSorted(student); 
				 else if (student.isScientific())
					WestBankSci.insertionSorted(student);   
			 }
			 scan.close();
			 while (scan1.hasNextLine()){ 
				Student student = new Student(scan1.nextLine());
				if (student.isLiterary()) 
					GazaLitral.insertionSorted(student); 
				else if (student.isScientific())
					GazaSci.insertionSorted(student);   
			 }
			 scan1.close();  

			 }catch(FileNotFoundException notFound){
				 notFound.printStackTrace();
			 }
			 catch (Exception e) {
				 e.printStackTrace(); 
			 }   
		launch(args);
	}	 
	
	public static LinkedList TopTen(LinkedList students) {
		//this method is created by me to get the top 10 students by grades
		LinkedList topTen = new LinkedList();
		Node current = students.getFirstNode();  
		int counter =10;   

		if(students.isEmpty()) { 
			//case empty linked list
            System.out.println("Your LinkedList is empty!");  
            return topTen;
        }
		  
		while(current != null && counter!=0) {
			topTen.insertionSorted(current.getStudent()); 
			current = current.getNext();
			counter--;
		}
		return topTen;  
	}
	
	public static float getSum(LinkedList students) {
		//this method is created by me to get the sum of students grades
		float sum=0;
		Node current= students.getFirstNode();  
		while(current != null) {   
        	sum =sum + current.student.getGrade();  
            current = current.next;  
        }
		return sum;
	}
	
	public static float getMean(LinkedList students) {
		//this method is created by me to get the mean of the students grades
		float  average=0;  
        if(students.isEmpty()) {  
        	//case empty
            System.out.println("Your LinkedList is empty!");   
            return 0;
        }  
        average=getSum(students)/students.getSize();
		return average; 
	} 
	
	public static float getMode(LinkedList students) {
		//this method is created by me to get the mode of the students grades  
		
		float mode = 0; 
		int max = 0;  //Maximum repetition of a value  
		int count = 0;
		Node current1 = students.firstNode;
		Node current2 = students.firstNode;
		
		if(students.isEmpty()) {  
			System.out.println("Your LinkedList is empty!");  
			return 0;
		}
		
		while(current1 != null) {
			while(current2 != null) {
				if(current2.getStudent().getGrade()==current1.getStudent().getGrade()) {
					   ++count;
				}
				current2 = current2.next;
			} 
			current1 = current1.next;
			if (count > max) {
				max = count;
		    	mode = current1.getStudent().getGrade();
			}
		} 
		return mode; 
	} 
	
	public static String getVarianceandstdr(LinkedList students) {
		//this method is created by me to get the variance and standard dev. of the students grades
		float stdr =0;
		float stdr1 =0;
		float dm = 0;
		float variance =0;
		
		Node current1 = students.firstNode;
		Node current2 = students.firstNode;
		if(students.isEmpty()) {   
            return "Your LinkedList is empty!";
        }  
        while(current1!=null) {  
        	stdr = stdr+ (float) Math.pow(current1.getStudent().getGrade()-getMean(students), 2);
         	current1 = current1.getNext();  
        }  
        stdr1=(float) Math.sqrt(stdr/students.getSize());
        
        
        while(current2!=null) {  
        	dm = dm+ (float) Math.pow(current2.getStudent().getGrade()-getMean(students), 2);
         	current2 = current2.getNext();   
        }  
        variance = dm/students.getSize(); 
        
        String answer = "Standard Deviation is: "+ stdr1+"\nVariance is: "+variance;
        return answer;
	}		
	
	public static float getMedian(LinkedList students) {
		//this method is created by me to get the median of the students grades 
		
		Node current =students.firstNode;
		int counter  =students.getSize()/2;
		if(students.isEmpty()) {  
			//case list is empty
			System.out.println("Your LinkedList is empty!");   
			return 0;
		}
		if(students.size%2!=0) {
			//median is the grade in the middle
			while(counter!=0) {
				current =current.next;
				counter--;
			}
			return current.getStudent().getGrade();
		}
		if (students.size == 1) {
			return current.getStudent().getGrade();
		} 
		else {
			while(counter!=1) {
				current =current.next;
				counter--;
			}
			return (float) ((current.getStudent().getGrade()+ current.getNext().getStudent().getGrade())/2);
		}   
	}
	
	public static String getPercentageofGrade(float grade,LinkedList students) {
		//this method is created by me to get the percentage of a specific grade among students
		int numOfSts = 0;
		float percentage; 
		Node current = students.getFirstNode();
		
		if(students.isEmpty()) {
			//case list is empty
			System.out.println("Empty Linked list!");
			return "";
		}
		while(current!=null) {
			if(current.getStudent().getGrade()==grade) {
				numOfSts++;
			}
			current = current.getNext();
		} 
		percentage= (float) numOfSts/students.getSize()*100;
		String answer ="Number of students with "+ grade +" \ngarde is: " +numOfSts +"\nPercentage of them: " +percentage;
		return answer; 
	}
	
	public static void exportReport(LinkedList students) throws FileNotFoundException{
		//this method is created by me to export to report
		try { 
			//handle File Not Found Exception
			PrintWriter out = new PrintWriter(report);  
	        if(students.isEmpty()) {  
	           out.println("Your LinkedList is empty!");   
	        }  
	       out.print("Top 10 students are:\n");
 		  	Node current = TopTen(students).firstNode;  
 		  		if(TopTen(students).isEmpty()) {  
 		  			out.print("Your LinkedList is empty!");   
 		  		}  
 		  		while(current!= null) {   
 		  			out.print(current.student + "\n");  
 		  			current = current.next;  
 		  		}  
	       out.print("\nThe Mean is:\n");
	       out.print(getMean(students)+"	\n");
	       out.print("The Mode is:\n");
	       out.print(getMode(students)+"	\n");
	       out.print("The variance and the standard dev are:\n");
	       out.print(getVarianceandstdr(students)+"	\n"); 
	       out.print("The Median is:\n");
	       out.print(getMedian(students)+"	\n");    
	       out.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
}
