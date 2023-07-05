package de.neuefische.studentdbfrontend;

import de.neuefische.studentdbfrontend.service.StudentService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    private final StudentService studentService = new StudentService();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(studentService.getStudentByMatriculationNumber("MN-873151").toString());
    }

}