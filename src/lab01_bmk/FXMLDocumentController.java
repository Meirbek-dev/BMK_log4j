package lab01_bmk;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author meirb
 */
public class FXMLDocumentController implements Initializable {

    private static final Logger logger = Logger.getLogger(JavaFX_log4j.class);
    @FXML
    private Label label;
    @FXML
    private Button solve;
    @FXML
    private Button clean;
    @FXML
    private Button exit;
    @FXML
    private TextField textInputA;
    @FXML
    private TextField textInputB;
    @FXML
    private TextField textInputX;
    @FXML
    private TextField textInputD;
    @FXML
    private Label textResult;
    @FXML
    private TextField textInputC;

    @FXML
    private void solve(ActionEvent event) {
        double a, b, c, x, d, y;
        try {
            a = Double.parseDouble(textInputA.getText());
            b = Double.parseDouble(textInputB.getText());
            c = Double.parseDouble(textInputC.getText());
            x = Double.parseDouble(textInputX.getText());
            d = Double.parseDouble(textInputD.getText());
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введеных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textInputA.requestFocus();
            textResult.setText("В введённых значениях допущены ошибки");
            logger.error("В введённых значениях допущены ошибки");
            textInputA.setText("");
            textInputB.setText("");
            textInputX.setText("");
            textInputD.setText("");
            textInputC.setText("");
            logger.debug("Значения ячеек очищены");
            return;
        }

        if (x <= 5) {
            y = ((a * a * c + b * b - d) / x);
            logger.debug("Выполнено вычисление по алгоритму, где x <= 5");
        } else {
            y = (x * x + 5);
            logger.debug("Выполнено вычисление по алгоритму, где x > 5");
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            textResult.setText("Ответ: " + String.format(":%.2f", y));
        } else {
            textResult.setText("Нет ответа");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clean(ActionEvent event) {
        textResult.setText("Ответ: ");
        textInputA.setText("");
        textInputB.setText("");
        textInputX.setText("");
        textInputD.setText("");
        textInputC.setText("");
        logger.debug("Значения ячеек очищены");
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
