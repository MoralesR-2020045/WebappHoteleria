/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techtitans.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Donovan Morales
 */
@Entity
public class MetodoDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodoPago;
    private String nombreDelMetodo;

    public MetodoDePago() {
    }

    public MetodoDePago(int idMetodoPago, String nombreDelMetodo) {
        this.idMetodoPago = idMetodoPago;
        this.nombreDelMetodo = nombreDelMetodo;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreDelMetodo() {
        return nombreDelMetodo;
    }

    public void setNombreDelMetodo(String nombreDelMetodo) {
        this.nombreDelMetodo = nombreDelMetodo;
    }
}

    
