package de.hs.emden.stud.busch.knn.dataset;

/**
 * Dataset for iris data.
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public class IrisDataSet extends DataSet {

    /**
     * sepal length.
     */
    protected double sepalLength;

    /**
     * sepal width.
     */
    protected double sepalWidth;

    /**
     * petal length.
     */
    protected double petalLength;

    /**
     * petal width.
     */
    protected double petalWidth;

    /**
     * iris class.
     */
    protected String irisClass;

    /**
     * Constructor
     *
     * @// TODO: 22.06.16 Check array boundaries and types
     * @param values    Array with row values from iris data file
     */
    public IrisDataSet(String[] values) {
        this.sepalLength = Double.parseDouble(values[0]);
        this.sepalWidth = Double.parseDouble(values[1]);
        this.petalLength = Double.parseDouble(values[2]);
        this.petalWidth = Double.parseDouble(values[3]);
        this.irisClass = values[4];
    }

    /**
     * Get sepal length
     *
     * @return sepal length
     */
    public double getSepalLength() {
        return sepalLength;
    }

    /**
     * Get sepal width
     *
     * @return sepal width
     */
    public double getSepalWidth() {
        return sepalWidth;
    }

    /**
     * Get petal length
     *
     * @return petal length
     */
    public double getPetalLength() {
        return petalLength;
    }

    /**
     * Get petal width
     *
     * @return petal width
     */
    public double getPetalWidth() {
        return petalWidth;
    }

    /**
     * Get Iris class
     *
     * @return iris class
     */
    public String getIrisClass() {
        return irisClass;
    }
}
