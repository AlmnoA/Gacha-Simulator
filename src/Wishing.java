import java.util.*;

import java.io.*;

//TODO
//reading files as input for pools(csv)
//writing to csv
//pity system
public class Wishing {

    private List<thing> allOutcomes = new ArrayList<thing>();
    private List<thing> threeThings = new ArrayList<thing>();
    private List<thing> fourThings = new ArrayList<thing>();
    private List<thing> fiveThings = new ArrayList<thing>();
    private List<thing> rateUpFourThings = new ArrayList<thing>();
    private List<thing> rateUpFiveThings = new ArrayList<thing>();
    Rates FourStarRates;
    Rates FiveStarRates;

    Wishing() {
        FiveStarRates = new Rates(510, 10, 10, 0);
        FourStarRates = new Rates(60, 90, 74, 600);
    }

    Wishing(Rates FiveStar, Rates FourStar) {
        FiveStarRates = FiveStar;
        FourStarRates = FourStar;

    }

    Wishing(Rates FiveStar, Rates FourStar, List<thing> Outcomes) {
        FiveStarRates = FiveStar;
        FourStarRates = FourStar;
        allOutcomes = Outcomes;
        SortOutcomes();
    }

    public thing summonThing() {
        return summonThing(new Random().nextLong());
    }

    public thing summonThing(long RNGSeed) {
        Random random = new Random(RNGSeed);
        int result = random.nextInt(10000);
        FiveStarRates.currentPity++;
        FourStarRates.currentPity++;
        if (FiveStarRates.currentPity >= FiveStarRates.softPity) {
            FiveStarRates.addSoftPity();
        }
        if (result <= FiveStarRates.realRate || FiveStarRates.currentPity == FiveStarRates.pity) {
            FiveStarRates.resetPity();
            if (FiveStarRates.rateUp && !rateUpFiveThings.isEmpty()) {
                FiveStarRates.rateUp = false;
                return rateUpFiveThings.get(random.nextInt(rateUpFiveThings.size()));
            } else {
                if (random.nextBoolean())
                    return rateUpFiveThings.get(random.nextInt(rateUpFiveThings.size()));
                FiveStarRates.rateUp = true;
                return fiveThings.get(random.nextInt(fiveThings.size()));
            }
        } else if (result <= FourStarRates.realRate || FourStarRates.currentPity == FourStarRates.pity) {
            FourStarRates.resetPity();
            if (FourStarRates.rateUp && !rateUpFourThings.isEmpty()) {
                FourStarRates.rateUp = false;
                return rateUpFourThings.get(random.nextInt(rateUpFourThings.size()));
            } else {
                if (random.nextBoolean()) {
                    return rateUpFourThings.get(random.nextInt(rateUpFourThings.size()));
                }
                FourStarRates.rateUp = true;
                return fourThings.get(random.nextInt(fourThings.size()));
            }
        } else {
            return threeThings.get(random.nextInt(threeThings.size()));
        }
    }

    public void setOutcomes(List<thing> a) {
        allOutcomes = a;
        SortOutcomes();
    }

    public void ReadOutcomesFromCSV(String filename) throws Exception{
    BufferedReader reader=new BufferedReader(new FileReader(filename));
    reader.readLine();//throw header line out
    for(String i=reader.readLine();i!=null;i=reader.readLine()){
        String[] temp=i.split(",");
        thing.Rarity rare=null;//stupid
        if(temp[2].equals("3")) rare=thing.Rarity.ThreeStar;
        else if(temp[2].equals("4")) {rare=thing.Rarity.FourStar;}
        else if(temp[2].equals("4^")) {rare=thing.Rarity.RateUpFourStar;}
        else if(temp[2].equals("5")) {rare=thing.Rarity.FiveStar;}
        else if(temp[2].equals("5^")) {rare=thing.Rarity.RateUpFiveStar;}
        allOutcomes.add(new thing(rare,temp[0],temp[1]));
    }
        SortOutcomes();
    }

    public void addOutcome(thing e) {
        allOutcomes.add(e);
        SortOutcomes();
    }

    public void addOutcome(thing.Rarity rare, String Name, String Discription) {
        thing e = new thing(rare, Name, Discription);
        addOutcome(e);
    }

    private void SortOutcomes() {
        threeThings.clear();
        fourThings.clear();
        fiveThings.clear();
        rateUpFourThings.clear();
        rateUpFiveThings.clear();
        for (thing Thing : allOutcomes) {
            switch (Thing.getRarity()) {
                case ThreeStar:
                    threeThings.add(Thing);
                    break;
                case FourStar:
                    fourThings.add(Thing);
                    break;
                case RateUpFourStar:
                    rateUpFourThings.add(Thing);
                    break;
                case FiveStar:
                    fiveThings.add(Thing);
                    break;
                case RateUpFiveStar:
                    rateUpFiveThings.add(Thing);
                    break;

            }
        }
    }

    public void exportCSV() throws Exception {

        BufferedWriter writer = new BufferedWriter(new FileWriter("WishingOutcomesList.csv"));
        writer.write("Name,Description,Rarity\n");
        for (thing thing : allOutcomes) {
            writer.write(thing.toCSV());
        }
        writer.flush();
    }
}