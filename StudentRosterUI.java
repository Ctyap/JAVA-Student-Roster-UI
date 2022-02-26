package labs.lab9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class StudentRosterUI extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	
	private static final int FIELD_WIDTH = 10;
	
	//An Array List that will hold current students. 
	private ArrayList<Student> Students = new ArrayList<>();
	
	//An array of student names
	private ArrayList<String> StudentNames = new ArrayList<>();
	
	//Current Student.
	private Student currentStudent;
	private int currentStudentIndex = 0;
	
	//New Student
	private boolean newStudent = true;
	
	//Current student Variables
	private String name = "";
	private String breed = "";
	private int breedIndex = 0;
	private String phone = "";
	private String isNewStudent = "None";
	private ArrayList<String> courses = new ArrayList<>();
	public double tuition;
	private String notes = "";
	
	
	//Name Field: Allows input of a label, Allows the editing of a single line of text.
	private JLabel nameLabel;
	private JTextField nameField;
	
	//Phone field.
	private JLabel phoneLabel;
	private JTextField phoneField;
	
	//Drop down menu dog breed Fields.
	String[] messageStrings = {"Bulldog", "Chihuahua", "French Bulldog", "German Shepherd",
			"Golden Retriever", "Labrador Retriever", "Pomeranian", "Poodle", "Pug",
			"Siberian Husky", "OTher"};
	private JComboBox dogBreedList;
	private JLabel dogBreedLabel;
	
	//New or Returning Student Radio Button
	private ButtonGroup buttonGroup;
	private JRadioButton returnStudentButton;
	private JRadioButton newStudentButton;
	
	
	//New, Save, and Delete Buttons
	private JButton saveButton;
	private JButton newButton;
	private JButton deleteButton;
	
	//Check boxes of courses.
	private JCheckBox course1, course2, course3, course4, course5;
	private JLabel coursesLabel;
	
	//Tuition display.
	private JLabel studentTuitionLabel;
	private JTextField tuitionField;

	//Notes text area.
	private JTextArea textareaNotes;
	private JLabel textareaLabel;
	private JScrollPane scrollPane;
	
	//Navigation buttons.
	private JButton previousButton;
	private JButton nextButton;
	
	/*Constructor for StudentRosterUI
	 * Will contain the size of the application window.
	 * Will contain the title name of the applicaiton.
	 * will call the textFields.
	 * Will call the createPanel.
	 * */
	public StudentRosterUI(){
		
		//Create GUI with a set size.
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		//Create GUI title.
		setTitle("Cooper Yap - 90967488");
		

		createNameField();
		createPhoneField();
		createBreedList();
		createStatusRButton();
		createCourseCheckBoxes();
		createTuition();
		createNotes();
		createButton();
		createNavigationButtons();
		//Set buttons to false.
		previousButton.setEnabled(false);
		nextButton.setEnabled(false);
		createPanel();
	}
	
	
	
	//Resets the student variables.
	public void resetCurrentStudent() {
		name = "";
		breed = "";
		breedIndex = 0;
		phone = "";
		isNewStudent = "None";
		courses = new ArrayList<String>();
		tuition = 0;
		notes = "";
	}
	

	
	private void createNameField() {
		//Name label.
		nameLabel = new JLabel("Name: ");
				
		//Allows editing of name label line of text.
		nameField = new JTextField(FIELD_WIDTH);
		
		//nameField.setText("Enter Name: ");
		 
	}
	
	
	private void createPhoneField() {
		//phone label.
		phoneLabel = new JLabel("Phone: ");
				
		//Allows editing of name label line of text.
		phoneField = new JTextField(FIELD_WIDTH);
	}
	
	private void createButton() {
		//Create saveButton (Saves student info)
		saveButton = new JButton("Save");
		
		//Create saveListener object
		ActionListener saveListener = new studentAttributeListener();
		saveButton.addActionListener(saveListener);
		
		//Create newButton (resets student info)
		newButton = new JButton("New");
		
		//Create newLisener object.
		ActionListener newListener = new studentAttributeListener();
		newButton.addActionListener(newListener);
		
		
		//Create deleteButton(deletes current student)
		deleteButton = new JButton("Delete");
		
		//Create deleteListener object.
		ActionListener deleteListener = new studentAttributeListener();
		deleteButton.addActionListener(deleteListener);
		
		
	}
	
	private void createBreedList() {
		//Creates a dropdown menu of dog breeds.
		dogBreedList = new JComboBox(messageStrings);
		
		//Creates a label for dog breeds.
		dogBreedLabel = new JLabel("Breed: ");
		
		//Select default breed: Bulldog.
		dogBreedList.setSelectedIndex(0);
		
		//Create actionListener object.
		ActionListener listener = new studentAttributeListener();
		
		//Add listener to dogBreedList catching what breed the user selects.
		dogBreedList.addActionListener(listener);
		
		
	}
	
	private void createStatusRButton() {
		//Creates radio button options
		returnStudentButton = new JRadioButton("New Student");
		newStudentButton = new JRadioButton("Returning Student");
		
		//Create group of buttons to allow only one selection
		buttonGroup = new ButtonGroup();
		buttonGroup.add(returnStudentButton);
		buttonGroup.add(newStudentButton);
		
		//Create actionListener object.
		ActionListener listener = new studentAttributeListener();
		
		//Create actionListener objects for each button.
		returnStudentButton.addActionListener(listener);
		newStudentButton.addActionListener(listener);
	}
	
	
	/*
	private JCheckBox course1, course2, course3, course4, course5;
	private JLabel agility, obed1, obed2, pup_etiq, tricks;
	 * 
	 * */
	private void createCourseCheckBoxes() {
		//checkbox desc, label.
		coursesLabel = new JLabel("Courses: ");
		course1 = new JCheckBox("Agility Training");
		
		course2 = new JCheckBox("Obedience 1");
		
		course3 = new JCheckBox("Obedience 2");
		
		course4 = new JCheckBox("Puppy Etiquette");
		
		course5 = new JCheckBox("Tricks");
		
		//Create actionListener object.
		ActionListener listener = new studentAttributeListener();
		
		//Allow for each checkbox to be listened to by an actionlistener object.
		course1.addActionListener(listener);
		course2.addActionListener(listener);
		course3.addActionListener(listener);
		course4.addActionListener(listener);
		course5.addActionListener(listener);
	}
	
	
	private void createTuition() {
		//Name label.
		studentTuitionLabel = new JLabel("Tuition: $ ");
		
		final int FIELD_WIDTH = 10;
		
		//Allows editing of name label line of text.
		tuitionField = new JTextField(FIELD_WIDTH);
		tuitionField.setEditable(false);
		tuitionField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tuitionField.setText(String.valueOf(tuition));
	}
	
	private void createNotes() {
		textareaLabel = new JLabel("Notes: ");
		textareaNotes = new JTextArea(3, 18);

		}
	
	private void createNavigationButtons() {
		//Create saveButton (Saves student info)
		previousButton = new JButton("<< Previous");
		
		//Create saveListener object
		ActionListener saveListener = new studentAttributeListener();
		previousButton.addActionListener(saveListener);
		
		//Create newButton (resets student info)
		nextButton = new JButton("Next >>");
		
		//Create newLisener object.
		ActionListener newListener = new studentAttributeListener();
		nextButton.addActionListener(newListener);
		
		
	}
	
	private void clearFields() {
		nameField.setText("");
		phoneField.setText("");
		dogBreedList.setSelectedIndex(0);
		buttonGroup.clearSelection();
		tuitionField.setText(String.valueOf(0.0));
		course1.setSelected(false);
		course2.setSelected(false);
		course3.setSelected(false);
		course4.setSelected(false);
		course5.setSelected(false);
		textareaNotes.setText("");
		
		resetCurrentStudent();
	}
	
	private void displayCurrentStudent() {
		//extract the info from the current students and set the fields accordingly to its saved states.
		nameField.setText(currentStudent.getName());
		phoneField.setText(currentStudent.getPhone());
		dogBreedList.setSelectedIndex(currentStudent.getBreedIndex());
		
		//Deals with radio button
		if (currentStudent.getisNewStudent().equals("True")) {
			newStudentButton.setSelected(true);
		}else {
			returnStudentButton.setSelected(true);
		}
		
		//deals with courses
		if (currentStudent.getCourses().size() != 0) {
			for (int i = 0; i < currentStudent.getCourses().size(); i++) {
				if (currentStudent.getCourses().get(i).equals("Agility Training")){
					course1.setSelected(true);
				}else if (currentStudent.getCourses().get(i).equals("Obedience 1")){
					course2.setSelected(true); 	
				}else if (currentStudent.getCourses().get(i).equals("Obedience 2")){
					course3.setSelected(true); 	
				}else if (currentStudent.getCourses().get(i).equals("Puppy Etiquette")){
					course4.setSelected(true); 	
				}else if (currentStudent.getCourses().get(i).equals("Tricks")){
					course5.setSelected(true); 
				}
			}
		}
		
		//Deals with tuition.
		tuitionField.setText(String.valueOf(currentStudent.tuition));
		
		//deals with notes
		textareaNotes.setText(currentStudent.getNotes());

	}
	
	
	private void createPanel() {
		//Create main panel object.
		JPanel MAIN_PANEL = new JPanel();
		MAIN_PANEL.setLayout(new GridLayout(9,1));
		
		//Create name panel object.
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		//Create phone panel object
		JPanel phonePanel = new JPanel();
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneField);
		
		//Create dogBreedList panel.
		JPanel breedPanel = new JPanel();
		breedPanel.add(dogBreedLabel);
		breedPanel.add(dogBreedList);
		
		//Create status panel.
		JPanel statusPanel = new JPanel();
		statusPanel.add(returnStudentButton);
		statusPanel.add(newStudentButton);
		
		//Create checkbox courses panel.
		JPanel coursesPanel = new JPanel();
		coursesPanel.add(coursesLabel);
		coursesPanel.add(course1);
		coursesPanel.add(course2);
		coursesPanel.add(course3);
		coursesPanel.add(course4);
		coursesPanel.add(course5);
		
		//Create new, save, delete panel.
		JPanel new_save_deletePanel = new JPanel();
		new_save_deletePanel.add(newButton);
		new_save_deletePanel.add(saveButton);
		new_save_deletePanel.add(deleteButton);
		
		//Create tuition display panel.
		JPanel tuition = new JPanel();
		tuition.add(studentTuitionLabel);
		tuition.add(tuitionField);
		
		//Create textarea panel.
		JPanel textarea = new JPanel();
		//textarea.setLayout(new FlowLayout());
		textarea.add(textareaLabel);
		textarea.add(textareaNotes);
		scrollPane = new JScrollPane(textareaNotes);
		textarea.add(scrollPane);
		
		//Create previous and next panel.
		JPanel prev_next_Panel = new JPanel();
		prev_next_Panel.add(previousButton);
		prev_next_Panel.add(nextButton);

		
		//Add created panels to main panel
		MAIN_PANEL.add(namePanel);
		MAIN_PANEL.add(breedPanel);
		MAIN_PANEL.add(phonePanel);
		MAIN_PANEL.add(statusPanel);
		MAIN_PANEL.add(coursesPanel);
		MAIN_PANEL.add(tuition);
		MAIN_PANEL.add(textarea);
		MAIN_PANEL.add(new_save_deletePanel);
		MAIN_PANEL.add(prev_next_Panel);

		add(MAIN_PANEL);
	}
	
	/*Class studentName creates a class based on students name.
	 * */
	public class studentAttributeListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//Deals with dogBreedList
			if (event.getSource() == dogBreedList) {
				JComboBox dogBreedList = (JComboBox) event.getSource();
				String dogBreed = (String)dogBreedList.getSelectedItem();
				breedIndex = dogBreedList.getSelectedIndex();
				breed = dogBreed;
				breedIndex = breedIndex;
			}
			
			//Deals with student status.
			if (newStudentButton.isSelected()) {
				isNewStudent = "True";
			}else if (returnStudentButton.isSelected()) {
				isNewStudent = "False";
			}else {
				isNewStudent = "None";
			}
			
			//Deals with Course Check Boxes.
			//If a course is selected add course to list and add 100 to tuition.
			if (event.getSource() == course1 || event.getSource() == course2 ||
					event.getSource() == course3 || event.getSource() == course4 ||
					event.getSource() == course5 ) {
				JCheckBox checkbox = (JCheckBox) event.getSource();
				
				if (newStudent == true) {
					if (checkbox.isSelected()) {
						if (checkbox == course1) {
							tuition += 100;
							courses.add("Agility Training");
						}else if (checkbox == course2) {
							tuition += 100;
							courses.add("Obedience 1");
						}else if (checkbox == course3) {
							tuition += 100;
							courses.add("Obedience 2");
						}else if (checkbox == course4) {
							tuition += 100;
							courses.add("Puppy Etiquette");
						}else if (checkbox == course5) {
							tuition += 100;
							courses.add("Tricks");
						}
					}else {
						if (checkbox == course1) {
							tuition -= 100;
							courses.remove("Agility Training");
						}else if (checkbox == course2) {
							tuition -= 100;
							courses.remove("Obedience 1");
						}else if (checkbox == course3) {
							tuition -= 100;
							courses.remove("Obedience 2");
						}else if (checkbox == course4) {
							tuition -= 100;
							courses.remove("Puppy Etiquette");
						}else if (checkbox == course5) {
							tuition -= 100;
							courses.remove("Tricks");
						}
					}tuitionField.setText(String.valueOf(tuition));


					
				}else {
					if (checkbox.isSelected()) {
						if (checkbox == course1) {
							currentStudent.getCourses().add("Agility Training");
							System.out.println("Add agility.");
							System.out.println(currentStudent.getCourses());
							
							System.out.println("Add 100.");
							currentStudent.addTuition(100);


						}else if (checkbox == course2) {
							currentStudent.addTuition(100);
							currentStudent.getCourses().add("Obedience 1");
						}else if (checkbox == course3) {
							currentStudent.addTuition(100);
							currentStudent.getCourses().add("Obedience 2");
						}else if (checkbox == course4) {
							currentStudent.addTuition(100);
							currentStudent.getCourses().add("Puppy Etiquette");
						}else if (checkbox == course5) {
							currentStudent.addTuition(100);
							currentStudent.getCourses().add("Tricks");
						}
					}else {
						if (checkbox == course1) {
							currentStudent.subTuition(100);
							currentStudent.getCourses().remove("Agility Training");
						}else if (checkbox == course2) {
							currentStudent.subTuition(100);
							currentStudent.getCourses().remove("Obedience 1");
						}else if (checkbox == course3) {
							currentStudent.subTuition(100);
							currentStudent.getCourses().remove("Obedience 2");
						}else if (checkbox == course4) {
							currentStudent.subTuition(100);
							currentStudent.getCourses().remove("Puppy Etiquette");
						}else if (checkbox == course5) {
							currentStudent.subTuition(100);
							currentStudent.getCourses().remove("Tricks");
						}
					}
				System.out.println("Current student tuition: " + currentStudent.getTuition());
				tuitionField.setText(String.valueOf(currentStudent.getTuition()));
				}


			}
			
			if (event.getSource() == newButton) {
				
				//Clear fields and reset student attributes through method.
				clearFields();
				newStudent = true;
				previousButton.setEnabled(false);
				nextButton.setEnabled(false);
		
			}
			
			if (event.getSource() == saveButton) {
				//Retrieves the user input text of student name.
				name = nameField.getText();
				phone = phoneField.getText();
				notes = textareaNotes.getText();

				//if currentstudent already exists; update student .contains()

				if (name.isEmpty()) {
				    JOptionPane.showMessageDialog(new JFrame(), "Empty Invalid Input!", "Error",
				            JOptionPane.ERROR_MESSAGE);
				    
				}else if (!(phone.matches("[0-9]+"))) {
				    JOptionPane.showMessageDialog(new JFrame(), "Phone Invalid Input!", "Error",
				            JOptionPane.ERROR_MESSAGE);} 
				
				else if (Students.size() !=0 && name == currentStudent.getName() && StudentNames.contains(name)) {
					JOptionPane.showMessageDialog(new JFrame(), "Name Invalid Input!", "Error",
				            JOptionPane.ERROR_MESSAGE);}
				
				else if (isNewStudent.equals("None")) {
					JOptionPane.showMessageDialog(new JFrame(), "Select Status!", "Error",
				            JOptionPane.ERROR_MESSAGE);}
	

				
				else{


					if (newStudent == true) {
						//Checks if new student name isnt already within.
						if (StudentNames.contains(name)) {
							JOptionPane.showMessageDialog(new JFrame(), "Name already exists!", "Error",
						            JOptionPane.ERROR_MESSAGE);}
						else {
					
				
						
						//Create student object.
						Student student = new Student(name, breed, breedIndex, phone, isNewStudent, tuition, notes, courses);
						
						//Add new student name
						StudentNames.add(name);
						
						//Add new student object to student arraylist.
						Students.add(student);
						
						newStudent = false;
						
						//Sort is lexicographically order.
						Collections.sort(Students);
						
						//Assign index of current student.
						currentStudentIndex = Students.indexOf(student);
						
						//Assign current Student.
						currentStudent = Students.get(currentStudentIndex);
						
						JOptionPane.showMessageDialog(new JFrame(), "Student Saved!", "Success",
					            JOptionPane.INFORMATION_MESSAGE);}
						
						System.out.println("Existing students: " + StudentNames);

						
					}else {
						
						//if the current name is the same and new name isnt already in currentNames: then edit 
						if (currentStudent.getName().equals(name)) {
							currentStudent.setName(name);
							//Add student name to list
							StudentNames.add(name);
							
							currentStudent.setBreed(breed);
							currentStudent.setPhone(phone);
							currentStudent.setisNewStudent(isNewStudent);
							currentStudent.setNotes(notes);
							
							System.out.println("Courses right before setting: " + currentStudent.getCourses());


							//clearFields();
							displayCurrentStudent();
							
							JOptionPane.showMessageDialog(new JFrame(), "Student Saved!", "Success",
						            JOptionPane.INFORMATION_MESSAGE);
						
							System.out.println("Existing students: " + StudentNames);

						}else {
						//if new name is not already in currentNames							
							System.out.println("Entering this error.");
							JOptionPane.showMessageDialog(new JFrame(), "Name already exists!", "Error",
						            JOptionPane.ERROR_MESSAGE);}


					}

					
					System.out.println("Student " + currentStudent + " info..");
					System.out.println("Student name: " + currentStudent.getName());
					System.out.println("Student breed: " + currentStudent.getBreed());
					System.out.println("Student phone: " + currentStudent.getPhone());
					System.out.println("isNewStudent: " + currentStudent.getisNewStudent());
					System.out.println("Courses: " + currentStudent.getCourses());
					System.out.println("Tuition: " + currentStudent.getTuition());
					System.out.println("Notes: " + currentStudent.getNotes());
					System.out.println("Students List size: " + Students.size());
					System.out.println("Current Student: " + currentStudent);
					System.out.println("Current Student index: " + currentStudentIndex);
					System.out.println("NewStudent: " + newStudent);
					System.out.println();
		

				}
				
				
			}
			
			


			
			if (event.getSource() == deleteButton) {
				//Display error message if there exists no student to delete.
				if (Students.size() == 0) {
					System.out.println("");
				    //JOptionPane.showMessageDialog(new JFrame(), "No student exists to delete!", "Delete Error",
				           // JOptionPane.ERROR_MESSAGE);
				}else {
				
				//Warn user
				int confirmDeletion = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				
				if (confirmDeletion == JOptionPane.YES_OPTION) {
					//delete user from list
					Students.remove(currentStudentIndex);
					if (Students.size() == 0) {
						clearFields();
					}else {
					currentStudent = Students.get(0);
					currentStudentIndex = 0;
					displayCurrentStudent();
					}
				}else {
	                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
			}


			
			
			//Deals with navigation restrictions:
			if (Students.size() == 1 || Students.size() == 0) {
				previousButton.setEnabled(false);
				nextButton.setEnabled(false);
			}
			else if (currentStudentIndex == 0 && Students.size() > 1) {
				previousButton.setEnabled(false);
				nextButton.setEnabled(true);

				}
			
			else if (currentStudentIndex == Students.size() - 1) {
				nextButton.setEnabled(false);
				previousButton.setEnabled(true);
				

			}else {
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			}
			
			
			if (event.getSource() == previousButton) {
				//Assign new current student -1 form current student.
				currentStudent = Students.get(currentStudentIndex - 1);
				currentStudentIndex = currentStudentIndex - 1;
				
				//clear fields.
				clearFields();
				
				//displayCurrentStudent information.
				displayCurrentStudent();
				


			}
			
			if (event.getSource() == nextButton) {
				//Assign new current student -1 form current student.
				currentStudent = Students.get(currentStudentIndex + 1);
				currentStudentIndex = currentStudentIndex + 1;
				
				
				//clear fields.
				clearFields();
				

				//displayCurrentStudent information.
				displayCurrentStudent();
	
			}
			

		}
	}
	
	
	public void printStudentAttributes() {
		//System.out.println("Name: " + name);
	}
	
	
	
	/*Class student creates a student object.
	 * This class holds the student info:
	 * name, breed, phone, status, courses, tuition, notes.
	 * Will be added to the Array List of students within the StudentRosterUI class.
	 * */
	class Student implements Comparable<Student>{
		private String name = "";
		private String breed = "";
		private int breedIndex = 0;
		private String phone = "";
		private String isNewStudent;
		private ArrayList<String> courses;
		private double tuition = 0;
		private String notes = "";
		
		
		//Student constructor.
		public Student(String name, String breed, int breedIndex, String phone, String isNewStudent, double tuition, String notes, ArrayList<String> courses){
			this.name = name;
			this.breed = breed;
			this.breedIndex = breedIndex;
			this.phone = phone;
			this.isNewStudent = isNewStudent;
			this.tuition = tuition;
			this.notes = notes;
			this.courses = courses;

		}
		
		//get methods to retrieve student attributes.
		public String getName() {
			return name;
		}
		
		public int getBreedIndex() {
			return breedIndex;
		}
		
		public String getBreed() {
			return breed;
		}
		
		public String getPhone() {
			return phone;
		}
		
		public String getisNewStudent() {
			return isNewStudent;
		}
		
		public ArrayList<String> getCourses() {
			return courses;
		}
		
		public double getTuition() {
			return tuition;
		}
		
		public void addTuition(double addtuition) {
			tuition += addtuition;
		}
		
		public void subTuition(double subtuition) {
			tuition -= subtuition;
		}
		
		public String getNotes() {
			return notes;
		}
		
		//Set methods
		public void setName(String name) {
			this.name = name;
		}
		
		public void setBreedIndex(int breedIndex) {
			this.breedIndex = breedIndex;
		}
		
		public void setBreed(String breed) {
			this.breed = breed;
		}
		
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public void setisNewStudent(String isNewStudent) {
			this.isNewStudent = isNewStudent;
		}
		
		public void setCourses(ArrayList<String> courses) {
			this.courses = courses;
			
		}
		
		public void setTuition(double tuition) {
			this.tuition = tuition;
		}
		
		public void setNotes(String notes) {
			this.notes = notes;
		}
		
		
		
		@Override
		public int compareTo(Student o) {
			return  getName().compareTo(o.getName());
		}
		

	
}
	
	
	


	public static void main (String[] args) {
		//Create a JFrame object.
		JFrame frame = new StudentRosterUI();
		
		//Exists application when user closes frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Sets the frame visible to user.
		frame.setVisible(true);
		
		((StudentRosterUI) frame).printStudentAttributes();
	}


}
