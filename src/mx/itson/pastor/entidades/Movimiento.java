/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.entidades;

import java.util.Date;
import mx.itson.pastor.enumerador.TipoMovimiento;

/**
 *
 * @author marit
 */
public class Movimiento {
    private int id;
    private String concepto;
    private Date fecha;
    private double importe;
    private TipoMovimiento tipo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the importe
     */
    public double getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * @return the tipo
     */
    public TipoMovimiento getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }
}
