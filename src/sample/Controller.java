package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainScene;

    @FXML
    private TextField textName;

    @FXML
    private TextField textSecondName;

    @FXML
    private TextField textNickname;

    @FXML
    private TextField textWeight;

    @FXML
    private TextField textGender;

    @FXML
    private TextField textActivity;

    @FXML
    private TextField textAge;

    @FXML
    private Button buttonRegistration;

    @FXML
    private Button buttonEnter;

    @FXML
    private Line checkName;

    @FXML
    private Line checkSecondName;

    @FXML
    private Line checkNickname;

    @FXML
    private Line checkWeight;

    @FXML
    private Line checkGender;

    @FXML
    private Line checkActivity;

    @FXML
    private Line checkAge;
    private Stage stage;

    @FXML
    void initialize() throws IOException {

        //Обработка событий, при нажатии кнопки регистрации
        buttonRegistration.setOnAction(event -> {
            String gender = "";
            double activity = 0.0;
            String job = "";
            int age = 0;
            double weight = 0;
            String name = "";
            String secondName = "";
            String nickname = "";

            // Выбор пола
            gender = textGender.getText();
            if (!gender.equals("male") && !gender.equals("female")) {
                checkGender.setVisible(true);
                textGender.setText("");
            } else {
                checkGender.setVisible(false);
            }

            // Выбор активности
            job = textActivity.getText();
            if (!job.equals("1") && !job.equals("2") && !job.equals("3")) {
                checkActivity.setVisible(true);
                textActivity.setText("");
            } else if (job.equals("1")) {
                activity = 1.1;
                checkActivity.setVisible(false);
            } else if (job.equals("2")) {
                activity = 1.3;
                checkActivity.setVisible(false);
            } else {
                activity = 1.5;
                checkActivity.setVisible(false);
            }

            // Ввод возраста
            try {
                age = Integer.parseInt(textAge.getText());
                checkAge.setVisible(false);
            } catch (NumberFormatException e) {
                checkAge.setVisible(true);
                textAge.setText("");
            }

            if (age <= 0) {
                checkAge.setVisible(true);
                textAge.setText("");
            }

            // Ввод веса
            try {
                weight = Double.parseDouble(textWeight.getText());
                checkWeight.setVisible(false);
                if (weight < 30 || weight > 300) {
                    checkWeight.setVisible(true);
                    textWeight.setText("");
                }
            } catch (NumberFormatException e) {
                checkWeight.setVisible(true);
                textWeight.setText("");
            }

            // Ввод имени
            name = textName.getText();
            if (name.equals("")) {
                checkName.setVisible(true);
                textName.setText("");
            } else {
                checkName.setVisible(false);
            }

            if (checkName.isVisible()) {
                System.out.println("hui");
            }

            //Ввод фамилии
            secondName = textSecondName.getText();
            if (secondName.equals("")) {
                checkSecondName.setVisible(true);
                textSecondName.setText("");
            } else {
                checkSecondName.setVisible(false);
            }

            //Ввод никнейма
            nickname = textNickname.getText();
            if (nickname.equals("")) {
                checkNickname.setVisible(true);
                textNickname.setText("");
            } else {
                checkNickname.setVisible(false);
            }

            //Вызов функции, считающей дневную норму калорий
            double value = calc(gender, activity, age, weight);

            if (!checkName.isVisible() && !checkSecondName.isVisible() && !checkNickname.isVisible() && !checkWeight.isVisible()
                    && !checkActivity.isVisible() && !checkGender.isVisible() && !checkAge.isVisible()) {

                /*buttonRegistration.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("account.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();*/
            } else {
                System.out.println("qwe");
            }
        });
    }


    //Функция, считающая норму калорий
    static double calc(String gender, double activity, int age, double weight) {
        if (gender.equals("female")) {
            if (age <= 30) {
                return (0.0621 * weight + 2.0357) * 240 * activity;
            } else if (age > 31 && age < 60) {
                return (0.0342 * weight + 3.5377) * 240 * activity;
            } else {
                return (0.0377 * weight + 2.7545) * 240 * activity;
            }
        } else {
            if (age <= 30) {
                return (0.0630 * weight + 2.8957) * 240 * activity;
            } else if (age > 31 && age < 60) {
                return (0.0484 * weight + 3.6534) * 240 * activity;
            } else {
                return (0.0491 * weight + 2.4587) * 240 * activity;
            }
        }
    }
}

