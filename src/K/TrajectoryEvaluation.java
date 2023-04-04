package K;

public class TrajectoryEvaluation implements Comparable<TrajectoryEvaluation> {
    public final Trajectory trajectory;
    public final double evaluation;

    public TrajectoryEvaluation(Trajectory trajectory, double evaluation) {
        this.trajectory = trajectory;
        this.evaluation = evaluation;
    }

    @Override
    public int compareTo(TrajectoryEvaluation other) {
        return Double.compare(this.evaluation, other.evaluation);
    }
}
