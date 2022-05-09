package emotionalsongs;

public class Percezione { private Emozione emozione;
    private int Score;
    private final String id_canzone;
    private final String id_persona;

    public Percezione(int Score,String id_canzone,String id_persona){
        this.Score= Score;
        this.id_canzone= id_canzone;
        this.id_persona= id_persona;
    }

    public int getScore() { return Score; }

    public void setScore(int Score) { this.Score = Score; }

    public String getId_canzone() { return id_canzone; }

    public String getId_persona() { return id_persona; }

    public Emozione getEmozione() {
        return emozione;
    }

    public void setEmozione(Emozione emozione) {
        this.emozione = emozione;
    }
}

