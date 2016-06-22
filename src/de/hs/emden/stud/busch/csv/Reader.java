package de.hs.emden.stud.busch.csv;

import com.Ostermiller.util.CSVParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Abstract reader class for reading data files from https://archive.ics.uci.edu/ml/datasets
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public abstract class Reader implements ReaderInterface {
    /**
     * Get the values of data file as multidimensional String array
     *
     * @param inputStream  input stream of file to read from
     * @return      content of input file as multidimensional array
     */
    protected String[][] get(InputStream inputStream) {
        // Parse the data
        String[][] values = new String[0][];
        try {
            // parse given csv file
            values = CSVParser.parse(
                    new BufferedReader(new InputStreamReader(inputStream))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }


        return values;
    }
}
