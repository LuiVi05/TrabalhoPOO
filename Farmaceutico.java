public class Farmaceutico extends Utilizador {
    private String NIF;
    private String morada;
    private String contactoTelefonico;

    public Farmaceutico(String aLogin, String aPassword, String aNome, boolean aIsActive, String aEmail, String aNIF,
            String aMorada, String aContactoTelefonico) {
        super(aLogin, aPassword, aNome, aIsActive, aEmail, "farmaceutico");
        this.NIF = aNIF;
        this.morada = aMorada;
        this.contactoTelefonico = aContactoTelefonico;
    }

    public String getNIF() {
        return NIF;
    }

    public String getContactoTelefonico() {
        return contactoTelefonico;
    }
}
