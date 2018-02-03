/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.containers;

/**
 *
 * @author johan
 */
public class Person {
    
    public static final String [] COLUMNS = {
        "USER_ID", "FIRST_NAME","MIDDLE_NAME", "LAST_NAME","EMAIL","COUNTRY","STREET_ADDRESS","CITY","POSTAL_CODE"
    };
    
    public static final String SELECT_PERSONAL_INFO_SQL ="SELECT * FROM PERSONAL_INFO";
    
    public static final String SELECT_PERSONAL_INFO_BY_ID_SQL ="SELECT * FROM PERSONAL_INFO WHERE USER_ID =";
    
    public static final String INSERT_PERSONAL_INFO_SQL = 
            "INSERT INTO PERSONAL_INFO (USER_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, COUNTRY, STREET_ADDRESS, CITY, POSTAL_CODE) values (?,?,?,?,?,?,?,?,?)";
    public static final String DELETE_PERSONAL_INFO_SQL =" DELETE FROM PERSONAL_INFO WHERE USER_ID = ?";
    
    public static final String UPDATE_PERSONAL_INFO_SQL =
            "UPDATE PERSONAL_INFO SET USER_ID = ?, FIRST_NAME = ?, MIDDLE_NAME = ?, LAST_NAME = ?, EMAIL = ?, COUNTRY = ?, STREET_ADDRESS = ?, CITY = ?, POSTAL_CODE = ? where USER_ID = ? ";
    
    
    private Integer userID;
    private String firstName;
    private String middleName;
    private String lastName;
    
    private String email;
    private String country;
    private String streetAddress;
    private String city;
    private String postalCode;

    /**
     *
     * @param userID
     * @param FirstName
     * @param LastName
     * @param MiddleName
     * @param Email
     * @param Country
     * @param StreetAddress
     * @param City
     * @param postalCode
     */
    public Person(Integer userID, String FirstName, String MiddleName, String LastName, String Email, String Country, String StreetAddress, String City, String postalCode) {
        initPerson(userID, FirstName, MiddleName, LastName, Email, Country, StreetAddress, City, postalCode);
    }
    
    public Person(){}
    
    
    
     /**
     *
     * @param userID
     * @param FirstName
     * @param LastName
     * @param MiddleName
     * @param Email
     * @param Country
     * @param StreetAddress
     * @param City
     * @param postalCode
     */
    public void initPerson(Integer userID, String FirstName, String MiddleName, String LastName, String Email, String Country, String StreetAddress, String City, String postalCode) {
        this.userID = userID;
        this.firstName = FirstName;
        this.middleName = MiddleName;
        this.lastName = LastName;
        this.email = Email;
        this.country = Country;
        this.streetAddress = StreetAddress;
        this.city = City;
        this.postalCode = postalCode;
    }
    
    @Override
    public String toString(){
        return COLUMNS[0]+" :"+userID+", "+COLUMNS[1]+" : "+firstName+", "+
               COLUMNS[2]+" : "+ middleName+", "+COLUMNS[3]+" : "+lastName+", "+
               COLUMNS[4]+" : "+email+", "+COLUMNS[5]+" : "+country+", "+
               COLUMNS[6]+" : "+streetAddress+", "+COLUMNS[7]+" : "+city+", "+COLUMNS[8]+" : "+postalCode;
    }
    

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }



    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
}
