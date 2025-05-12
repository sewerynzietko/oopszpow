public class DeathCauseStatistic {
    private String icdCode;
    private int[] numOfDeathInGroup;//20

    public static DeathCauseStatistic fromCsvLine(String line){
        String lineWhiteCharLess = line.replace(" ","");
        String[] lineParts = lineWhiteCharLess.split(",");
        String icdCode = lineParts[0];
        int[] numOfDeathInGroup = new int[lineParts.length - 2];
        for(int i = 2; i < lineParts.length; i++) {
            if(lineParts[i].equals("-"))
                numOfDeathInGroup[i-2] = 0;
            else
                numOfDeathInGroup[i-2] = Integer.parseInt(lineParts[i]);
        }
        return new DeathCauseStatistic(icdCode, numOfDeathInGroup);
    }

    public DeathCauseStatistic(String icdCode, int[] numOfDeathInGroup) {
        this.icdCode = icdCode;
        this.numOfDeathInGroup = numOfDeathInGroup;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public class AgeBracketDeaths{
        int young, old, deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
    }

    public AgeBracketDeaths getAgeBracketDeaths(int age){
        int group = age/5;
        return new AgeBracketDeaths(group*5,group*5+4,numOfDeathInGroup[group]);
    }
}
