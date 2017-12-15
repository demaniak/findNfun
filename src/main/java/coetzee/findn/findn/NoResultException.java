package coetzee.findn.findn;

/**
 * 
 * Raised when the finder decides a solution is impossible.
 * 
 *
 */
public class NoResultException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 2436179990970767232L;

    public NoResultException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public NoResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public NoResultException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public NoResultException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public NoResultException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
