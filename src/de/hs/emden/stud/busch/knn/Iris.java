package de.hs.emden.stud.busch.knn;

import de.hs.emden.stud.busch.csv.IrisReader;
import de.hs.emden.stud.busch.csv.ReaderInterface;
import de.hs.emden.stud.busch.knn.dataset.IrisDataSet;
import de.hs.emden.stud.busch.knn.dataset.DataSet;

import java.util.List;

/**
 * Class for caculating KNN for given values and iris data file
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public class Iris extends Knn {
    /**
     * sepal length given by user input.
     */
    protected double compareSepalLength;

    /**
     * sepal width given by user input.
     */
    protected double compareSepalWidth;

    /**
     * petal length given by user input.
     */
    protected double comparePetalLength;

    /**
     * petal width given by user input.
     */
    protected double comparePetalWidth;

    /**
     * Parse iris data file and caculate distances to given user data
     *
     * @param sepalLength   sepal length given by user
     * @param sepalWidth    sepal width given by user
     * @param petalLength   petal length given by user
     * @param petalWidth    petal width given by user
     *
     * @return  sublist with ascending sorted distances
     */
    public List<DataSet> parse(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        this.compareSepalLength = sepalLength;
        this.compareSepalWidth = sepalWidth;
        this.comparePetalLength = petalLength;
        this.comparePetalWidth = petalWidth;

        return super.parse();
    }

    @Override
    protected void calculateDistance(DataSet value) {
        value.setDistance(Math.sqrt(
                calculateXi(((IrisDataSet)value).getSepalLength(), this.compareSepalLength) +
                calculateXi(((IrisDataSet)value).getSepalWidth(), this.compareSepalWidth) +
                calculateXi(((IrisDataSet)value).getPetalLength(), this.comparePetalLength) +
                calculateXi(((IrisDataSet)value).getPetalWidth(), this.comparePetalWidth)
        ));
    }

    @Override
    protected String[][] getRowsFromFile() {
        ReaderInterface csvReader = new IrisReader();
        return csvReader.get();
    }

    @Override
    protected DataSet addRowToStore(String[] row) {
        return this.getDateStore().add(new IrisDataSet(row));
    }
}
