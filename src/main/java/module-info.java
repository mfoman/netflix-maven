module com.netflix {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.netflix to javafx.fxml;
    opens com.netflix.controllers to javafx.fxml;
    exports com.netflix;
}