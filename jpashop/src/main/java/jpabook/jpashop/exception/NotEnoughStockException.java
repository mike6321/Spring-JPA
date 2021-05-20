package jpabook.jpashop.exception;

/**
 * Project : jpashop
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:14 오후
 */
public class NotEnoughStockException extends RuntimeException{

    public NotEnoughStockException() {
        super();
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }

}
