
package javineavantureigrica;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Gvozdenovic Certified Java Develeoper
 */
public class JavineAvantureIgrica {

    
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        Random rand=new Random();
        
        
        System.out.println("=====================================================");
        System.out.println("== Dobrodosao u igricu Javine Avanture ==============");
        System.out.println("======================--kreirao David Gvozdenovic--==\n");
        System.out.print("Unesi svoje korisnicko ime: ");
        String korisnickoIme=s.nextLine();
        System.out.println();
        
        //kolicina neprijatelja i njihovi atributi
        String[] neprijatelji={"𝗦𝗸𝗲𝗹𝗲𝘁𝗼𝗻","𝗭𝗼𝗺𝗯𝗶","𝗥𝗮𝘁𝗻𝗶𝗸","𝗨𝗯𝗶𝗰𝗮"};
        int maxZdravljeNeprijatelja = 75;
        int neprijateljNapad = 25;
        
        //atributi igraca,igrice
        int zdravlje=100;
        int igracNapad = 50;
        int brojNapitakaZdralja=3;
        int kolicinaNapitkaZdravlja=30;
        int napitakZdravljaSansa = 50; //procentaza
        
        boolean igrivo=true;
        
        System.out.println("\n"+korisnickoIme+" Dobro dosao u javinu jazbinu!");
        
        IGRA:
        while(igrivo){
            System.out.println("=====================================================");
            
            int zdravljeNeprijatelja = rand.nextInt(maxZdravljeNeprijatelja);
            String neprijatelj = neprijatelji[rand.nextInt(neprijatelji.length)];
            System.out.println("\t# "+neprijatelj+" se pojavio! (◣_◢)\n");
            
                while(zdravljeNeprijatelja>0){
                    System.out.println("\tTvoje zdravlje:  ➕ "+zdravlje);
                    System.out.println("\t"+neprijatelj+" zdravlje: ➕ "+zdravljeNeprijatelja);
                    System.out.println("\n\tSta zelis da uradis?");
                    System.out.println("\t1. Napadni                  ⚔");
                    System.out.println("\t2. Popij napitak zdravlja   💉");
                    System.out.println("\t2. Bezi!                    🏃");

                    String unos=s.nextLine();
                    System.out.println("=====================================================");
                    
                    if(unos.equals("1")){
                        int nanetoStete = rand.nextInt(igracNapad);
                        int primljenoStete=rand.nextInt(neprijateljNapad);

                        zdravljeNeprijatelja -=nanetoStete;
                        zdravlje -=primljenoStete;

                        System.out.println("\t> Napao si "+neprijatelj+" sa "+nanetoStete+" stete.");
                        System.out.println("\t> Primio si "+primljenoStete+" stete zauzvrat!\n");
                        
                        if(zdravlje <1 ){
                            System.out.println("\t>Primio si previse stete.Preslab si da nastavis");
                            break;
                        }
                    }
                    else if(unos.equals("2")){
                        if(brojNapitakaZdralja >0){
                            zdravlje+=kolicinaNapitkaZdravlja;
                            brojNapitakaZdralja--;
                            System.out.println("\t> Popio si napitak zdravlja,ozdravio si za "+kolicinaNapitkaZdravlja+"."
                            +"\n\t> Sada imas "+zdravlje+" zdravlja."
                            +"\n\t> Imas jos "+brojNapitakaZdralja+" napitaka zdravlja.\n");
                        }else{
                            
                            System.out.println("\t> Nemas napitaka zdravlja na stanju!Ubij neprijatelje za sansu da dobijes jedan");

                        }
                    }
                    else if(unos.equals("3")){
                        System.out.println("\t>Pobegao si od "+neprijatelj+"!");
                        continue IGRA;
                    }
                    else{
                        System.out.println("\tNepravilan unos!");
                    }
                }
            
            if(zdravlje<1){
                System.out.println("Pobegao si iz jazbine,preslab si da se boris");
                break;
            }
            
            System.out.println("=====================================================");
            System.out.println(" # "+neprijatelj + " je porazen! #");
            System.out.println(" # Imas "+zdravlje+" zdravlja. #");
            
            if(rand.nextInt(100) < napitakZdravljaSansa){
                brojNapitakaZdralja++;
                System.out.println(" # "+neprijatelj+" je ispustion napitak zdravlja! # ");
                System.out.println(" # Sada imas "+brojNapitakaZdralja+" napitaka zdravlja. #");
            }
            
            System.out.println("=====================================================");
            System.out.println("Sta zelis da uradis?");
            System.out.println("1. Nastavi da se boris");
            System.out.println("2. Izadji iz Jazbine");
            
            String unos=s.nextLine();
            
            while(!unos.equals("1") && !unos.equals("2")){
                System.out.println("Pogresan unos");
                unos =s.nextLine();
            }
            
            if(unos.equals("1")){
                System.out.println("Nastavljas sa svojom avanturom");
            }else if(unos.equals("2")){
                System.out.println("Izasao si iz jazbine uspesno,cestitam!");
                break;
            }
        }
        for(int i=3;i>0;i--){
            System.out.println("=========================="+i+"==========================");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavineAvantureIgrica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("=========== Hvala sto si igrao moju igru! ===========");
        System.out.println("=====================================================");
    }
    
}
