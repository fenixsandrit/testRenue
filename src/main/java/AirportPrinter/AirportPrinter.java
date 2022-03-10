package AirportPrinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirportPrinter implements IPrinter{
    private List<String> stringList;
    @Override
    public void print(String lineNumbers) {
        List<String> numbers = new ArrayList<>();
        if(!"".equals(lineNumbers))
            numbers = Arrays.asList(lineNumbers.split(","));

        for (int i = 0; i < numbers.size(); i++)
            System.out.println(stringList.get(Integer.parseInt(numbers.get(i)) - 1));

    }
    public AirportPrinter(){
        try {
            stringList = Files.readAllLines(Paths.get("correctAirPorts.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
