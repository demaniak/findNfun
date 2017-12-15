package coetzee.findn.findn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name="spring.application.finder.impl", havingValue="DumbFinder")
public class DumbFinder implements FindN {
    private Problem problem;

    @Override
    public long findN(long lowerBound, long higherBound, long target) {
        long i = lowerBound;
        while (i <= higherBound) {
            log.trace("Checking value or N at {}",i);
            long result = problem.calc(i);
            if (target == result) {
                log.debug("N found at {}", i);
                return i;
            }
            i++;
        }
        
        return 0;
    }
    
    @Autowired
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

}
