package be.ebbewertz.pygitnodes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileIOManager {

    public final static String pyGitNodeFilesRootDir = "PyGitNodesProjectData";
    public final static String pythonScriptsDir = pyGitNodeFilesRootDir + "\\scripts";
    public final static String nodeDataJsonsDir = pyGitNodeFilesRootDir + "\\nodesData";

    public static void writeJson(PyGitNode pyGitNode) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String filePath = nodeDataJsonsDir + "\\" + pyGitNode.pythonScriptName + ".json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(pyGitNode, writer);
        } catch (IOException e) {
            System.out.println("Could not write json file: " + filePath);
        }
    }

    public static void writePythonTemplate(PyGitNode pyGitNode){
        String filePath = pythonScriptsDir + "\\" + pyGitNode.pythonScriptName + ".py";

        try (FileWriter writer = new FileWriter(filePath)) {
            //write comments:
            writer.write("\"\"\"\n");
            writer.write("   * ============================\n");
            writer.write("   * "+pyGitNode.displayName+"\n");
            writer.write("   * ============================\n");
            writer.write("   *\n");
            writer.write("   * IN: \n");
            int i = 1;
            for(String input : pyGitNode.inputs){
                writer.write("   *   - "+input+" " + i + ":  \n");
                i++;
            }
            if(i==1){
                writer.write("   *   (None)\n");
            }
            writer.write("   *\n");
            writer.write("   * OUT: \n");
            i = 1;
            for(String output : pyGitNode.outputs){
                writer.write("   *   - "+output+" " + i + ":  \n");
                i++;
            }
            if(i==1){
                writer.write("   *   (None)\n");
            }
            writer.write("\"\"\"\n\n");
            //write function skeleton:
            writer.write("def "+pyGitNode.pythonFunctionName+"(");
            i=1;
            for(String input : pyGitNode.inputs){
                writer.write(input.replace(" ", "_"));
                if(i < pyGitNode.inputs.size()){
                    writer.write(", ");
                }
                i++;
            }
            writer.write("):\n");
            writer.write("\t\n\t# implementation\n\t\n");
            writer.write("\treturn ");
            i=1;
            for(String output : pyGitNode.outputs){
                writer.write(output.replace(" ", "_"));
                if(i < pyGitNode.inputs.size()){
                    writer.write(", ");
                }
                i++;
            }
            if(i==1){
                writer.write("None");
            }
        } catch (IOException e) {
            System.out.println("Could not write python file: " + filePath);
        }
    }

    public static PyGitNode readJson(String path){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path)) {
            return gson.fromJson(reader, PyGitNode.class);
        } catch (IOException e) {
            System.out.println("Could not read json file "+path);
        }
        return null;
    }
}
