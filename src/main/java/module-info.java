module com.example.attendancesystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.attendancesystem to javafx.fxml;
    exports com.example.attendancesystem;
    exports com.example.attendancesystem.login;
    opens com.example.attendancesystem.login to javafx.fxml;
    exports com.example.attendancesystem.Student;
    opens com.example.attendancesystem.Student to javafx.fxml;
}