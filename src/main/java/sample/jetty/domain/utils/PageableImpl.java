package sample.jetty.domain.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Created by mik on 09.12.14.
 */
public class PageableImpl implements Pageable {

    int pageNumber = 0;
    int pageSize = 10;
    int offset = 0;
    Sort sort = null;
    Pageable next = null;
    Pageable previousOrFirst = null;
    Pageable first = null;
    boolean hasPrevious = false;

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Pageable next() {
        return next;
    }

    public void setNext(Pageable next) {
        this.next = next;
    }

    public Pageable previousOrFirst() {
        return previousOrFirst;
    }

    public void setPreviousOrFirst(Pageable previousOrFirst) {
        this.previousOrFirst = previousOrFirst;
    }

    public Pageable first() {
        return first;
    }

    public void setFirst(Pageable first) {
        this.first = first;
    }

    public boolean hasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }
}
