import java.util.ArrayList;

public class GereUtilizador {
    private ArrayList<Utilizador> utilizadores;

    public GereUtilizador() {
        this.utilizadores = new ArrayList<Utilizador>();
    }

    public boolean isEmpty() {
        return utilizadores.isEmpty();
    }

    public void registarUtilizador(Utilizador utilizador) {
        String nif = (utilizador instanceof Cliente || utilizador instanceof Farmaceutico) ? ((Cliente) utilizador).getNIF() : null;
        String contacto = (utilizador instanceof Cliente || utilizador instanceof Farmaceutico) ? ((Cliente) utilizador).getContactoTelefonico() : null;

        if (!verificarUnico(utilizador.getLogin(), utilizador.getEmail(), nif, contacto)) {
            System.out.println("Login, email, NIF ou contacto já existente. Registo falhou.");
            return;
        }
        utilizadores.add(utilizador);
        System.out.println("Utilizador registado com sucesso!");
    }

    public Utilizador autenticarUtilizador(String login, String password) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getLogin().equals(login) && utilizador.getPassword().equals(password)) {
                return utilizador;
            }
        }
        System.out.println("Utilizador não encontrado. Verifique o seu login e password.");
        return null;
    }

    public boolean verificarUnico(String login, String email, String nif, String contacto) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getLogin().equals(login) || utilizador.getEmail().equals(email)) {
                return false;
            }
            if (utilizador instanceof Cliente || utilizador instanceof Farmaceutico) {
                Cliente clienteFarmaceutico = (Cliente) utilizador;
                if ((nif != null && clienteFarmaceutico.getNIF().equals(nif)) || (contacto != null && clienteFarmaceutico.getContactoTelefonico().equals(contacto))) {
                    return false;
                }
            }
        }
        return true;
    }
}
