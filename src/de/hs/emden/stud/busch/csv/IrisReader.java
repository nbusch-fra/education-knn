package de.hs.emden.stud.busch.csv;

/**
 * Reader class for importing iris data file into java structure
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public class IrisReader extends Reader {
    @Override
    public String[][] get() {
        return get(this.getClass().getResourceAsStream("/data/iris.data"));
    }
}
