package pl.reslay.configs;

import pl.reslay.*;

public class Config {
    private String messageBow, messageSnowball, messageFishingRod;

    public void loadConfiguration() {
        this.messageBow = Main.getInstance().getConfig().getString("messages.bow");
        this.messageSnowball = Main.getInstance().getConfig().getString("messages.snowball");
        this.messageFishingRod = Main.getInstance().getConfig().getString("messages.fishing_rod");
    }

    public String getMessageBow() {
        return messageBow;
    }

    public String getMessageSnowball() {
        return messageSnowball;
    }

    public String getMessageFishingRod() {
        return messageFishingRod;
    }
}