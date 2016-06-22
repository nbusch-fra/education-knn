package de.hs.emden.stud.busch;

import de.hs.emden.stud.busch.knn.Haberman;
import de.hs.emden.stud.busch.knn.Iris;
import de.hs.emden.stud.busch.knn.dataset.DataSet;
import de.hs.emden.stud.busch.knn.dataset.HabermanDataSet;
import de.hs.emden.stud.busch.knn.dataset.IrisDataSet;
import org.apache.commons.cli.*;

import java.util.List;

/**
 * Simple tool for calculating KNN for iris or haberman data.
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public class Main {

    /**
     * Class name for help message
     */
    private static final String KLASSEN_NAME = "de.hs.emden.stud.busch.Main";

    /**
     * main method as starting point to show help and menu
     *
     * @param args  user input
     */
    public static void main(String[] args) {
        CommandLine lvCmd = null;
        HelpFormatter helpFormatter = new HelpFormatter();
        Options lvOptions = new Options();

        Option lvHilfe = new Option("h", "hilfe", false, "zeigt diese Hilfe an.");

        lvOptions.addOption(lvHilfe);

        lvOptions.addOption(Option.builder("d")
                .longOpt("data")
                .desc("Machine Learning data to use. Possible values: iris, haberman")
                .required()
                .argName("d")
                .hasArg(true)
                .valueSeparator('=')
                .build());

        try {
            lvCmd = new DefaultParser().parse(lvOptions, args, true);

            // if no parameters were given or help should be displayed
            if (lvCmd.hasOption('h') || lvCmd.getOptions().length == 0) {
                helpFormatter.printHelp(KLASSEN_NAME, lvOptions);
                return;
            }
            else if (lvCmd.hasOption("data") && lvCmd.getOptionValue("data").equals("iris")) {
                // if the user wants to use the iris data

                Options irisCliOptions = getIrisCliOptions();

                try {
                    lvCmd = new DefaultParser().parse(irisCliOptions, args, false);

                    Iris iris = new Iris();
                    List<DataSet> result = iris.parse(
                            Double.parseDouble(lvCmd.getOptionValue("sl")),
                            Double.parseDouble(lvCmd.getOptionValue("sw")),
                            Double.parseDouble(lvCmd.getOptionValue("pl")),
                            Double.parseDouble(lvCmd.getOptionValue("pw"))
                    );

                    System.out.println("Die Gattungen der 5 ähnlichsten Lilien lauten:");
                    for (DataSet val : result) {
                        System.out.println(((IrisDataSet) val).getIrisClass());
                    }
                } catch (ParseException e) {
                    // print a meaningful error message here
                    helpFormatter.printHelp(KLASSEN_NAME, irisCliOptions);
                    System.out.println(e.getMessage());
                }
            }
            else if (lvCmd.getOptionValue("d").equals("haberman")) {
                // if the user wants to use the haberman data

                Options habermanCliOptions = getHabermanCliOptions();

                try {
                    lvCmd = new DefaultParser().parse(habermanCliOptions, args);

                    Haberman haberman = new Haberman();
                    List<DataSet> result = haberman.parse(
                            Integer.parseInt(lvCmd.getOptionValue("a")),
                            Integer.parseInt(lvCmd.getOptionValue("y")),
                            Integer.parseInt(lvCmd.getOptionValue("ax"))
                    );

                    System.out.println("Überlebensstatus:");
                    for (DataSet val : result) {
                        System.out.println(((HabermanDataSet) val).getSurvivalStatus());
                    }


                } catch (ParseException e) {
                    // print a meaningful error message here
                    helpFormatter.printHelp(KLASSEN_NAME, habermanCliOptions);
                    System.out.println(e.getMessage());
                }

            }

        } catch (ParseException pvException) {
            System.out.println("Parse Fehler:" + pvException.getMessage());
            helpFormatter.printHelp(KLASSEN_NAME, lvOptions);
            return;
        }
    }

    /**
     * Get Console cli options for iris menu.
     *
     * @return  options menu
     */
    protected static Options getIrisCliOptions() {
        Options irisCliOptions = new Options();

        irisCliOptions.addOption(Option.builder("d")
                .longOpt("data")
                .desc("die verwendeten Daten.")
                .required()
                .valueSeparator('=')
                .argName("d")
                .build());
        irisCliOptions.addOption(Option.builder("sl")
                .longOpt("sepallength")
                .desc("Sepal Length")
                .type(Double.class)
                .required(true)
                .argName("sl")
                .hasArg(true)
                .build());
        irisCliOptions.addOption(Option.builder("sw")
                .longOpt("sepalwidth")
                .desc("Sepal Width")
                .type(Double.class)
                .required(true)
                .argName("sw")
                .hasArg(true)
                .build());
        irisCliOptions.addOption(Option.builder("pl")
                .longOpt("petallength")
                .desc("Petal Length")
                .type(Double.class)
                .required(true)
                .argName("pl")
                .hasArg(true)
                .build());
        irisCliOptions.addOption(Option.builder("pw")
                .longOpt("petalwidth")
                .desc("Petal Width")
                .type(Double.class)
                .required(true)
                .argName("pw")
                .hasArg(true)
                .build());

        return irisCliOptions;
    }

    /**
     * Get Console cli options for haberman menu.
     *
     * @return  options menu
     */
    protected static Options getHabermanCliOptions() {
        Options habermanCliOptions = new Options();

        habermanCliOptions.addOption(Option.builder("d")
                .longOpt("data")
                .desc("die verwendeten Daten.")
                .required()
                .valueSeparator('=')
                .argName("d")
                .build());
        habermanCliOptions.addOption(Option.builder("a")
                .longOpt("age")
                .desc("Age of patient at time of operation (numerical)")
                .type(Integer.class)
                .required(true)
                .argName("a")
                .hasArg(true)
                .build());
        habermanCliOptions.addOption(Option.builder("y")
                .longOpt("year")
                .desc("Patient's year of operation (year - 1900, numerical)")
                .type(Integer.class)
                .required(true)
                .argName("y")
                .hasArg(true)
                .build());
        habermanCliOptions.addOption(Option.builder("ax")
                .longOpt("axillary")
                .desc("Number of positive axillary nodes detected (numerical)")
                .type(Integer.class)
                .required(true)
                .argName("ax")
                .hasArg(true)
                .build());

        return habermanCliOptions;
    }
}
