import AirportFinder.IFinder;
import AirportFinder.LinearFinder;
import AirportPrinter.AirportPrinter;
import AirportPrinter.IPrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.List;

public class AirportDispatcher {
    private IFinder airportFinder;
    private IPrinter airportPrinter;

    public AirportDispatcher(){
        isCorrectFiles();
        airportFinder = new LinearFinder("column13.dat");
        airportPrinter = new AirportPrinter();
    }
    public AirportDispatcher(String column){
        if(!isCorrectColumn(column))
            throw new RuntimeException("column is incorrect");
        isCorrectFiles();

        String filename;
        switch (column){
            case "1":filename = "column1.dat";break;
            case "2":filename = "column2.dat";break;
            case "3":filename = "column3.dat";break;
            case "4":filename = "column4.dat";break;
            case "5":filename = "column5.dat";break;
            case "6":filename = "column6.dat";break;
            case "7":filename = "column7.dat";break;
            case "8":filename = "column8.dat";break;
            case "9":filename = "column9.dat";break;
            case "10":filename = "column10.dat";break;
            case "11":filename = "column11.dat";break;
            case "12":filename = "column12.dat";break;
            case "13":filename = "column13.dat";break;
            default:filename = "column14.dat";break;
        }
        airportFinder = new LinearFinder(filename);
        airportPrinter = new AirportPrinter();
    }

    public void execute(String findword){
        String result;
        long time = System.currentTimeMillis();
        result = airportFinder.find(findword);
        time = System.currentTimeMillis()-time;
        airportPrinter.print(result);
        int count = 0;
        if(!"".equals(result))
            count = result.split(",").length;

        System.out.println("size: "+ count + "; time:" + time + "mc" );
    }
    private boolean isCorrectColumn(String column){
        int col = -1;
        try{
            col = Integer.parseInt(column);
        }
        catch (NumberFormatException e){
            return false;
        }

        if( col < 1  || col > 14){
            return false;
        }
        return true;
    }
    private void isCorrectFiles(){
        String[] files = {"column1.dat","column2.dat","column3.dat","column4.dat","column5.dat",
                "column6.dat","column7.dat","column8.dat","column9.dat","column10.dat",
                "column11.dat","column12.dat","column13.dat","column14.dat","correctAirPorts.dat"};
        for (int i = 0; i < files.length ; i++)
            if (!(new File(files[i])).exists())
                throw new RuntimeException("The application needs files to work correctly: column1.dat, ... column14.dat, correctAirPorts.dat, which were previously generated and parsed by the developer");
    }
}
