import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateQuery {
       private void generateQuery(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Query.txt"));
            for(int i = 0; i<terms.size(); i++){
                writer.write(terms.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
