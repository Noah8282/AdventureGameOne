import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class AudioPlayer {
    String filePath = "/resources/audio/audio";
    HashMap<Room, String> audioFilePaths;
    Clip clip;
    public AudioPlayer(Room[] roomList) {
        // Change this to the path of your WAV file
        audioFilePaths = new HashMap<>();

        for (int i = 0; i < roomList.length; i++) {
            audioFilePaths.put(roomList[i], filePath + (i + 1) + ".wav");
        }
    }


    public void startAudio(Room room) {





        try (InputStream is = getClass().getResourceAsStream(audioFilePaths.get(room))) {
            AudioInputStream ais;
            if(is == null) {
                System.out.println("ran");
                File newFilePath = new File("resources/"+audioFilePaths.get(room));
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
                clip.start();

                System.out.println("Playing: " + audioFilePaths.get(room));
            } else {
                System.out.println("Audio file not found: " + audioFilePaths.get(room));
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.out.println("Error playing the file: " + e.getMessage());
        }
    }

    public void stopAudio() {
        clip.stop();
    }
}