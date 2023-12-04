module com.example.finalprojectparttwo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalprojectparttwo to javafx.fxml;
    exports com.example.finalprojectparttwo;
}