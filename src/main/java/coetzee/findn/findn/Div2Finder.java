package coetzee.findn.findn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

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
