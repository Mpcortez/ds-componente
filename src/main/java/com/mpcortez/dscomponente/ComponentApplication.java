package com.mpcortez.dscomponente;

import com.mpcortez.dscomponente.entities.Order;
import com.mpcortez.dscomponente.exception.EntryException;
import com.mpcortez.dscomponente.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ComponentApplication implements CommandLineRunner {

    private final OrderService orderService;

    public ComponentApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ComponentApplication.class, args);
    }

    @Override
    public void run(String... args) {
        var order = entry();

        orderTotal(order);
    }

    private Order entry() throws EntryException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int code;
        double basic, discount;

        try {
            System.out.print("Código: ");
            code = sc.nextInt();
            System.out.print("Valor Básico: ");
            basic = sc.nextDouble();
            System.out.print("Desconto: ");
            discount = sc.nextDouble();
            sc.close();
        } catch (IllegalStateException | InputMismatchException e) {
            throw new EntryException("Erro na entrada de dados. Por favor, insira os dados corretamente.");
        }

        return Order.builder().code(code).basic(basic).discount(discount).build();
    }

    private void orderTotal(Order order) {
        System.out.println();
        System.out.println("Pedido código " + order.getCode());
        System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
    }
}
