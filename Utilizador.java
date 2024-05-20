public class Utilizador {
    private String login;
    private String password;
    private String nome;
    private boolean isActive;
    private String email;
    private String tipoUtilizador;

    public Utilizador(String aLogin, String aPassword, String aNome, boolean aIsActive, String aEmail, String aTipoUtilizador) {
        this.login = aLogin;
        this.password = aPassword;
        this.nome = aNome;
        this.isActive = aIsActive;
        this.email = aEmail;
        this.tipoUtilizador = aTipoUtilizador;
    }

    protected String getLogin() {
        return login;
    }

    protected String getPassword() {
        return password;
    }

    protected String getNome() {
        return nome;
    }

    protected String getEmail() {
        return email;
    }

    protected String getTipoUtilizador() {
        return tipoUtilizador;
    }

    protected void setPassword(String aPassword) {
        this.password = aPassword;
      }
    
      protected void setNome(String aNome) {
        this.nome = aNome;
      }
    
      protected void setEmail(String aEmail) {
        this.email = aEmail;
      }
   
}