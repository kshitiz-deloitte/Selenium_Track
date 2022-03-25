package MiniAssignment4;

import java.io.*;

public class FileHandler {
    String[] data;

    FileHandler(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileReader fr = new FileReader(file);

        try (BufferedReader br = new BufferedReader(fr)) {
            String DELIMITER = ",";
            String line;
            while ((line = br.readLine()) != null) {

                this.data =  line.split(DELIMITER);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
