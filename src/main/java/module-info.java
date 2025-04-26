module SerenityMentalHealthTherapyCenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires jasperreports;
    requires jbcrypt;

    opens com.serenity.controller to javafx.fxml;
    opens com.serenity.config to org.hibernate.orm.core;
    opens com.serenity.entity to org.hibernate.orm.core;
    opens com.serenity.tm to javafx.base;

    exports com.serenity;

}