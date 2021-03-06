package coetzee.findn.findn;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindersTest {
    private static final long TARGET_VALUE = 7363094l;
    private static Problem prob;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        prob =  (n) ->{return (long)Math.pow(n, 2) + 5*n + 18;};
    }

    @Test
    public void testDumbFinder () {
        DumbFinder finder = new DumbFinder();
        finder.setProblem( prob);
        final long startTime = System.currentTimeMillis();
        long n = finder.findN(0l, 10000, TARGET_VALUE);
        
        log.debug("DumbFinder Found n at {}, after {}ms", n, System.currentTimeMillis() - startTime);
        assertEquals(TARGET_VALUE, prob.calc(n));
    }
    
    @Test
    public void testDiv2Finder () {
        Div2Finder finder = new Div2Finder();
        finder.setProblem( prob);
        final long startTime = System.currentTimeMillis();
        long n = finder.findN(0l, 10000, TARGET_VALUE);       
        
        log.debug("Div2Finder Found n at {} after {}ms", n, System.currentTimeMillis() - startTime);
        
        assertEquals(TARGET_VALUE, prob.calc(n));
    }
    

}
