package oracle.fodemo.storefront.account.view.managed;
/**
 * Marker exception used to prevent further error message handling
 * in a situation where we know the exact cause of the problem
 * and where further walking down the error stack will just cause 
 * message repetition
 * $Id: KnowErrorStopException.java,v 1.4 2006/04/20 12:07:35 steve Exp $.
 */
public class KnowErrorStopException extends Exception {

  /**
   * Constructor.
   * @param knownErrorKey key for known error
   */
  public KnowErrorStopException(String knownErrorKey){
     super(knownErrorKey);
 }
}

