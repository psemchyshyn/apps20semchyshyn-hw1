import ua.edu.ucu.tempseries.TempSummaryStatistics;
import ua.edu.ucu.tempseries.TemperatureSeriesAnalysis;

public class Main {
    public static void main(String[] args) {
        double series[] = {-1.0};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(series);


        analysis.addTemps(7.0, 8.0, 2.0);
        TempSummaryStatistics statistics = analysis.summaryStatistics();
        System.out.println(statistics);
    }

}
