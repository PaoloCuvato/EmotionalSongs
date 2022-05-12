package emotionalsongs;

/**
 * Le sue istanze rappresentano tutto ciò che viene associato all'emozione/alle emozioni seleionate
 * @author Paradiso Fabiola
 */

public class Percezione { 
    
    private final Emozione emozione;
    private final int score;
    private final String note;
    private final String songId;
    private final String userId;

    /**
     * Costruisce un oggetto che contiene i dati associati all'emozione/alle emozioni selezionate
     * @param emozione l'emozione selezionata
     * @param score il punteggio che rappresenta il grado si intensità dell'emozione provata
     * @param note il piccolo spazio di testo in cui poter specificare ulteriori dettagli riguardo all'emozione provata
     * @param songId il nome della canzone associato all'emozione
     * @param userId il nome utente che seleziona 'emozione provata
     */
    //costruttore

    public Percezione(Emozione emozione, int score, String note, String songId, String userId) {
        this.emozione = emozione;
        this.score = score;
        this.note = note;
        this.songId = songId;
        this.userId = userId;
    }

    //getter
    /**
     * Restituisce l'emozione provata rappresentata dall'oggetto che esegue il metodo
     * @return l'emozione selezionata
     */

    public Emozione getEmozione() {
        return emozione;
    }

    /**
     * Restituisce il punteggio di intensità dell'emozione provata rappresentata dall'oggetto che esegue il metodo
     * @return il punteggio di intensità dell'emozione
     */

    public int getScore() {
        return score;
    }

    /**
     * Restituisce lo spazio di testo per inserire dettagli sull'emozione rappresentata dall'oggetto che esegue il metodo
     * @return lo spazio di testo
     */

    public String getNote() {
        return note;
    }

    /**
     * Restituisce il nome della canzone associata all'emozione rappresentata dall'oggetto che esegue il metodo
     * @return il nome della canzone
     */

    public String getSongId() {
        return songId;
    }

    /**
     * Restituisce il nome dell'utente che ha selezionato l'emozione rappresentata dall'oggetto che esegue il metodo
     * @return il nome dell'utente
     */

    public String getUserId() {
        return userId;
    }
}

