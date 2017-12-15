package coetzee.findn.findn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * 
 * Main entry point.
 *
 */
@SpringBootApplication
@ShellComponent
public class FindNApplication {
    
    private FindN finder;

	public static void main(String[] args) {
		SpringApplication.run(FindNApplication.class, args);
	}

	@Autowired
    public void setFinder(FindN finder) {
        this.finder = finder;
    }
	
	@ShellMethod("Finds n for n^2 + 5n + 18, where n is integer between 0 and 10000")
	public long find (@ShellOption (defaultValue="0") long lowerBound,@ShellOption(defaultValue="10000") long higherBound, @ShellOption(defaultValue="7363094") long target) {
	    return finder.findN(lowerBound, higherBound, target);
	    
	}
	
	@Bean
	public Problem problem () {
	    return (n) ->  (long)Math.pow(n, 2) + 5*n + 18;
	}
}
