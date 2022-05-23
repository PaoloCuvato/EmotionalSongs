package emotionalsongs;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmotionalSongs {

    public static void main(String[] args) throws IOException {

        int r;
        Canzoni canzoni = new Canzoni();
        Persone persone = new Persone();
        //Authentication authentication = new Authentication(); non serve, spego lundeì differenza DA ELIMINARE
        Scanner sc = new Scanner(System.in);

        do {
            //stampiamo il menù iniziale
            System.out.println(" *** Fai la tua scelta *** \n " +
                    "\t 1. Ricerca di un brano per titolo \n" +
                    "\t 2. Ricerca di un brano per autore e anno \n" +
                    "\t 3. Visualizza le emozioni \n" +
                    "\t 4. Registrazione \n" +
                    "\t 5. Accedi \n" +
                    "\t 6. Crea una playlist \n" +
                    "\t 7. Inserisci le emozioni \n" +
                    "\t 0. Esci dal programma \n");
            System.out.print("Inserisci l'intero corrispondente alla tua scelta: ");
            r = sc.nextInt();
            //inserisci l'errore per avere letto il tipo sbagliato  (InputMismatchException)


            //Ora inizio con le operazioni nei diversi casi
            switch (r) {
                case 1:
                    System.out.println("Inserisci il titolo da cercare: ");
                    String titolo = sc.nextLine();
                    List<Canzone> possibiliTitoli = canzoni.cercaBranoMusicale(titolo);
                    if( possibiliTitoli.isEmpty() ){
                        System.out.println("Nessun brano trovato.");
                        break;   //mi fa uscire dallo switch
                    }
                    possibiliTitoli.toString();
                    //@TODO riscrivere metodo toString()
                    break;

                case 2:
                    System.out.println("Inserisci l'autore da cercare: ");
                    String autore = sc.nextLine();
                    System.out.println("Inserisci l'anno da cercare: ");
                    int anno = sc.nextInt();
                    List<Canzone> possibiliBrani = canzoni.cercaBranoMusicale(autore, anno);
                    if( possibiliBrani.isEmpty() ){
                        System.out.println("Nessun brano trovato. ");
                        break;
                    }
                    possibiliBrani.toString();
                    break;

                case 3:

                case 4:
                    System.out.println("Inserisci i tuoi dati per registrarti all'applicazione.");
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Cognome: ");
                    String cognome = sc.nextLine();
                    System.out.println("Codice Fiscale: ");
                    String codiceFiscale = sc.nextLine();
                    System.out.println("Indirizzo fisico: ");
                    String indirizzoFisico = sc.nextLine();
                    System.out.println("E-mail: ");
                    String email = sc.nextLine();
                    System.out.println("Password: ");
                    String password = sc.nextLine();
                    System.out.println("UserID: ");
                    String userId = sc.nextLine();
                    Persona newPersona = new Persona(nome, cognome, codiceFiscale, indirizzoFisico, email, password, userId );
                    if( persone.Registrazione(newPersona) ){
                        System.out.println( "La registrazione è andata a buon fine. Ora puoi eseguire l'accesso.");
                        break;
                    }else{
                        System.out.println( "Hai già effettutato la registrazione. Puoi eseguire l'accesso.");
                    };
                    break;

                case 5:
                    if( Authentication.isLogged() ){
                        String userIdConnesso = (Authentication.getLoggedAs()).getUserId();
                        System.out.println("Impossibile effettuare l'accesso: utente " + userIdConnesso + "già connesso.");
                        System.out.println("Effettuare il LogOut? (S/N)");
                        char check = sc.next().charAt(0);
                        while( check != 'S' && check != 'N' ){
                            System.out.println("Il valore inserito non è valido. Prego reinserire S o N.");
                            check = sc.next().charAt(0);
                        }
                        if( check == 'S'){
                            Authentication.logOut();
                            System.out.println("Ora puoi effettuare l'accesso.");
                        }else{
                            System.out.println("Continua come utente " + userIdConnesso);
                            break;
                        }
                    }
                    System.out.println("Inserisci UserId e password scelti in fase di registrazione.");
                    System.out.println("UserID: ");
                    userId = sc.nextLine();
                    System.out.println("Password: ");
                    password = sc.nextLine();
                    if( persone.accedi(userId, password) ){
                        System.out.println("Accesso riuscito. Ora puoi creare playlist e inserire le tue emozioni.");
                    }else{
                        System.out.println("Accesso non riuscito. Devi prima effettuare la registrazione. ");
                    }
                    break;

                case 6:

                    break;

                case 0:
                    System.out.println("Ciao.");
                    break;

                default:
                    System.out.println("Il valore inserito non e' corretto. \n");
                    System.out.print("Reinserire scelta:");
                    r = sc.nextInt();
            }


            sc.close();


        }while( r != 0 );
    }
}
