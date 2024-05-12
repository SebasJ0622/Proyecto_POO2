package com.example.proyecto_poo2;

public class Factura {
    private Cliente cliente;
    private double total;

    public Factura(Cliente cliente, double total) {
        this.cliente = cliente;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
}
