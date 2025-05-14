package Jonam_Gurung_24042026;

public class PremiumMember extends GymMember {
    //Instance Variables
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    private double dueAmount;

    //Constructor
    public PremiumMember(){};

    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String dob, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, dob, membershipStartDate);

        this.personalTrainer = personalTrainer;
    }

    //Accessor method of personalTrainer

    public final double getPremiumCharge(){
        return this.premiumCharge;
    }

    public void setPersonalTrainer(String personalTrainer){
        this.personalTrainer = personalTrainer;
    }
    public String getPersonalTrainer(){
        return this.personalTrainer;
    }

    //Accessor method of isFullPayment
    public void setFullPayment(boolean isFullPayment){
        this.isFullPayment = isFullPayment;
    }
    public boolean getFullPayment(){
        return this.isFullPayment;
    }

    //Accessor method of paidAmount
    public void setPaidAmount(double paidAmount){
        this.paidAmount += paidAmount;
    }
    public double getPaidAmount(){
        return this.paidAmount;
    }

    //Accessor method of discountAmount
    public void setDiscountAmount(double discountAmount){
        this.discountAmount = discountAmount;
    }
    public double getDiscountAmount(){
        return this.discountAmount;
    }

    //Accessor method of  dueAmount
    public void setDueAmount(double dueAmount){this.dueAmount = dueAmount;}

    public double getDueAmount() {
        return dueAmount;
    }

    //Abstract method
    @Override
    public void markAttendance(){
        setAttendance(1);
        setLoyaltyPoints(5);
        System.out.println("Total Attendance: "+getAttendance());
    }

    public String payDueAmount(double paidAmount){
        setPaidAmount(paidAmount);
        double change = 0;
        if (this.dueAmount==0) {
            return "You do not have any due amount";
        }
        else{
            if (this.dueAmount>paidAmount){
                this.dueAmount -=paidAmount;
                return "Thank you for paying. Now you have "+this.dueAmount + " remaining due amount";
            }
            else if(this.dueAmount == paidAmount){
                this.dueAmount = 0;
                return "Thank you for paying your due amount";

            }
            else{
                this.dueAmount = 0;
                change = paidAmount - dueAmount;
                return "Thank you for paying your due amount and Here you change: "+change;
            }
        }
    }

    public void calculateDiscount(){
        if(this.isFullPayment){
            this.discountAmount = premiumCharge*0.1;
            System.out.println("Thank you for paying full, you get 10% discount.");
        }
        else{
            this.discountAmount=0;
        }
    }

    public void revertPremiumMember(){
        super.resetMember();
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
        this.personalTrainer = "";
    }

    @Override
    public void display(){
        System.out.println("Your id is "+getId());
        System.out.println("Your name is "+getName());
        System.out.println("Your phone number is "+getPhone());
        System.out.println("Your email is "+getEmail());
    }

}


