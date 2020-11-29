/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_bmk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 *
 * @author meirb
 */
public class JavaFX_log4j extends Application {

    private static final Logger logger = Logger.getLogger(JavaFX_log4j.class);

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

            Scene scene = new Scene(root);
            logger.debug("Создание новой сцены");
            stage.setScene(scene);
            stage.setResizable(false);
            logger.debug("Запрет изменения размера окна");
            stage.show();
            logger.debug("Включение отображения сцены");
            stage.setTitle("Calculator JavaFX");
            logger.debug("Установка заголовка окна 'Calculator JavaFX'");
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
