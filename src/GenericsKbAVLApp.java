import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GenericsKbAVLApp {
    private AVLTree<Entry> tree = new AVLTree<>();
    private static ArrayList<String> terms = new ArrayList<>();
    private ArrayList<Integer> randomNumbers = new ArrayList<>();
    private ArrayList<Entry> subsetData = new ArrayList<>();
    private int aveCountInsert = 0;
    private int aveCountComparison = 0;

    public static void main(String[] args) {
        GenericsKbAVLApp App = new GenericsKbAVLApp();
        App.loadFullDataBase();
        GUI GUI = new GUI();
        GUI.start();

        JButton btn3 = GUI.getButton3();
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadQuery("Experiment_Testing_Values.txt");
                App.runPart1();
            }
        });

        JButton btn5 = GUI.getButton4();
        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadQuery("GenericsKB-queries.txt");
                App.runPart2();
            }
        });
    
        JButton btnBack1 = GUI.getBackButton1();
        btnBack1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Clicked Back 1");
            }
        });

        JButton btnBack2 = GUI.getBackButton2();
        btnBack2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Clicked Back 2");
            }
        });
    
    }


    private void runPart1(){
        for(int i = 5; i <= 50000; i *= 10){
            i--;
            loadDataset(i);
            searchTerm(terms.size());
            System.out.println("\nComparisions = " + tree.opSearchCount);
            System.out.println("Inserts = " + tree.opInsertCount + "\n");
            i++;

            aveCountComparison += tree.opSearchCount;
            aveCountInsert += tree.opInsertCount;
            tree.opSearchCount = 0;
            tree.opInsertCount = 1;
        }
        System.out.println("Average case for inserts: " + aveCountInsert/5);
        System.out.println("Average case for comparisons: " + aveCountComparison/5);
        aveCountComparison = 0;
        aveCountInsert = 0;
    }

    private void runPart2(){
        for(int i = 5; i <= 50000; i *= 10){
            i--;
            generateSubset(i);
            loadDataset(i);
            searchTerm(terms.size());
            searchTermSubset(randomNumbers.size());
            System.out.println("\nComparisions = " + tree.opSearchCount);
            System.out.println("Inserts = " + tree.opInsertCount + "\n");
            i++;

            aveCountComparison += tree.opSearchCount;
            aveCountInsert += tree.opInsertCount;
            tree.opSearchCount = 0;
            tree.opInsertCount = 1;
        }
        System.out.println("Average case for inserts: " + aveCountInsert/5);
        System.out.println("Average case for comparisons: " + aveCountComparison/5);
        aveCountComparison = 0;
        aveCountInsert = 0;
    }

    private void loadFullDataBase(){
        try{
            BufferedReader file = new BufferedReader(new FileReader("GenericsKB.txt"));
            for (int i = 0; i < 50000; i++){
                String line = file.readLine();
                String[] parts = line.split("\t");
                Double score = Double.parseDouble(parts[2]);
                Entry entry = new Entry(parts[0], parts[1], score);
                subsetData.add(entry);
            }
            file.close();
        }
        catch (IOException e){
            System.out.println("\nCould not find dataset file.\n");
        }
    }

    private void loadDataset(int num) {
        try{
            BufferedReader file = new BufferedReader(new FileReader("GenericsKB.txt"));
            for (int i = 0; i < num; i++){
                String line = file.readLine();
                String[] parts = line.split("\t");
                Double score = Double.parseDouble(parts[2]);
                Entry entry = new Entry(parts[0], parts[1], score);
                tree.insert(entry); 
            }
            file.close();
        }
        catch (IOException e){
            System.out.println("\nCould not find dataset file.\n");
        }
    }

    private static void loadQuery(String fileName){
        try {
            terms.clear();
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

    private void searchTerm(int num) {
        if (terms != null){
            for(int i=0; i<num;i++){
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

    private void searchTermSubset(int num){
        if (subsetData != null){
            for(int i=0; i<num;i++){
                Entry entry = subsetData.get(randomNumbers.get(i));
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

    private void generateSubset(int num){
        try {
            randomNumbers.clear();
            Random random = new Random();
            while (randomNumbers.size() < num){  //change 5 to num
                int randNum = random.nextInt(50000);
                if (!randomNumbers.contains(randNum)){
                    randomNumbers.add(randNum);
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("Subset.txt"));
            for (int i = 0; i < randomNumbers.size(); i++){
                Entry entry = subsetData.get(randomNumbers.get(i));
                String line = entry.getTerm();
                writer.write(line);
                writer.newLine();
            }   
            writer.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

}