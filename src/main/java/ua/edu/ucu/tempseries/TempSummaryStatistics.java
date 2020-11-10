package ua.edu.ucu.tempseries;


public final class TempSummaryStatistics {
    private TemperatureSeriesAnalysis results;
    private double avgTemp;
    private double devTemp;
    private double maxTemp;
    private double minTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis analysis){
        // For immutability we need to make a copy of analysis, because it can be changed externally
        double input[] = new double[analysis.getCurrSize()];
        double tempList[] = analysis.getTempList();
        for (int i = 0; i < analysis.getCurrSize(); i++){
            input[i] = tempList[i];
        }
        results = new TemperatureSeriesAnalysis(input);
        avgTemp = results.average();
        devTemp = results.deviation();
        maxTemp = results.max();
        minTemp = results.min();
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public TemperatureSeriesAnalysis getResults() {
        return new TemperatureSeriesAnalysis(results.getTempList());
    }

    public String toString(){
        return String.format("Average - %f; Deviation - %f; Min - %f; Max - %f\n", getAvgTemp(), getDevTemp(), getMinTemp(), getMaxTemp());
    }
}
