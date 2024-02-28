module be.ebbewertz.pygitnodes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens be.ebbewertz.pygitnodes to javafx.fxml;
    exports be.ebbewertz.pygitnodes;
}