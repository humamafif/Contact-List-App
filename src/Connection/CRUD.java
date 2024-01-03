package Connection;

import Modul.*;
import java.sql.*;

public class CRUD {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/buku_telepon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static LinkedList dataList = new LinkedList();
    private static Stack dataStack = new Stack();

    public static void tambahDataDatabase(Record record) {
        String query = "INSERT INTO daftarkontak (Nama, NoTelp, Alamat, Email) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement psmt = connection.prepareStatement(query)) {

            psmt.setString(1, record.getNama());
            psmt.setString(2, record.getNoTelp());
            psmt.setString(3, record.getAlamat());
            psmt.setString(4, record.getEmail());

            int row = psmt.executeUpdate();

            if (row > 0) {
                System.out.println("Tambah data sukses");
            } else {
                System.out.println("Tambah data gagal");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void updateDataDatabase(Record record) {
        String query = "UPDATE daftarkontak SET Nama=?, NoTelp=?, Alamat=?, Email=? where Nama = ? or NoTelp = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement psmt = connection.prepareStatement(query)) {

            psmt.setString(1, record.getNama());
            psmt.setString(2, record.getNoTelp());
            psmt.setString(3, record.getAlamat());
            psmt.setString(4, record.getEmail());
            psmt.setString(5, record.getNama());
            psmt.setString(6, record.getNoTelp());

            int row = psmt.executeUpdate();

            if (row > 0) {
                System.out.println("Edit data sukses");
            } else {
                System.out.println("Edit data gagal");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public ResultSet findDataInDatabase(String searchQuery) {
        String query = "SELECT * FROM daftarkontak WHERE Nama LIKE ? OR NoTelp LIKE ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement psmt = connection.prepareStatement(query);

            psmt.setString(1, "%" + searchQuery + "%");
            psmt.setString(2, "%" + searchQuery + "%");

            return psmt.executeQuery();
        } catch (Exception e) {
            System.err.println(e);

            return null;
        }
    }

    public static ResultSet fetchDataFromDatabase() {
        String query = "select * from daftarkontak";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement psmt = connection.prepareStatement(query);

            return psmt.executeQuery();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public ResultSet sortByName() {
        String query = "select * from daftarkontak order by Nama";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement psmt = connection.prepareStatement(query);

            return psmt.executeQuery();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public ResultSet sortByNoTelp() {
        String query = "select * from daftarkontak order by NoTelp";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement psmt = connection.prepareStatement(query);
            return psmt.executeQuery();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static void delete(String nama) {
        dataList.delete(nama);
        String delete = "delete from daftarkontak where Nama = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement psmt = connection.prepareStatement(delete)) {
            psmt.setString(1, nama);

            int rowsAffected = psmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted from the database: " + nama);
            } else {
                System.out.println("Data not found in the database.");
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
