<template>
  <div>
    <author-list :authors="authors"/>
    <GenreList :genres="genres"/>
    <BookList :books="books" :authors="authors"/>
  </div>
</template>

<script>
import AuthorList from "components/author/AuthorList.vue";
import GenreList from "components/genre/GenreList.vue";
import BookList from "components/book/BookList.vue";

export default {
	props: ['authors', 'genres', 'books'],
  components: {
    AuthorList,
    GenreList,
    BookList
  }
};
</script>
