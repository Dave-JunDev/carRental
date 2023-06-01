package beans;

public class User {

    private int ID;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String username;
    private String password;
    private String email;
    private double saldo;
    private int premiun;

    public User(int ID, String nombre, String apellido1, String apellido2, String username, String password, String email, double saldo, int premiun) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.username = username;
        this.password = password;
        this.email = email;
        this.saldo = saldo;
        this.premiun = premiun;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPremiun() {
        return premiun;
    }

    public void setPremiun(int premiun) {
        this.premiun = premiun;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", username=" + username + ", password=" + password + ", email=" + email + ", saldo=" + saldo + ", premiun=" + premiun + '}';
    }

}
