package de.hs.emden.stud.busch.knn;

import de.hs.emden.stud.busch.knn.dataset.DataSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Data store for knn datasets.
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public class DataStore implements Iterator<DataSet> {
    /**
     * datasets in store
     */
    protected ArrayList<DataSet> values = new ArrayList<DataSet>();

    /**
     * Current cursor position
     */
    private int cursor = 0;

    /**
     * Add a dataset to store.
     *
     * @param dataSet Dataset to add
     * @return
     */
    public DataSet add(DataSet dataSet) {
        this.values.add(dataSet);

        return dataSet;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < values.size();
    }

    @Override
    public DataSet next() {
        if (this.hasNext()) {
            DataSet current = values.get(cursor);
            cursor++;
            return current;
        }

        return null;
    }

    /**
     * Sort datasets
     */
    public void sort() {
        Collections.sort(values);
    }

    /**
     * Get a sublist of the datasets
     *
     * @return
     */
    public List<DataSet> getSubList() {
        return getSubList(5);
    }

    /**
     * Get a sublist of the datasets
     *
     * @return
     */
    public List<DataSet> getSubList(int count) {
        return values.subList(0, count);
    }
}
