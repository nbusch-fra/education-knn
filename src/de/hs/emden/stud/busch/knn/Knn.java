package de.hs.emden.stud.busch.knn;

import de.hs.emden.stud.busch.knn.dataset.DataSet;

import java.util.List;

/**
 * Class for calculating KNN for various files.
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public abstract class Knn implements KnnInterface {
    /**
     * Data store with rows
     */
    DataStore store = new DataStore();

    /**
     * Parse data file and caculate distances to given user data
     *
     * @return  sublist with ascending sorted distances
     */
    public List<DataSet> parse() {
        String[][] values = getRowsFromFile();

        for (String[] value : values) {
            this.addRowToStore(value);
        }

        calculateDistances(store);

        store.sort();

        return store.getSubList();
    }

    /**
     * Calculate distance between Dataset and user values
     *
     * @param value Dataset to calculate distance to
     */
    protected abstract void calculateDistance(DataSet value);

    /**
     * Get data store
     * @return  data store object
     */
    protected DataStore getDateStore() {
        return store;
    }

    /**
     * Calculate all distances
     *
     * @param store    store to calculate all distances for
     */
    protected void calculateDistances(DataStore store) {
        DataSet val;
        while ((val = store.next()) != null) {
            this.calculateDistance(val);
        }
    }

    /**
     * Caulculate Xi
     *
     * @param xi0   xi0
     * @param xi1   xi1
     * @return      (xi0 - xi1) ^2
     */
    protected double calculateXi(double xi0, double xi1) {
        return Math.pow(xi0 - xi1, 2.0);
    }

    /**
     * Get all rows from file.
     *
     * @return  rows as multidimensional array
     */
    protected abstract String[][] getRowsFromFile();

    /**
     * Add row to Data store as Dataset.
     *
     * @param row   Row values
     * @return
     */
    protected abstract DataSet addRowToStore(String[] row);
}
