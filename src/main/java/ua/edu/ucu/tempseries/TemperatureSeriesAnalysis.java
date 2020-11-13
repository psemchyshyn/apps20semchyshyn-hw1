package ua.edu.ucu.tempseries;


import java.util.InputMismatchException;


public class TemperatureSeriesAnalysis {
    private static final int ABSOLUTE_ZERO = -273;
    private static final int DEFAULT_SIZE = 10;
    private double[] tempList;
    private int currSize = 0;

    public TemperatureSeriesAnalysis() {
        setDefaultTempList();
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (temperatureSeries.length == 0) {
            setDefaultTempList();
        } else {
            checkIfAbsoluteZeroReached(temperatureSeries);
            tempList = new double[temperatureSeries.length];
            for (int i = 0; i < temperatureSeries.length; i++) {
                tempList[i] = temperatureSeries[i];
                currSize = i + 1;
            }
        }
    }

    private void setDefaultTempList() {
        tempList = new double[DEFAULT_SIZE];
    }

    public void checkIfEmpty() {
        if (currSize == 0) {
            throw new IllegalArgumentException("Temp list is empty");
        }
    }

    public void checkIfAbsoluteZeroReached(double[] arr) {
        // Checks if temp is >= -273C
        for (double temp: arr) {
            if (temp < ABSOLUTE_ZERO) {
                throw new InputMismatchException("Can't"
                        + " be lower than absolute zero");
            }
        }
    }

    public double average() {
        checkIfEmpty();
        double average = 0;
        for (int i = 0; i < currSize; i++) {
            average += tempList[i];
        }
        return average / currSize;
    }

    public double deviation() {
        double average = average();
        double standDev = 0;
        for (int i = 0; i < currSize; i++) {
            standDev += (tempList[i] - average) * (tempList[i] - average);
        }
        return Math.sqrt(standDev / currSize);
    }

    public double min() {
        checkIfEmpty();
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < currSize; i++) {
            if (tempList[i] < min) {
                min = tempList[i];
            }
        }
        return min;
    }

    public double max() {
        checkIfEmpty();
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < currSize; i++) {
            if (tempList[i] > max) {
                max = tempList[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkIfEmpty();
        double minDifference = Double.POSITIVE_INFINITY;
        double temp, currDiff = 0, closest = 0;
        for (int i = 0; i < currSize; i++) {
            temp = tempList[i];
            currDiff = temp - tempValue;
            if (Math.abs(currDiff) < minDifference) {
                minDifference = currDiff;
                closest = temp;
            } else if (Math.abs(currDiff)
                    == minDifference && currDiff > minDifference) {
                minDifference = currDiff;
                closest = temp;
            }
        }
        return closest;
    }

    public int amountOflessThen(double tempValue) {
        int amountOfLess = 0;
        for (int i = 0; i < currSize; i++) {
            if (tempList[i] < tempValue) {
                amountOfLess++;
            }
        }
        return amountOfLess;
    }

    public int amountOfGreaterThen(double tempValue) {
        return currSize - amountOflessThen(tempValue);
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] arr = new double[amountOflessThen(tempValue)];
        int i = 0;
        for (int j = 0; j < currSize; j++) {
            if (tempList[j] < tempValue) {
                  arr[i] = tempList[j];
                  i++;
            }
        }
        return arr;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] arr = new double[amountOfGreaterThen(tempValue)];
        int i = 0;
        for (int j = 0; j < currSize; j++) {
            if (tempList[j] >= tempValue) {
                arr[i] = tempList[j];
                i++;
            }
        }
        return arr;
    }

    public TempSummaryStatistics summaryStatistics() {
        checkIfEmpty();
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        checkIfAbsoluteZeroReached(temps);
        double[] temp;
        // Expanding array if necessary
        while (tempList.length - currSize < temps.length) {
            temp = new double[2*tempList.length];
            for (int i = 0; i < currSize; i++) {
                temp[i] = tempList[i];
            }
            tempList = temp;
        }
        // Adding temps elements
        for (double t: temps) {
            tempList[currSize] = t;
            currSize++;
        }
        return currSize;
    }
}
