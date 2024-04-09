import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame("App");
        window.setSize(400, 400);
        window.getContentPane().setBackground(Color.darkGray);
        // panel
        App app = new App();
        MeasurementFrame measurement = app.new MeasurementFrame();
        UnitFrame unitFrame = app.new UnitFrame(measurement);
        ShowButton showButton = app.new ShowButton();
        ShowResult showResult = app.new ShowResult();
        window.add(measurement);
        window.add(unitFrame);
        window.add(showButton);
        window.add(showResult);
        // update
        window.getContentPane().setLayout(new GridLayout(4, 2));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        measurement.setUnitFrame(unitFrame);
    }

    // add elements
    public class MeasurementFrame extends JPanel {
        private JComboBox<String> measurement;
        private UnitFrame unitFrame;

        public MeasurementFrame() {
            setBackground(Color.lightGray);
            JLabel label = new JLabel("Measurement");
            add(label);
            String measurementItems[] = { "Area", "Data Transfer Rate", "Digital Storage", "Energy", "Frequency",
                    "Fuel Economy", "Length", "Mass", "Plane Angle", "Pressure", "Speed", "Temperature", "Time",
                    "Volume" };
            measurement = new JComboBox<>(measurementItems);
            measurement.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateUnitList((String) measurement.getSelectedItem());
                }
            });
            add(measurement);
        }

        public void setUnitFrame(UnitFrame unitFrame) {
            this.unitFrame = unitFrame;
        }

        private void updateUnitList(String selectedItem) {
            String[] units;
            switch (selectedItem) {
                case "Area":
                    units = new String[] { "Square Kilometre", "Square Metre", "Square Mile", "Square Yard",
                            "Square Foot", "Square Inch", "Hectare", "Acre" };
                    break;
                case "Data Transfer Rate":
                    units = new String[] { "Bit per second", "Kilobit per second", "Kilobyte per second",
                            "Kibibit per second", "Megabit per second", "Megabyte per second", "Mebibit per second",
                            "Gigabit per second", "Gigabyte per second", "Gibibit per second", "Terabit per second",
                            "Terabyte per second", "Tebibit per second" };
                    break;
                // Add cases for other measurement types
                default:
                    units = new String[] { "" };
                    break;
            }
            unitFrame.updateUnitList(units);
        }
    }

    public class UnitFrame extends JPanel {
        private JComboBox<String> unit;
        private JTextField texbox;

        public UnitFrame(MeasurementFrame measurementFrame) {
            setBackground(Color.lightGray);
            JLabel label = new JLabel("Enter value");
            add(label);
            texbox = new JTextField(10);
            add(texbox);
            unit = new JComboBox<>(new String[] {});
            add(unit);
        }

        public void updateUnitList(String[] units) {
            unit.removeAllItems();
            for (String unitName : units) {
                unit.addItem(unitName);
            }
        }
    }

    public class ShowButton extends JPanel {
        public ShowButton() {
            setBackground(Color.lightGray);
            JButton Submit = new JButton("Submit");
            add(Submit);
        }
    }

    public class ShowResult extends JPanel {
        public ShowResult() {
            setBackground(Color.lightGray);
            JLabel label = new JLabel("Comparing values");
            add(label);
            JLabel label_information = new JLabel("None");
            add(label_information);
        }
    }

    // show results
    public class Results {
        public String measurement;
        public String unit;
        public Double value;
        private String compareUnit;
        private Double compareValue;

        public Results(String measurement, String unit, Double value) {
            this.measurement = measurement;
            this.unit = unit;
            this.value = value;
        }

        public String get_compareUnit() {
            if (measurement.equalsIgnoreCase("Area")) {

            }
        }
    }
}