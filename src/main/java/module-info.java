module com.sebasth.bank {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.net.http;
    requires org.json.chargebee;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires java.sql;

    opens com.sebasth.bank to javafx.fxml;
    exports com.sebasth.bank;
    exports com.sebasth.bank.controllers;
    opens com.sebasth.bank.controllers to javafx.fxml;
    exports com.sebasth.bank.objects;
    opens com.sebasth.bank.objects to javafx.fxml;
}