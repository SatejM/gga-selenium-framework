package com.ggasoftware.uitest.control.base.pairs;

import com.ggasoftware.uitest.utils.linqInterfaces.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.ggasoftware.uitest.utils.LinqUtils.*;
import static com.ggasoftware.uitest.utils.PrintUtils.print;

/**
 * Created by 12345 on 30.09.2014.
 */
public class Pairs<TValue1, TValue2> extends ArrayList<Pair<TValue1, TValue2>> {
    public Pairs() { }

    public Pairs(List<Pair<TValue1, TValue2>> pairs)
    {
        if (pairs == null) return;
        for (Pair<TValue1, TValue2> element : pairs)
            this.add(element);
    }

    public Pairs(TValue1 value1, TValue2 value2, Collection<Pair<TValue1, TValue2>> pairs)
    {
        if (pairs != null)
            for (Pair<TValue1, TValue2> element : pairs)
                this.add(element);
        add(value1, value2);
    }

    public Pairs<TValue1, TValue2> add(TValue1 value1, TValue2 value2) { this.add(new Pair(value1, value2)); return this;}
    public Pairs<TValue1, TValue2> add(Pairs<TValue1, TValue2> pairs) throws Exception { pairs.foreach(this::add); return this; }

    public void addNew(TValue1 value1, TValue2 value2) {
        clear();
        add(new Pair(value1, value2));
    }


    public void foreach(JActionT<Pair<TValue1, TValue2>> action) throws Exception {
        for (Pair<TValue1, TValue2> element : this)
            action.invoke(element);
    }


    public static <T, TValue1, TValue2> Pairs<TValue1, TValue2> toPairs(Iterable<T> list, JFuncTT<T, TValue1> selectorValue1, JFuncTT<T, TValue2> selectorValue2) throws Exception {
        Pairs<TValue1, TValue2> Pairs = new Pairs<>();
        for (T element : list)
            Pairs.add(selectorValue1.invoke(element), selectorValue2.invoke(element));
        return Pairs;
    }

    public Pairs<TValue1, TValue2> subList(int from) {
        return new Pairs<>(subList(from, size()));
    }

    @Override
    public String toString() {
        return print(select(this, pair -> pair.key + ":" + pair.value));
    }

    @Override
    public Pairs<TValue1, TValue2> clone() {
        return new Pairs<>(this);
    }
    public Pairs<TValue1, TValue2> copy() { return clone(); }
}