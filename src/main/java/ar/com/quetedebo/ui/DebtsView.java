package ar.com.quetedebo.ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import ar.com.quetedebo.core.Debt;
import ar.com.quetedebo.core.QueTeDebo;

public class DebtsView extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton buttonPay;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDebts;
    private javax.swing.JLabel labelNotDebts;
    private javax.swing.JMenu menuDebts;
    private javax.swing.JMenu menuPaymentsMethods;
    private javax.swing.JMenuBar menuQTD;
    private javax.swing.JPanel panelDebts;
    private javax.swing.JPanel panelNotDebts;
    private javax.swing.JTable tableDebts;
	
	private DebtsController debtsController;

	public DebtsView(QueTeDebo queTeDebo) {
		queTeDebo.addObserver(this);
		debtsController = new DebtsController(queTeDebo, this);
		
		initComponents();
		setDataComponents();
	}

	private void initComponents() {

        panelDebts = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDebts = new javax.swing.JTable();
        buttonPay = new javax.swing.JButton();
        labelDebts = new javax.swing.JLabel();
        panelNotDebts = new javax.swing.JPanel();
        labelNotDebts = new javax.swing.JLabel();
        menuQTD = new javax.swing.JMenuBar();
        menuDebts = new javax.swing.JMenu();
        menuPaymentsMethods = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QueTeDebo");
        setResizable(false);

        tableDebts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Pagar a", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDebts);

        buttonPay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonPay.setText("Pagar");

        labelDebts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDebts.setText("Vas a pagar las siguientes deudas");

        javax.swing.GroupLayout panelDebtsLayout = new javax.swing.GroupLayout(panelDebts);
        panelDebts.setLayout(panelDebtsLayout);
        panelDebtsLayout.setHorizontalGroup(
            panelDebtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDebtsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDebtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDebtsLayout.createSequentialGroup()
                        .addComponent(labelDebts, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDebtsLayout.createSequentialGroup()
                        .addGroup(panelDebtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonPay)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelDebtsLayout.setVerticalGroup(
            panelDebtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDebtsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDebts)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPay)
                .addGap(117, 117, 117))
        );

        labelNotDebts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNotDebts.setText("No tenés deudas para pagar");

        javax.swing.GroupLayout panelNotDebtsLayout = new javax.swing.GroupLayout(panelNotDebts);
        panelNotDebts.setLayout(panelNotDebtsLayout);
        panelNotDebtsLayout.setHorizontalGroup(
            panelNotDebtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotDebtsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNotDebts, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelNotDebtsLayout.setVerticalGroup(
            panelNotDebtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotDebtsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNotDebts)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        menuDebts.setText("Gastos");
        menuQTD.add(menuDebts);

        menuPaymentsMethods.setText("Metódos de pago");
        menuQTD.add(menuPaymentsMethods);

        setJMenuBar(menuQTD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDebts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNotDebts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDebts, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNotDebts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
	
	private void setDataComponents() {
		panelNotDebts.setVisible(debtsController.getDebts().size() == 0);
		DefaultTableModel model = (DefaultTableModel) this.tableDebts.getModel();
		for (Debt debt : debtsController.getDebts()) {
			model.addRow(new Object[]{debt.getDescription(), debt.getMemberPayment(), debt.getAmount()});
        }
		
		debtsController.addActionButtonPay(buttonPay);
	}
	
	public JButton getButtonPay() {
		return buttonPay;
	}

	public void update(Observable o, Object paymentMethod) {
		if (paymentMethod instanceof String) {
            panelDebts.setVisible(false);
            labelNotDebts.setText("Pagaste tus deudas con " + paymentMethod);
            panelNotDebts.setVisible(true);
        }
	}
}
