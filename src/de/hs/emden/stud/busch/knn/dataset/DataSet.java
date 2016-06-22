package de.hs.emden.stud.busch.knn.dataset;

/**
 * Abstract class for KNN datasets.
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public abstract class DataSet implements Comparable<DataSet> {

    /**
     * Calculated distance.
     */
    protected double distance;

    /**
     * Get the calculated distance
     *
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Set the calculated distance.
     *
     * @param distance  calculated distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(DataSet val) {
        return (this.getDistance() < val.getDistance() ? -1 : 1);
    }
}
