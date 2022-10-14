/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;
import mx.itson.pastor.entidades.Cuenta;

/**
 *
 * @author marit
 */
public class CuentaDAO {
    public static List<Cuenta> obtenerTodos(){
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("""
                                                         SELECT cu.id, cu.numero, cl.id, cl.nombre, cl.direccion, cl.telefono, cl.email 
                                                         FROM cuenta cu INNER JOIN cliente cl
                                                         ON cu.idCliente = cl.id
                                                         """);
            while(resultSet.next()){
                Cuenta cuenta = new Cuenta();
                cuenta.setId(resultSet.getInt(1));
                cuenta.setNumero(resultSet.getString(2));
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(3));
                c.setNombre(resultSet.getString(4));
                c.setDireccion(resultSet.getString(5));
                c.setTelefono(resultSet.getString(6));
                c.setEmail(resultSet.getString(7));
                cuenta.setCliente(c);
                cuentas.add(cuenta);
                
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        return cuentas;
    }
    
    public static boolean guardar(String cuenta, int idCliente){
        boolean resultado = false;
        try {
            Connection connection = Conexion.obtener();
            String consulta = "INSERT INTO cliente (cuenta, idCLiente) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, cuenta);
            statement.setInt(2, idCliente);
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
        } catch (Exception e) {
            System.out.println("Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
    public static List<Cuenta> obtenerCuenta(){
        List<Cuenta> numeros = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT numero FROM cuenta");
            
            while(resultSet.next()){
                Cuenta c = new Cuenta();
                c.setNumero(resultSet.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error: "+e.getMessage());
        }
        return numeros;
    }
}
