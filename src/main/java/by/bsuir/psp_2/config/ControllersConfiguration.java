package by.bsuir.psp_2.config;

import by.bsuir.psp_2.view.StartupView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Configuration
public class ControllersConfiguration {

    @Bean(name = "mainView")
    public ViewHolder viewHolder() throws IOException {
        return loadView("fxml/main.fxml");
    }

    @Bean
    public StartupView startupView() throws IOException {
        return (StartupView) viewHolder().getController();
    }

    private ViewHolder loadView(String url) throws IOException {
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new ViewHolder(loader.getRoot(), loader.getController());
        } finally {
            if (fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class ViewHolder {
        private Parent view;
        private Object controller;
    }

}
