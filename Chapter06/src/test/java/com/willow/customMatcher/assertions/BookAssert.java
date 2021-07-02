package com.willow.customMatcher.assertions;

import com.willow.customMatcher.Book;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BookAssert extends AbstractAssert<BookAssert, Book> {
   public BookAssert(Book actual){
       super(actual, BookAssert.class);
   }

   public static BookAssert assertThat(Book actual){
       return new BookAssert(actual);
   }

   public BookAssert hasTitle(String title){
       isNotNull();

       return this;
   }
}
