module com.example.lowleveldesign {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lowleveldesign to javafx.fxml;
    exports com.example.lowleveldesign;
    exports dataaccessor;
    opens dataaccessor to javafx.fxml;
}