package frames;

import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class SalesHistory extends JTable {
    private JPanel saleHistoryBody;
    private JTable tableSalesHistory;
    private JScrollPane barras;
    private DefaultTableModel modelo;
    private String[] columnas;

    public SalesHistory() {
        this.saleHistoryBody = new JPanel();
        //DefaultTableModel modelTable = new DefaultTableModel();
        //this.tableSalesHistory = new JTable(modelTable);

        this.barras = new JScrollPane(tableSalesHistory);
        this.modelo = new DefaultTableModel();
        this.tableSalesHistory = new JTable(modelo);
        this.addColumns();
        this.getTableSalesHistory().setModel(this.getModelo());
        this.addInformation();
        this.getTableSalesHistory().setPreferredSize(new Dimension(500, 100));
    }

    public void addColumns() {
        JSONObject model = new JSONObject();
        model.put("Nombre", "Victor");
        model.put("Apellido", "Benavente");
        model.put("Edad", 24);
        Iterator<String> keys = model.keys();
        int index = 0;
        this.setColumnas(new String[3]);
        while (keys.hasNext()) {
            String key = keys.next();
            this.getColumnas()[index] = key;
            index++;
        }
        this.getModelo().setColumnIdentifiers(this.getColumnas());
    }


    public void addInformation() {
        for(int i=0; i<5; i++) {
            String mensaje = (i+1) + " HELADOS";
            String[] info = {String.valueOf(i+1), mensaje, " INFO "};
            this.getModelo().addRow(info);
        }
        this.getSaleHistoryBody().add(this.getTableSalesHistory());
    }

    public JPanel getSaleHistoryBody() {
        return saleHistoryBody;
    }

    public void setSaleHistoryBody(JPanel saleHistoryBody) {
        this.saleHistoryBody = saleHistoryBody;
    }

    public JTable getTableSalesHistory() {
        return tableSalesHistory;
    }

    public void setTableSalesHistory(JTable tableSalesHistory) {
        this.tableSalesHistory = tableSalesHistory;
    }

    public JScrollPane getBarras() {
        return barras;
    }

    public void setBarras(JScrollPane barras) {
        this.barras = barras;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }
}
