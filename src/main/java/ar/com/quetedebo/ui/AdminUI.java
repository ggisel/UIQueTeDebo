package ar.com.quetedebo.ui;

import ar.com.quetedebo.core.QueTeDebo;

public class AdminUI extends DebtsView {

    public AdminUI(QueTeDebo queTeDebo) {
        super(queTeDebo);
        getButtonPay().setVisible(false);
        getButtonPay().setEnabled(false);
        AdminOptions adminPanel = new AdminOptions(queTeDebo);
        getContentPane().add(adminPanel);
    }
}
