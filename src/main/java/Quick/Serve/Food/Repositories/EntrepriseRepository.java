package Quick.Serve.Food.Repositories;

import Application.DatabaseConnection;
import Quick.Serve.Food.Models.Entreprise;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.*;
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

        }
        return entreprises;
    }

    public Entreprise addEntreprise(Entreprise entreprise){

        PreparedStatement preparedStatement = null;
        int rowAffected = 0;
        try{

            Connection connection = DatabaseConnection.getInstance().getConnection();
            StringBuilder sql= new StringBuilder("INSERT INTO entreprise (id, name, phonenumber, secondphonenumber, email, address, hourlyRate, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement = connection.prepareStatement(String.valueOf(sql));
            preparedStatement.setString(1, entreprise.getId());
            preparedStatement.setString(2, entreprise.getName());
            preparedStatement.setString(3, entreprise.getPhonenumber());
            preparedStatement.setString(4, entreprise.getSecondphonenumber());
            preparedStatement.setString(5, entreprise.getEmail());
            preparedStatement.setString(6, entreprise.getAddress());
            preparedStatement.setDouble(7, entreprise.getHourlyrate());
            preparedStatement.setString(8, entreprise.getDescription());
            rowAffected = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.getStackTrace();

        }finally {
            try {
                preparedStatement.close();
                //DatabaseConnection.getInstance().closeConnection();
            }catch (SQLException e){
                e.getStackTrace();
            }

        }
        return (rowAffected > 0) ? entreprise : null;
    }



}
