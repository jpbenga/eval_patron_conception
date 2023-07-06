package fr.humanbooster.jpb.iterator;

import fr.humanbooster.jpb.business.Poney;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionDePoneys implements Iterator<Poney> {

    private List<Poney> poneys = new ArrayList<>();
    private int offset = 0;

    public CollectionDePoneys(List<Poney> poneys) {
        this.poneys = poneys;
    }

    @Override
    public boolean hasNext() {
        return offset < poneys.size();
    }

    @Override
    public Poney next() {
        return poneys.get(offset++);
    }

    @Override
    public void remove() {
        if (offset > 0 && offset <= poneys.size()) {
            poneys.remove(offset - 1);
            offset--;
        } else {
            throw new IllegalStateException("No element to remove.");
        }
    }

    public int size() {
        return poneys.size();
    }

    public Poney getPoney(int index) {
        return poneys.get(index);
    }
}
