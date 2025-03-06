import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Task 1: Playing Music (Simulated with a loop)
class MusicPlayer extends Thread {
    public void run() {
        try {
            File musicFile = new File("music.wav"); // Ensure "music.wav" is in the project folder
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Wait until the music finishes
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Task 2: Displaying an Image
class ImageDisplay extends Thread {
    public void run() {
        JFrame frame = new JFrame("Image Display");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel(new ImageIcon("fhd.jpg")); // Ensure "example.jpg" is in the project folder
        frame.add(label);
        frame.setVisible(true);
    }
}

// Task 3: Counting Numbers
class Counter extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Counter: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiTaskingApp {
    public static void main(String[] args) {
        MusicPlayer musicThread = new MusicPlayer();
        ImageDisplay imageThread = new ImageDisplay();
        Counter counterThread = new Counter();
        
        // Start all threads
        musicThread.start();
        imageThread.start();
        counterThread.start();
    }
    
}
