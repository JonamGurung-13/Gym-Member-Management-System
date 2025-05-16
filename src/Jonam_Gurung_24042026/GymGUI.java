package Jonam_Gurung_24042026;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GymGUI {
    //Declaring Variables
    JFrame mainFrame, regularFrame,premiumFrame,newFrame;
    JButton regularBtn,premiumBtn,newBtn,addBtn,clearBtn,calculateDiscountBtn;
    JLabel titleNewMember,memberLbl,idLbl,nameLbl,phoneLbl,locationLbl,emailLbl,genderLbl,dobLbl,msdLbl,referralLbl,paidAmountLbl,planLbl,priceLbl,trainerLbl,discountLbl;
    JComboBox memberCb,dobYearCb,dobMonthCb,dobDayCb,msdYearCb,msdMonthCb,msdDayCb,planCb,trainerCb;
    JRadioButton maleRbtn,femaleRbtn;
    JTextField idTf,nameTf,locationTf,phoneTf,emailTf,referralTf,paidAmountTf,priceTf,discountTf;

    //Regular Member Instance Variables
    JLabel titleRegular,idRegularLbl,nameRegularLbl,locationRegularLbl,phoneRegularLbl,emailRegularLbl,msdRegularLbl,planRegularLbl,priceRegularLbl,paidAmountRegularLbl,attendanceRegularLbl,loyaltyRegularLbl,activeRegularLbl,removalReasonRegularLbl;
    JTextField idRegularTf, nameRegularTf,locationRegularTf,phoneRegularTf,emailRegularTf,msdRegularTf,priceRegularTf,paidAmountRegularTf,activeRegularTf,attendanceRegularTf,loyaltyRegularTf;
    JButton activeMemberRegularBtn,deactiveMemberRegularBtn,markAttendanceRegularBtn,upgradeRegularBtn,revertRegularBtn,displayRegularBtn,clearRegularBtn,saveRegularBtn,readRegularBtn;
    JTextArea removalReasonRegularTa;
    JComboBox planRegularCb;

    //Premium Member Instance Variables
    JLabel titlePremium,idPremiumLbl,namePremiumLbl,locationPremiumLbl,phonePremiumLbl,emailPremiumLbl,msdPremiumLbl,planPremiumLbl,pricePremiumLbl,paidAmountPremiumLbl,dueAmountPremiumLbl,attendancePremiumLbl,loyaltyPremiumLbl,activePremiumLbl;
    JTextField idPremiumTf, namePremiumTf,locationPremiumTf,phonePremiumTf,emailPremiumTf,msdPremiumTf,planPremiumTf,pricePremiumTf,paidAmountPremiumTf,dueAmountPremiumTf,attendancePremiumTf,loyaltyPremiumTf,activePremiumTf;
    JButton activeMemberPremiumBtn,deactiveMemberPremiumBtn,markAttendancePremiumBtn,revertPremiumBtn,payDuePremiumBtn,displayPremiumBtn,clearPremiumBtn,savePremiumBtn,readPremiumBtn;

    public GymGUI() {
        mainFrame = new JFrame("Main Menu");//This is the main frame where all the options to access the service is displayed
        mainFrame.setSize(400, 300);//Setting size of main frame
        mainFrame.setResizable(false);//Making the size of the main frame fixed
        mainFrame.setLocationRelativeTo(null);//Setting the location of the main frame in the center

        //Creating arraylist for regular and premium members
        ArrayList<GymMember>gymMembers = new ArrayList<GymMember>();
        //Store regular and premium members from the file
        try {
            //This is to store regular member from file
            //Regular Member
            File fileRegular = new File("RegularMembers.txt");
            if(fileRegular.exists()){
                Scanner scanRegular = new Scanner(fileRegular);
                boolean ignoreFirstLine = true;
                while(scanRegular.hasNextLine()){
                    if(ignoreFirstLine){
                        scanRegular.nextLine();
                        ignoreFirstLine = false;
                        continue;
                    }
                    String line = scanRegular.nextLine();
                    String idStr = line.substring(0,6).replace("R","");
                    int idRegular = Integer.parseInt(idStr.strip());
                    String nameRegular = line.substring(6,37).strip();
                    String locationRegular = line.substring(37,63).strip();
                    String phoneRegular = line.substring(63,79).strip();
                    String emailRegular = line.substring(79,120).strip();
                    String genderRegular = line.substring(120,131).strip();
                    String dobRegular = line.substring(131,152).strip();
                    String msdRegular = line.substring(152,178).strip();
                    String referralRegular = line.substring(178,204).strip();
                    RegularMember rm = new RegularMember(idRegular,nameRegular,locationRegular,phoneRegular,emailRegular,genderRegular,dobRegular,msdRegular,referralRegular);
                    String planRegular = line.substring(204,215).strip();
                    boolean activeStatusRegular = Boolean.parseBoolean(line.substring(231,247).strip());
                    int attendanceRegular = Integer.parseInt(line.substring(247,263).strip());
                    double loyaltyPointsRegular = Double.parseDouble(line.substring(263,line.length()-1).strip());
                    rm.setPlan(planRegular);
                    rm.setActiveStatus(activeStatusRegular);
                    rm.setAttendance(attendanceRegular);
                    rm.setLoyaltyPoints(loyaltyPointsRegular);
                    gymMembers.add(rm);
                }
                scanRegular.close();
            }

            //Premium Member
            File filePremium = new File("PremiumMembers.txt");
            if(filePremium.exists()){
                Scanner scanPremium = new Scanner(filePremium);
                boolean ignoreFirstLine = true;
                while(scanPremium.hasNextLine()){
                    if(ignoreFirstLine){
                        scanPremium.nextLine();
                        ignoreFirstLine = false;
                        continue;
                    }
                    String line = scanPremium.nextLine();
                    String idStr = line.substring(0,6).replace("P","");
                    int idPremium = Integer.parseInt(idStr.strip());
                    String namePremium = line.substring(6,37).strip();
                    String locationPremium = line.substring(37,63).strip();
                    String phonePremium = line.substring(63,79).strip();
                    String emailPremium = line.substring(79,120).strip();
                    String genderPremium = line.substring(120,131).strip();
                    String dobPremium = line.substring(131,152).strip();
                    String msdPremium = line.substring(152,178).strip();
                    String trainerPremium = line.substring(178,204).strip();
                    PremiumMember pm = new PremiumMember(idPremium,namePremium,locationPremium,phonePremium,emailPremium,genderPremium,dobPremium,msdPremium,trainerPremium);
                    pm.setPaidAmount(Double.parseDouble(line.substring(220,236).strip()));
                    pm.setDiscountAmount(Double.parseDouble(line.substring(236,252).strip()));
                    pm.setDueAmount(Double.parseDouble(line.substring(252,273).strip()));
                    pm.setActiveStatus(Boolean.parseBoolean(line.substring(273,289)));
                    pm.setAttendance(Integer.parseInt(line.substring(289,305).strip()));
                    pm.setLoyaltyPoints(Double.parseDouble(line.substring(305,line.length()-1)));
                    gymMembers.add(pm);
                }
                scanPremium.close();
            }
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(newFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException io){
            JOptionPane.showMessageDialog(newFrame,"File Not Found","Error",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(newFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }


        //New Member Frame
        {
            newFrame = new JFrame("New Member");//This frame is to add new members in the gym
            newFrame.setSize(800, 500);//Setting size of newFrame
            newFrame.setLocationRelativeTo(null);//Setting Location to center of the screen
            newFrame.setLayout(new GridBagLayout());//Setting Layout for newFrame
            GridBagConstraints gbcNew = new GridBagConstraints();

            //Creating Objects
            titleNewMember = new JLabel("New Member");
            titleNewMember.setFont(new Font("Arial", Font.BOLD, 24));
            memberLbl = new JLabel("Member:");
            idLbl = new JLabel("ID:");
            nameLbl = new JLabel("Name:");
            locationLbl = new JLabel("Location:");
            phoneLbl = new JLabel("Phone:");
            emailLbl = new JLabel("Email:");
            genderLbl = new JLabel("Gender:");
            dobLbl = new JLabel("DOB:");
            msdLbl = new JLabel("Membership Start Date:");
            referralLbl = new JLabel("Referral Source:");
            paidAmountLbl = new JLabel("Paid Amount:");
            planLbl = new JLabel("Plan:");
            priceLbl = new JLabel("Price:");
            trainerLbl = new JLabel("Trainer:");
            discountLbl = new JLabel("Discount:");

            idTf = new JTextField(15);
            idTf.setEditable(false);
            nameTf = new JTextField(15);
            locationTf = new JTextField(15);
            phoneTf = new JTextField(15);
            emailTf = new JTextField(15);
            referralTf = new JTextField(15);
            paidAmountTf = new JTextField(15);
            priceTf = new JTextField(15);
            priceTf.setEditable(false);
            priceTf.setText("6500");
            discountTf = new JTextField("0",15);
            discountTf.setEditable(false);

            maleRbtn = new JRadioButton("Male");
            femaleRbtn = new JRadioButton("Female");
            ButtonGroup btnGrp = new ButtonGroup();
            btnGrp.add(maleRbtn);
            btnGrp.add(femaleRbtn);

            memberCb = new JComboBox<>(new String[]{"Regular Member", "Premium Member"});
            dobYearCb = new JComboBox<>(new String[]{"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"});
            dobMonthCb = new JComboBox<>(new String[]{"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
            dobDayCb = new JComboBox<>(new String[]{"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});

            msdYearCb = new JComboBox<>(new String[]{"Year", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"});
            msdMonthCb = new JComboBox<>(new String[]{"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
            msdDayCb = new JComboBox<>(new String[]{"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});
            planCb = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
            trainerCb = new JComboBox<>(new String[]{"Select Trainer","Lelin Gurung","Nishan B.K","Rajan Bhujel","Thaman Sing Thapa","Rohit Gurung","Nabraj Gurung"});

            addBtn = new JButton("Add Regular Member");
            clearBtn = new JButton("Clear");
            calculateDiscountBtn = new JButton("Calculate Discount");
            JPanel buttons = new JPanel();
            buttons.add(addBtn);
            buttons.add(clearBtn);


            gbcNew.gridx = 0;
            gbcNew.gridy = 0;
            gbcNew.gridwidth = 4;
            gbcNew.insets = new Insets(5, 5, 40, 5);
            newFrame.add(titleNewMember, gbcNew);
            gbcNew.insets = new Insets(5, 0, 5, 10);
            gbcNew.gridwidth = 1;
            gbcNew.gridy = 1;
            newFrame.add(memberLbl, gbcNew);

            gbcNew.gridy = 2;
            newFrame.add(nameLbl, gbcNew);

            gbcNew.gridy = 3;
            newFrame.add(phoneLbl, gbcNew);

            gbcNew.insets = new Insets(5, 0, 5, 80);
            gbcNew.gridx = 1;
            newFrame.add(phoneTf, gbcNew);

            gbcNew.gridy = 2;
            newFrame.add(nameTf, gbcNew);

            gbcNew.gridy = 1;
            newFrame.add(memberCb, gbcNew);

            gbcNew.insets = new Insets(5, 0, 5, 10);
            gbcNew.gridx = 2;
            newFrame.add(idLbl, gbcNew);

            gbcNew.gridy = 2;
            newFrame.add(locationLbl, gbcNew);

            gbcNew.gridy = 3;
            newFrame.add(emailLbl, gbcNew);

            gbcNew.gridx = 3;
            newFrame.add(emailTf, gbcNew);

            gbcNew.gridy = 2;
            newFrame.add(locationTf, gbcNew);

            gbcNew.gridy = 1;
            newFrame.add(idTf, gbcNew);

            gbcNew.gridx = 0;
            gbcNew.gridy = 4;
            newFrame.add(genderLbl, gbcNew);

            gbcNew.insets = new Insets(5, 0, 5, 100);
            gbcNew.gridx = 1;
            JPanel genderPanel = new JPanel();
            genderPanel.add(maleRbtn);
            genderPanel.add(femaleRbtn);
            newFrame.add(genderPanel, gbcNew);

            gbcNew.insets = new Insets(5, 0, 5, 10);
            gbcNew.gridx = 0;
            gbcNew.gridy = 5;
            newFrame.add(dobLbl, gbcNew);


            JPanel dobPanel = new JPanel();
            dobPanel.add(dobYearCb);
            dobPanel.add(dobMonthCb);
            dobPanel.add(dobDayCb);

            gbcNew.gridx = 1;
            newFrame.add(dobPanel, gbcNew);

            JPanel msdPanel = new JPanel();
            msdPanel.add(msdYearCb);
            msdPanel.add(msdMonthCb);
            msdPanel.add(msdDayCb);
            gbcNew.gridy = 6;
            newFrame.add(msdPanel, gbcNew);

            gbcNew.gridx = 0;
            newFrame.add(msdLbl, gbcNew);

            gbcNew.gridy = 7;
            newFrame.add(planLbl, gbcNew);

            gbcNew.gridy = 8;
            newFrame.add(referralLbl, gbcNew);

            gbcNew.insets = new Insets(5, 0, 5, 80);
            gbcNew.gridx = 1;
            newFrame.add(referralTf,gbcNew);

            gbcNew.gridy = 7;
            newFrame.add(planCb, gbcNew);

            gbcNew.insets = new Insets(5, 0, 5, 10);
            gbcNew.gridx = 2;
            newFrame.add(priceLbl, gbcNew);

            gbcNew.gridy = 8;
            newFrame.add(paidAmountLbl, gbcNew);

            gbcNew.gridx = 3;
            newFrame.add(paidAmountTf, gbcNew);

            gbcNew.gridy = 7;
            newFrame.add(priceTf, gbcNew);

            gbcNew.insets = new Insets(15, 0, 0, 0);
            gbcNew.gridwidth = 3;
            gbcNew.gridy = 10;
            gbcNew.gridx = 1;
            gbcNew.ipady = 10;
            gbcNew.ipadx = 10;
            newFrame.add(buttons, gbcNew);

            //Setting action for plan combo box
            planCb.addActionListener(e -> {
                if (planCb.getSelectedIndex() == 0) {
                    priceTf.setText("6500");
                }
                else if (planCb.getSelectedIndex() == 1) {
                    priceTf.setText("12500");
                }
                else {
                    priceTf.setText("18500");
                }
            });

            //Choosing members
            memberCb.addActionListener(e -> {
                if (memberCb.getSelectedIndex() == 1) {
                    newFrame.remove(referralLbl);
                    newFrame.remove(referralTf);
                    newFrame.remove(planLbl);
                    newFrame.remove(planCb);

                    gbcNew.insets = new Insets(5, 0, 5, 10);
                    gbcNew.gridwidth = 1;
                    gbcNew.ipady = 0;
                    gbcNew.ipadx = 0;
                    gbcNew.gridx = 0;
                    gbcNew.gridy = 7;
                    newFrame.add(trainerLbl, gbcNew);
                    gbcNew.insets = new Insets(5, 0, 5, 80);
                    gbcNew.gridx = 1;
                    newFrame.add(trainerCb, gbcNew);
                    gbcNew.gridy = 8;
                    newFrame.add(discountTf,gbcNew);
                    gbcNew.gridx = 0;
                    gbcNew.insets = new Insets(5, 0, 5, 10);
                    newFrame.add(discountLbl,gbcNew);
                    priceTf.setText("50000");
                    addBtn.setText("Add Premium Member");
                    discountTf.setText("0");
                    buttons.add(calculateDiscountBtn);

                    idTf.setText("");
                    nameTf.setText("");
                    locationTf.setText("");
                    phoneTf.setText("");
                    emailTf.setText("");
                    btnGrp.clearSelection();
                    dobYearCb.setSelectedIndex(0);
                    dobMonthCb.setSelectedIndex(0);
                    dobDayCb.setSelectedIndex(0);
                    msdYearCb.setSelectedIndex(0);
                    msdMonthCb.setSelectedIndex(0);
                    msdDayCb.setSelectedIndex(0);
                    trainerCb.setSelectedIndex(0);
                    paidAmountTf.setText("");

                    newFrame.revalidate();
                    newFrame.repaint();
                }
                else {
                    newFrame.remove(trainerLbl);
                    newFrame.remove(trainerCb);
                    newFrame.remove(discountLbl);
                    newFrame.remove(discountTf);
                    buttons.remove(calculateDiscountBtn);

                    gbcNew.insets = new Insets(5, 0, 5, 10);
                    gbcNew.gridwidth = 1;
                    gbcNew.ipady = 0;
                    gbcNew.ipadx = 0;
                    gbcNew.gridx = 0;
                    gbcNew.gridy = 7;
                    newFrame.add(planLbl, gbcNew);
                    gbcNew.gridy = 8;
                    newFrame.add(referralLbl, gbcNew);
                    gbcNew.gridy = 9;
                    gbcNew.insets = new Insets(5, 0, 5, 80);
                    gbcNew.gridx = 1;
                    planCb.setSelectedIndex(0);
                    gbcNew.gridy = 8;
                    newFrame.add(referralTf, gbcNew);
                    gbcNew.gridy = 7;
                    newFrame.add(planCb, gbcNew);
                    addBtn.setText("Add Regular Member");

                    idTf.setText("");
                    nameTf.setText("");
                    locationTf.setText("");
                    phoneTf.setText("");
                    emailTf.setText("");
                    btnGrp.clearSelection();
                    dobYearCb.setSelectedIndex(0);
                    dobMonthCb.setSelectedIndex(0);
                    dobDayCb.setSelectedIndex(0);
                    msdYearCb.setSelectedIndex(0);
                    msdMonthCb.setSelectedIndex(0);
                    msdDayCb.setSelectedIndex(0);
                    planCb.setSelectedIndex(0);
                    referralTf.setText("");
                    paidAmountTf.setText("");

                    newFrame.revalidate();
                    newFrame.repaint();
                }
            });

            //Discount Calculation for premium member
            calculateDiscountBtn.addActionListener(e->{
                try {
                    if (memberCb.getSelectedIndex() == 1) {
                        if (Double.parseDouble(paidAmountTf.getText()) >= 50000) {
                            PremiumMember discountCalculation = new PremiumMember();
                            discountCalculation.setFullPayment(true);
                            discountCalculation.calculateDiscount();
                            discountTf.setText(String.valueOf(discountCalculation.getDiscountAmount()));
                        } else {
                            discountTf.setText("0.0");
                            JOptionPane.showMessageDialog(newFrame, "You have to pay full amount to get discount", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(newFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(newFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Clear Btn Action
            clearBtn.addActionListener(e->{
                idTf.setText("");
                nameTf.setText("");
                locationTf.setText("");
                phoneTf.setText("");
                emailTf.setText("");
                btnGrp.clearSelection();
                dobYearCb.setSelectedIndex(0);
                dobMonthCb.setSelectedIndex(0);
                dobDayCb.setSelectedIndex(0);
                msdYearCb.setSelectedIndex(0);
                msdMonthCb.setSelectedIndex(0);
                msdDayCb.setSelectedIndex(0);
                planCb.setSelectedIndex(0);
                referralTf.setText("");
                trainerCb.setSelectedIndex(0);
                paidAmountTf.setText("");
                if(memberCb.getSelectedIndex()==1){
                    priceTf.setText("50000");
                }


            });

            //Storing the information in arrayList
            addBtn.addActionListener(e->{
                if(memberCb.getSelectedIndex()==0){
                    if(nameTf.getText().isEmpty() || locationTf.getText().isEmpty() || phoneTf.getText().isEmpty() || emailTf.getText().isEmpty() ||
                            (!maleRbtn.isSelected() && !femaleRbtn.isSelected()) || dobYearCb.getSelectedIndex()==0 || dobMonthCb.getSelectedIndex()==0 || dobDayCb.getSelectedIndex()==0 ||
                            msdYearCb.getSelectedIndex()==0 || msdMonthCb.getSelectedIndex()==0 || msdDayCb.getSelectedIndex()==0 || referralTf.getText().isEmpty() || paidAmountTf.getText().isEmpty()){
                        JOptionPane.showMessageDialog(newFrame,"Please Fill or Choose All The Options","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try {
                            File file = new File("RegularMembers.txt");
                            int id;
                            ArrayList<Integer>ids = new ArrayList<>();
                            if(file.exists()) {
                                Scanner scan = new Scanner(file);
                                boolean ignoreFirstLine = true;
                                while (scan.hasNextLine()) {
                                    if (ignoreFirstLine) {
                                        ignoreFirstLine = false;
                                        scan.nextLine();
                                        continue;
                                    }
                                    String line = scan.nextLine();
                                    String idStr = line.substring(0, 6).replace("R", "");
                                    ids.add(Integer.parseInt(idStr.strip()));
                                }
                                scan.close();
                            }
                            if(ids.isEmpty()){
                                id = 1;
                            }
                            else{
                                id = ids.getLast()+1;
                            }

                            //Check phone number
                            boolean isNumber = false;
                            if(phoneTf.getText().length()==10) {
                                for (char pNumber : phoneTf.getText().toCharArray()) {
                                    if (Character.isDigit(pNumber)) {
                                        isNumber = true;
                                    } else {
                                        isNumber = false;
                                    }
                                }
                            }

                            if(Double.parseDouble(priceTf.getText())<=Double.parseDouble(paidAmountTf.getText()) && isNumber){
                                String name = nameTf.getText();
                                String location = locationTf.getText();
                                String phone = phoneTf.getText();
                                String email = emailTf.getText();
                                String gender = maleRbtn.isSelected() ? "Male" : "Female";
                                String dob = dobYearCb.getSelectedItem() + "-" + dobMonthCb.getSelectedIndex() + "-" + dobDayCb.getSelectedItem();
                                String memberShipStartDate = msdYearCb.getSelectedItem() + "-" + msdMonthCb.getSelectedIndex() + "-" + msdDayCb.getSelectedItem();
                                String referral = referralTf.getText();
                                RegularMember rm = new RegularMember(id, name, location, phone, email, gender, dob, memberShipStartDate, referral);
                                rm.setPlan(planCb.getSelectedItem().toString());
                                idTf.setText("R" + id);
                                gymMembers.add(rm);
                                boolean newFile = file.createNewFile();
                                FileWriter writer = new FileWriter(file, true);
                                if (newFile) {
                                    writer.write(String.format("%-5s %-30s %-25s %-15s %-40s %-10s %-20s %-25s %-25s %-10s %-15s %-15s %-15s %-15s","ID","Name","Location","Phone","Email","Gender","Date of Birth","MemberShip Start Date","Referral Source","Plan","Price","Active Status","Attendance","Loyalty Points") + "\n");
                                }
                                writer.write(String.format("%-5s %-30s %-25s %-15s %-40s %-10s %-20s %-25s %-25s %-10s %-15s %-15s %-15s %-15s",idTf.getText(),name,location,phone,email,gender,dob,memberShipStartDate,referral,rm.getPlan(),rm.getPlanPrice(rm.getPlan()),rm.getActiveStatus(),rm.getAttendance(),rm.getLoyaltyPoints()) + "\n");
                                writer.close();
                                double change = Double.parseDouble(paidAmountTf.getText()) - Double.parseDouble(priceTf.getText());
                                if(change == 0.00) {
                                    JOptionPane.showMessageDialog(newFrame, "Member details has been successfully added to the Gym.","Info",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(newFrame, "Member details has been successfully added to the Gym and Here is your change: "+change,"Info",JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            else{
                                if(!isNumber){
                                    JOptionPane.showMessageDialog(newFrame,"Please enter proper number","Error",JOptionPane.ERROR_MESSAGE);
                                }
                                else {
                                    JOptionPane.showMessageDialog(newFrame, "Please Pay The Full Amount", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(newFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        catch(IOException io){
                            JOptionPane.showMessageDialog(newFrame,"File Not Found","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(newFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }

                else{
                    if(nameTf.getText().isEmpty() || locationTf.getText().isEmpty() || phoneTf.getText().isEmpty() || emailTf.getText().isEmpty() ||
                            (!maleRbtn.isSelected() && !femaleRbtn.isSelected()) || dobYearCb.getSelectedIndex()==0 || dobMonthCb.getSelectedIndex()==0 || dobDayCb.getSelectedIndex()==0 ||
                            msdYearCb.getSelectedIndex()==0 || msdMonthCb.getSelectedIndex()==0 || msdDayCb.getSelectedIndex()==0 || trainerCb.getSelectedIndex()==0 || paidAmountTf.getText().isEmpty()){
                        JOptionPane.showMessageDialog(newFrame,"Please Fill or Choose All The Options","Error",JOptionPane.ERROR_MESSAGE);
                    }

                    else{
                        try {
                            File file = new File("PremiumMembers.txt");
                            boolean newFile = file.createNewFile();
                            int id;
                            ArrayList<Integer> ids = new ArrayList<>();
                            Scanner scan = new Scanner(file);
                            boolean ignoreFirstLine = true;
                            while (scan.hasNextLine()) {
                                if (ignoreFirstLine) {
                                    ignoreFirstLine = false;
                                    scan.nextLine();
                                    continue;
                                }
                                String line = scan.nextLine();
                                String idStr = line.substring(0, 6).replace("P", "");
                                ids.add(Integer.parseInt(idStr.strip()));
                            }
                            scan.close();
                            if (ids.isEmpty()) {
                                id = 1;
                            } else {
                                id = ids.getLast() + 1;
                            }

                            //Check phone number
                            boolean isNumber = false;
                            if(phoneTf.getText().length()==10) {
                                for (char pNumber : phoneTf.getText().toCharArray()) {
                                    if (Character.isDigit(pNumber)) {
                                        isNumber = true;
                                    } else {
                                        isNumber = false;
                                    }
                                }
                            }
                            if (isNumber) {
                                String name = nameTf.getText();
                                String location = locationTf.getText();
                                String phone = phoneTf.getText();
                                String email = emailTf.getText();
                                String gender = maleRbtn.isSelected() ? "Male" : "Female";
                                String dob = dobYearCb.getSelectedItem() + "-" + dobMonthCb.getSelectedIndex() + "-" + dobDayCb.getSelectedItem();
                                String memberShipStartDate = msdYearCb.getSelectedItem() + "-" + msdMonthCb.getSelectedIndex() + "-" + msdDayCb.getSelectedItem();
                                String trainer = trainerCb.getSelectedItem().toString();
                                PremiumMember pm = new PremiumMember(id, name, location, phone, email, gender, dob, memberShipStartDate, trainer);
                                double paidAmount = Double.parseDouble(paidAmountTf.getText());
                                double dueAmount = 0.00;
                                double change = 0.00;
                                if (Double.parseDouble(priceTf.getText()) > paidAmount) {
                                    dueAmount = Double.parseDouble(priceTf.getText()) - paidAmount;
                                    pm.setDiscountAmount(0.00);
                                } else {
                                    pm.setFullPayment(true);
                                    pm.calculateDiscount();
                                    change = paidAmount - Double.parseDouble(priceTf.getText()) + pm.getDiscountAmount();
                                }
                                pm.setPaidAmount(paidAmount - pm.getDiscountAmount());
                                pm.setDueAmount(dueAmount);
                                gymMembers.add(pm);
                                idTf.setText("P" + id);
                                FileWriter writer = new FileWriter(file, true);

                                if (newFile) {
                                    writer.write(String.format("%-5s %-30s %-25s %-15s %-40s %-10s %-20s %-25s %-25s %-15s %-15s %-20s %-15s %-15s %-15s %-15s", "ID", "Name", "Location", "Phone", "Email", "Gender", "Date of Birth", "MemberShip Start Date", "Trainer", "Price", "Paid Amount","Discount Amount", "Due Amount", "Active Status", "Attendance", "Loyalty Points") + "\n");
                                }
                                writer.write(String.format("%-5s %-30s %-25s %-15s %-40s %-10s %-20s %-25s %-25s %-15s %-15s %-20s %-15s %-15s %-15s %-15s", idTf.getText(), name, location, phone, email, gender, dob, memberShipStartDate, trainer, pm.getPremiumCharge(), pm.getPaidAmount(),pm.getDiscountAmount(), dueAmount, pm.getActiveStatus(), pm.getAttendance(), pm.getLoyaltyPoints()) + "\n");
                                writer.close();
                                if(change !=0) {
                                    JOptionPane.showMessageDialog(newFrame, "Member details has been successfully added to the Gym \nYou got 10% discount for full payment, here is your change:"+change, "Info", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(newFrame, "Member details has been successfully added to the Gym and Now you have: " +dueAmount + " due amount.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(newFrame,"Please enter proper number","Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch(NumberFormatException num){
                            JOptionPane.showMessageDialog(newFrame,"Please enter proper value","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        catch(IOException io){
                            JOptionPane.showMessageDialog(newFrame,"File Not Found","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(newFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }


        //Regular Frame
        {
            regularFrame = new JFrame("Regular Member");//This frame is for regular member
            regularFrame.setSize(800, 500);//Setting size of regularFrame
            regularFrame.setLocationRelativeTo(null);//Setting Location to center of the screen
            regularFrame.setLayout(new GridBagLayout());//Setting Layout for regularFrame
            GridBagConstraints gbcRegular = new GridBagConstraints();

            //Creating objects
            titleRegular = new JLabel("Regular Member");
            titleRegular.setFont(new Font("Arial", Font.BOLD, 24));
            idRegularLbl = new JLabel("ID:");
            nameRegularLbl = new JLabel("Name:");
            locationRegularLbl = new JLabel("Location:");
            phoneRegularLbl = new JLabel("Phone:");
            emailRegularLbl = new JLabel("Email:");
            msdRegularLbl = new JLabel("Membership Start Date:");
            planRegularLbl = new JLabel("Plan:");
            priceRegularLbl = new JLabel("Price:");
            paidAmountRegularLbl = new JLabel("Paid Amount:");
            attendanceRegularLbl = new JLabel("Attendance:");
            loyaltyRegularLbl = new JLabel("loyalty Points:");
            activeRegularLbl = new JLabel("Active Status:");
            removalReasonRegularLbl = new JLabel("Removal Reason:");

            removalReasonRegularTa = new JTextArea(4,15);
            removalReasonRegularTa.setLineWrap(true);
            removalReasonRegularTa.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(removalReasonRegularTa,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            idRegularTf = new JTextField(15);
            nameRegularTf = new JTextField(15);
            nameRegularTf.setEditable(false);
            locationRegularTf = new JTextField(15);
            locationRegularTf.setEditable(false);
            phoneRegularTf = new JTextField(15);
            phoneRegularTf.setEditable(false);
            emailRegularTf = new JTextField(15);
            emailRegularTf.setEditable(false);
            msdRegularTf = new JTextField(15);
            msdRegularTf.setEditable(false);
            priceRegularTf = new JTextField(15);
            priceRegularTf.setEditable(false);
            paidAmountRegularTf = new JTextField(15);
            paidAmountRegularTf.setEditable(false);
            attendanceRegularTf = new JTextField(15);
            attendanceRegularTf.setEditable(false);
            loyaltyRegularTf = new JTextField(15);
            loyaltyRegularTf.setEditable(false);
            activeRegularTf = new JTextField(15);
            activeRegularTf.setEditable(false);

            planRegularCb = new JComboBox<>(new String[]{"Basic","Standard","Deluxe"});
            planRegularCb.setEnabled(false);

            activeMemberRegularBtn = new JButton("Active Membership");
            deactiveMemberRegularBtn = new JButton("Deactive Membership");
            markAttendanceRegularBtn = new JButton("Mark Attendance");
            upgradeRegularBtn = new JButton("Upgrade Plan");
            revertRegularBtn = new JButton("Revert");
            displayRegularBtn = new JButton("Display");
            clearRegularBtn = new JButton("Clear");
            saveRegularBtn = new JButton("Save to File");
            readRegularBtn = new JButton("Read from File");

            JPanel regularBtnPanel1 = new JPanel();
            JPanel regularBtnPanel2 = new JPanel();
            regularBtnPanel1.add(activeMemberRegularBtn);
            regularBtnPanel1.add(deactiveMemberRegularBtn);
            regularBtnPanel1.add(markAttendanceRegularBtn);
            regularBtnPanel1.add(upgradeRegularBtn);
            regularBtnPanel2.add(revertRegularBtn);
            regularBtnPanel2.add(displayRegularBtn);
            regularBtnPanel2.add(clearRegularBtn);
            regularBtnPanel2.add(saveRegularBtn);
            regularBtnPanel2.add(readRegularBtn);

            gbcRegular.gridx = 0;
            gbcRegular.gridy = 0;
            gbcRegular.gridwidth = 4;
            gbcRegular.insets = new Insets(5, 5, 30, 5);
            regularFrame.add(titleRegular, gbcRegular);
            gbcRegular.gridwidth = 1;
            gbcRegular.gridy = 1;
            gbcRegular.insets = new Insets(5,0,5,10);
            regularFrame.add(idRegularLbl,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,80);
            gbcRegular.gridx = 1;
            regularFrame.add(idRegularTf,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,10);
            gbcRegular.gridx = 2;
            regularFrame.add(nameRegularLbl,gbcRegular);

            gbcRegular.gridx = 3;
            regularFrame.add(nameRegularTf,gbcRegular);

            gbcRegular.gridy = 2;
            regularFrame.add(phoneRegularTf,gbcRegular);

            gbcRegular.gridx = 2;
            regularFrame.add(phoneRegularLbl,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,80);
            gbcRegular.gridx = 1;
            regularFrame.add(locationRegularTf,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,10);
            gbcRegular.gridx = 0;
            regularFrame.add(locationRegularLbl,gbcRegular);

            gbcRegular.gridy = 3;
            regularFrame.add(emailRegularLbl,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,80);
            gbcRegular.gridx = 1;
            regularFrame.add(emailRegularTf,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,10);
            gbcRegular.gridx = 2;
            regularFrame.add(msdRegularLbl,gbcRegular);

            gbcRegular.gridx = 3;
            regularFrame.add(msdRegularTf,gbcRegular);

            gbcRegular.gridy = 4;
            regularFrame.add(priceRegularTf,gbcRegular);

            gbcRegular.gridx = 2;
            regularFrame.add(priceRegularLbl,gbcRegular);

            gbcRegular.gridx = 0;
            regularFrame.add(planRegularLbl,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,80);
            gbcRegular.gridx = 1;
            regularFrame.add(planRegularCb,gbcRegular);

            gbcRegular.gridy = 5;
            regularFrame.add(paidAmountRegularTf,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,10);
            gbcRegular.gridx = 0;
            regularFrame.add(paidAmountRegularLbl,gbcRegular);

            gbcRegular.gridx = 2;
            regularFrame.add(activeRegularLbl,gbcRegular);

            gbcRegular.gridx = 3;
            regularFrame.add(activeRegularTf,gbcRegular);

            gbcRegular.gridy = 6;
            regularFrame.add(loyaltyRegularTf,gbcRegular);

            gbcRegular.gridx = 2;
            regularFrame.add(loyaltyRegularLbl,gbcRegular);

            gbcRegular.gridx = 0;
            regularFrame.add(attendanceRegularLbl,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,80);
            gbcRegular.gridx = 1;
            regularFrame.add(attendanceRegularTf,gbcRegular);

            gbcRegular.gridy = 7;
            regularFrame.add(scrollPane,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,10);
            gbcRegular.gridx = 0;
            regularFrame.add(removalReasonRegularLbl,gbcRegular);

            gbcRegular.insets = new Insets(5,0,5,10);
            gbcRegular.gridx = 0;
            gbcRegular.gridy = 8;
            gbcRegular.gridwidth = 4;
            regularFrame.add(regularBtnPanel1,gbcRegular);

            gbcRegular.gridy = 9;
            regularFrame.add(regularBtnPanel2,gbcRegular);


            //ID action listener
            idRegularTf.addActionListener(e->{
                try {
                    File file = new File("RegularMembers.txt");
                    if(file.exists()){
                        String strId = String.valueOf(idRegularTf.getText().charAt(0));
                        boolean isInstance = false;
                        boolean isPresent = false;
                        if(strId.equals("R")) {
                            int id = Integer.parseInt(idRegularTf.getText().replace("R", ""));
                            for (int i = 0; i < gymMembers.size(); i++) {
                                if (gymMembers.get(i) instanceof RegularMember rm) {
                                    isInstance = true;
                                    if (id == gymMembers.get(i).getId()) {
                                        isPresent = true;
                                        nameRegularTf.setText(rm.getName());
                                        locationRegularTf.setText(rm.getLocation());
                                        emailRegularTf.setText(rm.getEmail());
                                        phoneRegularTf.setText(rm.getPhone());
                                        msdRegularTf.setText(rm.getMembershipStartDate());
                                        attendanceRegularTf.setText(String.valueOf(rm.getAttendance()));
                                        loyaltyRegularTf.setText(String.valueOf(rm.getLoyaltyPoints()));
                                        planRegularCb.setSelectedItem(rm.getPlan());
                                        priceRegularTf.setText(String.valueOf(rm.getPlanPrice(rm.getPlan())));
                                        activeRegularTf.setText(String.valueOf(rm.getActiveStatus()));
                                    }
                                }
                            }
                        }
                        if (!isInstance || !isPresent) {
                            JOptionPane.showMessageDialog(regularFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Currently there are zero regular members", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Plan Action Listener
            planRegularCb.addActionListener(e->{
                if(planRegularCb.getSelectedIndex()==0){
                    priceRegularTf.setText("6500");
                } else if (planRegularCb.getSelectedIndex()==1) {
                    priceRegularTf.setText("12500");
                }
                else{
                    priceRegularTf.setText("18500");
                }
            });

            //Buttons Actions
            //Activate Regular Membership
            activeMemberRegularBtn.addActionListener(e-> {
                try {
                    if(!idRegularTf.getText().isEmpty()) {
                        File file = new File("RegularMembers.txt");
                        if (file.exists()) {
                            boolean isInstance = false;
                            boolean isPresent = false;
                            String strId = String.valueOf(idRegularTf.getText().charAt(0));
                            if (strId.equals("R")) {
                                int id = Integer.parseInt(idRegularTf.getText().replace("R", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof RegularMember rm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if (rm.getActiveStatus()) {
                                                JOptionPane.showMessageDialog(regularFrame, "You membership is already active", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            } else {
                                                rm.activateMembership();
                                                JOptionPane.showMessageDialog(regularFrame, "You membership has been activated", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                activeRegularTf.setText(String.valueOf(rm.getActiveStatus()));
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(regularFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(regularFrame, "Currently there are zero regular members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Deactivate Regular Membership
            deactiveMemberRegularBtn.addActionListener(e->{
                try {
                    if(!idRegularTf.getText().isEmpty()) {
                        File file = new File("RegularMembers.txt");
                        if (file.exists()) {
                            String strId = String.valueOf(idRegularTf.getText().charAt(0));
                            boolean isInstance = false;
                            boolean isPresent = false;
                            if (strId.equals("R")) {
                                int id = Integer.parseInt(idRegularTf.getText().replace("R", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof RegularMember rm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if (!rm.getActiveStatus()) {
                                                JOptionPane.showMessageDialog(regularFrame, "You membership is already deactive", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            } else {
                                                rm.deactivateMembership();
                                                JOptionPane.showMessageDialog(regularFrame, "You membership has been deactivated", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                activeRegularTf.setText(String.valueOf(rm.getActiveStatus()));
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(regularFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(regularFrame, "Currently there are zero regular members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Mark Attendance for Regular Member
            markAttendanceRegularBtn.addActionListener(e->{
                try {
                    if(!idRegularTf.getText().isEmpty()) {
                        File file = new File("RegularMembers.txt");
                        if (file.exists()) {
                            boolean isInstance = false;
                            boolean isPresent = false;
                            String strId = String.valueOf(idRegularTf.getText().charAt(0));
                            if (strId.equals("R")) {
                                int id = Integer.parseInt(idRegularTf.getText().replace("R", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof RegularMember rm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if (rm.getActiveStatus()) {
                                                rm.markAttendance();
                                                JOptionPane.showMessageDialog(regularFrame, "You attendance has been marked.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                attendanceRegularTf.setText(String.valueOf(rm.getAttendance()));
                                                loyaltyRegularTf.setText(String.valueOf(rm.getLoyaltyPoints()));
                                                if (rm.getAttendance() >= 30) {
                                                    JOptionPane.showMessageDialog(regularFrame, "You are eligible for upgrade", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(regularFrame, "Your Membership is not active, Please activate it first", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(regularFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Revert Regular Membership
            revertRegularBtn.addActionListener(e->{
                try {
                    if(!idRegularTf.getText().isEmpty()) {
                        File file = new File("RegularMembers.txt");
                        if (file.exists()) {
                            boolean isInstance = false;
                            boolean isPresent = false;
                            String strId = String.valueOf(idRegularTf.getText().charAt(0));
                            if (strId.equals("R")) {
                                int id = Integer.parseInt(idRegularTf.getText().replace("R", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof RegularMember rm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            rm.revertRegularMember(removalReasonRegularTa.getText());
                                            attendanceRegularTf.setText(String.valueOf(rm.getAttendance()));
                                            loyaltyRegularTf.setText(String.valueOf(rm.getLoyaltyPoints()));
                                            activeRegularTf.setText(String.valueOf(rm.getActiveStatus()));
                                            planRegularCb.setSelectedIndex(0);
                                            removalReasonRegularTa.setText("");

                                            JOptionPane.showMessageDialog(regularFrame, "You membership has been reverted", "Info", JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(regularFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(regularFrame, "Currently there are zero regular members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Upgrade Plan for Regular Member
            upgradeRegularBtn.addActionListener(e->{
                try {
                    if(!idRegularTf.getText().isEmpty()) {
                        File file = new File("RegularMembers.txt");
                        if (file.exists()) {
                            boolean isInstance = false;
                            boolean isPresent = false;
                            String strId = String.valueOf(idRegularTf.getText().charAt(0));
                            if (strId.equals("R")) {
                                int id = Integer.parseInt(idRegularTf.getText().replace("R", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof RegularMember rm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if(rm.getAttendance()>=30) {
                                                if (rm.getActiveStatus()) {
                                                    String upgrade = planRegularCb.getSelectedItem().toString();
                                                    if (upgradeRegularBtn.getText().equals("Upgrade Plan")) {
                                                        upgradeRegularBtn.setText("Upgrade");
                                                        planRegularCb.setEnabled(true);
                                                        paidAmountRegularTf.setEditable(true);
                                                        JOptionPane.showMessageDialog(regularFrame, "You Please choose which plan you want to upgrade to", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                    } else {
                                                        double paidAmount = Double.parseDouble(paidAmountRegularTf.getText());
                                                        if (paidAmount >= rm.getPlanPrice(planRegularCb.getSelectedItem().toString())) {
                                                            rm.setPlan(planRegularCb.getSelectedItem().toString());
                                                            rm.setPrice(rm.getPlanPrice(planRegularCb.getSelectedItem().toString()));
                                                            rm.setAttendance(0);
                                                            rm.upgradePlan(upgrade);
                                                            attendanceRegularTf.setText("0");
                                                            planRegularCb.setEnabled(false);
                                                            paidAmountRegularTf.setEditable(false);
                                                            paidAmountRegularTf.setText("");
                                                            upgradeRegularBtn.setText("Upgrade Plan");
                                                            double change = paidAmount - rm.getPrice();
                                                            if (change == 0.00) {
                                                                JOptionPane.showMessageDialog(regularFrame, "You plan has been successfully upgraded", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                            } else {
                                                                JOptionPane.showMessageDialog(regularFrame, "You plan has been successfully upgraded and Here your change: " + change, "Info", JOptionPane.INFORMATION_MESSAGE);
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(regularFrame, "You have to pay full amount to upgrade", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                    }
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(regularFrame, "You membership is not active", "Error", JOptionPane.ERROR_MESSAGE);
                                                    break;
                                                }
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(regularFrame, "You do not have enough attendances", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(regularFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Display for Regular Member
            displayRegularBtn.addActionListener(e->{
                try {
                    File file = new File("RegularMembers.txt");
                    if (file.exists()) {
                        ArrayList<String[]> regularMemberList = new ArrayList<>();
                        for (GymMember gm : gymMembers) {
                            if (gm instanceof RegularMember rm) {
                                String[] details = new String[9];
                                details[0] = "R" + rm.getId();
                                details[1] = rm.getName();
                                details[2] = rm.getLocation();
                                details[3] = rm.getPhone();
                                details[4] = rm.getEmail();
                                details[5] = rm.getGender();
                                details[6] = rm.getDob();
                                details[7] = rm.getMembershipStartDate();
                                details[8] = rm.getReferralSource();
                                regularMemberList.add(details);
                            }
                        }
                        String[][] regularMemberDetails = regularMemberList.toArray(new String[regularMemberList.size()][]);
                        String[] columns = {"ID", "Name", "Location", "Phone", "Email", "Gender", "Dob", "Membership Start Date", "Referral Source"};

                        JTable regularTable = new JTable(regularMemberDetails, columns);
                        JScrollPane regularTableScroll = new JScrollPane(regularTable);
                        JFrame regularTableFrame = new JFrame("Table");
                        regularTableFrame.setSize(1100, 500);
                        regularTableFrame.setLocationRelativeTo(null);
                        regularTableFrame.add(regularTableScroll);
                        regularTableFrame.setVisible(true);


                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Currently there are zero regular members", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Clear for Regular Frame
            clearRegularBtn.addActionListener(e->{
                idRegularTf.setText("");
                nameRegularTf.setText("");
                locationRegularTf.setText("");
                phoneRegularTf.setText("");
                emailRegularTf.setText("");
                msdRegularTf.setText("");
                planRegularCb.setSelectedIndex(0);
                planRegularCb.setEnabled(false);
                paidAmountRegularTf.setText("");
                paidAmountRegularTf.setEditable(false);
                activeRegularTf.setText("");
                attendanceRegularTf.setText("");
                loyaltyRegularTf.setText("");
                removalReasonRegularTa.setText("");
            });

            //Save to Regular Member File
            saveRegularBtn.addActionListener(e->{
                try {
                    if(!idRegularTf.getText().isEmpty()) {
                        File file = new File("RegularMembers.txt");
                        if (file.exists()) {
                            Scanner scan = new Scanner(file);
                            boolean ignoreFirst = true;
                            int count = 1;
                            String id = idRegularTf.getText();
                            while (scan.hasNextLine()) {
                                if (ignoreFirst) {
                                    scan.nextLine();
                                    ignoreFirst = false;
                                    continue;
                                }
                                String line = scan.nextLine();
                                String comparingId = line.substring(0, 6).strip();
                                if (!id.equals(comparingId)) {
                                    count++;
                                } else {
                                    break;
                                }
                            }
                            scan.close();
                            for (GymMember gm : gymMembers) {
                                if (gm instanceof RegularMember rm) {
                                    int comparingId = Integer.parseInt(idRegularTf.getText().replace("R", ""));
                                    if (comparingId == rm.getId()) {
                                        Scanner scanForWriter = new Scanner(file);
                                        ArrayList<String> lines = new ArrayList<>();
                                        while (scanForWriter.hasNextLine()) {
                                            lines.add(scanForWriter.nextLine());
                                        }
                                        scanForWriter.close();
                                        lines.set(count, String.format("%-5s %-30s %-25s %-15s %-40s %-10s %-20s %-25s %-25s %-10s %-15s %-15s %-15s %-15s", "R" + rm.getId(), rm.getName(), rm.getLocation(), rm.getPhone(), rm.getEmail(), rm.getGender(), rm.getDob(), rm.getMembershipStartDate(), rm.getReferralSource(), rm.getPlan(), rm.getPlanPrice(rm.getPlan()), rm.getActiveStatus(), rm.getAttendance(), rm.getLoyaltyPoints()));
                                        FileWriter writer = new FileWriter("RegularMembers.txt");
                                        for (String line : lines) {
                                            writer.write(line + "\n");
                                        }
                                        writer.close();
                                        JOptionPane.showMessageDialog(regularFrame, "Your details has been save to the file", "Info", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(regularFrame, "Currently, there are no members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch(IOException io){
                    JOptionPane.showMessageDialog(regularFrame,"File Not Found","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Read From Regular Member File
            readRegularBtn.addActionListener(e->{
                try{
                    File file = new File("RegularMembers.txt");
                    if(file.exists()){
                        Scanner scanRegular = new Scanner(file);
                        boolean ignoreFirst = true;
                        ArrayList<String[]>regularMemberList = new ArrayList<>();
                        while(scanRegular.hasNextLine()){
                            if(ignoreFirst){
                                scanRegular.nextLine();
                                ignoreFirst = false;
                                continue;
                            }
                            String line = scanRegular.nextLine();
                            String [] details = new String[14];
                            details[0] = line.substring(0,6).strip();
                            details[1] = line.substring(6,37).strip();
                            details[2] = line.substring(37,63).strip();
                            details[3] = line.substring(63,79).strip();
                            details[4] = line.substring(79,120).strip();
                            details[5] = line.substring(120,131).strip();
                            details[6] = line.substring(131,152).strip();
                            details[7] = line.substring(152,178).strip();
                            details[8] = line.substring(178,204).strip();
                            details[9] = line.substring(204,215).strip();
                            details[10] = line.substring(215,231).strip();
                            details[11] = line.substring(231,247).strip();
                            details[12] = line.substring(247,263).strip();
                            details[13] = line.substring(263,line.length()-1).strip();
                            regularMemberList.add(details);
                        }
                        scanRegular.close();
                        String[][] regularMemberDetail = regularMemberList.toArray(new String[regularMemberList.size()][]);
                        String [] columns = {"ID","Name","Location","Phone","Email","Gender","Dob","Membership Start Date","Referral Source","Plan","Price","Active Status","Attendance","Loyalty Points"};
                        JTable regularTable = new JTable(regularMemberDetail,columns);
                        JScrollPane regularTableScroll = new JScrollPane(regularTable);
                        JFrame regularTableFrame = new JFrame("Table");
                        regularTableFrame.setSize(1200,500);
                        regularTableFrame.setLocationRelativeTo(null);
                        regularTableFrame.add(regularTableScroll);
                        regularTableFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(regularFrame,"Currently, there are zero regular members");
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(regularFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch(IOException io){
                    JOptionPane.showMessageDialog(regularFrame,"File Not Found","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(regularFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

        }


        //Premium Member
        {
            //Creating objects
            premiumFrame = new JFrame();//This frame is for premium member
            premiumFrame.setSize(800, 500);//Setting size of premiumFrame
            premiumFrame.setLocationRelativeTo(null);//Setting Location to center of the screen
            premiumFrame.setLayout(new GridBagLayout());//Setting Layout for premiumFrame
            GridBagConstraints gbcPremium = new GridBagConstraints();

            //Creating objects
            titlePremium = new JLabel("Premium Member");
            titlePremium.setFont(new Font("Arial", Font.BOLD, 24));
            idPremiumLbl = new JLabel("ID:");
            namePremiumLbl = new JLabel("Name:");
            locationPremiumLbl = new JLabel("Location:");
            phonePremiumLbl = new JLabel("Phone:");
            emailPremiumLbl = new JLabel("Email:");
            msdPremiumLbl = new JLabel("Membership Start Date:");
            pricePremiumLbl = new JLabel("Price:");
            paidAmountPremiumLbl = new JLabel("Paid Amount:");
            dueAmountPremiumLbl = new JLabel("Due Amount:");
            attendancePremiumLbl = new JLabel("Attendance:");
            loyaltyPremiumLbl = new JLabel("loyalty Points:");
            activePremiumLbl = new JLabel("Active Status:");


            idPremiumTf = new JTextField(15);
            namePremiumTf = new JTextField(15);
            namePremiumTf.setEditable(false);
            locationPremiumTf = new JTextField(15);
            locationPremiumTf.setEditable(false);
            phonePremiumTf = new JTextField(15);
            phonePremiumTf.setEditable(false);
            emailPremiumTf = new JTextField(15);
            emailPremiumTf.setEditable(false);
            msdPremiumTf = new JTextField(15);
            msdPremiumTf.setEditable(false);
            pricePremiumTf = new JTextField(15);
            pricePremiumTf.setEditable(false);
            paidAmountPremiumTf = new JTextField(15);
            paidAmountPremiumTf.setEditable(false);
            dueAmountPremiumTf = new JTextField(15);
            dueAmountPremiumTf.setEditable(false);
            attendancePremiumTf = new JTextField(15);
            attendancePremiumTf.setEditable(false);
            loyaltyPremiumTf = new JTextField(15);
            loyaltyPremiumTf.setEditable(false);
            activePremiumTf = new JTextField(15);
            activePremiumTf.setEditable(false);

            activeMemberPremiumBtn = new JButton("Active Membership");
            deactiveMemberPremiumBtn = new JButton("Deactive Membership");
            markAttendancePremiumBtn = new JButton("Mark Attendance");
            revertPremiumBtn = new JButton("Revert");
            payDuePremiumBtn = new JButton("Pay Due Amount");
            displayPremiumBtn = new JButton("Display");
            clearPremiumBtn = new JButton("Clear");
            savePremiumBtn = new JButton("Save to File");
            readPremiumBtn = new JButton("Read the File");

            JPanel premiumBtnPanel1 = new JPanel();
            JPanel premiumBtnPanel2 = new JPanel();
            premiumBtnPanel1.add(activeMemberPremiumBtn);
            premiumBtnPanel1.add(deactiveMemberPremiumBtn);
            premiumBtnPanel1.add(markAttendancePremiumBtn);
            premiumBtnPanel1.add(revertPremiumBtn);
            premiumBtnPanel2.add(payDuePremiumBtn);
            premiumBtnPanel2.add(displayPremiumBtn);
            premiumBtnPanel2.add(clearPremiumBtn);
            premiumBtnPanel2.add(savePremiumBtn);
            premiumBtnPanel2.add(readPremiumBtn);

            gbcPremium.gridx = 0;
            gbcPremium.gridy = 0;
            gbcPremium.gridwidth = 4;
            gbcPremium.insets = new Insets(5, 5, 30, 5);
            premiumFrame.add(titlePremium, gbcPremium);
            gbcPremium.gridwidth = 1;
            gbcPremium.gridy = 1;
            gbcPremium.insets = new Insets(5,0,5,10);
            premiumFrame.add(idPremiumLbl,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,80);
            gbcPremium.gridx = 1;
            premiumFrame.add(idPremiumTf,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,10);
            gbcPremium.gridx = 2;
            premiumFrame.add(namePremiumLbl,gbcPremium);

            gbcPremium.gridx = 3;
            premiumFrame.add(namePremiumTf,gbcPremium);

            gbcPremium.gridy = 2;
            premiumFrame.add(phonePremiumTf,gbcPremium);

            gbcPremium.gridx = 2;
            premiumFrame.add(phonePremiumLbl,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,80);
            gbcPremium.gridx = 1;
            premiumFrame.add(locationPremiumTf,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,10);
            gbcPremium.gridx = 0;
            premiumFrame.add(locationPremiumLbl,gbcPremium);

            gbcPremium.gridy = 3;
            premiumFrame.add(emailPremiumLbl,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,80);
            gbcPremium.gridx = 1;
            premiumFrame.add(emailPremiumTf,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,10);
            gbcPremium.gridx = 2;
            premiumFrame.add(msdPremiumLbl,gbcPremium);

            gbcPremium.gridx = 3;
            premiumFrame.add(msdPremiumTf,gbcPremium);

            gbcPremium.gridy = 4;
            premiumFrame.add(pricePremiumTf,gbcPremium);

            gbcPremium.gridx = 2;
            premiumFrame.add(pricePremiumLbl,gbcPremium);

            gbcPremium.gridx = 0;
            premiumFrame.add(dueAmountPremiumLbl,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,80);
            gbcPremium.gridx = 1;
            premiumFrame.add(dueAmountPremiumTf,gbcPremium);

            gbcPremium.gridy = 5;
            premiumFrame.add(paidAmountPremiumTf,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,10);
            gbcPremium.gridx = 0;
            premiumFrame.add(paidAmountPremiumLbl,gbcPremium);

            gbcPremium.gridx = 2;
            premiumFrame.add(activePremiumLbl,gbcPremium);

            gbcPremium.gridx = 3;
            premiumFrame.add(activePremiumTf,gbcPremium);

            gbcPremium.gridy = 6;
            premiumFrame.add(loyaltyPremiumTf,gbcPremium);

            gbcPremium.gridx = 2;
            premiumFrame.add(loyaltyPremiumLbl,gbcPremium);

            gbcPremium.gridx = 0;
            premiumFrame.add(attendancePremiumLbl,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,80);
            gbcPremium.gridx = 1;
            premiumFrame.add(attendancePremiumTf,gbcPremium);

            gbcPremium.insets = new Insets(5,0,5,10);
            gbcPremium.gridx = 0;
            gbcPremium.gridy = 7;
            gbcPremium.gridwidth = 4;
            premiumFrame.add(premiumBtnPanel1,gbcPremium);

            gbcPremium.gridy = 9;
            premiumFrame.add(premiumBtnPanel2,gbcPremium);

            //ID ActionListener
            idPremiumTf.addActionListener(e->{
                try {
                    File file = new File("PremiumMembers.txt");
                    if(file.exists()){
                        String strId = String.valueOf(idPremiumTf.getText().charAt(0));
                        boolean isInstance = false;
                        boolean isPresent = false;
                        if(strId.equals("P")) {
                            int id = Integer.parseInt(idPremiumTf.getText().replace("P",""));
                            for (int i = 0; i < gymMembers.size(); i++) {
                                if (gymMembers.get(i) instanceof PremiumMember pm) {
                                    isInstance = true;
                                    if (id == gymMembers.get(i).getId()) {
                                        isPresent = true;
                                        namePremiumTf.setText(pm.getName());
                                        locationPremiumTf.setText(pm.getLocation());
                                        emailPremiumTf.setText(pm.getEmail());
                                        phonePremiumTf.setText(pm.getPhone());
                                        msdPremiumTf.setText(pm.getMembershipStartDate());
                                        dueAmountPremiumTf.setText(String.valueOf(pm.getDueAmount()));
                                        paidAmountPremiumTf.setText(String.valueOf(pm.getPaidAmount()));
                                        attendancePremiumTf.setText(String.valueOf(pm.getAttendance()));
                                        loyaltyPremiumTf.setText(String.valueOf(pm.getLoyaltyPoints()));
                                        pricePremiumTf.setText(String.valueOf(pm.getPremiumCharge()));
                                        activePremiumTf.setText(String.valueOf(pm.getActiveStatus()));
                                    }
                                }
                            }
                        }
                        if (!isInstance || !isPresent) {
                            JOptionPane.showMessageDialog(premiumFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame, "Currently there are zero premium members", "Error", JOptionPane.ERROR_MESSAGE);
                    }



                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Activate Premium Member
            activeMemberPremiumBtn.addActionListener(e->{
                try{
                    if(!idPremiumTf.getText().isEmpty()) {
                        File file = new File("PremiumMembers.txt");
                        if (file.exists()) {
                            String strId = String.valueOf(idPremiumTf.getText().charAt(0));
                            boolean isInstance = false;
                            boolean isPresent = false;
                            if (strId.equals("P")) {
                                int id = Integer.parseInt(idPremiumTf.getText().replace("P", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof PremiumMember pm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if (pm.getActiveStatus()) {
                                                JOptionPane.showMessageDialog(premiumFrame, "You membership is already active", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            } else {
                                                pm.activateMembership();
                                                JOptionPane.showMessageDialog(premiumFrame, "You membership has been activated", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                activePremiumTf.setText(String.valueOf(pm.getActiveStatus()));
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(premiumFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(premiumFrame, "Currently there are zero premium members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Deactivate Premium Member
            deactiveMemberPremiumBtn.addActionListener(e->{
                try{
                    if(!idPremiumTf.getText().isEmpty()) {
                        File file = new File("PremiumMembers.txt");
                        if (file.exists()) {
                            String strId = String.valueOf(idPremiumTf.getText().charAt(0));
                            boolean isInstance = false;
                            boolean isPresent = false;
                            if (strId.equals("P")) {
                                int id = Integer.parseInt(idPremiumTf.getText().replace("P", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof PremiumMember pm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if (!pm.getActiveStatus()) {
                                                JOptionPane.showMessageDialog(premiumFrame, "You membership is already deactive", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            } else {
                                                pm.deactivateMembership();
                                                JOptionPane.showMessageDialog(premiumFrame, "You membership has been deactivated", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                activePremiumTf.setText(String.valueOf(pm.getActiveStatus()));
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(premiumFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(premiumFrame, "Currently there are zero premium members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Mark Attendance of Premium Member
            markAttendancePremiumBtn.addActionListener(e->{
                try {
                    if(!idPremiumTf.getText().isEmpty()) {
                        File file = new File("PremiumMembers.txt");
                        if (file.exists()) {
                            boolean isInstance = false;
                            boolean isPresent = false;
                            String strId = String.valueOf(idPremiumTf.getText().charAt(0));
                            if (strId.equals("P")) {
                                int id = Integer.parseInt(idPremiumTf.getText().replace("P", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof PremiumMember pm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if (pm.getActiveStatus()) {
                                                pm.markAttendance();
                                                attendancePremiumTf.setText(String.valueOf(pm.getAttendance()));
                                                loyaltyPremiumTf.setText(String.valueOf(pm.getLoyaltyPoints()));
                                                JOptionPane.showMessageDialog(premiumFrame, "You attendance has been marked.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(premiumFrame, "Your Membership is not active, Please activate it first", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(premiumFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Revert Premium Member
            revertPremiumBtn.addActionListener(e->{
                try{
                    if(!idPremiumTf.getText().isEmpty()) {
                        File file = new File("PremiumMembers.txt");
                        if (file.exists()) {
                            String strId = String.valueOf(idPremiumTf.getText().charAt(0));
                            boolean isInstance = false;
                            boolean isPresent = false;
                            if (strId.equals("P")) {
                                int id = Integer.parseInt(idPremiumTf.getText().replace("P", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof PremiumMember pm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            pm.revertPremiumMember();
                                            attendancePremiumTf.setText(String.valueOf(pm.getAttendance()));
                                            loyaltyPremiumTf.setText(String.valueOf(pm.getLoyaltyPoints()));
                                            activePremiumTf.setText(String.valueOf(pm.getActiveStatus()));

                                            JOptionPane.showMessageDialog(premiumFrame, "You membership has been reverted", "Info", JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(premiumFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(premiumFrame, "Currently there are zero premium members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Pay Due Amount
            payDuePremiumBtn.addActionListener(e->{
                try {
                    if(!idPremiumTf.getText().isEmpty()) {
                        File file = new File("PremiumMembers.txt");
                        if (file.exists()) {
                            String strId = String.valueOf(idPremiumTf.getText().charAt(0));
                            boolean isInstance = false;
                            boolean isPresent = false;
                            if (strId.equals("P")) {
                                int id = Integer.parseInt(idPremiumTf.getText().replace("P", ""));
                                for (int i = 0; i < gymMembers.size(); i++) {
                                    if (gymMembers.get(i) instanceof PremiumMember pm) {
                                        isInstance = true;
                                        if (id == gymMembers.get(i).getId()) {
                                            isPresent = true;
                                            if (Double.parseDouble(dueAmountPremiumTf.getText()) == 0) {
                                                JOptionPane.showMessageDialog(premiumFrame, "You do not have any due amount", "Info", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                if (payDuePremiumBtn.getText().equals("Pay Due Amount")) {
                                                    paidAmountPremiumTf.setText("");
                                                    paidAmountPremiumTf.setEditable(true);
                                                    paidAmountPremiumLbl.setText("Pay Due Amount:");
                                                    payDuePremiumBtn.setText("Pay");
                                                } else {
                                                    double paidAmount = Double.parseDouble(paidAmountPremiumTf.getText());
                                                    String message = pm.payDueAmount(paidAmount);
                                                    dueAmountPremiumTf.setText(String.valueOf(pm.getDueAmount()));
                                                    paidAmountPremiumTf.setText(String.valueOf(pm.getPaidAmount()));
                                                    paidAmountPremiumTf.setEditable(false);
                                                    paidAmountPremiumLbl.setText("Paid Amount");
                                                    payDuePremiumBtn.setText("Pay Due Amount");
                                                    JOptionPane.showMessageDialog(premiumFrame, message, "Info", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isInstance || !isPresent) {
                                JOptionPane.showMessageDialog(premiumFrame, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(premiumFrame, "Please enter your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Display Premium Members
            displayPremiumBtn.addActionListener(e->{
                try {
                    File file = new File("PremiumMembers.txt");
                    if (file.exists()) {
                        ArrayList<String[]> premiumMemberList = new ArrayList<>();
                        for (GymMember gm : gymMembers) {
                            if (gm instanceof PremiumMember pm) {
                                String[] details = new String[9];
                                details[0] = "P" + pm.getId();
                                details[1] = pm.getName();
                                details[2] = pm.getLocation();
                                details[3] = pm.getPhone();
                                details[4] = pm.getEmail();
                                details[5] = pm.getGender();
                                details[6] = pm.getDob();
                                details[7] = pm.getMembershipStartDate();
                                details[8] = pm.getPersonalTrainer();
                                premiumMemberList.add(details);
                            }
                        }

                        String[][] premiumMemberDetails = premiumMemberList.toArray(new String[premiumMemberList.size()][]);
                        String[] columns = {"ID", "Name", "Location", "Phone", "Email", "Gender", "Dob", "Membership Start Date", "Personal Trainer"};

                        JTable premiumTable = new JTable(premiumMemberDetails, columns);
                        JScrollPane premiumTableScroll = new JScrollPane(premiumTable);
                        JFrame premiumTableFrame = new JFrame("Table");
                        premiumTableFrame.setSize(1100, 500);
                        premiumTableFrame.setLocationRelativeTo(null);
                        premiumTableFrame.add(premiumTableScroll);
                        premiumTableFrame.setVisible(true);

                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame, "Currently there are zero premium members", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Clear Premium Frame
            clearPremiumBtn.addActionListener(e->{
                idPremiumTf.setText("");
                namePremiumTf.setText("");
                locationPremiumTf.setText("");
                phonePremiumTf.setText("");
                emailPremiumTf.setText("");
                msdPremiumTf.setText("");
                dueAmountPremiumTf.setText("");
                pricePremiumTf.setText("");
                paidAmountPremiumTf.setText("");
                paidAmountPremiumTf.setEditable(false);
                activePremiumTf.setText("");
                attendancePremiumTf.setText("");
                loyaltyPremiumTf.setText("");
            });

            //Save to Premium Member File
            savePremiumBtn.addActionListener(e->{
                try {
                    if(!idPremiumTf.getText().isEmpty()) {
                        File file = new File("PremiumMembers.txt");
                        if (file.exists()) {
                            Scanner scan = new Scanner(file);
                            boolean ignoreFirst = true;
                            int count = 1;
                            String id = idPremiumTf.getText();
                            while (scan.hasNextLine()) {
                                if (ignoreFirst) {
                                    scan.nextLine();
                                    ignoreFirst = false;
                                    continue;
                                }
                                String line = scan.nextLine();
                                String comparingId = line.substring(0, 6).strip();
                                if (!id.equals(comparingId)) {
                                    count++;
                                } else {
                                    break;
                                }
                            }
                            scan.close();
                            for (GymMember gm : gymMembers) {
                                if (gm instanceof PremiumMember pm) {
                                    int comparingId = Integer.parseInt(idPremiumTf.getText().replace("P", ""));
                                    if (comparingId == pm.getId()) {
                                        Scanner scanForWriter = new Scanner(file);
                                        ArrayList<String> lines = new ArrayList<>();
                                        while (scanForWriter.hasNextLine()) {
                                            lines.add(scanForWriter.nextLine());
                                        }
                                        scanForWriter.close();
                                        lines.set(count, String.format("%-5s %-30s %-25s %-15s %-40s %-10s %-20s %-25s %-25s %-15s %-15s %-20s %-15s %-15s %-15s %-15s", "P" + pm.getId(), pm.getName(), pm.getLocation(), pm.getPhone(), pm.getEmail(), pm.getGender(), pm.getDob(), pm.getMembershipStartDate(), pm.getPersonalTrainer(), pm.getPremiumCharge(), pm.getPaidAmount(), pm.getDiscountAmount(), pm.getDueAmount(), pm.getActiveStatus(), pm.getAttendance(), pm.getLoyaltyPoints()));
                                        FileWriter writer = new FileWriter("PremiumMembers.txt");
                                        for (String line : lines) {
                                            writer.write(line + "\n");
                                        }
                                        writer.close();
                                        JOptionPane.showMessageDialog(premiumFrame, "Your details has been save to the file", "Info", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(premiumFrame, "Currently, there are no members", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame, "Please Enter Your ID first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch(IOException io){
                    JOptionPane.showMessageDialog(premiumFrame,"File Not Found","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });

            //Read from premium member file
            readPremiumBtn.addActionListener(e->{
                try{
                    File file = new File("PremiumMembers.txt");
                    if(file.exists()){
                        Scanner scanPremium = new Scanner(file);
                        boolean ignoreFirst = true;
                        ArrayList<String[]>premiumMemberList = new ArrayList<>();
                        while(scanPremium.hasNextLine()){
                            if(ignoreFirst){
                                scanPremium.nextLine();
                                ignoreFirst = false;
                                continue;
                            }
                            String line = scanPremium.nextLine();
                            String [] details = new String[16];
                            details[0] = line.substring(0,6).strip();
                            details[1] = line.substring(6,37).strip();
                            details[2] = line.substring(37,63).strip();
                            details[3] = line.substring(63,79).strip();
                            details[4] = line.substring(79,120).strip();
                            details[5] = line.substring(120,131).strip();
                            details[6] = line.substring(131,152).strip();
                            details[7] = line.substring(152,178).strip();
                            details[8] = line.substring(178,204).strip();
                            details[9] = line.substring(204,220).strip();
                            details[10] = line.substring(220,236).strip();
                            details[11] = line.substring(236,252).strip();
                            details[12] = line.substring(252,273).strip();
                            details[13] = line.substring(273,289).strip();
                            details[14] = line.substring(289,305).strip();
                            details[15] = line.substring(305,line.length()-1).strip();
                            premiumMemberList.add(details);
                        }
                        scanPremium.close();
                        String[][] premiumMemberDetail = premiumMemberList.toArray(new String[premiumMemberList.size()][]);
                        String [] columns = {"ID","Name","Location","Phone","Email","Gender","Dob","Membership Start Date","Personal Trainer","Price","Paid Amount","Discount Amount","Due Amount","Active Status","Attendance","Loyalty Points"};
                        JTable premiumTable = new JTable(premiumMemberDetail,columns);
                        JScrollPane premiumTableScroll = new JScrollPane(premiumTable);
                        JFrame premiumTableFrame = new JFrame("Table");
                        premiumTableFrame.setSize(1300,500);
                        premiumTableFrame.setLocationRelativeTo(null);
                        premiumTableFrame.add(premiumTableScroll);
                        premiumTableFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(premiumFrame,"Currently, there are zero premium members");
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(premiumFrame,"Invalid Input, Please Fill Proper Input","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch(IOException io){
                    JOptionPane.showMessageDialog(premiumFrame,"File Not Found","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(premiumFrame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            });
        }


        //Main Frame
        {
            mainFrame.setLayout(new GridBagLayout());//Setting main frame layout
            GridBagConstraints gbc = new GridBagConstraints();

            JLabel title = new JLabel("Jonam's GYM");//This is the title of the GYM
            title.setFont(new Font("Arial", Font.BOLD, 24));//Setting the font style, size and bold
            regularBtn = new JButton("Regular Member");//This button is to access the portal for regular member
            premiumBtn = new JButton("Premium Member");//This button is to access the portal for premium member
            newBtn = new JButton("New Member");//This button is to access the portal for adding new member

            regularBtn.addActionListener(e -> {
                regularFrame.setVisible(true);
            });

            newBtn.addActionListener(e -> {
                newFrame.setVisible(true);
            });

            premiumBtn.addActionListener(e -> {
                premiumFrame.setVisible(true);
            });


            gbc.gridwidth = 4;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(5, 5, 5, 5);
            mainFrame.add(title, gbc);

            gbc.gridwidth = 2;
            gbc.gridy = 1;
            gbc.ipadx = 10;
            gbc.ipady = 10;
            mainFrame.add(regularBtn, gbc);

            gbc.gridx = 2;
            mainFrame.add(premiumBtn, gbc);

            gbc.gridwidth = 3;
            gbc.gridx = 1;
            gbc.gridy = 2;
            mainFrame.add(newBtn, gbc);

            mainFrame.setVisible(true);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new GymGUI();
    }
}