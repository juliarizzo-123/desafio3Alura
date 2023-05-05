import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        System.out.println("bem vindo");

        System.out.println("Digite o limite do cartão: ");
        Scanner scanner = new Scanner(System.in);
        double limite = scanner.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);


        int i = 1;
        while (i != 0){

            if (i == 1){
                System.out.println("Digite a descriçao: ");
                Scanner scanner1 = new Scanner(System.in);
                String descricao = scanner1.nextLine();

                System.out.println("Digite o valor da compra: ");
                Scanner scanner2 = new Scanner(System.in);
                double valor = scanner2.nextDouble();

                Compra compra = new Compra(descricao, valor);

                boolean compraRealizada = cartao.lancaCompra(compra);

                if (compraRealizada){
                    System.out.println("******* COMPRA REALIZADA *******");
                    System.out.println(" 0 para SAIR \n 1 para CONTINUAR \n Digite sua escolha: ");
                    Scanner leitura = new Scanner(System.in);
                    i = leitura.nextInt();
                }
                else {
                    System.out.println("Saldo insuficiente!");
                    i = 0;
                }
                System.out.println("\nSaldo do cartão: " +cartao.getSaldo());

            }else {
                System.out.println("opçao invalida");
                i = 1;
            }

        }
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());


        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " +c.getValor());
        }

        System.out.println("\n***********************");
        System.out.println("\nSaldo do cartão: " +cartao.getSaldo());
    }
}
