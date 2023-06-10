package tableModel;

import model.Barva;
import utils.GsonSaver;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private static final int POCET_SLOUPCU = 4;
    private static final int SLOUPEC_R = 0;
    private static final int SLOUPEC_G = 1;
    private static final int SLOUPEC_B = 2;
    private static final int SLOUPEC_HEXA = 3;
    private GsonSaver saver = new GsonSaver();
    private List<Barva> colorList = new ArrayList<>();

    public TableModel() {
    }

    public void addColor(Barva color) {
        colorList.add(color);
        int radek = colorList.size() - 1;
        fireTableRowsInserted(radek, radek);
    }

    public void saveToJson(String file) throws IOException {
        saver.uloz(file, colorList);
    }

    @Override
    public int getRowCount() {
        return colorList.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_SLOUPCU;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0: return "Red";
            case 1: return "Green";
            case 2: return "Blue";
            case 3: return "Hexa kod";
        }
        throw new RuntimeException("Unknown Column Index" + columnIndex);

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case SLOUPEC_R, SLOUPEC_G, SLOUPEC_B:
                return Integer.class;
            case SLOUPEC_HEXA:
                return String.class;
            default:
                throw new IllegalArgumentException("Nesprávný index sloupce tabulky.");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Barva barva = colorList.get(rowIndex);

        switch (columnIndex) {
            case SLOUPEC_R:
                return barva.getRed();
            case SLOUPEC_G:
                return barva.getGreen();
            case SLOUPEC_B:
                return barva.getBlue();
            case SLOUPEC_HEXA:
                return barva.getHexa();
            default:
                throw new IllegalArgumentException("Nesprávný index sloupce tabulky.");
        }
    }

    @Override
    public void setValueAt(Object hodnota, int rowIndex, int columnIndex) {
        Barva barva = colorList.get(rowIndex);

        switch (columnIndex) {
            case SLOUPEC_R:
                barva.setRed((Integer) hodnota);
                break;
            case SLOUPEC_G:
                barva.setGreen((Integer) hodnota);
                break;
            case SLOUPEC_B:
                barva.setBlue((Integer) hodnota);
                break;
            case SLOUPEC_HEXA:
                barva.setHexa((String) hodnota);
            default:
                throw new IllegalArgumentException("Nesprávný index sloupce tabulky.");
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
