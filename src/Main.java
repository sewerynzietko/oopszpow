public class Main {
    public static void main(String[] args) {
        DeathCauseStatistic one = DeathCauseStatistic.fromCsvLine("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");
        DeathCauseStatistic.AgeBracketDeaths two = one.getAgeBracketDeaths(78);
        System.out.println("endofprogram");
    }
}