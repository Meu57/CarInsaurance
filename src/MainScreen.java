import Plan.*;
import Policy.Costumer;
import Policy.Policy;
import Policy.Vehicle;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class MainScreen extends JFrame {
    //Font & Color
    Font myFont = new Font("SanSerif", Font.BOLD,28);
    Color myColor= Color.GRAY;

    // CustomizePanel 1 Variables
    JTextField subFname;
    JTextField subLname;
    JTextField subCity;
    JTextField subPhone;



    //CustomizePanel 2 Variables

    JTextField model;
    JTextField manufacturer;
    JTextField plateNb;
    JTextField estimated;
    JRadioButton damageradioButton1;
    JRadioButton damageradioButton2;
    JRadioButton damageradioButton3;
    JRadioButton damageradioButton4;
    ButtonGroup G1;



    // CustomizePanel 3 Variables

    JCheckBox obligatoryChkBX;
    JCheckBox allRiskChkBX;
    JCheckBox vehicleDamageChkBX;
    JCheckBox driverDamageChkBX;
    JCheckBox assistanceChkBX;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRisksList = new ArrayList<>();

    //CustomizePanel 4 Variables
    JRadioButton yearRadio;
    JRadioButton yearRadio2;
    JRadioButton yearRadio3;
    JRadioButton  yearRadio4;
    ButtonGroup G2;
    JLabel todayLBL;
    int validityYear=0;
    SimpleDateFormat df;
    Date currentDate;

    //CustomizePanel 6 Variables
    JTextArea risksTXT;
    JTextField searchTXT;
    Map<Integer, Costumer> customerMap = new TreeMap<>();

    //CustomizePanel 7 Variables
    JTextArea policyTXT;

    //CustomizePanel 8 Variables
    JTextArea customerTXT;

    //CustomizePanel 9 Variable

    JLabel claimingTXT1;
    JLabel claimingTXT2;
    JTextField claimingCoustumerField;

    //CustomizePanel 10
     JLabel claimingCostumerNameLBL;
     JLabel claimingCostumerValidateDateLBL;
     JLabel claimStatusLBL2;
    JTextArea claimingCostumerRisksCoveredAREA;

    boolean cond1;
    boolean cond2;
    boolean cond3;

    //CustomizePanel 11
    JTextArea settelmentArea;
    double totalPremium =0;
    double totalCoverage =0;
    double totalCeiling =0;
    //CustomizePanel 12
    JTextArea settelmentArea2;

    /***************METHODS************************/
    //Geting Costumer Data
    public Costumer GetCustomerData() throws ParseException{
        Costumer costumer = new Costumer(
                subFname.getText(),
                subLname.getText(),
                subCity.getText(),
                subPhone.getText(),
                GetPolicyData()
        );
        return costumer;
    }
    //Get Vehicle data
    public Vehicle GetVehicleData() throws ParseException{
        Vehicle vehicle= new Vehicle(
         Integer.parseInt(plateNb.getText()),
                Integer.parseInt(model.getText()),
                manufacturer.getText(),
                Integer.parseInt(estimated.getText()),
                GetDamageState());
        return vehicle;
    }

    //Get Damage Data
    public int GetDamageState(){
        if(damageradioButton1.isSelected()){
            return 1;

        }else if(damageradioButton2.isSelected()){
            return 2;
        }else if(damageradioButton3.isSelected()){
            return 3;
        }else if(damageradioButton4.isSelected()){
            return 4;
        }else {
            return 0;
        }

    }
    //Get Policy data
   private Policy GetPolicyData() throws ParseException{
        currentDate = new Date();
       LocalDate now = LocalDate.now();
       Policy policy= new Policy(
        GetVehicleData(),
        coveredRisksList,
        coverageRisksList,
        ceilingRisksList,
        premiumRisksList,
        validityYear,
         now
       );
       return policy;
    }

    //Resetting Fields to Empty

    private void NewCustomer(){
        coverageRisksList.clear();
        coveredRisksList.clear();
        premiumRisksList.clear();
        ceilingRisksList.clear();
        coveredRisksList.clear();
        cond1=false;
        cond2=false;
        cond3=false;

        //Setting textfields to Empty
        subFname.setText("");
        subLname.setText("");
        subCity.setText("");
        subPhone.setText("");
        plateNb.setText("");
        model.setText("");
        manufacturer.setText("");
        estimated.setText("");

        //set Radio button selection to non

        G1.clearSelection();
        G2.clearSelection();

        //Reset CheckBox
        allRiskChkBX.setSelected(false);
        obligatoryChkBX.setSelected(false);
        vehicleDamageChkBX.setSelected(false);
        driverDamageChkBX.setSelected(false);
        assistanceChkBX.setSelected(false);

        obligatoryChkBX.setEnabled(false);
        vehicleDamageChkBX.setEnabled(false);
        driverDamageChkBX.setEnabled(false);
        assistanceChkBX.setEnabled(false);

    }

    // Get Risks Covered By Plan Function
    private void GetRisksCoveredByPlan() {
        AllRisk allRisk = new AllRisk();
        ObligatoryRisk obligatoryRisk= new ObligatoryRisk();
        allRiskChkBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverDamageChkBX.setEnabled(false);
                vehicleDamageChkBX.setEnabled(false);
                assistanceChkBX.setEnabled(false);
                obligatoryChkBX.setEnabled(false);

                //Adding Risk details to an Array

                for (int i = 0; i < allRisk.allRisksCovered.length; i++) {
                    coveredRisksList.add(allRisk.allRisksCovered[i]);
                }

                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
            }
        });
        obligatoryChkBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coveredRisksList.add(obligatoryRisk.obligatoryRisksCovered[0]);
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
            }
        });
        vehicleDamageChkBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRisk vehicleRisk = new VehicleRisk();

                //Adding Risk Details to arrays
                coveredRisksList.add(obligatoryRisk.obligatoryRisksCovered[0]);
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
            }
        });
        driverDamageChkBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk= new DriverRisk();

                //Adding Risk Details to arrays
                coveredRisksList.add(obligatoryRisk.obligatoryRisksCovered[0]);
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
            }
        });
        assistanceChkBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AssistanceRisk assistanceRisk= new AssistanceRisk();
                
                //Adding Risk Details to the Array
                for (int i = 0; i < assistanceRisk.AssistanceRisksCovered.length; i++) {
                    coveredRisksList.add(assistanceRisk.AssistanceRisksCovered[i]);
                }
            }
        });


    }

    //Save Data to Disk
    public void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("D:/myfile.dat");
        int platenumber = Integer.parseInt(plateNb.getText());


            if (!file.exists()) {

                //creating new file
                System.out.println("File Created");
                file.createNewFile();
                SaveCustomerMapToNewFile(platenumber, file);

            } else {
                //file exists
                FileInputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is);

                TreeMap<Integer, Costumer> newMaptoSave = new TreeMap<>();
                TreeMap<Integer, Costumer> mapInFile = (TreeMap<Integer, Costumer>) ois.readObject();
                ois.close();
                is.close();

                //Get Old MAP

                for (Map.Entry<Integer, Costumer> m : mapInFile.entrySet()) {
                    newMaptoSave.put(m.getKey(), m.getValue());
                }

                //Updating the map: Adding new Customer to map
                newMaptoSave.put(platenumber, GetCustomerData());
                OutputStream os = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(os);
                //Saving the Updates to file
                oos.writeObject(newMaptoSave);
                oos.flush();
                oos.close();
            }


        }
public void SaveCustomerMapTools() throws ParseException {
        Costumer costumer=GetCustomerData();
        costumer.addToDB();
}
    private void SaveCustomerMapToNewFile(int platenumber, File file) throws ParseException, IOException {
        TreeMap<Integer,Costumer> newMaptoSave = new TreeMap<>();

        //Adding new Costumer to map
        newMaptoSave.put(platenumber,GetCustomerData());

        FileOutputStream os =  new FileOutputStream(file);
        ObjectOutputStream oos= new ObjectOutputStream(os);
        oos.writeObject(newMaptoSave);
        oos.flush();
        oos.close();
    }


    //Search Customer By Mobile Number

    private void  SearchCustomerByMobileNumber(){
        File file = new File("D:/myfile.dat");
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            TreeMap<Integer, Costumer> mapInFile = (TreeMap<Integer, Costumer>) ois.readObject();
            ois.close();
            is.close();

            Costumer costumer_find = mapInFile.get(Integer.parseInt(searchTXT.getText()));
            customerTXT.setText(costumer_find.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Costumer ClaimsSearchCustomerByMobileNumber(){
        Costumer costumer;
        File file = new File("D:/myfile.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            TreeMap<Integer, Costumer> mapInFile = (TreeMap<Integer, Costumer>) ois.readObject();
            ois.close();
            is.close();
            costumer = mapInFile.get(Integer.parseInt(claimingCoustumerField.getText()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return costumer;
    }

    //Checking Validity Of Policy
    private boolean CheckPolicyValidity(LocalDate validityOfPolicy){

        LocalDate now = LocalDate.now();
        if(now.isBefore(validityOfPolicy)){
            cond3=true;
            return true;
        }else{
            cond3= false;
            return false;
        }
        }
        private boolean ClaimsIsValid(){
           if(cond1==true && cond2 ==true && cond3==true){
                claimStatusLBL2.setText("Claiming Status: You can register your claim");
            return true;
        }else{
            claimStatusLBL2.setText("Claiming Status: You can't register the claim ");
            return false;
        }
        }
    //Display payments 
    private void DisplayPaymentsOfPolicy(){
        for (int i = 0; i < premiumRisksList.size(); i++) {
            totalPremium+=premiumRisksList.get(i);
            totalCoverage+=coverageRisksList.get(i);
            totalCeiling+=ceilingRisksList.get(i);
        }
        settelmentArea.setText(
                "Total Premium "+totalPremium*Integer.parseInt(estimated.getText()) + " Rs\n" +
                        "Risk Coverage: " + totalCoverage*Integer.parseInt(estimated.getText())*10 + " Rs\n" +
                        "Maximum Ceiling: "+totalCeiling*Integer.parseInt(estimated.getText()) + 100000 + " Rs\n"
        );
    }
    



    /**** Customization Methods *****/
    private void CustomizePanel1(){
        JPanel p1= new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Customer  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);
        p1.setBorder(titledBorder);

        //Label For Panel 1
        JLabel fnameLBL= new JLabel("First Name");
        JLabel LnameLBL= new JLabel("Last Name");
        JLabel CityLBL= new JLabel("City");
        JLabel phoneLBL= new JLabel("phone");

        //TextFields For Panel 1
        subFname= new JTextField();  subFname.setOpaque(false);
        subLname =new JTextField();  subLname.setOpaque(false);
        subCity =new JTextField();   subCity.setOpaque(false);
        subPhone =new JTextField();  subPhone.setOpaque(false);

        p1.add(fnameLBL);
        p1.add(subFname);
        p1.add(LnameLBL);
        p1.add(subLname);
        p1.add(CityLBL);
        p1.add(subCity);
        p1.add(phoneLBL);
        p1.add(subPhone);
        p1.setBounds(15,15,300,200);//width 315
        p1.setLayout(new GridLayout(4,2));

        //Adding panels To JFRAME
        setLayout(null);
        add(p1);
    }

    private void CustomizePanel2(){
        JPanel p2= new JPanel();

        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Car Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);
        //Customize panel2
        p2.setBorder(titledBorder);
        p2.setBounds(15,250,300,540);// width 315
        p2.setLayout(new GridLayout(14,1));



        //Labels p2
        JLabel modelLBL= new JLabel("Model Year");
        JLabel plateNBLBL= new JLabel("Plate Number");
        JLabel manufacturerLBL= new JLabel("Manufacturer");
        JLabel estimatedLBL= new JLabel("Estimated Value");
        JLabel spaceLBL= new JLabel(" ");
        JLabel damageLBL= new JLabel("Major Damage");

        //JTextFields
        plateNb = new JTextField();       plateNb.setOpaque(true);
        model= new JTextField();          model.setOpaque(true);
        manufacturer= new JTextField();   manufacturer.setOpaque(true);
        estimated= new JTextField();      estimated.setOpaque(true);

        //RadioButtons
        damageradioButton1= new JRadioButton();
        damageradioButton1.setText("Motor");
        damageradioButton2= new JRadioButton();
        damageradioButton2.setText("Wheels");
        damageradioButton3= new JRadioButton();
        damageradioButton3.setText("Body");
        damageradioButton4= new JRadioButton();
        damageradioButton4.setText("None");




        //JTextFields
        plateNb = new JTextField();       plateNb = new JTextField();
        model= new JTextField();          model= new JTextField();
        manufacturer= new JTextField();   manufacturer= new JTextField();
        estimated= new JTextField();      estimated= new JTextField();

        //RadioButtons
        damageradioButton1= new JRadioButton();
        damageradioButton1.setText("Motor");
        damageradioButton2= new JRadioButton();
        damageradioButton2.setText("Wheels");
        damageradioButton3= new JRadioButton();
        damageradioButton3.setText("Body");
        damageradioButton4= new JRadioButton();
        damageradioButton4.setText("None");


        //Radio Button Group
        G1= new ButtonGroup();
        G1.add(damageradioButton1);
        G1.add(damageradioButton2);
        G1.add(damageradioButton3);
        G1.add(damageradioButton4);

        //Adding Components to Panel
        p2.add(plateNBLBL);
        p2.add(plateNb);
        p2.add(modelLBL);
        p2.add(model);
        p2.add(manufacturerLBL);
        p2.add(manufacturer);
        p2.add(estimatedLBL);
        p2.add(estimated);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageradioButton1);
        p2.add(damageradioButton2);
        p2.add(damageradioButton3);
        p2.add(damageradioButton4);


        add(p2);
    }

    private void CustomizePanel3(){
        JPanel p3 = new JPanel();

        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Plan  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);
        p3.setBorder(titledBorder);
        p3.setBounds(325,15,300,200);// width 315+10
        p3.setLayout(new GridLayout(6,11));

        JLabel packageLBL= new JLabel(" Please select your plan ");
        obligatoryChkBX = new JCheckBox("Obligatory");
        vehicleDamageChkBX = new JCheckBox("Vehicle Damage");
        driverDamageChkBX = new JCheckBox("Driver Damage");
        assistanceChkBX = new JCheckBox("Assistance");
        allRiskChkBX = new JCheckBox("All Risk");

        //Get all risks covered by plan
       GetRisksCoveredByPlan();

       //adding Components to Panel3
        p3.add(packageLBL);
        p3.add(obligatoryChkBX);
        p3.add(allRiskChkBX);
        p3.add(vehicleDamageChkBX);
        p3.add(driverDamageChkBX);
        p3.add(assistanceChkBX);
        add(p3);
    }

    private void CustomizePanel4() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Validity Period ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);
        JPanel p4 = new JPanel();
        p4.setBorder(titledBorder);
        p4.setBounds(325,250,300,250);//width 315+10
        p4.setLayout(new GridLayout(6,1));

        //Radio Buttons
        JLabel spacer2 = new JLabel(" ");
        spacer2.setOpaque(false);
        yearRadio= new JRadioButton();
        yearRadio.setText(" 1 Year ");
        yearRadio2= new JRadioButton();
        yearRadio2.setText(" 2 Years ");
        yearRadio3= new JRadioButton();

        yearRadio3.setText(" 3 Years ");
        yearRadio4= new JRadioButton(" 4 years");
        yearRadio4.setText(" 4 Years ");

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear=1;
            }
        });

        yearRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear=2;
            }
        });
        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear=3;
            }
        });
        yearRadio4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear=4;
            }
        });

        //Button Group
        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearRadio2);
        G2.add(yearRadio3);
        G2.add(yearRadio4);

        //Time & Date
        todayLBL = new JLabel();

       df = new SimpleDateFormat(" dd/MM/yyyy ");
        currentDate = new Date();
        todayLBL.setText("Today: " + df.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont(font.deriveFont(size));

        //Adding All Components to  Panel4
        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearRadio2);
        p4.add(yearRadio3);
        p4.add(yearRadio4);

        //adding panel4 to jframe
        add(p4);
    }

    private void CustomizePanel5(){
    TitledBorder titledBorder = BorderFactory.createTitledBorder
            (BorderFactory.createLineBorder(Color.GRAY,1),
                    "  Actions  ", TitledBorder.CENTER,
                    TitledBorder.DEFAULT_POSITION,myFont,myColor);

    JPanel p5= new JPanel();
    p5.setBounds(325,520,300,270);//width 315+10
    p5.setBorder(titledBorder);
    p5.setLayout(new GridLayout(7, 11));

    JButton saveBTN = new JButton("Save Customer");
    JButton showBTN = new JButton("Show Plan Details");
    JButton loadBTN = new JButton("Load Customer");
    JButton newBTN = new JButton("New Customer");

    searchTXT = new JTextField("Enter Car Plate NO");
    searchTXT.setOpaque(false);

    showBTN.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String str ="";
            for (int i = 0; i < coveredRisksList.size(); i++) {
                str+=coveredRisksList.get(i) +"\n";
            }
            risksTXT.setText(str);

            try{
                policyTXT.setText(GetPolicyData().toString());
                DisplayPaymentsOfPolicy();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }

    });

    saveBTN.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
    try {
    SaveCustomerMapToDisk();
    SaveCustomerMapTools();

} catch (IOException ex) {
    throw new RuntimeException(ex);
} catch (ParseException ex){
        throw new RuntimeException(ex);
    } catch (ClassNotFoundException ex) {
        throw new RuntimeException(ex);
    }
        }
    });
    JLabel spacer3 = new JLabel(" ");
    spacer3.setOpaque(false);

    loadBTN.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
    SearchCustomerByMobileNumber();
        }
    });

    JLabel spacer4 = new JLabel(" ");
    spacer4.setOpaque(false);

    JLabel spacer5 = new JLabel(" ");
    spacer4.setOpaque(false);

    JLabel spacer6 = new JLabel(" ");
    spacer4.setOpaque(false);

    newBTN.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        NewCustomer();
        }
    });

    p5.add(spacer6);
    p5.add(showBTN);
    p5.add(saveBTN);
    p5.add(newBTN);
    p5.add(spacer5);
    p5.add(searchTXT);
    p5.add(loadBTN);

    add(p5);


}

    private void CustomizePanel6(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Covered Risks  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);
        JPanel p6 = new JPanel();
        p6.setBorder(titledBorder);
        p6.setBounds(635,15,300,200);//625+10

       risksTXT = new JTextArea(7,1);
       risksTXT.setEditable(false);
       risksTXT.setOpaque(false);
       risksTXT.setLineWrap(true);

       //Font
        Font font = risksTXT.getFont();
        float size = font.getSize() + 3.0f;
        risksTXT.setFont(font.deriveFont(size));
        p6.add(risksTXT);
        p6.setLayout(new GridLayout(1,1));
        add(p6);

    }

    private void CustomizePanel7(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Policy Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);

        JPanel p7= new JPanel();
        p7.setBounds(635,250,300,250);//width 625+10
        p7.setBorder(titledBorder);
        p7.setLayout(new GridLayout(6,1));
        policyTXT= new JTextArea(20,1);
        policyTXT.setEditable(false);
        policyTXT.setOpaque(false);
        policyTXT.setLineWrap(true);

        //Font
        Font font = policyTXT.getFont();
        float size = font.getSize() + 3.0f;
        risksTXT.setFont(font.deriveFont(size));


        p7.add(policyTXT);
        p7.setLayout(new GridLayout(1,1));
        add(p7);

    }
    private void Customizepanel8(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Customer Details  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);
        JPanel p8 = new JPanel();
        p8.setBorder(titledBorder);
        p8.setBounds(635,520,300,270);//width 625+10
        p8.setLayout(new GridLayout(6,1));
        customerTXT = new JTextArea(20,1);
        customerTXT.setEditable(false);
        customerTXT.setOpaque(false);
        customerTXT.setLineWrap(true);
        //Font
        Font font = customerTXT.getFont();
        float size = font.getSize() + 3.0f;
        customerTXT.setFont(font.deriveFont(size));

        p8.add(customerTXT);
        p8.setLayout(new GridLayout(1,1));
        add(p8);

    }
    private void Customizepanel9(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Claims  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);

        JPanel p9 = new JPanel();
        p9.setBorder(titledBorder);
        p9.setBounds(945,15,300,485);//width 935+10


        claimingTXT1 = new JLabel("Enter Plate No. for Claiming");
        claimingTXT2 = new JLabel("Select the type of Damage");
        JLabel spacer99 = new JLabel("                                                                                    ");
        claimingCoustumerField= new JTextField();
        claimingCoustumerField.setPreferredSize(new Dimension(250,30));
        claimingCoustumerField.setOpaque(false);

        String[] items= {
                "Fire",
                "Robbery",
                "Third Party Damage",
                "Vehicle Damage",
                "Driver Damage",
                "Transport",
                "Car Replacement"
        };
        final JList claimList = new JList<>(items);
        claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        claimList.setOpaque(false);
        claimList.setPreferredSize(new Dimension(250,150));
        JButton searchClaimer= new JButton("  Search Customer  ");
        List<String> coveredRisksByUserLIST= new ArrayList<>();

        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
    cond1=false;    //Customer is registered in DB?
    cond2=false;    //Is customer policy cover the claimed risk
    cond3=false;    //Is the policy date is Valid
    try{
        coveredRisksByUserLIST.clear();
        Costumer costumer= ClaimsSearchCustomerByMobileNumber();
        claimingCostumerNameLBL.setText("Claiming Customer: "+ costumer.getFirstName()+ " " + costumer.getLastName());
        cond1 = true;

        String str7="";
        for (int i = 0; i < costumer.getPolicy().getRiskcoveredLIST().size(); i++) {
            str7+= costumer.getPolicy().getRiskcoveredLIST().get(i) + " \n";
            coveredRisksByUserLIST.add(costumer.getPolicy().getRiskcoveredLIST().get(i));
        }
        LocalDate validityOfPolicy= costumer.getPolicy().getPolicyDate();
        int validityOfPolicyYears=costumer.getPolicy().getValidityYear();
        validityOfPolicy = validityOfPolicy.plusYears(validityOfPolicyYears);
        CheckPolicyValidity(validityOfPolicy);
        claimingCostumerRisksCoveredAREA.setText("Covered Risks By Costumer plan:\n"+str7);
        claimingCostumerNameLBL.setText("Date validity of policy: "+validityOfPolicy+" || " + CheckPolicyValidity(validityOfPolicy));

        if(costumer.getPolicy().getRiskcoveredLIST().size()>=5){
            cond2=true;
        }
    } catch (Exception ex) {
        claimingCostumerNameLBL.setText("Claiming Costumer not found");
    }
            }
        });
        JButton confirmClaimBTN= new JButton("  Confirm Claim ");
        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //Get the index of all selected Items

                int[] selectedIdx=  claimList.getSelectedIndices();
                List<String> claimed_List= new ArrayList<>();

                if(claimList.getSelectedIndex()!=-1){
                    for (int i = 0; i < selectedIdx.length; i++) {
                        String k= "" +claimList.getModel().getElementAt(selectedIdx[i]);
                        claimed_List.add(""+claimList.getModel().getElementAt(selectedIdx[i]));
                        System.out.println(""+k);
                    }
                }
                //check for the included Risks
                if(cond2==false ){
                    cond2= claimed_List.containsAll(coveredRisksByUserLIST);

                }
                //Check for claim validity to add the claim to the costumer
                ClaimsIsValid();

                //Display settlements
                Costumer costumer = ClaimsSearchCustomerByMobileNumber();
                if(ClaimsIsValid()){
                    int claims_no = claimed_List.size();
                    if(claimed_List.contains("Fire")){
                        settelmentArea2.setText("Fire Department: " + costumer.getPolicy().getVehicle().getEstimateValue()*0.25+" Rs");
                    }else if(claimed_List.contains("Robbery")){
                        settelmentArea2.setText("ProSec Company: "+ (costumer.getPolicy().getVehicle().getEstimateValue()*0.5 +" Rs")+ "Pay for Customer: "
                          +"Pay for Customer: "      + costumer.getPolicy().getVehicle().getEstimateValue()*1 + " Rs");
                    } else if (claimed_List.contains("Third Party Damage")) {
                        settelmentArea2.setText("Driver in other car: "+2000 +"Rs");
                    } else if (claimed_List.contains("Vehicle Damage")){
                        settelmentArea2.setText("Pay for Costumer: "+ costumer.getPolicy().getVehicle().getEstimateValue()*1+" Rs");
                    } else if (claimed_List.contains("Driver Damage")) {
                        settelmentArea2.setText("Pay for Customer: "+costumer.getPolicy().getVehicle().getEstimateValue()*1+" Rs");
                    } else if (claimed_List.contains("Transport")) {
                        settelmentArea2.setText("Transport Company "+costumer.getPolicy().getVehicle().getEstimateValue()*0.2+" Rs");
                    } else if (claimed_List.contains("Car Replacement")){
                        settelmentArea2.setText("car Rental Company "+
                                costumer.getPolicy().getVehicle().getEstimateValue()*0.2+" Rs");
                    } else if (claims_no>2) {
                        settelmentArea2.setText("Driver "+costumer.getPolicy().getVehicle().getEstimateValue()*4+" Rs"+
                                "Hospital "+ costumer.getPolicy().getVehicle().getEstimateValue()*4+" Rs"+
                                "Car Rental Company "+costumer.getPolicy().getVehicle().getEstimateValue()*0.2+" Rs "+"Third Party Driver "+
                                costumer.getPolicy().getVehicle().getEstimateValue()*2
                        );
                    }else{

                    }
                }
            }
        });
        p9.add(claimingTXT1);
        p9.add(claimingCoustumerField);
        p9.add(searchClaimer);
        p9.add(spacer99);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmClaimBTN);
        add(p9);
    }
    private void  Customizepanel10(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Claim Status  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);
        JPanel p10 = new JPanel();
        p10.setBorder(titledBorder);
        p10.setBounds(945,520,300,270);
        p10.setLayout(new GridLayout(4,1));

        //JLabel
        claimingCostumerNameLBL= new JLabel("Costumer Name: ");
        claimingCostumerValidateDateLBL= new JLabel("Date Validity of Policy:");
        claimStatusLBL2= new JLabel("Claiming Status: ");

        //JTextArea

        claimingCostumerRisksCoveredAREA = new JTextArea();
        JScrollPane pictureScrollPane= new JScrollPane(claimingCostumerRisksCoveredAREA);
        claimingCostumerRisksCoveredAREA.setOpaque(false);


        p10.add(claimingCostumerNameLBL);
        p10.add(claimingCostumerValidateDateLBL);
        p10.add(pictureScrollPane);
        p10.add(claimStatusLBL2);
        add(p10);
    }

    private void  Customizepanel11(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Payments  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);

        JPanel p11 = new JPanel();
        p11.setBorder(titledBorder);
        p11.setBounds(1255,15,300,270);
        p11.setLayout(new GridLayout(2,1));

        //JTextArea
        settelmentArea= new JTextArea();
        settelmentArea.setOpaque(false);

        //Increasing JTextArea size
        Font font = settelmentArea.getFont();
        float size = font.getSize() + 4.0f;
        settelmentArea.setFont(font.deriveFont(size));
        p11.add(settelmentArea);
        add(p11);

    }

    private void  Customizepanel12(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY,1),
                        "  Settlements  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,myFont,myColor);

        JPanel p12 = new JPanel();
        p12.setBorder(titledBorder);
        p12.setBounds(1255,285,300,505);
        p12.setLayout(new GridLayout());
        settelmentArea2= new JTextArea();
        settelmentArea2.setOpaque(false);


        Font font = settelmentArea2.getFont();
        float size = font.getSize() + 4.0f;
        settelmentArea2.setFont(font.deriveFont(size));
        p12.add(settelmentArea2);
        add(p12);

    }






    //Constructor
    public MainScreen(){
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        Customizepanel8();
        Customizepanel9();
        Customizepanel10();
        Customizepanel11();
        Customizepanel12();

    }




    //Main function
    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Car Insurance System");
        mainScreen.setBounds(0,0,1920,1080);

    }

}


