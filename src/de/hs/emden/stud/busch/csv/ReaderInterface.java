package de.hs.emden.stud.busch.csv;

/**
 * Interface to read data file.
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public interface ReaderInterface {
    /**
     * Get the values of data file as multidimensional String array
     *
     * @return      content of input file as multidimensional array
     */
    public String[][] get();
}
