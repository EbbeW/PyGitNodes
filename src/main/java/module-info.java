module be.ebbewertz.pygitnodes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens be.ebbewertz.pygitnodes to javafx.fxml;
    exports be.ebbewertz.pygitnodes;
}