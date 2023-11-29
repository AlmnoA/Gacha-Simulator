import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class thing {
    public enum Rarity {
        ThreeStar,
        FourStar,
        RateUpFourStar,
        FiveStar,
        RateUpFiveStar
    };

    private Rarity rarity;
    private String name;
    private String discription;
    private BufferedImage image=null;
    private String imgFilePath=null;

    public boolean loadImage() {
        try {
            image = ImageIO.read(new File(imgFilePath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getImagePath() {
        return imgFilePath;
    }

    public void setImage(String imgPath) {
        imgFilePath = imgPath;
        loadImage();
    }

    public void setName(String x) {
        name = x;
    }

    public void setDiscription(String x) {
        discription = x;
    }

    public void setRarity(Rarity x) {
        rarity = x;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public Rarity getRarity() {
        return rarity;
    }

    thing() {
        name = "mario";
        rarity = Rarity.ThreeStar;
        discription = "fucker used the wrong constructior";
    }

    thing(Rarity rarity1, String Name, String Discription) {
        rarity = rarity1;
        discription = Discription;
        name = Name;
    }

    thing(Rarity rarity1, String Name, String Discription, String imagePath) {
        rarity = rarity1;
        discription = Discription;
        name = Name;
        imgFilePath = imagePath;
        loadImage();
    }

    public String toString() {
        String temp = "Name:" + name.toString() + "| Discription:" + discription;
        switch (rarity) {
            case ThreeStar:
                temp += "| Rarity:3 Star";
                break;
            case FourStar:
                temp += "| Rarity:4 Star";
                break;
            case RateUpFourStar:
                temp += "| Rarity:4^ Star";
                break;
            case FiveStar:
                temp += "| Rarity:5 Star";
                break;
            case RateUpFiveStar:
                temp += "| Rarity: 5^ Star";
                break;
            default:
                temp += "Rarity:How the fuck";
                break;
        }
        return temp + "| " + imgFilePath;
    }

    public String toCSV() {
        String temp = "";
        switch (rarity) {
            case ThreeStar:
                temp += "3";
                break;
            case FourStar:
                temp += "4";
                break;
            case RateUpFourStar:
                temp += "4^";
                break;
            case FiveStar:
                temp += "5";
                break;
            case RateUpFiveStar:
                temp += "5^";
                break;
            default:
                temp += "How the fuck";
                break;
        }
        if (imgFilePath != null) {
            return name + "," + discription + "," + temp + "," + imgFilePath;
        }
        return name + "," + discription + "," + temp;
    }

    public boolean equals(thing thing2) {
        return (this.name.equals(thing2.name) && (this.rarity == thing2.rarity)
                && (this.discription.equals(thing2.discription)));
    }
}
