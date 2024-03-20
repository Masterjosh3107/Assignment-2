import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GenericsKbAVLApp {
    private AVLTree<Entry> tree = new AVLTree<>();
    private ArrayList<String> terms = new ArrayList<>();
    private int opCountInsert;
    private int aveCount;
    public Boolean btn1Clicked = false;
    public static Boolean btn2Clicked = false;

    public static void main(String[] args) {
        GenericsKbAVLApp App = new GenericsKbAVLApp();
        GUI GUI = new GUI();

        GUI.start();
        JButton btn1 = GUI.getButton1();
        btn1.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //loadQuery("Experiment_Testing_Values");
                GUI.part1();
            }
        });

        JButton btn2 = GUI.getButton2();
        btn2.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GUI.part2();
            }
        });

        //App.runPart1();
    }

    private void runPart1(){
        loadDataset(50000);
        searchTerm();
        System.out.println("Comparisions = " + tree.opCount);
        System.out.println("Inserts = " + opCountInsert);
        System.out.println("Average case for inserts: " + aveCount/5);
    }

    private void runPart2(){
        for(int i = 5; i < 50001; i *= 10){
            i--;
            loadDataset(i);
            searchTerm();
            System.out.println("Comparisions = " + tree.opCount);
            System.out.println("Inserts = " + opCountInsert);
            i++;
        }
        System.out.println("Average case for inserts: " + aveCount/5);
    }

    private void loadDataset(int num) {
        try{
            opCountInsert = 1;
            System.out.println(num);
            BufferedReader file = new BufferedReader(new FileReader("GenericsKB.txt"));
            for (int i = 0; i < num; i++){
                String line = file.readLine();
                String[] parts = line.split("\t");
                Double score = Double.parseDouble(parts[2]);
                Entry entry = new Entry(parts[0], parts[1], score);
                tree.insert(entry); 
                opCountInsert++;
            }
            aveCount += opCountInsert;
            file.close();
        }
        catch (IOException e){
            System.out.println("\nCould not find dataset file.\n");
        }
    }

    private void loadQuery(String fileName){
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = file.readLine()) != null){
                terms.add(line);
            }
            System.out.println("\nKnowledge base loaded successfully.\n");
            file.close();
        } catch (Exception e) {
            System.out.println("\nCould not find query file.\n");
        }
    }

    private void searchTerm() {
        if (terms != null){
            for(int i=0; i<5000;i++){
                Entry entry = new Entry(terms.get(i), null, null);
                if (tree.find(entry) != null){
                    BinaryTreeNode<Entry> node = tree.find(entry);
                    System.out.println(node.data.getTerm() + ": " + node.data.getStatement() + " (" + node.data.getScore() + ")");
                }
                else{
                    System.out.println("Term not found: " + entry.getTerm());
                }
            }
        }
    }

}