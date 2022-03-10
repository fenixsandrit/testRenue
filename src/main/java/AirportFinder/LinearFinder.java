package AirportFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearFinder implements IFinder{
    private List<String> lines;
    private List<String> numbers;
    private String symbols = "–\"( - /´ ";
    private String filename;
    public LinearFinder(String filename){
        this.filename = filename;
        List<String> stringList = null;
        lines = new ArrayList<>();
        numbers = new ArrayList<>();
        try {
            stringList = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < stringList.size(); i++) {
            lines.add(stringList.get(i).split(";")[0]);
            numbers.add(stringList.get(i).split(";")[1]);
        }
    }

    @Override
    public String find(String findword) {
        findword = findword.toLowerCase();
        String result;
        switch (filename){
            case "column2.dat": result = findWithSymbols(findword).toString(); break;
            case "column3.dat": result = findWithSymbols(findword).toString(); break;
            case "column4.dat": result = findWithSymbols(findword).toString(); break;
            case "column12.dat": result = findWithSymbols(findword).toString(); break;
            default: result = findWithoutSymbols(findword).toString(); break;
        }
        return result;
    }
    private StringBuilder findWithoutSymbols(String findword){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.size(); i++)
            if(lines.get(i).contains(findword) && lines.get(i).startsWith(findword))
                    result.append(numbers.get(i)).append(',');

        return result;
    }
    private StringBuilder findWithSymbols(String findword){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.size(); i++)
            if(lines.get(i).contains(findword)){
                if(lines.get(i).startsWith(findword)){
                    result.append(numbers.get(i)).append(',');
                }

                else{
                    for (int j = 0; j < symbols.length(); j++) {
                        if(lines.get(i).charAt(lines.get(i).indexOf(findword) - 1) == symbols.charAt(j))
                        {
                            result.append(numbers.get(i)).append(',');
                            break;
                        }
                    }
                }
            }

        return result;
    }

}
