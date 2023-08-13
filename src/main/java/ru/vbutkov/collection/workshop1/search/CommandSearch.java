package ru.vbutkov.collection.workshop1.search;

public class CommandSearch {
    FilterSearch filterSearch;
    String data;

    public CommandSearch(FilterSearch filterSearch, String data) {
        this.filterSearch = filterSearch;
        this.data = data;
    }

    public CommandSearch(FilterSearch filterSearch) {
        this.filterSearch = filterSearch;
    }

    public FilterSearch getFilterSearch() {
        return filterSearch;
    }

    public String getData() {
        return data;
    }
}
