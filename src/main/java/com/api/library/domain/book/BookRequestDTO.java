package com.api.library.domain.book;

public record BookRequestDTO(String title, String description, String date, int number_page, String isbn ) {
}
