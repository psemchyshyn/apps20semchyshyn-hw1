package ua.edu.ucu.tempseries;


public final class TempSummaryStatistics {
    public final double avgTemp;
    public final double devTemp;
    public final double maxTemp;
    public final double minTemp;

    private TempSummaryStatistics() throws Exception {
        throw new Exception("Disable default constructor");
    }

    public TempSummaryStatistics(TemperatureSeriesAnalysis analysis) {
        avgTemp = analysis.average();
        devTemp = analysis.deviation();
        maxTemp = analysis.max();
        minTemp = analysis.min();
    }


    public String toString() {
        return String.format("Average - %f; "
                        + "Deviation - %f; Min - %f; Max - %f%n",
                avgTemp, devTemp, minTemp, maxTemp);
    }
}
