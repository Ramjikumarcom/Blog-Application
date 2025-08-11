package com.springboot.blogproject.Payload;

import java.util.List;

public class PostResponse {
    private List<PostDto> content;
    private  int pageNumber;

    private  int pageSize;
    private int totalElements;
    private int totalPages;
    private  boolean lastPage;

    public PostResponse() {
    }

    public PostResponse(int pageNumber, List<PostDto> content, int pageSize, int totalElements, int totalPages, boolean lastPage) {
        this.pageNumber = pageNumber;
        this.content = content;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.lastPage = lastPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<PostDto> getContent() {
        return content;
    }

    public void setContent(List<PostDto> content) {
        this.content = content;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "pageNumber=" + pageNumber +
                ", content=" + content +
                ", pageSize=" + pageSize +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", lastPage=" + lastPage +
                '}';
    }
}
