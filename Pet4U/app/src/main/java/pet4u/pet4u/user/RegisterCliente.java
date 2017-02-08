package pet4u.pet4u.user;

/**
 * Created by carlosmorais on 16/12/2016.
 */

public class RegisterCliente {
    private String login;
    private String email;
    private String password;
    private String langKey;

    public RegisterCliente() {
        this.langKey = "pt-pt";
    }

    public RegisterCliente(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.langKey = "pt-pt";
    }

    public String getLogin() { return login; }

    public void setLogin(String username) { this.login = username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterCliente registerCliente = (RegisterCliente) o;

        if (login != null ? !login.equals(registerCliente.login) : registerCliente.login != null) return false;
        if (email != null ? !email.equals(registerCliente.email) : registerCliente.email != null) return false;
        if (password != null ? !password.equals(registerCliente.password) : registerCliente.password != null)
            return false;

        return langKey != null ? langKey.equals(registerCliente.langKey) : registerCliente.langKey == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (langKey != null ? langKey.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}