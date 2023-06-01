package controller;

import java.util.Map;

public interface IUsuarioController
{
    public String login(String user, String password);
    public String Create(String user, String password, String name, String email, String lastname1, String lastname2);
    public String pedir(String user);
}
