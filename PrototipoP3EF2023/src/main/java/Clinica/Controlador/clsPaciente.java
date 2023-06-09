/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinica.Controlador;
import java.util.List;
import Clinica.Modelo.daoPaciente;
/**
 *
 * @author visitante
 */
public class clsPaciente {
    private int pk_idPaciente;
    private String nombrePaci;
    private String apellidoPaci;
    private String FechaNacimiento;
    private int Genero;
    private String direccionPAci;
    private int Telefono;
    private int estadoPaci;
    private int fk_idReferencia;

    public int getPk_idPaciente() {
        return pk_idPaciente;
    }

    public void setPk_idPaciente(int pk_idPaciente) {
        this.pk_idPaciente = pk_idPaciente;
    }

    public String getNombrePaci() {
        return nombrePaci;
    }

    public void setNombrePaci(String nombrePaci) {
        this.nombrePaci = nombrePaci;
    }

    public String getApellidoPaci() {
        return apellidoPaci;
    }

    public void setApellidoPaci(String apellidoPaci) {
        this.apellidoPaci = apellidoPaci;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int Genero) {
        this.Genero = Genero;
    }

    public String getDireccionPAci() {
        return direccionPAci;
    }

    public void setDireccionPAci(String direccionPAci) {
        this.direccionPAci = direccionPAci;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getEstadoPaci() {
        return estadoPaci;
    }

    public void setEstadoPaci(int estadoPaci) {
        this.estadoPaci = estadoPaci;
    }

    public int getFk_idReferencia() {
        return fk_idReferencia;
    }

    public void setFk_idReferencia(int fk_idReferencia) {
        this.fk_idReferencia = fk_idReferencia;
    }

    public clsPaciente() {
    }

    public clsPaciente(int pk_idPaciente) {
        this.pk_idPaciente = pk_idPaciente;
    }

    public clsPaciente(int pk_idPaciente, String nombrePaci) {
        this.pk_idPaciente = pk_idPaciente;
        this.nombrePaci = nombrePaci;
    }

    public clsPaciente(int pk_idPaciente, String nombrePaci, String apellidoPaci) {
        this.pk_idPaciente = pk_idPaciente;
        this.nombrePaci = nombrePaci;
        this.apellidoPaci = apellidoPaci;
    }

    public clsPaciente(int pk_idPaciente, String nombrePaci, String apellidoPaci, String FechaNacimiento) {
        this.pk_idPaciente = pk_idPaciente;
        this.nombrePaci = nombrePaci;
        this.apellidoPaci = apellidoPaci;
        this.FechaNacimiento = FechaNacimiento;
    }

    public clsPaciente(int pk_idPaciente, String nombrePaci, String apellidoPaci, String FechaNacimiento, int Genero) {
        this.pk_idPaciente = pk_idPaciente;
        this.nombrePaci = nombrePaci;
        this.apellidoPaci = apellidoPaci;
        this.FechaNacimiento = FechaNacimiento;
        this.Genero = Genero;
    }

    public clsPaciente(int pk_idPaciente, String nombrePaci, String apellidoPaci, String FechaNacimiento, int Genero, String direccionPAci) {
        this.pk_idPaciente = pk_idPaciente;
        this.nombrePaci = nombrePaci;
        this.apellidoPaci = apellidoPaci;
        this.FechaNacimiento = FechaNacimiento;
        this.Genero = Genero;
        this.direccionPAci = direccionPAci;
    }

    public clsPaciente(int pk_idPaciente, String nombrePaci, String apellidoPaci, String FechaNacimiento, int Genero, String direccionPAci, int Telefono) {
        this.pk_idPaciente = pk_idPaciente;
        this.nombrePaci = nombrePaci;
        this.apellidoPaci = apellidoPaci;
        this.FechaNacimiento = FechaNacimiento;
        this.Genero = Genero;
        this.direccionPAci = direccionPAci;
        this.Telefono = Telefono;
    }

    public clsPaciente(int pk_idPaciente, String nombrePaci, String apellidoPaci, String FechaNacimiento, int Genero, String direccionPAci, int Telefono, int estadoPaci, int fk_idReferencia) {
        this.pk_idPaciente = pk_idPaciente;
        this.nombrePaci = nombrePaci;
        this.apellidoPaci = apellidoPaci;
        this.FechaNacimiento = FechaNacimiento;
        this.Genero = Genero;
        this.direccionPAci = direccionPAci;
        this.Telefono = Telefono;
        this.estadoPaci = estadoPaci;
        this.fk_idReferencia = fk_idReferencia;
    }
    

 
    @Override
    public String toString() {
        return "clsPaciente{" + "id =" + pk_idPaciente    + ", nombre=" + nombrePaci + ", apellido=" + apellidoPaci + ", fecha  =" + FechaNacimiento   + ", genero  =" + Genero + ", direccion  =" + direccionPAci + ", telefono  =" + Telefono + ", estado  =" + estadoPaci + ", referencia  =" + fk_idReferencia + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPaciente getBuscarInformacionPacientePorNombre(clsPaciente Paci)
    {
        daoPaciente daoPaciente = new daoPaciente();
        return daoPaciente.consultaPacientePorNombre(Paci);
    }
    public clsPaciente getBuscarInformacionMonedaPorId(clsPaciente Paci)
    {
        daoPaciente daoPaciente = new daoPaciente();
        return daoPaciente.consultaPacientePorId(Paci);
    }    
    public List<clsPaciente> getListadopaciente()
    {
        daoPaciente daoPaciente = new daoPaciente();
        List<clsPaciente> listadoMonedas = daoPaciente.consultaPaciente();
        return listadoMonedas;
    }
    public int setBorrarpaciente(clsPaciente Paci)
    {
        daoPaciente daoPaciente = new daoPaciente();
        return daoPaciente.borrarPaciente(Paci);
    }          
    public int setIngresarpaciente(clsPaciente Paci)
    {
        daoPaciente daoPaciente = new daoPaciente();
        return daoPaciente.ingresaPaciente(Paci);
    }              
    public int setModificarpaciente(clsPaciente Paci)
    {
        daoPaciente daoPaciente = new daoPaciente();
        return daoPaciente.actualizaPaciente(Paci);
    }              

    public void getPacienteValor(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPacienteValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
