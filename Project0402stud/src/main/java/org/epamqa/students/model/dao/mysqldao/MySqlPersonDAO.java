package org.epamqa.students.model.dao.mysqldao;

import org.epamqa.students.model.connection.MySqlConnectionManager;
import org.epamqa.students.model.dao.PersonDAO;
import org.epamqa.students.model.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 04.02.2016.
 */
public class MySqlPersonDAO extends PersonDAO {


    /**
     * Queries
     */
    private final String GET_PERSON_QUERY = "SELECT stud_id, last_name, name, profession, weight FROM persons WHERE stud_id = ?";
    private final String ADD_PERSON_QUERY = "INSERT INTO persons (stud_id, last_name, name, profession, weight) VALUES (?, ?, ?, ?, ?)";
    private final String GET_LIST_QUERY = "SELECT stud_id, last_name, name, profession, weight FROM persons ";
    private final String DEL_PERSON_QUERY = "DELETE FROM persons WHERE stud_id = ?";
    private final String UPDATE_PERSON_QUERY  = "UPDATE persons SET last_name = ?, name=?, profession=?, weight=? WHERE stud_id = ?";

    /**
     * Constructor
     */
    public MySqlPersonDAO() {
        super(MySqlConnectionManager.getInstace());
    }

    @Override
    public List<Person> getListPersons() {
            List<Person> persons = new ArrayList<>();

            try (Connection connection = connectionManager.getConnection();
                 PreparedStatement statement = connection.prepareStatement(GET_LIST_QUERY)) {

                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    int idFromSQL  = rs.getInt("stud_id");
                    String lastName = rs.getString("last_name");
                    String firstName = rs.getString("name");
                    String professionString = rs.getString("profession");
                    char professionCode = professionString.charAt(0);
                    float weightNumber = rs.getFloat("weight");
                    persons.add(new Person(idFromSQL, lastName, firstName, professionCode, weightNumber));
                }
            } catch (SQLException e) {
			    e.printStackTrace();
            }

            return persons;
    }


    @Override
    public Person getPerson(int id) {
        Person person = null;

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PERSON_QUERY)) {
            statement.setString(1, Integer.toString(id));
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int idFromSQL  = rs.getInt("stud_id");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("name");
                String professionString = rs.getString("profession");
                char professionCode = professionString.charAt(0);
                float weightNumber = rs.getFloat("weight");

                person = new Person(idFromSQL, lastName, firstName, professionCode, weightNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public boolean swapPersons(int id, int id2)  {
        Person person = getPerson(id);
        Person person2 = getPerson(id2);
        if((person2 == null)||(person == null)){
            return false;
        }
        try (Connection connection = connectionManager.getConnection();
                PreparedStatement statement  = connection.prepareStatement(UPDATE_PERSON_QUERY);
                PreparedStatement statement2 = connection.prepareStatement(UPDATE_PERSON_QUERY)){
            connection.setAutoCommit(false);
//            statement.setString(1, Integer.toString(person2.getId()));
//            statement2.setString(1, Integer.toString(person.getId()));


            statement.setString(1, person2.getLastName());
            statement.setString(2, person2.getName());
            statement.setString(3, ""+person2.getProfessionCode());
            statement.setFloat(4, person2.getWeightPerson());
            statement.setInt(5,person.getId());

            statement2.setString(1,null);
            statement2.setString(1, person.getLastName());
            statement2.setString(2, person.getName());
            statement2.setString(3, ""+person.getProfessionCode());
            statement2.setFloat(4, person.getWeightPerson());
            statement2.setInt(5,person2.getId());

            statement.executeUpdate();
            statement2.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Person deletePerson(int id) {
        Person person = getPerson(id);
        if(person != null){
            try (Connection connection = connectionManager.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DEL_PERSON_QUERY)) {
                connection.setAutoCommit(false);
                statement.setInt(1, id);
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                return null;
            }
        }
        return person;
    }

    @Override
    public boolean createPerson(Person person) {

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_PERSON_QUERY)) {
            statement.setString(1,null);
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getName());
            statement.setString(4, ""+person.getProfessionCode());
            statement.setFloat(5, person.getWeightPerson());

            int res = statement.executeUpdate();

            if (res == 0) {
                return false;
            }
        } catch (SQLException e) {
			e.printStackTrace();
            return false;
        }

        return true;
    }

}
