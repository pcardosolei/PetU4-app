package pet4u.pet4u;

/**
 * Created by Rafael on 14/12/2016.
 */

public class User {

    private String nome;
    private String email;
    private String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
