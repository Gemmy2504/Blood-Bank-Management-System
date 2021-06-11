package Users;

public class Recipient extends User{
    String hospital;
    String doctorOfCase;

    public Recipient(int ID, String name, String mail, String password, int age, String gender, String bloodType, String hospital, String doctorOfCase) {
        super(ID, name, mail, password, age, gender, bloodType);
        this.hospital = hospital;
        this.doctorOfCase = doctorOfCase;
    }
}
