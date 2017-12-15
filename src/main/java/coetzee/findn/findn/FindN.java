package coetzee.findn.findn;

/**
 * 
 * Interface for our problem solvers.
 * 
 *
 */
public interface FindN {
    /**
     * 
     * @param lowerBound the lowest bound of values for N
     * @param higherBound the highest bound of values for N
     * @param target the target value (desired result of the calculation)
     * @return the value of N that satisfies the equation
     */
    long findN (long lowerBound, long higherBound, long target);
}
