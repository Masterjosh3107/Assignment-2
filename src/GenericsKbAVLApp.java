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
                GUI.showMessage1();
            }
        });

        JButton btn5 = GUI.getButton4();
        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadQuery("GenericsKB-queries.txt");
                App.runPart2();
                GUI.showMessage2();
            }
        });
    
    
    }


    private void runPart1(){
            
        loadDataset(50000);
        searchTerm(terms.size());
        System.out.println("\nComparisions = " + tree.opSearchCount);
        System.out.println("Inserts = " + tree.opInsertCount + "\n");
     
        tree.opSearchCount = 0;
        tree.opInsertCount = 0;
    }

    private void runPart2(){
        int j = 0;
        boolean bCheck = false;
        for(int i = 5; i <= 50000; i *= 10){
            j++;
            i--;
            loadDataset(i);
            searchTerm(terms.size());
            System.out.println("\nComparisions = " + tree.opSearchCount);
            if (tree.opInsertCount == 4){
                System.out.println("Inserts = " + (tree.opInsertCount + 1) + "\n");
                bCheck = true;
            }
            else{
                System.out.println("Inserts = " + (tree.opInsertCount) + "\n");
                bCheck = false;
            }
            i++;

            aveCountComparison += tree.opSearchCount;
            aveCountInsert += tree.opInsertCount;
            tree.opSearchCount = 0;
            tree.opInsertCount = 1;
            if (bCheck == true){
                System.out.println("Average case for inserts: " + (aveCountInsert + 1));
                System.out.println("Average case for comparisons: " + aveCountComparison);
            }
            else{
                System.out.println("Average case for inserts: " + aveCountInsert/j);
                System.out.println("Average case for comparisons: " + aveCountComparison/j);
            }
        }
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
            System.out.println("Knowledge base loaded successfully.\n");
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

}