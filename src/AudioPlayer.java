import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class AudioPlayer {
    //Sets a string with the default file path
    String filePath = "/resources/audio/audio";
    //Sets attribute HashMap, that matches audiofilepath with room objects.
    HashMap<Room, String> audioFilePaths;
    //Defines Clip attribute for later use
    Clip clip;
    //Defines boolean for disabling and enabling music.
    private boolean musicEnabled = true;
    //Defines Room object for the current room.
    private Room currentRoom;

    public AudioPlayer(Room[] roomList) {
        //Instantiates Hashmap
        audioFilePaths = new HashMap<>();
        //Loop for setting and adding each filepath to the value, and setting a room object as a key.
        for (int i = 0; i < roomList.length; i++) {
            audioFilePaths.put(roomList[i], filePath + (i + 1) + ".wav");
        }
    }


    public void startAudio(Room room) {
        //Sets players room to this attributes currentroom.
        currentRoom = room;
        //Checks if music is enabled
        if (musicEnabled) {
            //Gets file from filepath and inserts it into an InputStream.
            try (InputStream is = getClass().getResourceAsStream(audioFilePaths.get(room))) {
                AudioInputStream ais;
                //If inputStream is null, it could not fine the filepath. This usually indicates, that the program
                //build is being run, and not from the IntelliJ project tree.
                if (is == null) {
                    //Makes a file Object instead, as this can access files outside this directory, which audio files
                    //are located when in IntelliJ directory tree.
                    File newFilePath = new File("resources/" + audioFilePaths.get(room));
                    ais = AudioSystem.getAudioInputStream(newFilePath);
                } else {
                    //BIS is used instead of File object, to avoid mark and reset compilation Exception
                    BufferedInputStream bis = new BufferedInputStream(is);
                    ais = AudioSystem.getAudioInputStream(bis);
                }
                //Checks if AudioSystem object is null. If yes then no audiofiles where found.
                if (ais != null) {
                    //Create audioformat object to get audiofiles format.
                    AudioFormat format = ais.getFormat();
                    //Create Dalaline.Info class that inserts the Clip class and the format from AudioFormat.
                    //Used to get info regarding audiofile for use in AudioSystem, which is downcast into Clip.
                    DataLine.Info info = new DataLine.Info(Clip.class, format);
                    clip = (Clip) AudioSystem.getLine(info);
                    //Opening the audiofile.
                    clip.open(ais);
                    //Setting the audiofile to loop, until stopped.
                    clip.loop(Clip.LOOP_CONTINUOUSLY);


                } else {
                    System.out.println("Audio file not found: " + audioFilePaths.get(room));
                }
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                System.out.println("Error playing the file: " + e.getMessage());
            }
        }
    }

    //Toggles the audio from off to on.
    public void toggleAudio() {
        //Checks if the clip is null. If yes it has never been instantiated. Usually means the music has been disabled
        //From the start.
        if (clip != null) {
            //Checks if music is enabled and if the clip is running. If it is not, check if music is enabled, if it is, then
            //start the music. If it isn't always try to stop the music, as music is disabled.
            if (musicEnabled && clip.isRunning()) {
                clip.stop();
            } else if (musicEnabled) {
                clip.start();
            } else {
                clip.stop();
            }
        } /*else {
            return;
        }

        if (clip != null) {
            clip.isRunning();
        }*/
    }

    public String userToggleMusic() {
        //Reverts boolean when user wished to toggle the music.
        musicEnabled = !musicEnabled;
        //If the music has been started, start audio. Else stop the audio.
        if (musicEnabled) {
            startAudio(currentRoom);
        } else {
            toggleAudio();
        }
        //Returns string for userinterface to print.
        return musicEnabled ? "Music has been enabled" : "Music has been disabled";
    }


}
