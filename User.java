package SmartHome;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean loggedIn = false;
    private boolean registered = false;
    public User(String firstName, String lastName, String email, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }
    //getter setter
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (password != null && !password.isEmpty() && password.length() >= 6) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
    }



    //register
    public void register() {
        if(!registered) {
            registered = true;
            System.out.println("User registered successfully: " + firstName + " " + lastName);
        } else {
            System.out.println("User is already registered");
        }
    }
    //login
    public void login(String email, String password) {
        if(this.email.equals(email) && this.password.equals(password) && registered) {
            loggedIn = true;
            System.out.println("Logged in successfully: " + firstName + " " + lastName);
        } else {
            System.out.println("Invalid email or password");
        }
    }
    //logout
    public void logout() {
        if(loggedIn) {
            loggedIn = false;
            System.out.println("Logged out successfully");
        } else {
            System.out.println("User is not logged in");
        }
    }
}
