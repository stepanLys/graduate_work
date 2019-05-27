<template>
  <div class="container">
    <h2>Book list</h2>
    <BookForm :books="books" :bookAttr="book" :authors="authors"/>

    <div class>
      <table class="table table-striped col-12">
        <thead>
          <tr>
            <th scope="col" style>#</th>
            <th scope="col" style>Title</th>
            <th scope="col" style>Description</th>
            <th scope="col" style>Price</th>
            <th scope="col" style>Genres</th>
            <th scope="col" style>Author</th>
            <th scope="col" style>Operation</th>
          </tr>
        </thead>
        <tbody>
          <BookRow
            v-for="book in books"
            :key="book.id"
            :book="book"
            :books="books"
            :editBook="editBook"
            :deleteBook="deleteBook"
          />
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import BookRow from "components/book/BookRow.vue";
import BookForm from 'components/book/BookForm.vue';
import axios from "axios";

export default {
  props: ["authors"],
  components: {
    BookRow,
    BookForm
  },
  data() {
    return {
      book: null,
      books: []
    };
  },
  methods: {
    editBook(book) {
      this.book = book;
    },
    deleteBook(book) {
      this.$resource("/book{/id}")
        .remove({ id: book.id })
        .then(result => {
          if (result.ok) {
            this.books.splice(this.books.indexOf(book), 1);
          }
        });
    }
  },

  created: function() {
    axios
      .get("/book")
      .then(response => {
        this.books = response.data;
      })
      .catch(error => console.log(error));
  }
};
</script>

