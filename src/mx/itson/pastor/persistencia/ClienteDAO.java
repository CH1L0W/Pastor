/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.persistencia;

import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author marit
 */
public class ClienteDAO {
    public static List<Cliente> obtenerTodos(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, nombre, direccion, telefono, email FROM cliente");
            while(resultSet.next()){
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setDireccion(resultSet.getString(3));
                c.setTelefono(resultSet.getString(4));
                c.setEmail(resultSet.getString(5));
                clientes.add(c);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        return clientes;
    }
    
    public static boolean guardar(String nombre, String direccion, String telefono, String email){
        boolean resultado = false;
        try {
            Connection connection = Conexion.obtener();
            String consulta = "INSERT INTO cliente (nombre, direccion, telefono, email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, telefono);
            statement.setString(4, email);
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
        } catch (Exception e) {
            System.out.println("Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
    public static boolean comprobarEmail(String email){
        boolean existencia = false;
        try {
            Connection connection = Conexion.obtener();
            String consulta = "Select * FROM cliente WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            existencia = resultSet.next();
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        return existencia;
    }
    
    public static boolean editar(String nombre, String direccion, String telefono, String email, int id) {
        boolean resultado = false;
        try {
            Connection coneccion = Conexion.obtener();

            String consulta = "UPDATE cliente SET nombre = ?, direccion = ?, telefono = ?, email = ? WHERE id = ?";
            PreparedStatement statement = coneccion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, telefono);
            statement.setString(4, email);
            statement.setInt(5, id);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
        }
        return resultado;
    }
    
    public static boolean Eliminar(int id) {
        boolean resultado = false;
        try {

            Connection coneccion = Conexion.obtener();

            String consulta = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement statement = coneccion.prepareStatement(consulta);
            statement.setInt(1, id);
            statement.execute();

            resultado = statement.getUpdateCount() == 1;
        } catch (Exception e) {
            System.out.println("Hubo un error al eliminar " + e.getMessage());
        }
        return resultado;
    }
    
    public static Cliente obtenerPorId(int id){
        Cliente cliente = new Cliente();
        try {
            Connection connection = Conexion.obtener();
            String consulta = "SELECT id, nombre, direccion, telefono, email FROM cliente WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.execute();
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        return cliente;
    }
    ///Hola, este es un comentarioS
}

