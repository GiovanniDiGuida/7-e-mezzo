import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Benvenuto a 7 e mezzo");
        Random random=new Random();

        Scanner input=new Scanner(System.in);

        boolean condizione= true;

        String[] seme= {"Denari","Coppe","Spade","Bastoni"}; 

        int soldi_giocatore=100;

        
        if (soldi_giocatore>0){
            while (condizione){

                double risultato_giocatore=0;
                double risultato_pc=0;
                boolean condizione_giocatore=true;
                int matta=random.nextInt(2);
                boolean[][] controllo_giocatore= new boolean[10][4];
                boolean[][] controllo_pc=new boolean[10][4];

                System.out.println("I tuoi soldi sono: "+soldi_giocatore+" euro ");

                System.out.println("Quanto vuoi puntare?: ");

                int puntata_giocatore=input.nextInt();
                input.nextLine();
                System.out.println("Hai puntato: "+puntata_giocatore+" euro");

                
                if (puntata_giocatore<=soldi_giocatore){
                    while (risultato_giocatore< 7.5  && condizione_giocatore){

                        int carta_giocatore;
                        int indice_seme_giocatore;
                        do{
                            carta_giocatore=random.nextInt(10)+1;
                            indice_seme_giocatore=random.nextInt(seme.length);
                        }while (controllo_giocatore[carta_giocatore - 1][indice_seme_giocatore]);

                        controllo_giocatore[carta_giocatore - 1][indice_seme_giocatore] = true;

                        String risultato_seme_giocatore=seme[indice_seme_giocatore];

                        
                        System.out.println("Al giocatore è uscito il numero: "+carta_giocatore+" di "+risultato_seme_giocatore);
                        if (carta_giocatore>7){
                            risultato_giocatore+=0.5;
                        }else {
                            risultato_giocatore+=carta_giocatore;
                        }

                        if (risultato_giocatore<7.5){
                            
                            System.out.println("Vuoi girare un'altra carta?: (s/n)");
                            String scelta=input.nextLine();
                            if (scelta.equalsIgnoreCase("s")){
                                System.out.println("Ok hai deciso di girare un'altra carta");
                            }else {
                                System.out.println("Hai deciso di fermarti");
                                System.out.println("Il tuo risultato è: "+risultato_giocatore);
                                condizione_giocatore=false;
                            }
                        }else if (risultato_giocatore==7.5) {
                            System.out.println("hai fatto 7 e mezzo");
                            condizione_giocatore=false;
                        }else {
                            System.out.println("Hai sballato");
                            condizione_giocatore=false;
                        }
                        
                        
                    }
                }else {
                    System.out.println("Non pupi puntare più dei tuoi soldi!!!");
                }
                while (risultato_pc<=4.5 && risultato_pc<=risultato_giocatore){

                    int carta_pc;
                    int indice_seme_pc;
                    do {
                        carta_pc=random.nextInt(10)+1;

                        indice_seme_pc=random.nextInt(seme.length);
                    }while (controllo_pc[carta_pc-1][indice_seme_pc]);

                    controllo_pc[carta_pc-1][indice_seme_pc]=true;
                    
                    
                    String risultato_seme_pc=seme[indice_seme_pc];
                    System.out.println("Al pc è uscito il numero: "+carta_pc+" di "+risultato_seme_pc);
                    if  (carta_pc>7){
                        risultato_pc+=0.5;

                    }else {
                        risultato_pc+=carta_pc;
                    }
                    if (risultato_pc<=4.5){
                        System.out.println("Il pc ha deciso di continuare");
                    }else if (risultato_pc==7.5){
                        System.out.println("Il pc ha fatto 7 e mezzo");
                    }else if(risultato_pc>7.5) {
                        System.out.println("Il pc ha sballato");
                        break;
                    }else {
                        System.out.println("Il pc ha deciso di fermarsi");
                    }

                    System.out.println("Il risultato del pc è: "+risultato_pc);
                }
                if ((risultato_pc<=7.5 && risultato_giocatore<=7.5) || risultato_giocatore==risultato_pc){
                    if (matta==0){
                        System.out.println("Il giocatore fa la matta");
                        if (risultato_giocatore>=risultato_pc){
                            System.out.println("Il giocatore ha vinto la partita");
                            soldi_giocatore+=puntata_giocatore;
                            
                        }else {
                            System.out.println("Il pc ha vinto la partita");
                            soldi_giocatore-=puntata_giocatore;
                        }
                    }else {
                        System.out.println("Il pc fa la matta");
                        if (risultato_pc>=risultato_giocatore){
                            System.out.println("Il pc ha vinto la partita");
                            soldi_giocatore-=puntata_giocatore;

                        }else {
                            System.out.println("Il giocatore ha vinto la partita");
                            soldi_giocatore+=puntata_giocatore;
                        }
                    }
                } else if (risultato_giocatore>7.5){
                    System.out.println("Il pc ha vinto la partita");
                    soldi_giocatore-=puntata_giocatore;

                }else {
                    System.out.println("Il giocatore ha vinto la partita");
                    soldi_giocatore+=puntata_giocatore;
                }
                

                System.out.println("Vuoi giocare ancora?: (s/n)");
                String scelta_rigiocare=input.nextLine();

                if(scelta_rigiocare.equalsIgnoreCase("s")){
                        System.out.println("Hai scelto di fare un'altra partita");
                }else {
                    System.out.println("Grazie per aver utilizzato il gioco");
                    condizione=false;
                }
                
                


        
        }
    }else {
        System.out.println("Hai finito i soldi, non puoi giocare");
    }
    input.close();
}
}
