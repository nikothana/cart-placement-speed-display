package cartdisplay.net;

public class StatsData {
    public int totalCombos = 0;
    public int sessionCombos = 0;
    public long fastestFrames = Long.MAX_VALUE;
    public long slowestFrames = 0;
    public long totalFramesSum = 0;
    public int subTenCombos = 0;

    public void recordCombo(long frames) {
        totalCombos++;
        sessionCombos++;
        totalFramesSum += frames;

        if (frames < fastestFrames) {
            fastestFrames = frames;
        }
        if (frames > slowestFrames) {
            slowestFrames = frames;
        }
        if (frames <= 10) {
            subTenCombos++;
        }
    }

    public double getAverageFrames() {
        if (totalCombos == 0) return 0.0;
        return (double) totalFramesSum / totalCombos;
    }

    public void reset() {
        totalCombos = 0;
        sessionCombos = 0;
        fastestFrames = Long.MAX_VALUE;
        slowestFrames = 0;
        totalFramesSum = 0;
        subTenCombos = 0;
    }
}