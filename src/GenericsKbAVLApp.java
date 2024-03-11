import java.io.*;
import java.util.*;

public class GenericsKbAVLApp {
    private AVLTree<Entry> tree;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GenericsKbAVLApp App = new GenericsKbAVLApp();
        App.run();
    }

    public void run(){
        loadFile();
    }
    private void loadFile() {
        try{
            BufferedReader file1 = new BufferedReader(new FileReader("Test.txt"));
            String line;
            while ((line = file1.readLine()) != null){
                String[] parts = line.split("\t");
                Double score = Double.parseDouble(parts[2]);
                Entry entry = new Entry(parts[0], parts[1], score);
                tree.insert(entry); 
            }
            System.out.println("\nKnowledge base loaded successfully.\n");
            file1.close();
        }
        catch (IOException e){
            System.out.println("\nCould not find file.\n");
        }
    }
}