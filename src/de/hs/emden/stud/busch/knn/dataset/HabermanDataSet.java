package de.hs.emden.stud.busch.knn.dataset;

/**
 * Dataset for haberman data.
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public class HabermanDataSet extends DataSet {

    /**
     * the age at operation
     */
    protected int ageAtOperation;

    /**
     * the operation year
     */
    protected int operationYear;

    /**
     * num of positive axillary
     */
    protected int numPositiveAxillary;

    /**
     * Survival Status
     */
    protected int survivalStatus;

    /**
     * Constructor
     *
     * @// TODO: 22.06.16 Check array boundaries and types
     * @param values    Array with row values from haberman data file
     */
    public HabermanDataSet(String[] values) {
        this.ageAtOperation = Integer.parseInt(values[0]);
        this.operationYear = Integer.parseInt(values[1]);
        this.numPositiveAxillary = Integer.parseInt(values[2]);
        this.survivalStatus = Integer.parseInt(values[3]);
    }

    /**
     * Get the age at operation
     *
     * @return  age
     */
    public int getAgeAtOperation() {
        return ageAtOperation;
    }

    /**
     * Get operation year
     *
     * @return  year
     */
    public int getOperationYear() {
        return operationYear;
    }

    /**
     * Get num of positive axillary
     *
     * @return num
     */
    public int getNumPositiveAxillary() {
        return numPositiveAxillary;
    }

    /**
     * Get survival status.
     *
     * @return survival status.
     */
    public int getSurvivalStatus() {
        return survivalStatus;
    }
}
