package coetzee.findn.findn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Picks the middle of the known values of N, performs calculation, and gets the difference between
 * calculated value and the target. If negative (&lt; 0), we go recursive with the same lower bound, but the higher bound
 * adjusted to the test N value we just used. If positive (&gt; 0), we again go recursive, with the lower bound adjusted 
 * to test N value, and the same higher bound.
 * </p>
 * <p>
 * It might be that we could find a solution faster by using random starting points, or the golden mean or something.
 * But this seems to work well enough within the bounds of the problem!
 * </p>
 *
 */
@Service
@Slf4j
@ConditionalOnProperty(name="spring.application.finder.impl",havingValue="Div2Finder")
public class Div2Finder implements FindN {
    
    private Problem problem;

    @Override
    public long findN(final long lowerBound,final  long higherBound,final  long target) {
        
        if (lowerBound > higherBound) {
            throw new NoResultException("lowerBound crossed higherBound");
        }
        
        if (higherBound <  lowerBound) {
            throw new NoResultException("higherBound crossed lowerBound");
        }
        
        long testN =lowerBound + ( (higherBound - lowerBound) / 2);
        log.trace("Testing N at {}", testN);
        long result = problem.calc(testN);
        long diff = target - result;
        if (diff == 0) {
            return testN;
        }
        
        if (diff < 0) {
            return findN(lowerBound, testN, target);
        }
        
        if (diff > 0) {
            return findN(testN, higherBound, target);
        }
//        if (result )
        // TODO Auto-generated method stub
        return -1;
    }

    @Autowired
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

}
