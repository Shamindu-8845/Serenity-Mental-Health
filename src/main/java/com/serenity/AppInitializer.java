package com.serenity;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.serenity.config.FactoryConfiguration;
import com.serenity.entity.Users;
import com.serenity.util.PasswordUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();

       /* Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        Users user = new Users();
        user.setName("Shamindu");
        String hashPassword = PasswordUtil.hashPassword("1234");
        user.setPassword(hashPassword);
        user.setJobRole("Admin");

        session.save(user);
        transaction.commit();

        session.close();*/
    }
}
