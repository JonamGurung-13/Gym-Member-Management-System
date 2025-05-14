package Jonam_Gurung_24042026;

public class RegularMember extends GymMember {
    //Instance Variables
    private final int attendanceLimit = 30;
    private boolean isEligibleForUpgrade = false;
    private String removalReason = "";
    private String referralSource;
    private String plan = "Basic";
    private double price = 6500;

    //Constructor
    public RegularMember(){};
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String dob, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, dob, membershipStartDate);
        this.referralSource = referralSource;
    }

    //Accessor method of isEligibleForUpgrade
    public final int getAttendanceLimit(){
        return this.attendanceLimit;
    }

    public void setEligibleForUpgrade(boolean isEligibleForUpgrade){
        this.isEligibleForUpgrade = isEligibleForUpgrade;
    }
    public boolean getEligibleForUpgrade(){
        return this.isEligibleForUpgrade;
    }

    //Accessor method of removalReason
    public void setRemovalReason(String removalReason){
        this.removalReason = removalReason;
    }
    public String getRemovalReason(){
        return this.removalReason;
    }

    //Accessor method of removalSource
    public void setReferralSource(String referralSource){
        this.referralSource = referralSource;
    }
    public String getReferralSource(){
        return this.referralSource;
    }

    //Accessor method of plan
    public  void setPlan(String plan){
        this.plan = plan;
    }
    public String getPlan(){
        return this.plan;
    }

    //Accessor method of price
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }

    //Methods
    @Override
    public void markAttendance(){
        setAttendance(1);
        setLoyaltyPoints(5);
        System.out.println("Total Attendance: "+getAttendance());
        int regularMemberAttendance = getAttendance();
        if(regularMemberAttendance>=this.attendanceLimit){
            this.isEligibleForUpgrade = true;
            System.out.println("You are eligible for upgrade");
        }

    }

    public double getPlanPrice(String plan){ //Must Use Switch Statement
        switch (plan){
            case "Basic":
                this.price=6500;
                return this.price;

            case "Standard":
                this.price = 12500;
                return  this.price;

            case "Deluxe":
                this.price = 18500;
                return this.price;

            default:
                return -1;
        }
    }

    public String upgradePlan(String plan){
        if (this.isEligibleForUpgrade) {
            if (getPlanPrice(plan) == -1) {
                System.out.println("Invalid plan");
                return "Invalid Plan";
            } else {
                this.price = getPlanPrice(plan);
                this.plan=plan;
                System.out.println("Your plan has successfully upgraded");
                return "Eligible";
            }

        }
        else {
            return "Not Eligible";
        }
    }

    public void revertRegularMember(String removalReason){
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
    }

    @Override
    public void display(){
        System.out.println("Your id is "+getId());
        System.out.println("Your name is "+getName());
        System.out.println("Your phone number is "+getPhone());
        System.out.println("Your email is "+getEmail());
    }


}

