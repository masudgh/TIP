package com.llstq;

import java.util.Comparator;

public class HashDemo  implements Comparator {
    private long id;
    private String name;
    private String email;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (email == null ? 0 : email.hashCode());
        return hash;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        HashDemo user = (HashDemo) obj;
        return id == user.id
                && (name.equals(user.name)
                && email.equals(user.email));
    }

}
