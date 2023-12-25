package Application;

import Quick.Serve.Food.Models.DatabaseProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private Connection connection;
    static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    DatabaseProperties dbcon = new DatabaseProperties();

    /**
     * creating a connection object
     */
    public DatabaseProperties getDbProps(String DATABASE_PROPERTIES) throws IOException{
        InputStream dataBaseConnection= this.getClass().getClassLoader().getResourceAsStream("database.properties");
        Properties props= new Properties();
        props.load(dataBaseConnection);
        dbcon.setUrl(props.getProperty("url"));
        dbcon.setUsername(props.getProperty("username"));
        dbcon.setPassword(props.getProperty("password"));
        return dbcon;
    }
    /**
     * creating a connection object
     * Private constructor to prevent direct instantiation from outside the class
     */
    private DatabaseConnection (){
        try {
            DatabaseProperties dbconnection;
            dbconnection = getDbProps("database.properties");
            connection = DriverManager.getConnection(dbconnection.getUrl(),dbconnection.getUsername(), dbconnection.getPassword());
            logger.info("Connexion : " + connection);
        }catch (SQLException | IOException e){
            e.getStackTrace();
        }
    }
    /**
     * Static method to retrieve the unique instance of the connection
     */
    public static synchronized DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        logger.debug("instance : " + instance);
        return instance;
    }
    /**
     * Method to get database connection
     */
    public Connection getConnection() {
        return connection;
    }
    /**
     * Method to close database connection
     */
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
