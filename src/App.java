
// writing results to csv

import java.io.BufferedWriter;
import java.io.FileWriter;

public class App {

    public static void main(String[] args) throws Exception {
        Wishing Wish = new Wishing(new Rates(60, 90, 74, 600), new Rates(510, 10, 10, 0));// honkais rates
        Wish.ReadOutcomesFromCSV("WishingOutcomes.csv");
        int i = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.csv"));
        writer.write("Name,Description,Rarity,5 Star pity,4 Star pity\n");

        while (true) {
            i++;
            thing aThing = Wish.summonThing();
            writer.write(aThing.toCSV() + "," + Wish.FiveStarRates.currentPity + "," + Wish.FourStarRates.currentPity
                    + "\n");
            if (i == 10000)
                break;
        }
        Wish.exportCSV();
    }
}
