import java.util.HashMap;

class UserAuthentication {
    private HashMap<String, String> users = new HashMap<>();

    public UserAuthentication() {
        // Predefined users (username, password)
        users.put("admin", "admin123");
        users.put("user", "user123");
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
