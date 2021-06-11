package Users;

import Blood.Disease;

import java.util.ArrayList;

public class Donor extends User{
    ArrayList<Disease>donorDisease=null;
    String dateOfLastDonation;

    public Donor(int ID, String name, String mail, String password, int age, String gender, String bloodType, ArrayList<Disease> donorDisease, String date) {
        super(ID, name, mail, password, age, gender, bloodType);
        this.donorDisease = donorDisease;
         dateOfLastDonation= date;
    }

    public void addDisease (String name, String medicine)
 {
     donorDisease.add(new Disease(name,medicine));
 }

}
