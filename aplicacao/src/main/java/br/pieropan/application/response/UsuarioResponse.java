package br.pieropan.application.response;

public class UsuarioResponse {

    private Long id;

    private String email;

    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UsuarioResponse(Long id, String email, String login) {
        this.id = id;
        this.email = email;
        this.login = login;
    }

    public UsuarioResponse() {
    }
}