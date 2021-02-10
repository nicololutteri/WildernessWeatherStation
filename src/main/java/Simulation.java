import base.Constant;
import station.FirmwareWeatherStation;
import station.StationManagmentSystem;

import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StationManagmentSystem sms = new StationManagmentSystem(5);

        System.out.println("Station Management System");

        while (true)
        {
            System.out.println("----------------------------------------------------------");
            System.out.println("Le 5 stazioni si chiamano 'Station0', 'Station1', 'Station2', 'Station3', 'Station4'");
            System.out.println("<Command>");
            System.out.println("<Station name> <Command> (Scrivi help per la guida)");
            String line = scanner.nextLine();

            action(line, sms, scanner);
        }
    }

    public static void action(String line, StationManagmentSystem sms, Scanner scanner)
    {
        if (line.trim().contains(" "))
        {
            String[] s = line.trim().split(" ");
            String printline = "";
            try {
                printline = sms.sendCommand(s[0], s[1]);
            }
            catch (RuntimeException ex)
            {
                printline = "Stazione non trovata";
            }
            System.out.println(printline);
        }
        else
        {
            switch (line.toLowerCase().trim())
            {
                case "help":
                    System.out.println(Constant.HelpConsole);
                    break;
                case "helpcommand":
                    System.out.println(Constant.HelpCommand);
                    break;
                case "normal":
                    FirmwareWeatherStation.setWriteLog(true);

                    sms.start();
                    scanner.nextLine();
                    sms.stop();
                    break;
                case "general":
                    String s = sms.generalStatus();
                    System.out.println(s);
                    break;
                default:
                    System.out.println("Comando non riconosciuto");
                    break;
            }
        }
    }

}
