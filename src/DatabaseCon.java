import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseCon {
	public static String username="postgres";
	public static String password="123456";
	public static String dbUrl="jdbc:postgresql://localhost:5432/online bilet satım otomasyonu";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			
			con=DriverManager.getConnection(dbUrl, username, password);
			System.out.println("baglanti basarili.");
			
			String sql="select * from bilet";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<Bilet> biletler=new ArrayList<Bilet>();
            while(resultSet.next()) {
            	biletler.add(new Bilet(resultSet.getInt("bilet_id"),
            			resultSet.getInt("bilet_sayısı"),
            			resultSet.getInt("bilet_fiyatı"),
            			resultSet.getDate("tarih")));
            }
            System.out.println(biletler.size());
		}
		catch(SQLException e) {
		    System.out.println(e.getMessage());
		}
		finally {
			con.close();
		}
	}
}
