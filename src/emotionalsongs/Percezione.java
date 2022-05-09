package emotionalsongs;

public class Percezione { 
    
    private final Emozione emozione;
    private final int score;
    private final String note;
    private final String songId;
    private final String userId;

    public Percezione(Emozione emozione, int score, String note, String songId, String userId) {
        this.emozione = emozione;
        this.score = score;
        this.note = note;
        this.songId = songId;
        this.userId = userId;
    }

    public Emozione getEmozione() {
        return emozione;
    }

    public int getScore() {
        return score;
    }

    public String getNote() {
        return note;
    }

    public String getSongId() {
        return songId;
    }

    public String getUserId() {
        return userId;
    }
}

