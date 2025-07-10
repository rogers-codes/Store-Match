import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o limite do seu cartão");
        double limite = leitor.nextDouble();
        double saldo = limite;
        var cartao = new Cartao (limite,saldo);

        int option = 1;
        while (option != 0) {
            System.out.println("Digite o item da sua compra");
            String descricao = leitor.next();
            System.out.println("Digite o valor");
            double valor = leitor.nextDouble();
            var compra = new Compra(descricao,valor);

            boolean compraRealizada = cartao. lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("COMPRA REALIZADA!");
                System.out.println("Digite 1 para continuar com as compras ou 0 para sair");
                option = leitor.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                option = 0;
            }

        }

        System.out.println("//////////////////");
        System.out.println("COMPRAS REALIZADAS: \n");
        Collections.sort(cartao.getCompras());
        for (Compra c: cartao.getCompras()){
            System.out.println(c.getDescricao() + " Valor: " + c.getValor());
        }
        System.out.println("/////////////////");
        System.out.println("Saldo do cartão: " + cartao.getSaldo());
    }
}
