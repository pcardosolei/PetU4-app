package pet4u.pet4u.user;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Rafael on 30/01/2017.
 * Package: ${PACKAGE_NAME}.
 * Project: Pet4U.
 */


public class AccountDTO implements Serializable{

    private boolean activated;
    private String[] authorities;
    private int clienteId;
    private int clinicaId;
    private String email;
    private String firstName;
    private int id;
    private String langKey;
    private String lastName;
    private String login;
    private int veterinarioId;

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(int clinicaId) {
        this.clinicaId = clinicaId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(int veterinarioId) {
        this.veterinarioId = veterinarioId;
    }
    @Override
    public String toString() {
        return "AccountDTO{" +
                "activated=" + activated +
                ", authorities=" + Arrays.toString(authorities) +
                ", clienteId=" + clienteId +
                ", clinicaId=" + clinicaId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", langKey='" + langKey + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", veterinarioId=" + veterinarioId +
                '}';
    }

}
