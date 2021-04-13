package it.unibo.oop.lab.nesting2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

    final List<T> list;

    public OneListAcceptable(final List<T> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public Acceptor<T> acceptor() {

        final Iterator<T> listIterate = list.iterator();

        return new Acceptor<T>() {

            @Override
            public void accept(T newElement) throws ElementNotAcceptedException {
                if (!listIterate.hasNext() || !newElement.equals(listIterate.next())) {
                    throw new ElementNotAcceptedException(newElement);
//                    if (!newElement.equals(listIterate.next())) {
//                        throw new ElementNotAcceptedException(newElement);
//                    }
                }
            }

            @Override
            public void end() throws EndNotAcceptedException {
                if (listIterate.hasNext()) {
                    throw new EndNotAcceptedException();
                }
            }
        };
    }

}
