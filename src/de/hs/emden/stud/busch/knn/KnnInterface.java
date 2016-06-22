package de.hs.emden.stud.busch.knn;

import de.hs.emden.stud.busch.knn.dataset.DataSet;

import java.util.List;

/**
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public interface KnnInterface {
    /**
     * Parse data file and caculate distances to given user data
     *
     * @return  sublist with ascending sorted distances
     */
    public List<DataSet> parse();
}
