
package se.johan.oh.dataaccess;


import se.johan.oh.containers.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class PersonDataAccess {

    /**
     * @param person to create
     */
    public int create(Person person) {
        int id = -1;
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Person.INSERT_PERSONAL_INFO_SQL,Statement.RETURN_GENERATED_KEYS);
            prepare(preparedStatement, person, false);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                id= rs.getInt(1);
            }
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return id;
    }

    /**
     *
     * @param userID
     */
    public void delete(int userID){
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Person.DELETE_PERSONAL_INFO_SQL);
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println(exception);
        }
    }

    /**
     *
     * @param person
     */
    public void update(Person person){
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Person.UPDATE_PERSONAL_INFO_SQL);
            prepare(preparedStatement, person, true);
            preparedStatement.executeUpdate();
           
        } catch (SQLException exception) {
            System.err.println(exception);
        }
    }


    /**
     * @return
     */
    public List<Person> readAll(){
        List<Person> persons = new ArrayList<>();
        try (Connection conn = ConnectionHelper.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Person.SELECT_PERSONAL_INFO_SQL);
            String[] columns = Person.COLUMNS;
            while (rs.next()) {
                Person person = new Person();
                parseResultset(rs, person);
                persons.add(person);
            }
        } catch (SQLException exception) {
            System.err.println();
        }
        return persons;
    }

    /**
     * @param userID
     * @return
     */
    public Person read(int userID){
        Person person = null;
        try (Connection conn = ConnectionHelper.getConnection()) {          
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(Person.SELECT_PERSONAL_INFO_SQL);
            while (rs.next()) {
                person = new Person();
                parseResultset(rs, person);
            }
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return person;
    }
    
    
    
    private void prepare(PreparedStatement preparedStatement, Person person, boolean isUpdate) throws SQLException {
        preparedStatement.setInt(1, person.getUserID());
        preparedStatement.setString(2, person.getFirstName());
        preparedStatement.setString(3, person.getMiddleName());
        preparedStatement.setString(4, person.getLastName());
        preparedStatement.setString(5, person.getEmail());
        preparedStatement.setString(6, person.getCountry());
        preparedStatement.setString(7, person.getStreetAddress());
        preparedStatement.setString(8, person.getCity());
        preparedStatement.setString(9, person.getPostalCode());
        if (isUpdate) {
            preparedStatement.setInt(10, person.getUserID());
        }

    }

    private void parseResultset(ResultSet rs, Person person) throws SQLException {
        String[] columns = Person.COLUMNS;
        person.initPerson(
                rs.getInt(columns[0]),
                rs.getString(columns[1]),
                rs.getString(columns[2]),
                rs.getString(columns[3]),
                rs.getString(columns[4]),
                rs.getString(columns[5]),
                rs.getString(columns[6]),
                rs.getString(columns[7]),
                rs.getString(columns[8]));
    }

}
