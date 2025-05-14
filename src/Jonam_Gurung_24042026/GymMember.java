package Jonam_Gurung_24042026;

abstract class GymMember {
    //instance Variables
    private int id;
    private String name;
    private String location;
    private String phone;
    private String email;
    private String gender;
    private String dob;
    private String membershipStartDate;
    private int attendance = 0;
    private double loyaltyPoints = 0;
    private boolean activeStatus = false;

    //Constructor
    public GymMember(){};
    public GymMember(int id, String name, String location, String phone, String email, String gender, String dob, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.membershipStartDate =membershipStartDate;
    }

    //Accessor method of id
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    //Accessor method of name
    public void setName(String name){
        this.name =  name;
    }
    public String getName(){
        return this.name;
    }

    //Accessor method of location
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }

    //Accessor method of phone
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }

    //Accessor method of email
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    //Accessor method of gender
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }

    //Accessor method of DOB
    public void setDob(String dob){
        this.dob = dob;
    }
    public String getDob(){
        return this.dob;
    }

    //Accessor method of membershipStartDate
    public void setMembershipStartDate(String membershipStartDate){
        this.membershipStartDate = membershipStartDate;
    }
    public String getMembershipStartDate(){
        return this.membershipStartDate;
    }

    //Accessor method of attendance
    public void setAttendance(int attendance){
        this.attendance += attendance;

    }
    public int getAttendance(){
        return this.attendance;
    }

    //Accessor method of loyaltyPoints
    public void setLoyaltyPoints(double loyaltyPoints){
        this.loyaltyPoints += loyaltyPoints;
    }
    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }

    //Accessor method of activeStatus
    public void setActiveStatus(boolean activeStatus){
        this.activeStatus = activeStatus;
    }
    public boolean getActiveStatus(){
        return this.activeStatus;
    }


    //Abstract Method
    abstract void markAttendance();


    //Non-Abstract Method
    public void activateMembership(){
        this.activeStatus = true;
        System.out.println("Your membership is activated.");
    }

    public void deactivateMembership(){
        this.activeStatus = false;
        System.out.println("Your membership is deactivated.");
    }

    public void resetMember(){
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        System.out.println("You membership has been reset.");
    }


    public void display(){
        System.out.println("Your id is "+this.id);
        System.out.println("Your name is "+this.name);
        System.out.println("Your phone number is "+this.phone);
        System.out.println("Your email is "+this.email);
        System.out.println("Your gender is "+this.gender);
        System.out.println(this.dob);
        System.out.println(this.membershipStartDate);
        System.out.println(this.attendance);
        System.out.println(this.loyaltyPoints);
        System.out.println(this.activeStatus);
    }
}


