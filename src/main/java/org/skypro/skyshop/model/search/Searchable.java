package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    String searchTerm();

    String getSearchContentType();

    String searchName();

    UUID getId();

    default void getStringRepresentation() {
        System.out.println("Имя - " + this.searchName() + " , тип объекта - " + this.getSearchContentType());
    }

    default int compareTo(Searchable o2){
        return this.searchName().compareTo(o2.searchName());
    }
}
