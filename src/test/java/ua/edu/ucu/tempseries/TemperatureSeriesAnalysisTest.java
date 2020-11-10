package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TemperatureSeriesAnalysisTest {

    private double[] temperatureSeries1;
    private double[] temperatureSeriesEmpty;
    private double[] temperatureSeriesMany;
    private double additionalTemp1;
    private double additionalTemp2;
    private double additionalTemp3;

    private double tempValue;

    @Before
    public void init(){
        temperatureSeries1 = new double[] {-1.0};
        temperatureSeriesEmpty = new double[] {};
        temperatureSeriesMany = new double[] {3.0, -5.0, 1.0, 5.0};
        tempValue = 3.7;
        additionalTemp1 = 7.0;
        additionalTemp2 = 8.0;
        additionalTemp3 =2.0;
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries1);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries1);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult = 3.741657;
        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries1);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries1);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindClosesToValtWithOneElementArray() {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries1);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindClosesToValWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        seriesAnalysis.findTempClosestToValue(tempValue);
    }

    @Test
    public void testFindClosesToVal() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult = 3.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindClosesToZero() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindLessThenWithOneElementArray() {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries1);
        double expResult[] = {-1.0};
        double actualResult[] = seriesAnalysis.findTempsLessThen(tempValue);
        for (int i = 0; i < expResult.length; i++){
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }

    @Test
    public void testFindLessThenWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        double expResult[] = {};
        double actualResult[] = seriesAnalysis.findTempsLessThen(tempValue);
        for (int i = 0; i < expResult.length; i++){
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }

    @Test
    public void testFindLessThen() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult[] = {3.0, -5.0, 1.0};
        double actualResult[] = seriesAnalysis.findTempsLessThen(tempValue);
        for (int i = 0; i < expResult.length; i++){
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }

    @Test
    public void testFindGreaterThen() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        double expResult[] = {5.0};
        double actualResult[] = seriesAnalysis.findTempsGreaterThen(tempValue);
        for (int i = 0; i < expResult.length; i++) {
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }

    @Test
    public void testAddTempsWithEmptyArray(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        seriesAnalysis.addTemps(additionalTemp1, additionalTemp2, additionalTemp3);
        double expAv = 5.666667;
        double expDev = 2.624669;
        double expMax = 8.0;
        double expMin = 2.0;
        TempSummaryStatistics after = seriesAnalysis.summaryStatistics();

        assertEquals(expAv, after.getAvgTemp(), 0.00001);
        assertEquals(expDev, after.getDevTemp(), 0.00001);
        assertEquals(expMax, after.getMaxTemp(), 0.00001);
        assertEquals(expMin, after.getMinTemp(), 0.00001);
    }


    @Test
    public void testAddTempsWithOneElementArray(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries1);
//        Average - 4.000000; Deviation - 3.674235; Min - -1.000000; Max - 8.000000

        seriesAnalysis.addTemps(additionalTemp1, additionalTemp2, additionalTemp3);
        double expAv = 4.0;
        double expDev = 3.674235;
        double expMax = 8.0;
        double expMin = -1.0;
        TempSummaryStatistics after = seriesAnalysis.summaryStatistics();
        assertEquals(expAv, after.getAvgTemp(), 0.00001);
        assertEquals(expDev, after.getDevTemp(), 0.00001);
        assertEquals(expMax, after.getMaxTemp(), 0.00001);
        assertEquals(expMin, after.getMinTemp(), 0.00001);
    }

    @Test
    public void testAddTemps(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeriesMany);
        seriesAnalysis.addTemps(additionalTemp1, additionalTemp2, additionalTemp3);
        double expAv = 3.0;
        double expDev = 4.035556;
        double expMax = 8.0;
        double expMin = -5.0;
        TempSummaryStatistics after = seriesAnalysis.summaryStatistics();

        assertEquals(expAv, after.getAvgTemp(), 0.00001);
        assertEquals(expDev, after.getDevTemp(), 0.00001);
        assertEquals(expMax, after.getMaxTemp(), 0.00001);
        assertEquals(expMin, after.getMinTemp(), 0.00001);
    }
}
