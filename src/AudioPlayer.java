import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class AudioPlayer {
    private final String fileSep = File.separator;
    String filePath = fileSep+"resources"+fileSep+"audio"+fileSep+"audio";
    HashMap<Room, String> audioFilePaths;
    Clip clip;
    private boolean musicEnabled = false;
    private Room currentRoom;

    public AudioPlayer(Room[] roomList) {
        // Change this to the path of your WAV file
        audioFilePaths = new HashMap<>();

        for (int i = 0; i < roomList.length; i++) {
            audioFilePaths.put(roomList[i], filePath + (i + 1) + ".wav");
        }
    }


    public void startAudio(Room room) {
        currentRoom = room;

        if (musicEnabled) {
            try (InputStream is = getClass().getResourceAsStream(audioFilePaths.get(room))) {
                AudioInputStream ais;
                if (is == null) {
                    File newFilePath = new File("resources"+ fileSep + audioFilePaths.get(room));
                    ais = AudioSystem.getAudioInputStream(newFilePath);
                } else {
                    BufferedInputStream bis = new BufferedInputStream(is);
                    ais = AudioSystem.getAudioInputStream(bis);
                }

                if (ais != null) {
                    AudioFormat format = ais.getFormat();
                    DataLine.Info info = new DataLine.Info(Clip.class, format);
                    clip = (Clip) AudioSystem.getLine(info);
                    clip.open(ais);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);

                } else {
                    System.out.println("Audio file not found: " + audioFilePaths.get(room));
                }
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                System.out.println("Error playing the file: " + e.getMessage());
            }
        }
    }

    public void toggleAudio() {
        if (clip != null) {
            if (musicEnabled && clip.isRunning()) {
                clip.stop();
            } else if (musicEnabled) {
                clip.start();
            } else {
                clip.stop();
            }
        } else {
            return;
        }

        if (clip != null) {
            clip.isRunning();
        }
    }

    public String userToggleMusic() {
        musicEnabled = !musicEnabled;
        if (musicEnabled) {
            startAudio(currentRoom);
        } else {
            toggleAudio();
        }

        return musicEnabled ? "Music has been enabled" : "Music has been disabled";
    }


}