package de.hs.emden.stud.busch.knn;

import de.hs.emden.stud.busch.csv.HabermanReader;
import de.hs.emden.stud.busch.csv.ReaderInterface;
import de.hs.emden.stud.busch.knn.dataset.DataSet;
import de.hs.emden.stud.busch.knn.dataset.HabermanDataSet;

import java.util.List;

/**
 * Class for caculating KNN for given values and haberman data file
 *
 * @author Nico Busch (nbusch@technik-emden.de)
 */
public class Haberman extends Knn {
    /**
     * Given age at operation by user
     */
    protected double ageAtOperation;

    /**
     * Given operation year by user.
     */
    protected double operationYear;

    /**
     * Given value of user for num positive axillary.
     */
    protected double numPositiveAxillary;

    /**
     * Parse haberman data file and caculate distances to given user data
     *
     * @param ageAtOperation        age at operation given by user to compare with
     * @param operationYear         operation year given by user to compare with
     * @param numPositiveAxillary   num positive axillary given by user to compare with
     *
     * @return  sublist with ascending sorted distances
     */
    public List<DataSet> parse(int ageAtOperation, int operationYear, int numPositiveAxillary) {
        this.ageAtOperation = ageAtOperation;
        this.operationYear = operationYear;
        this.numPositiveAxillary = numPositiveAxillary;

        return super.parse();
    }

    @Override
    protected void calculateDistance(DataSet value) {
        value.setDistance(Math.sqrt(
            calculateXi(((HabermanDataSet)value).getAgeAtOperation(), this.ageAtOperation) +
            calculateXi(((HabermanDataSet)value).getOperationYear(), this.operationYear) +
            calculateXi(((HabermanDataSet)value).getNumPositiveAxillary(), this.numPositiveAxillary)
        ));
    }

    @Override
    protected String[][] getRowsFromFile() {
        ReaderInterface csvReader = new HabermanReader();
        return csvReader.get();
    }

    @Override
    protected DataSet addRowToStore(String[] row) {
        return this.getDateStore().add(new HabermanDataSet(row));
    }
}
