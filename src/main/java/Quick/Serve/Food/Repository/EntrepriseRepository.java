package Quick.Serve.Food.Repository;

import Application.DatabaseConnection;
import Quick.Serve.Food.Models.Entreprise;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Persistence Layer
 */
public class EntrepriseRepository {

    private static EntrepriseRepository instance = null;
    final Logger logger = LoggerFactory.getLogger(EntrepriseRepository.class);

    private EntrepriseRepository() {
    }
    public static synchronized EntrepriseRepository getInstance(){
        if(instance == null){
            instance = new EntrepriseRepository();
        }
        return instance;
    }

    public List<Entreprise> getAll(){
        List<Entreprise> entreprises = new ArrayList<>();
        try{
            Connection connection= DatabaseConnection.getInstance().getConnection();
            logger.debug("connection in repository" +connection);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from entreprise");
            while (rs.next()){
                Entreprise entreprise = new Entreprise();

                entreprise.setId(rs.getString("id"));
                entreprise.setName(rs.getString("name"));
                entreprise.setPhonenumber(rs.getString("phonenumber"));
                entreprise.setSecondphonenumber(rs.getString("secondphonenumber"));
                entreprise.setEmail(rs.getString("email"));
                entreprise.setAddress(rs.getString("address"));
                entreprise.setHourlyrate(rs.getDouble("hourlyRate"));
                entreprise.setDescription(rs.getString("description"));

                entreprises.add(entreprise);

            }

        }catch (SQLException e){
            e.getStackTrace();

        }finally {
            DatabaseConnection.getInstance().closeConnection();
        }
        return entreprises;
    }


}
