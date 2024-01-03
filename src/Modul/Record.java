package Modul;

public class Record {

    private String noTelp, nama, alamat, email;
    
    public Record(String noTelp, String nama, String alamat, String email) {
        this.noTelp = noTelp;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
    }
     public Record(String noTelp) {
        this.noTelp = noTelp;
        this.nama = nama;
    }
    
    public Record(){}
    
    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}