/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinica.Controlador;
import java.util.List;
import Clinica.Modelo.daoLogin;
/**
 *
 * @author visitante
 */
public class clsLogin {
    private int pk_idUser;
    private String usuario;
    private String contraseña;
    private int estado;

    public int getPk_idUser() {
        return pk_idUser;
    }

    public void setPk_idUser(int pk_idUser) {
        this.pk_idUser = pk_idUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public clsLogin() {
    }

    public clsLogin(int pk_idUser) {
        this.pk_idUser = pk_idUser;
    }

    public clsLogin(int pk_idUser, String usuario) {
        this.pk_idUser = pk_idUser;
        this.usuario = usuario;
    }

    public clsLogin(int pk_idUser, String usuario, String contraseña) {
        this.pk_idUser = pk_idUser;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public clsLogin(int pk_idUser, String usuario, String contraseña, int estado) {
        this.pk_idUser = pk_idUser;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
    }
    
    
    @Override
    public String toString() {
        return "clsUsuario{" + "IdUsuario=" + pk_idUser + ", NombreUsuario=" + usuario + ", ContrasenaUsuario=" + contraseña + ", EstatusUsuario=" + estado +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsLogin getBuscarInformacionUsuarioPorNombre(clsLogin usuario)
    {
        daoLogin daousuario = new daoLogin();
        return daousuario.consultaUsuariosPorNombre(usuario);
    }
    public clsLogin getBuscarInformacionUsuarioPorId(clsLogin usuario)
    {
        daoLogin daousuario = new daoLogin();
        return daousuario.consultaUsuariosPorId(usuario);
    }    
    public List<clsLogin> getListadoUsuarios()
    {
        daoLogin daousuario = new daoLogin();
        List<clsLogin> listadoUsuarios = daousuario.consultaUsuarios();
        return listadoUsuarios;
    }
    public int setBorrarUsuario(clsLogin usuario)
    {
        daoLogin daousuario = new daoLogin();
        return daousuario.borrarUsuarios(usuario);
    }          
    public int setIngresarUsuario(clsLogin usuario)
    {
        daoLogin daousuario = new daoLogin();
        return daousuario.ingresaUsuarios(usuario);
    }              
    public int setModificarUsuario(clsLogin usuario)
    {
        daoLogin daousuario = new daoLogin();
        return daousuario.actualizaUsuarios(usuario);
    }              
}
