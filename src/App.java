
// writing results to csv

import java.io.BufferedWriter;
import java.io.FileWriter;

public class App {

    public static void main(String[] args) throws Exception {
        Wishing Wish = new Wishing(new Rates(60, 90, 75, 600), new Rates(510, 10, 10, 0));// honkais rates about
        Wish.ReadOutcomesFromCSV("WishingOutcomes.csv");
        int i = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.csv"));
        writer.write("Name,Description,Rarity,5 Star pity,4 Star pity\n");

        while (true) {
            i++;
            int a = Wish.FiveStarRates.currentPity;
            int b = Wish.FourStarRates.currentPity;
            thing aThing = Wish.summonThing();
            if (aThing.getRarity() == thing.Rarity.FiveStar || aThing.getRarity() == thing.Rarity.RateUpFiveStar)
                writer.write(aThing.toCSV() + "," + a + "," + b + "\n");
                
            if (i == 100000)
                break;
        }
        Wish.exportCSV();
    }
}
