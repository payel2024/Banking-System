interface BankAccount {
    float balanceLimit();
    boolean IsEligibleToEnroll(Details x);
    String PresentStatus(Details x);
}

class Details {
    private String Name;
    private String PhoneNo;
    private String EmailAd;
    private float Age;
    private String AccID;

    public void setName(String name) {
        this.Name = name;
    }

    public void setPhone(String phone) {
        this.PhoneNo = phone;
    }

    public void setEmailAd(String email) {
        this.EmailAd = email;
    }

    public void setAge(float age) {
        this.Age = age;
    }

    public void setAccID(String accid) {
        this.AccID = accid;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return PhoneNo;
    }

    public String getEmail() {
        return EmailAd;
    }

    public float getAge() {
        return Age;
    }

    public String getAcc() {
        return AccID;
    }
}

class FixedDeposite implements BankAccount {
    private String YearOfOpening;
    private String MatureDate;

    public void setYearOfOpening(String year) {
        this.YearOfOpening = year;
    }

    public String getYearOfOpening() {
        return YearOfOpening;
    }

    public void setMatureDate(String date) {
        this.MatureDate = date;
    }

    public String getMatureDate() {
        return MatureDate;
    }

    @Override
    public float balanceLimit() {
        return 50000.0f;
    }

    @Override
    public boolean IsEligibleToEnroll(Details x) {
        return x.getAge() > 18;
    }

    @Override
    public String PresentStatus(Details x) {
        return x.getAcc();
    }
}

class Savings implements BankAccount {
    private String YearOfOpening;

    public void setYearOfOpening(String year) {
        this.YearOfOpening = year;
    }

    public String getYearOfOpening() {
        return YearOfOpening;
    }

    @Override
    public float balanceLimit() {
        return 50000.0f;
    }

    @Override
    public boolean IsEligibleToEnroll(Details x) {
        return x.getAge() > 18;
    }

    @Override
    public String PresentStatus(Details x) {
        return x.getAcc();
    }
}

public class Bank {
    public static void main(String args[]) {
        Details d1 = new Details();
        d1.setAge(23);
        d1.setAccID("A12345");  // Set the AccID here
        
        // Check if AccID is properly set
        System.out.println("Account ID: " + d1.getAcc());  // Print the AccID to check if it's set

        FixedDeposite f1 = new FixedDeposite();
        System.out.println(f1.balanceLimit());
        System.out.println("Is Eligible: " + f1.IsEligibleToEnroll(d1));
        System.out.println(f1.PresentStatus(d1));

        Savings s1 = new Savings();
        System.out.println(s1.balanceLimit());
        System.out.println("Is Eligible: " + s1.IsEligibleToEnroll(d1));
        System.out.println(s1.PresentStatus(d1));
    }
}

