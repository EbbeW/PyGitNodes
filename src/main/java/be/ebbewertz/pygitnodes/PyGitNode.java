package be.ebbewertz.pygitnodes;

import java.util.ArrayList;

public class PyGitNode {
    public String pythonScriptName; //path to script
    public String pythonFunctionName;  //name to the entry function
    public String displayName;  //name to display in list
    public String shortName;    //short name or abbreviation for node graphical element
    public ArrayList<String> inputs;
    public ArrayList<String> outputs;

    public PyGitNode(String pythonScriptName, String pythonFunctionName, String displayName, String shortName, ArrayList<String> inputs, ArrayList<String> outputs) {
        this.pythonScriptName = pythonScriptName;
        this.pythonFunctionName = pythonFunctionName;
        this.displayName = displayName;
        this.shortName = shortName;
        this.inputs = inputs;
        this.outputs = outputs;
    }
}
