package Properties;

import java.io.InputStream;
import java.util.Properties;

public class Reader {

    private final Properties configProps = new Properties();

    public Reader() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (in == null) {
            throw new Exception("config.properties not found in classpath");
        }
        configProps.load(in);
    }

    public int getPrestigePointToWin() {
        return Integer.parseInt(configProps.getProperty("prestigePointsToWin"));
    }

    public int getNumOfPlayers() {
        return Integer.parseInt(configProps.getProperty("numOfPlayers"));
    }
    public int getNumOfCards(){
        return Integer.parseInt(configProps.getProperty("numOfCards"));
    }

    public int getCustomTokenMode(){
        return Integer.parseInt(configProps.getProperty("enableCustomToken"));
    }

    // In token class, the token names are all in capital letters, but the name of token in the properties file are all in lower case
    // in order to avoid the caller cannot find the name, change all the characters to upper case. 
    public int getColourToken(String str){
        String value = configProps.getProperty(str);
        if(value == null){
            value = configProps.getProperty(str.toUpperCase());
        }
        if(value == null){
            value = configProps.getProperty(str.toLowerCase());
        }
        if(value == null) {
            throw new IllegalArgumentException("Missing token config for color: " + str);
        }
        return Integer.parseInt(value);
    }
    public String getTierDeck(int tier){
        return configProps.getProperty("tier"+tier+"DeckDir");
    }
}
