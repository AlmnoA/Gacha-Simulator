public class Rates {
    public int rate;
    public int realRate;
    public int pity;
    public int softPity;
    public int softPityIncrease;
    public int currentPity = 0;
    public boolean rateUp = false;

    Rates() {
        rate = 100;
        realRate = 100;
        pity = 900;
        softPity = 80;
        softPityIncrease = 800;
    }

    Rates(int Rate, int Pity, int SoftPity, int SoftPityIncrease) {
        rate = Rate;
        realRate = Rate;
        pity = Pity;
        softPity = SoftPity;
        softPityIncrease = SoftPityIncrease;
    }

    public void addSoftPity() {
        realRate += softPityIncrease;
    }

    public void resetPity() {
        currentPity = 0;
        realRate = rate;

    }
}