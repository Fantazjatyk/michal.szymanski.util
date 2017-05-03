/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michal.szymanski.util.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class ClassGroupingMap implements ClassGroupableMap {

    private Map<Class, Collection<Object>> core = new HashMap();

    @Override
    public Collection getGroup(Class c) {
        Collection grp = core.get(c);
        if (grp == null) {
            return new ArrayList();
        }
        return grp;

    }

    @Override
    public boolean constainsGroup(Class c) {
        return core.containsKey(c);
    }

    @Override
    public void removeGroup(Class c) {
        core.remove(c);
    }

    @Override
    public int groupSize(Class c) {
        return core.getOrDefault(c, new ArrayList()).size();
    }

    @Override
    public int totalSize() {
        return core.values().stream().mapToInt((el) -> el.size()).sum();
    }

    @Override
    public void put(Object o) {
        if (o == null) {
            return;
        }
        Class objectClass = o.getClass();
        if (!core.containsKey(objectClass)) {
            createNewGroup(objectClass);
        }
        Collection group = core.get(objectClass);
        group.add(o);
        core.replace(objectClass, group);
    }

    private void createNewGroup(Class c) {
        core.put(c, new ArrayList());
    }

    @Override
    public void clear() {
        core.clear();
    }

    @Override
    public boolean isEmpty() {
        return core.values().stream().filter((el) -> !el.isEmpty()).count() == 0;
    }

    @Override
    public Optional getAnyOf(Class c) {
        if (core.containsKey(c)) {
            return core.get(c).stream().findAny();
        }
        return Optional.empty();
    }

    @Override
    public Map toMap() {
        return core;
    }

    @Override
    public Collection toCollection() {
        return getMergedGroup(this.core.keySet().stream().toArray((el) -> new Class[el]));
    }

    @Override
    public boolean contains(Object o) {
        Class objectClass = o.getClass();
        return core.containsKey(objectClass) && core.get(objectClass).contains(o);

    }

    @Override
    public void remove(Object c) {
        Class objectClass = c.getClass();
        this.getGroup(objectClass).remove(c);
    }

    @Override
    public void putAll(Collection c) {
        c.forEach((el) -> this.put(el));
    }

    @Override
    public Collection getMergedGroup(Class... classes) {
        Collection merged = new ArrayList();

        for (Class c : classes) {
            Collection grp = this.getGroup(c);
            if (!grp.isEmpty()) {
                merged.addAll(grp);
            }

        }
        return merged;
    }

    @Override
    public Collection getMergedGroup(Collection<Class> c) {
        Collection merged = new ArrayList();

        c.forEach((el) -> {
            Collection grp = this.getGroup(el);
            if (!grp.isEmpty()) {
                merged.addAll(grp);
            }
        });
        return merged;
    }

}
