package com.example.proyecto_poo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class FacturacionApp extends Application {

    private Cliente[] clientes = new Cliente[100];
    private Factura[] facturas = new Factura[100];
    private int numClientes = 0;
    private int numFacturas = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Facturacion");

        BorderPane borderPane = new BorderPane();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Button agregarClienteButton = new Button("Agregar com.example.proyecto_poo2.Cliente");
        agregarClienteButton.setOnAction(e -> agregarCliente());

        Button crearFacturaButton = new Button("Crear com.example.proyecto_poo2.Factura");
        crearFacturaButton.setOnAction(e -> crearFactura());

        vbox.getChildren().addAll(agregarClienteButton, crearFacturaButton);
        borderPane.setLeft(vbox);

        primaryStage.setScene(new Scene(borderPane, 400, 300));
        primaryStage.show();

    }

    private void agregarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        System.out.println("Ingrese el telefono del cliente: ");
        String telefonoCliente = sc.nextLine();
        clientes[numClientes] = new Cliente(nombreCliente, telefonoCliente);
        numClientes++;
    }

    private void crearFactura() {
        Scanner sc = new Scanner(System.in);
        if (numFacturas == 0) {
            System.out.println("No hay clientes registrados");
        } else {
            System.out.println("Selecciona un cliente:");
            for (int i = 0; i < numClientes; i++) {
                System.out.println((i+1) + ". " + clientes[i].getNombre());
            }

            int clienteSeleccionado = sc.nextInt();
            sc.nextLine();

            if (clienteSeleccionado > 0 && clienteSeleccionado <=numClientes) {

                System.out.println("Ingrese el total de la factura");
                double totalFactura = sc.nextDouble();
                sc.nextLine();
                facturas[numFacturas] = new Factura(clientes[clienteSeleccionado -1], totalFactura);
                numFacturas++;
                System.out.println("Factura creada correctamente.");
            } else {
                System.out.println("Selección invalida");
            }
        }
    }
}