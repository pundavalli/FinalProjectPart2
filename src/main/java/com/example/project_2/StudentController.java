package com.example.project_2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StudentController {

    TextField[] textFields;
    private ObservableList<Advisee> adviseesList = FXCollections.observableArrayList();
    private String name, acadID, email, address;
    private long phoneNum;
    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private String courseName;
    private int courseCredits;
    private double course_Cost;

    @FXML
    private Button addBtn;

    @FXML
    private Button editBtn;
    @FXML
    private Button add_CourseBtn;

    @FXML
    private ListView<Advisee> listView;

    @FXML
    private TextField txt_acadID;

    @FXML
    private TextField txt_address;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_phoneNum;
    @FXML
    private ListView<Course> courseList;
    @FXML
    private TextField text_courseName;
    @FXML
    private TextField text_courseCredits;
    @FXML
    private TextField text_course_Cost;

    public StudentController() {
    }

    private void fillData() {
        name = txt_name.getText();
        acadID = txt_acadID.getText();
        email = txt_email.getText();
        phoneNum = Long.parseLong(txt_phoneNum.getText());
        address = txt_address.getText();
    }

    private void clearTextFields() {
        for (TextField tf : textFields) {
            tf.clear();
        }
    }

    @FXML
    void addBtnPress(ActionEvent event) {
        fillData();

        Advisee addedAdvisee = new Advisee(name, acadID);
        addedAdvisee.setEmail(email);
        //addedAdvisee.setAddress(address);
        addedAdvisee.setPhoneNum(phoneNum);
        adviseesList.add(addedAdvisee);

        clearTextFields();
    }

    @FXML
    void editBtnPress(ActionEvent event) {
        fillData();

        Advisee editedAdvisee = listView.getSelectionModel().getSelectedItem();

        if (!name.isEmpty()) {
            editedAdvisee.setName(name);
        }
        if (!email.isEmpty()) {
            editedAdvisee.setEmail(email);
        }
        editedAdvisee.setPhoneNum(phoneNum);
        listView.getSelectionModel().clearSelection();

        clearTextFields();
    }
    @FXML
    void addCourse_Press(ActionEvent event){
        Course c = courseList.getSelectionModel().getSelectedItem();
        listView.getSelectionModel().getSelectedItem().getCourses().add(c);
    }
    @FXML
    void initialize() {
        textFields = new TextField[]{txt_name, txt_acadID, txt_email, txt_phoneNum, txt_address,text_courseName,text_courseCredits,text_course_Cost};

        listView.setItems(adviseesList);
        Course course=new Course("Math141H",3,1050);
        Course course2=new Course("Phys211",2,700);
        Course course3=new Course("Honors-301",3,1050);
        Course course4=new Course("CmpSci221",3,1050);
        courses.add(course);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courseList.setItems(courses);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Advisee>() {
            @Override
            public void changed(ObservableValue<? extends Advisee> observableValue, Advisee oldA, Advisee newA) {
                txt_name.setText(newA.getName());
                txt_acadID.setText(newA.getID());
                txt_email.setText(newA.getEmail().toString());
                txt_phoneNum.setText("" + newA.getPhoneNum());
                txt_address.setText(newA.getAddress().toString());
            }
            public void modified_Course(ObservableValue<? extends Course> observableValue, Course oldC, Course newC){
                text_courseName.setText(newC.getCourseName());
                text_courseCredits.setText(String.valueOf(newC.getNumOfCredits()));
                text_course_Cost.setText(String.valueOf(newC.getPrice()));
            }
        });
    }
}