package ar.com.quetedebo.ui.admin;

import ar.com.quetedebo.core.QueTeDebo;
import ar.com.quetedebo.ui.debts.DebtsView;

public class AdminUI extends DebtsView {

    public AdminUI(QueTeDebo queTeDebo) {
        super(queTeDebo);
        getButtonPay().setVisible(false);
        getButtonPay().setEnabled(false);
        AdminOptions adminPanel = new AdminOptions(queTeDebo);
        getContentPane().add(adminPanel);
    }
}
