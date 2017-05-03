/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.util.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public interface ClassGroupableMap {

    Collection getGroup(Class c);

    Collection getMergedGroup(Class... classes);

    Collection getMergedGroup(Collection<Class> c);

    boolean constainsGroup(Class c);

    void removeGroup(Class c);

    void remove(Object c);

    int groupSize(Class c);

    int totalSize();

    void put(Object o);

    void putAll(Collection c);

    boolean contains(Object o);

    void clear();

    boolean isEmpty();

    Optional<Object> getAnyOf(Class c);

    Map toMap();

    Collection toCollection();
}
