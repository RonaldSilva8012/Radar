package com.radar;

import java.util.Scanner;

public class Radar {

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Qual a velocidade maxima da via (km/h)? ");
            int limiteVia = scanner.nextInt();
            
            if (limiteVia <= 0) {
                System.out.println("Limite de via invalido.");
                return;
            }
   
            System.out.print("Qual a velocidade do seu veiculo (km/h)? ");
            int velocidadeMedida = scanner.nextInt();

            if (velocidadeMedida < 0) {
                System.out.println("Velocidade invalida.");
                return;
            }

            // Regra CONTRAN: 7 km/h de desconto até 107 km/h; acima disso, aplica-se 7%
            int margemTolerancia;
            if (velocidadeMedida <= 107) {
                margemTolerancia = 7;
            } else {
                margemTolerancia = (int) Math.round(velocidadeMedida * 0.07);
            }

            int velocidadeConsiderada = velocidadeMedida - margemTolerancia;

            System.out.println("\n--- RESULTADO DA FISCALIZACAO ---");
            System.out.println("Velocidade Medida: " + velocidadeMedida + " km/h");
            System.out.println("Velocidade Considerada: " + velocidadeConsiderada + " km/h");
            System.out.println("---------------------------------");

            if (velocidadeConsiderada <= limiteVia) {
                System.out.println("Situação: Nao ha infracao.");
            } else if (velocidadeConsiderada <= limiteVia * 1.20) { 
                // Até 20% acima do limite (72 km/h)
                System.out.println("Infracao: MEDIA");
                System.out.println("Pontos na CNH: 4");
                System.out.println("Valor da Multa: R$ 130,16");
                System.out.println("Penalidades: Conversão em advertencia por escrito (se não reincidente em 12 meses).");
            } else if (velocidadeConsiderada <= limiteVia * 1.50) { 
                // Entre 20% e 50% acima do limite (90 km/h)
                System.out.println("Infracao: GRAVE");
                System.out.println("Pontos na CNH: 5");
                System.out.println("Valor da Multa: R$ 195,23");
                System.out.println("Penalidades: Nenhuma extra.");
            } else { 
                // Mais de 50% acima do limite
                System.out.println("Infracao: GRAVISSIMA");
                System.out.println("Pontos na CNH: 7");
                System.out.println("Valor da Multa: R$ 880,41");
                System.out.println("Penalidades: Suspensao direta do direito de dirigir (de 2 a 8 meses).");
            }
        } catch (Exception e) {
            System.out.println("Entrada invalida. Digite apenas números inteiros.");
        }
    }
}