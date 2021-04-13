package it.unibo.oop.lab.nesting2;

import java.util.ArrayList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

    final List<T> list;

    public OneListAcceptable(final List<T> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public Acceptor<T> acceptor() {
        return new Acceptor<T>() {

            @Override
            public void accept(T newElement) throws ElementNotAcceptedException {
                if (list.contains(newElement)) {
                    list.remove(newElement);
                } else {
                    throw new ElementNotAcceptedException(newElement);
                }
            }

            @Override
            public void end() throws EndNotAcceptedException {
                if (!list.isEmpty()) {
                    throw new EndNotAcceptedException();
                }
            }
        };
    }

}
