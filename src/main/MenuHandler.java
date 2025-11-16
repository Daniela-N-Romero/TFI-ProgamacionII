/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Models.Pedido;
import Models.Estado;
import Service.PedidoServiceImpl;
import Models.Envio;
import Models.TipoEnvio;
import Models.Empresa;
import Models.EstadoEnvio;
import java.time.LocalDate; // << NECESITAS IMPORTAR LocalDate
import java.util.InputMismatchException;
import java.util.Scanner;
import Service.PedidoServiceImpl; // Asumo que esta es tu implementación

/**
 *
 * @author Daniela Nahir Romero
 */
public class MenuHandler {
    
    private final Scanner scanner;
    private final PedidoServiceImpl pedidoService;
    
    //Constructor con inyección de dependencias, valida que las dependencias no sean null.
    public MenuHandler(Scanner scanner, PedidoServiceImpl pedidoService) {
        if(scanner == null) {
            throw new IllegalArgumentException("Scanner no puede ser null");
        }
        if(pedidoService == null) {
            throw new IllegalArgumentException("PedidoService no puede ser null");
        }
        this.scanner = scanner;
        this.pedidoService = pedidoService;
    }
    
    
    public void crearPedido() {
        try { 
            System.out.print("Numero de pedido: ");
            String numero = scanner.nextLine().trim();
            System.out.print("Nombre del cliente: ");
            String nombreCliente = scanner.nextLine().trim();
            System.out.print("Total: ");
            double total = Double.parseDouble(scanner.nextLine().trim());
            Estado estado = Estado.NUEVO;
            
            Envio envio = null;
            System.out.print("¿Desea agregar un nuevo envio? (s/n): ");
            if(scanner.nextLine().trim().equalsIgnoreCase("s")) {
                envio = crearEnvio();
            }
            LocalDate fechaPedido = LocalDate.now(); //Generamos la fecha como "hoy"
            
            //Llamamos al constructor de Pedido
            Pedido pedido = new Pedido(numero, fechaPedido, numero, total, estado, envio, 0L);
            //Insertamos el pedido
            pedidoService.insertar(pedido);
            //Mostramos el mensaje de exito por pantalla
            System.out.println("Pedido creado exitosamente con ID: " + pedido.getId());
        } catch (NumberFormatException e) {
            System.err.println("Error: El campo 'total' debe ser un número válido");
        } catch (Exception e) {
            System.err.println("Error al crear el pedido " + e.getMessage());
        }
    }
    
    public Envio crearEnvio() {
        try {
            System.out.println("Codigo alfanumerico de tracking: ");
            String tracking = scanner.nextLine().trim();
            System.out.println("Costo del envio: ");
            double costo = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("Empresa de envio (ANDREANI, OCA, CORREO_ARG)");
            Empresa empresa = Empresa.valueOf(scanner.nextLine().trim().toUpperCase());
            System.out.println("Tipo de envio (ESTANDAR, EXPRESS)");
            TipoEnvio tipo = TipoEnvio.valueOf(scanner.nextLine().trim().toUpperCase());
            //Para el estado del envio, siempre comenzará por EN_PREPARACION
            EstadoEnvio estado = EstadoEnvio.EN_PREPARACION;
            System.out.println("Estado inicial del envio: " + estado.name());
            //Para la fechaDespacho le ponemos por defecto 1 día despues de "hoy"
            LocalDate fechaDespacho = LocalDate.now().plusDays(1);
            System.out.println("Fecha del despacho (mañana): " + fechaDespacho);
            //Para la fecha estimada le ponemos por defecto 5 días despues de "hoy"
            LocalDate fechaEstimada = LocalDate.now().plusDays(5);
            System.out.println("\"Fecha del despacho (mañana): " + fechaEstimada);
            
            //Creamos el objeto Envio con su Constructor completo.
            Envio envio = new Envio(tracking, costo, fechaDespacho, fechaEstimada, empresa, estado, tipo, 0L);
            System.out.println("Datos de Envío recopilados correctamente.");
            return envio;
            
        } catch (NumberFormatException e) {
            System.err.println("Error: El campo 'total' debe ser un número válido");
            return null;
        } catch(IllegalArgumentException e) {
            System.err.println("Error de Enum: La empresa o el tipo de envío ingresado no es válido.");
            return null;
        } catch (Exception e) {
            System.err.println("Error al crear el Envio " + e.getMessage());
            return null;
        }
    }
}

    
