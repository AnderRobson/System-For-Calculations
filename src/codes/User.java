package codes;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    /** Mensagem caso usuario não seja identificado.*/
    private final String NONEXISTENT_USER = "Usuário inexistente !";

    /** Mensagem caso a senha não corresponda ao usuário informado.*/
    private final String INVALID_PASSWORD = "Senha inválida !";

    /** Mensagem caso o login seja feito com sucesso.*/
    private final String SUCCESS = "Logado com sucesso !";

    /** Login do usuário.*/
    private String login;

    /** Senha do usuário.*/
    private byte password[];

    /**
     * Método construtor para teste.
     *
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public User () throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.login = "admin";
        String newPassword = "1234";

        MessageDigest Security = MessageDigest.getInstance("MD5");
        this.password = Security.digest(newPassword.getBytes(StandardCharsets.UTF_8));

    }

    /**
     * Método construtor com sobrecarga para criar usuário.
     *
     * @param login
     * @param password
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public User (String login, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.login = login;

        MessageDigest Security = MessageDigest.getInstance("MD5");
        this.password = Security.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Pegar mensagem de usuário inexistente.
     *
     * @return String
     */
    public String getNONEXISTENT_USER() {
        return NONEXISTENT_USER;
    }

    /**
     * Pegar mensagem de senha inválida.
     *
     * @return String
     */
    public String getINVALID_PASSWORD() {
        return INVALID_PASSWORD;
    }

    /**
     * Pegar mensagem de logado com sucesso.
     *
     * @return String
     */
    public String getSUCCESS () {
        return this.SUCCESS;
    }

    /**
     * Pegar nome do usuario logado.
     *
     * @return String
     */
    public String getLogin () {
        return this.login;
    }

    /**
     * Atualizar login.
     *
     * @param login
     */
    public void setLogin (String login) {
        this.login = login;
    }

    /**
     * Método desativado por motivos de segurança.
     * @return
     */
    private byte[] getPassword () {
        return this.password;
    }

    public void setPassword (String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest Security = MessageDigest.getInstance("MD5");
        this.password = Security.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Método responsavel por validar Login.
     *
     * @param login
     * @param password
     * @return String
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String validateLogin (String login, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (this.login.equals(login)) {
            MessageDigest Security = MessageDigest.getInstance("MD5");
            byte[] securePassword = Security.digest(password.getBytes(StandardCharsets.UTF_8));

            if (! MessageDigest.isEqual(securePassword, this.getPassword())) {
                return this.INVALID_PASSWORD;
            }

            return this.SUCCESS;
        } else {
            return this.NONEXISTENT_USER;
        }
    }
}
