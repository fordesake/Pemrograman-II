package soal1;

import java.util.Random;

public class Dadu {
    private int nilai;
    private static final Random random = new Random();

    public Dadu() {
        acakNilai();
    }

    public void acakNilai() {
        this.nilai = random.nextInt(6) + 1;
    }

    public int getNilai() {
        return nilai;
    }
}
